package com.saikumar.Backend_Traini8.ExceptionHandlers;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({UnexpectedTypeException.class})
    public ResponseEntity<ApiError> handleUnexpectedTypeException(final UnexpectedTypeException e) {
        log.error("Empty Fields Received : ", e);
        return ResponseEntity.internalServerError().body(new ApiError(500, "Internal Server Error", e.getMessage()));
    }
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ApiError> handleConstraintViolationExceptions(final ConstraintViolationException e) {
        log.error("Handling Constraint Violation Exception :", e);
        return ResponseEntity.badRequest().body( new ApiError(400,"Provide a valid value",e.getMessage()));
    }
    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<ApiError> handleDataIntegrityViolationExceptions(final DataIntegrityViolationException e){
        log.error("Duplicate Value Provided" , e);
        return ResponseEntity.badRequest().body(new ApiError(400 , "Field requires unique value , Provided duplicate value",e.getLocalizedMessage()));
    }
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Map<String,Object>> handleMethodArgumentNotValidExceptions(final MethodArgumentNotValidException e){
        log.error("Not valid Arguments" , e);

        // converting the Exceptions to a hashMap and returning as a response for better understanding

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", HttpStatus.BAD_REQUEST.value());

        List<String> errors = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            errors.add(error.getDefaultMessage());
        });
        response.put("errors", errors);
        return ResponseEntity.badRequest().body(response);
    }
    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleError(final Exception e) {
        log.error("UnExpected Error: ", e);
        return ResponseEntity.badRequest().body(new ApiError(400, "Empty fields or Invalid Value" ,e.getMessage()));
    }

}