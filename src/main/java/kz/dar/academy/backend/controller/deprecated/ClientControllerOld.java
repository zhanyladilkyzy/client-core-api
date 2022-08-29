package kz.dar.academy.backend.controller.deprecated;

import kz.dar.academy.backend.model.ClientModel;
import kz.dar.academy.backend.service.deprecated.ClientServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/deprecated/client")
public class ClientControllerOld {

    @Autowired
    Environment environment;

    @Autowired
    private ClientServiceOld clientServiceOld;


    @GetMapping("/check")
    public String check(){
        return "Client controller works! " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<String> addClient(@Valid @RequestBody ClientModel clientModel) {
        clientServiceOld.addClient(clientModel);
        return new ResponseEntity<String>("Successfully sent", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<ClientModel> getAllClients() {
        return clientServiceOld.getAllClients();
    }

    @GetMapping("/{clientId}")
    public ClientModel getClientById(@PathVariable String clientId) {
        return clientServiceOld.getClientById(clientId);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<String> updateClientById(@PathVariable String clientId, @Valid @RequestBody ClientModel clientModel) {
        clientServiceOld.updateClientById(clientId, clientModel);
        return new ResponseEntity<String>("Successfully updated!", HttpStatus.OK);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClientById(@PathVariable String clientId) {
        clientServiceOld.deleteClientById(clientId);
        return new ResponseEntity<String>("Successfully deleted!", HttpStatus.OK);
    }
}
