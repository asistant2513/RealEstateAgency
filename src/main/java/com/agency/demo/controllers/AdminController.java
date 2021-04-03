package com.agency.demo.controllers;

import com.agency.demo.enums.UserRole;
import com.agency.demo.models.User;
import com.agency.demo.services.AdvertisementService;
import com.agency.demo.services.EstateService;
import com.agency.demo.services.RealtorService;
import com.agency.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RealtorService realtorService;
    private final EstateService estateService;
    private final AdvertisementService advertisementService;

    @Autowired
    public AdminController(UserService userService,
                           RealtorService realtorService,
                           EstateService estateService,
                           AdvertisementService advertisementService) {
        this.userService = userService;
        this.realtorService = realtorService;
        this.estateService = estateService;
        this.advertisementService = advertisementService;
    }

    @GetMapping
    public String goToMainAdminPage(){
        return "admin/admin";
    }

    @GetMapping("/users")
    public String goToUsersAdministration(Model model){
        Iterable<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "admin/users/admin_users";
    }

    @GetMapping("/users/{id}")
    public String editUserById(@PathVariable("id") long id, Model model , HttpSession session){
        User u = userService.getUserById(id);
        session.setAttribute("user",u);
        model.addAttribute("user", u);
        return "/admin/users/edit_user";
    }

    @PutMapping("/users/{id}")
    public String editUser(@ModelAttribute("user") User u,
                           @SessionAttribute("user")User toUpdate,
                           HttpSession session){
        toUpdate.setName(u.getName());
        toUpdate.setSurname(u.getSurname());
        toUpdate.setPhoneNumber(u.getPhoneNumber());
        userService.saveUser(toUpdate);
        session.removeAttribute("user");
        return"redirect:/admin/users";
    }

    @DeleteMapping("/users/{id}")
    public String editUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/add")
    public String goToAddUser(Model model){
        model.addAttribute("roles", UserRole.values());
        model.addAttribute("user", new User());
        return "admin/users/add_user";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/admin/users";
    }
}
