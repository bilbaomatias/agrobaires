package com.agrobaires.agrobaires.context;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public enum UserStatus {
    ACTIVE("1"),
    INACTIVE("2"),
    SUSPENDED("3");

    private String status;
    UserStatus(String userStatus) {
        this.status = userStatus;
    }

    public int getUserStatusNumber() {
        return Integer.valueOf(status);
    }
}
