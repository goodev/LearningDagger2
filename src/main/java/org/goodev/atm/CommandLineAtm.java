package org.goodev.atm;

import org.goodev.atm.dagger.CommandRouterFactory;
import org.goodev.atm.dagger.DaggerCommandRouterFactory;

import java.util.Scanner;

/**
 * 虚拟的 ATM 机程序执行的入口。
 */
public class CommandLineAtm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //DaggerCommandRouterFactory 类有 Dagger 自动生成
        CommandRouterFactory factory = DaggerCommandRouterFactory.create();
        // 由 Dagger 来提供 CommandRouter 对象
        CommandRouter commandRouter = factory.router();

        while (scanner.hasNextLine()) {
            Command.Status status = commandRouter.route(scanner.nextLine());

        }
    }
}
