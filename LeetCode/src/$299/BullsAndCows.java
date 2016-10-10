package $299;

public class BullsAndCows {
	public String getHint(String secret, String guess) {
        int[] counts = new int[10];
        int bulls = 0, cows = 0;
        //first get the bulls and fill out counts array
        for (int i = 0; i < secret.length(); i++) {
            char secretChar = secret.charAt(i), guessChar = guess.charAt(i);
            if (secretChar == guessChar) {
                bulls++;
            } else {
                counts[secretChar - '0']++;
            }
        }
        
        //second get the cows
        for (int i = 0; i < secret.length(); i++) {
            char secretChar = secret.charAt(i), guessChar = guess.charAt(i);
            if (secretChar != guessChar) {
                if (counts[guessChar - '0']-- > 0) {
                    cows++;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }
}
