package leonardoribeiro.bdbot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class QuestoesActivity extends AppCompatActivity {

    TextView tvAlternativaA, tvAlternativaB, tvAlternativaC, tvAlternativaD, tvEnunciado;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questoes);

        loadUI();
        loadData();

    }

    private void loadData() {
        Questao questao = new Questao();
        questao.setEnunciado("Enunciado");
        questao.setAlternativaA("Alternativa a");
        questao.setAlternativaB("Alternativa b");
        questao.setAlternativaC("Alternativa c");
        questao.setAlternativaD("Alternativa d");
        questao.setTema("Conceitual");
        questao.setCorreta("a");

        tvEnunciado.setText(questao.getEnunciado());
        tvAlternativaA.setText(questao.getAlternativaA());
        tvAlternativaB.setText(questao.getAlternativaB());
        tvAlternativaC.setText(questao.getAlternativaC());
        tvAlternativaD.setText(questao.getAlternativaD());
    }

    private void loadUI() {
        tvAlternativaA = findViewById(R.id.tvAlternativaA);
        tvAlternativaB = findViewById(R.id.tvAlternativaB);
        tvAlternativaC = findViewById(R.id.tvAlternativaC);
        tvAlternativaD = findViewById(R.id.tvAlternativaD);
        tvEnunciado = findViewById(R.id.tvEnunciado);
        btnOK = findViewById(R.id.btnOK);
    }
}
