import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import java.sql.*;
import java.awt.event.ActionListener;

class Charts extends JFrame {
Charts() {

try {

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system","abc123");

String sql = "select * from student";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);
DefaultCategoryDataset d1 = new DefaultCategoryDataset();

while(rs.next()) {
	int rno = rs.getInt(1);
	String name = rs.getString(2);
	int s1 = rs.getInt(3);
	int s2 = rs.getInt(4);
	int s3 = rs.getInt(5);

	d1.addValue(s1, name, "Phy");
	d1.addValue(s2, name, "Chem");
	d1.addValue(s3, name, "Maths");

}

JFreeChart chart = ChartFactory.createBarChart("Student Performance", "Subjects", "Marks", d1, PlotOrientation.VERTICAL, true, false, false);


ChartPanel panel = new ChartPanel(chart);
setContentPane(panel);


setTitle("Mark Sheet");
setSize(800, 400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
catch(SQLException e) {
	System.out.println("issue " + e);
}

} // end of Charts()

} // end of class Charts

class ChartFrame {
public static void main(String args[]) {
ChartFrame c = new ChartFrame();
}
}
