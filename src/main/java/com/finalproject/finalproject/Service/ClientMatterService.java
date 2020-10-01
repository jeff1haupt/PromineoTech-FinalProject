package com.finalproject.finalproject.Service;

import com.finalproject.finalproject.Repository.ClientMatterRepository;
import com.finalproject.finalproject.Repository.ClientRepository;
import com.finalproject.finalproject.Repository.LawyerRepository;
import com.finalproject.finalproject.Repository.PracticeAreasRepository;
import com.finalproject.finalproject.entity.Client;
import com.finalproject.finalproject.entity.ClientMatter;
import com.finalproject.finalproject.entity.Lawyer;
import com.finalproject.finalproject.entity.PracticeAreas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public ClientMatter createMatter(ClientMatter matter, Long clientId, Long lawyerId, Long practiceId) throws Exception {
        Optional<Client> clientObject = clientRepo.findById(clientId);
        if (clientObject.isEmpty()) { throw new Exception( "Client not found." ); }
        Optional<Lawyer> lawyerObject = lawyerRepo.findById(lawyerId);
        if (lawyerObject.isEmpty()) {throw new Exception( "Lawyer not found." ); }
        Optional<PracticeAreas> practiceAreas = practiceRepo.findById(practiceId);
        if (practiceAreas.isEmpty()) {throw new Exception( "Practice area does not exist." ); }

        Client client = clientObject.get();
        Lawyer lawyer = lawyerObject.get();
        PracticeAreas pa = practiceAreas.get();
        matter.setClient(client);
        matter.setDateOpened(new Date());
        matter.setLawyer((Set<Lawyer>) lawyer);
        matter.setPracticeArea((Set<PracticeAreas>) pa);
        return repo.save(matter);
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


}
