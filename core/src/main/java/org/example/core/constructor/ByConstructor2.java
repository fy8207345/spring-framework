package org.example.core.constructor;

import lombok.ToString;

import java.beans.ConstructorProperties;

@ToString
public class ByConstructor2 {

    private ByConstructor1 byConstructor1;

    @ConstructorProperties({"byConstructor1"})
    public ByConstructor2(ByConstructor1 byConstructor1) {
        this.byConstructor1 = byConstructor1;
    }
}
