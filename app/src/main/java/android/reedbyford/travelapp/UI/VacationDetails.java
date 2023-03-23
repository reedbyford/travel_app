package android.reedbyford.travelapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.reedbyford.travelapp.Database.Repository;
import android.reedbyford.travelapp.R;
import android.reedbyford.travelapp.entities.Excursion;
import android.reedbyford.travelapp.entities.Vacation;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class VacationDetails extends AppCompatActivity {
    EditText editTitle;
    EditText editStayLocation;
    EditText editStartDate;
    EditText editEndDate;
    String title;
    String stayLocation;
    String startDate;
    String endDate;
    int vacationID;
    Vacation vacation;
    Repository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_details);
        editTitle = findViewById(R.id.vacationtitle);
        editStayLocation = findViewById(R.id.vacationstaylocation);
        editStartDate = findViewById(R.id.vacationstartdate);
        editEndDate = findViewById(R.id.vacationenddate);
        vacationID = getIntent().getIntExtra("vacationID", -1);
        title = getIntent().getStringExtra("title");
        stayLocation = getIntent().getStringExtra("stayLocation");
        startDate = getIntent().getStringExtra("startDate");
        endDate = getIntent().getStringExtra("endDate");
        editTitle.setText(title);
        editStayLocation.setText(stayLocation);
        editStartDate.setText(startDate);
        editEndDate.setText(endDate);
        repository = new Repository(getApplication());
        RecyclerView recyclerView = findViewById(R.id.excursionrecyclerview);
        final ExcursionAdapter excursionAdapter = new ExcursionAdapter(this);
        recyclerView.setAdapter(excursionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Excursion> filteredExcursions = new ArrayList<>();
        for(Excursion e : repository.getAllExcursions()){
            if(e.getVacationID() == vacationID) filteredExcursions.add(e);
        }
        Button button = findViewById(R.id.savevacation);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vacationID == -1){
                    vacation = new Vacation(0,editTitle.getText().toString(),editStayLocation.getText().toString(),editStartDate.getText().toString(),editEndDate.getText().toString());
                    repository.insert(vacation);
                }else{
                    vacation = new Vacation(vacationID,editTitle.getText().toString(),editStayLocation.getText().toString(),editStartDate.getText().toString(),editEndDate.getText().toString());
                    repository.update(vacation);
                }
            }
        });
        FloatingActionButton fab = findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent( VacationDetails.this, ExcursionDetails.class);
            startActivity(intent);
        });
    }
}