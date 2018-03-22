package com.anatolii.pozniak.validation.string_validations;

import com.anatolii.pozniak.validation.Validation;

public class StringEmptyValidation implements Validation<String, String> {
    private String value;
    private String error;

    public StringEmptyValidation(String value, String error) {
        this.value = value;
        this.error = error;
    }

    @Override
    public boolean isValid() {
        return (value != null && !value.isEmpty());
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getError() {
        return error;
    }

    @Override
    public String getValue() {
        return value;
    }
//
//    public static class Builder {
//        private String value;
//        private String error;
//
//        public Builder() {
//            value = "";
//            error = "";
//        }
//
//        public Builder setValue(String value) {
//            this.value = value;
//            return this;
//        }
//
//        public Builder setError(String error) {
//            this.error = error;
//            return this;
//        }
//
//        public Validation build() {
//            return new StringEmptyValidation(value, error);
//        }
//    }
}
