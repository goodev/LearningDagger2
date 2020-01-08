package org.goodev.atm.command;

import org.goodev.atm.Outputter;

import javax.inject.Inject;

public class LoginCommand extends SingleArgCommand {
    private final Outputter mOutputter;

    @Inject
    public LoginCommand(Outputter mOutputter) {
        this.mOutputter = mOutputter;
    }

    @Override
    public String key() {
        return "登录";
    }

    @Override
    protected Status handleArg(String username) {
        mOutputter.output(username + " 已登录。");
        return Status.HANDLED;
    }


}
