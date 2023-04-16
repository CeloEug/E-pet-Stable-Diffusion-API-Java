package TESTE;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class EndGame extends JFrame implements EndGameInterface {
    private JLabel label;

    public EndGame(BichinhoVirtual player) {
        setTitle("Tamagoch.io");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 630);

        setLayout(new FlowLayout());
        add(devolverMensagem(player));
        setVisible(true);
    }

    @Override
    public JLabel devolverMensagem(BichinhoVirtual player) {
        if (player.getFome() <= 0 && player.getSujeira() <= 4 && player.getFelicidade() > 0) {
            return new JLabel("Obrigado por jogar! :) " +
                    "você é um ótimo pai de pet.");
        } else {
            return new JLabel("Deixa pra próxima!");
        }
    }
}
