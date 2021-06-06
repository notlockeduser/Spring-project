package spring_project.notlockeduser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class User {
    private Map<String, TaxiService> listTaxi = new HashMap<>();

    @Autowired
    public User(@Qualifier("bolt") TaxiService bolt,
                @Qualifier("uber") TaxiService uber) {
        listTaxi.put(bolt.getName(), bolt);
        listTaxi.put(uber.getName(), uber);
    }

    public void callTaxiService(String nameTaxi) {
        System.out.println(listTaxi.get(nameTaxi).getCar());
    }
}
