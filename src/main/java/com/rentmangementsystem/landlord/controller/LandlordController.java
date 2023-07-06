package com.rentmangementsystem.landlord.controller;

import com.rentmangementsystem.landlord.entity.Landlord;
import com.rentmangementsystem.landlord.repo.LandlordRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/landlord")
public class LandlordController {


    private final LandlordRepo landlordRepo;

    @GetMapping("/getLandlord/{accountNo}")
    public ResponseEntity<Optional<Landlord>> getLandlord(@PathVariable String accountNo) {

        return ResponseEntity.ok(landlordRepo.findByLandlordAccountNo(accountNo));

    }

}
