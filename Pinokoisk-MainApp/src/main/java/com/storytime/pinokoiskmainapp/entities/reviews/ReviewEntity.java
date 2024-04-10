package com.storytime.pinokoiskmainapp.entities.reviews;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reviews")
public class ReviewEntity {
    @Id
    private String id;

    private Long userId;

    private String header;

    private String body;
}
