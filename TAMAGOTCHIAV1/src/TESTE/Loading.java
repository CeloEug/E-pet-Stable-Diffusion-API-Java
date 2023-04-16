package TESTE;
import javax.swing.*;

public class Loading extends JFrame{
    private static JFrame loadingFrame;

    public Loading() {
        setTitle("Tamagoch.io");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 630);
        ImageIcon loadingGif = new ImageIcon("C:/Users/Marcelo/Documents/TAMAGOTCHIAV1/src/IMAGENS/loading.gif");
        JLabel loadinglabel = new JLabel(loadingGif);

        Timer timer = new Timer(8000, e -> {
            //Fechar a interface de carregamento dps de 8 segundos, pra garantir que a IA gerou a imagem a tempo
            dispose();
            //desligando a interface do menu e instanciando a interface do jogo e ligando ela.
            setVisible(false);
            Interface jogo = new Interface();
            jogo.setVisible(true);
        });
        add(loadinglabel);
        timer.setRepeats(false);
        timer.start();
    }
}