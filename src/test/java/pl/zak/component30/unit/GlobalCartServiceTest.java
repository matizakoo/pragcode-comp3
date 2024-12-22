package pl.zak.component30.unit;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.zak.component30.service.GlobalCartService;

@SpringBootTest
public class GlobalCartServiceTest {
    @Autowired
    private GlobalCartService globalCartService;

    @Test
    public void createNewSessionTest() {
        Assertions.assertEquals(12, globalCartService.createNewSession().length());
    }
}
