package com.university.course.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.course.entity.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course,UUID> {

}
