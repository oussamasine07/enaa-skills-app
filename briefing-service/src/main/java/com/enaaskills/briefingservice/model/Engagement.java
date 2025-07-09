package com.enaaskills.briefingservice.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


public enum Engagement {

    BINOMIAL,
    TRINOMIAL,
    INDIVIDUAL;

    @JsonCreator
    public static Engagement fromString (String value) {
        try {
            return Engagement.valueOf(value.toUpperCase());
        }
        catch (Exception e) {
            return null;
        }
    }

    @JsonValue
    public String getValue() {
        return name();
    }

}
