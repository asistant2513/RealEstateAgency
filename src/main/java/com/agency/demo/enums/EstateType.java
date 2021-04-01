package com.agency.demo.enums;

public enum EstateType {
    APARTMENT("Apartment"),
    LAND("Land plot"),
    HOUSE("Private house"),
    OFFICE("Office");

    private EstateType(String val){
        this.type = val;
    }

        private String type;

    public String getType(){
        return this.type;
    }
}
