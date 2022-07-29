package kz.dar.academy.backend.service;

import kz.dar.academy.backend.model.Client;

import java.util.List;

public interface ClientService {

    void addClient(Client client);

    List<Client> getAllClients();

    Client getClientById(String clientId);

    void updateClientById(String clientId, Client client);

    void deleteClientById(String clientId);
}
