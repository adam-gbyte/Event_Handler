import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class KuisPenjumlahan extends JFrame {
    JTextField input1, input2, inputJawaban;
    JLabel feedback;
    JButton checkButton;
    int angka1, angka2;

    public KuisPenjumlahan() {
        setTitle("Kuis Penjumlahan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new BorderLayout());

        JPanel panelUtama = new JPanel(new GridLayout(3, 1));

        JPanel panelSoal = new JPanel(new FlowLayout());
        input1 = new JTextField(3);
        input2 = new JTextField(3);
        inputJawaban = new JTextField(5);

        input1.setEditable(false);
        input2.setEditable(false);
        input1.setHorizontalAlignment(JTextField.CENTER);
        input2.setHorizontalAlignment(JTextField.CENTER);
        inputJawaban.setHorizontalAlignment(JTextField.CENTER);

        angka1 = new Random().nextInt(20) + 1;
        angka2 = new Random().nextInt(20) + 1;

        input1.setText(String.valueOf(angka1));
        input2.setText(String.valueOf(angka2));

        panelSoal.add(input1);
        panelSoal.add(new JLabel("+"));
        panelSoal.add(input2);
        panelSoal.add(new JLabel(" = "));
        panelSoal.add(inputJawaban);

        JPanel panelTombol = new JPanel();
        checkButton = new JButton("CHECK");
        panelTombol.add(checkButton);

        JPanel panelFeedback = new JPanel();
        feedback = new JLabel(" ");
        feedback.setFont(new Font("Arial", Font.BOLD, 14));
        panelFeedback.add(feedback);

        panelUtama.add(panelSoal);
        panelUtama.add(panelTombol);
        panelUtama.add(panelFeedback);

        add(panelUtama, BorderLayout.CENTER);

        checkButton.addActionListener(e -> {
            try {
                int jawabanUser = Integer.parseInt(inputJawaban.getText());
                int jawabanBenar = angka1 + angka2;

                if (jawabanUser == jawabanBenar) {
                    feedback.setText("Selamat Jawaban Anda Benar !!!");
                    feedback.setForeground(Color.GREEN);
                    panelUtama.setBackground(new Color(200, 255, 200));
                } else {
                    feedback.setText("Maaf, Jawaban Anda Salah");
                    feedback.setForeground(Color.RED);
                    panelUtama.setBackground(new Color(255, 200, 200));
                }
            } catch (NumberFormatException ex) {
                feedback.setText("Masukkan angka yang valid!");
                feedback.setForeground(Color.ORANGE);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new KuisPenjumlahan();
    }
}
