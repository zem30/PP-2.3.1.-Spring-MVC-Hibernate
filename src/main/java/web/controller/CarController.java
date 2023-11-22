package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.DAO.CarDAO;


@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarDAO carDAO;

    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping
    public String show(@RequestParam(name = "count", required = false) Integer count,
                       ModelMap model) {
        if (count == null|| count <=0) {
            model.addAttribute("cars", carDAO.listCar());
        } else {
            model.addAttribute("cars", carDAO.show(count));
        }
        model.addAttribute("message", "Количество машин в запросе - " + count);
        return "/car/cars";
    }
}
