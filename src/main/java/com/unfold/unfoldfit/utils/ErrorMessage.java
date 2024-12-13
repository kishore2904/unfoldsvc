package com.unfold.unfoldfit.utils;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
    public static final String DATA_NOT_FOUND = "DATA_NOT_FOUND";
    public static final String INVALID_INPUT = "INVALID_INPUT";

    public enum ErrorCodeConstants {
        DATA_NOT_FOUND("A001", "Data Not Found", HttpStatus.NOT_FOUND),
        INVALID_INPUT("A002", "Invalid Input", HttpStatus.BAD_REQUEST);

        private final String errorCode;
        private final String errorMessage;
        private final HttpStatus httpStatus;


        ErrorCodeConstants(String errorCode, String errorMessage, HttpStatus httpStatus) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
            this.httpStatus = httpStatus;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public HttpStatus getHttpStatus() {
            return httpStatus;
        }
    }
}
