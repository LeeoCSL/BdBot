package leonardoribeiro.bdbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstScreen extends AppCompatActivity {

    Button btnIniciar;
    Button btnQuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        btnIniciar = findViewById(R.id.btnIniciar);
        btnQuest = findViewById(R.id.btnQuest);


        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstScreen.this, MainActivity.class));
                finish();
            }
        });

        btnQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstScreen.this, QuestoesActivity.class));
                finish();
            }
        });

    }
}
