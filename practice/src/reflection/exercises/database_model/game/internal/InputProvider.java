package reflection.exercises.database_model.game.internal;

interface InputProvider {
    BoardLocation provideNextMove(Board board);
}
