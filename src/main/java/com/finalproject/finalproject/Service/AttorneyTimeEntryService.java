package com.finalproject.finalproject.Service;

import com.finalproject.finalproject.Repository.ClientMatterRepository;
import com.finalproject.finalproject.Repository.TimeEntryRepository;
import com.finalproject.finalproject.entity.AttorneyTimeEntry;
import com.finalproject.finalproject.entity.Client;
import com.finalproject.finalproject.entity.ClientMatter;
import com.finalproject.finalproject.entity.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AttorneyTimeEntryService {

    @Autowired
    private TimeEntryRepository repo;

    @Autowired
    private ClientMatterRepository matterRepo;

    public AttorneyTimeEntry createEntry(AttorneyTimeEntry entry, Long matterId) throws Exception {
        Optional<ClientMatter> matterObject = matterRepo.findById(matterId);
        if (matterObject.isEmpty()) {throw new Exception( "Matter not found." ); }

        ClientMatter matter = matterObject.get();
        entry.setClientMatter(matter);
        return repo.save(entry);
    }

    public AttorneyTimeEntry getTimeEntryById(Long id) throws Exception {
        try {
            Optional<AttorneyTimeEntry> entryOptional = repo.findById(id);
            if ( entryOptional.isEmpty() ) {
                throw new Exception( "Time entry does not exist." );
            }
            return entryOptional.get();
        } catch (Exception e) {
            throw e;
        }
    }

    public Iterable<AttorneyTimeEntry> getEntriesByMatterId( Long matterId ) throws Exception {
        Optional<ClientMatter> matter = matterRepo.findById(matterId);
        if ( matter.isEmpty() ) {
            throw new Exception( "No matter exists with that ID." );
        }
        return matter.get().getEntry();
    }

    public void deleteEntry(Long id) throws Exception {
        try {
            repo.deleteById(id);
        } catch (Exception e){
            throw new Exception( "Unable to delete Entry." );
        }
    }

}
