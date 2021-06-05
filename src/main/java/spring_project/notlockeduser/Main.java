package spring_project.notlockeduser;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        User user = context.getBean("user", User.class);

        int choice = (int) (Math.random() * 1);
        String taxiService = (choice == 0) ? "Bolt" : "Uber";
        user.callTaxiService(taxiService);

        context.close();
    }

}
