package com.ead.authuser.dtos;

import lombok.*;
import com.ead.authuser.enums.*;

import java.util.*;

@Data
public class CourseDto {
    private UUID courseId;
    private String name;
    private String description;
    private String imageUrl;
    private CourseStatus courseStatus;
    private CourseLevel courseLevel;
    private UUID userInstructor;
}
