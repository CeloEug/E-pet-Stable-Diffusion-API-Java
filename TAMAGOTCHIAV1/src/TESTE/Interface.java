//doc swing: https://www.javatpoint.com/java-jbutton

package TESTE;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.util.Random;
public class Interface extends JFrame {
    private JLabel label;
    private JLabel imageLabel;
    private JLabel statusLabel;
    BichinhoVirtual player = new BichinhoVirtual(10, 10, 0, 0);

    // atualizar o label pegando o metodo de pintar a tela com a instancia do player.
    //super classe q extende o botao padrao do java pra renderizar novamente a tela
    //a cada vez q o botao for pressionado, serve para os botoes de interacao.
    public class botaoInteracao extends JButton {
        public botaoInteracao(String textoBotao, Runnable acao) {
            super(textoBotao);
            super.addActionListener(e -> {
                acao.run();
                label.setText(player.pintarTela());
            });
        }
    }

    public Interface() {
        //debug
        System.out.println("Fome: " + player.getFome() + " Energia: " + player.getEnergia() + " Felicidade: " + player.getFelicidade() + " Sujeira: " + player.getSujeira());
        setTitle("Tamagoch.io");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 630);


        ImageIcon imageIcon = new ImageIcon("C:/Users/Marcelo/Documents/TAMAGOTCHIAV1/src/IMAGENS/output.png");
        imageLabel = new JLabel(imageIcon);
        label = new JLabel(player.pintarTela());
        statusLabel = new JLabel();


        botaoInteracao botaoAcaoComida = new botaoInteracao("Alimentar",() -> player.alimentarBichinho(1));
        botaoInteracao botaoAcaoBrincar = new botaoInteracao("Brincar", () -> {
            //pega as brincadeiras, coloca numa lista e randomicamente mostra num label chamado de statusLabel. Esse label não precisa
            //ser apenas referente às brincadeiras, qualquer aviso ao jogador pode ser feito por aqui.
            Brincadeira[] brincadeiras = new Brincadeira[]{new Lutinha(), new JogarBola(), new Desenhar()};
            Random random = new Random();
            int randomIndex = random.nextInt(brincadeiras.length);
            Brincadeira brincadeira = brincadeiras[randomIndex];
            brincadeira.brincarBichinho(player);
            statusLabel.setText(brincadeira.statusAcao);

        });
        botaoInteracao botaoAcaoLimpar = new botaoInteracao("Limpar",() -> player.banharBichinho());

        JButton botaoAcaoNanar = new JButton("Dormir");
        botaoAcaoNanar.addActionListener(e -> {
            setVisible(false);
            EndGame endGame = new EndGame(player);
        });

        setLayout(new FlowLayout());
        add(imageLabel);
        add(label);
        add(botaoAcaoComida);
        add(botaoAcaoBrincar);
        add(botaoAcaoLimpar);
        add(botaoAcaoNanar);
        add(statusLabel);
    }

}

