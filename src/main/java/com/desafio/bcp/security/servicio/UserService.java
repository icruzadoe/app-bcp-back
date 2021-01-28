package com.desafio.bcp.security.servicio;

import com.desafio.bcp.security.util.Role;
import com.desafio.bcp.security.entidad.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, User> users;

    @PostConstruct
    public void init(){
        users = new HashMap<>();
        users.put("user",
                new User("user",
                            "cBrlgyL2GI2GINuLUUwgojITuIufFycpLG4490dhGtY=",
                                    true,
                                               Collections.singletonList(Role.ROLE_USER)));
        users.put("admin",
                new User("admin",
                        "dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w=",
                        true,
                        Collections.singletonList(Role.ROLE_ADMIN)));
    }

    public Mono<User> findByUserName(String username){
        if(users.containsKey(username)){
            return Mono.just(users.get(username));
        }else{
            return Mono.empty();
        }
    }

}
