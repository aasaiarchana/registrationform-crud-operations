package form;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;




public class StuDao {
		public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/regfom", "root", "admin");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int saveDetails(Student s) {
		int mark = 0;
		try {
			Connection con = StuDao.getConnection();
			System.out.println("thanagopal"+con);
			PreparedStatement ps = con.prepareStatement("insert into regfom91(name,address,email) values (?,?,?)");
			ps.setString(1, s.getName());
			ps.setString(2, s.getAddress());
			ps.setString(3, s.getEmail());
			//System.out.println("thanagopal"+s.getAddress()+s.getEmail()+s.getName());
			mark = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mark;

	}
	public static int update(Student s){  
        int mark=0;  
        try{  
            Connection con=StuDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update regfom91 set name=?,address=?,email=? where id=?");  
            ps.setString(1,s.getName());  
            ps.setString(2,s.getAddress());  
            ps.setString(3,s.getEmail()); 
            ps.setInt(4,s.getId()); 
            System.out.println("gopalupdate");
            mark=ps.executeUpdate();        
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return mark;  
    }  
	public static Student getStudentById(int id){  
        Student s =new Student();  
          
        try{  
            Connection con=StuDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from regfom91 where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                s.setId(rs.getInt(1));  
                s.setName(rs.getString(2));  
                s.setAddress(rs.getString(3));  
                s.setEmail(rs.getString(4));  
                 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return s;  
    }  
	public static int delete(int id){  
        int marks=0;  
        try{  
            Connection con=StuDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from regfom91 where id=?");  
            ps.setInt(1,id);  
            marks=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return marks;  
    }  


public static List<Student> getAllStudent(){  
    List<Student> list=new ArrayList<Student>();  
      
    try{  
        Connection con=StuDao.getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from regfom91");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            Student s=new Student();  
            s.setId(rs.getInt(1));  
            s.setName(rs.getString(2));  
            s.setAddress(rs.getString(3));  
            s.setEmail(rs.getString(4));  
             
            list.add(s);  
        }  
        con.close();  
    }catch(Exception e){e.printStackTrace();}  
      
    return list;  
}  
}