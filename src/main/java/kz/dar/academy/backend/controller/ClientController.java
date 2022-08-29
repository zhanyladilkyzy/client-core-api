package kz.dar.academy.backend.controller;

import kz.dar.academy.backend.model.ClientRequest;
import kz.dar.academy.backend.model.ClientResponse;
import kz.dar.academy.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    Environment environment;

    @GetMapping("/check")
    public String check(){
        return "Client controller works! " + environment.getProperty("local.server.port");
    }


    @PostMapping("/create")
    public ClientResponse createClient(@RequestBody ClientRequest clientRequest) {
        return clientService.createClient(clientRequest);
    }

    @PutMapping("/{clientId}")
    public ClientResponse updateClient(@PathVariable String clientId, @RequestBody ClientRequest clientRequest) {
        clientRequest.setClientId(clientId);
        return clientService.updateClient(clientRequest);
    }
    @GetMapping("/{clientId}")
    private ClientResponse getClientById(@PathVariable String clientId) {
        return clientService.getClientById(clientId);
    }

    @GetMapping("/all")
    private List<ClientResponse> getAllClients() {
        return clientService.getAllClients();
    }

    @DeleteMapping("/{clientId}")
    private ResponseEntity<String> deleteClient(@PathVariable String clientId) {
        clientService.deleteClientById(clientId);
        return new ResponseEntity<String>("Client deleted!", HttpStatus.OK);
    }
}
