package view;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import control.PessoasEsquecidas;

@SuppressWarnings("serial")
public class Window extends JFrame implements ActionListener{

    private JButton btnCorrida;
    private JButton btnCancel;
    private JLabel lblPista;
    private JLabel lblVelocimetro;
    private ImageIcon imgCorredor1;
    private ImageIcon imgCorredor2;
    private ImageIcon imgCorredor3;
    private ImageIcon pista;
    private ImageIcon velocimetro;

    // constructor
    public Window(){
        super();
        this.setLayout(null);
        this.setSize(800, 600); // res baixa
        this.setLocation(50,50);
        this.setResizable(false);
        getContentPane().setBackground(Color.white);

        this.setTitle("Corrida de pessoas que se esqueceram que era uma corrida");
        velocimetro = new ImageIcon(); // mostrando valores baixos (cm/h)
        pista = new ImageIcon(); // Campo de futebol da faetec vai ser o local da corrida


        this.lblPista = new JLabel(pista);
        this.lblVelocimetro = new JLabel(velocimetro);

        // setando as posições dos elementos
        this.lblPista.setBounds(0, 0, 800, 600);
        this.lblVelocimetro.setBounds(50, 230, 75, 75);

        this.add(lblPista);
        this.add(lblVelocimetro);

        this.lblPista.setBackground(Color.BLACK);

        this.btnCorrida = new JButton("Começar corrida");
        this.btnCancel = new JButton("Cancelar");

        // Inserindo imagens dos corredores
        imgCorredor1 = new ImageIcon("../images/pessoaEsquecida.png");
        imgCorredor2 = new ImageIcon("../images/pessoaEsquecida.png");
        imgCorredor3 = new ImageIcon("../images/pessoaEsquecida.png");

        this.lblPista.add(btnCorrida);
        this.lblPista.add(btnCancel);

        this.setVisible(true);

        btnCorrida.addActionListener(this);
        btnCancel.addActionListener(this);

        JPanel jPanel = new JPanel();
        jPanel.setSize(300, 70);
        jPanel.setLayout(null);
        jPanel.setLocation(400, 230);
        jPanel.setBorder(BorderFactory.createTitledBorder("[Gabriel e Augusto]"));
        jPanel.setVisible(true);

        this.repaint();
    }

    //Inserindo as labels do carro 

    public JLabel JLabelPessoaEsq(String nome, ImageIcon img, int posX, int posY) {
        PessoasEsquecidas pessoaEsq = new PessoasEsquecidas(nome, img, posX, posY);
        pessoaEsq.setSize(256, 141);
        pessoaEsq.setVisible(true);
        this.add(pessoaEsq);
        return pessoaEsq;
    }
          // botoes
    @Override
    public void actionPerformed(ActionEvent dispara) {
        if (dispara.getSource() == this.btnCorrida) {
            this.lblPista.add(JLabelPessoaEsq("Corredor1", imgCorredor1, 0, 50));
            this.lblPista.add(JLabelPessoaEsq("Corredor2", imgCorredor2, 0, 200));
            this.lblPista.add(JLabelPessoaEsq("Corredor3", imgCorredor3, 0, 350));
        }
        if (dispara.getSource() == this.btnCancel) {
            System.exit(0);
        }
    }
}