package com.rentmangementsystem.payment.service;

import com.rentmangementsystem.landlord.entity.Landlord;
import com.rentmangementsystem.landlord.service.LandlordServiceImpl;
import com.rentmangementsystem.lease.entity.Lease;
import com.rentmangementsystem.lease.service.LeaseServiceImpl;
import com.rentmangementsystem.main.shared.mapper.Mapper;
import com.rentmangementsystem.main.shared.mapper.MapperImpl;
import com.rentmangementsystem.payment.dto.PaymentDto;
import com.rentmangementsystem.payment.entity.Payment;
import com.rentmangementsystem.payment.repo.PaymentRepo;
import com.rentmangementsystem.property.service.PropertyServiceImpl;
import com.rentmangementsystem.tenant.service.TenantServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;

@Service
public class PaymentServiceImpl implements PaymentService {


    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    LandlordServiceImpl landlordService;

    @Autowired
    TenantServiceImpl tenantService;

    @Autowired
    PropertyServiceImpl propertyService;

    @Autowired
    LeaseServiceImpl leaseService;

    Mapper mapper = new MapperImpl();


    @Transactional
    public void makePayment(PaymentDto paymentDto) {


        Landlord landlord = landlordService.findByAccountNo(paymentDto.getLandlordAccountNo()).get();
        paymentDto.setLandlord(landlord);
        Payment payment = paymentRepo.save(mapper.toPayment(paymentDto));

        propertyService.updatePropertyStatus("inLease",paymentDto.getPropertyId());

        Lease lease = new Lease();
        lease.setTenant(payment.getTenant());
        lease.setProperty(propertyService.getProperty(paymentDto.getPropertyId()).get());
        lease.setStartDate(new Date());
        lease.setEndDate(new Date());

        leaseService.makeLease(lease);

    }


}
