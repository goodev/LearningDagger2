package org.goodev.atm.dagger;

import dagger.Component;
import org.goodev.atm.CommandRouter;

@Component(modules = {HelloWorldModule.class, SystemOutModule.class})
public interface CommandRouterFactory {
    CommandRouter router();
}
