package views.zeffect.cn.darkviews;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private PercentAdapter percentAdapter;
    private List<String> datas = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        datas.add("你好");
        percentAdapter = new PercentAdapter(R.layout.item_layout, datas);
        recyclerView = (RecyclerView) findViewById(R.id.recy);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setAdapter(percentAdapter);
    }
}
