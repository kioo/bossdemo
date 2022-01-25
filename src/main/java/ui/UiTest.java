package ui;

import javax.swing.*;
import java.awt.*;

public class UiTest extends JFrame {

    public UiTest(){
        setTitle("Java 2022 第一个程序");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jl = new JLabel("这是JFrame 类创建的窗口");
        Container contentPane = getContentPane();
        contentPane.add(jl);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UiTest();
    }
}
