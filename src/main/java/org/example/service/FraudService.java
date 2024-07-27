package org.example.service;

import org.example.dao.FraudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraudService {

    @Autowired
    final private  FraudRepository fraudRepository;

    public FraudService(FraudRepository fraudRepository) {
        this.fraudRepository = fraudRepository;
    }

    public Boolean findFraud(String emailId){
        return !fraudRepository.findFraud(emailId).isEmpty();
    }

}
