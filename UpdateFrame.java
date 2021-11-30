import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class InvalidRollnoException1 extends Exception {
String msg;
InvalidRollnoException1(String msg) {
this.msg= msg;
}
}
class EmptyNameException1 extends Exception {
String msg1;
EmptyNameException1(String msg1) {
this.msg1= msg1;
}
}
class OnlyAlphabetException1 extends Exception {
String msg2;
OnlyAlphabetException1(String msg2) {
this.msg2= msg2;
}
}
class InvalidNameException1 extends Exception {
String msg3;
InvalidNameException1(String msg3) {
this.msg3= msg3;
}
}
class InvalidMarksException4 extends Exception {
String msg7;
InvalidMarksException4(String msg7) {
this.msg7= msg7;
}
}
class InvalidMarksException5 extends Exception {
String msg8;
InvalidMarksException5(String msg8) {
this.msg8= msg8;
}
}
class InvalidMarksException6 extends Exception {
String msg9;
InvalidMarksException6(String msg9) {
this.msg9= msg9;
}
}


class UpdateFrame extends JFrame {
Container c;
JLabel lblRno, lblName, lblSub1, lblSub2, lblSub3;
JTextField txtRno, txtName , txtSub1 ,txtSub2 , txtSub3;
JButton btnSave, btnBack;

UpdateFrame() {
c = getContentPane();	
c.setLayout(new FlowLayout());

lblRno = new JLabel("enter Rno");
txtRno = new JTextField(20);
lblName = new JLabel("enter name");
txtName = new JTextField(20);
lblSub1 = new JLabel("enter sub marks 1:");
txtSub1 = new JTextField(20);
lblSub2 = new JLabel("enter sub marks 2:");
txtSub2 = new JTextField(20);
lblSub3 = new JLabel("enter sub marks 3:");
txtSub3 = new JTextField(20);


btnSave = new JButton("Save");
btnBack = new JButton("Back");
c.add(lblRno);
c.add(txtRno);
c.add(lblName);
c.add(txtName);
c.add(lblSub1);
c.add(txtSub1);
c.add(lblSub2);
c.add(txtSub2);
c.add(lblSub3);
c.add(txtSub3);
c.add(btnSave);
c.add(btnBack);

ActionListener a3 = (ae) -> {
MainFrame af = new MainFrame();
dispose();
};
btnBack.addActionListener(a3);

ActionListener a4 = (ae) -> {
int rno = 0;
try{
rno = Integer.parseInt(txtRno.getText());
if (rno == 0)
	throw new InvalidRollnoException1("Rollno cannot be zero");
}
catch(NumberFormatException e) {
	JFrame f = new JFrame();
	JOptionPane.showMessageDialog(f,"Please enter a roll number");
	return;
}
catch(InvalidRollnoException1 e) {
	JFrame u = new JFrame();
	JOptionPane.showMessageDialog(u,e.msg);
	return;
}

String name="";
try {

name = txtName.getText();
if(name.isEmpty())
	throw new EmptyNameException1("Name Cannot be Empty");
else if(!name.matches("^[a-zA-Z]*$"))
	throw new OnlyAlphabetException1("Name should contain only alphabets");
else if(name.length()<2)
	throw new InvalidNameException1("Name cannot contain less than two alphabets");
}

catch(EmptyNameException1 e) {
	JFrame t = new JFrame();
	JOptionPane.showMessageDialog(t,e.msg1);
	return;
}
catch(OnlyAlphabetException1 e) {
	JFrame r = new JFrame();
	JOptionPane.showMessageDialog(r,e.msg2);
	return;
}
catch(InvalidNameException1 e) {
	JFrame h = new JFrame();
	JOptionPane.showMessageDialog(h,e.msg3);
	return;
}
int s1 = 0;
try{
s1 = Integer.parseInt(txtSub1.getText());
if (s1<0 || s1>100)
	throw new InvalidMarksException4("Marks cannot be less than zero & greater than 100");
}

catch(NumberFormatException e) {
	JFrame v = new JFrame();
	JOptionPane.showMessageDialog(v,"Please enter Marks for subject1");
	return;
}
catch(InvalidMarksException4 e) {
	JFrame g = new JFrame();
	JOptionPane.showMessageDialog(g,e.msg7);
	return;
}
int s2 = 0;
try{
s2 = Integer.parseInt(txtSub2.getText());
if (s2<0 || s2>100)
	throw new InvalidMarksException5("Marks cannot be less than zero & greater than 100");
}

catch(NumberFormatException e) {
	JFrame w = new JFrame();
	JOptionPane.showMessageDialog(w,"Please enter Marks for subject2");
	return;
}
catch(InvalidMarksException5 e) {
	JFrame x = new JFrame();
	JOptionPane.showMessageDialog(x,e.msg8);
	return;
}

int s3 = 0;
try{
s3 = Integer.parseInt(txtSub3.getText());
if (s3<0 || s3>100)
	throw new InvalidMarksException6("Marks cannot be less than zero & greater than 100");
}

catch(NumberFormatException e) {
	JFrame j = new JFrame();
	JOptionPane.showMessageDialog(j,"Please enter Marks for subject3");
	return;
}
catch(InvalidMarksException6 e) {
	JFrame x = new JFrame();
	JOptionPane.showMessageDialog(x,e.msg9);
	return;
}


DbHandler db = new DbHandler();
db.updateStudent(rno, name,s1 ,s2 ,s3);
};
btnSave.addActionListener(a4);




setTitle("Update Student");
setSize(300, 300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Color n = new Color(255,204,200); 
getContentPane().setBackground(n);
setVisible(true);
}
}