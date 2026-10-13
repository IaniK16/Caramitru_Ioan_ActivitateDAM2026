package com.example.s02;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("seminar", "Starting");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("seminar", "Resuming");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("seminar", "Pausing");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("seminar", "Restarting");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("seminar", "Destroying");
    }

    public void deschideActivitate(View view) {
        Intent it = new Intent(this, ActivitateRezultat.class);

        Bundle bundle = new Bundle();
        bundle.putString("mesaj", "Mesaj din Activitate NOUA ");
        bundle.putInt("numar1", 5);
        bundle.putInt("numar2", 7);
        it.putExtras(bundle);

        startActivityForResult(it,83);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 83) {
            if(resultCode == RESULT_OK) {
                String mesajIntors=data.getStringExtra("mesaj");
                int suma=data.getIntExtra("suma",0);

                Toast.makeText(this,mesajIntors + " " + suma,Toast.LENGTH_SHORT).show();

            }

        }
    }



}