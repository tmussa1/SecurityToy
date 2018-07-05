package me.afua.securitydemoagain.controller;

import me.afua.securitydemoagain.model.AppUser;
import me.afua.securitydemoagain.model.UserRole;
import me.afua.securitydemoagain.repository.AppUserRepository;
import me.afua.securitydemoagain.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class MainController {

    @Autowired
    UserRoleRepository roles;

    @Autowired
    AppUserRepository users;

    @PostConstruct
    public void loadData()
    {
        UserRole ordinaryUser = new UserRole("USER");
        roles.save(ordinaryUser);

        UserRole admin = new UserRole("ADMIN");
        roles.save(admin);

        AppUser newUser = new AppUser("auser","apassword");
        newUser.addRole(ordinaryUser);
        users.save(newUser);

    }
}
