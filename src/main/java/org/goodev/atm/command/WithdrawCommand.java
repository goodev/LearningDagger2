package org.goodev.atm.command;

import org.goodev.atm.Database;
import org.goodev.atm.Outputter;

import javax.inject.Inject;
import java.math.BigDecimal;

public class WithdrawCommand extends BigDecimalCommand {
    private final Database.Account mAccount;
    private final Outputter mOutputter;

    @Inject
    public WithdrawCommand(Database.Account account, Outputter outputter) {
        super(outputter);
        System.err.println("创建 WithdrawCommand ：" + this);
        mAccount = account;
        mOutputter = outputter;
    }

    @Override
    protected void handleAmount(BigDecimal amount) {
        BigDecimal newBalance = mAccount.balance().subtract(amount);
        if (newBalance.signum() < 0) {
            // 取款后余额小于零，不能取款
            mOutputter.output(mAccount.username() + " 无法完成取款 " + amount + " 元， 您现在的余额是： " + mAccount.balance());
        } else {
            mAccount.withdraw(amount);
            mOutputter.output(mAccount.username() + " 现在的余额是： " + mAccount.balance());
        }
    }
}
