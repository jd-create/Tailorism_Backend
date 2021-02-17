package nl.novi.jdemeijervandriel.tailorism;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MainTests {

	@Test
	void contextLoads() {
	}
/*
The AAA (Arrange, Act, Assert) pattern is a common way of writing unit tests for a method under test.
The Arrange section of a unit test method initializes objects and sets the value of the data that is passed to the method
under test.

The Act section invokes the method under test with the arranged parameters.

The Assert section verifies that the action of the method under test behaves as expected.
------------------------
Ook handig gevonden op:https://www.baeldung.com/spring-boot-configure-data-source-programmatic

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenCalledSave_thenCorrectNumberOfUsers() {
        userRepository.save(new User("Bob", "bob@domain.com"));
        List<User> users = (List<User>) userRepository.findAll();

        assertThat(users.size()).isEqualTo(1);
    }
}
 */
}
