package com.example.rentabookrestservices.controller;

import com.example.rentabookrestservices.domain.Sale;
import com.example.rentabookrestservices.service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/sales")
    public ResponseEntity<List<Sale>> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/sales/{operationNumber}")
    public ResponseEntity<Sale> getSaleBySaleNumber(@PathVariable("operationNumber") String operationNumber) {
        return saleService.getSaleByOperationNumber(operationNumber);
    }

    @PostMapping("/sales")
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        return saleService.createSale(sale);
    }


}
