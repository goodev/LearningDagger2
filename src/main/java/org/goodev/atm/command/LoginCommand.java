package org.goodev.atm.command;

import org.goodev.atm.Database;
import org.goodev.atm.Outputter;

import javax.inject.Inject;

public class LoginCommand extends SingleArgCommand {
    private final Outputter mOutputter;
    private final Database mDatabase;

    @Inject
    public LoginCommand(Outputter outputter, Database database){
        mOutputter = outputter;
        mDatabase = database;
    }

    @Override
    protected Status handleArg(String username) {
        Database.Account account = mDatabase.getAccount(username);
        mOutputter.output(username + " 已登录。账号余额为 "+account.balance());
        return Status.HANDLED;
    }


}
