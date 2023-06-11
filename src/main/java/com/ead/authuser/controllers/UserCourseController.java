package com.ead.authuser.controllers;

import com.ead.authuser.clients.*;
import com.ead.authuser.dtos.*;
import lombok.extern.log4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.data.web.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Log4j2
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserCourseController {

    @Autowired
    UserClient userClient;

    @GetMapping("/users/{userId}/courses")
    public ResponseEntity<Page<CourseDto>> getAllCoursesByUser(
            @PageableDefault(page = 0, size = 10, sort = "courseId", direction = Sort.Direction.ASC) Pageable pageable,
            @PathVariable(value = "userId") UUID userId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(userClient.getAllCoursesByUser(userId, pageable));
    }
}
