import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame
{
Container c;
JButton btnAdd, btnView, btnUpdate, btnDelete, btnCharts;

MainFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());

btnAdd = new JButton("Add");
btnView = new JButton("View");
btnUpdate = new JButton("Update");
btnDelete = new JButton("Delete");
btnCharts = new JButton("Charts");

c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);
c.add(btnCharts);

ActionListener a1 = (ae) -> {
AddFrame af = new AddFrame();
dispose();
};
btnAdd.addActionListener(a1);

ActionListener a2 = (ae) -> {
ViewFrame vf = new ViewFrame();
dispose();
};
btnView.addActionListener(a2);

ActionListener a3 = (ae) -> {
UpdateFrame uf = new UpdateFrame();
dispose();
};
btnUpdate.addActionListener(a3);

ActionListener a4 = (ae) -> {
DeleteFrame df = new DeleteFrame();
dispose();
};
btnDelete.addActionListener(a4);

ActionListener a5 = (ae) -> {
Charts cf = new Charts();
dispose();
};
btnCharts.addActionListener(a5);

setTitle("S .M. S");
setSize(300, 300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Color c = new Color(200,255,200); 
getContentPane().setBackground(c);
setVisible(true);

}

}