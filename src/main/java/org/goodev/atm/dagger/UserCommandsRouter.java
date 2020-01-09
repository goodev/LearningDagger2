package org.goodev.atm.dagger;

import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;
import org.goodev.atm.CommandRouter;
import org.goodev.atm.Database;

@Subcomponent(modules = UserCommandsModule.class)
public interface UserCommandsRouter {
    CommandRouter router();

    @Subcomponent.Factory
    interface Factory {
        UserCommandsRouter create(@BindsInstance Database.Account account);
    }

    @Module(subcomponents = UserCommandsRouter.class)
    interface InstallationModule {
    }
}
