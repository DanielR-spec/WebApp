package com.model.ptr;

import javax.annotation.ManagedBean;

//@ManagedBean(name="user")
//@SessionScoped
public class UsuarioDAO {

	private int Id;
	private String name;
	private String secName;
	private String email;
	private String password;
	private Boolean isValid;
	
	public UsuarioDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	private int getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	private void setId(int id) {
		Id = id;
	}
	/**
	 * @return the name
	 */
	private String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the secName
	 */
	private String getSecName() {
		return secName;
	}
	/**
	 * @param secName the secName to set
	 */
	private void setSecName(String secName) {
		this.secName = secName;
	}
	/**
	 * @return the email
	 */
	private String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	private void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	private String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	private void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the isValid
	 */
	private Boolean getIsValid() {
		return isValid;
	}
	/**
	 * @param isValid the isValid to set
	 */
	private void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	
	

}
