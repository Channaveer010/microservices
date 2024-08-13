package com.university.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.course.domain.CourseRequest;
import com.university.course.entity.Course;
import com.university.course.service.CourseService;
import com.university.course.service.CourseServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/courses/api/")
@Tag(name = "Courses", description = "Operations related to courses")
public class CourseController {
	private final CourseService courseService;

	public CourseController(CourseServiceImpl courseService) {
		this.courseService = courseService;
	}

	@GetMapping("/getCourse/{id}")
	@Operation(summary = "Get course by ID", description = "Retrieve a specific course by its ID. If the course exists, it will return the course details. If not, it returns a 404 Not Found response.", parameters = {
			@Parameter(name = "id", description = "The ID of the course to retrieve", required = true, example = "1") }, responses = {
					@ApiResponse(responseCode = "200", description = "Successfully retrieved the course", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Course.class))),
					@ApiResponse(responseCode = "404", description = "Course not found", content = @Content(mediaType = "application/json")),
					@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))	
	})
	public String getCourseById(@PathVariable Long id) {

		return "course";
	}
	
	@GetMapping("/getAllCourses")
	@Operation(summary = "Get all courses", description = "Retrieve all courses. If the course exists, it will return the course details. If not, it returns a empty list in the response.", responses = {
					@ApiResponse(responseCode = "200", description = "Successfully retrieved the course", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Course.class))),
					@ApiResponse(responseCode = "404", description = "Course not found", content = @Content(mediaType = "application/json")),
					@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))	
	})
	public List<Course> getAllCourses() {
		return this.courseService.getAllCourses();
	}


	
	@PostMapping("/createCourse")
	@Operation(summary = "Create Course", description = "Create Course ", parameters = {
			@Parameter(name = "id", description = "The ID of the course to retrieve", required = true, example = "1") }, responses = {
					@ApiResponse(responseCode = "200", description = "Successfully retrieved the course", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Course.class))),
					@ApiResponse(responseCode = "201", description = "Successfully created the course", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Course.class))),
			    	@ApiResponse(responseCode = "404", description = "Course not found", content = @Content(mediaType = "application/json")),
					@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))	
	})
	public Course createCourse(@RequestBody CourseRequest course) {		
		return this.courseService.createNewCouse(course);		
	}
}
