package io.github.henriqueaguiiar.user_registry_core_api.domain.repository;

import io.github.henriqueaguiiar.user_registry_core_api.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {

}
