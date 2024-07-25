public class Q
{
    private int row;

    private int column;

    public Q(int columnNumber)
    {
        row = 0;
        column = columnNumber;
    }

    public void increase()
    {
        if ((row == 7) && (column == 7))
        {
            row = -1;
            column = -1;
        }
        else if (row == 7)
        {
            row = 0;
            column++;
        }
        else
        {
            row++;
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
