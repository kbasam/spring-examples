package kkb.examples.springbank.client.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kkb.examples.springbank.common.dto.Client;
import kkb.examples.springbank.common.dto.ClientId;
import kkb.examples.springbank.common.dto.CreateClientRequest;
import kkb.examples.springbank.common.dto.ServiceException;
import kkb.examples.springbank.common.service.AdminService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    private static final Logger LOG = LoggerFactory.getLogger(AdminServiceImpl.class);

    private static final String SERVICE_PREFIX = "/services/admin";

    private final HttpClient httpClient;
    private final ObjectMapper mapper;
    private String baseUri;

    public AdminServiceImpl(HttpClient httpClient, String baseUri, ObjectMapper mapper) {
        this.httpClient = httpClient;
        this.baseUri = baseUri + SERVICE_PREFIX;
        this.mapper = mapper;
    }

    @Override
    public ClientId createClient(CreateClientRequest createClientRequest) throws ServiceException {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(createClientRequest)))
                    .uri(URI.create(baseUri + "/client"))
                    .header("Content-Type", "application/json")
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new ServiceException("Http status: " + response.statusCode());
            }
            return mapper.readValue(response.body(), ClientId.class);
        } catch (Exception e) {
            LOG.error("ERROR: ", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public Collection<Client> getClients() throws ServiceException {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(baseUri + "/clients"))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new ServiceException("Http status: " + response.statusCode());
            }
            return mapper.readValue(response.body(), new TypeReference<List<Client>>(){});
        } catch (Exception e) {
            LOG.error("ERROR: ", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteClient(ClientId id) throws ServiceException {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .DELETE()
                    .uri(URI.create(baseUri + "/client/" + id.getId()))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new ServiceException("Http status: " + response.statusCode());
            }
        } catch (Exception e) {
            LOG.error("ERROR: ", e);
            throw new ServiceException(e);
        }
    }

}
