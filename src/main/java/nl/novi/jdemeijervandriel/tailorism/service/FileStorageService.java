package nl.novi.jdemeijervandriel.tailorism.service;


import nl.novi.jdemeijervandriel.tailorism.domain.CustomerDetails;
import nl.novi.jdemeijervandriel.tailorism.domain.File;
import nl.novi.jdemeijervandriel.tailorism.exception.RecordNotFoundException;
import nl.novi.jdemeijervandriel.tailorism.repository.CustomerDetailsRepository;
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
    private CustomerDetailsRepository customerDetailsRepository;

    public File store(MultipartFile file, long id) throws IOException{

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        File file1 = new File(fileName, file.getContentType(), file.getBytes());

        CustomerDetails customerDetails = null;
        if (customerDetailsRepository.existsById((id))) {
            customerDetails = customerDetailsRepository.findById(id).orElse(null);
        }
        file1.setCustomer(customerDetails);

        return fileRepository.save(file1);

    }

    public File getFileById(String id){
        return fileRepository.findById(id).get();
    }

    public File getFile(long id){
        if(fileRepository.existsByCustomerDetails_Id(
                id)){
            return fileRepository.findByCustomerDetails_Id(id);
        }
        else{
        throw new RecordNotFoundException();
        }
    }
}
