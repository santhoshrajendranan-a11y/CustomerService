package com.custservice.service;

import com.custservice.entity.CustEntity;
import com.custservice.repository.CustRepository;
import com.custservice.request.CustRequest;
import com.custservice.response.CustResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustService {

    @Autowired
    private CustRepository repository;

    public CustResponse createOrUpdateCust(CustRequest request){

        CustEntity entity=new CustEntity();

        entity.setEmail(request.getEmail());
        entity.setAddress(request.getAddress());
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setFeedBack(request.getFeedBack());
        entity.setPhoneNumber(request.getPhoneNumber());

        entity=repository.save(entity);

        CustResponse response=new CustResponse();

        if(null!=entity){
            response.setCustemail(entity.getEmail());
            response.setCustaddress(entity.getAddress());
            response.setId(entity.getId());
            response.setFirstCustName(entity.getFirstName());
            response.setLastCustName(entity.getLastName());
            response.setCustfeedBack(entity.getFeedBack());
            response.setCustphoneNumber(response.getCustphoneNumber());
        }

        return response;

    }

    public List<CustEntity> getAllCustomerService(){
        return repository.findAll();
    }
    public CustEntity getCustomerServiceById(Long id){
        return repository.getReferenceById(id);
    }


    public void deleteCustomer(Long id){
        repository.deleteById(id);
    }

}
