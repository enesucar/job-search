package com.topkapi.jobsearch.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "job")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "updated_date")
    private String updatedDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    @ManyToOne
    @JoinColumn(name = "position_id")
    @JsonIgnore
    private Position position;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    @JsonIgnore
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIgnore
    private City city;

    @OneToMany(mappedBy = "job")
    @JsonIgnore
    private List<Application> applications;
}
