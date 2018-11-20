package leonardoribeiro.bdbot;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestoesActivity extends AppCompatActivity {

    TextView tvAlternativaA, tvAlternativaB, tvAlternativaC, tvAlternativaD, tvEnunciado;
    Button btnOK, btnProxima;
    List<Questao> listaQuestoes = new ArrayList<>();
    Questao questao = new Questao();
    int nota = 0;
    boolean checkA, checkB, checkC, checkD;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questoes);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = sharedPref.edit();


        loadUI();
        criaQuestoes();
        loadData();

        tvAlternativaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               checkA = true;
               checkB = false;
               checkC = false;
               checkD = false;

               selecionarAlt();
            }
        });

        tvAlternativaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkA = false;
                checkB = true;
                checkC = false;
                checkD = false;

                selecionarAlt();
            }
        });

        tvAlternativaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkA = false;
                checkB = false;
                checkC = true;
                checkD = false;

                selecionarAlt();
            }
        });

        tvAlternativaD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkA = false;
                checkB = false;
                checkC = false;
                checkD = true;

                selecionarAlt();
            }
        });


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(checkA){
                    if(questao.getCorreta().equals(questao.getAlternativaA())){
                        Toast.makeText(QuestoesActivity.this, "acertou", Toast.LENGTH_SHORT).show();
                        nota = nota+1;
                        editor.putInt("nota", nota);
                        editor.commit();
                    }else{
                        Toast.makeText(QuestoesActivity.this, "errou", Toast.LENGTH_SHORT).show();
                    }
                }else  if(checkB){
                   if(questao.getCorreta().equals(questao.getAlternativaB())){
                       Toast.makeText(QuestoesActivity.this, "acertou", Toast.LENGTH_SHORT).show();
                       nota = nota+1;
                       editor.putInt("nota", nota);
                       editor.commit();
                   }else{
                       Toast.makeText(QuestoesActivity.this, "errou", Toast.LENGTH_SHORT).show();
                   }
               }else  if(checkC){
                   if(questao.getCorreta().equals(questao.getAlternativaC())){
                       Toast.makeText(QuestoesActivity.this, "acertou", Toast.LENGTH_SHORT).show();
                       nota = nota+1;
                       editor.putInt("nota", nota);
                       editor.commit();
                   }else{
                       Toast.makeText(QuestoesActivity.this, "errou", Toast.LENGTH_SHORT).show();
                   }
               }else  if(checkD){
                   if(questao.getCorreta().equals(questao.getAlternativaD())){
                       Toast.makeText(QuestoesActivity.this, "acertou", Toast.LENGTH_SHORT).show();
                       nota = nota+1;
                       editor.putInt("nota", nota);
                       editor.commit();
                   }else{
                       Toast.makeText(QuestoesActivity.this, "errou", Toast.LENGTH_SHORT).show();
                   }
               }
               btnOK.setVisibility(View.GONE);
                btnProxima.setVisibility(View.VISIBLE);
            }
        });

        btnProxima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaQuestoes.remove(i);
                checkA = false;
                checkB = false;
                checkC = false;
                checkD = false;
                if(listaQuestoes.isEmpty()){
                    startActivity(new Intent());
                }
                loadData();

                btnProxima.setVisibility(View.GONE);
                btnOK.setVisibility(View.VISIBLE);
            }
        });
    }

    private void selecionarAlt() {
        if(checkA){
            tvAlternativaA.setTypeface(tvAlternativaA.getTypeface(), Typeface.BOLD);
            tvAlternativaB.setTypeface(tvAlternativaB.getTypeface(), Typeface.NORMAL);
            tvAlternativaC.setTypeface(tvAlternativaC.getTypeface(), Typeface.NORMAL);
            tvAlternativaD.setTypeface(tvAlternativaD.getTypeface(), Typeface.NORMAL);
        } else if(checkB){
            tvAlternativaA.setTypeface(tvAlternativaA.getTypeface(), Typeface.NORMAL);
            tvAlternativaB.setTypeface(tvAlternativaB.getTypeface(), Typeface.BOLD);
            tvAlternativaC.setTypeface(tvAlternativaC.getTypeface(), Typeface.NORMAL);
            tvAlternativaD.setTypeface(tvAlternativaD.getTypeface(), Typeface.NORMAL);
        }else if(checkC){
            tvAlternativaA.setTypeface(tvAlternativaA.getTypeface(), Typeface.NORMAL);
            tvAlternativaB.setTypeface(tvAlternativaB.getTypeface(), Typeface.NORMAL);
            tvAlternativaC.setTypeface(tvAlternativaC.getTypeface(), Typeface.BOLD);
            tvAlternativaD.setTypeface(tvAlternativaD.getTypeface(), Typeface.NORMAL);
        }else if(checkD){
            tvAlternativaA.setTypeface(tvAlternativaA.getTypeface(), Typeface.NORMAL);
            tvAlternativaB.setTypeface(tvAlternativaB.getTypeface(), Typeface.NORMAL);
            tvAlternativaC.setTypeface(tvAlternativaC.getTypeface(), Typeface.NORMAL);
            tvAlternativaD.setTypeface(tvAlternativaD.getTypeface(), Typeface.BOLD);
        }
    }

    private void loadData() {
        if(listaQuestoes.size() > 1) {
            Random r = new Random();
            i = r.nextInt(listaQuestoes.size() - 1);
        }else{
            i = 0;
        }


        questao = listaQuestoes.get(i);

        tvEnunciado.setText(questao.getEnunciado());
        tvAlternativaA.setText(questao.getAlternativaA());
        tvAlternativaB.setText(questao.getAlternativaB());
        tvAlternativaC.setText(questao.getAlternativaC());
        tvAlternativaD.setText(questao.getAlternativaD());
    }

    private void loadUI() {
        checkA = false;
        checkB = false;
        checkC = false;
        checkD = false;

        tvAlternativaA = findViewById(R.id.tvAlternativaA);
        tvAlternativaB = findViewById(R.id.tvAlternativaB);
        tvAlternativaC = findViewById(R.id.tvAlternativaC);
        tvAlternativaD = findViewById(R.id.tvAlternativaD);
        tvEnunciado = findViewById(R.id.tvEnunciado);
        btnOK = findViewById(R.id.btnOK);
        btnProxima = findViewById(R.id.btnProxima);
    }

    public void criaQuestoes(){

        Questao q1 = new Questao();
            q1.setEnunciado("1º O nome atribuído a um conjunto de valores de um atributo é denominado o seu:");
            q1.setAlternativaA("a – relacionamento");
            q1.setAlternativaB("b – cardinalidade");
            q1.setAlternativaC("c – domínio");
            q1.setAlternativaD("d – classe");
            q1.setCorreta(q1.getAlternativaC());

        Questao q2 = new Questao();
        q2.setEnunciado("2º Se a entidade é identificada como forte, logo ela:");
        q2.setAlternativaA("a – não tem relacionamento");
        q2.setAlternativaB("b – possui atributos");
        q2.setAlternativaC("c – pode ser reduzida");
        q2.setAlternativaD("d – tem participação total");
        q2.setCorreta(q2.getAlternativaC());

        Questao q3 = new Questao();
        q3.setEnunciado("3º Cada instância do esquema é chamada de :");
        q3.setAlternativaA("a – tabela");
        q3.setAlternativaB("b - tupla");
        q3.setAlternativaC("c – coluna");
        q3.setAlternativaD("d – conjunto");
        q3.setCorreta(q3.getAlternativaB());

        Questao q4 = new Questao();
        q4.setEnunciado("4º O diagrama Entidade Relacionamento, é tipicamente utilizado para elaboração de modelo de dados :");
        q4.setAlternativaA("a – físico");
        q4.setAlternativaB("b – lógico");
        q4.setAlternativaC("c – relacional");
        q4.setAlternativaD("d – conceitual");
        q4.setCorreta(q4.getAlternativaD());

        Questao q5 = new Questao();
        q5.setEnunciado("6º  No modelo lógico buscamos a essência da normalização para:");
        q5.setAlternativaA("a - remover redundâncias");
        q5.setAlternativaB("b - definir entidades");
        q5.setAlternativaC("c - fazer atribuições ");
        q5.setAlternativaD("d - instanciar objetos");
        q5.setCorreta(q5.getAlternativaA());

        Questao q6 = new Questao();
        q6.setEnunciado("1º O nome atribuído a um conjunto de valores de um atributo é denominado o seu:");
        q6.setAlternativaA("a – relacionamento");
        q6.setAlternativaB("b – cardinalidade");
        q6.setAlternativaC("c – domínio");
        q6.setAlternativaD("d – classe");
        q6.setCorreta(q6.getAlternativaC());

        Questao q7 = new Questao();
        q7.setEnunciado("7º No mundo lógico, temos como produto :");
        q7.setAlternativaA("a - chaves primárias e estrangeiras");
        q7.setAlternativaB("b - os registros de dados que aparecerão no banco");
        q7.setAlternativaC("c - relação");
        q7.setAlternativaD("d - Modelo Entidade Relacionamento (MER)");
        q7.setCorreta(q7.getAlternativaC());

        Questao q8 = new Questao();
        q8.setEnunciado("8º Uma entidade é forte quando:");
        q8.setAlternativaA("a - sua existência é distinguível de outras entidades");
        q8.setAlternativaB("b - é dependente de outras entidades ");
        q8.setAlternativaC("c - não possui chave primária");
        q8.setAlternativaD("d - possui atributo chave parcial");
        q8.setCorreta(q8.getAlternativaA());

        Questao q9 = new Questao();
        q9.setEnunciado("9º Em um banco de dados a função do índice é:");
        q9.setAlternativaA("a – facilitar a visualização de uma tabela.");
        q9.setAlternativaB("b – referenciar unicamente uma instância de uma tabela.");
        q9.setAlternativaC("c – filtrar instâncias de uma tabela");
        q9.setAlternativaD("d – acelerar o tempo de acesso às linhas de uma tabela.");
        q9.setCorreta(q9.getAlternativaD());

        Questao q10 = new Questao();
        q10.setEnunciado("10º  Tuplas são?");
        q10.setAlternativaA("a - Um funcionário de um posto");
        q10.setAlternativaB("b - Um pedaço do mundo real");
        q10.setAlternativaC("c - Uma regra de negócio da empresa");
        q10.setAlternativaD("d - Um produto cartesiano de dois conjuntos");
        q10.setCorreta(q10.getAlternativaB());

        listaQuestoes.add(q1);
        listaQuestoes.add(q2);
        listaQuestoes.add(q3);
        listaQuestoes.add(q4);
        listaQuestoes.add(q5);
        listaQuestoes.add(q6);
        listaQuestoes.add(q7);
        listaQuestoes.add(q8);
        listaQuestoes.add(q9);
        listaQuestoes.add(q10);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, FirstScreen.class));
    }
}
