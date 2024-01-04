package com.a08r.restfulapirelations.modles.entities.dto;


import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLocationDTO {
    private String email;
    private String username;
    private String place;
    private Double latitude;
    private Double longitude;

}
