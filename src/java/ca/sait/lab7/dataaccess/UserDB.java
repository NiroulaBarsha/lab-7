
package ca.sait.lab7.dataaccess;
import ca.sait.lab7.models.Role;
import ca.sait.lab7.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Barsha
 */
public class UserDB{

	public List<User> getAll() throws Exception{
		List<User> users = new ArrayList<>();
		ConnectionPool cp=ConnectionPool.getInstance();
		Connection con= cp.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM user Inner Join role on role.role_id=user.role";
		try{
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
			String email=rs.getString(1);
			boolean active= rs.getBoolean(2);
			String firstName=rs.getString(3);
			String lastName=rs.getString(4);
			String password=rs.getString(5);
			int roleId =rs.getInt(6);
			String roleName=rs.getString(7);
			
			Role role=new Role(roleId,roleName);	
			User user=new User(email,active,firstName,lastName,password,role);
			users.add(user);
			
			}
			
			
		}finally{
			DbUtil.closeResulSet(rs);
			DbUtil.closePreparedStatement(ps);
			cp.freeConnection(con);
		}
		return users;

	}
	

	public User get(int userId) throws Exception{
	User user = null;	
	ConnectionPool cp=ConnectionPool.getInstance();
	Connection con= cp.getConnection();
	PreparedStatement ps=null;
	ResultSet rs=null;
	String sql="SELECT * FROM user Inner Join role on role.role_id=user.role where email=? Limit 1";
	try{
	ps=con.prepareStatement(sql);
            String email = null;
	ps.setString(1,email);
	rs=ps.executeQuery();
		if(rs.next()){
		boolean active= rs.getBoolean(2);
		String firstName=rs.getString(3);
		String lastName=rs.getString(4);
		String password=rs.getString(5);
		int roleId =rs.getInt(6);
		String roleName=rs.getString(7);
			
		Role role=new Role(roleId,roleName);	
		 user=new User(email,active,firstName,lastName,password,role);
	}
	
	}finally{
		DbUtil.closeResulSet(rs);
		DbUtil.closePreparedStatement(ps);
		cp.freeConnection(con);
	}
	return user;
}
	public boolean insert (User user) throws Exception{
	ConnectionPool cp=ConnectionPool.getInstance();
	Connection con= cp.getConnection();
	PreparedStatement ps=null;
	boolean inserted=false;
	String sql="Insert into user(email,firstName,lastName,password,role) values(?,?,?,?,?)";
	try{
		ps=con.prepareStatement(sql);
		ps.setString(1,user.getEmail());
		ps.setString(2,user.getFirstname());
		ps.setString(3,user.getLastname());
		ps.setString(4,user.getPassword());
		ps.setInt(5,user.getRole().getId());
		if(inserted=ps.executeUpdate()!=0){
			inserted=true;
		}else{
			inserted=false;
		}
		
	}finally{
		DbUtil.closePreparedStatement(ps);
		cp.freeConnection(con);
	}
	return inserted;
}
	public boolean update(User user) throws Exception{
	
	ConnectionPool cp=ConnectionPool.getInstance();
	Connection con= cp.getConnection();
	PreparedStatement ps=null;
	
	String sql="Update user Set email=?,firstName=?,lastName=?,password=?,role=? where email=?";
	boolean updated;
	try{
		ps=con.prepareStatement(sql);
		
		ps.setString(1,user.getFirstname());
		ps.setString(2,user.getLastname());
		ps.setString(3,user.getPassword());
		ps.setInt(4,user.getRole().getId());
		ps.setString(5,user.getEmail());
		updated=ps.executeUpdate()!=0;
		
		
	}finally{
		DbUtil.closePreparedStatement(ps);
		cp.freeConnection(con);
	}
	return updated;
	}
	
	
	
	public boolean delete(User user) throws Exception{
	
	ConnectionPool cp=ConnectionPool.getInstance();
	Connection con= cp.getConnection();
	PreparedStatement ps=null;
	
	String sql="Update user Set active=0 Where email=?";
	boolean deleted;
	try{
		ps=con.prepareStatement(sql);
		ps.setString(1,user.getEmail());
		deleted=ps.executeUpdate()!=0;
		
		
	}finally{
		DbUtil.closePreparedStatement(ps);
		cp.freeConnection(con);
	}
	return deleted;
	}

    public User get(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
