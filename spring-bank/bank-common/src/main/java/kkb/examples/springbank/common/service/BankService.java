package kkb.examples.springbank.common.service;

import kkb.examples.springbank.common.dto.Client;
import kkb.examples.springbank.common.dto.ClientId;
import kkb.examples.springbank.common.dto.DepositRequest;
import kkb.examples.springbank.common.dto.ServiceException;
import kkb.examples.springbank.common.dto.TransactionRequest;
import kkb.examples.springbank.common.dto.WithdrawRequest;

public interface BankService {

    void transferFunds(TransactionRequest transactionRequest) throws ServiceException;

    void deposit(DepositRequest depositRequest) throws ServiceException;

    void withDraw(WithdrawRequest withdrawRequest) throws ServiceException;

    Client getClientInfo(ClientId clientId) throws ServiceException;

}
