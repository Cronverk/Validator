package com.anatolii.pozniak.validation.string_validations;

import com.anatolii.pozniak.validation.Validation;

import java.util.ArrayList;
import java.util.List;

public class ComplexValidation implements Validation<String, String> {
    private final List<Validation<String, String>> validationList;
    private String mValue;
    private String error = "";

    private ComplexValidation(Builder builder) {
        mValue = builder.mValue;
        validationList = builder.validationList;
    }

    public boolean isValid() {
        for (Validation<String, String> validation : validationList) {
            if (!validation.isValid()) {
                error = validation.getError();
                return false;
            }
        }
        return true;
    }

    @Override
    public void setValue(String value) {
        mValue = value;
    }

    public String getError() {
        return error;
    }

    @Override
    public String getValue() {
        return mValue;
    }

    public static class Builder {

        private final String mValue;
        private final List<Validation<String, String>> validationList;

        public Builder(String value) {
            validationList = new ArrayList();
            mValue = value;
        }

        public Builder addValidation(Validation<String, String> validation) {
            validation.setValue(mValue);
            validationList.add(validation);
            return this;
        }

        public ComplexValidation build() {
            return new ComplexValidation(this);
        }
    }
}
