package com.example.leeyu.date;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by leeyu on 17-3-1.
 */

public class WednesdayIssue extends Activity{
    private ImageButton add;
    private ListView mondaything;
    SimpleCursorAdapter adapter=null;
    private DBhelper dbhelper;
    private SQLiteDatabase db;
    private TextView plan;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wednesday);
        add= (ImageButton) findViewById(R.id.we_add_issue);
        mondaything= (ListView) findViewById(R.id.we_thing);
        plan= (TextView) findViewById(R.id.we_plan);
        plan.setText("WEDNESDAY PLANS");
        dbhelper=new DBhelper(this,"week");
        //SQLiteDatabase db = openOrCreateDatabase("user.tb", MODE_PRIVATE, null);
        db=dbhelper.getReadableDatabase();
        Cursor cursor=db.query("wednesday_db",new String[]{"_id","content","start","finish"},null,null,null,null,null);
        adapter=new SimpleCursorAdapter(this,R.layout.wednesday_item,cursor,new String[]{"content","start","finish"},new int[]{R.id.we_issue,R.id.we_start_time_show,R.id.we_finish_time_show});
        mondaything.setAdapter(adapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("week","3");
                intent.setClass(WednesdayIssue.this,AddIssue.class);
                startActivity(intent);
                overridePendingTransition(R.anim.leftin,R.anim.rightout);
//                Intent intent=new Intent(WednesdayIssue.this,AddIssue.class);
//                startActivity(intent);
            }
        });
        this.registerForContextMenu(mondaything);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,4,0,"删除");
        menu.add(0,3,0,"全部删除");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case 3:
                dbhelper=new DBhelper(this,"week");
                db=dbhelper.getWritableDatabase();
                int status=db.delete("wednesday_db","_id>=0",null);
                if(status!=-1){
                    Cursor cursor=db.query("wednesday_db",new String[]{"_id","content","start","finish"},null,null,null,null,null);
                    adapter.changeCursor(cursor);
                    adapter.notifyDataSetChanged();
                    cursor.close();
                    Toast.makeText(this,"删除成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"删除失败",Toast.LENGTH_SHORT).show();
                }
                db.close();
                break;
            case 4:
                dbhelper=new DBhelper(this,"week");
                db=dbhelper.getWritableDatabase();
                status=db.delete("wednesday_db","_id=?",new String[]{""+info.id});
                if(status!=-1){
                    Cursor cursor=db.query("wednesday_db",new String[]{"_id","content","start","finish"},null,null,null,null,null);
                    adapter.changeCursor(cursor);
                    adapter.notifyDataSetChanged();
                    cursor.close();
                    Toast.makeText(this,"删除成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"删除失败",Toast.LENGTH_SHORT).show();
                }
                db.close();
                break;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Cursor cursor=db.query("wednesday_db",new String[]{"_id","content","start","finish"},null,null,null,null,null);
        adapter.changeCursor(cursor);
    }
    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.leftin,R.anim.rightout);
    }
}
