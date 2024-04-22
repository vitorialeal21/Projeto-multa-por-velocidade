import java.io.FileWriter;
import java.io.IOException;

public class MultaTransito {

    // Método para calcular a multa com base na porcentagem de velocidade excedida
    public static double calcularMulta(double velocidadeExcedida) {
        if (velocidadeExcedida <= 20) {
            return 130.00;
        } else if (velocidadeExcedida <= 40) {
            return 230.00;
        } else if (velocidadeExcedida <= 50) {
            return 580.00;
        } else {
            return 967.52;
        }
    }

    // Método para calcular a porcentagem de velocidade excedida
    public static double calcularPorcentagem(double velocidadeCarro, double velocidadeVia) {
        return ((velocidadeCarro - velocidadeVia) / velocidadeVia) * 100;
    }

    // Método para calcular e salvar a multa em um arquivo CSV
    public static void multaTransito(String carro, double velocidadeCarro, String via, double velocidadeVia) {
        double velocidadeExcedida = velocidadeCarro - velocidadeVia;
        double porcentagemExcedida = calcularPorcentagem(velocidadeCarro, velocidadeVia);
        double multa = calcularMulta(porcentagemExcedida);

        // Escrever as informações no arquivo CSV
        try (FileWriter writer = new FileWriter("multa.csv", true)) {
            writer.append(carro + "," + velocidadeCarro + "," + via + "," + velocidadeVia + "," + velocidadeExcedida + "," + multa + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso da função multaTransito
        multaTransito("CarroA", 150.0, "ViaA", 100.0);
        multaTransito("CarroB", 120.0, "ViaB", 100.0);
        multaTransito("CarroC", 180.0, "ViaC", 120.0);

        System.out.println("Informações de multa foram salvas no arquivo multa.csv");
    }
}
