package spring_project.notlockeduser;

import org.springframework.stereotype.Component;

public class Car implements Vehicle{
    @Override
    public String getVehicle() {
        return "Car 1";
    }
}
