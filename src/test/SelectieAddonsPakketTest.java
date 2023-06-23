import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectieAddonsPakketTest {
    private InputStream standardIn;

    @BeforeEach
    void setUp() {
        standardIn = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(standardIn);
    }

    @Test
    void testSelecteerAddons_NoAddonsSelected() {
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        SelectieAddonsPakket selectieAddonsPakket = new SelectieAddonsPakket();
        selectieAddonsPakket.selecteerAddons();

        String expectedAddons = "Geen addons";
        assertEquals(expectedAddons, selectieAddonsPakket.getAddons());
    }

    @Test
    void testSelecteerAddons_AddonsSelected() {
        String input = "1\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        SelectieAddonsPakket selectieAddonsPakket = new SelectieAddonsPakket();

        selectieAddonsPakket.selecteerAddons();

        String expectedAddons = "[Film1]";
        assertEquals(expectedAddons, selectieAddonsPakket.getAddons());
    }
}
