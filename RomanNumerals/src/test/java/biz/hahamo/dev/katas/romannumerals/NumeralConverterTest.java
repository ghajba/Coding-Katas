package biz.hahamo.dev.katas.romannumerals;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NumeralConverterTest
{
    NumeralConverter converter = new NumeralConverter();

    @Test(dataProvider = "arabicToRoman")
    public void testSimpleNumbers(Integer arabicNumber, String romanResult)
    {
        assertEquals(converter.convertToRoman(arabicNumber), romanResult);
    }

    @DataProvider(name="arabicToRoman")
    public Object[][] createTestForArabicToRoman()
    {
        return new Object[][]{
            {0,null},
            {1,"I"},
            {5,"V"},
            {10,"X"},
            {50,"L"},
            {100,"C"},
            {500,"D"},
            {1000,"M"},
            {3000, "MMM"},
            {1666,"MDCLXVI"},
            {1111,"MCXI"}
        };
    }
}
