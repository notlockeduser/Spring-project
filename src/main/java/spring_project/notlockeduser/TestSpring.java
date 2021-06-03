package spring_project.notlockeduser;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        TestBean testBean = context.getBean("testBean", TestBean.class);

        System.out.println("\n\nOutput\n");
        System.out.println(testBean.getName());

        context.close();
    }

}
