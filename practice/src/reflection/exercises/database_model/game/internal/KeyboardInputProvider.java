package reflection.exercises.database_model.game.internal;

import java.util.Scanner;

class KeyboardInputProvider implements InputProvider {
    private final Scanner scanner = new Scanner(System.in);
    private final BoardDimensions boardDimensions;

    public KeyboardInputProvider(BoardDimensions boardDimensions) {
        this.boardDimensions = boardDimensions;
    }

    @Override
    public BoardLocation provideNextMove(Board board) {
        int row;
        int column;
        do {
            System.out.println("행과 열은 [0, 1, 2] 중에 하나를 입력해주세요. ex) (0,1), (0,0)");
            System.out.print("Please choose row: ");
            row = scanner.nextInt();
            System.out.print("Please choose column: ");
            column = scanner.nextInt();
        } while (row < 0
                || row >= boardDimensions.getNumberOfRows()
                || column < 0
                || column >= boardDimensions.getNumberOfColumns()
                || !board.isCellEmpty(row, column));
        return new BoardLocation(row, column);
    }
}
