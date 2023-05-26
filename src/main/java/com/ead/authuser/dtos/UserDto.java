package com.ead.authuser.dtos;

import com.ead.authuser.validations.UsernameConstraint;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    public interface UserView {
        public static interface RegistratioPost {}
        public static interface UserPut {}
        public static interface PasswordPut {}
        public static interface ImagePut {}
    }

    private UUID userId;

    @NotBlank(groups = UserView.RegistratioPost.class, message = "Username can not be empty.")
    @Size(min = 4, max = 50, groups = UserView.RegistratioPost.class, message = "Username must be between 4 and 50 characters")
    @UsernameConstraint(groups = UserView.RegistratioPost.class)
    @JsonView(UserView.RegistratioPost.class)
    private String username;

    @NotBlank(groups = UserView.RegistratioPost.class, message = "Email can not be empty.")
    @Email(groups = UserView.RegistratioPost.class, message = "Email is not valid.")
    @JsonView(UserView.RegistratioPost.class)
    private String email;

    @NotBlank(groups = {UserView.RegistratioPost.class, UserView.PasswordPut.class}, message = "Password can not be empty.")
    @Size(min = 6, max = 20, groups = {UserView.RegistratioPost.class, UserView.PasswordPut.class}, message = "Password must be between 6 and 20 characters")
    @JsonView({UserView.RegistratioPost.class, UserView.PasswordPut.class})
    private String password;

    @NotBlank(groups = UserView.PasswordPut.class, message = "Old password can not be empty.")
    @Size(min = 6, max = 20, groups = UserView.PasswordPut.class, message = "Old password must be between 4 and 50 characters")
    @JsonView(UserView.PasswordPut.class)
    private String oldPassword;

    @JsonView({UserView.RegistratioPost.class, UserView.UserPut.class})
    private String fullName;

    @JsonView({UserView.RegistratioPost.class, UserView.UserPut.class})
    private String phoneNumber;

    @JsonView({UserView.RegistratioPost.class, UserView.UserPut.class})
    private String cpf;

    @NotBlank(groups = UserView.ImagePut.class, message = "Image URL can not be empty.")
    @JsonView(UserView.ImagePut.class)
    private String imageUrl;

}
