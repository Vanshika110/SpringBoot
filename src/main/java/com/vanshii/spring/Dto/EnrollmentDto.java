package com.vanshii.spring.Dto;

import java.time.LocalDateTime;
import com.vanshii.spring.enums.CourseStatus;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class EnrollmentDto {
    private long studentid;

    private long courseid;

    private LocalDateTime enroldate;

    private CourseStatus status = CourseStatus.ACTIVE;
}
