package Zut_IPZ.Inwentaryzacja.user;

import Zut_IPZ.Inwentaryzacja.error.exception.RoleWithGivenNameDoesNotExist;
import Zut_IPZ.Inwentaryzacja.role.Role;
import Zut_IPZ.Inwentaryzacja.role.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> {
            return new NoSuchElementException("User not found with id " + id);
        });
    }

    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = this.getById(id);
        user.setLogin(userDetails.getLogin());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());
        user.setVerified(userDetails.getVerified());
        user.setRole(userDetails.getRole());
        return this.userRepository.save(user);
    }

    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsByLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    public User saveUser(User user, Role.Name nameOfRole) {
        Role role = roleRepository.findByName(nameOfRole).orElseThrow(() -> new RoleWithGivenNameDoesNotExist("Role with given name: " + nameOfRole.name() + "does not exist"));
        user.setRole(role);
        return userRepository.save(user);
    }
}