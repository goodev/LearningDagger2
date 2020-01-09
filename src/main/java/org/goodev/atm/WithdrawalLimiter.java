package org.goodev.atm;

import org.goodev.atm.dagger.MaximumWithdraw;

import javax.inject.Inject;
import java.math.BigDecimal;

public final class WithdrawalLimiter {
    private BigDecimal mRemainingLimit;

    @Inject
    public WithdrawalLimiter(@MaximumWithdraw BigDecimal maxLimit) {
        System.err.println("创建 WithdrawalLimiter ：" + this);
        mRemainingLimit = maxLimit;
    }

    public void recordDeposit(BigDecimal amount) {
        mRemainingLimit = mRemainingLimit.add(amount);
    }

    public void recordWithdrawal(BigDecimal amount) {
        mRemainingLimit = mRemainingLimit.subtract(amount);
    }

    public BigDecimal remainingWithdrawalLimit() {
        return mRemainingLimit;
    }
}
