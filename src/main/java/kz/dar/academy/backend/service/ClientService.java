package kz.dar.academy.backend.service;

import kz.dar.academy.backend.model.ClientRequest;
import kz.dar.academy.backend.model.ClientResponse;

import java.util.List;

public interface ClientService {
    ClientResponse createClient(ClientRequest clientRequest);

    ClientResponse updateClient(ClientRequest clientRequest);

    ClientResponse getClientById(String clientId);

    List<ClientResponse> getAllClients();

    void deleteClientById(String clientId);
}
