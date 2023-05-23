package com.rentmangementsystem.property.entity;


import com.rentmangementsystem.landlord.entity.Landlord;
import com.rentmangementsystem.property.enums.PropertyStatus;
import com.rentmangementsystem.property.enums.PropertyType;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_Id")
    private Long propertyId;
    @Column(name = "property_Address")
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(name = "propertyType")
    private PropertyType propertyType;
    @Column(name = "rent_Amount")
    private Double rentAmount;
    @Column(name = "propertyStatus")
    @Enumerated(EnumType.STRING)
    private PropertyStatus propertyStatus;

    @ManyToOne
    @JoinColumn(name="landLord_Id")
    private Landlord landlord;



}
