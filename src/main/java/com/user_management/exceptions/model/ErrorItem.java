package com.user_management.exceptions.model;

import lombok.Data;

@Data
public class ErrorItem {
    private String statusCode;
    private String statusDescription;
    private boolean status;

}
