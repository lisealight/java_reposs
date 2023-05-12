package ru.tinkoff.edu.java.scrapper.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.tinkoff.edu.java.scrapper.entity.jpa.JpaLink;

import java.sql.Timestamp;
import java.util.List;



public interface LinkRepository extends JpaRepository<JpaLink, Long> {

    @Modifying
    @Query(value="insert into link(url, last_update) values (:url, :last_update) on conflict do nothing",
            nativeQuery = true)
    void saveLink(@Param("url") String url, @Param("last_update") Timestamp timestamp);

    @Modifying
    @Query(value="SELECT id, url, last_update FROM link WHERE last_update < :newTime",nativeQuery = true)
    List<JpaLink> findAllForUpdate(@Param("newTime") Timestamp newTime);


    @Modifying(clearAutomatically = true)
    @Query(value="UPDATE link SET last_update = :newTime WHERE id = :id",nativeQuery = true)
    void updateLinkUpdateTime(@Param("newTime") Timestamp newTime, @Param("id")Long id);


    JpaLink findByUrl(String linkRequest);

    boolean existsByUrl(String linkRequest);
}
