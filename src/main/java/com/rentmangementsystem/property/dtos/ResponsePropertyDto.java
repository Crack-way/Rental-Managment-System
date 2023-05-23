package com.rentmangementsystem.property.dtos;

import com.rentmangementsystem.contact.dto.ContactDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePropertyDto {
    private Long landlordId;
    private String propertyAddress;

    private Double rentAmount;

    private String landlordAccountNo;

    private ContactDto LandlordContactNo;

}
