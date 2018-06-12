package cn.motian.controller;

import cn.motian.constant.TTMSConst;
import cn.motian.exception.TTMSException;
import cn.motian.model.User;
import cn.motian.serveice.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static cn.motian.constant.TTMSConst.TTMS_RESULT_STATUS.FAIL;
import static cn.motian.constant.TTMSConst.TTMS_RESULT_STATUS.SUCCEED;


@Controller
@RequestMapping(TTMSConst.TTMS_SERVER_URL.ADMINISTRATOR)
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    @RequestMapping(params = "method=addUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addUser(
            @RequestParam String name,
            @RequestParam(required = false, defaultValue = "666666") String pass,
            @RequestParam String identity,
            @RequestParam(required = false) String teL,
            @RequestParam(required = false) String addr,
            @RequestParam(required = false) String email
            ) throws TTMSException {
        User user = new User(name, pass, identity,teL,addr,email);
        Map<String, Object> rs = new HashMap<>();
        rs.put("result", administratorService.addUser(user) ? SUCCEED : FAIL);
        return rs;
    }

    @RequestMapping(params = "method=updateUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateUser(
            @RequestParam String unionId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String pass,
            @RequestParam(required = false) String teL,
            @RequestParam(required = false) String addr,
            @RequestParam(required = false) String email
    ) throws TTMSException {
//        User user = administratorService.getByUnionId(unionId);
        User user = new User();

        user.setUnionId(unionId);
        user.setName(name);
        user.setPass(pass);
        user.setTeL(teL);
        user.setAddr(addr);
        user.setEmail(email);
        System.out.println(user);

        Map<String, Object> rs = new HashMap<>();
        rs.put("result", administratorService.updateUser(user) ? SUCCEED : FAIL);
        return rs;
    }


    @RequestMapping(params = "method=getUserByUnionId",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getByUnionId(
            @RequestParam String unionId) throws TTMSException {
        Map<String, Object> rs = new HashMap<>();
        User user = administratorService.getByUnionId(unionId);
        rs.put("user", user);
        return rs;
    }
}