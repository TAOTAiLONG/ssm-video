package com.zgl.service.impl;

import com.zgl.dao.SpeakerMapper;
import com.zgl.pojo.Speaker;
import com.zgl.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerMapper speakerMapper;

    @Override
    public List<Speaker> findAll() {
        return speakerMapper.selectByExampleWithBLOBs(null);
    }

    @Override
    public Speaker findSpeakerOne(Integer id) {
        return speakerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int UpdateSpeaker(Speaker speaker) {
        return speakerMapper.updateByPrimaryKeyWithBLOBs(speaker);
    }

    @Override
    public int saveSpeaker(Speaker speaker) {
        return speakerMapper.insertSelective(speaker);
    }

    @Override
    public void speakerDel(Integer id) {
        speakerMapper.deleteByPrimaryKey(id);
    }
}
