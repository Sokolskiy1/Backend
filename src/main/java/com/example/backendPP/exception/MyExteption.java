package com.example.backendPP.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


public class MyExteption extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(ThereIsNoSuchUserException.class)
//    public ResponseEntity<AwesomeException> handleThereIsNoSuchUserException() {
//       // return new ResponseEntity<>(new AwesomeException("There is no such user"), HttpStatus.NOT_FOUND);
//    }
//
//    //@Data
//    //@AllArgsConstructor
//   // @Data
//            //@AllArgsConstructor
//    private static class AwesomeException {
//        private String message;
//
//    }
}
