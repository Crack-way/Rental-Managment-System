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
import org.mapstruct.Mapping;

public class MapperImpl implements Mapper {
    @Override
//    @Mapping(source = "propertyList", target = "propertyList", qualifiedByName = "toPropertyList")
//    @Mapping(source="contact",target="contact",qualifiedByName = "toContactEntity")
    public Landlord toLandlord(LandlordDto landlordDto) {
        Landlord landlord = new Landlord();
        landlord.setName(landlordDto.getName());
        landlord.setLandlordAccountNo(landlordDto.getAccountNo());
        landlord.setPropertyList(toPropertyList(landlordDto.getPropertyList()));
        landlord.setContact(toContact(landlordDto.getContact()));
        return landlord;
    }

    @Override
    @Mapping(source = "propertyList", target = "propertyList", qualifiedByName = "toPropertyDtoList")
    public LandlordDto toLandlordDto(Landlord landlord) {
        LandlordDto landlordDto=new LandlordDto();
        landlordDto.setName(landlord.getName());
        landlordDto.setContact(toContactDto(landlord.getContact()));
        landlordDto.setAccountNo(landlord.getLandlordAccountNo());
        landlordDto.setPropertyList(toPropertyDtoList(landlord.getPropertyList()));
        return landlordDto;
    }


    @Override
    public Property toProperty(PropertyDto propertyDto) {
        Property property = new Property();
        property.setAddress(propertyDto.getAddress());
        property.setRentAmount(propertyDto.getRentAmount());
        return property;
    }

    @Override
    public Contact toContact(ContactDto contactDto) {
        Contact contact=new Contact();
        contact.setAddress(contactDto.getAddress());
        contact.setEmail(contactDto.getEmail());
        contact.setPhone(contactDto.getPhone());
        System.out.println("for Contact "+ contact);
        return contact;
    }

    @Override
    public ContactDto toContactDto(Contact contact) {
        ContactDto contactDto=new ContactDto();
        contactDto.setPhone(contact.getPhone());
        contactDto.setAddress(contact.getAddress());
        contactDto.setEmail(contact.getEmail());
        return contactDto;
    }

    @Override
    public ResponsePropertyDto toResponsePropertyDto(Property property) {
          ResponsePropertyDto responsePropertyDto=new ResponsePropertyDto();

          responsePropertyDto.setPropertyAddress(property.getAddress());
          responsePropertyDto.setRentAmount(property.getRentAmount());
          responsePropertyDto.setLandlordId(property.getPropertyId());
          responsePropertyDto.setLandlordAccountNo(property.getLandlord().getLandlordAccountNo());
          responsePropertyDto.setLandlordContactNo(toLandlordDto(property.getLandlord()).getContact());


          return  responsePropertyDto;
    }

    @Override
    public PaymentDto toPaymentDto(Payment payment) {
        return null;
    }

    @Override
    public Payment toPayment(PaymentDto paymentDto) {
       Payment payment=new Payment();
       payment.setAmountPaid(paymentDto.getAmountPaid());
       payment.setLandlord(paymentDto.getLandlord());
       payment.setPropertyId(paymentDto.getPropertyId());
       payment.setTenant(toTenant(paymentDto.getCustomer()));

       return payment;
    }

    @Override
    public Tenant toTenant(TenantDto tenantDto) {
        Tenant tenant=new Tenant();
        tenant.setContact(toContact(tenantDto.getCustomerContactDto()));
        tenant.setName(tenantDto.getCustomerName());
        return tenant;
    }

    @Override
    public TenantDto toTenantDto(Tenant tentant) {
        TenantDto tenantDto=new TenantDto();
        tenantDto.setCustomerName(tenantDto.getCustomerName());

        return tenantDto;
    }


    @Override
    public PropertyDto toPropertyDto(Property property) {
        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setAddress(property.getAddress());
        propertyDto.setRentAmount(property.getRentAmount());
        return propertyDto;
    }





}
