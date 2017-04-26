package com.example.leeyu.date;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by leeyu on 17-3-1.
 */

public class AddIssue extends Activity{
    private DBhelper dBhelper;
    private EditText start_time;
    private EditText finish_time;
    private EditText content;
    private Button save;
    private ImageView start_btn;
    private ImageView finish_btn;
    private static final int START_TIME=0;
    private static final int FINISH_TIME=1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addissue);
        start_time= (EditText) findViewById(R.id.start_time);
        finish_time= (EditText) findViewById(R.id.finish_time);
        content= (EditText) findViewById(R.id.content);
        save= (Button) findViewById(R.id.save);
        start_btn= (ImageView) findViewById(R.id.start_btn);
        finish_btn= (ImageView) findViewById(R.id.finish_btn);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(START_TIME);
            }
        });
        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(FINISH_TIME);
            }
        });
        /*
        获取从上一个页面返回的信息，用于判断是周几
         */
        Intent intent=getIntent();
        String week=intent.getStringExtra("week").toString();
        isWeek(week);
//        dBhelper=new DBhelper(this,"week");
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ContentValues contentValues=new ContentValues();
//                String get_start=start_time.getText().toString();
//                String get_finish=finish_time.getText().toString();
//                String get_content=content.getText().toString();
//                contentValues.put("content",get_content);
//                contentValues.put("start",get_start);
//                contentValues.put("finish",get_finish);
//                SQLiteDatabase db=dBhelper.getWritableDatabase();
//                db.insert("monday_db",null,contentValues);
//                contentValues.clear();
//                Toast.makeText(AddIssue.this,"保存成功",Toast.LENGTH_SHORT).show();
//                db.close();
//                finish();
//            }
//        });

    }
    public void isWeek(String num){
        //该方法用于判断是周几
        dBhelper=new DBhelper(this,"week");
        switch (num){
            case "1":
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ContentValues contentValues=new ContentValues();
                        String get_start=start_time.getText().toString();
                        String get_finish=finish_time.getText().toString();
                        String get_content=content.getText().toString();
                        contentValues.put("content",get_content);
                        contentValues.put("start",get_start);
                        contentValues.put("finish",get_finish);
                        SQLiteDatabase db=dBhelper.getWritableDatabase();
                        db.insert("monday_db",null,contentValues);
                        contentValues.clear();
                        Toast.makeText(AddIssue.this,"保存成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                break;
            case "2":
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ContentValues contentValues=new ContentValues();
                        String get_start=start_time.getText().toString();
                        String get_finish=finish_time.getText().toString();
                        String get_content=content.getText().toString();
                        contentValues.put("content",get_content);
                        contentValues.put("start",get_start);
                        contentValues.put("finish",get_finish);
                        SQLiteDatabase db=dBhelper.getWritableDatabase();
                        db.insert("tuesday_db",null,contentValues);
                        contentValues.clear();
                        Toast.makeText(AddIssue.this,"保存成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                break;
            case "3":
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ContentValues contentValues=new ContentValues();
                        String get_start=start_time.getText().toString();
                        String get_finish=finish_time.getText().toString();
                        String get_content=content.getText().toString();
                        contentValues.put("content",get_content);
                        contentValues.put("start",get_start);
                        contentValues.put("finish",get_finish);
                        SQLiteDatabase db=dBhelper.getWritableDatabase();
                        db.insert("wednesday_db",null,contentValues);
                        contentValues.clear();
                        Toast.makeText(AddIssue.this,"保存成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                break;
            case "4":
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ContentValues contentValues=new ContentValues();
                        String get_start=start_time.getText().toString();
                        String get_finish=finish_time.getText().toString();
                        String get_content=content.getText().toString();
                        contentValues.put("content",get_content);
                        contentValues.put("start",get_start);
                        contentValues.put("finish",get_finish);
                        SQLiteDatabase db=dBhelper.getWritableDatabase();
                        db.insert("thursday_db",null,contentValues);
                        contentValues.clear();
                        Toast.makeText(AddIssue.this,"保存成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                break;
            case "5":
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ContentValues contentValues=new ContentValues();
                        String get_start=start_time.getText().toString();
                        String get_finish=finish_time.getText().toString();
                        String get_content=content.getText().toString();
                        contentValues.put("content",get_content);
                        contentValues.put("start",get_start);
                        contentValues.put("finish",get_finish);
                        SQLiteDatabase db=dBhelper.getWritableDatabase();
                        db.insert("friday_db",null,contentValues);
                        contentValues.clear();
                        Toast.makeText(AddIssue.this,"保存成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                break;
            case "6":
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ContentValues contentValues=new ContentValues();
                        String get_start=start_time.getText().toString();
                        String get_finish=finish_time.getText().toString();
                        String get_content=content.getText().toString();
                        contentValues.put("content",get_content);
                        contentValues.put("start",get_start);
                        contentValues.put("finish",get_finish);
                        SQLiteDatabase db=dBhelper.getWritableDatabase();
                        db.insert("saturday_db",null,contentValues);
                        contentValues.clear();
                        Toast.makeText(AddIssue.this,"保存成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                break;
            case "7":
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ContentValues contentValues=new ContentValues();
                        String get_start=start_time.getText().toString();
                        String get_finish=finish_time.getText().toString();
                        String get_content=content.getText().toString();
                        contentValues.put("content",get_content);
                        contentValues.put("start",get_start);
                        contentValues.put("finish",get_finish);
                        SQLiteDatabase db=dBhelper.getWritableDatabase();
                        db.insert("sunday_db",null,contentValues);
                        contentValues.clear();
                        Toast.makeText(AddIssue.this,"保存成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                break;
            default:
                break;

        }
    }
    private TimePickerDialog.OnTimeSetListener startlistener=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            if(hourOfDay<10){
                StringBuilder sb = new StringBuilder();
                sb.append("0").append(hourOfDay).append(":").append(minute);
                start_time.setText(sb.toString());
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append(hourOfDay).append(":").append(minute);
                start_time.setText(sb.toString());
            }
            if(minute<10){
                StringBuilder sb=new StringBuilder();
                sb.append(hourOfDay).append(":").append("0").append(minute);
                start_time.setText(sb.toString());
            }else{
                StringBuilder sb=new StringBuilder();
                sb.append(hourOfDay).append(":").append(minute);
                start_time.setText(sb.toString());
            }

        }
    };
    private TimePickerDialog.OnTimeSetListener finishlistener=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            if(hourOfDay<10){
                StringBuilder sb = new StringBuilder();
                sb.append("0").append(hourOfDay).append(":").append(minute);
                finish_time.setText(sb.toString());
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append(hourOfDay).append(":").append(minute);
                finish_time.setText(sb.toString());
            }
            if (minute < 10) {
                StringBuilder sb = new StringBuilder();
                sb.append(hourOfDay).append(":").append("0").append(minute);
                finish_time.setText(sb.toString());
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(hourOfDay).append(":").append(minute);
                finish_time.setText(sb.toString());
            }


        }
    };
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case START_TIME:
                TimePickerDialog start_tpd=new TimePickerDialog(this,startlistener,Calendar.HOUR_OF_DAY,Calendar.MINUTE,true);
                start_tpd.setCancelable(true);
                start_tpd.setTitle("选择开始时间");
                start_tpd.show();
                break;
            case FINISH_TIME:
                TimePickerDialog finish_tpd=new TimePickerDialog(this,finishlistener,Calendar.HOUR_OF_DAY,Calendar.MINUTE,true);
                finish_tpd.setCancelable(true);
                finish_tpd.setTitle("选择结束时间");
                finish_tpd.show();
                break;
            default:
                break;
        }
        return null;
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.leftin,R.anim.rightout);
    }
}

