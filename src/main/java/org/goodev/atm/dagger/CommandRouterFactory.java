package org.goodev.atm.dagger;

import dagger.Component;
import org.goodev.atm.CommandRouter;

@Component
public interface CommandRouterFactory {
    CommandRouter router();
}
