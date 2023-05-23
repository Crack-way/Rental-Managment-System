package com.rentmangementsystem.tenant.dto;

import com.rentmangementsystem.contact.dto.ContactDto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TenantDto {

    String customerName;
    ContactDto customerContactDto;
}
