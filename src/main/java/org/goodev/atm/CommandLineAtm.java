package org.goodev.atm;

import java.util.Scanner;

/**
 * 虚拟的 ATM 机程序执行的入口。
 */
public class CommandLineAtm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandRouter commandRouter = new CommandRouter();

        while (scanner.hasNextLine()) {
            Command.Status status = commandRouter.route(scanner.nextLine());

        }
    }
}
