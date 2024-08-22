package com.moyoraq.busking.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Users {

    @Id
    private String userId;

    @Column(nullable = false, length = 30)
    private String userPw;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime userRegdate;

    @Column(nullable = false, length = 10)
    private String userName;

    @Column(length = 30)
    private String userEmail;

    @Column(length = 11)
    private String userPno;

    @Column(length = 100)
    private String userAddr;

    @OneToOne(mappedBy = "user")
    private Managers manager;

    @OneToMany(mappedBy = "user")
    private List<Reservations> reservations;

    @OneToMany(mappedBy = "user")
    private List<LocaReviews> locaReviews;

}
