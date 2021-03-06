package org.goodev.atm;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayDeque;
import java.util.Deque;

@Singleton
public final class CommandProcessor {
    private final Deque<CommandRouter> commandRouterStack = new ArrayDeque<>();

    @Inject
    CommandProcessor(CommandRouter firstCommandRouter) {
        commandRouterStack.push(firstCommandRouter);
    }

    Command.Status process(String input) {
        System.out.println("commandRouterStack size : " + commandRouterStack.size());
        CommandRouter router = commandRouterStack.peek();
        Command.Result result = router.route(input);
        System.out.println("first router " + router + " result " + result.status());
        if (result.status().equals(Command.Status.INPUT_COMPLETED)) {
            commandRouterStack.pop();
            return commandRouterStack.isEmpty()
                    ? Command.Status.INPUT_COMPLETED
                    : Command.Status.HANDLED;
        } else if (result.status().equals(Command.Status.INVALID)) {
            System.err.println("该命令非法！");
        }

        result.nestedCommandRouter().ifPresent(commandRouterStack::push);
        return result.status();
    }
}