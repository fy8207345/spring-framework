package org.example.core.method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Lookup;

public abstract class CommandManager {

    public Object process(Integer state){
        Command command = createCommand();
        command.setState(state);
        return command;
    }

    @Lookup
    protected abstract Command createCommand();
}
