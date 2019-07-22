package nl.rls.ci.aa.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class License {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date validFrom;
	private Date validTo;
	private String contract;
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	public License(String contract, Date validFrom, Date validTo, Owner owner) {
		this.contract = contract;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		return "License [id=" + id + ", validFrom=" + validFrom + ", validTo=" + validTo + ", contract=" + contract
				+ "]";
	}
}
