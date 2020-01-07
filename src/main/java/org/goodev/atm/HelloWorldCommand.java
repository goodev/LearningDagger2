package org.goodev.atm;

import javax.inject.Inject;
import java.util.List;

/**
 * 一个简单的 hello world 命令， 命令的名称为“hello”，命令的功能为在控制台输出“world!”
 */
public final class HelloWorldCommand implements Command {

    @Inject
    HelloWorldCommand() {}

    @Override
    public String key() {
        return "hello";
    }

    @Override
    public Status handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Status.INVALID;
        }
        System.out.println("world!");
        return Status.HANDLED;
    }
}