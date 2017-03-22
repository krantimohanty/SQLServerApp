package hitesh.sqlapp;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Kranti on 16-March-17.
 */

public class ConnectionClass {
    String ip = "192.168.1.4";
    String classs = "net.sourceforge.jtds.jdbc.Driver";
    String db = "KenCentral";
    String un = "induction";
    String password = "swash@2015";

//    String port = 50857;
//    ip = "192.168.1.4";
//    ip = "SWASHDBS//SWASHSQLINT";
//    db = "KenCentral";
//    un = "induction";
//    pass = "swash@2015";

    @SuppressLint("NewApi")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {

            Class.forName(classs);
//            ConnURL = "jdbc:jtds:sqlserver://192.168.1.4/KenCentral;user=" + un + ";password=" + password;
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";"
                    + "databaseName=" + db + ";user=" + un + ";password="
                    + password + ";";

//            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";"
//                    + "databaseName=" + db + ";user=" + un + ";password="
//                    + password + ";";

            //Connection DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.188.4.83:1433/DATABASE;user=" + username + ";password=" + password);

            conn = DriverManager.getConnection(ConnURL);
//            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;
    }
}
