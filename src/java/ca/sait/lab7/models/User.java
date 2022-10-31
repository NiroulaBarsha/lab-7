
package ca.sait.lab7.models;

import java.io.Serializable;

/**
 *
 * @author Barsha
 */
public class User implements Serializable{
        private String email;
	private boolean active;
	private String firstname;
	private String lastname;
	private String password;
	private Role role;

	public User(){
	
	}
	public User(String email,boolean active,String firstname,String lastname,String password,Role role){
	this.email=email;
	this.active=active;
	this.firstname=firstname;
	this.lastname=lastname;
	this.password=password;
	this.role=role;
        }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
        
}
