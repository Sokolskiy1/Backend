package com.example.backendPP.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CodeMessege {
    @JsonFormat(shape = JsonFormat.Shape.STRING)//, pattern = "yyyy-MM-dd hh:mm:ss"
    // private LocalDateTime timestamp;
    //private int status;
    //private String error;
    private String code;
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    //...setters setters
}
