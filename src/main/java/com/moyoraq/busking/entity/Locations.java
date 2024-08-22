package com.moyoraq.busking.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LOCATIONS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long locaId;

    @Column(length = 200)
    private String locaName;

    @Column(length = 500)
    private String locaInfo;

    @Column(length = 30)
    private String locaPointX;

    @Column(length = 30)
    private String locaPointY;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mangerId")
    private Managers manager;

    @OneToMany(mappedBy = "location")
    private List<Reservations> reservations;

    @OneToMany(mappedBy = "location")
    private List<LocaReviews> locaReviews;

}
