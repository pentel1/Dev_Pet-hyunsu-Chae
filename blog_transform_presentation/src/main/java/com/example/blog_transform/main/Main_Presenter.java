package com.example.blog_transform.main;

import android.content.Context;

import com.example.blog_transform.Main_Contract;
import com.example.blog_transform_domain.Main_Domain.Schedule_Update_UseCase;

import java.util.ArrayList;

public class Main_Presenter  implements Main_Contract.Main_Presenter{

    Context context;
    Schedule_Update_UseCase usecase;

    public Main_Presenter(Context context) {
        this.context = context;
        this.usecase = new Schedule_Update_UseCase();
    }

    @Override
    public ArrayList<String> getRoomList_Data() {

        return null;

    }

    @Override
    public void RoomList_Touch() {

    }

    @Override
    public ArrayList<Integer> getSchedule_value() {
        return null;
    }

}
