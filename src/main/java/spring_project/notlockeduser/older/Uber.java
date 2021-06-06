//package spring_project.notlockeduser.older;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class Uber implements TaxiService {
//    @Value("${uber.name}")
//    private String name;
//    private List<String> cars = new ArrayList<>();
//
//    public Uber() {
//        cars.add("Volkswagen_Uber");
//        cars.add("BMW_Uber");
//        cars.add("Ford_Uber");
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public String getCar() {
//        return cars.get((int) (Math.random() * 3));
//    }
//}
