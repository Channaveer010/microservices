package com.university.course.entity;



import java.time.LocalDateTime;
import java.util.UUID;

import com.university.course.enums.CourseStatuses;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID courseId;	
	
	@NotBlank(message = "Course name cannot be blank")
	@Column(columnDefinition = "course_name")
	private String courseName;
	
	@NotBlank(message = "Couse description cannot be blank")
	@Column(columnDefinition = "course_description")
	private String courseDescription;
		
	@NotBlank(message = "Start date cannot be blank")
	@Column(columnDefinition = "start_date_time")
	private LocalDateTime startDateTime;
	
	@NotBlank(message = "Start date cannot be blank")
	@Column(columnDefinition = "created_at")
	private LocalDateTime createdAt;
	
	@NotBlank(message = "Course status cannot be blank")
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "course_status")	
	private CourseStatuses courseStatus;	
	
	@NotBlank(message = "End date cannot be blank")
	@Column(columnDefinition = "end_date_time")
	private LocalDateTime endDateTime;	
	
	@NotBlank(message = "Updated date cannot be blank")
	@Column(columnDefinition = "updated_at")
	private LocalDateTime updatedAt;
	

	
}
