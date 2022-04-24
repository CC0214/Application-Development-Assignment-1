package GenPassword;

//--------------------------------------------------------------------
// Assignment 1
// Written by: Xin ZHAO 2152461
// For Application Development 2 (Mobile) - Winter 2022
// --------------------------------------------------------------------

import java.util.Random;

public class GenPassword {

		static final String[][][] book = {
				{
					{"ALICE was beginning to get very tired of sitting by her sister on the\n",
						"bank, and of having nothing to do. Once or twice she had peeped into the\n",
						"book her sister was reading, but it had no pictures or conversations in\n",
						"it, \"and what is the use of a book,\" thought Alice, \"without pictures or\n",
					"conversations?\"\n"},
					{"So she was considering in her OWN mind (as well as she could, for the\n",
						"day made her feel very sleepy and stupid), whether the pleasure of\n",
						"making a daisy-chain would be worth the trouble of getting up and\n",
						"picking the daisies, when suddenly a White Rabbit with pink eyes ran\n",
					"close by her.\n"},
					{"There was nothing so very remarkable in that, nor did Alice think it so\n",
						"very much out of the way to hear the Rabbit say to itself, \"Oh dear! Oh\n",
						"dear! I shall be too late!\" But when the Rabbit actually took a watch\n",
						"out of its waistcoat-pocket and looked at it and then hurried on, Alice\n",
						"started to her feet, for it flashed across her mind that she had never\n",
						"before seen a rabbit with either a waistcoat-pocket, or a watch to take\n",
						"out of it, and, burning with curiosity, she ran across the field after\n",
						"it and was just in time to see it pop down a large rabbit-hole, under\n",
					"the hedge. In another moment, down went Alice after it!"}
				},
				{
					{"\"WHAT a curious feeling!\" said Alice. \"I must be shutting up like a\n",
					"telescope!\"\n"},
					{"And so it was indeed! She was now only ten inches high, and her face\n",
						"brightened up at the thought that she was now the right size for going\n",
					"through the little door into that lovely garden.\n"},
					{"After awhile, finding that nothing more happened, she decided on going\n",
						"into the garden at once; but, alas for poor Alice! When she got to the\n",
						"door, she found she had forgotten the little golden key, and when she\n",
						"went back to the table for it, she found she could not possibly reach\n",
						"it: she could see it quite plainly through the glass and she tried her\n",
						"best to climb up one of the legs of the table, but it was too slippery,\n",
						"and when she had tired herself out with trying, the poor little thing\n",
					"sat down and cried.\n"},
					{"\"Come, there's no use in crying like that!\" said Alice to herself rather\n",
						"sharply. \"I advise you to leave off this minute!\" She generally gave\n",
						"herself very good advice (though she very seldom followed it), and\n",
						"sometimes she scolded herself so severely as to bring tears into her\n",
					"eyes.\n"},
					{"Soon her eye fell on a little glass box that was lying under the table:\n",
						"she opened it and found in it a very small cake, on which the words \"EAT\n",
						"ME\" were beautifully marked in currants. \"Well, I'll eat it,\" said\n",
						"Alice, \"and if it makes me grow larger, I CAN reach the key; and if it\n",
						"makes me grow smaller, I can creep under the door: so either way I'll\n",
					"get into the garden, and I don't care which happens!\"\n"},
					{"She ate a little bit and said anxiously to herself, \"Which way? Which\n",
						"way?\" holding her hand on the top of her head to feel which way she was\n",
						"growing; and she was quite surprised to find that she remained the same\n",
					"size. So she set to work and very soon finished off the cake."}
				},
				{
					{"The King and Queen of Hearts were seated on their throne when they\n",
						"arrived, with a great crowd assembled about them--all sorts of little\n",
						"birds and beasts, as well as the whole pack of cards: the Knave was\n",
						"standing before them, in chains, with a soldier on each side to guard\n",
						"him; and near the King was the White Rabbit, with a trumpet in one hand\n",
						"and a scroll of parchment in the other. In the very middle of the court\n",
						"was a table, with a large DISH of tarts upon it. \"I wish they'd get the\n",
					"trial done,\" Alice thought, \"and hand 'round the refreshments!\"\n"},
					{"The judge, by the way, was the King and he wore his crown over his great\n",
						"wig. \"That's the jury-box,\" thought Alice; \"and those twelve creatures\n",
					"(some were animals and some were birds) I suppose they are the jurors.\"\n"},
					{"Just then the White Rabbit cried out \"Silence in the court!\"\n"},
					{"\"HERALD! read the accusation!\" said the King."}
				}
		};
		

	static Random random = new Random();

	static int randomWordNumber; 
	static String[] words; 
	static String word_1; 
	static String word_2; 
	static String word_3; 
	static String password; 

	static int charCount = 0;
	static int flag1; 
	static int flag2; 
	static int flag3;  
	static int newLine = 0;
	static int singleChar = 0; 
	static int sameWords = 0; 
	static int wordLength = 0; 
	static int uppercase = 0; 
	static int lowercase = 0; 
	static int specialChar = 0; 
	static int totalPasswords = 0; 
    
