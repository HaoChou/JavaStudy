package http;

import java.util.Map;

/**
 * @author lone
 * @date 2015/10/6
 * @time 11:23
 */
public enum Ret {

    OK(200,"OK"),
    WRONG_PARAMETER(301,"参数错误"),
    MESSAGE_CACHED(302,"添加消息到缓存，并删除过期消息"),
    NOT_FOUNT(400,"不支持的url"),
    PROCESS_FAIL(400,"处理失败"),
    AUTHENTICATION_FAIL(401,"验证失败"),
    IP_RESTRICT(403,"IP限制");

    Ret(int retCode,String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }
    final int retCode;
    final String retMsg;
    public static final String RET_CODE_KEY="retCode";
    public static final String RET_MSG_KEY="retMsg" ;

    public int getRetCode() {
        return retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public static void setRet(Map<String,Object> retMap,Ret ret) {
        if(retMap == null) {
            return;
        }
        if(ret!=null) {
            retMap.put(RET_CODE_KEY,ret.retCode);
            retMap.put(RET_MSG_KEY,ret.retMsg);
        }
    }
}
