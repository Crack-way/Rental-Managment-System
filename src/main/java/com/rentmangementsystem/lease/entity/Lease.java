package com.rentmangementsystem.lease.entity;


import com.rentmangementsystem.property.entity.Property;
import com.rentmangementsystem.tenant.entity.Tenant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lease{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long leaseId;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    private Date EndDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Property property;

    @OneToOne(cascade=CascadeType.ALL)
    private Tenant tenant;
}
