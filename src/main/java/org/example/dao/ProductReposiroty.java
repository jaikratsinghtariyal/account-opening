package org.example.dao;

import org.example.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductReposiroty extends JpaRepository<Product, Long> {

//    @Modifying
//    @Query("INSERT INTO Product (customerid, product)" +
//            "VALUES (:customerId, :product)")
//    @Transactional
//    Integer onboardProduct(@Param("customerId") Integer customerid, @Param("product") String product);
}
