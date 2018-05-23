import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.codoid.products.fillo.*;
//https://codoid.com/fillo/
public class Test {

	public static void main(String[] args) throws FilloException {
		
		String fileloc = "H:\\Downloads\\writingtest.xlsx";
		Fillo fillo = new Fillo(); 
		Connection connection = fillo.getConnection(fileloc);
		String strQuery="Update Sheet1 Set Phone='US' where LastName='Gysberts'";
		connection.executeUpdate(strQuery);
		connection.close();
	}
}	