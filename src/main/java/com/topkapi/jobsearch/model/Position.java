package com.topkapi.jobsearch.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "position")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "position")
    @JsonIgnore
    private List<Job> jobs;
}
