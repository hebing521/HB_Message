package kp.wsr.hb_recycleview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HeBing on 2017/5/10 14:51
 */

public class DateUtil {

    public static List<MessageEntity> init() {
        List<MessageEntity> data = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            StringBuffer build =new StringBuffer();
            for(int j=0;j<i;j++){
                build.append("小波你好你好");
            }
            MessageEntity entity = new MessageEntity(R.drawable.log1, build.toString(), "1990-06-024", "你急急急");
            data.add(entity);
        }
        return data;
    }
}
