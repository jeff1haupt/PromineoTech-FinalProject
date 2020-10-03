package com.finalproject.finalproject.Controller;

import com.finalproject.finalproject.Service.ClientMatterService;
import com.finalproject.finalproject.Service.LawyerService;
import com.finalproject.finalproject.entity.ClientMatter;
import com.finalproject.finalproject.entity.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matters")
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
    @RequestMapping(value = "/addMatter/{clientId}/{lawyerId}/{practiceId}", method = RequestMethod.POST)
    public ResponseEntity<Object> createMatter(@RequestBody ClientMatter clientMatter, @PathVariable Long clientId, @PathVariable Long lawyerId, @PathVariable Long practiceId) throws Exception {
        return new ResponseEntity<Object>(service.createMatter(clientMatter, clientId, lawyerId, practiceId), HttpStatus.CREATED);
    }

    //Update
    @RequestMapping(value = "/close/{matterId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> closeMatter(@RequestBody ClientMatter matter, @PathVariable Long matterId) throws Exception {
        return new ResponseEntity<Object>(service.closeMatter(matter, matterId), HttpStatus.OK);
    }

    //Delete
    @RequestMapping( value = "/delete/{matterId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteMatter(@PathVariable Long matterId) throws Exception {
        service.deleteMatter(matterId);
        return new ResponseEntity<Object>("Deleted matter id: " + matterId, HttpStatus.OK);
    }

}
