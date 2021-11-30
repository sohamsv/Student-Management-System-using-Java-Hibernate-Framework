class Sms
{
public static void main(String args[])
{
MainFrame m = new MainFrame();
}
public static void disableWarning() {
	System.err.close();
	System.setErr(System.out);
}
}
