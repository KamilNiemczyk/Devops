package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private LocalDate start_date;
    private LocalDate end_date;
    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
    private List<Progress> progress;

    public Challenge() {
    }
    public Challenge(String name, String type, LocalDate start_date, LocalDate end_date) {
        this.name = name;
        this.type = type;
        this.start_date = start_date;
        this.end_date = end_date;
    }

        public String getName() {
            return name;
        }
        public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public LocalDate getStart_date() {
        return start_date;
    }
    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }
    public LocalDate getEnd_date() {
        return end_date;
    }
    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }
    public String toString() {
        return "Challenge [ID=" + id + ", name=" + name + ", type=" + type + ", start_date=" + start_date + ", end_date=" + end_date + "]";
    }
    public void addProgress(Progress progress) {
        this.progress.add(progress);
    }
    public List<Progress> getProgress() {
        return progress;
    }
}
