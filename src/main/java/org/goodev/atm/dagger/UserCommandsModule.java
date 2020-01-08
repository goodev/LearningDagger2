package org.goodev.atm.dagger;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import org.goodev.atm.Command;
import org.goodev.atm.command.DepositCommand;

@Module
public abstract class UserCommandsModule {

    @Binds
    @IntoMap
    @StringKey("存款")
    abstract Command depositCommand(DepositCommand command);
}