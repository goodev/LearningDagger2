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

    @Provides
    static Outputter textOutputterLambda() {
        return System.err::println;
    }

    // 上面的实现是 Java Lambda 表达式的方法引用方式。所以代码看起来比较简单。
    // 和下面的实现方式是一样的效果。 可以把光标放到下方的 new 关键字的地方，
    // 然后右方会出现一个小灯泡提示，点击小灯泡然后选择“Replace with method reference”
    // 选项 IDE 就会把下面的实现重构为上面的方法引用。
    static Outputter textOutputterNoLambda() {
        return new Outputter() {
            @Override
            public void output(String out) {
                System.out.println(out);
            }
        };
    }
}
