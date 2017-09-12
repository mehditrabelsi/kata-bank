package tn.wevioo.kata.bank.service;

import tn.wevioo.kata.bank.entities.Account;
import tn.wevioo.kata.bank.exception.AccountNotFoundException;
import tn.wevioo.kata.bank.exception.AmountLowerThanBalance;
import tn.wevioo.kata.bank.exception.AmountMinMaxValueException;

/**
 * Interface of operation service
 *
 * @author Mehdi
 * @since 10 septembre 2017
 */
public interface OperationService {

    /**
     * To make a deposit in the account
     *
     * @param account the user account
     * @param amount  the amount to save
     * @return true if the deposit succeeded
     * @throws AccountNotFoundException
     * @throws AmountMinMaxValueException
     */
    public boolean deposit(Account account, double amount) throws AccountNotFoundException, AmountMinMaxValueException;

    /**
     * To make a withdrawal for the account
     *
     * @param account the user account
     * @param amount  the amount to be withdrawn
     * @return true if the withdrawal succeeded
     * @throws AccountNotFoundException
     * @throws AmountLowerThanBalance
     * @throws AmountMinMaxValueException
     */
    public boolean retrive(Account account, double amount) throws AccountNotFoundException, AmountLowerThanBalance, AmountMinMaxValueException;

    /**
     * To print operations history for the account
     *
     * @param account the user account
     * @throws AccountNotFoundException
     */
    public void history(Account account) throws AccountNotFoundException;
}
