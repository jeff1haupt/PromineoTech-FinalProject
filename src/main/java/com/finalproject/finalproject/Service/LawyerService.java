package com.finalproject.finalproject.Service;

import com.finalproject.finalproject.Repository.ClientRepository;
import com.finalproject.finalproject.Repository.LawyerRepository;
import com.finalproject.finalproject.entity.Client;
import com.finalproject.finalproject.entity.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class LawyerService {

    @Autowired
    private LawyerRepository repo;

    @Autowired
    private ClientRepository clientRepo;

    public Lawyer createLawyer(Lawyer lawyer) {
        return repo.save(lawyer);
    }

    public Lawyer getLawyerById(Long id) throws Exception {
        try {
            Optional<Lawyer> lawyer = repo.findById(id);
            if ( lawyer.isEmpty() ) {
                throw new Exception( "Lawyer does not exist." );
            }
            return lawyer.get();
        } catch (Exception e) {
            throw e;
        }
    }

    public Iterable<Lawyer> getLawyers() {
        return repo.findAll();
    }

    public Lawyer updateLawyer(Lawyer lawyer, Long lawyerId) throws Exception {
        Optional<Lawyer> lawyer1 = repo.findById(lawyerId);
        if ( lawyer1.isEmpty() ) {
            throw new Exception( "Lawyer does not exist." );
        }
        Lawyer foundLawyer = lawyer1.get();
        foundLawyer.setFirstName(lawyer.getFirstName());
        foundLawyer.setLastName(lawyer.getLastName());
        foundLawyer.setEmail(lawyer.getEmail());
        foundLawyer.setPhoneNumber(lawyer.getPhoneNumber());
        foundLawyer.setHourlyRate(lawyer.getHourlyRate());
        return repo.save(foundLawyer);
    }

    public void deleteLawyer(Long id) throws Exception {
        try {
            repo.deleteById(id);
        } catch (Exception e){
            throw new Exception( "Unable to delete Lawyer." );
        }
    }

    public Lawyer addClients(Set<Long> clientIds, Long id) {
        Lawyer lawyer = repo.findById(id).get();
        lawyer.setClient(convertToSet(clientRepo.findAllById(clientIds)));
        addClientToLawyer(lawyer);
        return repo.save(lawyer);
    }

    private void addClientToLawyer(Lawyer lawyer) {
        Set<Client> clients = lawyer.getClient();
        for(Client client : clients) {
            client.getLawyer().add(lawyer);
        }
    }

    private Set<Client> convertToSet(Iterable<Client> iterable){
        Set<Client> set = new HashSet<Client>();
        for(Client client: iterable) {
            set.add(client);
        }
        return set;
    }
}


