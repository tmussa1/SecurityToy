package me.afua.securitydemoagain.controller;

import me.afua.securitydemoagain.model.AppUser;
import me.afua.securitydemoagain.model.UserRole;
import me.afua.securitydemoagain.repository.AppUserRepository;
import me.afua.securitydemoagain.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
public class MainController {

    @Autowired
    UserRoleRepository roles;

    @Autowired
    AppUserRepository users;

    @RequestMapping("/")
    public String showHomepage(){
        return "dashboard";
    }
    @RequestMapping("/teacher")
    public String showCourselist(){
        return "dashboard";
    }

    @RequestMapping("/student")
    public String showDashboard(){
        return "dashboard";
    }

    @PostConstruct
    public void loadData()
    {
        UserRole teacher = new UserRole("TEACHER");
        roles.save(teacher);

        UserRole student = new UserRole("STUDENT");
        roles.save(student);

        AppUser oldUser = new AppUser("ateacher","apassword");
        oldUser.addRole(teacher);
        users.save(oldUser);

        AppUser newUser = new AppUser("astudent","apass");
        newUser.addRole(student);
        users.save(newUser);

    }
}
