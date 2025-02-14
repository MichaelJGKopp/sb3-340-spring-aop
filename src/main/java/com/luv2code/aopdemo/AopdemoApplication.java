package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.dao.MembershipDAOImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	private final MembershipDAOImpl membershipDAOImpl;

	public AopdemoApplication(MembershipDAOImpl membershipDAOImpl) {
		this.membershipDAOImpl = membershipDAOImpl;
	}

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		return runner -> {

			demoTheBeforeAdviceMethod(accountDAO);
		};
	}

	private void demoTheBeforeAdviceMethod(AccountDAO accountDAO) {

		accountDAO.addAccount(new Account());

		membershipDAOImpl.addAccount();
	}
}
