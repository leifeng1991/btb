package com.bishang366.app;

import android.content.Context;

import com.bishang366.data.DataRepository;
import com.bishang366.data.LocalDataSource;
import com.bishang366.data.RemoteDataSource;


/**
 * Created by Administrator on 2017/9/25.
 */

public class Injection {
    public static DataRepository provideTasksRepository(Context context) {
        return DataRepository.getInstance(RemoteDataSource.getInstance(), LocalDataSource.getInstance(context));
    }
}