	public static void main(String[] args) {
		// Welcome Message
		System.out.println("\nWelcome to the password generator game!\n");

		// print passwords
		do {
			// Validate and generate a password 
			do {

				// Generate first valid word
				do {
					firstWordGeneration();

				} while(words[randomWordNumber].length() == 1 || words[randomWordNumber].matches(".*\\n.*"));

				// Generate second valid word
				do {
					secondWordGeneration();

				} while(words[randomWordNumber].length() == 1 || words[randomWordNumber].matches(".*\\n.*"));

				// Generate third valid word and combine all three words in a password
				do {

					thirdWordGeneration();

				} while(words[randomWordNumber].length() == 1 || words[randomWordNumber].matches(".*\\n.*"));


				validation();




			} while(repeatedSubstringCount(password) > 2 || charCount < 8 || charCount > 15 || flag1 > 0 || flag2 > 0 || flag3 != 1);

			// Increment valid passwords
			totalPasswords++;

			// Print output in a required format
			System.out.println(String.format("%-30s", "Password = " + password) + String.format("%-15s", "NewLine = " + newLine) + String.format("%-15s", "Single = " + singleChar) + String.format("%-15s", "Equal = " + sameWords) + String.format("%-15s", "Length = " + wordLength) + String.format("%-15s", "Upper = " + uppercase) + String.format("%-15s", "Lower = " + lowercase) + String.format("%-15s",  "Special = " + specialChar));
            
			// Reset count
			newLine = 0; 
			singleChar = 0;
			sameWords = 0;
			wordLength = 0;
			uppercase = 0;
			specialChar = 0;

		} while(totalPasswords < 10000 && lowercase == 0);

		// Print total passwords
		System.out.println("\nTotal passwords generated: " + totalPasswords);

		// Print closing message
		System.out.println("\nThanks for using the password generator game. Good bye!");


	}

	// method to generate first word
	public static void firstWordGeneration() {
		int page = random.nextInt(book.length);
		int paragraph = random.nextInt(book[page].length);
		int line = random.nextInt(book[page][paragraph].length);
		String word = book[page][paragraph][line];

		words = word.split(" ");
		randomWordNumber = random.nextInt(words.length);
		word_1 = words[randomWordNumber];

		// check if a word has \n
		if(words[randomWordNumber].matches(".*\\n.*")) {
			newLine++;
		}
		// check if a word has one character
		if(words[randomWordNumber].length() == 1) {
			singleChar++;
		}
	}

	// method to generate second word
	static void secondWordGeneration() {
		int page = random.nextInt(book.length);
		int paragraph = random.nextInt(book[page].length);
		int line = random.nextInt(book[page][paragraph].length);
		String word = book[page][paragraph][line];

		words = word.split(" ");
		randomWordNumber = random.nextInt(words.length);
		word_2 = words[randomWordNumber];

		// check if a word has \n
		if(words[randomWordNumber].matches(".*\\n.*")) {
			newLine++;
		} 
		// check if a word has one character
		if(words[randomWordNumber].length() == 1) {
			singleChar++;
		}
	}

	// method to generate third word and concatenate words
	static void thirdWordGeneration() {
		int page = random.nextInt(book.length);
		int paragraph = random.nextInt(book[page].length);
		int line = random.nextInt(book[page][paragraph].length);

		String word = book[page][paragraph][line];
		words = word.split(" ");
		randomWordNumber = random.nextInt(words.length);
		word_3 = words[randomWordNumber];
		password = word_1 + word_2 + word_3;

		// check if a word has \n
		if(words[randomWordNumber].matches(".*\\n.*")) {
			newLine++;
		} 
		// check if a word has one character
		if(words[randomWordNumber].length() == 1) {
			singleChar++;
		}
	}

	static void validation() {

		String [] passArray = password.split("");

		charCount = 0;
		for(int i = 0; i < passArray.length; i++) {
			charCount++;
		}
		if(!(charCount >= 8 && charCount < 16)) {
			wordLength++;
		}

		flag1 = 0;
		if(!password.matches("^.*[A-Z].*")) {
			flag1 = 1;
			uppercase++;
		} 

		flag2 = 0;
		if(!password.matches("^.*[a-z].*")) {
			flag2 = 1;
			lowercase++;
		} 

		flag3 = 0;
		String [] passArraySC = password.split("");
		for(int i = 0; i < passArraySC.length; i++ ){
			if(passArraySC[i].matches("^.*[@$!%*#?&+_-].*")) {
				flag3++;
				if(flag3 != 1) {
					specialChar++;
				}

			} 
		}
		if(repeatedSubstringCount(password) > 2) {
			sameWords++;
		}
	}

	// method to count duplicated characters
	static int repeatedSubstringCount(String str) {
		int n = str.length();
		int LCSRe[][] = new int[n + 1][n + 1];

		String res = ""; 
		int res_length = 0;

		int i, index = 0;
		for (i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				
				if (str.charAt(i - 1) == str.charAt(j - 1)
						&& LCSRe[i - 1][j - 1] < (j - i)) {
					LCSRe[i][j] = LCSRe[i - 1][j - 1] + 1;

					if (LCSRe[i][j] > res_length) {
						res_length = LCSRe[i][j];
						index = Math.max(i, index);
					}
				} else {
					LCSRe[i][j] = 0;
				}
			}
		}
		if (res_length > 0) {
			for (i = index - res_length + 1; i <= index; i++) {
				res += str.charAt(i - 1);
			}
		}
		if(res.length() > 2) {
			return res.length();
		}
		return 0;
	}





}