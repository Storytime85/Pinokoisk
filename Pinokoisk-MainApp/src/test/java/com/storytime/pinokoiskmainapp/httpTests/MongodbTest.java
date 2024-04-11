package com.storytime.pinokoiskmainapp.httpTests;

import com.storytime.pinokoiskmainapp.entities.reviews.ReviewEntity;
import com.storytime.pinokoiskmainapp.service.ReviewContentService;
import com.storytime.pinokoiskmainapp.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@Profile("test")
@SpringBootTest
public class MongodbTest {
    @Autowired
    private ReviewContentService reviewService;

    @Test
    public void readEntity_expectExistsAndValid(){
        ReviewEntity reviewEntity = new ReviewEntity("6616d1638d1b1c12acf59648",
                "Lorem ipsum",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                        "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                        "laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
                        "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat " +
                        "non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                );
        assertThat(reviewService.findOne("6616d1638d1b1c12acf59648")).
                isNotNull();
        assertThat(reviewService.findOne("6616d1638d1b1c12acf59648")).
                isEqualTo(reviewEntity);
    }
}
