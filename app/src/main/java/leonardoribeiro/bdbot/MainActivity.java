package leonardoribeiro.bdbot;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String idUser = "0";
    String idBot = "1";

    EditText editMensagem;

    List<Mensagem> mensagens = new ArrayList<>();
    RecyclerView recyclerMensagens;
    private MensagensAdapter adapter;

    private List<Mensagem> listaPopulaRecycler = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        editMensagem = findViewById(R.id.editMensagem);
        recyclerMensagens = findViewById(R.id.recyclerMensagens);

//        adapter = new MensagensAdapter(mensagem, getApplicationContext());
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerMensagens.setLayoutManager(layoutManager);
//        recyclerMensagens.setHasFixedSize(true);
//        recyclerMensagens.setAdapter(adapter);

        criaPrimeiraMensagem();

        populaRecycler();


    }

    private void criaPrimeiraMensagem() {
        Mensagem m = new Mensagem();
        m.setIdUser(idBot);
        m.setMensagem(respostasBot.getMensagemBot( "inicio", this));
//        m.setMensagem("Olá");
        mensagens.add(m);
    }

    private void populaRecycler() {
        listaPopulaRecycler.clear();
        for(int i = 0; i < mensagens.size(); i++){
            listaPopulaRecycler.add(mensagens.get(i));
        }
        loadRecycler();
    }

    private void loadRecycler() {

        recyclerMensagens.setHasFixedSize(true);

        recyclerMensagens.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) recyclerView.getLayoutManager();
                MensagensAdapter adapter = (MensagensAdapter) recyclerView.getAdapter();
                if (listaPopulaRecycler.size() == llm.findLastCompletelyVisibleItemPosition() + 1) {

                }
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerMensagens.setLayoutManager(llm);


        MensagensAdapter adapter = new MensagensAdapter(listaPopulaRecycler, getApplicationContext());

        recyclerMensagens.setAdapter(adapter);
        recyclerMensagens.scrollToPosition(mensagens.size() - 1);
    }


    public void enviarMensagem(View view){
        String textoMensagem = editMensagem.getText().toString();
        if(!textoMensagem.isEmpty()){
            Mensagem mensagem = new Mensagem();
            mensagem.setIdUser(idUser);
            mensagem.setMensagem(textoMensagem);
            mensagens.add(mensagem);
            editMensagem.setText("");

            populaRecycler();

            verificaRespostaBot(mensagem.getMensagem());

        }else{
            Toast.makeText(this, "Digite uma mensagem para enviar", Toast.LENGTH_SHORT).show();
        }
    }

    private void verificaRespostaBot(String mensagem) {

        Mensagem msgUser = new Mensagem();
        msgUser.setIdUser(idBot);
        msgUser.setMensagem(respostasBot.getMensagemBot(mensagem, this));
        mensagens.add(msgUser);
        populaRecycler();
    }

}
