package pl.sasieczno.familyLibrary.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sasieczno.familyLibrary.config.JwtService;
import pl.sasieczno.familyLibrary.model.Owner;
import pl.sasieczno.familyLibrary.model.Role;
import pl.sasieczno.familyLibrary.repository.OwnerRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final OwnerRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        Owner owner = Owner.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(owner);
        var jwtToken = jwtService.generateToken(owner);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        Owner owner = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(owner);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
