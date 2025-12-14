import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CeluciusToFarenheint {
    
    public static void main(String[] args){

        JFrame frame = new JFrame("converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 120);

        JTextField celcius = new JTextField(5);

        JLabel resultado = new JLabel("farenheit");

        JButton botao = new JButton("convert");

        // Ação do botão
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celsius = Double.parseDouble(celcius.getText());
                    double fahrenheit = (celsius * 1.8) + 32;
                    resultado.setText(String.format("%.2f Fahrenheit", fahrenheit));
                } catch (NumberFormatException ex) {
                    resultado.setText("valor invalido!");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(celcius);
        panel.add(new JLabel("celsius"));
        panel.add(botao);
        panel.add(resultado);

        frame.add(panel);
        frame.setVisible(true);
    }
}
