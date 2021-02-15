package com.valunskii.majo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Entry {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "day_of_week")
    private Integer dayOfWeek;

    @Column(name = "time")
    private LocalTime time;//'date' and 'time' field

    @Column(name = "duration")
    private LocalTime duration;//'duration' of meditation

    @Column(name = "salutation_1")
    private LocalTime salutation1;

    @Column(name = "salutation_2")
    private LocalTime salutation2;

    @Column(name = "salutation_3")
    private LocalTime salutation3;

    @Column(name = "meditation")
    private String meditationField;

    @Column(name = "result")
    private String resultField;

    @Column(name = "daily")
    private String dailyLifeField;

    @Column(name = "other")
    private String otherField;

    @Column(name = "sunrise_time")
    private String sunriseTime;

    @Column(name = "sunset_time")
    private String sunsetTime;

    @Column(name = "moon_phase")
    private String moonPhase;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="user_id")
    private User user;

    public Entry(
            LocalDate date,
            Integer dayOfWeek,
            String sunriseTime,
            String sunsetTime,
            String moonPhase
            ) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.moonPhase = moonPhase;
    }
}
