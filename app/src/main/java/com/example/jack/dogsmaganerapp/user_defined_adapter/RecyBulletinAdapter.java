package com.example.jack.dogsmaganerapp.user_defined_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.jack.dogsmaganerapp.R;
import com.example.jack.dogsmaganerapp.object.Bulletin;
import com.example.jack.dogsmaganerapp.user_defined_view.CircleImageView;

import java.util.List;

//继承自Recy.Adapter，指定泛型为创建好的内部类ViewHolder
public class RecyBulletinAdapter extends RecyclerView.Adapter<RecyBulletinAdapter.ViewHolder>{

    //    内部类viewHolder,里面放着recy列表单项的布局控件
    static class ViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView bullitin_icon;
        private TextView bulletin_name,bulletin_title,bulletin_time;

        public ViewHolder(View itemView) {
            super(itemView);

    //        初始化单项控件
            bullitin_icon = (CircleImageView) itemView.findViewById(R.id.image_bulletin_icon);
            bulletin_name = (TextView)itemView.findViewById(R.id.tv_bulletin_name);
            bulletin_title = (TextView)itemView.findViewById(R.id.tv_bulletin_title);
            bulletin_time = (TextView)itemView.findViewById(R.id.tv_bulletin_time);


        }
    }

    private List<Bulletin> bulletinList;
    private Context context;

//    Adapter构造方法，构造时将放着公告对象的list,和上下文传入
    public RecyBulletinAdapter(List bulletins,Context context){
        bulletinList = bulletins;
        this.context = context;
    }

    //    创建ViewHolder（模板），
//      构造视图时调用，这里在构造视图时通过LayoutInflate添加item子项布局创建view，
//          传给viewholder构造函数
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_recy_bulletin,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    //    下滑列表出现新视图是调用该方法，这里调用方法时为视图赋值
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

//        获得列表对应位置的bulletin
        Bulletin bulletin = bulletinList.get(position);
//        设置视图
        holder.bullitin_icon.setImageResource(bulletin.getBulletin_icon());
        holder.bulletin_name.setText(bulletin.getBulletin_name());
        holder.bulletin_title.setText(bulletin.getBulletin_title());
        holder.bulletin_time.setText(bulletin.getBulletin_time());
    }

    @Override
    public int getItemCount() {
        return bulletinList.size();
    }


}
