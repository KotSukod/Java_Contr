import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sql_db {

    private static final String url = "jdbc:mysql://localhost:3306/java";
    private static final String user = "root";
    private static final String pass = "root";

    private static Connection con;
    private static Statement stm;
    private static ResultSet rs;


    public static void add_toy(String name, int count, int drop) {

        try {

            String query = String.format("INSERT INTO toys (name, count, drop1) \n" +
                    "VALUES ('%s',%d, %d);",name,count,drop);
            con = DriverManager.getConnection(url, user, user);
            stm = con.createStatement();
            stm.executeUpdate(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void viewall(){

        try{

            String query = "SELECT Id, name, count, drop1 FROM toys;";
            con = DriverManager.getConnection(url, user, user);
            stm = con.createStatement();
            rs = stm.executeQuery(query);

            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int count = rs.getInt(3);
                int drop = rs.getInt(4);
                StringBuilder buil = new StringBuilder();
                buil.append(String.format("ID: %d ",id));
                buil.append(String.format("Название: %s ",name));
                buil.append(String.format("Количество %d ",count));
                buil.append(String.format("Шанс выпадения %d ",drop));
                String str = buil.toString();
                System.out.println(str);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updatecount(int Id, int count) {

        try {

            String query = String.format("UPDATE toys SET count = count + %d WHERE ID = %d;",count,Id);
            con = DriverManager.getConnection(url, user, user);
            stm = con.createStatement();
            stm.executeUpdate(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void updatedrop(int Id, int drop) {

        try {

            String query = String.format("UPDATE toys SET drop1 = %d WHERE ID = %d;",drop,Id);
            con = DriverManager.getConnection(url, user, user);
            stm = con.createStatement();
            stm.executeUpdate(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
