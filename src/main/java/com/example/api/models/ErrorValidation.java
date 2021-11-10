package com.example.api.models;

public class ErrorValidation {
    private String input;
    private  String error;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ErrorValidation(String input, String error) {
        this.input = input;
        this.error = error;
    }
}
