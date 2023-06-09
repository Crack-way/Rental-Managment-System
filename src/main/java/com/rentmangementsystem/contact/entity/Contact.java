package com.rentmangementsystem.contact.entity;


import com.rentmangementsystem.landlord.entity.Landlord;
import com.rentmangementsystem.tenant.entity.Tenant;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long contact_Id;
    private String email;

    private String phone;

    private String address;





}
