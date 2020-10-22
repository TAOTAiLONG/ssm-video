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

    /**
     * 分页
     * @param pn
     * @param model
     * @return
     */
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

    /**
     * 跳转到添加/修改讲师页面，并提交相关数据
     * @param speaker1
     * @param model
     * @return
     */
    @RequestMapping("/addSpeakerView")
    public String addSpeakerView(Speaker speaker1, Model model) {
        //System.out.println(speaker1.getId());

        Speaker speaker = speakerService.findSpeakerOne(speaker1.getId());
        //List<Speaker> speakerList = speakerService.findAll();

        model.addAttribute("speaker", speaker);

        return "behind/addSpeaker";
    }

    /**
     * 根据Id删除讲师信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/speakerDel")
    public String speakerDel(Integer id) {
        //System.out.println(id);

        if (speakerService.speakerDel(id) != 0){
            return "success";
        }
        return "failed";
    }

    /**
     * 更新/保存讲师信息
     * @param speaker
     * @return
     */
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
