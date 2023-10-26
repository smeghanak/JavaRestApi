package com.staxrt.tutorial.service;

import com.staxrt.tutorial.exception.BadRequestException;
import com.staxrt.tutorial.model.UserProfile;
import com.staxrt.tutorial.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService{

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile createUserProfile(UserProfile userProfile) throws BadRequestException{
        if(userProfile.getAddress().length()< 6 ){
            throw new BadRequestException("Error: Address length less than 6");
        }
        if(userProfile.getUserName().length() < 3){
            throw new BadRequestException("Error: Name less than 3 chars");
        }
        // 1 23nKg
        String c = userProfile.getPassword();
        Boolean hasUpperCase = false;
        for(int i=0;i<c.length();i++) {
            char currentChar = c.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                hasUpperCase = true;
                break;
//                throw new BadRequestException("Error: No upper case letter in the password");
            }
            if(i==c.length()-1){
                throw new BadRequestException("Error: No upper case letter in the password");
            }
        }
        if(!hasUpperCase){
            throw new BadRequestException("Error: No upper case letter in the password");
        }
//        char firstChar= userProfile.getPassword().charAt(0);
//        Boolean isDigit = false;
//        for(int i=0;i<=9;i++){
//            char currentChar = (char) i;
//            if(currentChar == firstChar){
//                isDigit = true;
//
//            }
//
//        }
//        if(!isDigit){
//            throw new BadRequestException("Error: First position is not integer");
//        }

//        char firstChar= userProfile.getPassword().charAt(0);
//        if(!Character.isDigit(firstChar)){
//            throw new BadRequestException("Error: First position is not integer");
//        }
        UserProfile result= userProfileRepository.save(userProfile);
        return result;
    }

}
