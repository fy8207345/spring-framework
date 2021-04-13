package org.example.core.xml.setter;

public class Setter2 {

    private Setter1 setter1;

    public Setter2() {
    }

    public void setSetter1(Setter1 setter1) {
        this.setter1 = setter1;
    }

    @Override
    public String toString() {
        return "setter1 is null : " + (setter1 == null);
    }
}
