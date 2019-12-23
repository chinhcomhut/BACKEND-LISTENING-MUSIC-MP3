package com.security.demospringsecurity.service.Impl;

import com.security.demospringsecurity.model.Player;
import com.security.demospringsecurity.repository.PlayerRepository;
import com.security.demospringsecurity.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public List<Player> findAllPlayer() {
        return playerRepository.findAll();
    }

    @Override
    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }
}
