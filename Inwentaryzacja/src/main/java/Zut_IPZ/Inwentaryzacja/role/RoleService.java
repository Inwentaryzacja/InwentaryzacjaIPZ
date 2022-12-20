package Zut_IPZ.Inwentaryzacja.role;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return this.roleRepository.findAll();
    }

    public Role getById(Long id) {
        return (Role)this.roleRepository.findById(id).orElseThrow(() -> {
            return new NoSuchElementException("Role not found with id " + id);
        });
    }

    public Role addRole(Role role) {
        return (Role)this.roleRepository.save(role);
    }

    public Role updateRole(Long id, Role roleDetails) {
        Role role = this.getById(id);
        role.setName(roleDetails.getName());
        return (Role)this.roleRepository.save(role);
    }

    public void delete(Long id) {
        this.roleRepository.deleteById(id);
    }
}
