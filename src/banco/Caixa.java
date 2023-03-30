package banco;

import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author pedro
 */
public class Caixa implements Runnable 
{
    private LinkedBlockingQueue<Pessoa> fila;

    public Caixa(LinkedBlockingQueue<Pessoa> fila) 
    {
        this.fila = fila;
    }

    @Override
    public void run() 
    {
        while (true) 
        {
            try 
            {
                Pessoa p = fila.take(); // Proximo
                if(!fila.isEmpty())
                {
                    p.atender();
                }
                else{
                    System.out.println("Os clientes acabaram.");
                    System.exit(0);
                }
                synchronized (p) 
                {
                    p.notify(); // Notifica o atendimento
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

