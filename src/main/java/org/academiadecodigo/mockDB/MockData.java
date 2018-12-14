package org.academiadecodigo.mockDB;

import org.academiadecodigo.model.CulturalChallenge;
import org.academiadecodigo.model.Customer;
import org.academiadecodigo.model.HealthyChallenge;
import org.academiadecodigo.model.SocialChallenge;

import java.util.HashMap;
import java.util.Map;

public class MockData {

    public MockData() {
        populateSocialChallenge();
        populateHealthyChallenge();
        populateCulturalChallenge();
    }

    private static MockData ourInstance = new MockData();
    CulturalChallenge culturalChallenge1 = new CulturalChallenge();
    CulturalChallenge culturalChallenge2 = new CulturalChallenge();

    HealthyChallenge healthyChallenge1 = new HealthyChallenge();
    HealthyChallenge healthyChallenge2 = new HealthyChallenge();


    SocialChallenge socialChallenge1 = new SocialChallenge();
    SocialChallenge socialChallenge2 = new SocialChallenge();


    public static MockData getInstance() {
        return ourInstance;
    }


    private Map<Integer, Customer> customerMap = new HashMap();
    private Map<Integer, CulturalChallenge> culturalChallengeMap = new HashMap<>();
    private Map<Integer, HealthyChallenge> healthyChallengeMap = new HashMap<>();
    private Map<Integer, SocialChallenge> socialChallengeMap = new HashMap<>();

    public Customer addCustomer(Customer customer){
        //since this is a new customer we're giving him challenges here
        customer.setCulturalChallenge(culturalChallengeMap.get(1));
        customer.setHealthyChallenge(healthyChallengeMap.get(1));
        customer.setSocialChallenge(socialChallengeMap.get(1));

        customer.setId(customerMap.keySet().size()+1);
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    public Customer updateCustomer(Customer customer){
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    public CulturalChallenge getCulturalChallenge(Integer id){
        return culturalChallengeMap.get(id);
    }


    public void populateCulturalChallenge() {
        culturalChallenge1.setName("Cultural Challenge #1");
        culturalChallenge1.setDescription("Bohemian Rhapsody");
        culturalChallenge1.setLink("http://cinemas.nos.pt/Filmes/Pages/bohemian-rhapsody.aspx");
        culturalChallengeMap.put(1,culturalChallenge1);

        culturalChallenge2.setName("Cultural Challenge #2");
        culturalChallenge2.setDescription("Fado na Baixa");
        culturalChallenge2.setLink("https://www.bol.pt/Comprar/Bilhetes/67415-meu_unico_fado-fado_na_baixa/");
        culturalChallengeMap.put(2,culturalChallenge2);
    }

    public void populateHealthyChallenge() {
        healthyChallenge1.setName("Healthy Challenge #1");
        healthyChallenge1.setDescription("30 Minute Power Yoga Class");
        healthyChallenge1.setLink("https://www.youtube.com/watch?v=qy_oIKf1ByM");
        healthyChallengeMap.put(1,healthyChallenge1);

        healthyChallenge2.setName("Healthy Challenge #2");
        healthyChallenge2.setDescription("");
        healthyChallenge2.setLink("https://www.youtube.com/watch?v=NNQVM35goK8&index=4&list=RDQMtuhzHNwB5lc");
        healthyChallengeMap.put(2,healthyChallenge2);
    }

    public void populateSocialChallenge() {
        socialChallenge1.setName("Social Challenge #1");
        socialChallenge1.setDescription("Schedule a coffee with your friends.");
        socialChallengeMap.put(1,socialChallenge1);

        socialChallenge2.setName("Social Challenge #2");
        socialChallenge2.setDescription("Call a special person!");
        socialChallengeMap.put(2,socialChallenge2);
    }


    public Map<Integer, Customer> getCustomerMap() {
        return customerMap;
    }

    public void setCustomerMap(Map<Integer, Customer> customerMap) {
        this.customerMap = customerMap;
    }
}
