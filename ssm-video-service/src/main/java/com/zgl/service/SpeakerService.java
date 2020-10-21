package com.zgl.service;

import com.zgl.pojo.Speaker;

import java.util.List;

public interface SpeakerService {

    List<Speaker> findAll();

    Speaker findSpeakerOne(Integer id);

    int UpdateSpeaker(Speaker speaker);

    int saveSpeaker(Speaker speaker);

    void speakerDel(Integer id);
}
