package org.example.dao;

import org.example.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DecisionRepository extends JpaRepository<Application, Long> {

    @Query("select a.decision from Decision a where a.customername = :customerName and a.dob = :dob " +
            "and a.emailid = :emailId and a.postcode = :postCode")
    List<String> getDecision(@Param("customerName") String customerName, @Param("dob") String dob,
                                 @Param("emailId") String emailId,
                                @Param("postCode") String postCode);
}
