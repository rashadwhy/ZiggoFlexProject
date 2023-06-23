import java.util.regex.Pattern;

public class PostcodeCheck {
    private final KlantDatabase klantDatabase;
    private final String databaseName;

    public PostcodeCheck(KlantDatabase klantDatabase, String databaseName) {
        this.klantDatabase = klantDatabase;
        this.databaseName = databaseName;
    }

    public static boolean isGeldig(String postcode) {
        boolean validFormat = Pattern.matches("\\d{4}[\\s]?[A-Z]{2}", postcode);

        if (!validFormat) {
            return false;
        }

        String numericPostcode = postcode.substring(0, 4);

        int inputPostcode = Integer.parseInt(numericPostcode);

        int[][] postcodeRanges = {
                {1011, 1199}, {1201, 1437}, {1441, 1489}, {1501, 1569}, {1600, 1659}, {1700, 1935},
                {1940, 2013}, {2021, 2071}, {2074, 2136}, {2139, 2215}, {2221, 2224}, {2231, 2269},
                {2271, 2289}, {2291, 2321}, {2324, 2396}, {2400, 2445}, {2447, 2499}, {2511, 2518},
                {2521, 2533}, {2541, 2555}, {2561, 2585}, {2591, 2597}, {2600, 2665}, {2671, 2678},
                {2681, 2716}, {2718, 2752}, {2761, 2763}, {2771, 2771}, {2800, 2831}, {2833, 2871},
                {2900, 2925}, {2931, 2957}, {2961, 2995}
        };

        for (int[] range : postcodeRanges) {
            int start = range[0];
            int end = range[1];
            if (inputPostcode >= start && inputPostcode <= end) {
                return true;
            }
        }

        return false;
    }
}
