package org.example.servicetasks;

import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.springframework.stereotype.Component;

@Component
public class SendReminderServiceTask {

    @ZeebeWorker(type="sendReminderServiceTask", autoComplete = true)
    public void serve(){
        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++ Email Sent ++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++");
    }
}
