package com.ead.authuser.dtos;

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

    @NotBlank(groups = UserView.RegistratioPost.class)
    @Size(min = 4, max = 50)
    @JsonView(UserView.RegistratioPost.class)
    private String username;

    @NotBlank(groups = UserView.RegistratioPost.class)
    @Email
    @JsonView(UserView.RegistratioPost.class)
    private String email;

    @NotBlank(groups = {UserView.RegistratioPost.class, UserView.PasswordPut.class})
    @Size(min = 6, max = 20)
    @JsonView({UserView.RegistratioPost.class, UserView.PasswordPut.class})
    private String password;

    @NotBlank(groups = UserView.PasswordPut.class)
    @Size(min = 6, max = 20)
    @JsonView(UserView.PasswordPut.class)
    private String oldPassword;

    @JsonView({UserView.RegistratioPost.class, UserView.UserPut.class})
    private String fullName;

    @JsonView({UserView.RegistratioPost.class, UserView.UserPut.class})
    private String phoneNumber;

    @JsonView({UserView.RegistratioPost.class, UserView.UserPut.class})
    private String cpf;

    @NotBlank(groups = UserView.ImagePut.class)
    @JsonView(UserView.ImagePut.class)
    private String imageUrl;

}
