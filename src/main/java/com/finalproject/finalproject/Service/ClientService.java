package com.finalproject.finalproject.Service;

import com.finalproject.finalproject.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.finalproject.entity.Client;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    public Client createClient(Client client) {
        return repo.save(client);
    }

    public Client updateClient(Long clientId) throws Exception {
        Optional<Client> client = repo.findById(clientId);
        if ( client.isEmpty() ) {
            throw new Exception( "Client does not exist." );
        }
        
    }

}
