package com.ead.authuser.repositories;

import com.ead.authuser.models.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface UserCourseRepository  extends JpaRepository<UserCourseModel, UUID> {
}
