package org.goodev.atm;

import java.util.List;
import java.util.Optional;

/**
 * 用来处理用户输入命令逻辑的接口。
 */
public interface Command {

    /**
     * 处理用户输入的其他参数
     */
    Result handleInput(List<String> input);

    /**
     * 命令处理的结果。包含处理的状态 {@link Status} 和一个可选的用来
     * 后续继续处理的 {@link CommandRouter}
     */
    final class Result {
        private final Status mStatus;
        private final Optional<CommandRouter> mNestedCommandRouter;

        private Result(Status status, Optional<CommandRouter> nestedCommandRouter) {
            mStatus = status;
            mNestedCommandRouter = nestedCommandRouter;
        }

        public static Result invalid() {
            return new Result(Status.INVALID, Optional.empty());
        }

        public static Result handled() {
            return new Result(Status.HANDLED, Optional.empty());
        }

        public static Result inputCompleted() {
            return new Result(Status.INPUT_COMPLETED, Optional.empty());
        }

        public static Result enterNestedCommandSet(CommandRouter nestedCommandRouter) {
            return new Result(Status.HANDLED, Optional.of(nestedCommandRouter));
        }

        public Status status() {
            return mStatus;
        }

        public Optional<CommandRouter> nestedCommandRouter() {
            return mNestedCommandRouter;
        }
    }

    enum Status {
        INVALID,
        HANDLED,
        INPUT_COMPLETED
    }
}
