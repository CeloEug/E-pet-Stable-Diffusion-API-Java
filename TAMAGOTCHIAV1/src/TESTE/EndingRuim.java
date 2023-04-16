package TESTE;
import javax.swing.*;


public class EndingRuim implements EndGameInterface {
    @Override
    public JLabel devolverMensagem(BichinhoVirtual player) {
        return new JLabel("Deixa pra próxima!");
    }
}