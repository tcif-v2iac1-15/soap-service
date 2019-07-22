package nl.rls.ci.rest.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter @Setter
public class CiPostDto {
    private String messageXml;
	private String messageId;
    private Date createDate;
    private Date postDate;
    private boolean posted;
}

