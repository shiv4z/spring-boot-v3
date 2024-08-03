package in.shiv;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.shiv.entity.Account;
import in.shiv.entity.AccountPK;
import in.shiv.repo.AccountRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		AccountRepo repo = context.getBean(AccountRepo.class);

		AccountPK pk = new AccountPK();
		pk.setAccountNo(13213215454L);
		pk.setAccType("Saving");

//		Account ac = new Account();
//		ac.setAccHolderName("Shiv Prasad");
//		ac.setAddress("New Delhi");
//		ac.setAccountPK(pk);
//		
//		repo.save(ac);

		Optional<Account> account = repo.findById(pk);
		if (account.isPresent()) {
			System.out.println(account.get());
		}
		System.out.println("Record inserted successfully..");

	}

}
