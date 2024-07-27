package org.example.service;

import org.example.dao.FVQRepository;
import org.example.models.FVQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FVQService {

    @Autowired
    final private FVQRepository repository;

    public FVQService(FVQRepository repository) {
        this.repository = repository;
    }

    public void writeFVQ(FVQ fvq) {
        if (repository.writeFVQ(fvq.getContent(), fvq.getApplicationstatus(), fvq.getApplicationid())==1) {
            System.out.println("FVQ Written");
        }
    }
}
