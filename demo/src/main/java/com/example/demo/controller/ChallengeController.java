package com.example.demo.controller;

import com.example.demo.model.Challenge;
import com.example.demo.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//import com.example.demo.repository.ChallengeRepository;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;

    @Autowired
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }


    @GetMapping
    public List<Challenge> getChallenges() {
        return challengeService.getChallenges();
    }
    @PostMapping
    public Challenge createChallenge(@RequestBody Challenge challenge) {
        return challengeService.createChallenge(challenge);
    }

    @GetMapping("/{id}")
    public Challenge getChallenge(@PathVariable Long id) {
        return challengeService.getChallenge(id);
    }

    @DeleteMapping("/{id}")
    public void deleteChallenge(@PathVariable Long id) {
        challengeService.deleteChallenge(id);
    }

    @PostMapping("/{id}/progress")
    public void addProgress(@PathVariable Long id, @RequestBody int score) {
        challengeService.addProgress(id, score, LocalDate.now());
    }

    @PutMapping("/{id}/progress/{progressId}")
    public void updateProgress(@PathVariable Long id, @PathVariable Long progressId, @RequestBody int score) {
        challengeService.updateProgress(id, progressId, score);
    }

    @GetMapping("/{id}/progress")
    public List<Integer> getProgress(@PathVariable Long id) {
        return challengeService.getProgress(id);
    }
}
