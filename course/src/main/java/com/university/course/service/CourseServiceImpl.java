package com.university.course.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.university.course.domain.CourseRequest;
import com.university.course.entity.Course;
import com.university.course.enums.CourseStatuses;
import com.university.course.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	private final CourseRepository courseRepository;

	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}


	@Transactional
	@Override
	public Course createNewCouse(CourseRequest courseRequest) {
		LocalDateTime endDateTime  = Objects.requireNonNullElse(courseRequest.getEndDate(), LocalDateTime.now().plusMonths(2));
		CourseStatuses courseStatus = getCourseStatus(endDateTime);
		Course course = Course.builder()
						.courseName(courseRequest.getCourseName())
						.courseDescription(courseRequest.getDescription())
						.courseStatus(courseStatus)						
						.startDateTime(courseRequest.getStartDate())
						.endDateTime(endDateTime)
						.createdAt(LocalDateTime.now())
						.updatedAt(LocalDateTime.now())						
						.build();	
		return this.courseRepository.save(course);
	}
	

	@Override
	public List<Course> getAllCourses() {		
		
		return this.courseRepository.findAll();
	}
	
	private CourseStatuses getCourseStatus(LocalDateTime endDateTime) {			
		return endDateTime != null && endDateTime.isBefore(LocalDateTime.now()) ? 
		           CourseStatuses.COMPLETED : 
		           CourseStatuses.DRAFT;	
	}


	
}
