package org.goodev.atm;

import java.util.List;

/**
 * 用来处理用户输入命令逻辑的接口。
 */
public interface Command {

    /**
     * 命令的名称，用来处理用户的输入，比如用户输入的 “存款”、“取款”等命令。
     *
     * @return 返回命令的名称。
     */
    String key();

    /**
     * 处理用户输入的其他参数
     */
    Status handleInput(List<String> input);

    enum Status{
        INVALID,
        HANDLED
    }
}
