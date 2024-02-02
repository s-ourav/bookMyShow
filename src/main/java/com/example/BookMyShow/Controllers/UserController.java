package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.RequestDTOs.AddUserReq;
import com.example.BookMyShow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/addUser")
    public String addUser (@RequestBody AddUserReq addUserReq){
        return userService.addUser(addUserReq);
    }

}
