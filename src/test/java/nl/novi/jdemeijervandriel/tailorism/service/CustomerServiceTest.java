/*package nl.novi.jdemeijervandriel.tailorism.service;

import nl.novi.jdemeijervandriel.tailorism.domain.Customer;
import nl.novi.jdemeijervandriel.tailorism.repository.CustomerRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@TestConfiguration
@RunWith(SpringRunner.class)

class CustomerServiceTest {
   @TestConfiguration
    static class CustomerServiceTestContextConfiguration{
        @Bean
       public CustomerService customerService(){
            return new CustomerService();
        }
    }

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @Before
    public void setUp() {
        Customer customer= new Customer("Fietje","Janssen");

        Mockito
                .when(customerRepository.findByLastNameIgnoreCase(customer.getLastName()))
                .thenReturn(customer);
    }

    @Test
    public void testGetCustomerByLastName() {
        String name  = "Janssen";
        Customer found = customerService.getCustomerByLastName(name);

        assertThat(found.getLastName()).isEqualTo(name);
    }
}*/