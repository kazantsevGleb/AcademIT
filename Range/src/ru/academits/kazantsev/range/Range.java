package ru.academits.kazantsev.range;

import java.util.Locale;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom (double from) {
        this.from = from;
    }

    public double getTo () {
        return to;
    }

    public void setTo (double to) {
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
        return String.format(Locale.US, "(%.1f; %.1f)", this.from, this.to);
    }

    public Range getIntersection(Range range) {
        Range intersectionRange;

        if (this.from >= range.to || this.to <= range.from) {
            intersectionRange = null;
        } else {
            intersectionRange = new Range(Math.max(this.from, range.from), Math.min(this.to, range.to));
        }

        return intersectionRange;
    }

    public Range[] getUnion(Range range) {
        Range[] unionRange;

        if (this.from > range.to) {
            unionRange = new Range[] {
                    new Range(range.from, range.to),
                    new Range(this.from, this.to)
            };
        } else if (this.to < range.from) {
            unionRange = new Range[] {
                    new Range(this.from, this.to),
                    new Range(range.from, range.to)
            };
        } else {
            unionRange = new Range[] {
                    new Range(Math.min(this.from, range.from), Math.max(this.to, range.to))
            };
        }
        return unionRange;
    }

    public Range[] getDifference(Range range) {
        Range[] differenceRange;
        if (this.from >= range.to || this.to <= range.from) {
            differenceRange = new Range[] {
                new Range(this.from, this.to)
            };
        } else {
            if (range.from < this.from && range.to <= this.to) {
                differenceRange = new Range[] {
                        new Range(range.from, this.from)
                };
            } else if (this.from <= range.from && this.to < range.to) {
                differenceRange = new Range[] {
                        new Range(this.from, range.from)
                };
            } else if (this.from < range.from && range.to < this.to) {
                differenceRange = new Range[] {
                        new Range(this.from, range.from),
                        new Range(range.to, this.to)
                };
            } else {
                return new Range[0];
            }
        }
        return differenceRange;
    }
}
