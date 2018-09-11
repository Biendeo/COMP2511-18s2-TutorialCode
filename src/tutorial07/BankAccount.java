package tutorial07;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class BankAccount {
	private int balance;
	private int todayWithdrawalAmount;
	private LocalDate lastWithdrawalDate;
	private final int WITHDRAWAL_LIMIT = 800;

	public BankAccount() {
		balance = 0;
		todayWithdrawalAmount = 0;
		lastWithdrawalDate = LocalDate.EPOCH;
	}

	/**
	 * Deposit some money.
	 * @param amount
	 * @precondition amount >= 0
	 * @postcondition balance = balance + amount
	 */
	public boolean deposit(int amount) {
		if (amount >= 0) {
			balance += amount;
			return true;
		} else {
			throw new IllegalArgumentException("amount was negative!");
			//return false;
		}
	}

	/**
	 * Withdraw some money.
	 * @param amount
	 * @precondition amount >= 0 && balance >= amount && todayWithdrawalAmount + amount <= WITHDRAWAL_LIMIT
	 * @postcondition balance = balance - amount && lastWithdrawalDate = today
	 */
	public boolean withdraw(int amount) throws InsufficientBalanceException {
		// You must have a positive amount, and enough balance to withdraw. If you can withdraw enough to be under the
		// limit OR if it's a new day and you aren't already exceeding the limit, you can withdraw.
		if (amount > balance) {
			throw new InsufficientBalanceException("YOu don't have money.");
		}
		if (amount >= 0 && balance >= amount && (todayWithdrawalAmount + amount <= WITHDRAWAL_LIMIT || lastWithdrawalDate != LocalDate.now() && amount <= WITHDRAWAL_LIMIT)) {
			balance -= amount;
			todayWithdrawalAmount += amount;
			// Resets
			if (lastWithdrawalDate == LocalDate.now()) {
				todayWithdrawalAmount = amount;
			}
			lastWithdrawalDate = LocalDate.now();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return String.format("Balance: $%d, WithdrawalLimit: $%d/$%d", balance, todayWithdrawalAmount, WITHDRAWAL_LIMIT);
	}

	public static void main(String[] args) {
		BankAccount b = new BankAccount();
		System.out.println(b);
		System.out.println(b.deposit(500));
		System.out.println(b);
		try {
			System.out.println(b.withdraw(20));
		} catch (InsufficientBalanceException e) {
			e.printStackTrace();
		}
		System.out.println(b);
		try {
			System.out.println(b.withdraw(500));
		} catch (InsufficientBalanceException e) {
			e.printStackTrace();
		}
		System.out.println(b);
	}

	@Test
	public void testDeposit() {
		BankAccount b = new BankAccount();
		assertEquals(b.balance, 0);
		b.deposit(50);
		assertEquals(b.balance, 50);
	}
}
