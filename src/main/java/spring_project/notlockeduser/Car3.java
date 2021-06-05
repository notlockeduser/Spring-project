package spring_project.notlockeduser;

public class Car3 implements Vehicle {
    private Car3() {
    }

    public  static Car3 getCar3 (){
        return new Car3();
    }

    public void init() {
        System.out.println("init");
    }

    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    public String getVehicle() {
        return "Car 3";
    }
}
