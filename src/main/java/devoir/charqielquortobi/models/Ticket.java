package devoir.charqielquortobi.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Column(name = "id_ticket")
	private int id_ticket;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "urgence")
	private String urgence;
	
	@Column(name = "environnement")
	private String environnement;
	
	@Column(name = "logiciel")
	private String logiciel;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "attribue_a")
	private String attribue_a;
	

	public Ticket() {
		
	}

	public int getId_ticket() {
		return id_ticket;
	}

	public void setId_ticket(int id_ticket) {
		this.id_ticket = id_ticket;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrgence() {
		return urgence;
	}

	public void setUrgence(String urgence) {
		this.urgence = urgence;
	}

	public String getEnvironnement() {
		return environnement;
	}

	public void setEnvironnement(String environnement) {
		this.environnement = environnement;
	}

	public String getLogiciel() {
		return logiciel;
	}

	public void setLogiciel(String logiciel) {
		this.logiciel = logiciel;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAttribue_a() {
		return attribue_a;
	}

	public void setAttribue_a(String attribue_a) {
		this.attribue_a = attribue_a;
	}
	
}
