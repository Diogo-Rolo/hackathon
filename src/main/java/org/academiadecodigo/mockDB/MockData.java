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
        Customer customer = new Customer();
        customer.setFirstName("Frédi");
        customer.setLastName("Mércure");
        customer.setEmail("fredinho@gmail.com");
        customer.setPassword("123");
        customer.setPhone("919919919");
        addCustomer(customer);
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

    public HealthyChallenge getHealthyChallenge(Integer id){
        return healthyChallengeMap.get(id);
    }

    public SocialChallenge getSocialChallenge(int id) {
        return socialChallengeMap.get(id);
    }


    public void populateCulturalChallenge() {
        culturalChallenge1.setName("Cultural Challenge #1");
        culturalChallenge1.setDescription("Bohemian Rhapsody");
        culturalChallenge1.setLink("https://www.youtube.com/embed/mP0VHJYFOAU");
        culturalChallenge1.setId(1);
        culturalChallengeMap.put(culturalChallenge1.getId(),culturalChallenge1);

        culturalChallenge2.setName("Cultural Challenge #2");
        culturalChallenge2.setDescription("Fado na Baixa");
        culturalChallenge2.setLink("https://www.youtube.com/embed/WIleD7RVD1I");
        culturalChallenge2.setId(2);
        culturalChallengeMap.put(culturalChallenge2.getId(),culturalChallenge2);
    }

    public void populateHealthyChallenge() {
        healthyChallenge1.setName("Healthy Challenge #1");
        healthyChallenge1.setDescription("30 Minute Power Yoga Class");
        healthyChallenge1.setLink("https://www.youtube.com/embed/qy_oIKf1ByM");
        healthyChallenge1.setId(1);
        healthyChallengeMap.put(healthyChallenge1.getId(),healthyChallenge1);

        healthyChallenge2.setName("Healthy Challenge #2");
        healthyChallenge2.setDescription("Cook a nice chicken salad for yourself for a change!");
        healthyChallenge2.setLink("https://www.youtube.com/embed/NNQVM35goK8");
        healthyChallenge2.setId(2);
        healthyChallengeMap.put(healthyChallenge2.getId(),healthyChallenge2);
    }

    public void populateSocialChallenge() {
        socialChallenge1.setName("Social Challenge #1");
        socialChallenge1.setDescription("Schedule a coffee with your friends.");
        socialChallenge1.setId(1);
        socialChallengeMap.put(socialChallenge1.getId(),socialChallenge1);

        socialChallenge2.setName("Social Challenge #2");
        socialChallenge2.setDescription("Call a special person!");
        socialChallenge2.setId(2);
        socialChallengeMap.put(socialChallenge2.getId(),socialChallenge2);
    }


    public Map<Integer, Customer> getCustomerMap() {
        return customerMap;
    }

    public void setCustomerMap(Map<Integer, Customer> customerMap) {
        this.customerMap = customerMap;
    }
}
