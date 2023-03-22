package android.reedbyford.travelapp.entities;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "vacations")
public class Vacation {
    @PrimaryKey(autoGenerate = true)
    private int vacationID;
    private String title;
    private String stayLocation;
    private String startDate;
    private String endDate;

    public Vacation(int vacationID, String title, String stayLocation, String startDate, String endDate) {
        this.vacationID = vacationID;
        this.title = title;
        this.stayLocation = stayLocation;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Vacation() {
    }

    public int getVacationID() {
        return vacationID;
    }

    public void setVacationID(int vacationID) {
        this.vacationID = vacationID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStayLocation() {
        return stayLocation;
    }

    public void setStayLocation(String stayLocation) {
        this.stayLocation = stayLocation;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
