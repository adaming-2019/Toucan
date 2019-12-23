package fr.adaming.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	
	// déclaration des atributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ro")
	private int id;
	private String rolename;
	
	// transformation de l'association UML en Java
	@OneToMany(mappedBy="role")
	private List<Client> clients;
	
	@OneToMany(mappedBy="role")
	private List<Administrateur> admins;
	
	// déclaration des constructeurs
	public Role() {
		super();
	}
	public Role(String rolename) {
		super();
		this.rolename = rolename;
	}
	public Role(int id, String rolename) {
		super();
		this.id = id;
		this.rolename = rolename;
	}
	
	// déclaration des getters et setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + "]";
	}
	
	

}
