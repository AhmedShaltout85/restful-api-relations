package com.a08r.restfulapirelations.modles.entities.users;

import com.a08r.restfulapirelations.modles.BaseEntity;

import com.a08r.restfulapirelations.modles.entities.location.Location;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String email;
    private String username;
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "location_id")
    private Location location;
}
