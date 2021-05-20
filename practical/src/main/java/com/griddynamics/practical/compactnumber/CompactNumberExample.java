package com.griddynamics.practical.compactnumber;

import java.math.RoundingMode;
import java.text.*;
import java.util.Currency;
import java.util.Locale;

public class CompactNumberExample {
    public static void main(String[] args) throws ParseException {

        NumberFormat numberFormat = NumberFormat
                .getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        numberFormat.setMinimumFractionDigits(1);
        numberFormat.setMaximumFractionDigits(3);
        numberFormat.setRoundingMode(RoundingMode.CEILING);

        System.out.println(numberFormat.format(100)); // 100
        System.out.println(numberFormat.format(1763)); // 1.764k
        System.out.println(numberFormat.format(100_000)); // 100.0k
        System.out.println(numberFormat.format(1000_000)); // 1.0M

        // === inverted operation ===
        numberFormat = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        System.out.println(numberFormat.parse("100 thousand"));

        // === Custom Pattern ===
        String[] compactPatterns = {"", "", "", "0t", "00f", "000d"}; // first three formats correspond to 10^0
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance();
        numberFormat = new CompactNumberFormat(decimalFormat.toPattern(), decimalFormat.getDecimalFormatSymbols(), compactPatterns);
        System.out.println(numberFormat.format(100)); // 100
        System.out.println(numberFormat.format(1000)); // 1t
        System.out.println(numberFormat.format(10000)); // 10f
        System.out.println(numberFormat.format(100_000)); // 100d

        // === ChoiceFormat ===
        double[] limits = {1, 2, 3, 4, 5, 6, 7};
        String[] daysPatterns = {"ND", "PON", "WT", "SR", "CZW", "PT", "SB"}; // SN, MON, TUE ....
        ChoiceFormat polishChoiceFormat = new ChoiceFormat(limits, daysPatterns);
        System.out.println(polishChoiceFormat.format(1));
        System.out.println(polishChoiceFormat.format(3));

        // === For Doubles use Decimal Format ===
        String pat = "###,###.##";
        DecimalFormat f = new DecimalFormat(pat);
        System.out.println(f.format(123456.667));


    }
}
