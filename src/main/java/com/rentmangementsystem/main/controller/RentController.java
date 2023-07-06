package com.rentmangementsystem.main.controller;

import com.rentmangementsystem.landlord.dto.LandlordDto;
import com.rentmangementsystem.landlord.service.LandlordServiceImpl;
import com.rentmangementsystem.lease.dto.RequestLeaseDto;
import com.rentmangementsystem.lease.dto.ResponseLeaseDto;
import com.rentmangementsystem.payment.dto.PaymentDto;
import com.rentmangementsystem.payment.service.PaymentServiceImpl;
import com.rentmangementsystem.property.dtos.ResponsePropertyDto;
import com.rentmangementsystem.property.service.PropertyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rent")
@RequiredArgsConstructor
public class RentController {

    private final LandlordServiceImpl landlordService;

    private final PropertyServiceImpl propertyService;

    private final PaymentServiceImpl paymentService;


    @PostMapping(value = "/addLandlord")
    public ResponseEntity<LandlordDto> addLandlord(@RequestBody LandlordDto landlordDto) {

        return ResponseEntity.ok(landlordService.addLandlord(landlordDto));


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
