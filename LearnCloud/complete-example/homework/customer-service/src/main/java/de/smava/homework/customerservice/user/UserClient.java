package de.smava.homework.customerservice.user;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${auth.users.name}")
public interface UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "${auth.users.url}")
    ResponseEntity<UserDTO> getUser(@RequestHeader("Authorization") String bearerToken, @PathVariable("id") String id);
}
