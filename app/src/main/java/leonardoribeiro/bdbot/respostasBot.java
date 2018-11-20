package leonardoribeiro.bdbot;

import android.content.Context;

import java.util.List;
import java.util.Random;

public class respostasBot {

//    static String primeiraMensagem = (R.string.primeiraMensagem);

//    static String explicacaoMundoConceitual = String.valueOf(R.string.explicacaoMundoConceitual);

//    static String explicacaoMundoLogico = String.valueOf(R.string.explicacaoMundoLogico);

//    static String explicacaoMundoFisico = String.valueOf(R.string.explicacaoMundoFisico);

    static String[] naoReconhecidos = {"Desculpe não entendi", "Pode dizer de novo?", "Tente dizer de outra forma, por favor"};


    public static String getMensagemBot(String gatilho, Context c){

        String retorno = "";

        gatilho = gatilho.trim().toLowerCase();
        if(gatilho.equalsIgnoreCase("inicio")){
            retorno = c.getString(R.string.primeiraMensagem);
        } else if(gatilho.equalsIgnoreCase("conceitual") || gatilho.equalsIgnoreCase("mundo conceitual")){
            retorno = c.getString(R.string.explicacaoMundoConceitual);
        }else if(gatilho.equalsIgnoreCase("logico") || gatilho.equalsIgnoreCase("mundologico") || gatilho.equalsIgnoreCase("lógico") || gatilho.equalsIgnoreCase("mundo lógico")){
            retorno = c.getString(R.string.explicacaoMundoLogico);
        }else if(gatilho.equalsIgnoreCase("fisico") || gatilho.equalsIgnoreCase("mundo fisico") || gatilho.equalsIgnoreCase("físico") || gatilho.equalsIgnoreCase("mundo físico")){
            retorno = c.getString(R.string.explicacaoMundoFisico);
        }else if(gatilho.equalsIgnoreCase("entidade")){
            retorno = c.getString(R.string.explicacaoEntidade);
        }else if(gatilho.equalsIgnoreCase("entidade fraca")){
            retorno = c.getString(R.string.explicacaoEntidadeFraca);
        }else if(gatilho.equalsIgnoreCase("relacionamento")){
            retorno = c.getString(R.string.explicacaoRelacionamento);
        }else if(gatilho.equalsIgnoreCase("cardinalidade")){
            retorno = c.getString(R.string.explicacaoCardinalidade);
        }else if(gatilho.equalsIgnoreCase("relação") || gatilho.equalsIgnoreCase("relaçao")
                || gatilho.equalsIgnoreCase("relacao") || gatilho.equalsIgnoreCase("relacão")){
            retorno = c.getString(R.string.explicacaoRelacao);
        }else if(gatilho.equalsIgnoreCase("tabela")){
            retorno = c.getString(R.string.explicacaoTabela);
        }else if(gatilho.equalsIgnoreCase("tupla") || gatilho.equalsIgnoreCase("tuplas")){
            retorno = c.getString(R.string.explicacaoTupla);
        }else if(gatilho.equalsIgnoreCase("dominio") || gatilho.equalsIgnoreCase("domínio")){
            retorno = c.getString(R.string.explicacaoDominio);
        }

        else{

            retorno = naoReconhecidos[geraIndice()];
        }

        return retorno;
    }

    private static int geraIndice() {
        Random r = new Random();
        return r.nextInt(3);
    }

}
