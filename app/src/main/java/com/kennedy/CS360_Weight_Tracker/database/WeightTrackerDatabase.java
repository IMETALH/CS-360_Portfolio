package com.kennedy.CS360_Weight_Tracker.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.kennedy.CS360_Weight_Tracker.model.DailyWeight;
import com.kennedy.CS360_Weight_Tracker.model.GoalWeight;
import com.kennedy.CS360_Weight_Tracker.model.User;

/**
 * SQLite database class
 */
@Database(entities = {User.class, DailyWeight.class, GoalWeight.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class WeightTrackerDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "weightTracker.db";

    private static WeightTrackerDatabase mWeightTrackerDatabase;

    // Singleton pattern
    public static WeightTrackerDatabase getInstance(Context context) {
        if (mWeightTrackerDatabase == null) {
            mWeightTrackerDatabase = Room.databaseBuilder(context, WeightTrackerDatabase.class,
                    DATABASE_NAME).allowMainThreadQueries().build();
        }
        return mWeightTrackerDatabase;
    }

    public abstract UserDao userDao();
    public abstract DailyWeightDao dailyWeightDao();
    public abstract GoalWeightDao goalWeightDao();
}
