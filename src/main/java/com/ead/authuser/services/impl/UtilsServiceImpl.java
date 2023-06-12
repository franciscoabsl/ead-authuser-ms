package com.ead.authuser.services.impl;

import com.ead.authuser.services.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UtilsServiceImpl implements UtilsService {

    private String REQUEST_URI = "http://localhost:8082";

    public String createUrl(UUID userId, Pageable pageable) {
        return REQUEST_URI +
                "/courses?userId=" + userId +
                "&page=" + pageable.getPageNumber() +
                "&size=" + pageable.getPageSize() +
                "&sort=" + pageable.getSort().toString().replaceAll(": ", ",");
    }
}
