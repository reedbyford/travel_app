package android.reedbyford.travelapp.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "excursions")
public class Excursion {
    @PrimaryKey(autoGenerate = true)
    private int excursionID;
    private String title;
    private String date;
    private int VacationID;

    public Excursion(int excursionID, String title, String date, int vacationID) {
        this.excursionID = excursionID;
        this.title = title;
        this.date = date;
        VacationID = vacationID;
    }

    public Excursion() {
    }

    public int getExcursionID() {
        return excursionID;
    }

    public void setExcursionID(int excursionID) {
        this.excursionID = excursionID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getVacationID() {
        return VacationID;
    }

    public void setVacationID(int vacationID) {
        VacationID = vacationID;
    }
}
