package org.goodev.atm.dagger;

import dagger.Binds;
import dagger.BindsOptionalOf;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import org.goodev.atm.Command;
import org.goodev.atm.Database;
import org.goodev.atm.command.LoginCommand;

@Module
public abstract class LoginCommandModule {
    @Binds
    @IntoMap
    @StringKey("登录")
    abstract Command loginCommand(LoginCommand command);

    @BindsOptionalOf
    abstract Database.Account optionalAccount();
}
