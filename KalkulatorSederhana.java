import javax.swing.*;
import java.awt.*;

public class KalkulatorSederhana extends JFrame {
    JTextField input1 = new JTextField();
    JTextField input2 = new JTextField();
    JLabel hasil = new JLabel("= ", SwingConstants.CENTER);

    public KalkulatorSederhana() {
        setTitle("Kalkulator Sederhana");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setLayout(new BorderLayout());

        JPanel panelKiri = new JPanel(new BorderLayout());

        JPanel panelInput = new JPanel(new GridLayout(1, 2, 10, 10));
        input1.setFont(new Font("Arial", Font.PLAIN, 16));
        input2.setFont(new Font("Arial", Font.PLAIN, 24));
        panelInput.add(input1);
        panelInput.add(input2);
        panelKiri.add(panelInput, BorderLayout.NORTH);

        JPanel panelTombol = new JPanel(new GridLayout(5, 1, 5, 5));
        String[] labelTombol = { "+", "-", "*", "/", "Modulus" };
        char[] simbolTombol = { '+', '-', '*', '/', '%' };

        for (int i = 0; i < labelTombol.length; i++) {
            JButton btn = new JButton(labelTombol[i]);
            char operator = simbolTombol[i];
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            btn.addActionListener(e -> hitung(operator));
            panelTombol.add(btn);
        }

        panelKiri.add(panelTombol, BorderLayout.CENTER);

        JPanel panelKanan = new JPanel(new BorderLayout());
        hasil.setFont(new Font("Arial", Font.BOLD, 28));
        hasil.setHorizontalAlignment(SwingConstants.LEFT);
        panelKanan.add(hasil, BorderLayout.NORTH);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelKiri, panelKanan);
        split.setResizeWeight(0.66);
        split.setDividerSize(2);

        add(split, BorderLayout.CENTER);
        setVisible(true);
    }

    void hitung(char op) {
        try {
            double a = Double.parseDouble(input1.getText());
            double b = Double.parseDouble(input2.getText());
            double r = switch (op) {
                case '+' -> a + b;
                case '-' -> a - b;
                case '*' -> a * b;
                case '/' -> {
                    if (b == 0) throw new ArithmeticException("Bagi 0");
                    yield a / b;
                }
                case '%' -> {
                    if (b == 0) throw new ArithmeticException("Mod 0");
                    yield a % b;
                }
                default -> 0;
            };
            hasil.setText(String.format("= %.2f", r));
        } catch (NumberFormatException e) {
            hasil.setText("Input salah");
        } catch (ArithmeticException e) {
            hasil.setText("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new KalkulatorSederhana();
    }
}
