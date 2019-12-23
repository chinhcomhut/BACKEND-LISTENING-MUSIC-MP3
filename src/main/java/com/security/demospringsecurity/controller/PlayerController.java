package com.security.demospringsecurity.controller;

import com.security.demospringsecurity.model.Player;
import com.security.demospringsecurity.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @PostMapping("/save")
    public ResponseEntity<?> savePlayer(@RequestBody Player player){
        try {
            playerService.save(player);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/list")
    public ResponseEntity<List<Player>> listPlayer(){
        List<Player> players = playerService.findAllPlayer();
        return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Player> findById(@PathVariable("id") Long id){
        Optional<Player> player =  playerService.findById(id);
        System.out.println(player.get());
        return new ResponseEntity<Player>(player.get(), HttpStatus.OK);
    }
}
