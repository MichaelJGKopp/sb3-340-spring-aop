package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.dao.MembershipDAOImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

			demoTheAfterReturningAdviceMethod(accountDAO);
		};
	}

	private void demoTheBeforeAdviceMethod(AccountDAO accountDAO) {

		Account account = new Account();
		account.setName("John Doe");
		account.setLevel("Platinum");

		accountDAO.addAccount(account);

		membershipDAOImpl.addAccount();

		accountDAO.setName("foobar");
		System.out.println("AccountDAO name: " + accountDAO.getName() + "\n");

	}

	private void demoTheAfterReturningAdviceMethod(AccountDAO accountDAO) {

		List<Account> accounts = accountDAO.findAccounts();

		System.out.println("accounts, changed return value during advice: " + accounts);
	}
}
