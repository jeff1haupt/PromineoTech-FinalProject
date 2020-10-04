package com.finalproject.finalproject.Service;

import com.finalproject.finalproject.Repository.*;
import com.finalproject.finalproject.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientMatterService {

    @Autowired
    private ClientMatterRepository repo;

    @Autowired
    private LawyerRepository lawyerRepo;

    @Autowired
    private ClientRepository clientRepo;

    @Autowired
    private PracticeAreasRepository practiceRepo;

    @Autowired
    private TimeEntryRepository entryRepo;

    public ClientMatter createMatter(Long clientId) throws Exception {
        try {
            Client client = clientRepo.findById(clientId).get();
            ClientMatter matter = initializeNewMatter(client);
            return repo.save(matter);
        } catch (Exception e) {
            throw e;
        }

    }

    public Iterable<ClientMatter> getAllMatters() {
        return repo.findAll();
    }

    public void deleteMatter(Long id) throws Exception {
        try {
            repo.deleteById(id);
        } catch (Exception e){
            throw new Exception( "Unable to delete matter." );
        }
    }

    public ClientMatter closeMatter(ClientMatter matter, Long matterId) throws Exception {
        Optional<ClientMatter> matter1 = repo.findById(matterId);
        if ( matter1.isEmpty() ) {
            throw new Exception( "Matter does not exist." );
        }

        ClientMatter foundMatter = matter1.get();
        foundMatter.setMatterStatus("CLOSED");
        return repo.save(foundMatter);
    }

    public ClientMatter getMatter(Long id) throws Exception {
        try {
            Optional<ClientMatter> foundMatter = repo.findById(id);
            return foundMatter.get();
        } catch (Exception e){
            throw new Exception( "Unable to find matter." );
        }
    }

    private ClientMatter initializeNewMatter(Client client) {
        ClientMatter matter = new ClientMatter();
        matter.setMatterStatus("OPEN");
        matter.setDateOpened(new Date());
        matter.setClient(client);
        matter.setLawyer(convertToLawyerSet(client.getLawyer()));
        return matter;
    }

    private Set<Lawyer> convertToLawyerSet(Iterable<Lawyer> iterable) {
        Set<Lawyer> lawyers = new HashSet<Lawyer>();
        for( Lawyer lawyer : iterable ) {
            lawyers.add(lawyer);
        }
        return lawyers;
    }


}
