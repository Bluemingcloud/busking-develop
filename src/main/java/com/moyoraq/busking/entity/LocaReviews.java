package com.moyoraq.busking.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LOCA_REVIEWS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class LocaReviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long locaReviewId;

    @Column(length = 500)
    private String locaReviewContent;

    @Column(length = 10)
    private long locaPoint;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime locaReviewRegdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locaId")
    private Locations location;
}
