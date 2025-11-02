package package16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordChecker extends JFrame {
    private JTextField serviceField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextArea resultArea;

    public PasswordChecker() {
        initializeUI();
    }

    private void initializeUI() {
        // Настройка основного окна
        setTitle("Проверка пароля");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Создание главной панели с BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Панель для ввода данных с GridBagLayout
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Метки и поля ввода
        JLabel serviceLabel = new JLabel("Service:");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        serviceField = new JTextField(20);
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        // Добавление компонентов в сетку
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(serviceLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        gbc.weightx = 1.0;
        inputPanel.add(serviceField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0.0;
        inputPanel.add(usernameLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gbc.weightx = 1.0;
        inputPanel.add(usernameField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.weightx = 0.0;
        inputPanel.add(passwordLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        gbc.weightx = 1.0;
        inputPanel.add(passwordField, gbc);

        // Панель для кнопки с FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton checkButton = new JButton("Проверить пароль");

        buttonPanel.add(checkButton);

        // Область для вывода результатов
        resultArea = new JTextArea(8, 30);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Добавление всех компонентов на главную панель
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        // Добавление главной панели в окно
        add(mainPanel);

        // Обработчик события для кнопки
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkPassword();
            }
        });
    }

    private void checkPassword() {
        String service = serviceField.getText().trim();
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        StringBuilder result = new StringBuilder();

        // Проверка на пустые поля
        if (service.isEmpty() || username.isEmpty() || password.isEmpty()) {
            result.append("ОШИБКА: Все поля должны быть заполнены!\n\n");
            resultArea.setForeground(Color.RED);
        } else {
            result.append("Данные для проверки:\n");
            result.append("Сервис: ").append(service).append("\n");
            result.append("Имя пользователя: ").append(username).append("\n");
            result.append("Длина пароля: ").append(password.length()).append(" символов\n\n");

            // Проверка сложности пароля
            result.append("Результат проверки пароля:\n");

            boolean hasUpperCase = !password.equals(password.toLowerCase());
            boolean hasLowerCase = !password.equals(password.toUpperCase());
            boolean hasDigits = password.matches(".*\\d.*");
            boolean hasSpecial = !password.matches("[A-Za-z0-9]*");
            int length = password.length();

            int score = 0;

            if (length >= 8) score++;
            if (length >= 12) score++;
            if (hasUpperCase) score++;
            if (hasLowerCase) score++;
            if (hasDigits) score++;
            if (hasSpecial) score++;

            result.append("✓ Длина: ").append(length).append(" символов\n");
            result.append("✓ Заглавные буквы: ").append(hasUpperCase ? "Да" : "Нет").append("\n");
            result.append("✓ Строчные буквы: ").append(hasLowerCase ? "Да" : "Нет").append("\n");
            result.append("✓ Цифры: ").append(hasDigits ? "Да" : "Нет").append("\n");
            result.append("✓ Спецсимволы: ").append(hasSpecial ? "Да" : "Нет").append("\n\n");

            // Оценка пароля
            result.append("ОЦЕНКА БЕЗОПАСНОСТИ: ");
            if (score >= 5) {
                result.append("ОТЛИЧНО\n");
                result.append("Ваш пароль достаточно надежный");
                resultArea.setForeground(new Color(0, 128, 0)); // Темно-зеленый
            } else if (score >= 3) {
                result.append("ХОРОШО\n");
                result.append("Пароль неплохой, но можно улучшить");
                resultArea.setForeground(Color.BLUE);
            } else {
                result.append("СЛАБО\n");
                result.append("Рекомендуется усилить пароль");
                resultArea.setForeground(Color.RED);
            }
        }

        resultArea.setText(result.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PasswordChecker().setVisible(true);
            }
        });
    }
}