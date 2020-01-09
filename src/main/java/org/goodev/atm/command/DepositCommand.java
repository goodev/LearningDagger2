package org.goodev.atm.command;

import org.goodev.atm.Database;
import org.goodev.atm.Outputter;
import org.goodev.atm.WithdrawalLimiter;

import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * 处理用户存款的操作
 */
public class DepositCommand extends BigDecimalCommand {
    private final Database.Account mAccount;
    private final Outputter mOutputter;
    private final WithdrawalLimiter mWithdrawalLimiter;

    @Inject
    public DepositCommand(Database.Account account, Outputter outputter, WithdrawalLimiter limiter) {
        super(outputter);
        System.err.println("创建 DepositCommand ：" + this);
        mAccount = account;
        mOutputter = outputter;
        mWithdrawalLimiter = limiter;
    }

    @Override
    protected void handleAmount(BigDecimal amount) {
        mAccount.deposit(amount);
        mWithdrawalLimiter.recordDeposit(amount);
        mOutputter.output(mAccount.username() + " 现在的余额是： " + mAccount.balance());
    }
}
