package control;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PessoaEsqThread extends JLabel implements Runnable{

    private Thread pessoaEsqThread = null;
    private int posX;
    private int posY;
    private ImageIcon img;
    private static int pos=0;
    private String nome;

    // constructor
    public PessoaEsqThread(){}

    public PessoaEsqThread(String nome, ImageIcon img, int posX, int posY){
        super(img);
        this.img = img;
        this.posX = posX;
        this.posY = posY;
        this.nome = nome;

        pessoaEsqThread = new Thread(this, nome);
        pessoaEsqThread.start();
    } 
    
    // método run() da interface runnable
    @Override 
    public void run(){
        posX += new Random().nextInt(3) * 100;
        this.setLocation(posX, posY);

        if(poX >= 800){
            poss++;
            JOptionPane.showMessageDialog(null, pos + ")" + nome);
            return;
        }
        try{
            Thread.sleep(new Random().nextInt(5) * 100);
            run();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}