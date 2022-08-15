package uz.al_jamoa.collections.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import uz.al_jamoa.collections.auth.dto.LoginDto;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @GetMapping(path = "/login/{username}/{password}")
    public ResponseEntity<?> login(@PathVariable String username, @PathVariable String password) throws JsonProcessingException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Bad Credentials", HttpStatus.BAD_REQUEST);
        }
        String token = jwtService.createJwt(username);
        return ResponseEntity.ok(token);
    }

}
