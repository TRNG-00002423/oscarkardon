import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.EmailClient;
import com.revature.User;
import com.revature.UserRepository;
import com.revature.UserService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repository;

    @Mock
    private EmailClient emailClient;

    @InjectMocks
    private UserService userService;

    @Test
    void getUser_existingUser_returnsUser() {

        User expected = new User("John", "john@test.com");
        expected.setId(1L);

        when(repository.findById(1L))
                .thenReturn(Optional.of(expected));

        User actual = userService.getUser(1L);

        assertEquals(expected, actual);
        assertEquals("John", actual.getName());
        assertEquals("john@test.com", actual.getEmail());
    }

    @Test
    void getUser_nonExistentUser_throwsException() {

        when(repository.findById(999L))
                .thenReturn(Optional.empty());

        assertThrows(UserService.UserNotFoundException.class,
                () -> userService.getUser(999L));
    }

    @Test
    void createUser_validUser_returnsSavedUser() {

        User saved = new User("Alice", "alice@test.com");
        saved.setId(10L);

        when(repository.existsByEmail("alice@test.com"))
                .thenReturn(false);

        // repository.save() receives a NEW User object, so use any(User.class)
        when(repository.save(any(User.class)))
                .thenReturn(saved);

        User result = userService.createUser("Alice", "alice@test.com");

        assertEquals(10L, result.getId());
        assertEquals("Alice", result.getName());

        verify(emailClient).send(
                eq("alice@test.com"),
                eq("Welcome!"),
                contains("Alice"));
            }

    @Test
    void createUser_duplicateEmail_throwsException() {

        when(repository.existsByEmail("bob@test.com"))
        .thenReturn(true);

        assertThrows(UserService.DuplicateUserException.class,
                () -> userService.createUser("Bob", "bob@test.com"));
            }

    @Test
    void createUser_nullName_throwsException() {

        assertThrows(IllegalArgumentException.class,
        () -> userService.createUser(null, "test@test.com"));
    }

    @Test
    void createUser_invalidEmail_throwsException() {

        assertThrows(IllegalArgumentException.class,
        () -> userService.createUser("John", "invalidEmail"));
    }

    @Test
    void getActiveUsers_returnsList() {

        User user1 = new User("John", "john@test.com");
        User user2 = new User("Jane", "jane@test.com");

        List<User> users = List.of(user1, user2);

        when(repository.findAllActive())
                .thenReturn(users);

        List<User> result = userService.getActiveUsers();

        assertEquals(2, result.size());
        assertEquals(users, result);
    }

    @Test
    void getUserCount_returnsCount() {

        when(repository.count()).thenReturn(42L);

        long count = userService.getUserCount();

        assertEquals(42L, count);
    }
}