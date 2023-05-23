package com.rentmangementsystem.landlord.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.rentmangementsystem.contact.entity.Contact;
import com.rentmangementsystem.payment.entity.Payment;
import com.rentmangementsystem.property.entity.Property;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property ="id")
public class Landlord{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="landlord_id")
    private Long id;
    @Column(name="landlord_Name")
    private String name;

    @Column(name="account_No")
    private String landlordAccountNo;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name ="contact_id")
    private Contact contact;

    @OneToMany(mappedBy = "landlord",cascade=CascadeType.ALL)
    private List<Property> propertyList;



}
