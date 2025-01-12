package com.example.demo.controller;

import com.example.demo.model.Challenge;
import com.example.demo.service.ChallengeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;


@WebMvcTest(ChallengeController.class)
public class ChallengeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChallengeService challengeService;

    @Test
    public void testGetChallenges() throws Exception {
        Challenge challenge1 = new Challenge("Name1", "Type1", LocalDate.now(), LocalDate.now().plusDays(1));
        Mockito.when(challengeService.getChallenges()).thenReturn(List.of(challenge1));
        mockMvc.perform(MockMvcRequestBuilders.get("/challenges"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCreateChallenge() throws Exception {
        Challenge challenge = new Challenge("Name1", "Type1", LocalDate.now(), LocalDate.now().plusDays(1));
        Mockito.when(challengeService.createChallenge(Mockito.any(Challenge.class))).thenReturn(challenge);
        mockMvc.perform(MockMvcRequestBuilders.post("/challenges")
                        .contentType("application/json")
                        .content("{\"name\":\"Name1\",\"type\":\"Type1\",\"startDate\":\"" + LocalDate.now() + "\",\"endDate\":\"" + LocalDate.now().plusDays(1) + "\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
