package com.university.course.domain;

import java.time.LocalDateTime;

import com.university.course.enums.CourseStatuses;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {	
	
	@NotBlank(message = "Course name cannot be blank")
	private String courseName;
	
	@NotBlank(message = "Couse description cannot be blank")
	private String description;
	
	@NotBlank(message = "Start date cannot be blank")
	private LocalDateTime startDate;
	
	@NotBlank(message = "Create date cannot be blank")
	private LocalDateTime createDate;
	
	@NotBlank(message = "Couse status cannot be blank")
	private CourseStatuses courseStatus;
	
	@NotBlank(message = "End date cannot be blank")
	private LocalDateTime endDate;

}
