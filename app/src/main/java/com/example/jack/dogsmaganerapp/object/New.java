package com.example.jack.dogsmaganerapp.object;

public class New {

    private int imag_new_icon,imag_new_from,
                    tv_new_title,tv_new_from,tv_new_time;

    //    初始化全部属性构造函数
    public New(int icon,int imag_from,int title,int time,int from){
        imag_new_icon = icon;
        imag_new_from = imag_from;
        tv_new_title = title;
        tv_new_time = time;
        tv_new_from = from;
    }

    public int getImag_new_icon() {
        return imag_new_icon;
    }

    public int getImag_new_from() {
        return imag_new_from;
    }

    public int getTv_new_title() {
        return tv_new_title;
    }

    public int getTv_new_from() {
        return tv_new_from;
    }

    public int getTv_new_time() {
        return tv_new_time;
    }

    public void setImag_new_icon(int imag_new_icon) {
        this.imag_new_icon = imag_new_icon;
    }

    public void setImag_new_from(int imag_new_from) {
        this.imag_new_from = imag_new_from;
    }

    public void setTv_new_title(int tv_new_title) {
        this.tv_new_title = tv_new_title;
    }

    public void setTv_new_from(int tv_new_from) {
        this.tv_new_from = tv_new_from;
    }

    public void setTv_new_time(int tv_new_time) {
        this.tv_new_time = tv_new_time;
    }

    @Override
    public String toString() {
        return "新闻图片："+imag_new_icon+";新闻标题："+tv_new_title +
                ";新闻时间："+tv_new_time+";新闻出处："+tv_new_from+";出处图标："+imag_new_from;
    }
}
