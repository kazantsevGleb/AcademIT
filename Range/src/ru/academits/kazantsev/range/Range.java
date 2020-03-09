package ru.academits.kazantsev.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    @Override
    public String toString() {
        return String.format("%.1f, %.1f", this.from, this.to);
    }

    public Range getIntersectionRanges(Range range) {
        if (this.from >= range.to || this.to <= range.from) {
            return null;
        } else {
            if (this.from > range.from && this.to > range.to) {
                return new Range(this.from, range.to);
            } else if (range.from > this.from && this.to > range.to) {
                return new Range(range.from, range.to);
            } else if (range.from < this.from && this.to < range.to) {
                return new Range(this.from, this.to);
            } else {
                return new Range(range.from, this.to);
            }
        }
    }

    public Range[] getAdditionRanges(Range range) {
        Range[] additionRange = new Range[2];

        if (this.from > range.to) {
            additionRange[0] = new Range(range.from, range.to);
            additionRange[1] = new Range(this.from, this.to);
            return additionRange;
        } else if (this.to < range.from) {
            additionRange[0] = new Range(this.from, this.to);
            additionRange[1] = new Range(range.from, range.to);
            return additionRange;
        } else {
            additionRange = new Range[1];
            additionRange[0] = new Range(Math.min(this.from, range.from), Math.max(this.to, range.to));
            return additionRange;
        }
    }

    public Range[] getSubtractionRanges(Range range) {
        Range[] subtractionRange = new Range[1];

        if (this.from >= range.to || this.to <= range.from) {
            subtractionRange[0] = new Range(this.from, this.to);
            return subtractionRange;
        } else {
            if (range.from < this.from && range.to <= this.to) {
                subtractionRange[0] = new Range(range.from, this.from);
                return subtractionRange;
            } else if (this.from <= range.from && this.to < range.to) {
                subtractionRange[0] = new Range(this.to, range.to);
                return subtractionRange;
            } else if (this.from < range.from && range.to < this.to) {
                subtractionRange = new Range[2];
                subtractionRange[0] = new Range(this.from, range.from);
                subtractionRange[1] = new Range(range.to, this.to);
                return subtractionRange;
            } else {
                return new Range[0];
            }
        }
    }
}
