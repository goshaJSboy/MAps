import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<Address, Integer> costPerAddress = new HashMap<>();
        Map<Address, Integer> moscowCost = new HashMap<>();
        moscowCost.put(new Address("Russia", "Moscow"), 200);

        long totalCost = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Заполнение нового заказа.");

                System.out.print("Введите страну: ");
                String country = scanner.nextLine().trim();
                if (country.equalsIgnoreCase("end")) {
                    break;
                }

                System.out.print("Введите город: ");
                String city = scanner.nextLine().trim();

                System.out.print("Введите вес (кг): ");
                int weight;
                try {
                    weight = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Введите вес целым числом.");
                    continue;
                }
                if (weight <= 0) {
                    System.out.println("Вес должен быть больше нуля.");
                    continue;
                }

                Integer pricePerKg = moscowCost.get(new Address(country, city)); 
                if (pricePerKg == null) {
                    System.out.println("Доставки по этому адресу нет");
                } else {
                    long deliveryCost = (long) weight * pricePerKg;
                    totalCost += deliveryCost;
                    System.out.println("Стоимость доставки составит: " + deliveryCost + " руб.");
                    System.out.println("Общая стоимость всех доставок: " + totalCost + " руб.");
                }

                System.out.println();
            }
        }
    }
}
