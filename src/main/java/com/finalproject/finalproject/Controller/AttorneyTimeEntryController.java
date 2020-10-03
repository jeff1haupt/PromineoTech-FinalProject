package com.finalproject.finalproject.Controller;

import com.finalproject.finalproject.Service.AttorneyTimeEntryService;
import com.finalproject.finalproject.entity.AttorneyTimeEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("entry")
public class AttorneyTimeEntryController {

    @Autowired
    private AttorneyTimeEntryService service;

    //Create
    @RequestMapping(value = "/addEntry/{matterId}", method = RequestMethod.POST)
    public ResponseEntity<Object> createTimeEntry(@RequestBody AttorneyTimeEntry entry, @PathVariable Long matterId) {
        try {
            return new ResponseEntity<Object>(service.createEntry(entry, matterId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Read
    @RequestMapping( value = "/{matterId}/entries", method = RequestMethod.GET)
    public ResponseEntity<Object> getEntriesByMatter(@RequestBody AttorneyTimeEntry entry, @PathVariable Long matterId) throws Exception {
        return new ResponseEntity<Object>( service.getEntriesByMatterId(matterId), HttpStatus.OK);
    }

    //Delete
    @RequestMapping(value = "/delete/{entryId}")
    public ResponseEntity<Object> deleteEntry(@PathVariable Long entryId) throws Exception {
        service.deleteEntry(entryId);
        return new ResponseEntity<Object>("Deleted the following entry: " + entryId, HttpStatus.OK);
    }


}
