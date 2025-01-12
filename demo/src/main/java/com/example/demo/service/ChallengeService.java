package com.example.demo.service;


import com.example.demo.model.Challenge;
import com.example.demo.model.Progress;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ChallengeRepository;
import com.example.demo.repository.ProgressRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {

    private final ChallengeRepository challengeRepository;
    private final ProgressRepository progressRepository;

    public ChallengeService(ChallengeRepository challengeRepository, ProgressRepository progressRepository) {
        this.challengeRepository = challengeRepository;
        this.progressRepository = progressRepository;
    }

    public void deleteChallenge(Long id) {
        challengeRepository.deleteById(id);
    }

    public void addProgress(Long id, int score, LocalDate date) {
        Challenge challenge = challengeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Challenge not found"));
        Progress progress = new Progress(challenge, score, date);
        challenge.addProgress(progress);
        challengeRepository.save(challenge);
    }

    public void updateProgress(Long id, Long progressId, int score) {
        Progress progress = progressRepository.findById(progressId).orElseThrow(() -> new IllegalArgumentException("Progress not found"));
        progress.setScore(score);
        progressRepository.save(progress);
    }

    public List<Integer> getProgress(Long id) {
        Challenge challenge = challengeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Challenge not found"));
        List<Integer> progress = new ArrayList<>();
        for (Progress p : challenge.getProgress()) {
            progress.add(p.getScore());
        }
        return progress;
    }

    public Challenge createChallenge(Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    public Challenge getChallenge(Long id) {
        return challengeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Challenge not found"));
    }

    public List<Challenge> getChallenges() {
        return challengeRepository.findAll();
    }




}
