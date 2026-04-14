package com.example.journalApp.service;
import com.example.journalApp.entity.UserEntry;
import com.example.journalApp.repository.UserEntryrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceimp implements UserDetailsService {

    @Autowired
    private UserEntryrepository userEntryrepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserEntry user = userEntryrepository.findByUserName(username);
        if (user!=null){
            UserDetails userDetails = User.builder().username(user.getUserName()).password(user.getPassword()).roles(user.getRole().toArray(new String[0])).build();
       return userDetails;
        }
       throw new UsernameNotFoundException("user NOt found with user name"+username);

    }

}
