package org.goodev.atm;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Database {

    private final Map<String, Account> mAccounts = new HashMap<>();

    @Inject
    public Database() {
    }

    public Account getAccount(String name) {
        return mAccounts.computeIfAbsent(name, Account::new);
    }


    public static final class Account {
        private final String username;
        private BigDecimal balance = BigDecimal.ZERO;

        public Account(String username) {
            this.username = username;
        }

        public String username() {
            return username;
        }

        public BigDecimal balance() {
            return balance;
        }

        public void deposit(BigDecimal amount) {
            balance = balance.add(amount);
        }
    }
}
