import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public abstract class AbstractPakketSelector implements PakketSelector {
    // Common implementation for selecteerPakketten method
    // ...

    // getPakketten method will be implemented by subclasses
    public abstract List<String> getPakketten();
}
