package Zut_IPZ.Inwentaryzacja.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getById(Long id) {
        return (User)this.userRepository.findById(id).orElseThrow(() -> {
            return new NoSuchElementException("User not found with id " + id);
        });
    }

    public User addUser(User user) {
        return (User)this.userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = this.getById(id);
        user.setLogin(userDetails.getLogin());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());
        user.setVerified(userDetails.getVerified());
        user.setRole(userDetails.getRole());
        return (User)this.userRepository.save(user);
    }

    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}