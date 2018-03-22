package com.anatolii.pozniak.validation.string_validations;

import com.anatolii.pozniak.validation.Validation;

public class StringLengthValidation implements Validation<String, String> {
    private String value;
    private String error;
    private int min;
    private int max;

    public StringLengthValidation(String value, String error, int min, int max) {
        this.value = value;
        this.error = error;
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean isValid() {
        return (value != null) &&
                (value.length() >= min && value.length() <= max);
    }

    @Override
    public String getError() {
        return error;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static class Builder {
        private String value;
        private String error;
        private int min;
        private int max;

        public Builder() {
            value = "";
            error = "";
            min = 1;
            max = 1;
        }

        public Builder setValue(String value) {
            this.value = value;
            return this;
        }

        public Builder setError(String error) {
            this.error = error;
            return this;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public Validation build() {
            return new StringLengthValidation(value, error, min, max);
        }
    }
}
