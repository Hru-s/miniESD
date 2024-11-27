package iiitb.mini.repo;

import iiitb.mini.entity.Credentials;
import iiitb.mini.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialsRepo extends JpaRepository<Credentials,Long> {
    Optional<Credentials> findByEmail(String email);
}

