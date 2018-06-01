package cn.motian.controller;

import cn.motian.constant.TTMSConst;
import cn.motian.exception.TTMSException;
import cn.motian.model.User;
import cn.motian.serveice.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(params = "method=addUser")
    @ResponseBody
    public Map<String, Object> addUser(@RequestParam String name,
                                       @RequestParam(required = false, defaultValue = "666666") String pass,
                                       @RequestParam String identity) throws TTMSException {
        User user = new User(name, pass, identity);
        Map<String, Object> rs = new HashMap<>();
        rs.put("result", administratorService.addUser(user) ? SUCCEED : FAIL);
        return rs;
    }

    @RequestMapping(params = "method=updateUser")
    @ResponseBody
    public Map<String, Object> updateUser(@RequestParam String name,
                                          @RequestParam String pass,
                                          @RequestParam String unionId) throws TTMSException {
        Map<String, Object> rs = new HashMap<>();
        User user = administratorService.updateUser(unionId, name, pass);
        rs.put("result", user == null ? SUCCEED : FAIL);
        return rs;
    }


    @RequestMapping(params = "method=getUserByUnionId")
    @ResponseBody
    public Map<String, Object> getByUnionId(
            @RequestParam String unionId) throws TTMSException {
        Map<String, Object> rs = new HashMap<>();
        User user = administratorService.getByUnionId(unionId);
        rs.put("user", user);
        return rs;
    }
}