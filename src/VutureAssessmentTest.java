import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VutureAssessmentTest {

	VutureAssessment va = new VutureAssessment();
	
	////////////////////  Task 1  //////////////////////////////
	@Test
	public void numOfOccurences() {
		assertEquals(5, va.numOfOccurences("I have some cheese",'e')); 
		assertEquals(0, va.numOfOccurences("I have some cheese",'z'));
		assertEquals(0, va.numOfOccurences("",'e'));
	}
		
	////////////////////  Task 2  //////////////////////////////
	@Test
	public void isPalindrome() {
		assertFalse(va.isPalindrome("I have some cheese"));
		assertTrue(va.isPalindrome("God saved Eva's dog"));
		assertTrue(va.isPalindrome(""));
	}
	
	////////////////////  Task 3A  //////////////////////////////
	@Test
	public void countOccurences() {
		String censored1[] = {"cat","dog", "large"};
		String text1 = "I have a cat named Meow and a dog name Woof. I love the dog a lot. He is larger than a small horse.";
		assertEquals("cat: 1, dog: 2, large: 1, Total: 4", va.countOccurences(censored1, text1));
		
		String censored2[] = {"apple","banana", "mango"};
		String text2 = "I have a cat named Meow and a dog name Woof. I love the dog a lot. He is larger than a small horse.";
		assertEquals("apple: 0, banana: 0, mango: 0, Total: 0", va.countOccurences(censored2, text2));
		
		String censored3[] = {"hello"};
		String text3 = "hello hello hello hello hello";
		assertEquals("hello: 5, Total: 5", va.countOccurences(censored3, text3));
	}
	
	
	////////////////////  Task 3B  //////////////////////////////
	@Test
	public void  censorWords() {
		String censored1[] = {"meow","woof"};
		assertEquals("I have a cat named M$$w and a dog name W$$f. I love the dog a lot. He is larger than a small horse.",
					va.censorWords(censored1, "I have a cat named Meow and a dog name Woof. I love the dog a lot. He is larger than a small horse."));
		
		String censored2[] = null;
		assertEquals("Censored words array is null",
					va.censorWords(censored2, "I have a cat named Meow and a dog name Woof. I love the dog a lot. He is larger than a small horse."));
		
		String censored3[] = {"meow","woof"};
		assertEquals("Text array is null",
					va.censorWords(censored3, null));
	}
	
	
	////////////////////  Task 3C  //////////////////////////////
	@Test
	public void censorPalindrome() {
		assertEquals("A$$a went to vote in the election to fulfil her c$$$c duty", va.censorPalindrome("Anna went to vote in the election to fulfil her civic duty"));
		assertEquals("I have some cheese", va.censorPalindrome("I have some cheese"));
		assertEquals("Sentence array is null", va.censorPalindrome(null));
	}

}
