package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class StartUi {
    private JPanel panel=new JPanel();
    private JComboBox cmb=new JComboBox();    //创建JComboBox
    private JLabel label=new JLabel("添加新城市：");
    private JLabel showInfo=new JLabel();    //用于显示信息
    private JTextField jtf=new JTextField(16);    //用于输入信息
    private JButton buttonAdd=new JButton("新增");
    private JButton buttonDel=new JButton("删除");

    public StartUi(){
        JFrame frame = new JFrame("Boss数据整理助手");
        cmb.addItem("--请选择--");
        cmb.addItem("北京");
        cmb.addItem("上海");
        panel.add(cmb);
        panel.add(label);
        panel.add(jtf);
        panel.add(buttonAdd);
        panel.add(buttonDel);
        frame.add(panel);
        buttonAdd.addActionListener(new MyActionListener());
        buttonDel.addActionListener(new MyActionListener());
        cmb.addItemListener(new MyItemListener());
        frame.setBounds(300,200,600,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    class MyItemListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            String s = e.getItem().toString();
            panel.add(showInfo);
        }
    }

    class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if(command.equals("新增")){
                if(jtf.getText().length()!=0){
                    cmb.addItem(jtf.getText());
                    panel.add(showInfo);
                    showInfo.setText("添加成功，新增了："+jtf.getText());
                }else{
                    panel.add(showInfo);
                    showInfo.setText("请输入要添加的城市");
                }
            }
            if(command.equals("删除")){
                if(cmb.getSelectedIndex()!=-1)
                {
                    //先获得要删除的项的值
                    String strDel=cmb.getSelectedItem().toString();
                    cmb.removeItem(strDel);    //删除项
                    panel.add(showInfo);
                    showInfo.setText("删除成功，删除了："+strDel);
                }
                else
                {
                    panel.add(showInfo);
                    showInfo.setText("请选择要删除的星座");
                }
            }
        }
    }


    public static void main(String[] agrs)
    {
        new StartUi();
    }

}
