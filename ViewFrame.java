import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ViewFrame extends JFrame {

Container c;
TextArea taData;
JButton btnBack;

ViewFrame() {
c = getContentPane();
c.setLayout(new FlowLayout());
Color k = new Color(255,255,153); 
taData = new TextArea(10,30);
taData.setBackground(k);
btnBack = new JButton("Back");
c.add(taData);
c.add(btnBack);

String data = new DbHandler().viewStudent();
taData.setText(data);


ActionListener a1 = (ae) -> {
MainFrame af = new MainFrame();
dispose();
};

btnBack.addActionListener(a1);
setTitle("View Student");
setSize(300, 300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Color n = new Color(255,255,153); 
getContentPane().setBackground(n);
setVisible(true);
}
}

