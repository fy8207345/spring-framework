package org.example.core.setter;

import lombok.ToString;

public class Setter1 {

    private Setter2 setter2;

    public Setter1() {
    }

    public void setSetter2(Setter2 setter2) {
        this.setter2 = setter2;
    }

    @Override
    public String toString() {
        return "setter2 is null : " + (setter2 == null);
    }
}
