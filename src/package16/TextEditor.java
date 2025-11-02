package package16;

import javax.swing.*;
import java.awt.*;

public class TextEditor extends JFrame {
    private JTextArea textArea;

    public TextEditor() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Текстовый редактор с меню");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Текстовая область
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText("Введите ваш текст здесь...\nВы можете изменить цвет и шрифт через меню.");
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        // Создание меню
        JMenuBar menuBar = new JMenuBar();

        // Меню Цвет
        JMenu colorMenu = new JMenu("Цвет");

        JMenuItem blueItem = new JMenuItem("Синий");
        JMenuItem redItem = new JMenuItem("Красный");
        JMenuItem blackItem = new JMenuItem("Черный");

        blueItem.addActionListener(e -> textArea.setForeground(Color.BLUE));
        redItem.addActionListener(e -> textArea.setForeground(Color.RED));
        blackItem.addActionListener(e -> textArea.setForeground(Color.BLACK));

        colorMenu.add(blueItem);
        colorMenu.add(redItem);
        colorMenu.add(blackItem);

        // Меню Шрифт
        JMenu fontMenu = new JMenu("Шрифт");

        JMenuItem timesItem = new JMenuItem("Times New Roman");
        JMenuItem sansSerifItem = new JMenuItem("MS Sans Serif");
        JMenuItem courierItem = new JMenuItem("Courier New");

        timesItem.addActionListener(e -> setFont("Times New Roman"));
        sansSerifItem.addActionListener(e -> setFont("MS Sans Serif"));
        courierItem.addActionListener(e -> setFont("Courier New"));

        fontMenu.add(timesItem);
        fontMenu.add(sansSerifItem);
        fontMenu.add(courierItem);

        menuBar.add(colorMenu);
        menuBar.add(fontMenu);
        setJMenuBar(menuBar);
    }

    private void setFont(String fontName) {
        Font currentFont = textArea.getFont();
        textArea.setFont(new Font(fontName, currentFont.getStyle(), currentFont.getSize()));
    }

    public static void main(String[] args) {
        // Простая версия без UIManager - будет использоваться системный Look and Feel по умолчанию
        SwingUtilities.invokeLater(() -> {
            new TextEditor().setVisible(true);
        });
    }
}