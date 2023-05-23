package com.rentmangementsystem.main.shared.mapper;

import com.rentmangementsystem.contact.dto.ContactDto;
import com.rentmangementsystem.contact.entity.Contact;
import com.rentmangementsystem.landlord.dto.LandlordDto;
import com.rentmangementsystem.landlord.entity.Landlord;
import com.rentmangementsystem.payment.dto.PaymentDto;
import com.rentmangementsystem.payment.entity.Payment;
import com.rentmangementsystem.property.dtos.PropertyDto;
import com.rentmangementsystem.property.dtos.ResponsePropertyDto;
import com.rentmangementsystem.property.entity.Property;
import com.rentmangementsystem.tenant.dto.TenantDto;
import com.rentmangementsystem.tenant.entity.Tenant;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {


    Landlord toLandlord(LandlordDto landlordDto);

    @Named("toPropertyList")
    default List<Property> toPropertyList(List<PropertyDto> propertyDto) {
        return propertyDto.stream()
                .map(this::toProperty)
                .collect(Collectors.toList());
    }


    LandlordDto toLandlordDto(Landlord landlord);


    @Named("toPropertyDtoList")
    default List<PropertyDto> toPropertyDtoList(List<Property> property) {
        return property.stream()
                .map(this::toPropertyDto)
                .collect(Collectors.toList());
    }

    PropertyDto toPropertyDto(Property property);

    Property toProperty(PropertyDto propertyDto);


//    @Named("toContactEntity")
//    default Contact toContactEntity(ContactDto contactDto) {
//
//
//        return toContact(contactDto);
//    }


    Contact toContact(ContactDto contactDto);

    ContactDto toContactDto(Contact contact);


    ResponsePropertyDto toResponsePropertyDto(Property property);


    PaymentDto toPaymentDto(Payment payment);

    Payment toPayment(PaymentDto paymentDto);


    Tenant toTenant(TenantDto tenantDto);

    TenantDto toTenantDto(Tenant tentant);
}
