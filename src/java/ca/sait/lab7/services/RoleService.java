
package ca.sait.lab7.services;
import ca.sait.lab7.models.Role;
import java.util.List;
import ca.sait.lab7.dataaccess.UserDB;
import ca.sait.lab7.dataaccess.RoleDB;
/**
 *
 * @author Barsha
 */
public class RoleService{
		private RoleDB roleDB = new RoleDB();
	
	public List<Role> getAll() throws Exception{
	List<Role> roles = this.roleDB.getAll();
	return roles;
	}
}
