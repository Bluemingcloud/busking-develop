package com.moyoraq.busking.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MANAGERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Managers {

    @Id
    @Column(length = 30)
    private String managerId;

    @Column(nullable = false, length = 30)
    private String managerPw;

    @OneToMany(mappedBy = "manager")
    private List<Locations> locations;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "managerId", referencedColumnName = "userId")
    private Users user;
}
