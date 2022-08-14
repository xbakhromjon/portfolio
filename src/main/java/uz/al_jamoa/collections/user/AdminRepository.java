package uz.al_jamoa.collections.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
