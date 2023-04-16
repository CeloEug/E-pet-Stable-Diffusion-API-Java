package TESTE;

public class BichinhoVirtual {
    public int fome;
    public int energia;
    public int felicidade;
    public int sujeira;
    public int calorias;

    public int getFome() {
        return fome;
    }

    public void setFome(int fome) {
        if (fome < 0) {
            this.fome = 0;
        } else {
            this.fome = fome;
        }
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        if (energia < 0) {
            this.energia = 0;
        } else {
            this.energia = energia;
        }
    }

    public int getFelicidade() {
        return felicidade;
    }

    public void setFelicidade(int felicidade) {
        if (felicidade > 10) {
            this.felicidade = 10;
        } else {
            this.felicidade = felicidade;
        }
    }

    public int getSujeira() {
        return sujeira;
    }

    public void setSujeira(int sujeira) {
        if (sujeira > 10) {
            this.sujeira = 10;
        } else {
            this.sujeira = sujeira;
        }
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }


    //Os sysout são para debug do jogo
    public BichinhoVirtual(int fome, int energia, int felicidade, int sujeira) {
        setFome(fome);
        setEnergia(energia);
        setFelicidade(felicidade);
        setSujeira(sujeira);
    }

    public int alimentarBichinho(int calorias) {
        setCalorias(calorias);
        setFome(getFome() - getCalorias());
        System.out.println("fome = " + getFome());
        return getFome();
    }


    public void banharBichinho() {
        setSujeira(0);
        System.out.println("sujeira = " + getSujeira());
    }

    //método que calcula e envia a string com o contador de fome, energia, felicidade e sujeira.
    public static String contador(int status) {
        //string vazia p declarar
        String resultado = "";
        int contador = 1;
        while (contador <= 10) {
            if (contador > status) {
                resultado += "o";
            } else {
                resultado += "x";
            }
            contador = contador + 1;
        }
        return resultado;
    }

    //pintarTela() era um meteodo p imprimir o texto no terminal, mas agora ele retorna os valores pra um label e n imprime.
    public String pintarTela() {
        return "Fome: " +
                contador(getFome()) + " | " + "Energia: " +
                contador(getEnergia()) + " | "  + "Felicidade: " +
                contador(getFelicidade()) + " | " + "Sujeira: " +
                contador(getSujeira());
    }
}
