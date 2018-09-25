package com.example.jack.dogsmaganerapp.object;

public class Bulletin {


    private int bulletin_icon;
    private int bulletin_name,bulletin_title,bulletin_time;

//    无参数构造函数
    public Bulletin(){

    }
//    初始化全部属性构造函数
    public Bulletin(int icon,int name,int title,int time){
        bulletin_icon = icon;
        bulletin_name = name;
        bulletin_title = title;
        bulletin_time = time;
    }


//    set/get方法
    public int getBulletin_icon() {
        return bulletin_icon;
    }

    public int getBulletin_name() {
        return bulletin_name;
    }

    public int getBulletin_title() {
        return bulletin_title;
    }

    public int getBulletin_time() {
        return bulletin_time;
    }

    public void setBulletin_icon(int bulletin_icon) {
        this.bulletin_icon = bulletin_icon;
    }

    public void setBulletin_name(int bulletin_name) {
        this.bulletin_name = bulletin_name;
    }

    public void setBulletin_title(int bulletin_title) {
        this.bulletin_title = bulletin_title;
    }

    public void setBulletin_time(int bulletin_time) {
        this.bulletin_time = bulletin_time;
    }

    @Override
    public String toString() {
        return "公告部门图标："+bulletin_icon+"/n"
                +"公告部门名称："+bulletin_name+"/n"
                +"公告标题："+bulletin_title+"/n"
                +"公告时间："+bulletin_time;
    }
}
