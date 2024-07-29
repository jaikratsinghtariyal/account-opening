package org.example.servicetasks;

import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.springframework.stereotype.Component;

@Component
public class FinishingServiceTask {

    @ZeebeWorker(type="finishingServiceTask", autoComplete = true)
    public void serve(){
        System.out.println("+++++++++Finishing the flow ++++++++++++");
        //return true;
    }
}
