package com.roberasd.sqliteandroid.wrapper;

import android.view.View;
import android.widget.TextView;

import com.roberasd.sqliteandroid.R;

/**
 * Created by roberasd on 14/04/16.
 */
public class UsersWrapper {

    private View mView;
    private TextView mName, mLastName, mEmail, mAge;

    public UsersWrapper(View view){
        this.mView = view;
    }

    public TextView getName(){

        if(mName == null)
            mName = (TextView) mView.findViewById(R.id.item_user_name);

        return mName;
    }

    public TextView getLastName(){
        if (mLastName == null)
            mLastName = (TextView) mView.findViewById(R.id.item_user_last_name);

        return mLastName;
    }

    public TextView getEmail(){
        if (mEmail == null)
            mEmail = (TextView) mView.findViewById(R.id.item_user_email);

        return mLastName;
    }

    public TextView getAge(){
        if (mAge == null)
            mAge = (TextView) mView.findViewById(R.id.item_user_age);

        return mAge;
    }
}
