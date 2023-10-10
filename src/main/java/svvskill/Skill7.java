package svvskill;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.sql.*;
public class Skill7
{
    public static void main(String[] args) throws SQLException
    {
        String host = "localhost";
        String port = "3306";
        Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/svvdb2", "root", "264");
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select * from DETAIL where id=30902");
        while (rs.next()) {
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("email"));
            System.out.println(rs.getString("dob"));

        }
    }

}