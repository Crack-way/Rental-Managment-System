package com.rentmangementsystem.landlord.service;

import com.rentmangementsystem.landlord.dto.LandlordDto;
import com.rentmangementsystem.lease.dto.RequestLeaseDto;
import com.rentmangementsystem.lease.dto.ResponseLeaseDto;
import com.rentmangementsystem.main.shared.mapper.MapperImpl;
import com.rentmangementsystem.property.entity.Property;
import com.rentmangementsystem.landlord.entity.Landlord;
import com.rentmangementsystem.landlord.repo.LandlordRepo;
import com.rentmangementsystem.property.enums.PropertyStatus;
import com.rentmangementsystem.property.enums.PropertyType;
import com.rentmangementsystem.property.exception.PropertyAlreadyInLeaseException;
import com.rentmangementsystem.property.exception.PropertyDoesNotExistException;
import com.rentmangementsystem.property.service.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LandlordServiceImpl implements LandlordService {

    @Autowired
    private LandlordRepo landlordRepo;


    @Autowired
    private PropertyServiceImpl propertyService;


    private final MapperImpl mapper = new MapperImpl();




    public LandlordDto addLandlord(LandlordDto landlordDto) {

        Landlord landlord = mapper.toLandlord(landlordDto);

        List<Property> propertyList = landlord.getPropertyList();
        for (Property property : propertyList) {

            property.setPropertyStatus(PropertyStatus.isAvailable);
            property.setPropertyType(PropertyType.LAND);
            property.setLandlord(landlord);
        }
        landlordRepo.save(landlord);
        return mapper.toLandlordDto(landlord);
    }


    @Override
    public ResponseLeaseDto requestForLease(Long propertyId, RequestLeaseDto requestLeaseDto) {


        if (propertyService.findPropertyStatus(propertyId).equals(("inLease"))){


            throw new PropertyAlreadyInLeaseException("Already In lease");
        }
        else if(propertyService.findPropertyStatus(propertyId).equals("isAvailable")){


            Landlord landlord=propertyService.getProperty(propertyId).get().getLandlord();

            ResponseLeaseDto responseLeaseDto=new ResponseLeaseDto();
            responseLeaseDto.setLandlordId(landlord.getId());
            responseLeaseDto.setLandlordAccountNo(landlord.getLandlordAccountNo());
            responseLeaseDto.setPropertyId(propertyId);
            return responseLeaseDto;
        }
        else{
            throw new PropertyDoesNotExistException("Does Not exist");
        }
    }

    @Override
    public Optional<Landlord> findByAccountNo(String accountNo) {
        return  landlordRepo.findByLandlordAccountNo(accountNo);
    }
}



