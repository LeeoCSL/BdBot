package leonardoribeiro.bdbot;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MensagensAdapter extends RecyclerView.Adapter<MensagensAdapter.MyViewHolder> {

    private List<Mensagem> mensagens;
    private Context context;
    private static final int TIPO_REMETENTE = 0;
    private static final int TIPO_DESTINATARIO = 1;


    public MensagensAdapter(List<Mensagem> lista, Context c) {
        this.mensagens = lista;
        this.context = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item = null;

        if (viewType == TIPO_REMETENTE) {

             item = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_mensagem_remetente, parent, false);

        } else if (viewType == TIPO_DESTINATARIO) {
             item = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_mensagem_destinatario, parent, false);
        }

        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        Mensagem mensagem = mensagens.get(position);
        String msg = mensagem.getMensagem();

        myViewHolder.mensagem.setText(Html.fromHtml(msg));
    }

    @Override
    public int getItemCount() {
        return mensagens.size();
    }

    @Override
    public int getItemViewType(int position) {

        Mensagem mensagem = mensagens.get(position);
        if (mensagem.getIdUser().equalsIgnoreCase("0")) {
            return TIPO_REMETENTE;
        }
        return TIPO_DESTINATARIO;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mensagem;

        public MyViewHolder(View itemView) {
            super(itemView);

            mensagem = itemView.findViewById(R.id.textMensagemTexto);

        }
    }

}
