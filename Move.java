public class Move {
    public int row;
    public int amount;

    public Move(int row, int amount) {
        this.row = row;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Move{" +
                "row=" + row +
                ", amount=" + amount +
                '}';
    }
}