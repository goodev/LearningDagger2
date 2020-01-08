package org.goodev.atm;

import org.goodev.atm.dagger.CommandProcessorFactory;
import org.goodev.atm.dagger.DaggerCommandProcessorFactory;

import java.util.Scanner;

/**
 * 虚拟的 ATM 机程序执行的入口。
 */
public class CommandLineAtm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CommandProcessorFactory factory = DaggerCommandProcessorFactory.create();
        CommandProcessor commandProcessor = factory.processor();

        while (scanner.hasNextLine()) {
            Command.Status status = commandProcessor.process(scanner.nextLine());

        }
    }
}
