package com.storytime.pinokoiskmainapp.entities;

import com.storytime.pinokoiskmainapp.entities.links.PersonSeriesProfessionLinkEntity;
import com.storytime.pinokoiskmainapp.entities.simple.GenreEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "series")
public class SeriesEntity extends Show {

    @Id
    @Column(insertable = false, updatable = false, name = "series_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "avg_running_time")
    private Integer avgRunningTime;
    @Column(name = "seasons_count")
    private Integer seasonCount;
    @Column(name = "series_count")
    private Integer seriesCount;
    @Column(name = "budget_on_episode")
    private Integer budgetOnEpisode;

    @ManyToMany(targetEntity = GenreEntity.class, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "series_on_genres",
            joinColumns = {@JoinColumn(name = "series", referencedColumnName = "series_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre", referencedColumnName = "genre_id")}
    )
    @NotNull
    private List<GenreEntity> genres;

    @OneToMany(mappedBy = "series", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonSeriesProfessionLinkEntity> pspl;


    //Todo: Постер

    //TODO: Добавить функционал для отдельных серий
}
