package kkb.examples.springbank.client;

import com.fasterxml.jackson.databind.ObjectMapper;

import kkb.examples.springbank.client.service.AdminServiceImpl;
import kkb.examples.springbank.client.service.BankServiceImpl;
import kkb.examples.springbank.client.service.SystemInfoServiceImpl;
import kkb.examples.springbank.common.service.AdminService;
import kkb.examples.springbank.common.service.BankService;
import kkb.examples.springbank.common.service.SystemInfoService;

import java.net.http.HttpClient;

public class ClientApp {

    public static void main(String[] args) {
        String baseUri = "http://localhost:8080";
        ObjectMapper mapper = new ObjectMapper();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        AdminService adminService = new AdminServiceImpl(httpClient, baseUri, mapper);
        BankService bankService = new BankServiceImpl(httpClient, baseUri, mapper);
        SystemInfoService systemInfoService = new SystemInfoServiceImpl(httpClient, baseUri, mapper);
    }

}
