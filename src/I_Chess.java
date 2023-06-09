public interface I_Chess {
    public void checkPromotion(Square destinationSquare);
    public boolean isUnderAttack();
    public boolean isCheckMate();
    public boolean isDraw();
    public boolean isCastling();
}
