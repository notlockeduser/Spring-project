//package spring_project.notlockeduser.older;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class Bolt implements TaxiService {
//    @Value("${bolt.name}")
//    private String name;
//    private List<String> cars = new ArrayList<>();
//
//    public Bolt() {
//        cars.add("Volkswagen_Bolt");
//        cars.add("BMW_Bolt");
//        cars.add("Ford_Bolt");
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
