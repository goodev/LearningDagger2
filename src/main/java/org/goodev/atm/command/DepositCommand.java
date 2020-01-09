package org.goodev.atm.command;

import org.goodev.atm.Command;
import org.goodev.atm.Database;
import org.goodev.atm.Outputter;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

/**
 * 处理用户存款的操作
 */
public class DepositCommand implements Command {
    private final Database.Account mAccount;
    private final Outputter mOutputter;

    @Inject
    public DepositCommand(Database.Account account, Outputter outputter) {
        System.err.println("创建 DepositCommand ：" + this);
        mAccount = account;
        mOutputter = outputter;
    }

    @Override
    public Result handleInput(List<String> input) {
        if (input.size() != 1) {
            return Result.invalid();
        }
        mAccount.deposit(new BigDecimal(input.get(0)));
        mOutputter.output(mAccount.username() + " 现在的余额是： " + mAccount.balance());
        return Result.handled();
    }
}
