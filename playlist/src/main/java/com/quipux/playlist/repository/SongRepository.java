package com.quipux.playlist.repository;

import com.quipux.playlist.repository.entitys.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository  extends JpaRepository<SongEntity, Long> {

    List<SongEntity> findByTitleIn(List<String> titles);

}
