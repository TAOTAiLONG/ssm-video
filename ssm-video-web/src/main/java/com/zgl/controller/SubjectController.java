package com.zgl.controller;

import com.zgl.pojo.Subject;
import com.zgl.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    /**
     * 查询所有课程分类信息
     * @param model
     * @return
     */
    @RequestMapping("/selectAll")
    public String subject_selectAll(Model model) {
        List<Subject> subjectList = subjectService.findAll();

        model.addAttribute("subjectList", subjectList);

        return "/before/index";
    }
}
