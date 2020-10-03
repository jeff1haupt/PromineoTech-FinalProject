package com.finalproject.finalproject.Service;

import com.finalproject.finalproject.Repository.ClientRepository;
import com.finalproject.finalproject.Repository.LawyerRepository;
import com.finalproject.finalproject.entity.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.finalproject.entity.Client;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    @Autowired
    private LawyerRepository lawyerRepo;

    public Client createClient(Client client, Long lawyerId) throws Exception {
        Optional<Lawyer> lawyerObject = lawyerRepo.findById(lawyerId);
        if (lawyerObject.isEmpty()) {throw new Exception( "Lawyer not found." ); }

        Lawyer lawyer = lawyerObject.get();
        client.setLawyer(lawyer);
        return repo.save(client);
    }

    public Client getClientById(Long id) throws Exception {
        try {
            Optional<Client> client = repo.findById(id);
            if ( client.isEmpty() ) {
                throw new Exception( "Client does not exist." );
            }
            return client.get();
        } catch (Exception e) {
            throw e;
        }
    }

    public Iterable<Client> getClients() {
        return repo.findAll();
    }

    public Client updateClient(Client client, Long clientId) throws Exception {
        Optional<Client> client1 = repo.findById(clientId);
        if ( client1.isEmpty() ) {
            throw new Exception( "Client does not exist." );
        }
        Client foundClient = null;
        try {
            foundClient = client1.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        foundClient.setFirstName(client.getFirstName());
        foundClient.setLastName(client.getLastName());
        foundClient.setEmail(client.getEmail());
        foundClient.setPhoneCell(client.getPhoneCell());
        foundClient.setPhoneHome(client.getPhoneHome());
        foundClient.setPhoneWork(client.getPhoneWork());
        foundClient.setStreetAddress(client.getStreetAddress());
        foundClient.setCity(client.getCity());
        foundClient.setState(client.getState());
        return repo.save(foundClient);
    }

    public void deleteClient(Long id) throws Exception {
        try {
            repo.deleteById(id);
        } catch (Exception e){
            throw new Exception( "Unable to delete Client." );
        }
    }

}
