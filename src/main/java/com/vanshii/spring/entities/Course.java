package com.vanshii.spring.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "course")
@NoArgsConstructor
@Getter
@Setter
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private long id;

  @Version
  @Column(name = "version")
  private Integer version;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "price", nullable = false)
  private double price;

  @Column(name = "capacity", nullable = false)
  private int capacity;

  @Column(name = "noOfDays", nullable = false)

  private int noOfDays;

  @Column(name = "startdate", nullable = false)
  private LocalDateTime startdate;

  @Column(name = "descen")
  private String descen;

  @ManyToOne
  @JoinColumn(name = "mentorid", nullable = false)
  private Mentor mentor;

  @Column(name = "enroldate", nullable = false)
  private LocalDateTime enroldate;

  @JsonIgnore
  public LocalDateTime getEndDate() {
    return this.startdate.plusDays(this.noOfDays);
  }

}
