package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDAO {
    private static int CAR_COUNT;
    private List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car(++CAR_COUNT, "Mercedes", 163));
        carList.add(new Car(++CAR_COUNT, "VW", 4));
        carList.add(new Car(++CAR_COUNT, "Opel", 8));
        carList.add(new Car(++CAR_COUNT, "Lada", 2108));
        carList.add(new Car(++CAR_COUNT, "Kia", 3));
    }

    public List<Car> getCarList(int count) {
        return carList.stream().limit(count).collect(Collectors.toList());
    }

}
