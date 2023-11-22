package web.DAO;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarDAO {

    private static int CAR_COUNT;
    private List<Car> car;

    {
        car = new ArrayList<>();

        car.add(new Car(++CAR_COUNT,"BMW", 1, "black"));
        car.add(new Car(++CAR_COUNT,"Lada", 2, "white"));
        car.add(new Car(++CAR_COUNT,"Honda", 3, "red"));
        car.add(new Car(++CAR_COUNT,"Ford", 4, "blue"));
        car.add(new Car(++CAR_COUNT,"Cherry", 5, "grey"));
    }

    public List<Car> listCar() {
        return car;
    }

    public List<Car> show(int count){
        return car.stream().limit(count).toList();
    }
}
