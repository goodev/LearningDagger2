package org.goodev.atm.command;

import org.goodev.atm.Database;
import org.goodev.atm.Outputter;
import org.goodev.atm.WithdrawalLimiter;
import org.goodev.atm.dagger.MaximumWithdraw;
import org.goodev.atm.dagger.MinimumBalance;

import javax.inject.Inject;
import java.math.BigDecimal;

public class WithdrawCommand extends BigDecimalCommand {
    private final Database.Account mAccount;
    private final Outputter mOutputter;
    private final BigDecimal mMinBalance;
    private final WithdrawalLimiter mWithdrawalLimiter;

    @Inject
    public WithdrawCommand(Database.Account account, Outputter outputter,
                           @MinimumBalance BigDecimal minimumBalance,
                           WithdrawalLimiter limiter) {
        super(outputter);
        System.err.println("创建 WithdrawCommand ：" + this);
        mAccount = account;
        mOutputter = outputter;
        mMinBalance = minimumBalance;
        mWithdrawalLimiter = limiter;
    }

    @Override
    protected void handleAmount(BigDecimal amount) {
        BigDecimal remainingLimit = mWithdrawalLimiter.remainingWithdrawalLimit();
        if (amount.compareTo(remainingLimit) > 0) {
            mOutputter.output("取款额度超过限制，一次最多只能取款 " + amount + " 元");
            return;
        }
        BigDecimal newBalance = mAccount.balance().subtract(amount);
        if (newBalance.compareTo(mMinBalance) < 0) {
            // 取款后余额不满足最低额度要求，不能取款
            mOutputter.output(mAccount.username() + " 无法完成取款 " + amount + " 元， 您现在的余额是： " + mAccount.balance() + "，账号最低余额要求不少于： " + mMinBalance);
        } else {
            mAccount.withdraw(amount);
            mWithdrawalLimiter.recordWithdrawal(amount);
            mOutputter.output(mAccount.username() + " 现在的余额是： " + mAccount.balance());
        }
    }
}
