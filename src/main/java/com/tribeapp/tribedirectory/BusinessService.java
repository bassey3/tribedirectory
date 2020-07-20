package com.tribeapp.tribedirectory;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.Date.from;

@Slf4j
@Service
@RequiredArgsConstructor
public class BusinessService{

    private final BusinessRepo businessRepo;
    private final CommentRepo commentRepo;
   // private final GeoApiService geoApiService;


    public boolean create (BusinessDto businessdto){

//        GeocodingResult[] response;
//        try{
//            response = geoApiService.getGeocodeForAddress(businessdto.getAddress());
//
//        }catch (Exception ex){
//            log.info("gooogle kpaf",ex);
//        }

        Business business = Business.builder()
                .name(businessdto.getName())
                .address(businessdto.getAddress())
                .category(businessdto.getCategory())
                .description(businessdto.getDescription())
                .email(businessdto.getEmail())
                .facebookUrl(businessdto.getFacebookUrl())
                .googleUrl(businessdto.getGoogleUrl())
                .instagramUrl(businessdto.getInstagramUrl())
                .phone(businessdto.getPhone())
                .owner(businessdto.getOwner())
                .otherInfo(businessdto.getOtherInfo())
                .website(businessdto.getWebsite())
                .build();

        businessRepo.save(business);
        return true;
    }

    public List<Business> getAll (){
        var allBusinesses = businessRepo.findAll();
        return allBusinesses;
    }

    public Optional<Business> getOneById (String id){
        var aBusinesses = businessRepo.findById(id);
        if(aBusinesses.isPresent()){
            var comments = commentRepo.findAllByBusinessName(aBusinesses.get().name);
            aBusinesses.get().setComments(comments);
        }
        return aBusinesses;
    }

    public Optional<Business> getOneByName (String businessName){
        var aBusinesses = businessRepo.findByName(businessName);
        return Optional.ofNullable(aBusinesses);
    }

    public boolean saveCommentToBusiness (CommentDto comment){
        String id = UUID.randomUUID().toString();
        var business = getOneById(comment.getBusinessId());
        Comment commentForSave;
        if(business.isPresent()){
            commentForSave = new Comment(id, business.get().getName(),
                    business.get().getId(), comment.getUserName(), comment.getBody(),
                    from(Instant.now()));
        }else {
            return false;
        }

        try {
            commentRepo.save(commentForSave);
            return true;

        }catch (Exception ex) {
            return false;
        }
    }

    public boolean saveRatingToBusiness (String businessId, Integer rating){
        log.debug("Saving ratings businessId {}, rating [{}]", businessId, rating);
        return true;
    }
}
