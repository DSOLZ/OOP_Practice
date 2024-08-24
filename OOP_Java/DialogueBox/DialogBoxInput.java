import javax.swing.JOptionPane;

public class DialogBoxInput {

	public static void main(String[] args)  {
		String s = JOptionPane.showInputDialog("Enter an integer");
		System.out.println("You entered " + s);

        try{
		int n = Integer.parseInt(s);
		System.out.println("Conversion was successful. The integer is " + n);
        }
        catch (NumberFormatException nfe){
            System.err.println("Data is not an integer.\n");
            System.err.println(nfe.getMessage());
        }
	}

}