package com.ead.authuser.services.impl;

import com.ead.authuser.repositories.*;
import com.ead.authuser.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Autowired
    UserCourseRepository userCourseRepository;
}
