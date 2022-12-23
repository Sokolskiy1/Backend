package com.example.backendPP.exception;

//package com.csharpcoderr.error;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class CustomErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING)//, pattern = "yyyy-MM-dd hh:mm:ss"
   // private LocalDateTime timestamp;
    //private int status;
    //private String error;
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
//...setters setters
}