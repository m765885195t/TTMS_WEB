package cn.motian.serveice.impl;

import cn.motian.constant.TTMSConst;
import cn.motian.mapper.PlayMapper;
import cn.motian.model.Play;
import cn.motian.serveice.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayServiceImpl implements PlayService {
    @Autowired
    private PlayMapper playMapper;

    public boolean addPlay(Play play) {
        // 需要传入play_type的字面值
        play.setType(String.valueOf(TTMSConst.TTMS_PLAY_TYPE.valueOf(play.getType()).ordinal()));
        play.setLanguage(String.valueOf(TTMSConst.TTMS_PLAY_LANG.valueOf(play.getLanguage())));

        return playMapper.insert(play);
    }

    @Override
    public Play getByUnionId(String unionId) {
        return playMapper.getByUnionId(unionId);
    }


    public Play getByName(String name) {
        return playMapper.getByName(name);
    }

    @Override
    public boolean updatePlay(Play play) {
        if (play.getType() != null) {
            play.setType(String.valueOf(TTMSConst.TTMS_PLAY_TYPE.valueOf(play.getType()).ordinal()));
        }
        if (play.getLanguage() != null) {
            play.setLanguage(String.valueOf(TTMSConst.TTMS_PLAY_LANG.valueOf(play.getLanguage())));
        }

        return playMapper.update(play);
    }

    @Override
    public List<Play> getPlayList() {
        return playMapper.getPlayList();
    }

    @Override
    public boolean deleterPlay(String unionId) {
        return playMapper.deleter(unionId);
    }
}
