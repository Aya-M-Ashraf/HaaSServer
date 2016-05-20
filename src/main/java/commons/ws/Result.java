package commons.ws;

import commons.dto.BaseObject;

/**
 *
 * @author Aya M. Ashraf
 */
public class Result {

    private boolean success;
    private String code;
    private String msg;
    private BaseObject obj;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BaseObject getObj() {
        return obj;
    }

    public void setObj(BaseObject obj) {
        this.obj = obj;
    }
    
    
}
