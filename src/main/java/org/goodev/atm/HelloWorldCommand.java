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
        System.err.println("创建 HelloWorldCommand " + this);
        mOutputter = outputter;
    }

    @Override
    public Result handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Result.invalid();
        }
        mOutputter.output("world!");
        return Result.handled();
    }
}