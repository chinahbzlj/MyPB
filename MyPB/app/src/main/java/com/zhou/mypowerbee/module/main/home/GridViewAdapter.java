package com.zhou.mypowerbee.module.main.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhou.mypowerbee.R;
import com.zhou.mypowerbee.model.entity.Device;

import java.util.List;

/**
 * Created by zhou on 17-3-14.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<Device> deviceList;

    public GridViewAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<Device> data) {
        this.deviceList = data;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return deviceList.size();
    }

    @Override
    public Object getItem(int position) {
        return deviceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        Device device = deviceList.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.view_home_grid_item, null);
            viewHolder = new ViewHolder();
            viewHolder.deviceIc = (ImageView) convertView.findViewById(R.id.img_device_ic);
            viewHolder.deviceTitle = (TextView) convertView.findViewById(R.id.tv_device_title);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.device = device;
        viewHolder.deviceTitle.setText(device.getTitle().substring(3));
        viewHolder.deviceIc.setImageResource(device.getDeviceIc());
        viewHolder.deviceIc.setTag(device);
        return convertView;
    }

    public class ViewHolder {
        ImageView deviceIc;
        TextView deviceTitle;
        Device device;
    }
}
