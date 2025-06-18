package com.vanshii.spring.Dto;

import java.time.LocalDateTime;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseDto {

    @Version
    private Integer version;

    private String name;

    @Min(0)
    private double price;

    @Min(10)
    private int capacity;

    @Min(3)
    @Max(60)
    private int noOfDays;

    private LocalDateTime startdate;

    private String descen;

    private long mentorId;

    private LocalDateTime enroldate;

}
