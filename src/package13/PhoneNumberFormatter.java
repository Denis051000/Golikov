package package13;

public class PhoneNumberFormatter {

    public static String formatPhoneNumber(String phone) {
        // Удаляем все нецифровые символы, кроме плюса в начале
        String cleaned = phone.replaceAll("[^\\d+]", "");

        // Обработка российского формата (начинается с 8)
        if (cleaned.startsWith("8")) {
            cleaned = "+7" + cleaned.substring(1);
        }

        // Проверяем длину номера
        if (cleaned.length() < 11) {
            throw new IllegalArgumentException("Неверный формат номера");
        }

        String countryCode = cleaned.substring(0, cleaned.length() - 10);
        String number = cleaned.substring(cleaned.length() - 10);

        // Форматируем номер: +XXX-XXX-XXX-XXXX
        return String.format("%s-%s-%s-%s",
                countryCode,
                number.substring(0, 3),
                number.substring(3, 6),
                number.substring(6));
    }

    public static void main(String[] args) {
        String[] testNumbers = {
                "+79175655655",
                "+104289652211",
                "89175655655",
                "+74951234567"
        };

        for (String number : testNumbers) {
            try {
                System.out.println(number + " -> " + formatPhoneNumber(number));
            } catch (IllegalArgumentException e) {
                System.out.println(number + " -> Ошибка: " + e.getMessage());
            }
        }
    }
}