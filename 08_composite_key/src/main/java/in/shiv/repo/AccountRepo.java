package in.shiv.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.shiv.entity.Account;
import in.shiv.entity.AccountPK;

public interface AccountRepo extends JpaRepository<Account, AccountPK>{

}
