package Zut_IPZ.Inwentaryzacja.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/users"})
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping({"/{id}"})
    public User getUser(@PathVariable Long id) {
        return this.userService.getById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    @PutMapping({"/{id}"})
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return this.userService.updateUser(id, userDetails);
    }

    @DeleteMapping({"/{id}"})
    public void deleteUser(@PathVariable Long id) {
        this.userService.delete(id);
    }
}