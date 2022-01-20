package ru.academits.kazantsev.range;

public class Range {
    private final double FROM;
    private final double TO;

    public Range(double from, double to) {
        this.FROM = from;
        this.TO = to;
    }

    public double getLength() {
        return Math.abs(TO - FROM);
    }

    public boolean isInside(double number) {
        return number >= FROM && number <= TO;
    }

    @Override
    public String toString() {
        return String.format("%.1f, %.1f", this.FROM, this.TO);
    }

    public Range getIntersectionRanges(Range range) {
        if (this.FROM >= range.TO || this.TO <= range.FROM) {
            return null;
        } else {
            if (this.FROM > range.FROM && this.TO > range.TO) {
                return new Range(this.FROM, range.TO);
            } else if (range.FROM > this.FROM && this.TO > range.TO) {
                return new Range(range.FROM, range.TO);
            } else if (range.FROM < this.FROM && this.TO < range.TO) {
                return new Range(this.FROM, this.TO);
            } else {
                return new Range(range.FROM, this.TO);
            }
        }
    }

    public Range[] getAdditionRanges(Range range) {
        Range[] additionRange = new Range[2];

        if (this.FROM > range.TO) {
            additionRange[0] = new Range(range.FROM, range.TO);
            additionRange[1] = new Range(this.FROM, this.TO);
            return additionRange;
        } else if (this.TO < range.FROM) {
            additionRange[0] = new Range(this.FROM, this.TO);
            additionRange[1] = new Range(range.FROM, range.TO);
            return additionRange;
        } else {
            additionRange = new Range[1];
            additionRange[0] = new Range(Math.min(this.FROM, range.FROM), Math.max(this.TO, range.TO));
            return additionRange;
        }
    }

    public Range[] getSubtractionRanges(Range range) {
        Range[] subtractionRange = new Range[1];

        if (this.FROM >= range.TO || this.TO <= range.FROM) {
            subtractionRange[0] = new Range(this.FROM, this.TO);
            return subtractionRange;
        } else {
            if (range.FROM < this.FROM && range.TO <= this.TO) {
                subtractionRange[0] = new Range(range.FROM, this.FROM);
                return subtractionRange;
            } else if (this.FROM <= range.FROM && this.TO < range.TO) {
                subtractionRange[0] = new Range(this.TO, range.TO);
                return subtractionRange;
            } else if (this.FROM < range.FROM && range.TO < this.TO) {
                subtractionRange = new Range[2];
                subtractionRange[0] = new Range(this.FROM, range.FROM);
                subtractionRange[1] = new Range(range.TO, this.TO);
                return subtractionRange;
            } else {
                return new Range[0];
            }
        }
    }
}
