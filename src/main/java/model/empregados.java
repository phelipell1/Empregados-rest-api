package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Empregados")
public class empregados {
	
	private long id;
	private String primeroNome;
	private String sobrenome;
	private String emailId;
	
	public empregados() {
		
	}

	public empregados(long id, String primeroNome, String sobrenome, String emailId) {
		super();
		this.id = id;
		this.primeroNome = primeroNome;
		this.sobrenome = sobrenome;
		this.emailId = emailId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "primero_nome", nullable = false)
	public String getPrimeroNome() {
		return primeroNome;
	}

	public void setPrimeroNome(String primeroNome) {
		this.primeroNome = primeroNome;
	}
	
	@Column(name = "segundo_nome", nullable = false)
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "empregados [id=" + id + ", primeroNome=" + primeroNome + ", sobrenome=" + sobrenome + ", emailId="
				+ emailId + "]";
	}
	
}
