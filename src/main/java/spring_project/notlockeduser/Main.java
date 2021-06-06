package spring_project.notlockeduser;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                Config.class
        );

        User user = context.getBean("user", User.class);

        int choice = (int) (Math.random() * 1);
        String taxiService = (choice == 0) ? "Bolt" : "Uber";
        user.callTaxiService(taxiService);

        context.close();
    }
}
