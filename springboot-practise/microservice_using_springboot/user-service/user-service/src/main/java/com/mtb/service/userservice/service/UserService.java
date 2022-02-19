package com.mtb.service.userservice.service;

import com.mtb.service.userservice.entity.User;
import com.mtb.service.userservice.repository.UserRepository;
import com.mtb.service.userservice.vo.Department;
import com.mtb.service.userservice.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author MithileshB
 * @created 28/01/2022 - 9:36 PM
 * @project user-service
 */
@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserService");

        ResponseTemplateVO responseTemplateVO=new ResponseTemplateVO();
        User user=userRepository.findByUserId(userId);

        Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;

    }
}
