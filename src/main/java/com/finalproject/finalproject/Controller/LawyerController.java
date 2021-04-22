package com.finalproject.finalproject.Controller;

import com.finalproject.finalproject.Repository.LawyerRepository;
import com.finalproject.finalproject.Service.ClientService;
import com.finalproject.finalproject.Service.LawyerService;
import com.finalproject.finalproject.entity.Client;
import com.finalproject.finalproject.entity.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/lawyers")
public class LawyerController {

    @Autowired
    private LawyerService service;

    @Autowired
    private LawyerRepository lawyerRepo;

    //Read
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getLawyers() {
        return new ResponseEntity<Object>(service.getLawyers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{lawyerId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getLawyerById(@PathVariable Long lawyerId) throws Exception {
        return new ResponseEntity<Object>(service.getLawyerById(lawyerId), HttpStatus.OK);
    }

    //Create

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addLawyer(@RequestBody Lawyer lawyer) {
        return new ResponseEntity<Object>(service.createLawyer(lawyer), HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}/clients", method=RequestMethod.POST)
    public ResponseEntity<Object> addClients(@RequestBody Set<Long> clientIds, @PathVariable Long id){
        try {
            return new ResponseEntity<Object>(service.addClients(clientIds, id), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e,HttpStatus.BAD_REQUEST);
        }
    }

    //Update
    @RequestMapping(value = "/update/{lawyerId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateLawyer(@RequestBody Lawyer lawyer, @PathVariable Long lawyerId) throws Exception {
        return new ResponseEntity<Object>(service.updateLawyer(lawyer, lawyerId), HttpStatus.OK);
    }

    //Delete
    @RequestMapping(value = "/delete/{lawyerId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteLawyer(@PathVariable Long lawyerId) throws Exception {
        service.deleteLawyer(lawyerId);
        return new ResponseEntity<Object>("Lawyer with ID of: " + lawyerId + " has been deleted.", HttpStatus.OK);
    }
}
