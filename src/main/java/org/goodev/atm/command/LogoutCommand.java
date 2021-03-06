package org.goodev.atm.command;

import org.goodev.atm.Command;

import javax.inject.Inject;
import java.util.List;

public class LogoutCommand implements Command {

    @Inject
    public LogoutCommand() {
    }

    @Override
    public Result handleInput(List<String> input) {
        return input.isEmpty() ? Result.inputCompleted() : Result.invalid();
    }
}
