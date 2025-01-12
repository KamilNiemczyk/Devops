package com.example.demo.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenge;

    private int score;

    private LocalDate progress_date;

    public Progress() {
    }

    public Progress(Challenge challenge, int score, LocalDate progress_date) {
        this.challenge = challenge;
        this.score = score;
        this.progress_date = progress_date;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDate getProgress_date() {
        return progress_date;
    }

    public void setProgress_date(LocalDate progress_date) {
        this.progress_date = progress_date;
    }

    public String toString() {
        return "Progress [ID=" + id + ", challenge=" + challenge + ", score=" + score + ", progress_date=" + progress_date + "]";
    }
}
