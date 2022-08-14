package uz.al_jamoa.collections.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FileRepository extends JpaRepository<File, UUID> {

    Optional<File> findByGeneratedName(String generatedName);
}
