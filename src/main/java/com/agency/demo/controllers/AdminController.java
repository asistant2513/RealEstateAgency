package com.agency.demo.controllers;

import com.agency.demo.enums.EstateStatus;
import com.agency.demo.enums.EstateType;
import com.agency.demo.enums.UserRole;
import com.agency.demo.models.*;
import com.agency.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

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

    /* Admin panel controller for USERS */

    @GetMapping("/users")
    public String goToUsersAdministration(Model model){
        Iterable<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "admin/users/admin_users";
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

    @GetMapping("/users/{id}")
    public String editUserById(@PathVariable("id") long id, Model model , HttpSession session){
        User u = userService.getUserById(id);
        session.setAttribute("user",u);
        model.addAttribute("user", u);
        model.addAttribute("roles", UserRole.values());
        return "admin/users/edit_user";
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
    public String deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    /* Admin panel controller for REALTORS */

    @GetMapping("/realtors")
    public String goToRealtorsAdministration(Model model){
        Iterable<Realtor> realtors = realtorService.getAll();
        model.addAttribute("realtors", realtors);
        return "admin/realtors/admin_realtors";
    }

    @GetMapping("/realtors/add")
    public String goToAddRealtor(Model model){
        model.addAttribute("availableUsers", userService.getUsersWithDefaultRole());
        model.addAttribute("realtor", new Realtor());
        return "admin/realtors/add_realtor";
    }

    @PostMapping("/realtors/add")
    public String addRealtor(@ModelAttribute("realtor") Realtor realtor){
        realtorService.saveRealtor(realtor);
        return "redirect:/admin/realtors";
    }

    @GetMapping("/realtors/{id}")
    public String editRealtorById(@PathVariable("id") long id, Model model , HttpSession session){
        Realtor r = realtorService.getById(id);
        session.setAttribute("realtor",r);
        model.addAttribute("realtor", r);
        model.addAttribute("availableUsers", userService.getUsersWithDefaultRole());
        return "/admin/realtors/edit_realtor";
    }

    @PutMapping("/realtors/{id}")
    public String EditRealtor(@ModelAttribute("realtor") Realtor r,
                           @SessionAttribute("realtor") Realtor toUpdate,
                           HttpSession session){
        if(r.getUser() == toUpdate.getUser()){
            return "redirect:/admin/realtors";
        }
        toUpdate.getUser().setRole(UserRole.USER);
        userService.saveUser(toUpdate.getUser());
        toUpdate.setUser(r.getUser());
        userService.saveUser(toUpdate.getUser());
        realtorService.saveRealtor(toUpdate);
        session.removeAttribute("realtor");
        return"redirect:/admin/realtors";
    }

    @DeleteMapping("/realtors/{id}")
    public String deleteRealtor(@PathVariable("id") long id){
        Realtor r = realtorService.getById(id);
        r.getUser().setRole(UserRole.USER);
        userService.saveUser(r.getUser());
        realtorService.deleteRealtor(id);
        return "redirect:/admin/realtors";
    }

    /* Admin panel controller for Estates */

    @GetMapping("/estates")
    public String goToEstatesAdministration(Model model){
        Iterable<Estate> estates = estateService.getAll();
        model.addAttribute("estates", estates);
        return "admin/estates/admin_estates";
    }

    @GetMapping("/estates/add")
    public String goToAddEstate(Model model){
        model.addAttribute("states", EstateStatus.values());
        model.addAttribute("types", EstateType.values());
        model.addAttribute("estate", new Estate());
        return "admin/estates/add_estate";
    }

    @PostMapping("/estates/add")
    public String addEstate(@ModelAttribute("estate") Estate estate){
        estateService.saveEstate(estate);
        return "redirect:/admin/estates";
    }

    @GetMapping("/estates/{id}")
    public String editEstateByID(@PathVariable("id") long id, Model model , HttpSession session){
        Estate e = estateService.getEstateByID(id);
        session.setAttribute("estate",e);
        model.addAttribute("types",EstateType.values());
        model.addAttribute("statuses",EstateStatus.values());
        model.addAttribute("estate", e);
        return "admin/estates/edit_estate";
    }

    @PutMapping("/estates/{id}")
    public String editEstate(@ModelAttribute("estate") Estate e,
                              @SessionAttribute("estate") Estate toUpdate,
                              HttpSession session){
        toUpdate.setAddress(e.getAddress());
        toUpdate.setArea(e.getArea());
        toUpdate.setCost(e.getCost());
        toUpdate.setFloors(e.getFloors());
        toUpdate.setRooms(e.getRooms());
        toUpdate.setStatus(e.getStatus());
        toUpdate.setType(e.getType());
        session.removeAttribute("estate");
        estateService.saveEstate(toUpdate);
        return"redirect:/admin/estates";
    }

    @DeleteMapping("/estates/{id}")
    public String deleteEstate(@PathVariable("id") long id){
        estateService.deleteEstateByID(id);
        return "redirect:/admin/estates";
    }

    /* Admin panel controller for ADVERTISEMENTS */

    @GetMapping("/advertisements")
    public String goToAdvertsAdministration(Model model){
        Iterable<Advertisement> adverts = advertisementService.getAll();
        model.addAttribute("adverts", adverts);
        return "admin/adverts/admin_advert";
    }

    @GetMapping("/advertisements/add")
    public String goToAddAdvert(Model model){
        Iterable<Estate> estates = estateService.getAllWithoutAdverts();
        if(!estates.iterator().hasNext()){
            model.addAttribute("hasEstates", false);
        }
        model.addAttribute("realtors", realtorService.getAll());
        model.addAttribute("estates", estates);
        model.addAttribute("advert", new Advertisement());
        return "admin/adverts/add_advert";
    }

    @PostMapping("/advertisements/add")
    public String addAdvert(@ModelAttribute("advert") Advertisement advert){
        advert.setDateCreated(LocalDate.now());
        advertisementService.saveAdvert(advert);
        return "redirect:/admin/advertisements";
    }

    @GetMapping("/advertisements/{id}")
    public String goToEditAdvert(@PathVariable("id") long id, Model model , HttpSession session){
        Iterable<Estate> estates = estateService.getAllWithoutAdverts();
        Advertisement a = advertisementService.getAdvertByID(id);
        session.setAttribute("advert",a);
        model.addAttribute("realtors", realtorService.getAll());
        model.addAttribute("estates", estates);
        model.addAttribute("advert", a);
        return "admin/adverts/edit_advert";
    }

    @PutMapping("/advertisements/{id}")
    public String editAdvert(@ModelAttribute("advert") Advertisement e,
                             @SessionAttribute("advert") Advertisement toUpdate,
                             HttpSession session){
        toUpdate.setTitle(e.getTitle());
        toUpdate.setDescription(e.getDescription());
        toUpdate.setEstate(e.getEstate());
        toUpdate.setRealtor(e.getRealtor());
        session.removeAttribute("advert");
        advertisementService.saveAdvert(toUpdate);
        return"redirect:/admin/advertisements";
    }

    @DeleteMapping("/advertisements/{id}")
    public String deleteAdvert(@PathVariable("id") long id){
        advertisementService.deleteAdvertByID(id);
        return "redirect:/admin/advertisements";
    }
}
