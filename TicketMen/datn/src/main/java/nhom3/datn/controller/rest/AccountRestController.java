package nhom3.datn.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nhom3.datn.entity.Account;
import nhom3.datn.entity.Category;
import nhom3.datn.entity.Movie;
import nhom3.datn.service.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
    @Autowired
    AccountService accountService;

    @GetMapping
    public List<Account> getAccounts(@RequestParam("admin") Optional<Boolean> admin){
        if(admin.orElse(false)){
            return accountService.getAdministrators();
        }
        return accountService.findAllStaff(); 
    }
//  @GetMapping("{id}")
//     public Account getOne(@PathVariable("id") Long id){
//         return accountService.findById(id);
//     }

    @PostMapping()
    public Account create(@RequestBody Account account){
        return accountService.create(account);
    }

    @PutMapping("{id}")
    public Account update(@PathVariable("id") String id,
        @RequestBody Account account){
        return accountService.update(account);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id){
        accountService.delete(id);
    }

    @GetMapping("{id}")
    public Account getUser(@PathVariable("id") String id){
        return accountService.findById(id);
    }
}
