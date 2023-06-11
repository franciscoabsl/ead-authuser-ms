package com.ead.authuser.clients;

import com.ead.authuser.dtos.*;
import lombok.extern.log4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

import java.util.*;

@Log4j2
@Component
public class UserClient {

    @Autowired
    RestTemplate restTemplate;

    String REQUEST_URI = "http://localhost:8082";

    public Page<CourseDto> getAllCoursesByUser(UUID userId, Pageable pageable) {
        List<CourseDto> searchResult = null;

        String url = REQUEST_URI +
                "/courses?userId=" + userId +
                "&page=" + pageable.getPageNumber() +
                "&size=" + pageable.getPageSize() +
                "&sort=" + pageable.getSort().toString().replaceAll(": ", ",");

        log.debug("REQUEST URL: {} ", url);
        log.info("REQUEST URL: {} ", url);

        try {


            log.debug("Response Number of Elements: {} ", searchResult.size());

        } catch (HttpStatusCodeException e) {

            log.error("Error request /courses {} ", e);
        }

        log.debug("Ending request /courses userID {} ", userId);

        return null;
    }
}
