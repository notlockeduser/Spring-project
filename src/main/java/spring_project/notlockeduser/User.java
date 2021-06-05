package spring_project.notlockeduser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User {
    private TaxiService bolt;
    private TaxiService uber;

    @Autowired
    public User(@Qualifier("bolt") TaxiService bolt,
                @Qualifier("uber") TaxiService uber) {
        this.bolt = bolt;
        this.uber = uber;
    }

    public void callTaxiService(String taxiServiceName) {
        if (taxiServiceName.equals(bolt.getName())) {
            System.out.println(bolt.getCar());
        } else if (taxiServiceName.equals(uber.getName())) {
            System.out.println(bolt.getCar());
        }
    }
}
