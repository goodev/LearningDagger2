package org.goodev.atm.command;

import org.goodev.atm.Database;
import org.goodev.atm.Outputter;
import org.goodev.atm.dagger.UserCommandsRouter;

import javax.inject.Inject;

public class LoginCommand extends SingleArgCommand {
    private final Outputter mOutputter;
    private final Database mDatabase;
    private final UserCommandsRouter.Factory mFactory;

    @Inject
    public LoginCommand(Outputter outputter, Database database, UserCommandsRouter.Factory factory) {
        System.err.println("创建 LoginCommand ：" + this);
        mOutputter = outputter;
        mDatabase = database;
        mFactory = factory;
    }

    @Override
    protected Result handleArg(String username) {
        Database.Account account = mDatabase.getAccount(username);
        mOutputter.output(username + " 已登录。账号余额为 " + account.balance());
        return Result.enterNestedCommandSet(mFactory.create(account).router());
    }


}
