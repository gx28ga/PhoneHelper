package com.axun.phonehelper.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axun.phonehelper.R;
import com.axun.phonehelper.bean.AppInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.ViewHolder> {

    private List<AppInfo> mDatas = new ArrayList<>();
    private Context mContext;

    public RecommendAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AppInfo item = mDatas.get(position);

        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void setDatas(List<AppInfo> datas) {
        if (mDatas != null) {
            mDatas.addAll(datas);
            notifyDataSetChanged();
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_icon)
        ImageView imgIcon;
        @BindView(R.id.text_title)
        TextView textTitle;
        @BindView(R.id.text_size)
        TextView textSize;
        @BindView(R.id.btn_dl)
        Button btnDl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void setData(AppInfo item) {
            String baseImgUrl = "http://file.market.xiaomi.com/mfc/thumbnail/png/w150q80/";
            Picasso.with(mContext).load(baseImgUrl + item.getIcon()).into(imgIcon);
            textTitle.setText(item.getDisplayName());
            textSize.setText(item.getApkSize() / 1024 / 1024 + "MB");

        }
    }
}
