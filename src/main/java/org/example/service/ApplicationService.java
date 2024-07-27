package org.example.service;

import org.example.dao.ApplicationRepository;
import org.example.models.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    final private ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Boolean findDuplicate(Application application) {

        return !applicationRepository.findDuplicate(application.getCustomername(),
                application.getDob(),
                application.getMobilenumber(),
                application.getEmailid(),
                application.getPostcode()).isEmpty();
    }

    public Integer createApplication(Application application) {
        return applicationRepository.save(application).getAppid();
    }

    public void deleteApplication(String applicationId){
        applicationRepository.deleteById(Long.valueOf(applicationId));
    }

    public Integer updateApplication(Application application) {

        Optional<Application> optionalEntity = applicationRepository.findById((long) application.getAppid());

        Application existingEntity = optionalEntity.get();
        existingEntity.setApplicationstatus(application.getApplicationstatus());
        existingEntity.setFraudresult(application.getFraudresult());
        existingEntity.setIdnvresult(application.getIdnvresult());
        existingEntity.setCreditdecisionresult(application.getCreditdecisionresult());

        return applicationRepository.save(existingEntity).getAppid();
    }
}
