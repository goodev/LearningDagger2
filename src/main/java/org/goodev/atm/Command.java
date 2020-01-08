package org.goodev.atm;

import java.util.List;

/**
 * 用来处理用户输入命令逻辑的接口。
 */
public interface Command {

    /**
     * 处理用户输入的其他参数
     */
    Status handleInput(List<String> input);

    enum Status{
        INVALID,
        HANDLED
    }
}
