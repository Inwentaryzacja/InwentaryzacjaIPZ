package Zut_IPZ.Inwentaryzacja.role;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/roles"})
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return this.roleService.getAllRoles();
    }

    @GetMapping({"/{id}"})
    public Role getRole(@PathVariable Long id) {
        return this.roleService.getById(id);
    }

    @PostMapping
    public Role addRole(@RequestBody Role role) {
        return this.roleService.addRole(role);
    }

    @PutMapping({"/{id}"})
    public Role updateRole(@PathVariable Long id, @RequestBody Role roleDetails) {
        return this.roleService.updateRole(id, roleDetails);
    }

    @DeleteMapping({"/{id}"})
    public void deleteRole(@PathVariable Long id) {
        this.roleService.delete(id);
    }
}
