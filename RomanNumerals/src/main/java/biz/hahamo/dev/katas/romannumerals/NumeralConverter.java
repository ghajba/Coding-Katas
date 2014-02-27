package biz.hahamo.dev.katas.romannumerals;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class NumeralConverter
{
    Map<Integer, String> conversionMap = new HashMap<Integer, String>(7);
    {
        conversionMap.put(1, "I");
        conversionMap.put(5, "V");
        conversionMap.put(10, "X");
        conversionMap.put(50, "L");
        conversionMap.put(100, "C");
        conversionMap.put(500, "D");
        conversionMap.put(1000, "M");
    }

    public String convertToRoman(Integer arabicNumber)
    {
        if (arabicNumber <= 0)
            return null;
        if (conversionMap.containsKey(arabicNumber))
            return conversionMap.get(arabicNumber);

        String romanNumber = StringUtils.repeat("I", arabicNumber);
        romanNumber = romanNumber.replaceAll("IIIIIIIIII", "X");
        romanNumber = romanNumber.replaceAll("IIIII", "V");
        romanNumber = romanNumber.replaceAll("VIIII", "IX");
        romanNumber = romanNumber.replaceAll("IIII", "IV");
        romanNumber = romanNumber.replaceAll("XXXXXXXXXX", "C");
        romanNumber = romanNumber.replaceAll("XXXXX", "L");
        romanNumber = romanNumber.replaceAll("LXXXX", "XC");
        romanNumber = romanNumber.replaceAll("XXXX", "XL");
        romanNumber = romanNumber.replaceAll("CCCCCCCCCC", "M");
        romanNumber = romanNumber.replaceAll("CCCCC", "D");
        romanNumber = romanNumber.replaceAll("DCCCC", "CM");
        romanNumber = romanNumber.replaceAll("CCCC", "CD");

        return validateRomanNumber(romanNumber) ? romanNumber : null;
    }

    public Integer convertToArabic(String romanNumber)
    {
        if (!validateRomanNumber(romanNumber))
            return 0;
        return 0;
    }

    private boolean validateRomanNumber(String romanNumber)
    {
        Pattern p = Pattern.compile("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
        Matcher m = p.matcher(romanNumber);
        return m.matches();
    }
}
