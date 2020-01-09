package com.loginsecurity;

import com.loginsecurity.bean.Resource;
import com.loginsecurity.bean.Role;
import com.loginsecurity.repository.ResourceRepository;
import com.loginsecurity.repository.RoleRepository;
import com.loginsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StarterData implements ApplicationRunner {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Role all = new Role("ALL");
        Role user = new Role("USER");
        Role none = new Role("NONE");
        Role student = new Role("STUDENT");
        Role admin = new Role("ADMIN");

        if (roleRepository.count() == 0 && resourceRepository.count() == 0) {
            roleRepository.save(none);
            roleRepository.save(admin);
            roleRepository.save(student);
            roleRepository.save(user);
            roleRepository.save(all);

            Resource r = new Resource();
            r.setPage("/**.jsp");
            r.getRoles().add(none);
            resourceRepository.save(r);
            r = null;

            String[] permitallresources = {"/bootstrap/**", "/css/**", "/images/**",
                    "/jquery/**", "/js/**", "/menu/**", "/index", "/login", "/register"};



            for(int i=0; i < permitallresources.length; ++i) {
                Resource resource = new Resource();
                resource.setPage(permitallresources[i]);
                resource.getRoles().add(all);
                resourceRepository.save(resource);
            }

            r = new Resource();
            r.setPage("/admin");
            r.getRoles().add(admin);
            resourceRepository.save(r);
            r = null;

            r = new Resource();
            r.setPage("/student");
            r.getRoles().add(student);
            r.getRoles().add(admin);
            resourceRepository.save(r);
            r = null;

        }

        /*for(Resource resource : resourceRepository.findAll()){
            String page = resource.getPage();
            List<String> roles = new ArrayList<>();
            resource.getRoles().parallelStream().forEach(role -> roles.add(role.getName()));
        }*/
    }
}
