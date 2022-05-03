package org.flowable.ui.common.rest.idm.remote;

import org.flowable.ui.common.model.UserRepresentation;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 免登录，替换原RemoteAccountResource，返回固定用户
 */
@RestController
@RequestMapping({"/app", "/"})
public class RemoteAccountResource{
    @GetMapping(
            value = {"/rest/account"},
            produces = {"application/json"}
    )
    public UserRepresentation getAccount(Authentication authentication) {
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setId("admin");
        userRepresentation.setEmail("zdb17173@xxx.com");
        userRepresentation.setFirstName("admin");
        userRepresentation.setLastName("admin");

        return userRepresentation;
    }
}