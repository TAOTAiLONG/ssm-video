package com.zgl.service.impl;

import com.zgl.dao.CourseMapper;
import com.zgl.pojo.Course;
import com.zgl.pojo.CourseExample;
import com.zgl.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findAll() {
        return courseMapper.selectByExampleWithBLOBs(null);
    }

    @Override
    public Course findCourseOne(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int UpdateSpeaker(Course course) {
        return courseMapper.updateByPrimaryKeyWithBLOBs(course);
    }

    @Override
    public int saveSpeaker(Course course) {
        return courseMapper.insertSelective(course);
    }

    @Override
    public List<Course> findCourseBySubjectId(Integer subjectId) {
        CourseExample example = new CourseExample();
        CourseExample.Criteria criteria = example.createCriteria();
        criteria.andSubjectIdEqualTo(subjectId);
        return courseMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public Course findCourseByCourseId(Integer courseId) {
        return courseMapper.selectByPrimaryKeyWithVideo(courseId);
    }
}
