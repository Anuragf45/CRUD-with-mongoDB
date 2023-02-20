package com.example.final_connection.model;

import com.example.final_connection.dao.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class customerController {
    @Autowired
private customerRepository customerRepository;

    @PostMapping("/addCustomer")
    public customer addCustomer(@RequestBody customer Customer){
        System.out.println(Customer.getSalary());
        customerRepository.save(Customer);
        return Customer;
    }

    @GetMapping("/getCustomers")
    public List<customer> getCustomer(){
      return  customerRepository.findAll();
    }

    @PutMapping("/updateCustomer/{id}")
    public String updateCustomer(@PathVariable String id, @RequestBody customer Customer){
//          boolean exists=customerRepository.existsById(Id);
//          customer Customer1=customerRepository.findById(Id);

        Optional<customer> optionalCustomer1 = customerRepository.findById(id);
        if(!optionalCustomer1.isPresent()){
            return "No such customer with id "+id;
        }else{
            customer customerData = optionalCustomer1.get();
            customerData.setName(Customer.getName());
            customerData.setSalary(Customer.getSalary());
            customerRepository.save(customerData);

            return "customer updated with Id "+id;
        }
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public  String deleteCustomer(@PathVariable String id){
        System.out.println(id);
        customerRepository.deleteById(id);
        return "Customer with Id "+ id+" has been deleted";
    }
}
