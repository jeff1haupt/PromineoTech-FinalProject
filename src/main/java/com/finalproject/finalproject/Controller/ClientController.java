package com.finalproject.finalproject.Controller;

import com.finalproject.finalproject.Service.ClientService;
import com.finalproject.finalproject.entity.Client;
import com.finalproject.finalproject.entity.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    //Read
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getClients() {
        return new ResponseEntity<Object>(service.getClients(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getClientById(@PathVariable Long clientId) throws Exception {
        return new ResponseEntity<Object>(service.getClientById(clientId), HttpStatus.OK);
    }

    //Create
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addClient(@RequestBody Client client) throws Exception {
        return new ResponseEntity<Object>(service.createClient(client), HttpStatus.CREATED);
    }

    //Update
    @RequestMapping(value = "/{clientId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateClient(@RequestBody Client client, @PathVariable Long clientId) throws Exception {
        return new ResponseEntity<Object>(service.updateClient(client, clientId), HttpStatus.OK);
    }

    //Delete
    @RequestMapping(value = "/{clientId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteClient(@PathVariable Long clientId) throws Exception {
        service.deleteClient(clientId);
        return new ResponseEntity<Object>("Client with ID of: " + clientId + " has been deleted.", HttpStatus.OK);
    }
}
