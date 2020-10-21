package com.zgl.service;

import com.zgl.pojo.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> findAll();

    Subject findSubjectById(Integer id);
}
