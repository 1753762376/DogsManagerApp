package com.example.jack.dogsmaganerapp.user_difined_view;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class CircleImageView extends AppCompatImageView{

//    控件大小长宽
    private float width;
    private float height;
//    圆形半径
    private float radius;
//    画笔
    private Paint paint;
//    控制图片旋转、缩放，裁剪的矩阵
    private Matrix matrix;

//    imageview的三个构造函数
    public CircleImageView(Context context)
    {
        this(context, null);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        paint = new Paint();//初始化画笔
        paint.setAntiAlias(true); //设置抗锯齿
        matrix = new Matrix(); //初始化缩放矩阵
    }

    /** * 测量控件的宽高，并获取其内切圆(因控件默认是矩形，所以这里称为内切圆）的半径 */
    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
//        半径为控件长宽中断的一边的一半
        radius = Math.min(width, height) / 2;
    }

//    绘制
    @Override protected void onDraw(Canvas canvas)
    {
        paint.setShader(initBitmapShader());//将着色器设置给画笔
//        参数：圆心x、圆心y，半径、画笔
        canvas.drawCircle(width / 2, height / 2, radius, paint);//使用画笔在画布上画圆
    }

    /** * 获取ImageView中资源图片的Bitmap
     * ，利用Bitmap初始化图片着色器,通过缩放矩阵将原资源图片缩放到铺满整个绘制区域
     * ，避免边界填充 */

    private BitmapShader initBitmapShader()
    {
//        bitmap代表图片信息，英语直译为位图
        Bitmap bitmap = ((BitmapDrawable) getDrawable()).getBitmap();
//        shader直译著色器
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//        求图片缩放比例，单精度类型小数。
//        控件的长宽/图片的长宽分别获得长宽的缩放比例，有限满足大的，否则长边将无法再控件中显示
        float scale = Math.max(width / bitmap.getWidth(), height / bitmap.getHeight());
        matrix.setScale(scale, scale);//将图片宽高等比例缩放，避免拉伸
//        把设置好缩放比例的图片矩阵告诉著色器
        bitmapShader.setLocalMatrix(matrix);
        return bitmapShader;
    }



}
