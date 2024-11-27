package iiitb.mini.mapper;

import iiitb.mini.dto.LoginRequest;
//import iiitb.mini.dto.dto.CustomerResponse;
import iiitb.mini.entity.Credentials;
import iiitb.mini.dto.LoginRequest;
import iiitb.mini.entity.Credentials;
import org.springframework.stereotype.Service;

@Service
public class CredentialsMapper {
    public Credentials toCreds(LoginRequest request) {
        return Credentials.builder()
                .email(request.email())
                .password(request.password())
                .build();
    }

//    public CustomerResponse toCustomerResponse(Customer customer) {
//        return new CustomerResponse(customer.getFirstName(), customer.getLastName(), customer.getEmail());
//    }
}
