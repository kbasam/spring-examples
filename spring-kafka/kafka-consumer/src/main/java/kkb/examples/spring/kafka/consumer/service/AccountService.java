package kkb.examples.spring.kafka.consumer.service;

import kkb.examples.spring.kafka.dto.Account;
import kkb.examples.spring.kafka.dto.AccountId;
import kkb.examples.spring.kafka.events.CreateAccountAsyncEvent;
import kkb.examples.spring.kafka.events.DeleteAccountAsyncEvent;
import kkb.examples.spring.kafka.events.DepositAccountAsyncEvent;
import kkb.examples.spring.kafka.events.TransferFundsAsyncEvent;

import java.util.Collection;
import java.util.Optional;

public interface AccountService {

    boolean createAccount(CreateAccountAsyncEvent createAccountAsyncEvent);

    boolean deleteAccount(DeleteAccountAsyncEvent deleteAccountAsyncEvent);

    boolean transferFunds(TransferFundsAsyncEvent transferFundsAsyncEvent);

    boolean depositFunds(DepositAccountAsyncEvent depositAccountAsyncEvent);

    Collection<Account> getAccounts();

    Optional<Account> getAccount(AccountId id);

}
