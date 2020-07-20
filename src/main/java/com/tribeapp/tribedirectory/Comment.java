package com.tribeapp.tribedirectory;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Comment{

    @Id
    public String commentid;
    String businessName;
    String businessId;
    String userName;
    String body;
    Date addedOn;
}
