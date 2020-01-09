package org.goodev.atm.dagger;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import org.goodev.atm.Command;
import org.goodev.atm.command.DepositCommand;
import org.goodev.atm.command.LogoutCommand;
import org.goodev.atm.command.WithdrawCommand;

import java.math.BigDecimal;

@Module
public abstract class UserCommandsModule {

    @Binds
    @IntoMap
    @StringKey("存款")
    abstract Command depositCommand(DepositCommand command);

    @Binds
    @IntoMap
    @StringKey("取款")
    abstract Command withdrawCommand(WithdrawCommand command);

    @Binds
    @IntoMap
    @StringKey("退出")
    abstract Command logoutCommand(LogoutCommand command);


    @Provides
    @MinimumBalance
    static BigDecimal minimumBalance() {
        return BigDecimal.ZERO;
    }


    @Provides
    @MaximumWithdraw
    static BigDecimal maximumWithdrawal() {
        return new BigDecimal(3000);
    }

}
