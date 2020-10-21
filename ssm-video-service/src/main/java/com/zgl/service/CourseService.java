package com.zgl.service;

import com.zgl.pojo.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course findCourseOne(Integer id);

    int UpdateSpeaker(Course course);

    int saveSpeaker(Course course);

    List<Course> findCourseBySubjectId(Integer subjectId);

    Course findCourseByCourseId(Integer courseId);

    void courseDel(Integer id);
}
