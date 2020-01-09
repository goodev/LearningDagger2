package org.goodev.atm.command;

import org.goodev.atm.Database;
import org.goodev.atm.Outputter;

import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * 处理用户存款的操作
 */
public class DepositCommand extends BigDecimalCommand {
    private final Database.Account mAccount;
    private final Outputter mOutputter;

    @Inject
    public DepositCommand(Database.Account account, Outputter outputter) {
        super(outputter);
        System.err.println("创建 DepositCommand ：" + this);
        mAccount = account;
        mOutputter = outputter;
    }

    @Override
    protected void handleAmount(BigDecimal amount) {
        mAccount.deposit(amount);
        mOutputter.output(mAccount.username() + " 现在的余额是： " + mAccount.balance());
    }
}
