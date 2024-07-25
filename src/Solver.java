public class Solver
{
    public static int numOfQueens = 0;
    public static int numOfAnswers = 0;

    public static String[][] board = {
            {"0" , "0" , "0" , "0" , "0" , "0" , "0" , "0"},
            {"0" , "0" , "0" , "0" , "0" , "0" , "0" , "0"},
            {"0" , "0" , "0" , "0" , "0" , "0" , "0" , "0"},
            {"0" , "0" , "0" , "0" , "0" , "0" , "0" , "0"},
            {"0" , "0" , "0" , "0" , "0" , "0" , "0" , "0"},
            {"0" , "0" , "0" , "0" , "0" , "0" , "0" , "0"},
            {"0" , "0" , "0" , "0" , "0" , "0" , "0" , "0"},
            {"0" , "0" , "0" , "0" , "0" , "0" , "0" , "0"}};
    
    public static boolean isSafe(int row, int column)
    {
        if (board[row][column].equals("Q"))
        {
            return false;
        }
        else
        {
            for (int i = 0 ; i <= 7 ; i++) //checking row and column
            {
                if ((board[row][i].equals("Q")) || (board[i][column].equals("Q")))
                {
                    return false;
                }
            }

            int i = row + column;
            int j = 0;
            if (i > 7)
            {
                j = j + i - 7;
                i = 7;
            }

            while ((i != -1) && (j != 8))
            {
                if (board[i][j].equals("Q"))
                {
                    return false;
                }

                i--;
                j++;
            }

            i = 0;
            j = column - row;

            if (j < 0)
            {
                i = i - j;
                j = 0;
            }

            while ((i != 8) && (j != 8))
            {
                if (board[i][j].equals("Q"))
                {
                    return false;
                }

                i++;
                j++;
            }

            return true;
        }
    }

    public static class LinkedListElement
    {
        private final Object object;

        private LinkedListElement next;

        public LinkedListElement(Object object)
        {
            this.object = object;
            next = null;
        }

        public Object getObject() {
            return object;
        }

        public LinkedListElement getNextItem()
        {
            return next;
        }

        public void setNextItem(LinkedListElement element)
        {
            next = element;
        }
    }

    public static LinkedListElement start;
    public static LinkedListElement end;

    public static String[][] copy(String[][] copyFrom)
    {
        String[][] board = new String[8][8];

        for (int i = 0 ; i <= 7 ; i++)
        {
            for (int j = 0 ; j <= 7 ; j++)
            {
                board[i][j] = copyFrom[i][j];
            }
        }

        return board;
    }
    public static void solver()
    {
        if (numOfQueens == 8)
        {
            // we find an answer.
            LinkedListElement element = new LinkedListElement(copy(board));
            if (numOfAnswers == 0)
            {
                start = element;
                end = element;
            }
            else
            {
                end.setNextItem(element);
                end = end.getNextItem();
            }

            numOfAnswers++;

        }
        else
        {
            Q queen = new Q(numOfQueens);

            for (int i = 1; i <= 8; i++)
            {
                if (isSafe(queen.getRow(), queen.getColumn()))
                {
                    board[queen.getRow()][queen.getColumn()] = "Q";
                    numOfQueens++;

                    solver();

                    board[queen.getRow()][queen.getColumn()] = "0";
                    numOfQueens--;
                    queen.increase();
                }
                else
                {
                    queen.increase();
                }
            }

        }
    }

    public static void printAll()
    {
        LinkedListElement element = start;

        System.out.println("Num of answers: " + numOfAnswers);

        while (element != null)
        {
            String[][] board = (String[][]) element.getObject();

            for (int i = 0 ; i <= 7 ; i++)
            {
                for (int j = 0 ; j <= 7 ; j++)
                {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.out.println();

            element = element.getNextItem();
        }

        System.out.println("Num of answers: " + numOfAnswers);
    }
}
