package nl.novi.jdemeijervandriel.tailorism.service;


import nl.novi.jdemeijervandriel.tailorism.domain.Customer;
import nl.novi.jdemeijervandriel.tailorism.domain.File;
import nl.novi.jdemeijervandriel.tailorism.exception.RecordNotFoundException;
import nl.novi.jdemeijervandriel.tailorism.repository.CustomerRepository;
import nl.novi.jdemeijervandriel.tailorism.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Service
public class FileStorageService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public File store(MultipartFile file, long id) throws IOException{

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        File file1 = new File(fileName, file.getContentType(), file.getBytes());

        Customer customer = null;
        if (customerRepository.existsById((id))) {
            customer = customerRepository.findById(id).orElse(null);
        }
        file1.setCustomer(customer);

        return fileRepository.save(file1);

    }

    public File getFileById(String id){
        return fileRepository.findById(id).get();
    }

    public File getFile(long id){
        if(fileRepository.existsByCustomer_Id(id)){
            return fileRepository.findByCustomer_Id(id);
        }
        else{
        throw new RecordNotFoundException();
        }
    }
}
