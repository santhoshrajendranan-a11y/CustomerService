package com.custservice.controller;


import com.custservice.CustException;
import com.custservice.CustomerServiceApplication;
import com.custservice.entity.CustEntity;
import com.custservice.request.CustRequest;
import com.custservice.response.CustResponse;
import com.custservice.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerservice")
public class CustController {

    CustService service;

    @Autowired
    public CustController(CustService service ){
        this.service = service;
}


    @PostMapping("createCust")
    public ResponseEntity<?> createCust(@RequestBody CustRequest request) {
        try{
            if(null == request.getFirstName() || request.getFirstName().isEmpty()){
                throw new CustException("Customer First Name should not be empty");
            }
            if(null == request.getLastName() || request.getLastName().isEmpty()){
                throw new CustException("Customer Last Name should not be empty");
            }

            return new ResponseEntity<>(service.createOrUpdateCust(request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("allCustomer")
    public List<CustEntity> getcustomerlist(){
        return service.getAllCustomerService();
    }

    @GetMapping("/customerservice/{id}")
    public CustEntity getcustomerserviceById(@PathVariable("id") Long id){
        return service.getCustomerServiceById(id);
    }

   /* @PutMapping("/updateCustomer")
    public CustEntity updateCustomer(@RequestBody CustEntity updateCustomer) {
        CustEntity currentcustomer = null;
        if (updateCustomer.getId() != null) {
            currentcustomer = service.getCustomerServiceById(updateCustomer.getId());
        }
        if (currentcustomer != null) {
            currentcustomer.setFeedBack(updateCustomer.getFeedBack());
            currentcustomer.setFirstName(updateCustomer.getFirstName());
            currentcustomer.setLastName(updateCustomer.getLastName());
            currentcustomer.setPhoneNumber(updateCustomer.getPhoneNumber());
            currentcustomer.setEmail(updateCustomer.getEmail());
            currentcustomer.setId(updateCustomer.getId());
        }
        service.createOrUpdateCust(currentcustomer);
        return currentcustomer;

        }*/

    @DeleteMapping("/deletecustomer/{id}")
    public void deletecustomer(@PathVariable("id") Long id) {
        service.deleteCustomer(id);
    }
    }

