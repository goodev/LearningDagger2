package org.goodev.atm;

import javax.inject.Inject;
import java.util.List;

/**
 * 一个简单的 hello world 命令， 命令的名称为“hello”，命令的功能为在控制台输出“world!”
 */
public final class HelloWorldCommand implements Command {
    private final Outputter mOutputter;

    @Inject
    HelloWorldCommand(Outputter outputter) {
        mOutputter = outputter;
    }

    @Override
    public Status handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Status.INVALID;
        }
        mOutputter.output("world!");
        return Status.HANDLED;
    }
}