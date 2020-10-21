package com.zgl.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zgl.pojo.*;
import com.zgl.service.CourseService;
import com.zgl.service.SpeakerService;
import com.zgl.service.SubjectService;
import com.zgl.service.VideoService;
import com.zgl.utils.Msg;
import com.zgl.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private SpeakerService speakerService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private SubjectService subjectService;

    /**
     * 查询video列表
     * @param pageNum
     * @param model
     * @param queryVo
     * @return
     */
    @RequestMapping("/list")
    public String video_list(@RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             Model  model,
                             QueryVo queryVo) {
        model.addAttribute("queryVo",queryVo);
        System.out.println(queryVo);
        System.out.println(pageNum);
        //引入分页插件
        //在查询之前只需要调用  传入页码 以及分页大小
        PageHelper.startPage(pageNum,5);
        //startPage后面紧跟的查询就是一个分页查询
        List<Video> videos = videoService.findAllVideo(queryVo);
        /*for (Video video : videos) {
            String time = StringUtils.getTimeByInt(video.getTime());
            video.setTime(time);
        }*/

        List<Speaker> speakerList = speakerService.findAll();
        List<Course> courseList = courseService.findAll();

        PageInfo pageInfo = new PageInfo(videos,5);//连续显示的页数
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("speakerList", speakerList);
        model.addAttribute("courseList", courseList);

        return "behind/videoList";//携带数据
    }

    @RequestMapping("/addVideo")
    public String addVideo(Video video1, Model model) {
//        System.out.println(video1.getTitle());
//        System.out.println(video1.getId());

        Video video = videoService.findVideoOne(video1.getId());
        List<Speaker> speakerList = speakerService.findAll();
        List<Course> courseList = courseService.findAll();

        model.addAttribute("video", video);
        model.addAttribute("speakerList", speakerList);
        model.addAttribute("courseList", courseList);

        return "behind/addVideo";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Video video) {

        if (video.getId() != null) {
            videoService.UpdateView(video);
        } else {
            videoService.saveView(video);
        }

        return "redirect:/video/list";
    }


    /**
     * 根据id删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/videoDel")
    public String videoDel(Integer id){

        int res = videoService.deleteVideoById(id);
        if (res != 0) {
            return "success";
        }
        System.out.println("-----------");

        return "fail";
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/delBatchVideos")
    public String videoDel(Integer[] ids){

        int res = 0;
        for (Integer id : ids) {
            res = videoService.deleteVideoById(id);
        }
        if (res != 0) {
            return "redirect:/video/list";
        }
        System.out.println("-----------");

        return "删除失败!";
    }


    @RequestMapping("/showVideo")
    public String showVideo(Integer videoId, String subjectName, Model model) {
        //System.out.println(videoId + " : " + subjectName);

        Video video = videoService.findVideoById(videoId);
        //System.out.println(video);
        Course course = courseService.findCourseByCourseId(video.getCourseId());
        List<Subject> subjectList = subjectService.findAll();

        model.addAttribute("subjectList", subjectList);
        model.addAttribute("course", course);
        model.addAttribute("video", video);
        model.addAttribute("subjectName", subjectName);

        return "before/section";
    }

    /*@ResponseBody
    @RequestMapping("/showVideo")
    public Msg showVideo() {

        Video video = videoService.findVideoById(218);

        System.out.println(video);
        *//*Course course = courseService.findCourseByCourseId(video.getCourseId());*//*

        *//*model.addAttribute("course", course);
        model.addAttribute("video", video);
        model.addAttribute("subjectName", subjectName);*//*

        return Msg.success().add("video", video);
    }*/




    /*public String video_list(@RequestParam(defaultValue = "1",required = false) Integer pageNum,
                             @RequestParam(defaultValue = "2",required = false) Integer pageSize,
                             Model  model,
                             QueryVo queryVo){

        model.addAttribute("queryVo",queryVo);

        System.out.println(queryVo.getTitle());

        PageHelper.startPage(pageNum,pageSize);

        List<Video> videos = videoService.findAllVideo(queryVo);
        List<Speaker> speakerList = speakerService.findAll();
        List<Course> courseList = courseService.findAll();

        PageInfo<Video> pageInfo = new PageInfo<>(videos);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("speakerList", speakerList);
        model.addAttribute("courseList", courseList);

        return "behind/videoList";//携带数据
    }*/





}
