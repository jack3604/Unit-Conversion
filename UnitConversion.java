public class UnitConversion {
    final double INCHES_TO_FEET = 12; // 12 inches in 1 foot

    public static void main(String[] args) {
        String unitFrom = "";
        String unitTo = "";
        int unit = 0;

        if (args.length == 3) {
            unitFrom = args[0];
            unitTo = args[1];
            unit = Integer.parseInt(args[2]);
            System.out.println(unit + " " + unitFrom + " to " + unitTo);
        }
        else {
            System.out.println("You must use 3 arguments.");
        }


    }
}

// inches, feet, cubits, steps, yards, miles