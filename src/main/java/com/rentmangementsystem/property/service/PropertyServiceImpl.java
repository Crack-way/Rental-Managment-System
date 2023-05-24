package com.rentmangementsystem.property.service;

import com.rentmangementsystem.main.shared.mapper.Mapper;
import com.rentmangementsystem.main.shared.mapper.MapperImpl;
import com.rentmangementsystem.property.dtos.ResponsePropertyDto;
import com.rentmangementsystem.property.entity.Property;
import com.rentmangementsystem.property.enums.PropertyStatus;
import com.rentmangementsystem.property.repo.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepo propertyRepo;

    private Mapper mapper=new MapperImpl();


    @Secured("ROLE_LANDLORD")
    public List<ResponsePropertyDto> getAllProperty(){
         List<Property> propertyList= propertyRepo.findAll();
         List<ResponsePropertyDto> responsePropertyDto=new ArrayList<>();

         for(Property property:propertyList){

            responsePropertyDto.add(mapper.toResponsePropertyDto(property));

         }
         return responsePropertyDto;
    }


    public String findPropertyStatus(Long propertyId){

       return String.valueOf(propertyRepo.findById(propertyId).get().getPropertyStatus());
    }

    public Optional<Property> getProperty(Long propertyId){

        return propertyRepo.findById(propertyId);
    }

    public void updatePropertyStatus(String status,Long propertyId){
        Property property= propertyRepo.findById(propertyId).orElseThrow(null);

        if(status.equals("inLease")){

            property.setPropertyStatus(PropertyStatus.inLease);
        }
        else{
            property.setPropertyStatus(PropertyStatus.isAvailable);
        }
        propertyRepo.save(property);


    }
}
