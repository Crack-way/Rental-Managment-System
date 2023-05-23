package com.rentmangementsystem.lease.repo;

import com.rentmangementsystem.lease.entity.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseRepo extends JpaRepository<Lease,Long> {
}
