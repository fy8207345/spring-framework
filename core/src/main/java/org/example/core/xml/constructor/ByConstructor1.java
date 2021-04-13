package org.example.core.xml.constructor;

import lombok.ToString;

import java.beans.ConstructorProperties;

@ToString
public class ByConstructor1 {

    private String name;

    @ConstructorProperties({"name"})
    public ByConstructor1(String name) {
        this.name = name;
    }
}
