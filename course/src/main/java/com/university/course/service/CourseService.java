package com.university.course.service;

import java.util.List;

import com.university.course.domain.CourseRequest;
import com.university.course.entity.Course;



public interface CourseService {
	
	public Course createNewCouse(CourseRequest courseRequest);
	
	public List<Course> getAllCourses();
	

}
