package com.rentmangementsystem.payment.entity;


import com.rentmangementsystem.landlord.entity.Landlord;
import com.rentmangementsystem.tenant.entity.Tenant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long payment_Id;

    @Column(name = "amount_Paid")
    private double amountPaid;

    private Long propertyId;

    @OneToOne(cascade = CascadeType.ALL)
    private Tenant tenant;

    @ManyToOne
    @JoinColumn(name="landlord_id")
    private Landlord landlord;


}
