package com.base_java.baselts.enums;

public enum Gender {
    Unknown(0),
    Male(1),
    Female(2),
    ;
    private final int value;

    public int getValue() {
        return value;
    }

    Gender(int value) {
        this.value = value;
    }
}
