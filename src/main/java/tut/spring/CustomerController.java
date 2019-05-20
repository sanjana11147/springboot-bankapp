package tut.spring;

import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {

    CustomerMockedData customerMockedData = CustomerMockedData.getInstance();

    @RequestMapping("/customer")
    public List<Customer> index(){
        return customerMockedData.fetchCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer show(@PathVariable String id){
        int customerId = Integer.parseInt(id);
        return CustomerMockedData.getCustomerById(customerId);
    }

    @PostMapping("/customer/search")
    public List<Customer> search(@RequestBody Map<String, String> body){
        String query = body.get("text");
        return CustomerMockedData.searchCustomers(query);
    }

    @PostMapping("/customer")
    public Customer create(@RequestBody Map<String, String> body){
        int id = Integer.parseInt(body.get("id"));
        String name = body.get("name");
        String bank_name = body.get("bank_name");
        String repayment_option = body.get("repayment_option");
        return customerMockedData.createCustomer(id , name, bank_name, repayment_option);
    }

    @PutMapping("/customer/{id}")
    public Customer update(@PathVariable int id, @RequestBody Map<String, String> body){
        int customerId = Integer.parseInt(String.valueOf(id));
        String name = body.get("name");
        String bank_name = body.get("bank_name");
        String repayment_option = body.get("repayment_option");
        return customerMockedData.updateCustomer(id, name, bank_name, repayment_option);
    }

    @DeleteMapping("customer/{id}")
    public boolean delete(@PathVariable String id){
        int customerId = Integer.parseInt(id);
        return customerMockedData.delete(customerId);
    }
}
