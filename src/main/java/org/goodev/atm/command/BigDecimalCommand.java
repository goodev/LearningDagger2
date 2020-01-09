package org.goodev.atm.command;

import org.goodev.atm.Outputter;

import java.math.BigDecimal;

public abstract class BigDecimalCommand extends SingleArgCommand {
    private final Outputter mOutputter;

    public BigDecimalCommand(Outputter outputter) {
        mOutputter = outputter;
    }

    @Override
    protected final Result handleArg(String arg) {
        BigDecimal amount = tryParse(arg);
        if (amount == null) {
            mOutputter.output("参数 " + arg + " 不是一个合法的数字");
        } else if (amount.signum() <= 0) {
            mOutputter.output("数字必须为正数");
        } else {
            handleAmount(amount);
        }
        return Result.handled();
    }

    private static BigDecimal tryParse(String arg) {
        try {
            return new BigDecimal(arg);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * 处理用户输入的金额
     */
    protected abstract void handleAmount(BigDecimal amount);
}
