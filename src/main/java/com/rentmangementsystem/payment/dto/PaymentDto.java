package com.rentmangementsystem.payment.dto;

import com.rentmangementsystem.contact.dto.ContactDto;
import com.rentmangementsystem.landlord.dto.LandlordDto;
import com.rentmangementsystem.landlord.entity.Landlord;
import com.rentmangementsystem.tenant.dto.TenantDto;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class PaymentDto {



    private double amountPaid;

    private long propertyId;
    private String landlordAccountNo;

    private TenantDto customer;

    private Landlord landlord;

}
