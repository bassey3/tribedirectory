package com.tribeapp.tribedirectory;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessService{

    private final BusinessRepo businessRepo;


    public boolean create (BusinessDto businessdto){
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
        return aBusinesses;
    }

    public Optional<Business> getOneByName (String businessName){
        var aBusinesses = businessRepo.findByName(businessName);
        return Optional.ofNullable(aBusinesses);
    }
}
