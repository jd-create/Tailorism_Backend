package nl.novi.jdemeijervandriel.tailorism.controller;

import nl.novi.jdemeijervandriel.tailorism.domain.User;
import nl.novi.jdemeijervandriel.tailorism.payload.LoginRequest;
import nl.novi.jdemeijervandriel.tailorism.payload.SignupRequest;
import nl.novi.jdemeijervandriel.tailorism.payload.response.JwtResponse;
import nl.novi.jdemeijervandriel.tailorism.payload.response.MessageResponse;
import nl.novi.jdemeijervandriel.tailorism.service.AuthorizationService;
import nl.novi.jdemeijervandriel.tailorism.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthorizationService authorizationService;

//    @Autowired
//    UserDetailsServiceImpl userDetails;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return authorizationService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@RequestBody SignupRequest signUpRequest) {
        return authorizationService.registerUser(signUpRequest);
    }

    //Deze request wordt gebruikt in de Frontend in de functie GetUserData omdat
    // uit de Token alleen de username te halen is en we naar een reset nog steeds ingelogd willen blijven

//    @GetMapping(value = "/600/user/{username}")
//    public ResponseEntity<Object> getUser(@PathVariable("username") String username){
//        User user = (User) userDetails.loadUserByUsername(username);
//        System.out.println("getUser");
//                return new ResponseEntity<>(user, HttpStatus.OK);
//    }

}
