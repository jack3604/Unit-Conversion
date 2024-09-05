import java.util.ArrayList;
import java.util.HashMap;

public class UnitConversion {
    final static double FEET_TO_INCHES = 12.0;    // 12 inches in 1 foot
    final static double CUBITS_TO_FEET = 1.5;     // 18 inches in 1 cubit (Google says an ancient form of measurement)
    final static double STEPS_TO_CUBITS = 1.5;    // 2.25 feet or 27 inches in a walking step
    final static double YARDS_TO_STEPS = 1.3333;  // 1 and 1/3 steps in a yard.
    final static double MILES_TO_YARDS = 1760.0;
    // LinkedHashMap to be referenced for the conversions
    public static HashMap<String, Double> unitsMap = new HashMap<>();

    public static void main(String[] args) {
        // Initialize variables
        unitsMap.put("inches", FEET_TO_INCHES);
        unitsMap.put("feet", CUBITS_TO_FEET);
        unitsMap.put("cubits", STEPS_TO_CUBITS);
        unitsMap.put("steps", YARDS_TO_STEPS);
        unitsMap.put("yards", MILES_TO_YARDS);
        unitsMap.put("miles", 1.0);
        String unitFrom = "";
        String unitTo = "";
        double unit = 0;
        double answer;

        if (args.length == 3) {
            // Assign inputs
            unitFrom = args[0];
            unitTo = args[1];
//            unit = Integer.parseInt(args[2]);
            unit = Double.parseDouble(args[2]);
            // Print a summary of the conversion to be done
            System.out.print(unit + " " + unitFrom + " to " + unitTo + ": ");
        }
        else {
            System.out.println("You must use 3 arguments.");
        }

        // Do the Conversion method and store the output as answer
        answer = Convert(unitFrom, unitTo, unit);

        // Final print statement with answer
        System.out.print(String.format("%.2f", answer) + " " + unitTo);
    }

    public static double Convert(String unitFrom, String unitTo, double unit) {
        // Initialize the starting number
        double answer = unit;

        // Determine the indexes of the starting and ending indexes in the conversion map
        ArrayList<String> indexList = new ArrayList<>(unitsMap.keySet());
        int mapEntryPos = indexList.indexOf(unitFrom);
        int mapExitPos = indexList.indexOf(unitTo);

        // Determine whether you are ascending or descending the map
        if (mapEntryPos > mapExitPos) {
            for (int i = mapEntryPos-1; i >= mapExitPos; i--) {
                // Iterate through the HashMap to get the next conversion until complete
                answer = Math.round(answer * unitsMap.get(indexList.get(i))); // Rounds numbers for division
            }
        } else {
            for (int i = mapEntryPos; i < mapExitPos; i++) {
                // Iterate through the HashMap to get the next conversion until complete
                answer = answer / unitsMap.get(indexList.get(i));
            }
        }

        return answer;
    }
}