package ui;

import javax.swing.*;
import java.awt.*;

public class JPanelDemo {
    public static void main(String[] args) {
        JFrame jf = new JFrame("java 第二个GUI程序");
        jf.setBounds(400,300,400,200);
        JPanel jp = new JPanel();
        JLabel jl = new JLabel("这是放在JPanel 的标签");
        jp.setBackground(Color.white);
        jp.add(jl);
        jf.add(jp);
        jf.setVisible(true);
    }
}
