package nl.rls.ci.aa.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Privilege {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
 
    private String name;
 
    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;
}