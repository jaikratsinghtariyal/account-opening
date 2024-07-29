package org.example.dao;

import org.example.models.Fraud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FraudRepository extends JpaRepository<Fraud, Long> {

    @Query("select a.fraudid from Fraud a where a.emailid = :emailId")
    List<Integer> findFraud(@Param("emailId") String emailId);
}
