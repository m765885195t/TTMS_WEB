package cn.motian.serveice.impl;

import cn.motian.mapper.StudioMapper;
import cn.motian.mapper.UserMapper;
import cn.motian.model.Studio;
import cn.motian.serveice.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudioServiceImpl implements StudioService {

    @Autowired
    private StudioMapper studioMapper;
    public boolean addStudio(Studio studio) {
        return studioMapper.insert(studio);
    }
}
