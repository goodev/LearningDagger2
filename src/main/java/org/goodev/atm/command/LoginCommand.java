package org.goodev.atm.command;

import dagger.Lazy;
import org.goodev.atm.Database;
import org.goodev.atm.Outputter;
import org.goodev.atm.dagger.UserCommandsRouter;

import javax.inject.Inject;
import java.util.Optional;

public class LoginCommand extends SingleArgCommand {
    private final Outputter mOutputter;
    private final Lazy<Database> mDatabase;
    private final UserCommandsRouter.Factory mFactory;
    private final Optional<Database.Account> mAccount;

    @Inject
    public LoginCommand(Outputter outputter, Lazy<Database> database, UserCommandsRouter.Factory factory,
                        Optional<Database.Account> account) {
        System.err.println("创建 LoginCommand ：" + this);
        mOutputter = outputter;
        mDatabase = database;
        mFactory = factory;
        mAccount = account;
    }

    @Override
    protected Result handleArg(String username) {
        System.out.println("LoginCommand handleArg ：" + this);
        if (mAccount.isPresent()) {
            mOutputter.output(mAccount.get().username() + " 已经登录了。");
            return Result.handled();
        }
        Database.Account account = mDatabase.get().getAccount(username);
        mOutputter.output(username + " 已登录。账号余额为 " + account.balance());
        return Result.enterNestedCommandSet(mFactory.create(account).router());
    }


}
