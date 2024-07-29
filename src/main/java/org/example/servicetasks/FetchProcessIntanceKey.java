package org.example.servicetasks;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import io.camunda.zeebe.spring.client.properties.ZeebeClientConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FetchProcessIntanceKey {

    @ZeebeWorker(type = "fetchProcessInstanceKey", autoComplete = true)
    public Map<String, String> serve(JobClient client, final ActivatedJob job) {
        System.out.println("+++++++++fetchProcessInstanceKey ++++++++++++");

        Map<String, String> map = new HashMap<>();
        map.put("processInstanceKey", String.valueOf(job.getProcessInstanceKey()));

        return map;
    }
}
