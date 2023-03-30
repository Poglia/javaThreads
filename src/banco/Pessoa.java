package banco;

import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author pedro
 */
public class Pessoa implements Runnable 
{
    private int id;
    private LinkedBlockingQueue<Pessoa> fila;

    public Pessoa(int id, LinkedBlockingQueue<Pessoa> fila) 
    {
        this.id = id;
        this.fila = fila;
    }

    @Override
    public void run() 
    {
        // Entrando na fila
        fila.add(this);

        // Aguarda na Fila
        while (true) 
        {
            synchronized (this) 
            {
                try 
                {
                    wait(); // Espera Atendimento
                } catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public void atender() 
    {
        // simula o atendimento da pessoa pelo caixa
        System.out.println("Cliente " + id + ": Em atendimento");
       
        try 
        {
            Thread.sleep(3000); // Tempo do atendimento
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("O Cliente " + id + " foi atendido!");
        System.out.println("\n");
       
    }
}
