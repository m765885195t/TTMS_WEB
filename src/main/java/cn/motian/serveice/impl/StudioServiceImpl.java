package cn.motian.serveice.impl;

import cn.motian.constant.TTMSConst;
import cn.motian.mapper.StudioMapper;
import cn.motian.model.Seat;
import cn.motian.model.Studio;
import cn.motian.serveice.SeatService;
import cn.motian.serveice.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioServiceImpl implements StudioService {

    @Autowired
    private StudioMapper studioMapper;
    @Autowired
    private SeatService seatService;

    public boolean addStudio(Studio studio) {
        if (studioMapper.insert(studio)) {
            for (int i = 0; i < studio.getRow(); i++) {
                for (int j = 0; j < studio.getCol(); j++) {
                    Seat seat = new Seat(studio.getUnionId(), i, j, String.valueOf(TTMSConst.TTMS_SEAT_STATUS.valueOf("USE").getIndex()));
                    seatService.addSeat(seat);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public Studio getByUnionId(String unionId) {
        return studioMapper.getByUnionId(unionId);
    }

    @Override
    public Studio getByName(String name) {
        return studioMapper.getByName(name);
    }

    @Override
    public boolean updateStudio(Studio studio) {
        return studioMapper.update(studio);
    }

    @Override
    public List<Studio> getStudioList() {
        return studioMapper.getStudioList();
    }

    @Override
    public boolean deleterStudio(String unionId) {
        if (seatService.deleterSeat(unionId)) {
            return studioMapper.deleter(unionId);
        }
        return false;
    }
}
