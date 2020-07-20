package com.tribeapp.tribedirectory;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Business{

    @Id
    public String id;
    String name;
    String address;
    String category;
    String description;
    String email;
    String owner;
    String phone;
    String website;
    String facebookUrl;
    String instagramUrl;
    String googleUrl;
    String otherInfo;
    List<Comment> comments;
    Integer rating;

}
