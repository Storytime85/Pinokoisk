package com.storytime.pinokoiskmainapp.entities.simple;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "streamings")
public class StreamingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "streaming_id")
    private Long id;

    @NotNull
    @Size(max = 20, message = "Слишком длинное название")
    @Column(name = "name")
    private String streamingService;
}
