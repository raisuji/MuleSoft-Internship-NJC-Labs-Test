import java.sql.ResultSet;
import java.util.*;

class Movies
{
    public static void main(String[] args) {
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
            Connection con = DriverManager.getConnection("jdbc:odbc:Movies");   
            Statement  statement = con.createStatement();
            ResultSet  rs1 = statement.executeQuery("create database movies");
            ResultSet  rs2 = statement.executeQuery("create table movie(movie_name varchar(30),lead_actor varchar(20),lead_actress varchar(20),YOR year,Director_name varchar(20))");
            ResultSet  rs3 = statement.executeUpdate("insert into movie values('Dabang','Salman Khan','Sonakshi sinha','2019','Prabhu Deva')");
            ResultSet  rs4 = statement.executeQuery("Select * from movie");
            System.out.println("movie_name\t lead_actor\t lead_actress\t YOR\t Director_name");

            while(rs4.next())
            {
                System.out.print(rs4.getString("movie_name")+"\t"+ rs4.getString("lead_actor")+"\t"+ rs4.getString("lead_actress")+"\t"+ rs4.getInt("YOR")+"\t"+ rs4.getString("Director_name"));  
            }
           }
        catch(Exception e){
        }

        con.close();

    }
}