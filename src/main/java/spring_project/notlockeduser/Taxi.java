package spring_project.notlockeduser;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private List<Vehicle> cars = new ArrayList<>();
    private String name;
    private int cost;

    public Taxi() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setCars(List<Vehicle> cars) {
        this.cars = cars;
    }

    public void getCars() {
        for (Vehicle car : cars) {
            System.out.println(car.getVehicle());
        }
    }
}
