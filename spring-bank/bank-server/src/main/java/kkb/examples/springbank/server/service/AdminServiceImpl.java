package kkb.examples.springbank.server.service;

import kkb.examples.springbank.common.dto.Client;
import kkb.examples.springbank.common.dto.ClientId;
import kkb.examples.springbank.common.dto.CreateClientRequest;
import kkb.examples.springbank.common.dto.ServiceException;
import kkb.examples.springbank.common.service.AdminService;
import kkb.examples.springbank.server.repository.ClientRepository;
import kkb.examples.springbank.server.repository.model.AccountEntity;
import kkb.examples.springbank.server.repository.model.ClientEntity;
import kkb.examples.springbank.server.utils.DTS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final ClientRepository clientRepository;

    @Autowired
    public AdminServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public ClientId createClient(CreateClientRequest createClientRequest) throws ServiceException {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setCredit(0L);
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setFirstName(createClientRequest.getFirstName());
        clientEntity.setLastName(createClientRequest.getLastName());
        clientEntity.setAccount(accountEntity);
        ClientEntity savedEntity = clientRepository.save(clientEntity);
        return new ClientId(savedEntity.getId().toString());
    }

    @Override
    @Transactional
    public Collection<Client> getClients() throws ServiceException {
        List<Client> clients = new ArrayList<>();
        List<ClientEntity> allClientEntities = clientRepository.findAll();
        allClientEntities.forEach(c -> {
            clients.add(DTS.transform(c));
        });
        return clients;
    }

    @Override
    @Transactional
    public void deleteClient(ClientId id) throws ServiceException {
        Long clientId = Long.parseLong(id.getId());
        clientRepository.deleteById(clientId);
    }

}
