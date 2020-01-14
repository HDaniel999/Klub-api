package com.controllers;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.configs.JwtTokenProvider;
import com.models.User;
import com.repositories.UserRepository;
import com.services.CustomUserDetailsService;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(
origins = "http://localhost:4200/signup", 
allowedHeaders = "*", 
methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class AuthController {
	
	 @Autowired
	    AuthenticationManager authenticationManager;

	    @Autowired
	    JwtTokenProvider jwtTokenProvider;

	    @Autowired
	    UserRepository users;

	    @Autowired
	    private CustomUserDetailsService userService;

	    @SuppressWarnings("rawtypes")
	    @CrossOrigin(origins = "*")
	    @PostMapping("/login")
	    public ResponseEntity login(@RequestBody AuthBody data) {
	        try {
	            String username = data.getEmail();
	            String fullname = this.users.findByEmail(username).getFullname();
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
	            String token = jwtTokenProvider.createToken(username, this.users.findByEmail(username).getRoles());
	            Map<Object, Object> model = new HashMap<>();
	            model.put("username", username);
	            model.put("token", token);
	            model.put("fullname", fullname);
	            return ok(model);
	        } catch (AuthenticationException e) {
	            throw new BadCredentialsException("Invalid email/password supplied");
	        }
	    }

	    @SuppressWarnings("rawtypes")
	    @CrossOrigin(origins = "*")
	    @PostMapping("/register")
	    public ResponseEntity register(@RequestBody User user) {
	        User userExists = userService.findUserByEmail(user.getEmail());
	        User friendCodeExists = userService.findUserByMyFriendCode(user.getFriendCode());
	        if (userExists != null) {
	            throw new BadCredentialsException("User with username: " + user.getEmail() + " already exists");
	        } else if (friendCodeExists == null) {
	        	throw new BadCredentialsException("Friend Code invalid.");
	        }
	        userService.saveUser(user);
	        Map<Object, Object> model = new HashMap<>();
	        model.put("message", "User registered successfully");
	        System.out.println("Usuario Registrado");
	        return ok(model);
	    }
	    
	    @RequestMapping(method=RequestMethod.GET, value="/users")
	    @CrossOrigin(origins = "*")
	    public Iterable<User> user() {
	    	System.out.println("Usuarios GET");
	        return users.findAll();
	    }

}
