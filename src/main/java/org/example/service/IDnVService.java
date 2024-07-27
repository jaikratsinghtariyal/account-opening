package org.example.service;

import org.example.dao.IDnVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IDnVService {

    @Autowired
    private final IDnVRepository iDnVRepository;

    public IDnVService(IDnVRepository iDnVRepository) {
        this.iDnVRepository = iDnVRepository;
    }

    public Boolean  findIDnV(String postcode){
        return !iDnVRepository.findIDnV(postcode).isEmpty();
    }
}
