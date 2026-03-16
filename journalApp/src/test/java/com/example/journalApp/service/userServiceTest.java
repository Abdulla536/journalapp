package com.example.journalApp.service;

import com.example.journalApp.repository.UserEntryrepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class userServiceTest {

    @InjectMocks
    private UserDetailsServiceimp userDetailsServiceimp;

    @Mock
    private UserEntryrepository userEntryrepository;

    @BeforeEach
    void setUP(){
        MockitoAnnotations.initMocks(this);
    }

   // @Test
    // public void testfindbyuserName(){
    //     when(userEntryrepository.findByUserName("person", "12345"))
    //             .thenReturn(new User("1", "person", "12345"));

    //     assertNotNull(userEntryrepository.findByUserName("person"));
    // }
}
