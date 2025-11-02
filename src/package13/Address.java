package package13;

import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;

    // Реализация а) - только запятая
    public void parseWithSplit(String address) {
        String[] parts = address.split(",");
        if (parts.length >= 7) {
            this.country = parts[0].trim();
            this.region = parts[1].trim();
            this.city = parts[2].trim();
            this.street = parts[3].trim();
            this.house = parts[4].trim();
            this.building = parts[5].trim();
            this.apartment = parts[6].trim();
        }
    }

    // Реализация б) - любой разделитель
    public void parseWithTokenizer(String address) {
        StringTokenizer tokenizer = new StringTokenizer(address, ",.;-");
        if (tokenizer.countTokens() >= 7) {
            this.country = tokenizer.nextToken().trim();
            this.region = tokenizer.nextToken().trim();
            this.city = tokenizer.nextToken().trim();
            this.street = tokenizer.nextToken().trim();
            this.house = tokenizer.nextToken().trim();
            this.building = tokenizer.nextToken().trim();
            this.apartment = tokenizer.nextToken().trim();
        }
    }

    @Override
    public String toString() {
        return String.format("Страна: %s, Регион: %s, Город: %s, Улица: %s, Дом: %s, Корпус: %s, Квартира: %s",
                country, region, city, street, house, building, apartment);
    }

    // Проверочный класс
    public static class TestAddress {
        public static void main(String[] args) {
            String[] testAddresses = {
                    "Россия, Московская область, Москва, Ленина, 15, 1, 25",
                    "Украина. Киевская область. Киев. Шевченко. 10. 2. 30",
                    "Беларусь; Минская область; Минск; Победителей; 20; 3; 40",
                    "Казахстан-Алматинская область-Алматы-Абая-25-4-50"
            };

            System.out.println("=== Разбор с split() ===");
            for (String addr : testAddresses) {
                Address address = new Address();
                address.parseWithSplit(addr);
                System.out.println(address);
            }

            System.out.println("\n=== Разбор с StringTokenizer ===");
            for (String addr : testAddresses) {
                Address address = new Address();
                address.parseWithTokenizer(addr);
                System.out.println(address);
            }
        }
    }
}