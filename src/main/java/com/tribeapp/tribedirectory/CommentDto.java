package com.tribeapp.tribedirectory;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CommentDto{

    String userName;
    String body;
    String businessId;
}
