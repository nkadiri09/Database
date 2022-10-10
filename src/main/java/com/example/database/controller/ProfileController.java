package com.example.database.controller;

import com.example.database.entity.Profile;
import com.example.database.repo.ProfileRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/profile")
public class ProfileController {

    @Autowired private
    ProfileRepository profileRepository;

    //@PostMapping(path = "/create")
    public @ResponseBody
    String createProfile(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {

        Profile profile = new Profile();
        profile.setFirstName(firstName);
        profile.setLastName(lastName);
        profile.setEmail(email);
        Profile save = profileRepository.save(profile);
        return "User Created: "+save.getEmail();
    }

    @PostMapping(path = "/create")
    @ResponseBody // to send back the response body to Client in Normal Controller
    String createProfile(@RequestBody @NotNull Profile profile) {
        Profile save = profileRepository.save(profile);
        return "Profile Created with EmailID: "+save.getEmail();
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable <Profile> fetchAllProfile() {
        return profileRepository.findAll();
    }

    @GetMapping("/")
    public @ResponseBody Profile getProfile(@RequestParam String email) {
        return profileRepository.findByEmail(email);
    }

    @DeleteMapping("/")
    public @ResponseBody Profile deleteProfile(@RequestParam String email) {
        return profileRepository.findByEmail(email);
    }

    @PutMapping("/update/{email}")
    @ResponseBody
    String updateProfile(@RequestBody @NotNull Profile profile, @PathVariable String email) {
        Profile byEmail = profileRepository.findByEmail(email);
        byEmail.setPassword(profile.getPassword());
        profileRepository.save(byEmail);
        return "Profile Updated for : "+email;
    }

}