package kz.dar.academy.backend.service;

import kz.dar.academy.backend.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService{

    private static final HashMap<String, Client> clientMap = new HashMap<>();

    static {
        Client client1 = new Client(UUID.randomUUID().toString(), "Amanat", "Zhanyl", "123456789");
        Client client2 = new Client(UUID.randomUUID().toString(), "Zhanyl", "Zhanyl", "123456789");
        Client client3 = new Client(UUID.randomUUID().toString(), "Adil", "Zhanyl", "123456789");

        clientMap.put(client1.getClientId(), client1);
        clientMap.put(client2.getClientId(), client2);
        clientMap.put(client3.getClientId(), client3);
    }
    
    @Override
    public void addClient(Client client) {
        client.setClientId(UUID.randomUUID().toString());
        clientMap.put(client.getClientId(), client);
    }

    @Override
    public List<Client> getAllClients() {
        return new ArrayList<>(clientMap.values());
    }

    @Override
    public Client getClientById(String clientId) {
        return clientMap.get(clientId);
    }

    @Override
    public void updateClientById(String clientId, Client client) {
        client.setClientId(UUID.randomUUID().toString());
        clientMap.put(client.getClientId(), client);
        clientMap.remove(clientId);
    }

    @Override
    public void deleteClientById(String clientId) {
        clientMap.remove(clientId);
    }
}
