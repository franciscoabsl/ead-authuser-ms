package com.ead.authuser.services;

import org.springframework.data.domain.*;

import java.util.*;

public interface UtilsService {

    public String createUrl(UUID userId, Pageable pageable);
}
