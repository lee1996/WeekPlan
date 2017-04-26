package com.example.leeyu.date;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.view.Window;

import java.util.Calendar;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        DBhelper dBhelper=new DBhelper(this,"week");
        SQLiteDatabase db=dBhelper.getWritableDatabase();
        db.execSQL("create table if not exists monday_db ( _id integer primary key autoincrement , content varchar(200) , start varchar(20) , finish varchar(20))");
        db.execSQL("create table if not exists tuesday_db ( _id integer primary key autoincrement , content varchar(200) , start varchar(20) , finish varchar(20))");
        db.execSQL("create table if not exists wednesday_db ( _id integer primary key autoincrement , content varchar(200) , start varchar(20) , finish varchar(20))");
        db.execSQL("create table if not exists thursday_db ( _id integer primary key autoincrement , content varchar(200) , start varchar(20) , finish varchar(20))");
        db.execSQL("create table if not exists friday_db ( _id integer primary key autoincrement , content varchar(200) , start varchar(20) , finish varchar(20))");
        db.execSQL("create table if not exists saturday_db ( _id integer primary key autoincrement , content varchar(200) , start varchar(20) , finish varchar(20))");
        db.execSQL("create table if not exists sunday_db ( _id integer primary key autoincrement , content varchar(200) , start varchar(20) , finish varchar(20))");
      setNotification();
    }
    public void doClick(View v){
        switch (v.getId()){
            case R.id.monday:

                Intent intent1=new Intent(MainActivity.this,MondayIssue.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.leftin,R.anim.rightout);
                break;
            case R.id.tuesday:
                Intent intent2=new Intent(MainActivity.this,TuesdayIssue.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.leftin,R.anim.rightout);
                break;
            case R.id.wednesday:
                Intent intent3=new Intent(MainActivity.this,WednesdayIssue.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.leftin,R.anim.rightout);
                break;
            case R.id.thursday:
                Intent intent4=new Intent(MainActivity.this,ThursdayIssue.class);
                startActivity(intent4);
                overridePendingTransition(R.anim.leftin,R.anim.rightout);
                break;
            case R.id.friday:
                Intent intent5=new Intent(MainActivity.this,FridayIssue.class);
                startActivity(intent5);
                overridePendingTransition(R.anim.leftin,R.anim.rightout);
                break;
            case R.id.saturday:
                Intent intent6=new Intent(MainActivity.this,SaturdayIssue.class);
                startActivity(intent6);
                overridePendingTransition(R.anim.leftin,R.anim.rightout);
                break;
            case R.id.sunday:
                Intent intent7=new Intent(MainActivity.this,SundayIssue.class);
                startActivity(intent7);
                overridePendingTransition(R.anim.leftin,R.anim.rightout);
                break;

        }
    }
    /*
        用来实现下拉通知栏的效果
     */
    public void setNotification(){
        DBhelper dBhelper=new DBhelper(this,"week");
        SQLiteDatabase db=dBhelper.getWritableDatabase();
        NotificationCompat.Builder mBuilder= (NotificationCompat.Builder) new NotificationCompat.Builder(this).setSmallIcon(R.drawable.smallalarm)
                .setContentTitle("this is your week plans").setContentText("别忘了你的星期计划哦");
        Intent intent=new Intent(this,MainActivity.class);
        TaskStackBuilder builder=TaskStackBuilder.create(this);
        builder.addParentStack(MainActivity.this);
        builder.addNextIntent(intent);
        PendingIntent pendingIntent=builder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pendingIntent);
        NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0,mBuilder.build());

    }
    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.leftin,R.anim.rightout);
    }
}
