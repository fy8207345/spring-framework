package org.example.core.xml.method;

import lombok.ToString;

@ToString
public class Command {

    private Integer state;

    public Command() {
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
