package org.goodev.atm.dagger;

import dagger.Binds;
import dagger.Module;
import org.goodev.atm.Command;
import org.goodev.atm.command.LoginCommand;

@Module
public abstract class LoginCommandModule {
    @Binds
    abstract Command loginCommand(LoginCommand command);
}
