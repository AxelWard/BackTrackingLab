public class Driver {

    private static int[] square;

    public static void main(String[] args) {
        int[] used = new int[25];
        square = new int[25];

        magicSquare(0, used);
    }

    public static void magicSquare(int position, int[] used) {

        for(int i = 1; i < 25; i++) {
            System.out.println("Running: " + position + ", " + i);
            if(!used(i, used)) {

                square[position] = i;
                used[position] = i;

                boolean isValid = true;

                if(position == 4 || position == 9 || position == 14 || position == 19 || position == 24) {
                    if (!valid(position)) {
                        isValid = false;
                    }
                }

                if(isValid) {
                    if (position == 24) {
                        print();
                    } else {
                        magicSquare(position + 1, used);
                    }
                }
            }

            square[position] = 0;
            used[position] = 0;
        }
    }

    public static boolean used(int number, int[] usedArray) {
        for(int i = 0; i < 25; i++) {
            if(number == usedArray[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean valid(int startPos) {
        int total = 0;

        for(int i = startPos - 4; i < (startPos + 1); i++) {
            total += square[i];
        }

        System.out.println(" - Total: " + total);

        if(total == 65) {
            return true;
        }
        return false;
    }

    public static void print() {
        int pos = 0;
        System.out.println("---------------------");
        for(int x = 0; x < 5; x++) {
            System.out.print("| ");
            for(int y = 0; y < 5; y++) {
                System.out.print(square[pos] + " | ");
                pos++;
            }
            System.out.println("\n---------------------");
        }
    }
}
