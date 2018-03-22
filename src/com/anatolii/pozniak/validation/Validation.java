package com.anatolii.pozniak.validation;

public interface Validation<T, E> {
    boolean isValid();

    void setValue(T value);

    E getError();

    T getValue();
}
