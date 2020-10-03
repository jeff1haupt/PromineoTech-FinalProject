package com.finalproject.finalproject.Controller;

import com.finalproject.finalproject.Service.ClientService;
import com.finalproject.finalproject.Service.LawyerService;
import com.finalproject.finalproject.entity.Client;
import com.finalproject.finalproject.entity.Lawyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lawyers")
public class LawyerController {

    @Autowired
    private LawyerService service;

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
    @RequestMapping(value = "/addLawyer", method = RequestMethod.POST)
    public ResponseEntity<Object> addLawyer(@RequestBody Lawyer lawyer) {
        return new ResponseEntity<Object>(service.createLawyer(lawyer), HttpStatus.CREATED);
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
