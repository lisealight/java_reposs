package ru.tinkoff.edu.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.tinkoff.edu.repository.jpa.entity.TgChatEntity;

import java.util.Optional;

public interface TgChatEntityRepository extends JpaRepository<TgChatEntity, Long> {
    Optional<TgChatEntity> findByTgChatId(Long tgChatId);

    @Modifying
    @Query(value="insert into chat (tg_chat_id) values (:tg_chat_id) on conflict do nothing",
            nativeQuery = true)
    void insertTgChat(@Param("tg_chat_id") Long tgChatId);
}
