import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
class InvalidRollnoException2 extends Exception {
String msg;
InvalidRollnoException2(String msg) {
this.msg= msg;
}
}

class DeleteFrame extends JFrame {
Container c;
JLabel lblRno;
JTextField txtRno;
JButton btnSave, btnBack;

DeleteFrame() {
c = getContentPane();	
c.setLayout(new FlowLayout());

lblRno = new JLabel("enter Rno");
txtRno = new JTextField(20);


btnSave = new JButton("Save");
btnBack = new JButton("Back");
c.add(lblRno);
c.add(txtRno);
c.add(btnSave);
c.add(btnBack);


ActionListener a5 = (ae) -> {
MainFrame af = new MainFrame();
dispose();
};
btnBack.addActionListener(a5);

ActionListener a6 = (ae) -> {
int rno = 0;
try{
rno = Integer.parseInt(txtRno.getText());
if (rno == 0)
	throw new InvalidRollnoException2("Rollno cannot be zero");
}
catch(NumberFormatException e) {
	JFrame f = new JFrame();
	JOptionPane.showMessageDialog(f,"Please enter a roll number");
	return;
}
catch(InvalidRollnoException2 e) {
	JFrame u = new JFrame();
	JOptionPane.showMessageDialog(u,e.msg);
	return;
}

DbHandler db = new DbHandler();
db.deleteStudent(rno);
};
btnSave.addActionListener(a6);




setTitle("Delete Student");
setSize(300, 300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Color c = new Color(150,204,255); 
getContentPane().setBackground(c);
setVisible(true);
}
}