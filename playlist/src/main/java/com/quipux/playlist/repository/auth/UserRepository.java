package com.quipux.playlist.repository.auth;

import com.quipux.playlist.repository.entitys.SongEntity;
import com.quipux.playlist.repository.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

}
