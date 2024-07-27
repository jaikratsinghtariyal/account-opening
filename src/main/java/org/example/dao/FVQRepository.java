package org.example.dao;

import org.example.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface FVQRepository extends JpaRepository<Application, Long> {

    @Modifying
    @Query("INSERT INTO FVQ (content, applicationstatus, applicationid)" +
            "VALUES (:content, :applicationstatus, :applicationid)")
    @Transactional
    Integer writeFVQ(@Param("content") String content, @Param("applicationstatus") String applicationstatus,
                           @Param("applicationid") int applicationid);
}
