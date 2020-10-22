package com.zgl.service;

import com.zgl.pojo.QueryVo;
import com.zgl.pojo.Video;

import java.util.List;

public interface VideoService {

    List<Video> findAllVideo(QueryVo queryVo);

    int UpdateVideo(Video video);

    int saveVideo(Video video);

    Video findVideoOne(Integer id);

    int deleteVideoById(Integer id);

    Video findVideoById(Integer id);
}
