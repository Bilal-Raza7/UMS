package com.example.demo.conroller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class UserController {
    private List<User> users;

    public UserController(){users=new ArrayList<>();}
    @GetMapping("/Users")
    public List<User> getAllUsers(){return users;}
    @PostMapping("/NewUser")
    public String addUser(@RequestBody User user){
        users.add(user);
        return "User added";
    }
    @GetMapping("/UserId")
    public String getUser(@RequestParam Integer id){
        for(User MyUser: users){
            if(!MyUser.getUserId().equals(id)){
                return "user found "+MyUser;
            }
        }
        return "User Not found";
    }
    @DeleteMapping("/RemoveUser")
    public String  delUser(@RequestParam Integer id){
        for(User MyUser: users){
            if(MyUser.getUserId().equals(id)){
                users.remove(MyUser);
                return " user removed ";
            }
        }
        return "User Not Found";
    }
    @PutMapping("/UpdateInfo")
    public String updateInfo(@RequestParam Integer id, @RequestParam String name, @RequestParam String adrs,@RequestParam Long num){
        for(User userr:users){
            if(userr.getUserId().equals(id)){
                userr.setName(name);
                userr.setAddress(adrs);
                userr.setPhone(num);
            }
            else{
                return "user not found for the user id "+id;
            }
        }
        return "User info updated for user id "+id;
    }

}
