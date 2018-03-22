package com.anatolii.pozniak.validation.string_validations;

import com.anatolii.pozniak.validation.Validation;

import java.util.regex.Pattern;

public class StringPatternValidation implements Validation<String, String> {

    private String value;
    private String error;
    private String pattern;

    public StringPatternValidation(String value, String error, String pattern) {
        this.value = value;
        this.error = error;
        this.pattern = pattern;
    }

    @Override
    public boolean isValid() {
        return Pattern.matches(pattern, value);
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

    public class Builder {
        private String value;
        private String error;
        private String pattern;

        public Builder() {
            value = "";
            error = "";
            pattern = "";
        }

        public Builder setValue(String value) {
            this.value = value;
            return this;
        }

        public Builder setError(String error) {
            this.error = error;
            return this;
        }

        public Builder setPattern(String pattern) {
            this.pattern = pattern;
            return this;
        }

        public Validation build() {
            return new StringPatternValidation(value, error, pattern);
        }
    }
}
