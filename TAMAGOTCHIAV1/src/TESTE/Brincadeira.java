package TESTE;
//O tratamento que fiz com as brincadeiras deve ser feito também de forma abstrata com as outras ações, como alimentar (com comidas diferentes).
public abstract class Brincadeira {
    public String statusAcao;
    public int ficarFeliz;
    public int gastoEnergia;
    public int sujar;
    protected void setFicarFeliz(int ficarFeliz) {
        this.ficarFeliz = ficarFeliz;
    }

    protected void setGastoEnergia(int gastoEnergia) {
        this.gastoEnergia = gastoEnergia;
    }

    protected void setSujar(int sujar) {
        this.sujar = sujar;
    }
    public void brincarBichinho(BichinhoVirtual bichinhoVirtual) {
        bichinhoVirtual.setEnergia(bichinhoVirtual.getEnergia() - gastoEnergia);
        bichinhoVirtual.setSujeira(bichinhoVirtual.getSujeira() + sujar);
        bichinhoVirtual.setFelicidade(bichinhoVirtual.getFelicidade() + ficarFeliz);
        System.out.println(statusAcao);
        System.out.println("Energia: " + bichinhoVirtual.getEnergia());
        System.out.println("Sujeira: " + bichinhoVirtual.getSujeira());
        System.out.println("Felicidade: " + bichinhoVirtual.getFelicidade());
    }

}

class Lutinha extends Brincadeira {
    public Lutinha() {
        this.statusAcao = " Seu bichinho brincou de lutinha!";
        setFicarFeliz(4);
        setGastoEnergia(5);
        setSujar(3);
    }
}

class JogarBola extends Brincadeira {
    public JogarBola() {
        this.statusAcao = "Seu bichinho jogou futebol! ";

        setFicarFeliz(4);
        setGastoEnergia(4);
        setSujar(2);
    }
}

class Desenhar extends Brincadeira {
    public Desenhar() {
        this.statusAcao = "Seu bichinho desenhou!";
        setFicarFeliz(4);
        setGastoEnergia(1);
       setSujar(0);
    }

}

