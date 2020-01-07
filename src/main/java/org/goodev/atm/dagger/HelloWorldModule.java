package org.goodev.atm.dagger;

import dagger.Binds;
import dagger.Module;
import org.goodev.atm.Command;
import org.goodev.atm.HelloWorldCommand;

@Module
public abstract class HelloWorldModule {
    @Binds
    abstract Command helloWorldCommand(HelloWorldCommand cmd);
}
