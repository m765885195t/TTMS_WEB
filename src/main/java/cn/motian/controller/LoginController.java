package cn.motian.controller;

import cn.motian.constant.TTMSConst;
import cn.motian.serveice.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static cn.motian.constant.TTMSConst.TTMS_RESULT_STATUS.FAIL;

@Controller
@RequestMapping(TTMSConst.TTMS_SERVER_URL.LOGIN)
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(params = "method=login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(
            @RequestParam String name,
            @RequestParam String pass) {
        Map<String, Object> rs = new HashMap<>();
        String result = loginService.login(name, pass);
        rs.put("result", result != null ? result : FAIL);
        return rs;
    }
}
