package nl.rls.ci.rest.dto;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter @Setter
public class CiDto extends ResourceSupport {
    private Date createDate;
    private Date postDate;
    private boolean posted = false;
    private UicHeaderDto uicHeader;
    private UicRequestDto uicRequest;
    private UicResponseDto uicResponse;
    private OwnerDto owner;
}

