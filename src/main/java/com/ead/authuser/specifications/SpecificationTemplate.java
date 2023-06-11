package com.ead.authuser.specifications;

import com.ead.authuser.models.*;

import net.kaczmarzyk.spring.data.jpa.domain.*;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import java.util.*;

public class SpecificationTemplate {

    @And({
        @Spec(path="userType", spec= Equal.class),
        @Spec(path="userStatus", spec= Equal.class),
        @Spec(path="email", spec= Like.class),
        @Spec(path="fullName", spec= Like.class)

    })
    public interface UserSpec extends Specification<UserModel> {}

    public static Specification<UserModel> userCourseId(final UUID courseId) {
        return (root, query, cb) -> {
            query.distinct(true);
            Join<UserModel, UserCourseModel> userProd = root.join("usersCourses");
            return cb.equal(userProd.get("courseId"), courseId);
        };
    }
}
