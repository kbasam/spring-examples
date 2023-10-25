package kkb.examples.springbank.server.utils;

import kkb.examples.springbank.common.dto.Account;
import kkb.examples.springbank.common.dto.AccountId;
import kkb.examples.springbank.common.dto.Client;
import kkb.examples.springbank.common.dto.ClientId;
import kkb.examples.springbank.server.repository.model.AccountEntity;
import kkb.examples.springbank.server.repository.model.ClientEntity;

public final class DTS {

    private DTS() {
        throw new UnsupportedOperationException("Please do not instantiate utility class.");
    }

    public static Client transform(ClientEntity clientEntity) {
        AccountEntity accountEntity = clientEntity.getAccount();
        AccountId accountId = new AccountId(accountEntity.getId().toString());
        Account account = new Account(accountId, accountEntity.getCredit());
        ClientId id = new ClientId(clientEntity.getId().toString());
        Client client = new Client(id, clientEntity.getFirstName(), clientEntity.getLastName(), account);
        return client;
    }

}
