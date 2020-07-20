package com.tribeapp.tribedirectory;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@Controller
@RequiredArgsConstructor
public class RatingsController{

    private final BusinessService businessService;

    @ApiResponses(value = { @ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred"),
            @ApiResponse(code = SC_OK, message = "Save a rating for a business")
    })
    @PostMapping("/rating/{businessId}")
    public ResponseEntity saveRating(@PathVariable("businessId") String businessId, RatingDto ratingDto){

        if(businessService.saveRatingToBusiness(businessId, ratingDto.rating)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
