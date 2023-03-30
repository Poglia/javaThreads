package banco;
import java.util.concurrent.LinkedBlockingQueue;

public class Banco 
{

    public static void main(String[] args) 
    {
        LinkedBlockingQueue<Pessoa> fila = new LinkedBlockingQueue<>(); // Cria Fila de Bloqueio 

        // Cria pessoas da Fila em forma de Threads
        for (int i = 1; i <= 6; i++) 
        {
            Thread t = new Thread(new Pessoa(i, fila));
            t.start(); 
        }

       // Cria Pessa do Caixa em forma de Thread
        Thread caixa = new Thread(new Caixa(fila));
        caixa.start(); 
    }
}


