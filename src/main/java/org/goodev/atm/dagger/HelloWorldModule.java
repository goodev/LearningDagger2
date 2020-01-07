package org.goodev.atm.dagger;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import org.goodev.atm.Command;
import org.goodev.atm.HelloWorldCommand;
import org.goodev.atm.Outputter;

@Module
public abstract class HelloWorldModule {
    @Binds
    abstract Command helloWorldCommand(HelloWorldCommand cmd);

}
