import javax.swing.*;
import java.awt.*;

public class TicTacToeSederhana extends JFrame {
    private boolean giliranX = true; // true = X, false = O
    private JButton[][] tombol = new JButton[3][3];

    public TicTacToeSederhana() {
        setTitle("Tic-Tac-Toe Sederhana");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(3, 3, 5, 5));

        Font fontBesar = new Font("Arial", Font.BOLD, 40);

        // Inisialisasi tombol-tombol
        for (int baris = 0; baris < 3; baris++) {
            for (int kolom = 0; kolom < 3; kolom++) {
                JButton btn = new JButton("");
                btn.setFont(fontBesar);
                tombol[baris][kolom] = btn;

                btn.addActionListener(e -> {
                    JButton sumber = (JButton) e.getSource();
                    if (!sumber.getText().isEmpty()) return; // Sudah diklik

                    sumber.setText(giliranX ? "X" : "O");
                    giliranX = !giliranX; // Ganti giliran
                    sumber.setEnabled(false); // Setelah diklik, disable
                });

                add(btn);
            }
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new TicTacToeSederhana();
    }
}
