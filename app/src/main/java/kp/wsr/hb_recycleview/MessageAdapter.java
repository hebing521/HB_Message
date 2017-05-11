package kp.wsr.hb_recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by HeBing on 2017/5/10 14:24
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyHolder> implements ItemTouchelperAdapterCallback{

    private final DragListener dragListener;
    private List<MessageEntity> data;
    public MessageAdapter(List<MessageEntity> data,DragListener dragListener) {
        this.dragListener = dragListener;
        this.data = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {

        MessageEntity entity = data.get(position);
        holder.iv_log.setImageResource(entity.getLog());
        holder.tv_name.setText(entity.getName());
        holder.tv_time.setText(entity.getTime());
        holder.lastMesg.setText(entity.getMessage());

        holder.iv_log.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                dragListener.onStartDrag(holder);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public boolean onItemMove(int formPosition, int toPostiion) {

        Collections.swap(data,formPosition,toPostiion);
        notifyItemMoved(formPosition,toPostiion);

        return false;
    }

    @Override
    public void onItemSwipe(int position) {


    }

    class MyHolder extends RecyclerView.ViewHolder{

        public ImageView iv_log;
        public TextView tv_name;
        public TextView tv_time;
        public TextView lastMesg;


        public MyHolder(final View itemView) {
            super(itemView);
            iv_log = (ImageView) itemView.findViewById(R.id.iv_log);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            lastMesg = (TextView) itemView.findViewById(R.id.tv_lastmsg);


        }
    }
}
