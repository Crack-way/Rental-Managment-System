package com.rentmangementsystem.tenant.service;

import com.rentmangementsystem.main.shared.mapper.Mapper;
import com.rentmangementsystem.main.shared.mapper.MapperImpl;
import com.rentmangementsystem.tenant.dto.TenantDto;
import com.rentmangementsystem.tenant.entity.Tenant;
import com.rentmangementsystem.tenant.repo.TenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantServiceImpl implements TenantService{


    @Autowired
    private TenantRepo tenantRepo;


    private Mapper mapper=new MapperImpl();
    public TenantDto addTenant(TenantDto tenantDto){


        Tenant tenant=mapper.toTenant(tenantDto);

        return mapper.toTenantDto(tenantRepo.save(tenant));
    }
}
