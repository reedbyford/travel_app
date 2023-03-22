package android.reedbyford.travelapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.reedbyford.travelapp.Database.Repository;
import android.reedbyford.travelapp.R;
import android.reedbyford.travelapp.entities.Excursion;
import android.reedbyford.travelapp.entities.Vacation;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, VacationList.class);
                startActivity(intent);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.addSampleData:
                Vacation vacation = new Vacation(0, "Jordan", "Hotel", "11-07-23", "11-14-23");
                Repository repository = new Repository(getApplication());
                repository.insert(vacation);
                Excursion excursion = new Excursion(0, "Petra", "11-09-23", 0);
                repository.insert(excursion);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}