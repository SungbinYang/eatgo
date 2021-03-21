package kr.co.sungbin.eatgo.application;

import kr.co.sungbin.eatgo.domain.MenuItem;
import kr.co.sungbin.eatgo.domain.MenuItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class MenuItemServiceTests {

    private MenuItemService menuItemService;

    @Mock
    private MenuItemRepository menuItemRepository;

    @Test
    void getMenuItems() {

        List<MenuItem> mockMenuItems = new ArrayList<>();
        mockMenuItems.add(MenuItem.builder().name("Kimchi").build());

        given(menuItemRepository.findAllByRestaurantId(1004L)).willReturn(mockMenuItems);

        List<MenuItem> menuItems = menuItemService.getMenuItems(1004L);
        MenuItem menuItem = menuItems.get(0);

        assertThat(menuItem.getName()).isEqualTo("Kimchi");
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        menuItemService = new MenuItemService(menuItemRepository);
    }

    @Test
    void bulkUpdate() {
        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(MenuItem.builder().name("Kimchi").build());
        menuItems.add(MenuItem.builder().id(12L).name("Gukbob").build());
        menuItems.add(MenuItem.builder().id(1004L).destroy(true).build());

        menuItemService.bulkUpdate(1L, menuItems);

        verify(menuItemRepository, times(2)).save(any());
        verify(menuItemRepository, times(1)).deleteById(eq(1004L));
    }

}