package com.vanshii.spring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mentor")
@NoArgsConstructor
@Getter
@Setter
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "firstn", nullable = false)
    @NotBlank
    private String firstn;

    @Column(name = "lastn", nullable = false)
    @NotBlank
    private String lastn;

    @Column(name = "currCo", nullable = false)
    @NotBlank
    private String currCo;

    @Column(name = "yoExp", nullable = false)
    @Min(0)
    @Max(40)
    private float yoExp;

}
