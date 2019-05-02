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

    @Override
    public boolean equals(Object i) {
        if (i == null) {
            return false;
        }
        if (this == i) {
            return true;
        }
        return (i instanceof Interval) && (((Interval) i).low == this.low && ((Interval) i).high == this.high);
    }

    @Override
    public int hashCode() {
        return (this.high % 11 + this.low % 11) % 11;
    }
}
