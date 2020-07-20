package com.tribeapp.tribedirectory;

import java.util.List;
import lombok.Data;

@Data
public class BusinessDto{

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
    List<CommentDto> comments;

}
