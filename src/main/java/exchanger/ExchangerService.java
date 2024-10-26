package exchanger;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExchangerService {
    private static Map<String, Double> exchangeRates = new HashMap<String, Double>();

    static {
        exchangeRates.put("BYN", 1.0);
        exchangeRates.put("USD", 3.22);
        exchangeRates.put("EUR", 3.89);
        exchangeRates.put("RUB", 0.34);
        exchangeRates.put("CNY", 2.18);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Supported currencies: BYN, USD, EUR, RUB, CNY");

        while (true) {
            System.out.println("Type the amount (in BYN): ");
            Double typedAmount = scanner.nextDouble();
            System.out.println("Enter the target currency (BYN, USD, EUR, RUB, CNY)");
            String targetCurrency = scanner.next();

            if (exchangeRates.containsKey(targetCurrency)) {
                double convertedAmount = convertCurrency(typedAmount, targetCurrency);
                System.out.println("Converted " + convertedAmount + " to " + targetCurrency);
            } else {
                System.out.println("Unknown currency: " + targetCurrency);
            }
            System.out.println("Do you want to exchange rates? (Y/N): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("Y")) {
                break;
            }
        }
        }
        private static double convertCurrency(Double amountInByn, String targetCurrency) {
        double exchangeRate = exchangeRates.get(targetCurrency);
        return amountInByn / exchangeRate;
        }
    }


