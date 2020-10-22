package com.zgl.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zgl.pojo.Course;
import com.zgl.pojo.Speaker;
import com.zgl.pojo.Subject;
import com.zgl.service.CourseService;
import com.zgl.service.SubjectService;
import com.zgl.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private SubjectService subjectService;

    /**
     * 根据课程分类查询相应课程
     * @param subjectId
     * @param model
     * @return
     */
    @RequestMapping(value = "/course/{subjectId}")
    public String course(@PathVariable("subjectId") Integer subjectId, Model model) {
        System.out.println(subjectId);

        //List<Course> courseList = courseService.findCourseBySubjectId(subjectId);

        List<Subject> subjectList = subjectService.findAll();

        model.addAttribute("subjectList", subjectList);

        Subject subject = subjectService.findSubjectById(subjectId);


        //courseService.findCourseBySubjectId(subjectId);

        /*Subject subjectList = subjectService.findSubjectById(id);*/


        model.addAttribute("subjectList", subjectList);
        model.addAttribute("subject", subject);
        //Subject subjectList = subjectService.findSubjectById(id);

        //return Msg.success().add("subject", subject);

        return "before/course";
    }


    /**
     * 分页
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("/showCourseList")
    public String course_list(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             Model model) {
        //引入分页插件
        //在查询之前只需要调用  传入页码 以及分页大小
        PageHelper.startPage(pn,5);
        //startPage后面紧跟的查询就是一个分页查询
        List<Course> courseList = courseService.findAll();

        PageInfo pageInfo = new PageInfo(courseList,5);//连续显示的页数
        model.addAttribute("pageInfo",pageInfo);

        return "behind/courseList";//携带数据
    }

    /**
     * 添加课程分类
     * @param course1
     * @param model
     * @return
     */
    @RequestMapping("/addCourse")
    public String addVideo(Course course1, Model model) {
        //System.out.println(course1.getId());

        Course course = courseService.findCourseOne(course1.getId());

        model.addAttribute("course", course);

        return "behind/addCourse";
    }

    /**
     * 根据Id删除课程信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/courseDel")
    public String courseDel(Integer id) {
        System.out.println(id);

        courseService.courseDel(id);

        return "success";
    }

    /**
     * 保存或更新Course
     * @param course
     * @return
     */
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Course course) {

        if (course.getId() != null) {
            courseService.UpdateSpeaker(course);
        } else {
            courseService.saveSpeaker(course);
        }

        return "redirect:/course/showCourseList";
    }
}
