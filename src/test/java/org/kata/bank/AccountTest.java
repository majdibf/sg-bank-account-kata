package org.kata.bank;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class AccountTest {
    // US1 : In order to save money As a bank cleint I want to make a deposit in my account
    @Test
    void deposit1000ShouldBeRetainedInBalance1000() {
        Account account = new Account();
        account.deposit(1000);
        assertThat(account.getBalance()).isEqualTo(1000);
    }

    @Test
    void multipleDepositShouldBeRetainedInBalance() {
        Account account = new Account();
        account.deposit(1000);
        account.deposit(1000);
        account.deposit(2000);
        assertThat(account.getBalance()).isEqualTo(4000);
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

    //    //US2: In order to retreive some or all my savings As a bank client I want to make a withdraw from my account
    @Test
    void withdrawnAmountShouldBeDeductedFromCurrentBalance() {
        //given
        Account account = new Account();
        account.deposit(2000);
        //when
        account.withdraw(1000);
        //then
        assertThat(account.getBalance()).isEqualTo(1000);
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

    //US3: In order to check my operation As a bank client I want to see the history(operation, date, amount, balance) of my operations
    @Test
    void showHistoryShouldPrintExpectedHistory() {
        //given
        Account account = new Account();
        account.deposit(5000);
        account.withdraw(1000);
        account.withdraw(1000);
        account.deposit(700);
        String dateAsString = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        //when
        List<String> historyLines = new ArrayList<>();
        account.showHistory(historyLines::add);
        //then
        assertThat(historyLines.get(0)).isEqualTo("| Operation | Date | Amount | Balance |");
        assertThat(historyLines.get(1)).isEqualTo("| DEPOSIT | " + dateAsString + " | 5000.0 | 5000.0 |");
        assertThat(historyLines.get(2)).isEqualTo("| WITHDRAW | " + dateAsString + " | -1000.0 | 4000.0 |");
        assertThat(historyLines.get(3)).isEqualTo("| WITHDRAW | " + dateAsString + " | -1000.0 | 3000.0 |");
        assertThat(historyLines.get(4)).isEqualTo("| DEPOSIT | " + dateAsString + " | 700.0 | 3700.0 |");
    }
}
