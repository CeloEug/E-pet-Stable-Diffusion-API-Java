import TESTE.BichinhoVirtual;
import TESTE.EndGameInterface;

import javax.swing.*;

public class EndingBom implements EndGameInterface {
    @Override
    public JLabel devolverMensagem(BichinhoVirtual player) {
        return new JLabel("Obrigado por jogar! :) " +
                "você é um ótimo pai de pet.");
    }
}
