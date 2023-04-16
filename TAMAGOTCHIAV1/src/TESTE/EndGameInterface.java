package TESTE;
import javax.swing.JLabel;

//interface criada para implementar depois a função "img2img" do stable siffusion. Para refazer a imagem do bichinho
//de acordo com o final o ideal era implementar mais de um final diferente com a evolução do bichinho (tipo tamagotchi)
//ex: final ruim refazia a foto gerada, mas com o bichinho triste.
public interface EndGameInterface {
    JLabel devolverMensagem(BichinhoVirtual player);
}
