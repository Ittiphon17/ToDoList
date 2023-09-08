import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Form1 extends JFrame implements ActionListener {

    public Container cp;
    public BufferedImage Image1; 
    public JLabel M;
    public JButton B;

    public Form1(){
        super("To Do List !!");
        Initial();
        setComponent();
        Finally() ;
    }
    public void Initial(){
        cp = getContentPane();
        cp.setLayout(null);
    }

    public void setComponent(){

        B = new JButton("Let's go");
        B.setBounds(450, 350, 100, 30);
        B.setForeground(Color.black);
        B.setBackground(new Color(45,45,45,45));
        
        B.setActionCommand("Let's go");
        B.addActionListener(this);
        cp.add(B);

        // วิธีตูน

        try {
            Image1 = ImageIO.read(new File("Image/2.png"));
            M = new JLabel(new ImageIcon(Image1));
            M.setBounds(0, 0, 1000, 600);
            cp.add(M);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // วิธกูเอง

        // M = new JLabel();
        // M.setIcon(new ImageIcon("Image/2.png"));
        // Dimension size = M.getPreferredSize();
        // M.setBounds(0, 0, size.width, size.height);
        // cp.add(M);
    }

    public void actionPerformed(ActionEvent e) {
        if ("Let's go".equals(e.getActionCommand())) {
            Form2 Form2 = new Form2();
            Form2.setVisible(true);
            dispose();
            }
    }

    public void Finally(){
        setSize(1000, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
