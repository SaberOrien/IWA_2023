package com.example.springapp.controllers;
/*
import com.example.springapp.model.Address;
import com.example.springapp.repository.AddressRepository;
import com.example.springapp.repository.StudentRepository;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/addresses")
public class AddressController {
    private AddressRepository addressRepository;
    private StudentRepository studentRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository, StudentRepository studentRepository){
        this.addressRepository = addressRepository;
        this.studentRepository = studentRepository;
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<Address> findAllAddresses(){
        return addressRepository.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Address> findAddress(@PathVariable("id") long id){
        Address address = addressRepository.findById(id);
        return new ResponseEntity<Address>(address, HttpStatus.FOUND);
    }
    @RequestMapping(method=RequestMethod.DELETE)
    public ResponseEntity<AddressRepository> deleteCollection(){
        addressRepository.deleteAll();
        return new ResponseEntity<AddressRepository>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Address> deleteAddress(@PathVariable("id") long id){
        Address address = addressRepository.findById(id);
        if(address==null){
            System.out.println("Address not found!");
            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }
        if(address.getStudentList().size() > 0){
            return new ResponseEntity<Address>(HttpStatus.CONFLICT);
        }
        addressRepository.deleteById(id);
        return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        addressRepository.save(address);
        return new ResponseEntity<Address>(address, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Address> updatePartOfAddress(@RequestBody Map<String, Object> updates, @PathVariable("id") long id){
        Address address = addressRepository.findById(id);
        if(address == null){
            System.out.println("Address not found!");
            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }
        partialUpdate(address, updates);
        return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
    }

    private void partialUpdate(Address address, Map<String, Object> updates){
        if(updates.containsKey("city")){
            address.setCity((String) updates.get("city"));
        }
        if(updates.containsKey("number")){
            address.setNumber((String) updates.get("number"));
        }
        if(updates.containsKey("street")){
            address.setStreet((String) updates.get("street"));
        }
        if(updates.containsKey("postalCode")){
            address.setPostalCode((String) updates.get("postalCode"));
        }
        addressRepository.save(address);
    }

}
*/
