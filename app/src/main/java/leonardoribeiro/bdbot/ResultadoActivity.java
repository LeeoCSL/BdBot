package leonardoribeiro.bdbot;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    Button btnOK;
    TextView tvNota;
    int nota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        btnOK = findViewById(R.id.btnOK);
        tvNota = findViewById(R.id.tvNota);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

         nota = sharedPref.getInt("nota", 0);
         tvNota.setText("Você acertou " + nota + "questões");

         btnOK.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(ResultadoActivity.this, FirstScreen.class));
                 finish();
             }
         });

    }
}
