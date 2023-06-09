package com.rentmangementsystem.landlord.repo;

import com.rentmangementsystem.landlord.entity.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LandlordRepo extends JpaRepository<Landlord, Long> {


    Optional<Landlord> findByLandlordAccountNo(String accountNo);

    Optional<Landlord> findById(Long id);
}
