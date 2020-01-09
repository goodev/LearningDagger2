package org.goodev.atm.dagger;

import dagger.Binds;
import dagger.BindsOptionalOf;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.Multibinds;
import dagger.multibindings.StringKey;
import org.goodev.atm.Command;
import org.goodev.atm.Database;
import org.goodev.atm.HelloWorldCommand;
import org.goodev.atm.command.LoginCommand;

import java.util.Map;

@Module
public abstract class CommandsModule {
    @Binds
    @IntoMap
    @StringKey("hello")
    abstract Command helloWorldCommand(HelloWorldCommand cmd);

    @Binds
    @IntoMap
    @StringKey("登录")
    abstract Command loginCommand(LoginCommand command);

    // 如果没有上面的 IntoMap 定义，则需要定义个 Multibinds，告诉 dagger
    //    @Multibinds
    abstract Map<String, Command> commands();

    @BindsOptionalOf
    abstract Database.Account optionalAccount();

}
