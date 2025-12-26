package com.example.ResponseComparision.controller;

import com.example.ResponseComparision.DTO.Customer;
import com.example.ResponseComparision.DTO.FileData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.ResponseComparision.service.CustomerService;
import com.example.ResponseComparision.service.FileService;

import java.util.List;

@RestController
@Slf4j

@RequestMapping("/blocking")
public class BlockingController {

    @Autowired
    CustomerService customerService;

    @Autowired
    FileService fileService;

    @GetMapping("/test")
    public String fun(){
        return "kaka";
    }
    @GetMapping("/customers/{name}")
    public List<Customer> getCustomerByName(@PathVariable String name) {
        log.info("Getting customer by name {} ", name);
        List customerList = customerService.getCustomerByName(name);
        log.info("Received {} customers by name {}", customerList.size(), name);
        return customerList;
    }

    @PostMapping("/customers/save")
    public Customer addCustomer(@RequestBody Customer customer) {
        log.info("Adding user {} to the Database", customer.getName());
        return customerService.addCustomer(customer);
    }

    @GetMapping("/fileread")
    public String readFile() {
        log.info("reading file request");
        return fileService.readFile();
    }

    @PostMapping("/filewrite")
    public boolean writeFile(@RequestBody FileData fileData) {
        log.info("Write data {} to File", fileData);
        return fileService.writeFile(fileData);
    }
}
