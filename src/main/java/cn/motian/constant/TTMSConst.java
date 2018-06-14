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

    enum TTMS_PLAY_TYPE { // 剧目类型
        COMEDY(1),//喜剧
        ADVENTURE(2),//冒险
        MYSTERY(3),//悬疑
        DOCUMENTARY(4);//记录
        int index;

        TTMS_PLAY_TYPE(int index) {
            this.index = index;
        }
    }

    enum TTMS_PLAY_LANG { // 剧目语种
        Chinese(1),//中文
        English(2);//英文
        int index;

        TTMS_PLAY_LANG(int index) {
            this.index = index;
        }
    }

    enum TTMS_SEAT_STATUS { // 座位状态
        USE(1),//正常使用中
        DAMAGE(2);//损坏
        int index;

        TTMS_SEAT_STATUS(int index) {
            this.index = index;
        }
    }

    enum TTMS_SCHEDULE_STATUS { // 演出计划状态
        SHOW(1),//上映
        NOTSHOW(2);//未上映
        int index;

        TTMS_SCHEDULE_STATUS(int index) {
            this.index = index;
        }
    }

    enum TTMS_TICKET_STATUS { //票状态
        UNSOLD(1),//待销售
        SALE(2),//卖出
        NOEXIT(3);//不存在',

        int index;

        TTMS_TICKET_STATUS(int index) {
            this.index = index;
        }
    }

    enum TTMS_Order_STATUS { //订单状态
        CREATE(1),//创建
        PAY(2),//支付成功
        REFUND(3),//退款
        CANCEL(4);//取消

        int index;

        TTMS_Order_STATUS(int index) {
            this.index = index;
        }
    }
}
