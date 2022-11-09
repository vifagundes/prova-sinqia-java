import java.util.Arrays;
import java.util.Scanner;

public class Prova {
    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);
        Prova prova = new Prova();

        System.out.println("Informe quantas temperaturas deseja inserir: ");
        int qntTemp = scanner.nextInt();
        double[] temperaturas;
        int[] unidade;
        int[] unidadeTrans;
        double resultado;
        double media = 0;
        double mediaTrans;

        temperaturas = prova.pegaTemp(qntTemp);
        unidade = prova.pegaUnidade(qntTemp);
        unidadeTrans = prova.pegaUnidadeTrans(qntTemp);
        String stringArr = Arrays.toString(temperaturas);

        System.out.println("As temperaturas passadas foram: " + stringArr);
        System.out.println("Escolha duas para converter: (1 - " + temperaturas.length + ")");
        System.out.println("Primeira temperatura: ");
        int indice1 = scanner.nextInt() - 1;

        System.out.println("Segunda temperatura: ");
        int indice2 = scanner.nextInt() - 1;
        double[] temperaturasDepoisEscolhindas = new double[2];
        temperaturasDepoisEscolhindas[0] = temperaturas[indice1];
        temperaturasDepoisEscolhindas[1] = temperaturas[indice2];


        for(int i = 0; i < temperaturasDepoisEscolhindas.length; i++){
            if(unidade[i] == 1 && unidadeTrans[i] == 2) {
                resultado = prova.conversaoCelsiusToFahrenheit(temperaturasDepoisEscolhindas[i]);
                System.out.printf("Temperatura escolhida: %.2f C para: %.2f F\n",temperaturasDepoisEscolhindas[i], resultado);
                mediaTrans = prova.calcMediaTrans(unidade[i], resultado);
                System.out.println("A media das duas e de: " + mediaTrans);
            }
            if(unidade[i] == 1 && unidadeTrans[i] == 3) {
                resultado = prova.conversaoCelsiusToKelvin(temperaturasDepoisEscolhindas[i]);
                System.out.printf("Temperatura escolhida: %.2f C para: %.2f K\n",temperaturasDepoisEscolhindas[i], resultado);
                mediaTrans = prova.calcMediaTrans(unidade[i], resultado);
                System.out.println("A media das duas e de: " + mediaTrans);
            }

            if(unidade[i] == 2 && unidadeTrans[i] == 1) {
                resultado = prova.conversaoFahrenheitToCelsius(temperaturasDepoisEscolhindas[i]);
                System.out.printf("Temperatura escolhida: %.2f F para: %.2f C\n",temperaturasDepoisEscolhindas[i], resultado);
                mediaTrans = prova.calcMediaTrans(unidade[i], resultado);
                System.out.println("A media das duas e de: " + mediaTrans);
            }
            if(unidade[i] == 2 && unidadeTrans[i] == 3) {
                resultado = prova.conversaoFahrenheitToKelvin(temperaturasDepoisEscolhindas[i]);
                System.out.printf("Temperatura escolhida: %.2f F para: %.2f K\n",temperaturasDepoisEscolhindas[i], resultado);
                mediaTrans = prova.calcMediaTrans(unidade[i], resultado);
                System.out.println("A media das duas e de: " + mediaTrans);
            }

            if(unidade[i] == 3 && unidadeTrans[i] == 1) {
                resultado = prova.conversaoKelvinToCelsius(temperaturasDepoisEscolhindas[i]);
                System.out.printf("Temperatura escolhida: %.2f K para: %.2f C\n",temperaturasDepoisEscolhindas[i], resultado);
                mediaTrans = prova.calcMediaTrans(unidade[i], resultado);
                System.out.println("A media das duas e de: " + mediaTrans);
            }
            if(unidade[i] == 3 && unidadeTrans[i] == 2) {
                resultado = prova.conversaoKelvinToFahrenheit(temperaturasDepoisEscolhindas[i]);
                System.out.printf("Temperatura escolhida: %.2f K para: %.2f F\n",temperaturasDepoisEscolhindas[i], resultado);
                mediaTrans = prova.calcMediaTrans(unidade[i], resultado);
                System.out.println("A media das duas e de: " + mediaTrans);
            }

            if(unidade[i] == unidadeTrans[i]) {
                System.out.println("Erro, temperaturas do mesmo tipo");
            }
        }



        double soma = 0;

        for(int i = 0;i < temperaturas.length; i++) {
            soma += temperaturas[i];
            media = soma / temperaturas.length;
        }
        System.out.println("A media de todas as temperaturas passadas e de: " + media);
    }


    public double conversaoFahrenheitToCelsius(double temperatura) {
        return (temperatura - 32) / 1.8;
    }

    public double conversaoFahrenheitToKelvin(double temperatura) {
        return (temperatura + 459.67) * 1.8;
    }



    public double conversaoKelvinToCelsius(double temperatura) {
        return temperatura - 273.15;
    }

    public double conversaoKelvinToFahrenheit(double temperatura) {
        return (temperatura * 1.8) - 459.57;
    }



    public double conversaoCelsiusToKelvin(double temperatura) {
        return temperatura + 273.15;
    }

    public double conversaoCelsiusToFahrenheit(double temperatura) {
        return (temperatura * 1.8) + 32;
    }

    public double[] pegaTemp(int qntTemp){
        Scanner scanner = new Scanner(System.in);
        double[] temp = new double[qntTemp];
        for(int i = 0; i < qntTemp; i++) {
            System.out.println("Informe a temperatura: ");
            temp[i] = scanner.nextDouble();
        }
        return temp;
    }

    public int[] pegaUnidade(int qntTemp){
        Scanner scanner = new Scanner(System.in);
        int[] unidade = new int[qntTemp];
        for(int i = 0; i < qntTemp; i++) {
            System.out.println("Informe a unidade: ");
            System.out.printf("Celsius - 1\nFahrenheit - 2\nKelvin - 3\n");
            unidade[i] = scanner.nextInt();
        }
        return unidade;
    }

    public int[] pegaUnidadeTrans(int qntTemp){
        Scanner scanner = new Scanner(System.in);
        int[] unidadeTrans = new int[qntTemp];
        for(int i = 0; i < qntTemp; i++) {
            System.out.println("Informe a unidade para transformar: ");
            System.out.printf("Celsius - 1\nFahrenheit - 2\nKelvin - 3\n");
            unidadeTrans[i] = scanner.nextInt();
        }
        return unidadeTrans;
    }


    public double calcMediaTrans(double value1, double value2) {
        return (value1 + value2) / 2;
    }

}
