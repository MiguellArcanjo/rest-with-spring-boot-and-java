package br.com.erudio.restwithspringbootandjava.mapper.custom;

import br.com.erudio.restwithspringbootandjava.data.vo.v1.UserVO;
import br.com.erudio.restwithspringbootandjava.model.User;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserMapper {
    
    public UserVO convertEntityToVo(User user) {

        UserVO vo = new UserVO();
        vo.setId(user.getId());
        vo.setUserName(user.getUserName());
        vo.setFullName(user.getFullName());
        vo.setPassword(user.getPassword());
        vo.setAccountNonExpired(true);
        vo.setAccountNonLocked(true);
        vo.setCredentialNonExpired(true);
        vo.setEnabled(true);
        return vo;
    }


    public User convertVoToEntity(UserVO user) {

        User entity = new User();
        entity.setId(user.getId());
        entity.setUserName(user.getUserName());
        entity.setFullName(user.getFullName());
        entity.setPassword(user.getPassword());
        entity.setAccountNonExpired(true);
        entity.setAccountNonLocked(true);
        entity.setCredentialNonExpired(true);
        entity.setEnabled(true);
        return entity;
    }

}
