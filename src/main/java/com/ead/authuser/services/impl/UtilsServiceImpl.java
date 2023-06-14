package com.ead.authuser.services.impl;

import com.ead.authuser.services.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UtilsServiceImpl implements UtilsService {

    public String createUrlGetAllCoursesByUserId(UUID userId, Pageable pageable) {
        return  "/courses?userId=" + userId +
                "&page=" + pageable.getPageNumber() +
                "&size=" + pageable.getPageSize() +
                "&sort=" + pageable.getSort().toString().replaceAll(": ", ",");
    }
}
