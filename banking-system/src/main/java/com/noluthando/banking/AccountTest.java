package com.noluthando.banking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void depositShouldIncreaseBalance() {
        Account acc = new Account("Thando", 100);
        acc.deposit(50);

        assertEquals(150, acc.getBalance());
    }

    @Test
    void withdrawShouldDecreaseBalance() {
        Account acc = new Account("Thando", 100);
        acc.withdraw(40);

        assertEquals(60, acc.getBalance());
    }

    @Test
    void withdrawTooMuchShouldThrowError() {
        Account acc = new Account("Thando", 100);

        assertThrows(IllegalArgumentException.class, () -> {
            acc.withdraw(200);
        });
    }
    @Test
    void transferShouldMoveMoneyBetweenAccounts() {
        Account acc1 = new Account("Thando", 100);
        Account acc2 = new Account("Alex", 50);

        acc1.transfer(acc2, 40);

        assertEquals(60, acc1.getBalance());
        assertEquals(90, acc2.getBalance());
    }
}