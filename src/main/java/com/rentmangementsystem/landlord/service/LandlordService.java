package com.rentmangementsystem.landlord.service;

import com.rentmangementsystem.landlord.dto.LandlordDto;
import com.rentmangementsystem.landlord.entity.Landlord;
import com.rentmangementsystem.lease.dto.RequestLeaseDto;
import com.rentmangementsystem.lease.dto.ResponseLeaseDto;

import java.util.Optional;

public interface LandlordService {

    public LandlordDto addLandlord(LandlordDto landlordDto);

    public ResponseLeaseDto requestForLease(Long propertyId, RequestLeaseDto requestLeaseDto);


    public Optional<Landlord>  findByAccountNo(String accountNo);
}
