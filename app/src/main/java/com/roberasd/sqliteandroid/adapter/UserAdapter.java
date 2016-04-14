package com.roberasd.sqliteandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.roberasd.sqliteandroid.R;
import com.roberasd.sqliteandroid.models.UserModel;
import com.roberasd.sqliteandroid.wrapper.UsersWrapper;

/**
 * Created by roberasd on 14/04/16.
 */
public class UserAdapter extends ArrayAdapter<UserModel> {

    
    public UserAdapter(Context context){
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UserModel userModel = getItem(position);
        UsersWrapper wrapper;

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_view_list_users, null);
            wrapper = new UsersWrapper(convertView);
            convertView.setTag(wrapper);
        }else{
            wrapper = (UsersWrapper) convertView.getTag();
        }

        wrapper.getName().setText(userModel.getName());
        wrapper.getLastName().setText(userModel.getLastName());
        wrapper.getAge().setText(String.valueOf(userModel.getAge()));
        wrapper.getEmail().setText(userModel.getEmail());

        return convertView;
    }
}
