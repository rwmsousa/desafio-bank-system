import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String banco = "Banco Paraíso";
        String cliente = "José da Silva";
        double saldo = 1000;
        int optionNumber = 0;
        List<String> transactions = new ArrayList<>();

        Scanner option = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            System.out.println("\n-------------------\n" + banco + "\n-------------------\n");
            System.out.println("Data: " + LocalDateTime.now().format(formatter));
            System.out.println("Cliente: " + cliente);
            System.out.println("Saldo: R$ " + saldo);
            System.out.println("\n-------------------\n");

            while (optionNumber != 5) {

            System.out.println("\nMenu de opções:");
            System.out.println("1 - Depósito");
            System.out.println("2 - Saque");
            System.out.println("3 - Transferir");
            System.out.println("4 - Extrato");
            System.out.println("5 - Sair");

            optionNumber = option.nextInt();

            switch (optionNumber) {
                case 1:
                    System.out.println("\nDigite o valor do depósito: ");
                    double deposito = option.nextDouble();
                    saldo += deposito;
                    transactions.add("Depósito      |  R$ " + deposito + " - " + LocalDateTime.now().format(formatter));
                    System.out.println("Depósito realizado com sucesso!");
                    break;
                case 2:
                    System.out.println("\nDigite o valor do saque: ");
                    double saque = option.nextDouble();
                    if (saque <= saldo) {
                        saldo -= saque;
                        transactions.add("Saque         |  R$ " + saque + " - " + LocalDateTime.now().format(formatter));
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                    break;
                case 3:
                    System.out.println("\nDigite o valor da transferência: ");
                    double transference = option.nextDouble();
                    if (transference <= saldo) {
                        saldo -= transference;
                        transactions.add("Transferência | R$ " + transference + " - " + LocalDateTime.now().format(formatter));
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                    break;
                case 4:
                    System.out.println("\n------Extrato------");
                    System.out.println("Cliente: " + cliente);
                    System.out.println("Data: " + LocalDateTime.now().format(formatter));
                    System.out.println("Transação     |  Valor     |  Data");
                    for (String transaction : transactions) {
                        System.out.println(transaction);
                    }
                    System.out.println("Saldo: R$ " + saldo);
                    System.out.println("-------------------");
                    break;
                case 5:
                    System.out.println("\nObrigado por utilizar o " + banco);
                    break;
                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }
        }
        option.close();
    }
}
