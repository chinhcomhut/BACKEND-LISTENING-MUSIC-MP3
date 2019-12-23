package com.security.demospringsecurity.service;

import com.security.demospringsecurity.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlayerService {
    void save(Player player);
    List<Player> findAllPlayer();
    Optional<Player> findById(Long id);
}
