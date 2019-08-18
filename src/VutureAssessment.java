
public class VutureAssessment {


	//////////  Task 1   //////////
	//Counts the number of occurrences of a given letter in a string.
	public int numOfOccurences(String sentence, char letter) {
		int count=0;	//Initialise count to 0
		for(int i=0;i<sentence.length();i++) {	//To iterate through each character in the string
			if(sentence.charAt(i)==letter) {
				count+=1;						//If given letter occurs in the string increment count by 1.
			}
		}
		return count;
	}
	
	//////////  Task 2   //////////
	//Decides if a string is a palindrome, if yes return true else returns false.
	public boolean isPalindrome(String sentence) {
		String newSentence = "";	
		sentence = sentence.replaceAll("\\s", "").replaceAll("'", "").toLowerCase();	//Remove all spaces and apostrophes
		
		for(int i=sentence.length()-1;i>=0;i--) {	// To iterate through the string in reverse
			newSentence += sentence.charAt(i);		// Set the new string as palindrome of original
		}

		if(newSentence.equals(sentence)) {			//If the new string matches the original, its a palindrome
			return true;
		}else
			return false;
	}
	
	
	
	//////////  Task 3A   //////////
	//Counts the number of occurrences of words from a "censored words list" in a text.
	public String countOccurences(String censoredWords[], String sentence) {
		String a[] = sentence.split(" "); //Split the string into an array of substrings
		StringBuffer sb = new StringBuffer();
		String output;
		
		int total = 0;		//Initialise total to 0
		int[] count = new int [censoredWords.length]; 	
		for (int i = 0; i < censoredWords.length; i++) {	//To iterate through each censored word 
			for(int j=0;j<a.length;j++) {					//To iterate through each word in original string
				if(a[j].contains(censoredWords[i])) {		//If match found increase count and total
					count[i]+=1;	//Store count of each censored word at each index
					total++;
				}
			}
		}
		for(int i=0;i<censoredWords.length;i++) {	//To build the output string with all the counts
			sb.append(censoredWords[i] + ": " + count[i] + ", ");
		}
		sb.append("Total: " + total);	//Appends total to the string
		output = sb.toString();
		return output;
	}
	
	//////////	Task 3B   //////////
	//Censor words featured in the "censored words list" that appear in the text
	public String censorWords(String censoredWords[], String sentence) {
		String output;
		if (censoredWords == null){						//If sensored words array is null
			output = "Censored words array is null";
			return output;
            
        } else if (sentence == null){					//If sentence array is null
        	output = "Text array is null";
        	return output;
        }
		
		String a[] = sentence.split(" ");	//Splits the string into an array of substrings
		
		for (int i = 0; i < a.length; i++) { 	//Iterate through the substrings
			for(int j = 0;j<censoredWords.length; j++) {	//Iterate through the censored words to check if they appear in string
				if(isCensor(a[i],censoredWords[j])) {	//Uses helper method 'isCensor' to check if the words match
					a[i] = censorChars(a[i]);	//Uses helper method 'censorChars' to censor the words
				}
			}
		}
		output = String.join(" ", a);	//Build the final string with the words censored
		return output;
	}
	
	//////////	Task 3C   //////////
	//Censor a single word palindrome in a text
	public String censorPalindrome(String sentence) {
		String output;
		
		if (sentence == null){					//If sentence is null
			output = "Sentence array is null";
			return output;
        }
		
		String a[] = sentence.split(" "); 		//Split string into array of substrings
		
		for(int i = 0;i<a.length;i++) {			//Iterate through the substrings
			if(isPalindrome(a[i])) {			//Use task 2 method to check if the string is palindrome
				a[i] = censorChars(a[i]);		//Use the helper method to censor the string to $$
			}
		}
		output = String.join(" ", a);	//Build the final string to output
		return output;
	}
	
	
	/////////	Helper method to check if a word is a censored word	////////
	private boolean isCensor( String word, String censoredWord ) {
        //If word is null set to empty string
		if(word == null) {
			word = "";
		}
		if(censoredWord == null) {
			censoredWord = "";
		}
        
        if(word.toLowerCase().contains( censoredWord.toLowerCase())) {	//If the string contains censored word return true
        	return true;
        }else {
        	return false;
        }
    }
	
	
	/////////	Helper method to replace the characters in the string to '$'
    private String censorChars(String word){

        char [] a = word.toCharArray();	//Split the string into array of characters

        int first = 0;	//First position
        int last = a.length - 1;	//Last position
        
        boolean isFirst = false;	//Initialised to false and last because first position is unknown
        boolean isLast = false;

        while(!isLast || !isFirst && first != last){ //While first or last position is unknown and first doesnt equal last
            
            if (Character.isLetter(a[first])){	//If the first character is a letter, first position is known i.e. True.
                isFirst = true;
            } else {	//Else increment first
                first++;
            }
        
            if (Character.isLetter(a[last])){	//If the last character is a letter, last position is known i.e. True
                isLast = true;
            } else {	//Else decrement
                last --;
            }
        }
        
        for (int i = first + 1 ; i < last; i++){	//Change values between start and end to the '$' character
            a[i] = '$';
        }
        return new String(a);
    }
}
