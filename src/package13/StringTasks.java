package package13;

public class StringTasks {

    public static void analyzeString(String str) {
        // 2. Последний символ строки
        System.out.println("2. Последний символ: " + str.charAt(str.length() - 1));

        // 3. Проверка окончания на "!!!"
        System.out.println("3. Заканчивается на '!!!': " + str.endsWith("!!!"));

        // 4. Проверка начала на "I like"
        System.out.println("4. Начинается на 'I like': " + str.startsWith("I like"));

        // 5. Проверка содержания "Java"
        System.out.println("5. Содержит 'Java': " + str.contains("Java"));

        // 6. Позиция подстроки "Java"
        System.out.println("6. Позиция 'Java': " + str.indexOf("Java"));

        // 7. Замена "а" на "о"
        String replaced = str.replace('a', 'o');
        System.out.println("7. После замены 'а' на 'о': " + replaced);

        // 8. В верхний регистр
        System.out.println("8. В верхнем регистре: " + str.toUpperCase());

        // 9. В нижний регистр
        System.out.println("9. В нижнем регистре: " + str.toLowerCase());

        // 10. Вырезать "Java"
        int javaStart = str.indexOf("Java");
        if (javaStart != -1) {
            String javaSubstring = str.substring(javaStart, javaStart + 4);
            System.out.println("10. Вырезанная 'Java': " + javaSubstring);
        }
    }

    public static void main(String[] args) {
        String testString = "I like Java!!!";
        analyzeString(testString);
    }
}