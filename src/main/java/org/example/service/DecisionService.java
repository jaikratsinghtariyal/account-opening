package org.example.service;

import org.example.dao.DecisionRepository;
import org.example.models.Decision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecisionService {

    @Autowired
    private final DecisionRepository repository;

    public DecisionService(DecisionRepository repository) {
        this.repository = repository;
    }

    public Boolean getDecision(Decision decision){
        List<String> listofDecision = repository.getDecision(decision.getCustomername(),
                decision.getDob(), decision.getEmailid(),
                decision.getPostcode());

        if (!listofDecision.isEmpty()) {
            return switch (listofDecision.get(0)) {
                case "Rejected" -> false;
                case "Referred" -> false;
                default -> true;
            };
        }

        return true;
    }
}
