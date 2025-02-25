package com.workintech.s19d2.controller;

import com.workintech.s19d2.dto.RegisterResponse;
import com.workintech.s19d2.dto.RegistrationMember;
import com.workintech.s19d2.entity.Member;
import com.workintech.s19d2.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegistrationMember registrationMember) {
        // Kullanıcıyı kaydet
        Member registeredMember = authenticationService.register(registrationMember.email(), registrationMember.password());

        // Yanıt oluştur ve döndür
        RegisterResponse response = new RegisterResponse(registeredMember.getEmail(), "kayıt başarılı bir şekilde gerçekleşti.");
        return ResponseEntity.ok(response);
    }


}
