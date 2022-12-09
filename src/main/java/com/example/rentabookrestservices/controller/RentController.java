package com.example.rentabookrestservices.controller;

import com.example.rentabookrestservices.domain.Rent;
import com.example.rentabookrestservices.service.RentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RentController {
    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("/rents")
    public ResponseEntity<List<Rent>> getAllRents() {
        List<Rent> rentList = rentService.getAllRents();

        if (rentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(rentList, HttpStatus.OK);
    }

    @GetMapping("/rents/{operationNumber}")
    public ResponseEntity<Rent> getRent(@PathVariable("operationNumber") String operationNumber) {
        if (rentService.isExistRent(operationNumber)) {
            Rent rent = rentService.getRent(operationNumber);
            return new ResponseEntity<>(rent, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/rents")
    public ResponseEntity<Rent> createRent(@RequestBody Rent rent) {
        return new ResponseEntity<>(rentService.createRent(rent), HttpStatus.CREATED);
    }

    @DeleteMapping("/rents/{operationNumber}")
    public ResponseEntity<HttpStatus> deleteRent(@PathVariable("operationNumber") String operationNumber) {
        boolean isExistRent = rentService.isExistRent(operationNumber);

        if (isExistRent) {
            rentService.deleteRentByOperationNumber(operationNumber);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
