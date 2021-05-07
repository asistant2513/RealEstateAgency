package com.agency.demo.enums;

public enum EstateStatus {
    NEEDS_RENOVATION("Needs renovation"),
    NEW_BUILDING("New building"),
    GOOD("Good"),
    AFTER_RENOVATION("After renovation"),
    NOT_APPLIABLE("Not appliable");

    private String status;

    private EstateStatus(String val){
        this.status = val;
    }

    public String getStatus() {
        return status;
    }
}
