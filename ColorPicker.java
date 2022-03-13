import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.GridLayout;
import java.awt.Color;

public class ColorPicker extends JPanel implements ChangeListener {
    public JSlider redS, greenS, blueS;
    public JLabel redL1, greenL1, blueL1, redL2, greenL2, blueL2;
    public JPanel colorPanel, contentPanel;

    public ColorPicker() {
        redS = new JSlider(0, 255, 0);
        greenS = new JSlider(0, 255, 0);
        blueS = new JSlider(0, 255, 0);

        redL1 = new JLabel(" Red");
        redL2 = new JLabel(" 0");
        greenL1 = new JLabel(" Green");
        greenL2 = new JLabel(" 0");
        blueL1 = new JLabel(" Blue");
        blueL2 = new JLabel(" 0");

        contentPanel = new JPanel();
        colorPanel = new JPanel();
        colorPanel.setBackground(new Color(0, 0, 0));

        contentPanel.setLayout(new GridLayout(3, 1));
        contentPanel.add(redL1);
        contentPanel.add(redS);
        contentPanel.add(redL2);
        contentPanel.add(greenL1);
        contentPanel.add(greenS);
        contentPanel.add(greenL2);
        contentPanel.add(blueL1);
        contentPanel.add(blueS);
        contentPanel.add(blueL2);

        this.setLayout(new GridLayout(2, 1));
        this.setSize(300, 300);
        this.add(colorPanel);
        this.add(contentPanel);

        // LISTENERS
        redS.addChangeListener(this);
        greenS.addChangeListener(this);
        blueS.addChangeListener(this);
        this.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        redL2.setText(redS.getValue() + "");
        greenL2.setText(greenS.getValue() + "");
        blueL2.setText(blueS.getValue() + "");
        colorPanel.setBackground(new Color(redS.getValue(), greenS.getValue(), blueS.getValue()));
        this.validate();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ColorPicker());
        frame.setSize(300, 400);
        frame.setVisible(true);
    }

}
