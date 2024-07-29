package org.example.dao;

import org.example.models.FVQ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FVQRepository extends JpaRepository<FVQ, Long> {

//    @Modifying
//    @Query("INSERT INTO FVQ (content, applicationstatus, applicationid)" +
//            "VALUES (:content, :applicationstatus, :applicationid)")
//    @Transactional
//    Integer writeFVQ(@Param("content") String content, @Param("applicationstatus") String applicationstatus,
//                           @Param("applicationid") int applicationid);

//    FVQ save(FVQ customer);
}
