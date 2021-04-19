package com.vmware.talentboost.finaltask.networkofgiving.controllers;

import com.vmware.talentboost.finaltask.networkofgiving.authentication.JwtUtil;
import com.vmware.talentboost.finaltask.networkofgiving.model.JsonWebTokenModel;
import com.vmware.talentboost.finaltask.networkofgiving.model.Login;
import com.vmware.talentboost.finaltask.networkofgiving.model.User;
import com.vmware.talentboost.finaltask.networkofgiving.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Login loginuser) {
        User user = userService.getUserByUsername(loginuser.getUsername());
        if(user == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Not found user with this username!");
        }
        if(!user.getPassword().equals(loginuser.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong password!");
        }
        String token = jwtUtil.generateToken(user);
        return ResponseEntity.ok(new JsonWebTokenModel(token));
    }
}
