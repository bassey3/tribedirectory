package com.tribeapp.tribedirectory;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@Controller
@RequiredArgsConstructor
public class BusinessController{

    private final BusinessService businessService;

    @ApiResponses(value = { @ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred"),
            @ApiResponse(code = SC_OK, message = "A particular business")
    })
    @GetMapping("/business")
    public ResponseEntity<List<Business>> getAllBusinesses(){
        var all = businessService.getAll();
        return ResponseEntity.ok(all);
    }

    @ApiResponses(value = { @ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred"),
            @ApiResponse(code = SC_OK, message = "Return all businesses - not paginated")
    })
    @GetMapping("/business/{businessId}")
    public ResponseEntity<Business> getBusiness(@PathVariable("businessId") String businessId){
        var business = businessService.getOne(businessId);
        if(business.isPresent()){
            return ResponseEntity.ok(business.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiResponses(value = { @ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred"),
            @ApiResponse(code = SC_OK, message = "Save a particular business")
    })
    @PostMapping("/business")
    public ResponseEntity saveBusiness(BusinessDto businessdto){
        if(businessService.create(businessdto)) {
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.unprocessableEntity().build();
        }

    }

}
