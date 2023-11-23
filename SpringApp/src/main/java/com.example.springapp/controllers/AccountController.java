package com.example.springapp.controllers;
/*
import com.example.springapp.model.Account;
import com.example.springapp.model.Student;
import com.example.springapp.repository.AccountRepository;
import com.example.springapp.repository.StudentRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private AccountRepository accountRepository;
    private StudentRepository studentRepository;
    @Autowired
    public AccountController(AccountRepository accountRepository, StudentRepository studentRepository){
        this.accountRepository = accountRepository;
        this.studentRepository = studentRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<Account> findAllAccounts(){
        return accountRepository.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Account> findAccount(@PathVariable("id") long id){
        Account account = accountRepository.findById(id);
        return new ResponseEntity<Account>(account, HttpStatus.FOUND);
    }

    @RequestMapping(method=RequestMethod.DELETE)
    public ResponseEntity<AccountRepository> deleteCollection(){
        accountRepository.deleteAll();
        studentRepository.deleteAll();
        return new ResponseEntity<AccountRepository>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Account> deleteAccount(@PathVariable("id") long id){
        Account account = accountRepository.findById(id);
        if(account == null){
            System.out.println("Account not found!");
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        accountRepository.deleteById(id);
        return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Account> updateAccount(@RequestBody Account account, @PathVariable("id") long id){
        Account currentAccount = accountRepository.findById(id);
        Student currentStudent = currentAccount.getStudent();
        account.setId(id);
        currentStudent.setAccount(account);
        studentRepository.save(currentStudent);
        return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PATCH)
    public ResponseEntity<Account> updatePartOfAccount(@RequestBody Map<String, Object> updates, @PathVariable("id") long id){
        Account account = accountRepository.findById(id);
        if(account == null){
            System.out.println("Account not found!");
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        partialUpdate(account, updates);
        return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
    }

    private void partialUpdate(Account account, Map<String, Object> updates){
        if(updates.containsKey("accountName")){
            account.setAccountName((String) updates.get("accountName"));
        }
        if(updates.containsKey("accountType")){
            account.setAccountName((String) updates.get("accountType"));
        }
        accountRepository.save(account);
    }
}
*/
