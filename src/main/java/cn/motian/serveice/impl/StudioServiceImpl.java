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
    private StudioService studioService;
    @Autowired
    private StudioMapper studioMapper;
    @Autowired
    private SeatService seatService;

    public boolean addStudio(Studio studio) {
        if (Integer.valueOf(studio.getRow()) < 15 &&
                Integer.valueOf(studio.getCol()) < 15) {
            if (studioMapper.insert(studio)) {
                Studio st = studioService.getByName(studio.getName());
                for (int i = 0; i < Integer.valueOf(studio.getRow()); i++) {
                    for (int j = 0; j < Integer.valueOf(studio.getCol()); j++) {
                        Seat seat = new Seat(st.getUnionId(), String.valueOf(i), String.valueOf(j), String.valueOf(TTMSConst.TTMS_SEAT_STATUS.valueOf("USE").getIndex()));
                        seatService.addSeat(seat);
                    }
                }
                return true;
            }
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

    @Override
    public boolean deleterStudioByName(String name) {
        return studioMapper.deleterStudioByName(name);
    }
}
