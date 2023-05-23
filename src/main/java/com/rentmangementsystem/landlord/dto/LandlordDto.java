package com.rentmangementsystem.landlord.dto;

import com.rentmangementsystem.contact.dto.ContactDto;
import com.rentmangementsystem.contact.entity.Contact;
import com.rentmangementsystem.property.dtos.PropertyDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LandlordDto {


    private String name;


    private String accountNo;

    private ContactDto contact;


    private List<PropertyDto> propertyList;
}
