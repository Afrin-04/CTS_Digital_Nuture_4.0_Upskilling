//4th one
//
// package com.example.demo.controller;
//
//import com.example.demo.security.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Base64;
//import java.util.Map;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//@RestController
//public class AuthController {
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @GetMapping("/authenticate")
//    public Map<String, String> authenticate(HttpServletRequest request) {
//        String authHeader = request.getHeader("Authorization"); // e.g., "Basic dXNlcjpwd2Q="
//
//        if (authHeader == null || !authHeader.startsWith("Basic ")) {
//            throw new RuntimeException("Missing or invalid Authorization header.");
//        }
//
//        String base64Credentials = authHeader.substring("Basic ".length()).trim();
//        byte[] decoded = Base64.getDecoder().decode(base64Credentials);
//        String[] credentials = new String(decoded).split(":", 2);
//        String username = credentials[0];
//        String password = credentials[1];
//
//        // Skip revalidation because Spring Security already validated user via httpBasic
//        String token = jwtUtil.generateToken(username);
//        return Map.of("token", token);
//    }
//}


package com.example.demo.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start of authenticate()");
        LOGGER.debug("Authorization header: {}", authHeader);

        String user = getUser(authHeader);
        LOGGER.debug("Extracted user from header: {}", user);

        String token = generateJwt(user);
        LOGGER.debug("Generated token: {}", token);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("End of authenticate()");
        return map;
    }

    private String getUser(String authHeader) {
        String encodedCredentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes);
        return decodedString.split(":")[0];
    }

    private String generateJwt(String user) {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date(new Date().getTime() + 20 * 60 * 1000));
        builder.signWith(SignatureAlgorithm.HS256, "ThisIsASecretKeyUsedToSignAndVerifyJWTsWithHmacSha256ItMustBeLongEnoughToProvideSecurityAndAvoidWarningsOrExceptionsRelatedToKeyLengthEspeciallyWhenUsingStrongEncryptionAlgorithmsInProduction");
        return builder.compact();
    }
}
