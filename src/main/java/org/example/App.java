package org.example;

import io.camunda.zeebe.spring.client.EnableZeebeClient;
import io.camunda.zeebe.spring.client.annotation.ZeebeDeployment;
import org.example.models.*;
import org.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

/**
 * Hello world!
 */
@SpringBootApplication
@RestController
public class App {

    @Autowired
    final private ZeeBeeService zeeBeeService;

    @Autowired
    final private ApplicationService applicationService;

    @Autowired
    final private CustomerService customerService;

    @Autowired
    final private FraudService fraudService;

    @Autowired
    final private IDnVService iDnVService;

    @Autowired
    final private DecisionService decisionService;

    @Autowired
    final private FVQService fvqService;

    @Autowired
    final private ProductService productService;

    public App(ZeeBeeService zeeBeeService, ApplicationService applicationService,
               CustomerService customerService, FraudService fraudService, IDnVService iDnVService,
               DecisionService decisionService, FVQService fvqService, ProductService productService) {
        this.zeeBeeService = zeeBeeService;
        this.applicationService = applicationService;
        this.customerService = customerService;
        this.fraudService = fraudService;
        this.iDnVService = iDnVService;
        this.decisionService = decisionService;
        this.fvqService = fvqService;
        this.productService = productService;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/hello")
    public String sayHello() {
        System.out.println("+++++++++++++++++++++++++++");
        return "Hello From Spring example++++++++";
    }

    @PostMapping("/onboard")
    public String startJourney(@RequestBody Application application) {
        zeeBeeService.startFlow(application);
        return "Customer Journey Started";
    }

    @PostMapping("/onboard-event")
    public String startJourneyEventWay(@RequestBody Application application) {
        zeeBeeService.sendMsg(application);
        return "Customer Journey Started";
    }

    @PostMapping("/duplicate-application")
    public Boolean checkDuplicateApplication(@RequestBody Application application) {
        return applicationService.findDuplicate(application);
    }

    @PostMapping("/application")
    public Integer createApplication(@RequestBody Application application) {
        application.setApplicationstatus("NEW");
        return applicationService.createApplication(application);
    }

    @PatchMapping("/application")
    public Integer updateApplication(@RequestBody Application application) {
        return applicationService.updateApplication(application);
    }

    @DeleteMapping("/application")
    public void updateApplication(@RequestParam String applicationId) {
        System.out.println("++++++++++++++++++++++++++++++++++++ " + applicationId);
        applicationService.deleteApplication(applicationId);
    }

    @PostMapping("/duplicate-customer")
    public Boolean checkDuplicateCustomer(@RequestBody Customer customer) {
        return customerService.findDuplicate(customer);
    }

    @PostMapping("/customer")
    public Integer createCustomer(@RequestBody Customer customer) {

        if (customer.getPostcode().equals("000000")) {
            throw new RuntimeException("Wrong PostCode");
        }
        return customerService.createCustomer(customer);
    }

    @PostMapping("/fraud")
    public Boolean findFraud(@RequestBody Fraud fraud) {
        return fraudService.findFraud(fraud.getEmailid());
    }

    @PostMapping("/idnv")
    public Boolean findIdnv(@RequestBody IDnV iDnV) {
        return iDnVService.findIDnV(iDnV.getPostcode());
    }

    @PostMapping("/decision")
    public Boolean getDecisiong(@RequestBody Decision decision) {
        return decisionService.getDecision(decision);
    }

    @PostMapping("/fvq")
    public void writeFVQ(@RequestBody FVQ FVQ) {
        fvqService.writeFVQ(FVQ);
    }

    @PostMapping("/product-onboarding")
    public boolean addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }


}
