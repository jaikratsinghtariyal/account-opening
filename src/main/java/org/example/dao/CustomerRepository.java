package org.example.dao;

import org.example.models.Application;
import org.example.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Application, Long> {

    @Query("select a.customerid from Customer a where a.customername = :customerName and a.dob = :dob " +
            "and a.mobilenumber = :mobileNumber and a.emailid = :emailId and a.postcode = :postCode")
    List<Integer> findDuplicate(@Param("customerName") String customerName, @Param("dob") String dob,
                                @Param("mobileNumber") String mobileNumber, @Param("emailId") String emailId,
                                @Param("postCode") String postCode);

    @Modifying
    @Query("INSERT INTO Customer (customername, dob, mobilenumber, emailid, postcode)" +
            "VALUES (:customerName, :dob, :mobileNumber, :emailId, :postCode)")
    @Transactional
    List<Customer> createCustomer(@Param("customerName") String customerName, @Param("dob") String dob,
                                  @Param("mobileNumber") String mobileNumber, @Param("emailId") String emailId,
                                  @Param("postCode") String postCode);

    Customer save(Customer customer);
}
