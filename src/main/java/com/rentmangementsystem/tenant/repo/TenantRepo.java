package com.rentmangementsystem.tenant.repo;

import com.rentmangementsystem.tenant.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepo extends JpaRepository<Tenant,Long> {
}
