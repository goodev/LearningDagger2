package org.goodev.atm.command;

import org.goodev.atm.Command;

import java.util.List;

/**
 * 一个只接受单个参数的命令处理抽象类
 */
public abstract class SingleArgCommand implements Command {

    @Override
    public final Result handleInput(List<String> input) {
        return input.size() == 1 ? handleArg(input.get(0)) : Result.invalid();
    }

    /**
     * 命令用来处理单个输入的参数
     */
    protected abstract Result handleArg(String arg);
}
