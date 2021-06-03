package spring_project.notlockeduser;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Taxi taxi = context.getBean("taxi", Taxi.class);

        taxi.getCars();

        //taxi.setCars();
      //  taxi.getCars();
        //System.out.println(taxi.getCar());
//        System.out.println(taxi.getName());
//        System.out.println(taxi.getCost());

        context.close();
    }

}
