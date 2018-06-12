package cn.motian.constant;

public interface TTMSConst {
    class TTMS_SERVER_URL {
        public static final String ADMINISTRATOR = "/administrator";// 管理员主页面
        public static final String MANAGER = "/manager";// 经理主页面
        public static final String CONDUCTOR = "/conductor";// 售票员主页面
        public static final String LOGIN = "/login";// 登录

    }

    class TTMS_RESULT_STATUS { // 返回结果状态集
        public static final String SUCCEED = "succeed";
        public static final String FAIL = "fail";

    }
}
