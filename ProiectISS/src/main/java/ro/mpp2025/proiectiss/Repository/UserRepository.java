package ro.mpp2025.proiectiss.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mpp2025.proiectiss.Domain.User;

import java.time.LocalDate;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByPhoneNumber(String phoneNumber);
    User findByAddress(String address);
    User findByDateOfBirth(LocalDate dateOfBirth);

}