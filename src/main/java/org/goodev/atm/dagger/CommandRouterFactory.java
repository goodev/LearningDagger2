package org.goodev.atm.dagger;

import dagger.Component;
import org.goodev.atm.CommandRouter;

@Component(modules = {LoginCommandModule.class, HelloWorldModule.class, SystemOutModule.class,UserCommandsModule.class})
public interface CommandRouterFactory {
    CommandRouter router();
}
