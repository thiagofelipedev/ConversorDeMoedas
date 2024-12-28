import java.io.IOException;
import java.util.Scanner;

public class ApiClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Seja bem-vindo/a ao Conversor de Moedas!");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileiro");
            System.out.println("4) Real brasileiro => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Euro => Real Brasileiro");
            System.out.println("8) Real Brasileiro => Euro");
            System.out.println("9) Sair");
            System.out.print("Escolha uma opção válida: ");

            int option = scanner.nextInt();
            if (option == 9) {
                System.out.println("Saindo...");
                break;
            }

            String baseCurrency;
            String destinedCurrency;
            switch (option) {
                case 1:
                    baseCurrency = "USD";
                    destinedCurrency = "ARS";
                    break;
                case 2:
                    baseCurrency = "ARS";
                    destinedCurrency = "USD";
                    break;
                case 3:
                    baseCurrency = "USD";
                    destinedCurrency = "BRL";
                    break;
                case 4:
                    baseCurrency = "BRL";
                    destinedCurrency = "USD";
                    break;
                case 5:
                    baseCurrency = "USD";
                    destinedCurrency = "COP";
                    break;
                case 6:
                    baseCurrency = "COP";
                    destinedCurrency = "USD";
                    break;
                case 7:
                    baseCurrency = "EUR";
                    destinedCurrency = "BRL";
                    break;
                case 8:
                    baseCurrency = "BRL";
                    destinedCurrency = "EUR";
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            try {
                ExchangeRateResponse response = converter.getExchangeRates(baseCurrency);
                double rate = response.getRates().get(destinedCurrency);

                System.out.print("Digite o valor em " + baseCurrency + ": ");
                double amount = scanner.nextDouble();

                double convertedAmount = amount * rate;
                System.out.println("----------------------------------------");
                System.out.printf("O valor em %s é: %.2f%n", destinedCurrency, convertedAmount);

            } catch (NullPointerException e) {
                System.out.println("Erro: Não foi possível obter a moeda de conversão ou ela não existe." +
                        "Verifique a entrada de informações. " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Erro de I/O: Não foi possível acessar a API. " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado na obtenção do câmbio para a conversão: " + e.getMessage());
            }
        }
        scanner.close();
    }
}