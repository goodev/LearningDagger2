package org.goodev.atm.dagger;

import dagger.Component;
import org.goodev.atm.CommandProcessor;

import javax.inject.Singleton;

@Singleton
@Component(modules = {CommandsModule.class, SystemOutModule.class, UserCommandsRouter.InstallationModule.class})
public interface CommandProcessorFactory {
    CommandProcessor processor();
}
