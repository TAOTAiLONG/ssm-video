package com.zgl.service.impl;

import com.zgl.dao.VideoMapper;
import com.zgl.pojo.QueryVo;
import com.zgl.pojo.Video;
import com.zgl.pojo.VideoExample;
import com.zgl.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> findAllVideo(QueryVo queryVo) {
        VideoExample example = new VideoExample();
        VideoExample.Criteria criteria = example.createCriteria();
        if (queryVo.getTitle() != null) {
            criteria.andTitleLike("%" + queryVo.getTitle() + "%");
        }
        if (queryVo.getSpeakerId() != null) {
            criteria.andSpeakerIdEqualTo(queryVo.getSpeakerId());
        }
        if (queryVo.getCourseId() != null) {
            criteria.andCourseIdEqualTo(queryVo.getCourseId());
        }
        return videoMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public int UpdateView(Video video) {
        return videoMapper.updateByPrimaryKeyWithBLOBs(video);
    }

    @Override
    public int saveView(Video video) {
        return videoMapper.insertSelective(video);
    }

    @Override
    public Video findVideoOne(Integer id) {
        return videoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteVideoById(Integer id) {
        return videoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Video findVideoById(Integer id) {
        return videoMapper.selectByPrimaryKeyWithSpeaker(id);
    }


}
