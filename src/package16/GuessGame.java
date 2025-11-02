package package16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GuessGame extends JFrame {
    private JTextField guessField;
    private JButton guessButton;
    private JLabel infoLabel;
    private int secretNumber;
    private int attemptsLeft;
    private Random random;

    // Панели для разных областей BorderLayout
    private JPanel centerPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel northPanel;
    private JPanel southPanel;

    public GuessGame() {
        initializeGame();
        setupUI();
        setupMouseListeners();
    }

    private void initializeGame() {
        random = new Random();
        secretNumber = random.nextInt(21); // Число от 0 до 20
        attemptsLeft = 3;
        System.out.println("Секретное число: " + secretNumber); // Для отладки
    }

    private void setupUI() {
        setTitle("Игра-угадайка");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(600, 400);

        // Создаем панели для каждой области
        centerPanel = createColoredPanel("CENTER", Color.LIGHT_GRAY);
        westPanel = createColoredPanel("WEST", Color.CYAN);
        eastPanel = createColoredPanel("EAST", Color.ORANGE);
        northPanel = createColoredPanel("NORTH", Color.PINK);
        southPanel = createColoredPanel("SOUTH", Color.GREEN);

        // Добавляем панели в соответствующие области
        add(centerPanel, BorderLayout.CENTER);
        add(westPanel, BorderLayout.WEST);
        add(eastPanel, BorderLayout.EAST);
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);

        // Основная игровая панель в центре
        setupGamePanel();
    }

    private JPanel createColoredPanel(String text, Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(label, BorderLayout.CENTER);

        return panel;
    }

    private void setupGamePanel() {
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(4, 1, 10, 10));
        gamePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Заголовок
        JLabel titleLabel = new JLabel("Угадайте число от 0 до 20", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gamePanel.add(titleLabel);

        // Информационная метка
        infoLabel = new JLabel("У вас 3 попытки", SwingConstants.CENTER);
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gamePanel.add(infoLabel);

        // Поле для ввода
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        guessField = new JTextField(10);
        guessField.setFont(new Font("Arial", Font.PLAIN, 14));

        // Добавляем обработчик нажатия Enter в текстовом поле
        guessField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processGuessInput();
            }
        });

        inputPanel.add(new JLabel("Ваша догадка:"));
        inputPanel.add(guessField);

        gamePanel.add(inputPanel);

        // Кнопка угадать
        guessButton = new JButton("Угадать!");
        guessButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Используем анонимный класс вместо внутреннего
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processGuessInput();
            }
        });

        // Создаем отдельную панель для кнопки, чтобы избежать конфликтов с MouseListener
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(guessButton);
        gamePanel.add(buttonPanel);

        // Добавляем игровую панель в центр основной центральной панели
        centerPanel.add(gamePanel, BorderLayout.CENTER);
    }

    private void setupMouseListeners() {
        // Обработчики для CENTER - добавляем только на метку, а не на всю панель
        JLabel centerLabel = (JLabel) centerPanel.getComponent(0);
        centerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                showWelcomeDialog("Добро пожаловать в ЦАО");
            }
        });

        // Обработчики для WEST - добавляем только на метку
        JLabel westLabel = (JLabel) westPanel.getComponent(0);
        westLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                showWelcomeDialog("Добро пожаловать в ЗАО");
            }
        });

        // Обработчики для SOUTH - добавляем только на метку
        JLabel southLabel = (JLabel) southPanel.getComponent(0);
        southLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                showWelcomeDialog("Добро пожаловать в ЮАО");
            }
        });

        // Обработчики для NORTH - добавляем только на метку
        JLabel northLabel = (JLabel) northPanel.getComponent(0);
        northLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                showWelcomeDialog("Добро пожаловать в САО");
            }
        });

        // Обработчики для EAST - добавляем только на метку
        JLabel eastLabel = (JLabel) eastPanel.getComponent(0);
        eastLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                showWelcomeDialog("Добро пожаловать в ВАО");
            }
        });
    }

    private void processGuessInput() {
        try {
            int guess = Integer.parseInt(guessField.getText());
            processGuess(guess);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(GuessGame.this,
                    "Пожалуйста, введите целое число!",
                    "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
        }
        guessField.setText("");
        guessField.requestFocus();
    }

    private void showWelcomeDialog(String message) {
        JOptionPane.showMessageDialog(this,
                message,
                "Приветствие",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void processGuess(int guess) {
        attemptsLeft--;

        if (guess == secretNumber) {
            JOptionPane.showMessageDialog(this,
                    "Поздравляем! Вы угадали число " + secretNumber + "!",
                    "Победа!",
                    JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            return;
        }

        if (attemptsLeft == 0) {
            JOptionPane.showMessageDialog(this,
                    "К сожалению, вы исчерпали все попытки. Загаданное число было: " + secretNumber,
                    "Игра окончена",
                    JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            return;
        }

        // Подсказка
        String hint = guess < secretNumber ? "больше" : "меньше";
        infoLabel.setText("Неверно! Число " + hint + ". Осталось попыток: " + attemptsLeft);

        JOptionPane.showMessageDialog(this,
                "Неверно! Загаданное число " + hint + " чем " + guess +
                        ". Осталось попыток: " + attemptsLeft,
                "Не угадали",
                JOptionPane.WARNING_MESSAGE);
    }

    private void resetGame() {
        initializeGame();
        infoLabel.setText("У вас 3 попытки");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GuessGame().setVisible(true);
        });
    }
}