package kp.wsr.hb_recycleview;

/**
 * Created by HeBing on 2017/5/10 15:38
 */

public interface ItemTouchelperAdapterCallback {

    boolean onItemMove(int formPosition, int toPostiion);

    void onItemSwipe(int position);
}
