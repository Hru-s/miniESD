package iiitb.mini.service;

import iiitb.mini.dto.LoginRequest;
//import com.prashantjain.esdtestingprogram.exception.CustomerNotFoundException;
import iiitb.mini.entity.Credentials;
import iiitb.mini.helper.EncryptionService;
import iiitb.mini.helper.JWTHelper;
import iiitb.mini.mapper.CredentialsMapper;
import iiitb.mini.repo.CredentialsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final CredentialsRepo credentialsRepo;
    private final CredentialsMapper credentialsMapper;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;

    public String login(LoginRequest request) {
        Credentials credentials = credentialsRepo.findByEmail(request.email())
                .orElseThrow(() -> new IllegalArgumentException("email doesnot exist"));
        if(!encryptionService.validates(request.password(), credentials.getPassword())) {
            return "Wrong Password or Email";
        }

        return jwtHelper.generateToken(String.valueOf(credentials.getId()));
    }

    public String createUser(LoginRequest request) {
        Credentials credentials = credentialsMapper.toCreds(request);
        credentials.setPassword(encryptionService.encode(credentials.getPassword()));
        credentialsRepo.save(credentials);
        return "Customer Created Successfully";
    }
}
