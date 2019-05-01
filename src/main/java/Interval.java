class Interval {
    int low;
    int high;

    Interval(int low, int high) {
        this.low = low;
        this.high = high;
    }

    boolean overlapsWith(Interval i) {
        return this.low <= i.high && i.low <= this.high;
    }

    @Override
    public String toString() {
        return String.format("low: %d high: %d", this.low, this.high);
    }

}
