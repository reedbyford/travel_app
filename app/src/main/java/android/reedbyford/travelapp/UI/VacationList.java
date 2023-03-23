package android.reedbyford.travelapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.reedbyford.travelapp.Database.Repository;
import android.reedbyford.travelapp.R;
import android.reedbyford.travelapp.entities.Vacation;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class VacationList extends AppCompatActivity {
    private Repository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_list);
        RecyclerView recyclerView = findViewById(R.id.vacationrecyclerview);
        final VacationAdapter vacationAdapter = new VacationAdapter(this);
        recyclerView.setAdapter(vacationAdapter);
        repository = new Repository(getApplication());
        List<Vacation> allVacations = repository.getAllVacations();
        vacationAdapter.setVacations(allVacations);
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent( VacationList.this, VacationDetails.class);
            startActivity(intent);
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        List<Vacation> allVacations = repository.getAllVacations();
        RecyclerView recyclerView = findViewById(R.id.vacationrecyclerview);
        final VacationAdapter vacationAdapter = new VacationAdapter(this);
        recyclerView.setAdapter(vacationAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        vacationAdapter.setVacations(allVacations);
    }
}