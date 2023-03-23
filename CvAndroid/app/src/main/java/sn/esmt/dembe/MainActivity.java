package sn.esmt.dembe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sn.esmt.dembe.model.Cv;
import sn.esmt.dembe.retrofit.CvApi;
import sn.esmt.dembe.retrofit.RetrofitService;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Orientation vers la page de visualisation des CV

        MaterialButton buttonVisualition = findViewById(R.id.form_buttonVisualisation);
        buttonVisualition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CvListActivity.class);
                startActivity(intent);
            }
        });

        //Orientation vers la page d'enrollement des CV

        MaterialButton buttonEnrollement = findViewById(R.id.form_buttonEnrollement);
        buttonEnrollement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CvSaveActivity.class);
                startActivity(intent);
            }
        });



    }
}