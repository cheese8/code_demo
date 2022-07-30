package com.skypyb.test.controller;

import com.skypyb.security.service.AuthenticationUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试获取资源
 */
@RestController
public class MethodProtectedRestController {
    
    @Resource
    private AuthenticationUserService authenticationUserService;

    /**
     * This is an example of some different kinds of granular restriction for endpoints. You can use the built-in SPEL expressions
     * in @PreAuthorize such as 'hasRole()' to determine if a user has access. Remember that the hasRole expression assumes a
     * 'ROLE_' prefix on all role names. So 'ADMIN' here is actually stored as 'ROLE_ADMIN' in database!
     **/
    @RequestMapping(value = "/protectedadmin", method = RequestMethod.GET)
    public ResponseEntity<?> getProtectedAdmin() {
        return ResponseEntity.ok("Greetings from admin protected method!");
    }

    @RequestMapping(value = "/protecteduser", method = RequestMethod.GET)
    public ResponseEntity<?> getProtectedUser() {
        return ResponseEntity.ok("Greetings from user protected method!");
    }


    @RequestMapping(value = "/test/one", method = RequestMethod.GET)
    public ResponseEntity<?> testOne() {
        return ResponseEntity.ok("/test/one");
    }

    @RequestMapping(value = "/test/two/two", method = RequestMethod.GET)
    public ResponseEntity<?> testTwo() {
        return ResponseEntity.ok("/test/two/two");
    }

    @RequestMapping(value = "/ignore/testget", method = RequestMethod.GET)
    public ResponseEntity<?> testIgnoreGet() {
        return ResponseEntity.ok("/ignore/testget");
    }

    @RequestMapping(value = "/ignore/testpost", method = RequestMethod.POST)
    public ResponseEntity<?> testIgnorePost() {
        return ResponseEntity.ok("/ignore/testpost");
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public UserDTO authenticate(@RequestBody LoginDTO loginDTO, HttpServletResponse response) {
        return authenticationUserService.loadUserByUsername();
    }
}
