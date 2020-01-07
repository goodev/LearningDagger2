package org.goodev.atm;

import javax.inject.Inject;
import java.util.*;

/**
 * 管理所有命令，并根据用户输入来选择对应的类来处理。
 */
public final class CommandRouter {

    private final Map<String, Command> commands = new HashMap<>();

    @Inject
    public CommandRouter(Command command) {
        commands.put(command.key(), command);
    }

    Command.Status route(String input) {
        List<String> splitInput = split(input);
        if (splitInput.isEmpty()) {
            return invalidCommand(input);
        }

        String commandKey = splitInput.get(0);
        Command command = commands.get(commandKey);
        if (command == null) {
            return invalidCommand(input);
        }

        Command.Status status = command.handleInput(splitInput.subList(1, splitInput.size()));
        if (status == Command.Status.INVALID) {
            System.out.println(commandKey + ": 命令参数不合法");
        }
        return status;
    }

    private Command.Status invalidCommand(String input) {
        String text = String.format("无法处理 \"%s\" 命令。请重试！", input);
        System.out.println(text);
        return Command.Status.INVALID;
    }

    // Split on whitespace
    private static List<String> split(String input) {
        return Arrays.asList(input.trim().split("\\s+"));
    }
}