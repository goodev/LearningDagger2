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
    private final Database mDatabase;
    private final Outputter mOutputter;

    @Inject
    public DepositCommand(Database database, Outputter outputter) {
        System.err.println("创建 DepositCommand ："+this);
        mDatabase = database;
        mOutputter = outputter;
    }

    @Override
    public Status handleInput(List<String> input) {
        if (input.size() != 2) {
            return Status.INVALID;
        }
        Database.Account account = mDatabase.getAccount(input.get(0));
        account.deposit(new BigDecimal(input.get(1)));
        mOutputter.output(account.username() + " 现在的余额是： " + account.balance());
        return Status.HANDLED;
    }
}
