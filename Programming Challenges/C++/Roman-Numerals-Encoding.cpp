/*
Problem Task: Create a function taking a positive integer as its parameter and returning a string containing the Roman Numeral representation of that integer.
Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any digit with a value of zero. 
In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.

Sample Tests:
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConversionTest {

    private Conversion conversion = new Conversion();

    @Test
    public void shouldConvertToRoman() {
        assertEquals("solution(1) should equal to I", "I", conversion.solution(1));
        assertEquals("solution(4) should equal to IV", "IV", conversion.solution(4));
        assertEquals("solution(6) should equal to VI", "VI", conversion.solution(6));
    }
}

*/

#include <iostream>
#include <string>
#include <map>
#include <cmath>

const std::map<int, std::string> letters {
                                    {1, "I"}, {5, "V"}, {10, "X"},
                                    {50, "L"}, {100, "C"}, {500, "D"}, {1000, "M"}
                                   };

const std::map<int, std::string> compound_statements {
                                    {4, "IV"}, {9, "IX"}, {40, "XL"},
                                    {90, "XC"}, {400, "CD"}, {900, "CM"}
                                   };


int Get_First_Digit(int number)
{
    while(number >= 10)
    {
        number = number / 10;
    }

    return number;
}

int Split_Number(int number)
{
    int number_of_digits = [number] () { return number > 0 ? (int) log10 ((double) number) + 1 : 1; }();
    int first_digit = Get_First_Digit(number);
    int base = std::pow(10, number_of_digits -1);

    return first_digit * base;
}

bool Check_If_Compound_Statement_Possible(int number)
{
    if(compound_statements.find(number) != compound_statements.end())
        return true;
    return false;
}

decltype(auto) Find_Closest_Element(int number)
{
    std::map<int, std::string>::const_iterator closest_element = letters.end();
    int closest_number = -1;

    for(auto element = letters.begin(); element != letters.end(); ++element)
    {
        if(element->first < number)
        {
            if(element->first > closest_number)
            {
                closest_number = element->first;
                closest_element = element;
            }
        }
    }

    return closest_element;
}

void Append_Letters(int number, std::string &result)
{
    while(number != 0)
    {
        /* Try to find exact value */
        auto iter = letters.find(number);
        if(iter != letters.end())
        {
            result.append(letters.at(number));
            return;
        }
        else
        {
             std::map<int, std::string>::const_iterator closest_element = Find_Closest_Element(number);
             result.append(closest_element->second);
             number -= closest_element->first;
        }
    }
}

std::string solution(int number)
{
    int stripped_number;
    std::string result = "";

    while(number != 0)
    {
        stripped_number = Split_Number(number);
        if(Check_If_Compound_Statement_Possible(stripped_number))
        {
            result.append(compound_statements.at(stripped_number));
        }
        else
        {
            Append_Letters(stripped_number, result);
        }

        number = number - stripped_number;
    }


    return result;
}