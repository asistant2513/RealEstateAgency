package com.agency.demo.enums;

public enum EstateStatus {
    NEEDS_RENOVATION("Needs renovation"),
    NEW_BUILDING("New building"),
    GOOD("Good"),
    AFTER_RENOVATION("After renovation");

    private String status;

    private EstateStatus(String val){
        this.status = val;
    }



}
