package com.finalproject.finalproject.Controller;

import com.finalproject.finalproject.Service.ClientMatterService;
import com.finalproject.finalproject.Service.LawyerService;
import com.finalproject.finalproject.entity.Client;
import com.finalproject.finalproject.entity.ClientMatter;
import com.finalproject.finalproject.entity.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("client/{id}/matters")
public class ClientMatterController {

    @Autowired
    private ClientMatterService service;

    //Read
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllMatters() {
        return new ResponseEntity<Object>(service.getAllMatters(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{matterId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getMatterById(@PathVariable Long matterId) throws Exception {
        return new ResponseEntity<Object>( service.getMatter(matterId), HttpStatus.OK);
    }

    //Create
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addMatter(@PathVariable Long id) throws Exception {
        return new ResponseEntity<Object>(service.createMatter(id), HttpStatus.CREATED);
    }

    //Update
    @RequestMapping(value = "/{matterId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> closeMatter(@RequestBody ClientMatter matter, @PathVariable Long matterId) throws Exception {
        return new ResponseEntity<Object>(service.closeMatter(matter, matterId), HttpStatus.OK);
    }

    //Delete
    @RequestMapping( value = "/{matterId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteMatter(@PathVariable Long matterId) throws Exception {
        service.deleteMatter(matterId);
        return new ResponseEntity<Object>("Deleted matter id: " + matterId, HttpStatus.OK);
    }

}
