package com.moyoraq.busking.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVATIONS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long resId;

    @Column(length = 20)
    private String resDate;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime resRegdate;

    @Column(length = 10)
    private long resCount;

    @Column(length = 500)
    private String resContent;

    @Column(length = 30)
    private String resEquipment;

    @Column(columnDefinition = "char(1) default 'f'")
    private String resResult;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locaId")
    private Locations location;

}
