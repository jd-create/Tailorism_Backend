package nl.novi.jdemeijervandriel.tailorism.controller;

import nl.novi.jdemeijervandriel.tailorism.domain.Address;
import nl.novi.jdemeijervandriel.tailorism.domain.CustomerDetails;
import nl.novi.jdemeijervandriel.tailorism.domain.File;
import nl.novi.jdemeijervandriel.tailorism.payload.RegisterUserRequest;
import nl.novi.jdemeijervandriel.tailorism.payload.response.ResponseMessage;
import nl.novi.jdemeijervandriel.tailorism.repository.AddressRepository;
import nl.novi.jdemeijervandriel.tailorism.service.CustomerDetailsService;
import nl.novi.jdemeijervandriel.tailorism.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerDetailsService customerDetailsService;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") long id){
        CustomerDetails customerDetails = customerDetailsService.getCustomerById(id);
        return new ResponseEntity<>(customerDetails, HttpStatus.OK);
    }

    @GetMapping(value = "/lastname/{lastname}")
    public ResponseEntity<Object> getCustomerByLastName(@PathVariable("lastname") String lastname){
        CustomerDetails customerDetails = customerDetailsService.getCustomerByLastName(lastname);
        return new ResponseEntity<>(customerDetails, HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Object> saveCustomer(@RequestBody RegisterUserRequest registerUserRequest){
        long newId = customerDetailsService.saveCustomer(registerUserRequest);
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/id/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") long id){
        customerDetailsService.deleteCustomer(id);
        return new ResponseEntity<>("Client with ID " + id + "deleted.", HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/id/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") long id, @RequestBody CustomerDetails customerDetails)
    {
        customerDetailsService.updateCustomer(id, customerDetails);
        return new ResponseEntity<>(customerDetails, HttpStatus.OK);
    }

    @PostMapping("/upload/customerid/{id}")
    public ResponseEntity<ResponseMessage> uploadFile(@PathVariable long id, @RequestParam("file") MultipartFile file) {

        try{
            fileStorageService.store(file, id);

            String message = "Upload file succesfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }catch (Exception e){
            String message = "Couldn't upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/download/customerid/{id}")
    public ResponseEntity<byte[]> getFileById(@PathVariable String id){
        File file1 = fileStorageService.getFileById(id);

        return  ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                 "attachment; filename=\"" + file1.getName() + "\"")
                .body(file1.getData());
    }

    @GetMapping("/address/customer_lastname/{lastname}")
    public Optional<Address> findAddressByCustomer_lastname(@PathVariable ("lastname")String lastname){
        Optional<Address> address1 = addressRepository.findAddressByCustomerDetails_LastName(lastname);
        return address1;
    }
}
