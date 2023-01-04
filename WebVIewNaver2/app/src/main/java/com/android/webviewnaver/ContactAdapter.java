package com.android.webviewnaver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<ContactVO> sample;

    public ContactAdapter(Context mContext, ArrayList<ContactVO> data) {
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.sample = data;
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.contact_list, null);

        TextView contactName = (TextView) view.findViewById(R.id.contact_name);
        TextView contactPhonenum = (TextView) view.findViewById(R.id.contact_phonenum);

        contactName.setText(sample.get(position).getName());
        contactPhonenum.setText(sample.get(position).getPhonenum());

        return view;
    }
}
