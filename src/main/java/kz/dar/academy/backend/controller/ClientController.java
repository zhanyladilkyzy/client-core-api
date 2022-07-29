package kz.dar.academy.backend.controller;

import kz.dar.academy.backend.model.Client;
import kz.dar.academy.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    Environment environment;

    @Autowired
    private ClientService clientService;


    @GetMapping("/check")
    public String check(){
        return "Controller works! " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<String> addClient(@Valid @RequestBody Client client) {
        clientService.addClient(client);
        return new ResponseEntity<String>("Successfully sent", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public Client getClientById(@PathVariable String clientId) {
        return clientService.getClientById(clientId);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<String> updateClientById(@PathVariable String clientId, @Valid @RequestBody Client client) {
        clientService.updateClientById(clientId, client);
        return new ResponseEntity<String>("Successfully updated!", HttpStatus.OK);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClientById(@PathVariable String clientId) {
        clientService.deleteClientById(clientId);
        return new ResponseEntity<String>("Successfully deleted!", HttpStatus.OK);
    }
}
