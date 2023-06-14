package com.ead.authuser.services;

import org.springframework.data.domain.*;

import java.util.*;

public interface UtilsService {

    public String createUrlGetAllCoursesByUserId(UUID userId, Pageable pageable);
}
