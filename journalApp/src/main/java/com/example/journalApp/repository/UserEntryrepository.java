package com.example.journalApp.repository;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.entity.UserEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEntryrepository extends MongoRepository<UserEntry, ObjectId> {
    UserEntry findByUserName(String username);
    //UserEntry deleteByuserName(String username);
}
