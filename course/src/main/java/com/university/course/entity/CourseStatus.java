package com.university.course.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long couseStatusId;
	
	@NotBlank(message = "Course status cannot be blank")
	private String courseStatus;
	
	@NotBlank(message = "Course description cannot be blank")
	private String courseDescription;
}
