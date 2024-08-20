package com.base_java.baselts.enums;

public enum ContractStatus {

    HetHan(0),
    BanNhap(1),
    DaHuy(2),
    DaGiaHan(3),
    DaChamDut(4),
    DangCho(5);
    private final int value;

    ContractStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
