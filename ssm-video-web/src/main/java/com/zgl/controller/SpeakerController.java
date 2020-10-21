package com.zgl.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zgl.pojo.Course;
import com.zgl.pojo.QueryVo;
import com.zgl.pojo.Speaker;
import com.zgl.pojo.Video;
import com.zgl.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("/showSpeakerList")
    public String speaker_list(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             Model model) {
        //引入分页插件
        //在查询之前只需要调用  传入页码 以及分页大小
        PageHelper.startPage(pn,5);
        //startPage后面紧跟的查询就是一个分页查询
        List<Speaker> speakerList = speakerService.findAll();

        PageInfo pageInfo = new PageInfo(speakerList,5);//连续显示的页数
        model.addAttribute("pageInfo",pageInfo);

        return "behind/speakerList";//携带数据
    }

    @RequestMapping("/addSpeaker")
    public String addVideo(Speaker speaker1, Model model) {
        System.out.println(speaker1.getId());

        Speaker speaker = speakerService.findSpeakerOne(speaker1.getId());
        //List<Speaker> speakerList = speakerService.findAll();

        model.addAttribute("speaker", speaker);

        return "behind/addSpeaker";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Speaker speaker) {

        if (speaker.getId() != null) {
            speakerService.UpdateSpeaker(speaker);
        } else {
            speakerService.saveSpeaker(speaker);
        }

        return "redirect:/speaker/showSpeakerList";
    }

}
