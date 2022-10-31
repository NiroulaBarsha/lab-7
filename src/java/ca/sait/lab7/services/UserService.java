
package ca.sait.lab7.services;
import ca.sait.lab7.models.User;
import ca.sait.lab7.models.Role;
import java.util.List;
import ca.sait.lab7.dataaccess.UserDB;
/**
 *
 * @author Barsha
 */
public class UserService{
	private UserDB userDB = new UserDB();
	public User get(String email) throws Exception{
	User user=userDB.get(email);
	return user;
	}
	public List<User> getAll() throws Exception{
	List<User> users = this.userDB.getAll();
	return users;
	}
	public boolean insert(String email,boolean active,String firstname,String lastname,String password,Role role) throws Exception{
	User user=new User(email,active,firstname,lastname,password,role);
	return this.userDB.insert(user);
	}
	public boolean update(String email,boolean active,String firstname,String lastname,String password,Role role) throws Exception{
	User user=new User(email,active,firstname,lastname,password,role);
	return this.userDB.update(user);
	}
	public boolean delete(String email) throws Exception{
	User user=new User();
	user.setEmail(email);
	return this.userDB.delete(user);
	}
}
