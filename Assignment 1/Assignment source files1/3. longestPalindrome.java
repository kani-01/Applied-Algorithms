
public class longestPalindrome {
	
	private static String currentPalindrome = "", longestPalindrome = "";

	public static String getLongestPalindrome(final String input) {
        int rightIndex = 0, leftIndex = 0;
        
        //checks odd digit palindrome
        for (int centerIndex = 1; centerIndex < input.length() - 1; centerIndex++) {
            leftIndex = centerIndex - 1;  rightIndex = centerIndex + 1;
            while (leftIndex >= 0 && rightIndex < input.length()) {
                if (input.charAt(leftIndex) != input.charAt(rightIndex)) {
                    break;
                }
                currentPalindrome = input.substring(leftIndex, rightIndex + 1);
                longestPalindrome = currentPalindrome.length() > longestPalindrome.length() ? currentPalindrome : longestPalindrome;
                leftIndex--;  rightIndex++;
            }
        }
        //checks even digit palindrome
        for (int centerIndex1 = 1; centerIndex1 < input.length() - 1; centerIndex1++) {
            leftIndex = centerIndex1 - 1;  rightIndex = centerIndex1;
            while (leftIndex >= 0 && rightIndex < input.length()) {
                if (input.charAt(leftIndex) != input.charAt(rightIndex)) {
                    break;
                }
                currentPalindrome = input.substring(leftIndex, rightIndex + 1);
                longestPalindrome = currentPalindrome.length() > longestPalindrome.length() ? currentPalindrome : longestPalindrome;
                leftIndex--;  rightIndex++;
            }
        }
        return longestPalindrome;
    }

    public static void main(String[] args) {
        String str = "Helomaam1rormadam"; //Helomadfeefdamr1ormadammadammadam
        String myLongestPalindrome = getLongestPalindrome(str);
        System.out.println("Given String is 	: " + str);
        System.out.println("Longest Palindrome	: " + myLongestPalindrome);
    }
	
}
