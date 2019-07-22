package nl.rls.ci.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@NoArgsConstructor
@Getter
@Setter
public class CiMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date createDate;
	private Date postDate;
	private boolean posted = false;
	@OneToOne(cascade = CascadeType.ALL)
	private UicHeader uicHeader;
	@OneToOne(cascade = CascadeType.ALL)
	private UicRequest uicRequest;
	@OneToOne(cascade = CascadeType.ALL)
	private UicResponse uicResponse;
	private int ownerId;
}
