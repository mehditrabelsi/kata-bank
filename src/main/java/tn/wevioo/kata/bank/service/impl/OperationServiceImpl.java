package tn.wevioo.kata.bank.service.impl;

import tn.wevioo.kata.bank.entities.Account;
import tn.wevioo.kata.bank.entities.Operation;
import tn.wevioo.kata.bank.entities.TypeOperation;
import tn.wevioo.kata.bank.exception.AccountNotFoundException;
import tn.wevioo.kata.bank.exception.AmountLowerThanBalance;
import tn.wevioo.kata.bank.exception.AmountMinMaxValueException;
import tn.wevioo.kata.bank.service.OperationService;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

/**
 * Impl Service of operation
 *
 * @author Mehdi
 * @see OperationService for more informations about methods
 * @since 10 septembre 2017
 */
public class OperationServiceImpl implements OperationService {

    private static final Logger logger = Logger.getLogger("MyLog");
    private static final double MIN_VALUE = 0;
    private static final double MAX_VALUE = 9999999;

    /**
     * Deposit amount in the Account
     *
     * @param account the user account
     * @param amount  the amount to save
     * @return
     * @throws AccountNotFoundException
     * @throws AmountMinMaxValueException
     */
    @SuppressWarnings("unused")
    @Override
    public boolean deposit(Account account, double amount) throws AccountNotFoundException, AmountMinMaxValueException {

        logger.info("deposit : " + account.toString() + " | amount : " + amount);

        // Check if the account object is NULL
        if (account == null) {
            throw new AccountNotFoundException("There is no account !");
        }

        // the amount must be positive
        if (amount <= MIN_VALUE || amount > MAX_VALUE) {
            throw new AmountMinMaxValueException("The entered amount should be greater than " + MIN_VALUE + " and less than " + MAX_VALUE);
        } else { // if the amount is valid, let's do the operation
            Operation operation = new Operation();
            account.setBalance(account.getBalance() + amount);

            // Auto-increment NumOperation
            operation.setNumOperation(account.getOperations().size() + 1);
            operation.setAmount(amount);
            operation.setBalance(account.getBalance());
            operation.setDate(LocalDate.now());
            operation.setType(TypeOperation.Deposit);

            // save operation in account history
            account.getOperations().add(operation);

            return true;
        }
    }

    /**
     * Withdrawn amount from the Account
     *
     * @param account the user account
     * @param amount  the amount to be withdrawn
     * @return
     * @throws AccountNotFoundException
     * @throws AmountLowerThanBalance
     * @throws AmountMinMaxValueException
     */
    @SuppressWarnings("unused")
    @Override
    public boolean retrive(Account account, double amount) throws AccountNotFoundException, AmountLowerThanBalance, AmountMinMaxValueException {

        logger.info("retrive : " + account.toString() + " | amount : " + amount);

        // testing if the account is NULL
        if (account == null) {
            throw new AccountNotFoundException("There is no account !");
        }

        // the amount should be lower than account's balance
        if (amount > account.getBalance()) {
            throw new AmountLowerThanBalance("Please introduce an amount lower than your balance : <" + account.getBalance());
        } else if (amount <= MIN_VALUE || amount > MAX_VALUE) { // the amount should be positive
            throw new AmountMinMaxValueException("The entered amount should be greater than " + MIN_VALUE + " and less than " + MAX_VALUE);
        } else { // if the amount is valid, let's do the operation
            Operation operation = new Operation();
            account.setBalance(account.getBalance() - amount);

            // Auto-increment NumOperation
            operation.setNumOperation(account.getOperations().size() + 1);
            operation.setAmount(amount);
            operation.setBalance(account.getBalance());
            operation.setDate(LocalDate.now());
            operation.setType(TypeOperation.Withdrawal);

            // save operation in account history
            account.getOperations().add(operation);

            return true;
        }
    }

    /**
     * Display Account history
     *
     * @param account the user account
     * @throws AccountNotFoundException
     */
    @SuppressWarnings("unused")
	@Override
    public void history(Account account) throws AccountNotFoundException {
        logger.info("history : " + account.toString());
        // testing if the account is NULL
        if (account == null) {
            throw new AccountNotFoundException("There is no account !");
        }
        List<Operation> allOperations = account.getOperations();
        logger.info("* * * * * * * * H I S T O R Y * * * * * * * *");
        logger.info("Num | Operation type | Date      | Amount  | Balance   ");
        allOperations.stream().forEach(
                operation -> {
                    logger.info(operation.getNumOperation() + "   | "
                            + operation.getType() + "        | "
                            + operation.getDate() + "| "
                            + operation.getAmount() + "    | "
                            + operation.getBalance());
                });
    }
}
