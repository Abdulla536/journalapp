package com.example.journalApp.service;

import com.example.journalApp.entity.UserEntry;
import com.example.journalApp.repository.UserEntryrepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserEntryService {

    @Autowired
    private UserEntryrepository userEntryrepository;

        public static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveNewEntry(UserEntry userEntry){
     userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
     userEntry.setRole(Arrays.asList("User"));
        userEntryrepository.save(userEntry);
    }

    public void saveAdmin(UserEntry userEntry){
        userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
        userEntry.setRole(Arrays.asList("User","ADMIN"));
        userEntryrepository.save(userEntry);
    }

    public void saveUser(UserEntry userEntry){

        userEntryrepository.save(userEntry);
    }

//    public void saveNewUser(UserEntry userEntry){
//
//        userEntryrepository.save(userEntry);
//    }


    public List<UserEntry> getAll(){
       return userEntryrepository.findAll();

    }

    public Optional<UserEntry> findById(ObjectId id){
        return userEntryrepository.findById(id);
    }

    public void deletebyid(ObjectId id){
        userEntryrepository.deleteById(id);

    }
    public UserEntry findByUserName(String username){
        return userEntryrepository.findByUserName(username);
    }

}
// controller -->service -->repository