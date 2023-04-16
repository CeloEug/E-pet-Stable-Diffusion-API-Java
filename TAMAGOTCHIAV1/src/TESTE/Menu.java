package TESTE;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class Menu extends JFrame {
    private JLabel labelPergunta;
    private JLabel labelPerguntaKey;
    //a variavel do prompt precisa ser publica p ser acessado pelo plugin "Main", daqui a string eh enviada como prompt na requisiçao pra IA
    private JTextField caixaPromptIA;
    private JTextField caixaKeyIA;
    public static String promptIA;
    private static String apiKey;
    public Menu() {
        //Desenhar a tela do menu
        setTitle("Tamagoch.io");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 630);

        labelPergunta = new JLabel("Como você quer o seu bichinho?");
        labelPerguntaKey = new JLabel("Qual a sua key?");
        caixaPromptIA = new JTextField(10);
        caixaKeyIA = new JTextField(10);
        JButton botaoIniciar = new JButton("Gerar bichinho e iniciar o jogo.");
        //Assim que o botão é clicado o Menu fecha, instancia a interface e a desenha na tela.
        //Tbm é o gatilho p enviar o prompt pra ia.
        botaoIniciar.addActionListener(e -> {

            //pegar input do usuario assim q ele clicar p gerar. Daqui passa o prompt como parametro pro arquivo Main dos plugins e acrescentar ao prompt de la.
            promptIA = caixaPromptIA.getText();
            apiKey = caixaKeyIA.getText();
            setVisible(false);
            Loading  loading = new Loading();
            loading.setVisible(true);
            //debugging do valor q ta sendo armazenado.
            System.out.println("Prompt digitado: " + promptIA);
            System.out.println("Chave Api: " + apiKey);

            //Envia a solicitacao pra API assim que o valor de promptIA for diferente de vazio ou nulo.
            //Sem codigo p lidar com algum problema que a requisicao tenha, só coloquei a sugestão da IDE p rodar o codigo.
            //isEmpty() é um metodo p saber se promptIA é nulo.
            if (promptIA != null && !promptIA.isEmpty()) {
                TextToImg textToImg = new TextToImg();
                //usando "try" e "catch" pq não sei a condição exata do erro, ele vai tentar o mètodo .sendRequest(), e se n conseguir, move pro catch.
                //https://stackoverflow.com/questions/651619/what-is-the-advantage-of-using-try-catch-versus-if-else
                try {
                    textToImg.sendRequest();
                }
                    //se tiver qualquer problema na tentativa, joga p catch pegar a exceçao (no caso, pega o metodo de imprimir o erro)
                catch (Exception ececao) {
                    //Método que imprime o problema que deu na requisicao
                    ececao.printStackTrace();
                }
            }
        });

        //envia o prompt assim que não estiver mais vazio.
        TextToImg textToImg = new TextToImg();

        //Desenhando os elementos da tela
        setLayout(new FlowLayout());
        //add(labelPerguntaKey); descomentar qnd implementar a função, só jogar o valor da caixa e concatenar com a string no TextToImg
        //add(caixaKeyIA);
        add(labelPergunta);
        add(caixaPromptIA);
        add(botaoIniciar);
        setVisible(true);

    }
}

