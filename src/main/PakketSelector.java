import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface PakketSelector {
    void selecteerPakketten(Scanner scanner);
    List<String> getPakketten();
    List<String> getAddons();
}



// Abstract class implementing the PakketSelector interface
// Represents common behavior for package selection classes

