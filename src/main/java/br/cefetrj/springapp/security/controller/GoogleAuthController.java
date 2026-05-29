package br.cefetrj.springapp.security.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth")
public class GoogleAuthController {

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    private String clientSecret;

    @Value("${spring.security.oauth2.client.registration.google.redirect-uri}")
    private String redirectUri;

    @PostMapping("/google")
    public ResponseEntity<?> exchangeCodeForToken(@RequestParam("code") String code) {

        String tokenEndpoint = "https://oauth2.googleapis.com/token";

        RestTemplate restTemplate = new RestTemplate();

        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Body
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("code", code);
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);
        body.add("redirect_uri", redirectUri);
        body.add("grant_type", "authorization_code");

        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                tokenEndpoint,
                HttpMethod.POST,
                request,
                Map.class
        );

        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());
    }
}