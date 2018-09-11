package tutorial07;

import java.time.LocalDate;

public class InternetAccount extends BankAccount {
	private int numTransactions;
	private LocalDate mostRecentMonth;
	private final int TRANSACTION_LIMIT = 10;

	public InternetAccount() {
		numTransactions = 0;
		mostRecentMonth = LocalDate.EPOCH;
	}

	/**
	 * Withdraws money.
	 * @param amount
	 * @precondition numTransactions < TRANSACTION_LIMIT && the super precond.
	 */
	@Override
	public boolean withdraw(int amount) throws InsufficientBalanceException { // I can't add more exceptions because Liskov-substitution principle.
		if (numTransactions < TRANSACTION_LIMIT || (mostRecentMonth.isAfter(LocalDate.now().minusMonths(1)))) {
			if (mostRecentMonth.isAfter(LocalDate.now().minusMonths(1))) {
				mostRecentMonth = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
			}
			if (super.withdraw(amount)) {
				++numTransactions;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return super.toString() + String.format(", NumTransactions: %d/%d", numTransactions, TRANSACTION_LIMIT);
	}

	public static void main(String[] args) {
		InternetAccount i = new InternetAccount();
		System.out.println(i);
		System.out.println(i.deposit(500));
		System.out.println(i);
		try {
			System.out.println(i.withdraw(20));
		} catch (InsufficientBalanceException e) {
			e.printStackTrace();
		}
		System.out.println(i);
		try {
			System.out.println(i.withdraw(500));
		} catch (InsufficientBalanceException e) {
			e.printStackTrace();
		}
		System.out.println(i);
	}
}