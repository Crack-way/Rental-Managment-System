package com.rentmangementsystem.payment.repo;

import com.rentmangementsystem.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long> {

}
