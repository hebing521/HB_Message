package kp.wsr.hb_recycleview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class MainActivity extends Activity implements DragListener {

    private RecyclerView recycleListView;
    private ItemTouchHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleListView = (RecyclerView) findViewById(R.id.recycleList);
//        recycleListView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
        recycleListView.setLayoutManager(new LinearLayoutManager(this));
        MessageAdapter adapter = new MessageAdapter(DateUtil.init(),this);
        recycleListView.setAdapter(adapter);

        helper = new ItemTouchHelper(new MessageCallback(adapter));
        helper.attachToRecyclerView(recycleListView);


    }


    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        helper.startDrag(viewHolder);
    }
}
