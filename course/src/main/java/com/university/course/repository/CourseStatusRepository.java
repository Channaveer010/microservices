package com.university.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.course.entity.CourseStatus;

@Repository
public interface CourseStatusRepository extends JpaRepository<CourseStatus, Long> {

}
