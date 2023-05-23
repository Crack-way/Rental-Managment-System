package com.rentmangementsystem.lease.service;


import com.rentmangementsystem.lease.entity.Lease;
import com.rentmangementsystem.lease.repo.LeaseRepo;
import com.rentmangementsystem.payment.dto.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaseServiceImpl implements LeaseService {


    @Autowired
    private LeaseRepo leaseRepo;
    @Override
    public String makeLease(Lease lease) {


        leaseRepo.save(lease);
        return "SuccessFully Completed Agreement.";
    }
}
