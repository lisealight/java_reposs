package ru.tinkoff.edu.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tinkoff.edu.repository.jpa.entity.LinkEntity;

import java.util.Optional;

public interface LinkEntityRepository extends JpaRepository<LinkEntity, Long> {
    Optional<LinkEntity> findByLink(String link);
}
