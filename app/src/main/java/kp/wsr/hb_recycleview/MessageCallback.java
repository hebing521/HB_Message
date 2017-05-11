package kp.wsr.hb_recycleview;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by HeBing on 2017/5/10 15:19
 */

public class MessageCallback extends ItemTouchHelper.Callback {

    private final ItemTouchelperAdapterCallback adapterCallback;

    public MessageCallback(ItemTouchelperAdapterCallback adapterCallback) {
        this.adapterCallback = adapterCallback;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //判断是否允许侧滑和拖拽
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

        adapterCallback.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        adapterCallback.onItemSwipe(direction);
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
//            float alpha = 1 - Math.abs(dX) / viewHolder.itemView.getWidth();
//            viewHolder.itemView.setAlpha(alpha);
//            viewHolder.itemView.setScaleX(alpha);
//            viewHolder.itemView.setScaleY(alpha);
//
//            if (alpha <= 0) {
//                viewHolder.itemView.setAlpha(1);
//                viewHolder.itemView.setScaleX(1);
//                viewHolder.itemView.setScaleY(1);
//            }

            if(dX<-0.5f*viewHolder.itemView.getWidth()){
                viewHolder.itemView.setTranslationX(-0.5f*viewHolder.itemView.getWidth());
            }else{
                viewHolder.itemView.setTranslationX(dX);
            }
        } else {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

        }
    }
}