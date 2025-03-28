package com.madebywizard.ecommerce;

import com.madebywizard.ecommerce.exceptions.ItemNotFoundException;
import com.madebywizard.ecommerce.item.ItemRepository;
import com.madebywizard.ecommerce.item.model.Item;
import com.madebywizard.ecommerce.item.model.ItemDTO;
import com.madebywizard.ecommerce.item.services.GetItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // initialize mocks by using MockitoExtension
public class GetItemServiceTest {

    @Mock // create mock objects (dummy implementations) that will be used for testing purposes. we need this dependency to create and run the test
    private ItemRepository itemRepository;


    @InjectMocks // inject mock objects that we want to test
    private GetItemService getItemService;


//    This is no longer recommended (Mockito 4.x or later prefers using 'MockitoAnnotations.openMocks(this)' to initialize mocks)
//    @BeforeEach // things that are needed before the test runs (we use this to avoid repetition of setup code)
//    public void setup() {
//        // initializes 'UserRepository' and 'GetUserService' objects
//        MockitoAnnotations.openMocks(this);
//    }

//
//    @Test
//    public void given_user_exists_when_get_user_service_return_user_dto() {
//
//        // Given
//        Item user = new Item();
//
//        user.setId(1);
//        user.setFirstName("Tester");
//        user.setLastName("Kim");
//        user.setSex('M');
//        user.setBirthDate(LocalDate.of(2000, 1, 1));
//        user.setUserId("test123");
//        user.setUserPassword("testing1234");
//
//
//        // create a behavior (find user by id = 1) then return the user (creates an Optional object containing User object)
//        when(itemRepository.findById(1)).thenReturn(Optional.of(user));
//
//        // When ( -> a scenario that I want to test)
//        ResponseEntity<ItemDTO> response = getItemService.execute(1);
//
//        //Then (an expectation of the test -> a scenario that are expecting to occur)
//        assertEquals(ResponseEntity.ok(new ItemDTO(user)), response);
//        verify(itemRepository, times(1)).findById(1);
//    }
//
//    @Test
//    public void given_user_does_not_exist_when_get_user_service_throw_user_not_found_exception() {
//
//        //Given
//        when(itemRepository.findById(1)).thenReturn(Optional.empty());
//
//        // When and Then
//        assertThrows(ItemNotFoundException.class, () -> getItemService.execute(1));
//        verify(itemRepository, times(1)).findById(1);
//
//    }
}
