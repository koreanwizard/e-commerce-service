package com.madebywizard.ecommerce;

import com.madebywizard.ecommerce.item.ItemRepository;
import com.madebywizard.ecommerce.item.model.Item;
import com.madebywizard.ecommerce.item.model.ItemDTO;
import com.madebywizard.ecommerce.item.services.SearchItemService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class SearchItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private SearchItemService searchItemService;

//    @Test
//    public void given_user_last_name_exists_when_search_user_service_return_list_of_user_dto() {
//
//        // Given
//        Item user = new Item();
//        Item user2 = new Item();
//
//        user.setId(1);
//        user.setFirstName("Tester");
//        user.setLastName("Kim");
//        user.setSex('M');
//        user.setBirthDate(LocalDate.of(2000, 1, 1));
//        user.setUserId("test123");
//        user.setUserPassword("testing1234");
//
//        user.setId(2);
//        user.setFirstName("Irene");
//        user.setLastName("Hakim");
//        user.setSex('F');
//        user.setBirthDate(LocalDate.of(2001, 5, 21));
//        user.setUserId("ire86");
//        user.setUserPassword("haha111");
//
//
//        // should return a List<User> with containing user and user2
//        when(itemRepository.findByLastNameContaining("Kim")).thenReturn(List.of(user, user2));
//
//        // When
//        ResponseEntity<List<ItemDTO>> response = searchItemService.execute("Kim");
//
//        // Then
//        // compare List<DTO> that contains an UserDTO (this includes user object) and the response
//        assertEquals(ResponseEntity.ok(List.of(new ItemDTO(user), new ItemDTO(user2))), response);
//        verify(itemRepository, times(1)).findByLastNameContaining("Kim");
//    }
}
