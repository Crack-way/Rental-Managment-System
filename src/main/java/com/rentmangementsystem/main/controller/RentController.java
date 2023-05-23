package com.rentmangementsystem.main.controller;

import com.rentmangementsystem.landlord.dto.LandlordDto;
import com.rentmangementsystem.landlord.service.LandlordServiceImpl;
import com.rentmangementsystem.lease.dto.RequestLeaseDto;
import com.rentmangementsystem.lease.dto.ResponseLeaseDto;
import com.rentmangementsystem.payment.dto.PaymentDto;
import com.rentmangementsystem.payment.service.PaymentServiceImpl;
import com.rentmangementsystem.property.dtos.ResponsePropertyDto;
import com.rentmangementsystem.property.service.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentController {
    @Autowired
    private LandlordServiceImpl landlordService;

    @Autowired
    private PropertyServiceImpl propertyService;

    @Autowired
    private PaymentServiceImpl paymentService;


    @PostMapping(value = "/addLandlord")
    public LandlordDto addLandlord(@RequestBody LandlordDto landlordDto) {

        return landlordService.addLandlord(landlordDto);


    }


    @GetMapping(value = "/showAllProperty")
    public List<ResponsePropertyDto> showAllProperty() {


        return propertyService.getAllProperty();
    }

    @PostMapping(value = "/requestForLease/{propertyId}")
    public ResponseLeaseDto requestForLease(@PathVariable Long propertyId, @RequestBody RequestLeaseDto requestLeaseDto) {


        return landlordService.requestForLease(propertyId, requestLeaseDto);

    }

    @PostMapping(value = "/makePayment")
    public boolean makePayment(@RequestBody PaymentDto paymentDto) {

        paymentService.makePayment(paymentDto);

        return true;
    }


}
