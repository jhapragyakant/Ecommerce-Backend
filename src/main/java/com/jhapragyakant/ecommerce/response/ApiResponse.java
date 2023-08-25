package com.jhapragyakant.ecommerce.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ApiResponse {

    private final boolean success;
    private final String message;

    public boolean isSuccess(){
        return success;
    }
    public String getMessage(){
        return message;
    }
    public String getTimeStamp(){
        return LocalDateTime.now().toString();
    }
}
