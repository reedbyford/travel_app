package android.reedbyford.travelapp.Database;

import android.content.Context;
import android.reedbyford.travelapp.dao.ExcursionDAO;
import android.reedbyford.travelapp.dao.VacationDAO;
import android.reedbyford.travelapp.entities.Excursion;
import android.reedbyford.travelapp.entities.Vacation;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Vacation.class, Excursion.class}, version = 1, exportSchema = false)
public abstract class TravelDatabaseBuilder extends RoomDatabase {
    public abstract VacationDAO vacationDAO();
    public abstract ExcursionDAO excursionDAO();

    private static volatile TravelDatabaseBuilder INSTANCE;

    static TravelDatabaseBuilder getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (TravelDatabaseBuilder.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TravelDatabaseBuilder.class, "MyTravelDatabase.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
