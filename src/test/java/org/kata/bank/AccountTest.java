package org.kata.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class AccountTest {
    // US1 : In order to save money As a bank cleint I want to make a deposit in my account
    @Test
    void deposit1000ShouldBeRetainedInBalance1000() {
        Account account = new Account();
        account.deposit(1000);
        assertThat(account.balance).isEqualTo(1000);
    }

    @Test
    void multipleDepositShouldBeRetainedInBalance() {
        Account account = new Account();
        account.deposit(1000);
        account.deposit(1000);
        account.deposit(2000);
        assertThat(account.balance).isEqualTo(4000);
    }

    @Test
    void deposit0ShouldThrowIllegalException() {
        Account account = new Account();
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> account.deposit(0));
    }

    @Test
    void depositNegativeAmountShouldThrowIllegalException() {
        Account account = new Account();
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> account.deposit(-1000));
    }

    //US2: In order to retreive some or all my savings As a bank client I want to make a withdraw from my account
    @Test
    void withdrawnAmountShouldBeDeductedFromCurrentBalance() {
        //given
        Account account = new Account();
        account.deposit(2000);
        //when
        account.withdraw(1000);
        //then
        assertThat(account.balance).isEqualTo(1000);
    }

    @Test
    void withdrawZeroShouldThrowIllegalException() {
        Account account = new Account();
        account.deposit(2000);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> account.withdraw(0));
    }

    @Test
    void withdrawNegativeAmountShouldThrowIllegalException() {
        Account account = new Account();
        account.deposit(2000);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> account.withdraw(-1000));
    }

    @Test
    void withdrawnAmountShouldBeLowerThanAmountInBalance() {
        Account account = new Account();
        account.deposit(2000);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> account.withdraw(3000));
    }
}
