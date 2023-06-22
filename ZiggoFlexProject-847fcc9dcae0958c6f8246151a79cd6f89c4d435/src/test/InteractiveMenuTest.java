//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.InputStream;
//import java.io.PrintStream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class InteractiveMenuTest {
//    private InputStream originalInput;
//    private PrintStream originalOutput;
//    private ByteArrayOutputStream outputStream;
//
//    @BeforeEach
//    public void setup() {
//        originalInput = System.in;
//        originalOutput = System.out;
//        outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//    }
//
//    @AfterEach
//    public void teardown() {
//        System.setIn(originalInput);
//        System.setOut(originalOutput);
//    }
//
//    @Test
//    public void testInteractiveMenu() {
//        // Set up input stream
//        String input = "1\nAnwar Muradin\n2152EP\n22\n1\n3\n3\n1\n4\n1\n2\n3\n4\n5\n";
//        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//        System.setIn(inputStream);
//
//        // Run the interactive menu
//        InteractiveMenu menu = new InteractiveMenu();
//        menu.run();
//
//        // Verify the output
//        String expectedOutput = "Naam: Anwar Muradin\n" +
//                "Postcode: 2152EP\n" +
//                "Huisnummer: 22\n" +
//                "Pakketten: [TV Max, Internet Max]\n" +
//                "Addons: [Ziggo Sport Totaal, Film1, ESPN Compleet, FOX Sports Compleet]\n" +
//                "Factuur totaal: €136.50\n";
//        assertEquals(expectedOutput, outputStream.toString());
//    }
//}
