package com.staxrt.tutorial.controller;

import com.staxrt.tutorial.exception.BadRequestException;
import com.staxrt.tutorial.exception.ResourceNotFoundException;
import com.staxrt.tutorial.model.UserProfile;
import com.staxrt.tutorial.repository.UserProfileRepository;
import com.staxrt.tutorial.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/userProfile")
public class UserProfileController {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/userProfile")
    public List<UserProfile> getUserProfiles(){
        List<UserProfile> result = userProfileRepository.findAll();
        return result;
    }

    @GetMapping("/userProfile/{id}")
    public ResponseEntity<UserProfile> getProfileId(@PathVariable(value = "id")Long profileId) throws ResourceNotFoundException{
        UserProfile profile = userProfileRepository.findById(profileId)
                            .orElseThrow(() -> new ResourceNotFoundException("Profile not found on ::" + profileId));
        return ResponseEntity.ok().body(profile);

    }

    @PostMapping("/userProfile")
    public UserProfile createProfile(@RequestBody UserProfile x) throws BadRequestException {
        UserProfile result= userProfileService.createUserProfile(x);
        return result;
    }

    @PutMapping("/userProfile/{id}")
    public ResponseEntity<UserProfile> updateUser(@PathVariable(value ="id")Long profileId,@RequestBody UserProfile userDetails) throws ResourceNotFoundException,BadRequestException{
        UserProfile user= userProfileRepository.findById(profileId)
                       .orElseThrow(() -> new ResourceNotFoundException("Profile not found on : " + profileId));

        user.setUserName(userDetails.getUserName());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());
        user.setAddress(userDetails.getAddress());
        UserProfile updatedUser = userProfileService.createUserProfile(user);
        return ResponseEntity.ok().body(updatedUser);

    }


    @DeleteMapping("/userProfile")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "abc") Long profileId) throws Exception{
        UserProfile profile= userProfileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found on :: " + profileId));

        userProfileRepository.delete(profile);
        Map<String, Boolean> result = new HashMap<>();
        result.put("deleted", true);
        return result;
    }

}
