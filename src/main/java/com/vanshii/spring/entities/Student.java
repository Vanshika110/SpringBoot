package com.vanshii.spring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="student")
@Getter
@Setter

public class Student {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
@Column(name = "id", nullable = false)
private long id;
@Column(name = "firstn", nullable = false)

private String firstn;
@Column(name = "lastn", nullable = false)

private String lastn;

}
