package devoir.charqielquortobi.models;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Column(name = "id_user")
	private int id_user;
	
	@Column(name = "nom")
	private String nom ;
	
	@Column(name = "password")
	private String password ;
	
	@Column(name = "email")
	private String email ;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "phone_number")
	private String phone_number ;
	
	@Column(name = "role")
	private String role;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_ticket_List", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_ticket"))
    private List<Ticket> ticketslist ;

    public Utilisateur () {}

	public List<String> getRoleList() {
		if (this.role.length() > 0) {
			return Arrays.asList(this.role.split(","));
		}

		return new ArrayList<String>();
	}

	
	public Utilisateur(int id_user, String nom, String password, String email, String phone_number, String role) {
		this.id_user = id_user;
		this.nom = nom;
		this.password = password;
		this.email = email;
		this.enabled = true;
		this.phone_number = phone_number;
		this.role = role;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Ticket> getTicketslist() {
		return ticketslist;
	}

	public void setTicketslist(List<Ticket> ticketslist) {
		this.ticketslist = ticketslist;
	}
        
}
