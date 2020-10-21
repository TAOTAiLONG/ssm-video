package com.zgl.service.impl;

import com.zgl.dao.SubjectMapper;
import com.zgl.pojo.Subject;
import com.zgl.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<Subject> findAll() {

        return subjectMapper.selectByExample(null);
    }

    @Override
    public Subject findSubjectById(Integer id) {
        return subjectMapper.selectByPrimaryKeyWithCourseAndVideo(id);
    }
}
