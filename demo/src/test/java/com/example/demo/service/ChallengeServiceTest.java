package com.example.demo.service;

import com.example.demo.model.Challenge;
import com.example.demo.repository.ChallengeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ChallengeServiceTest {

    @Mock
    private ChallengeRepository challengeRepository;

    @InjectMocks
    private ChallengeService challengeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetChallenges() {
        Challenge challenge1 = new Challenge("Name1", "Type2", LocalDate.now(), LocalDate.now().plusDays(1));
        Challenge challenge2 = new Challenge("Name2", "Type2", LocalDate.now(), LocalDate.now().plusDays(2));

        List<Challenge> challenges = new ArrayList<>();
        challenges.add(challenge1);
        challenges.add(challenge2);

        when(challengeRepository.findAll()).thenReturn(challenges);

        List<Challenge> result = challengeService.getChallenges();

        assertEquals(2, result.size());
        assertEquals(challenge1, result.get(0));
        assertEquals(challenge2, result.get(1));
    }

    @Test
    public void testCreateChallenge() {
        Challenge challenge = new Challenge("Name1", "Type1", LocalDate.now(), LocalDate.now().plusDays(1));
        when(challengeRepository.save(challenge)).thenReturn(challenge);
        Challenge result = challengeService.createChallenge(challenge);
        assertEquals(challenge, result);
    }

    @Test
    public void testGetChallengeById() {
        Challenge challenge = new Challenge("Name1", "Type1", LocalDate.now(), LocalDate.now().plusDays(1));
        when(challengeRepository.findById(1L)).thenReturn(java.util.Optional.of(challenge));
        Challenge result = challengeService.getChallenge(1L);
        assertEquals(challenge, result);
    }

}