import com.delivery.Dependencies;
import com.delivery.db.UserEntity;
import com.delivery.services.RegisterUser;
import com.delivery.services.objects.UserEntityService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class RegisterUserTest {

    @Test
    public void register_successfully() {

        UserEntityService userEntityService = mock(UserEntityService.class);

        UserEntity userEntity = new UserEntity();
        userEntity.setId(7);
        userEntity.setLogin("username");
        userEntity.setPassword("password");
        userEntity.setIsAdmin((byte) 0);

        when(userEntityService.getByLogin("username")).thenReturn(null);
        when(userEntityService.save(any(UserEntity.class))).thenReturn(true);

        Dependencies.userEntityService = userEntityService;

        assert RegisterUser.register("username", "password");

        verify(userEntityService, times(1)).save(argThat(x ->
        {
            assert x != null;
            assert x.getLogin().equals(userEntity.getLogin());
            assert x.getPassword().equals(userEntity.getPassword());
            assert x.getIsAdmin() == userEntity.getIsAdmin();
            return true;
        }));
    }

    @Test
    public void register_too_small_login() {

        UserEntityService userEntityService = mock(UserEntityService.class);

        when(userEntityService.getByLogin("small")).thenReturn(null);

        Dependencies.userEntityService = userEntityService;

        assert !RegisterUser.register("small", "small");

        verify(userEntityService, never()).save(any(UserEntity.class));

    }

    @Test
    public void register_user_already_exist() {
        UserEntityService userEntityService = mock(UserEntityService.class);

        UserEntity userEntity = new UserEntity();
        userEntity.setId(7);
        userEntity.setLogin("username");
        userEntity.setPassword("password");
        userEntity.setIsAdmin((byte) 0);

        when(userEntityService.getByLogin("username")).thenReturn(userEntity);

        Dependencies.userEntityService = userEntityService;

        assert !RegisterUser.register("username", "password");

        verify(userEntityService, never()).save(any(UserEntity.class));
    }
}
