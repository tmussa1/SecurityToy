package me.afua.securitydemoagain.repository;

import me.afua.securitydemoagain.model.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
}
