package kkb.examples.springbank.common.service;

import java.util.Collection;

import kkb.examples.springbank.common.dto.Client;
import kkb.examples.springbank.common.dto.ClientId;
import kkb.examples.springbank.common.dto.CreateClientRequest;
import kkb.examples.springbank.common.dto.ServiceException;

public interface AdminService {

    ClientId createClient(CreateClientRequest createClientRequest) throws ServiceException;

    Collection<Client> getClients() throws ServiceException;

    void deleteClient(ClientId id) throws ServiceException;

}
