package com.finalproject.finalproject.Service;

import com.finalproject.finalproject.Repository.PracticeAreasRepository;
import com.finalproject.finalproject.entity.Client;
import com.finalproject.finalproject.entity.PracticeAreas;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PracticeAreaService {


    @Autowired
    private PracticeAreasRepository repo;

    public PracticeAreas createPracticeArea(PracticeAreas pa) {
        return repo.save(pa);
    }

    public PracticeAreas getAreaById(Long id) throws Exception {
        try {
            Optional<PracticeAreas> pArea = repo.findById(id);
            if ( pArea.isEmpty() ) {
                throw new Exception( "Practice area does not exist." );
            }
            return pArea.get();
        } catch (Exception e) {
            throw e;
        }
    }

    public void deletePracticeArea(Long id) throws Exception {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            throw new Exception( "Unable to delete practice area.");
        }
    }

    public Iterable<PracticeAreas> getAreas() {
        return repo.findAll();
    }

}
