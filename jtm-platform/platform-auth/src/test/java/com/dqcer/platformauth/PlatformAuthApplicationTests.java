package com.dqcer.platformauth;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

//@SpringBootTest
class PlatformAuthApplicationTests {


    @Test
    public void testMethod() {
        List<SimpleGrantedAuthority> authorities;
        SimpleGrantedAuthority admin = new SimpleGrantedAuthority("ADMIN");
        SimpleGrantedAuthority user = new SimpleGrantedAuthority("USER");
        authorities = Lists.newArrayList(admin, user);
        authorities.stream().map(authority -> authority.getAuthority()).collect(Collectors.toList());
    }

}
