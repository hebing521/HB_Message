package kp.wsr.hb_recycleview;

/**
 * Created by HeBing on 2017/5/10 14:10
 */

public class MessageEntity {

    private int log;
    private String name;
    private String time;
    private String message;

    public int getLog() {
        return log;
    }

    public void setLog(int log) {
        this.log = log;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageEntity(int log, String name, String time, String message) {
        this.log = log;
        this.name = name;
        this.time = time;
        this.message = message;
    }
}
