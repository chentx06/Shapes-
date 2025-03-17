import javax.swing.JOptionPane;

public class ShapesTwo {

    public static void main(String[] args) {
        boolean again;
        int choice;

        do {
            String name = JOptionPane.showInputDialog("Welcome to the program of shapes! What's your name?");
            name = name.toUpperCase();
            JOptionPane.showMessageDialog(null, "Hello " + name + "! First we'll be asking you to choose a shape you want us to print, then we'll take some parameters from you and print your shape!");
            JOptionPane.showMessageDialog(null, "Now, please take a look at the console.");

            choice = getShapeChoice();
            char inputChoice = getCharacterChoice();

            int height;
            boolean mustOdd = false;
            switch (choice) {
                case 4, 5, 6, 9 -> mustOdd = true;
            }

            height = getHeight(mustOdd);

            switch (choice) {
                case 1 -> printSquare(height, inputChoice);
                case 2 -> printTriangle(height, inputChoice);
                case 3 -> printPyramid(height, inputChoice);
                case 4 -> printHourglass(height, inputChoice);
                case 5 -> printDiamond(height, inputChoice);
                case 6 -> printBowtie(height, inputChoice);
                case 7 -> printBox(height, inputChoice);
                case 8 -> printParallelogram(height, inputChoice);
                case 9 -> printFish(height, inputChoice);
            }

            again = JOptionPane.showConfirmDialog(null, "Do you wish to run the program again?", "Continue?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        } while (again);
    }

    private static int getShapeChoice() {
        int choice;
        do {
            choice = Integer.parseInt(JOptionPane.showInputDialog("Below are the choices, please type the number for the shape you want to print. For example, to choose square, press 1:\n\n"
                    + "1. Square\n"
                    + "2. Triangle\n"
                    + "3. Pyramid\n"
                    + "4. Hourglass\n"
                    + "5. Diamond\n"
                    + "6. Bowtie\n"
                    + "7. Box\n"
                    + "8. Parallelogram\n"
                    + "9. Fish"));
        } while (choice < 1 || choice > 9);
        return choice;
    }

    private static char getCharacterChoice() {
        String userInput;
        do {
            userInput = JOptionPane.showInputDialog("Now please choose any character you want us to print the shape with. It can be any character.");
        } while (userInput.isEmpty());
        return userInput.charAt(0);
    }

    private static int getHeight(boolean mustOdd) {
        int height;
        String message = mustOdd ? "Choose a height. The height must be an ODD number." : "Choose a height.";
        do {
            height = Integer.parseInt(JOptionPane.showInputDialog(message));
        } while ((mustOdd && height % 2 == 0) || height < 1 || height > 49);
        return height;
    }

    // Define your shape printing methods here


//prints a square
	public static void printSquare(int squareSide, char squareInput) {
		for (int row = 0; row < squareSide; row++) {
			for (int col = 0; col < squareSide; col++) {
				System.out.print(squareInput + " ");
			}
			System.out.println();
		}
	}
	
	
	//prints the triangle, making column change based on row
	public static void printTriangle(int height, char triangleInput) {
		for(int row = 0; row <= height; row++) {
			for(int col = 0; col < row; col++) {
				System.out.print(triangleInput + " ");
			}
			System.out.println();
		}
	}

	
	//prints pyramid, prints spaces first and the following characters with their spaces depending on row
	public static void printPyramid(int height, char pyramidInput) {
		int space = height - 1;
		int midHeight = height - (height - 1);
		
		//prints rows
		for (int row = 0; row < height; row++) {
			
			//prints the spaces in front of the characters
			for (int k = space; k > 0; k--) {
				System.out.print(" ");
				}
			
			//creates the characters with a space between each, the SPACE IS KEY
			for (int j = 0; j < midHeight; j++) {
				System.out.print(pyramidInput + " ");
			}
			//moves to a new line
			System.out.println();
			//1 lesser space new row in front of the characters
			space--;
			//add 1 to midHeight storing the changing height value depending on height increasing a character every rw
			midHeight++;
		}
	}
	
	//prints hour glass, has to be ODD NUMBER!
	public static void printHourglass(int height, char hourglassInput) {
		int spaceCount = 0;
		//mid height stores height and allow us to change it
		int midHeight = height;
		
		//prints rows of upper hour  glass
		for (int row = 0; row < ((height-1)/2)+1; row++) {
			
			//1st part: prints spaces in upper hour glass
			for (int space = 0; space < spaceCount; space++) {
				System.out.print(" ");
			}
			
			//prints the characters depending on mid height, the changing height
			for (int printChar = 0; printChar < midHeight; printChar++) {
				System.out.print(hourglassInput + " ");
			}
			
			System.out.println();
			spaceCount += 2;
			midHeight -= 2;
		}
			
		//2nd part: print the lower hour glass
		//secondPart is the first row of the second part, that is the height minus 1 divided by 2
		int secondRows= ((height - 1)/2);
		int secondChar = 3;
		
		//printing the rows
		for(int printRows = 0; printRows < secondRows; printRows++){
			
			//printing the spaces, making use of SPACECOUNT from ABOVE CODE
			//Doing spaceCount-4 because it +2 proceeded one more time before reacher condition and end loop
			for(int spaces = 0; spaces < spaceCount-4; spaces++) {
				System.out.print(" ");
			}
			
			//printing the characters
			for(int printChars = 0; printChars < secondChar; printChars++) {
				System.out.print(hourglassInput + " ");
			}
			System.out.println();
			secondChar += 2;
			spaceCount -=2;
		}
		System.out.println();
	}
	
	
	//prints parallelogram
		public static void printParallelogram(int height, char parallelogramInput) {
			int spaceCount = 0;
			
			//print rows
			for (int row = 0; row < height; row++) {
				
				//prints the space in front depending on space count we are on
				for (int space = 0; space < spaceCount; space++) {
					System.out.print(" ");
				}
				
				//prints the same number of characters in every row
				for (int printChar = 0; printChar < height; printChar++) {
					System.out.print(parallelogramInput + " ");
				}
				System.out.println();
				spaceCount += 2;
				
			}	
		}


	//prints diamond. has to be ODD NUMBER!
		public static void printDiamond(int height, char diamondInput) {
			
			//printing the diamond with 2 separate shapes
			int topRows = ((height - 1)/2)+1;
			int topSpace = 2*(topRows - 1);
			int topInput = 1;
			
			//prints the top rows
			for (int row = 0; row < topRows; row++) {
				
				//prints the spaces on the top half of diamond
				for (int spacePrint = 0; spacePrint < topSpace; spacePrint ++) {
					System.out.print(" ");
				}
				
				//prints the input 
				for (int inputPrint = 0; inputPrint < topInput; inputPrint++) {
					System.out.print(diamondInput + " ");
				}
				
				//every time the space at the top rows decreases by 2, input increases by 2
				topSpace -=2;
				topInput +=2;
				System.out.println();
			}
			
			//the number of bottom rows is the diamond without the top rows
			int btmRows = height - topRows;
			//the number of spaces start with 2 and inputs start with 2 less than height interestingly
			int btmSpace = 2;
			int btmInput = height - 2;
		
			//printing the bottom rows
			for (int rows = 0; rows < btmRows; rows++) {
				
				//prints the spaces of the diamond 
				for (int spacePrints = 0; spacePrints < btmSpace; spacePrints++) {
					System.out.print(" ");
				}
				
				//prints the user input 
				for (int inputPrints = 0; inputPrints < btmInput; inputPrints++) {
					System.out.print(diamondInput + " ");
				}
				
				//every time the space increase by 2 and input decrease by 2
				btmSpace += 2;
				btmInput -=2;
				
				//go to the next line every time the spaces and input finish printing
				System.out.println();
			}
			
		}
	
	
	//must have odd numbers input
	//this was more difficult because I initially did not realize the space problems just putting "__" and thought it was a input problem
	public static void printBowtie(int height, char bowtieInput) {
	
		//divide the bow-tie into top and bottom rows
		//for each row, print the first character first, then print the spaces, then print the character, the first and last characters are equal, 3 for loops inside the rows loop		
		
		//printing the top rows
		int rows = ((height -1)/2);
		//in every top row, the number of inputs start with 1 on the left and right, and the number of spaces in middle equals the topRows
		int topInput = 1;
		//the pattern for space was a little difficult to find
		int topSpace = (height *2)-3 ;
		for(int printRow = 0; printRow < rows; printRow++) {
			
			//print the inputs on the left
			for (int inputLeft = 0; inputLeft < topInput; inputLeft++){
				System.out.print(bowtieInput + " ");
			}
			
			/*prints the spaces note that 2 spaces are needed because we set the top space /2 as much
			 * I had issues finding the spaces between, because I initially didn't know the spaces between varied by 4 every time
			 * Note that it is top space - 1 because the input in the front already has one space after it 
			*/
			for (int space = 0; space < topSpace-1; space++){
				System.out.print(" ");
			}
			
			//print the inputs on the right, 1 more each time
			for (int inputRight = 0; inputRight < topInput; inputRight++){
				System.out.print(bowtieInput + " ");
			}
			
			System.out.println();
			//in every top row, number of input increase by 2 (sum of left AND right increase), and spaces decrease by 4
			topInput++;
			topSpace -= 4;
		}
		
		//printing the middle row
		for (int middleInput = 0; middleInput < height; middleInput++) {
			System.out.print(bowtieInput + " ");
		}
		
		//print the bottom rows, same number as top rows
		System.out.println();
		//I initially put this inside the for loop for rows and it created some problems
		int btmInput = topInput -1;
		for (int printRows = 0; printRows < rows; printRows++) {
			
			//this time do the same with input on the right and left, except the opposite
			//the input on bottom is top -1 because the top loop stops when it is equal to the limit meaning it is the limit
			
			//print the inputs on the left, 1 less each time
			for (int inputLefts = 0; inputLefts < btmInput; inputLefts++){
				System.out.print(bowtieInput + " ");
			}
			
			//prints the spaces between for bottom rows, note it is adding 3 because we already have 1 space after the input above
			int btmSpace = topSpace +3;
			for (int space = 0; space < btmSpace; space++){
				System.out.print(" ");
			}
			
			//print the inputs on the right, 1 less each time
			for (int inputRights = 0; inputRights < btmInput; inputRights++){
				System.out.print(bowtieInput + " ");
			}
			
			btmInput--;
			topSpace += 4;
			System.out.println();
		}
	}
	
	
	//print the box
	public static void printBox(int height, char boxInput) {
		//first print the top row, then print the middle rows, then print the bottom row
		
		//top row
		for (int input = 0; input < height; input++) {
			System.out.print(boxInput + " ");
		}
		System.out.println();
		
		//middle rowS is height -2, the -2 are the top and the bottom rows
		int middleRows = height - 2 ;
		for (int rows = 0; rows < middleRows; rows++) {
			
			//print 1 character in the beginning and in the end of the row, note to NOT add the space after the character here
			System.out.print(boxInput);
			
			//print the spaces in between, this pattern was tricky to find because i initially thought it varies for odd and even numbers
			int middleSpaces = (height*2) -3;
			for (int spaces = 0; spaces < middleSpaces; spaces++) {
				System.out.print(" ");
			}
			
			//prints the character at the end of the row, and moves to a new line
			System.out.print(boxInput + " ");
			System.out.println();
		}
		
		//bottom row is basically the same as the top row
		for (int input = 0;input < height; input++) {
			System.out.print(boxInput + " ");
		}
		System.out.println();
	}
	
	//prints fish, must have odd number inputs
	public static void printFish(int height, char fishInput) {
		
		//print top rows first, then print the middle, then print the bottom rows
		//the top rows is calculated without the middle row, so the middle row is taken out, and the rest of the rows are evenly shared for top and bottom
		int topbtmRows = (height -1)/2; 
		//I spend some time realizing that these must be put outside the for loop, otherwise after adding 2 everytime it's just going to go back to 1
		//Some interesting patterns
		int topInput = 1;
		int frontSpace = height -1;
		int midSpace = (height*2)-4;
		int topRightInput = 1;
		
		//prints top rows of fish
		for (int row = 0; row < topbtmRows; row++) {
			
			//in every row, print spaces in this pattern:
			for (int printSpace = 0; printSpace < frontSpace; printSpace++) {
				System.out.print(" ");
			}
			
			//in every row, print the input that builds up like a pyramid
			for (int printTop = 0; printTop < topInput; printTop++) {
				System.out.print(fishInput + " ");
			}
			
			//after printing the input, print the spaces again, omit 1 space since it is already there from above code
			for (int printMidspace = 0; printMidspace < midSpace; printMidspace++) {
				System.out.print(" ");
			}
			
			//after printing the spaces in the middle, print the input last 
			for (int printTopRight = 0; printTopRight < topRightInput; printTopRight++) {
				System.out.print(fishInput + " ");
			}
			
			//decrease in front every time by 2 for every row
			frontSpace -= 2;
			//increase the inputs at the top by 2 every time for every row
			topInput += 2;
			//decrease spaces in middle every time by 4
			midSpace -= 4;
			//increase the inputs on the right by 1 every time
			topRightInput++;
			System.out.println();
		}
		
		//prints middle rows of fish, the number of prints in the middle row is always its height plus its height -1, divided by 2 because diamonds have equal sides, and fish tail is basically half of it
		int middleRows = height + (height-1)/2;
		for (int printMid = 0; printMid < middleRows; printMid++) {
			System.out.print(fishInput + " ");
		}
		//do not forget to add a new row after the middle row
		System.out.println();
		
		//prints bottom rows of fish
		//prints bottom rows of fish
		for (int row = 0; row < topbtmRows; row++) {
			
		}
		
		//prints the bottom rows of fish, the same as the top ones but in the opposite direction
		int btmInput = height -2;
		int frontSpaces = 2;
		int midSpaces = 2;
		int btmRightInput = (height-1)/2;
		
		for (int row = 0; row < topbtmRows; row++) {
			
			//first print the spaces in front of the bottom rows using the same techniques
			for (int printSpaces = 0; printSpaces < frontSpaces; printSpaces++) {
				System.out.print(" ");
			}
			
			//print the bottom inputs for the diamond
			for (int printTops = 0; printTops < btmInput; printTops++) {
				System.out.print(fishInput + " ");
			}
			
			//print the spaces in the middle
			for (int printMidspaces = 0; printMidspaces < midSpaces; printMidspaces++) {
				System.out.print(" ");
			}
				
			//the input increases every row instead of decreasing
			for (int printBtmRights = 0; printBtmRights < btmRightInput; printBtmRights++) {
				System.out.print(fishInput + " ");
				}
			
			//for every row increase the spaces in front by 2
			frontSpaces += 2;
			//decrease the input by 2 for every row
			btmInput -= 2;
			//the spaces in the middle increase by 4 for every row
			midSpaces += 4;
			//the input at the end decreases by 1 every row
			btmRightInput--;
			System.out.println();
		}
				
	}
	
} //closes class

