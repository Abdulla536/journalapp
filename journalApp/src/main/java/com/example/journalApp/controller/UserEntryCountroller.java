package com.example.journalApp.controller;

import com.example.journalApp.entity.UserEntry;
import com.example.journalApp.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserEntryCountroller {

    @Autowired
    private UserEntryService userEntryService;

//    @GetMapping
//    public List<UserEntry> getalluser(){
//        return userEntryService.getAll();
//    }

    @PutMapping
    public ResponseEntity<?> username(@RequestBody UserEntry userEntry){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        UserEntry userIndb= userEntryService.findByUserName(username);

            userIndb.setUserName(userEntry.getUserName());
            userIndb.setPassword(userEntry.getPassword());
            userEntryService.saveNewEntry(userIndb);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
