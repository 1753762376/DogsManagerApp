package com.example.jack.dogsmaganerapp.user_defined_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.jack.dogsmaganerapp.R;
import com.example.jack.dogsmaganerapp.object.New;

import java.util.List;

//继承自Recy.Adapter，指定泛型为创建好的内部类ViewHolder
public class RecyNewsAdapter extends RecyclerView.Adapter<RecyNewsAdapter.ViewHolder>{

    //    内部类viewHolder,里面放着recy列表单项的布局控件
    static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imag_new_icon,imag_new_from;
        private TextView tv_new_title,tv_new_from,tv_new_time;

        public ViewHolder(View itemView) {
            super(itemView);

            //        初始化单项控件
            imag_new_icon = (ImageView) itemView.findViewById(R.id.imag_new);
            imag_new_from = (ImageView) itemView.findViewById(R.id.imag_new_from);
            tv_new_title = (TextView)itemView.findViewById(R.id.tv_new_title);
            tv_new_from = (TextView)itemView.findViewById(R.id.tv_new_from);
            tv_new_time = (TextView)itemView.findViewById(R.id.tv_new_time);


        }
    }

    private List<New> newsList;
    private Context context;

    //    Adapter构造方法，构造时将放着公告对象的list,和上下文传入
    public RecyNewsAdapter(List bulletins,Context context){
        newsList = bulletins;
        this.context = context;
    }

    //    创建ViewHolder（模板），
//      构造视图时调用，这里在构造视图时通过LayoutInflate添加item子项布局创建view，
//          传给viewholder构造函数
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_recy_news,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    //    下滑列表出现新视图是调用该方法，这里调用方法时为视图赋值
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

//        获得列表对应位置的bulletin
       New myNew = newsList.get(position);
//        设置视图
        holder.imag_new_icon.setImageResource(myNew.getImag_new_icon());
        holder.imag_new_from.setImageResource(myNew.getImag_new_from());
        holder.tv_new_title.setText(myNew.getTv_new_title());
        holder.tv_new_from.setText(myNew.getTv_new_from());
        holder.tv_new_time.setText(myNew.getTv_new_time());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }


}
