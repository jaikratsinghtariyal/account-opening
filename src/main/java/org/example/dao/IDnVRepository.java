package org.example.dao;

import org.example.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDnVRepository extends JpaRepository<Application, Long> {

    @Query("select a.idnvid from IDnV a where a.postcode = :postcode")
    List<Integer> findIDnV(@Param("postcode") String postcode);
}
