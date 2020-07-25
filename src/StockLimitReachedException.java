public class StockLimitReachedException extends Exception {
    public StockLimitReachedException(String errorMessage) {
        super(errorMessage);
    }
}