
package connection;

import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 *
 * @author JOAOARTHURDELIMAFLORES
 */
public class ConnectionFactory {

////                          ~~LOCAL~~    
//    private static final String DRIVER = "com.mysql.jdbc.Driver";
//    private static final String URL = "jdbc:mysql://127.0.0.1/uniunbd";
//    private static final String USER = "root";
//    private static final String PASS = "";

////                          ~~BD UOL~~    
//    private static final String DRIVER = "com.mysql.jdbc.Driver";
//    private static final String URL = "jdbc:mysql://uniun-bd.mysql.uhserver.com:3306/uniun_bd";
//    private static final String USER = "uniun_admin";
//    private static final String PASS = "x96q12r57+";
    
//                          ~~BD JELASTIC~~    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://node43088-union.jelastic.saveincloud.net:11351/uniun_bd";
    private static final String USER = "root";
    private static final String PASS = "LIMlhd16188";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
             
            return (Connection) DriverManager.getConnection(URL, USER, PASS);
                    
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
         
    }
    
    public static void closeconnection(Connection con) {
        if(con!=null) {
            try { 
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public static void closeconnection(Connection con, PreparedStatement stmt) {
        
        closeconnection(con);
        
            try { 
                
                if(stmt!=null){
                    stmt.close();
                }
                
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    
    
    public static void closeconnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        
        closeconnection(con, stmt);
        
            try { 
                
            if(rs!=null){
                rs.close();
            }
                
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
