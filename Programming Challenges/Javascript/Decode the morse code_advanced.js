/*
Kata Name: Deocde the morse code, advanced
Problem Task: In this kata you have to write a Morse code decoder for wired electrical telegraph.
Electric telegraph is operated on a 2-wire line with a key that, when pressed, connects the wires together, which can be detected on a remote station. The Morse code encodes every character being transmitted as a sequence of "dots" (short presses on the key) and "dashes" (long presses on the key).

When transmitting the Morse code, the international standard specifies that:

"Dot" – is 1 time unit long.
"Dash" – is 3 time units long.
Pause between dots and dashes in a character – is 1 time unit long.
Pause between characters inside a word – is 3 time units long.
Pause between words – is 7 time units long.
However, the standard does not specify how long that "time unit" is. And in fact different operators would transmit at different speed. An amateur person may need a few seconds to transmit a single character, a skilled professional can transmit 60 words per minute, and robotic transmitters may go way faster.
For this kata we assume the message receiving is performed automatically by the hardware that checks the line periodically, and if the line is connected (the key at the remote station is down), 1 is recorded, and if the line is not connected (remote key is up), 0 is recorded. After the message is fully received, it gets to you for decoding as a string containing only symbols 0 and 1.

Sample Tests:
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MorseCodeDecoderTest {
    @Test
    public void testExampleFromDescription() throws Exception {
        assertThat(MorseCodeDecoder.decodeMorse(MorseCodeDecoder.decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011")), is("HEY JUDE"));
    }
}
*/

const decodeBits = bits => {
    const arrayOfBits = bits.match(/(\d)\1*/g); // split for parts
    // find the length of symbols
    const length = Math.min(Infinity, ...arrayOfBits
        .filter((x, i) => // remove some extra 0's
            (i === 0 && x[0] === '1') ||
            (i > 0 && i < arrayOfBits.length - 1) ||
            (i === arrayOfBits.length - 1 && x[0] === '1')
        )
        .map(x => x.length)
    );

    return arrayOfBits
        .map(x => {
            const symLength = x.length / length; // find the correct length

            return +x[0] // descode bits to Morse code
                ?
                symLength > 1 ? '-' : '.' :
                symLength > 3 ? '   ' :
                symLength > 1 ? ' ' : '';
        })
        .join ``;
}

const decodeMorse = morseCode => {
    return morseCode
        .trim() //remove extra spaces
        .split('   ') //devide by words
        .map((str) => //parse each word
            str
            .split(' ') //devide by symbols
            .map((s) => MORSE_CODE[s]) //return Char
            .join('')
        )
        .join(' ');
}