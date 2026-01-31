package com.custservice.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustResponse {

    private long id;

    private String firstCustName;

    private String lastCustName;

    private String Custemail;

    private String CustfeedBack;

    private String CustphoneNumber;

    private String Custaddress;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstCustName() {
        return firstCustName;
    }

    public void setFirstCustName(String firstCustName) {
        this.firstCustName = firstCustName;
    }

    public String getLastCustName() {
        return lastCustName;
    }

    public void setLastCustName(String lastCustName) {
        this.lastCustName = lastCustName;
    }

    public String getCustemail() {
        return Custemail;
    }

    public void setCustemail(String custemail) {
        Custemail = custemail;
    }

    public String getCustfeedBack() {
        return CustfeedBack;
    }

    public void setCustfeedBack(String custfeedBack) {
        CustfeedBack = custfeedBack;
    }

    public String getCustphoneNumber() {
        return CustphoneNumber;
    }

    public void setCustphoneNumber(String custphoneNumber) {
        CustphoneNumber = custphoneNumber;
    }

    public String getCustaddress() {
        return Custaddress;
    }

    public void setCustaddress(String custaddress) {
        Custaddress = custaddress;
    }
}
