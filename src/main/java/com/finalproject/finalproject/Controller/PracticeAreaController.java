package com.finalproject.finalproject.Controller;

import com.finalproject.finalproject.Repository.PracticeAreasRepository;
import com.finalproject.finalproject.Service.PracticeAreaService;
import com.finalproject.finalproject.entity.Lawyer;
import com.finalproject.finalproject.entity.PracticeAreas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/areas")
public class PracticeAreaController {

    @Autowired
    private PracticeAreaService service;

    //Read
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAreas() {
        return new ResponseEntity<Object>(service.getAreas(), HttpStatus.OK);
    }

    //Create
    @RequestMapping(value = "/addArea", method = RequestMethod.POST)
    public ResponseEntity<Object> addArea(@RequestBody PracticeAreas area) {
        return new ResponseEntity<Object>(service.createPracticeArea(area), HttpStatus.CREATED);
    }

    //Delete
    @RequestMapping(value = "/delete/{areaId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePracticeArea(@PathVariable Long areaId) throws Exception {
        service.deletePracticeArea(areaId);
        return new ResponseEntity<Object>("Practice area ID: " + areaId + " has been deleted.", HttpStatus.OK);
    }
}
