package com.jhapragyakant.ecommerce;

import com.jhapragyakant.ecommerce.config.AppConstants;
import com.jhapragyakant.ecommerce.entities.Role;
import com.jhapragyakant.ecommerce.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EcommerceBackendApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			Role role1 = new Role();
			role1.setRoleId(AppConstants.ADMIN_USER);
			role1.setRoleName("ROLE_ADMIN");

			Role role2 = new Role();
			role2.setRoleId(AppConstants.NORMAL_USER);
			role2.setRoleName("ROLE_NORMAL");

			List<Role> roles = List.of(role1, role2);
			List<Role> results = roleRepository.saveAll(roles);

			results.forEach((result) ->{
				System.out.println(result.getRoleName());
			});
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
