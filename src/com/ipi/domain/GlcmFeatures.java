package com.ipi.domain;

public class GlcmFeatures {

    private GlcmMatrix zeroDegree;

    private GlcmMatrix fortyFiveDegree;

    private GlcmMatrix ninetyDegree;

    private GlcmMatrix oneHundredThirtyFiveDegre;

    int length;

    int d;

    public GlcmMatrix getZeroDegree() {
        return zeroDegree;
    }

    public void setZeroDegree(GlcmMatrix zeroDegree) {
        this.zeroDegree = zeroDegree;
    }

    public GlcmMatrix getFortyFiveDegree() {
        return fortyFiveDegree;
    }

    public void setFortyFiveDegree(GlcmMatrix fortyFiveDegree) {
        this.fortyFiveDegree = fortyFiveDegree;
    }

    public GlcmMatrix getNinetyDegree() {
        return ninetyDegree;
    }

    public void setNinetyDegree(GlcmMatrix ninetyDegree) {
        this.ninetyDegree = ninetyDegree;
    }

    public GlcmMatrix getOneHundredThirtyFiveDegre() {
        return oneHundredThirtyFiveDegre;
    }

    public void setOneHundredThirtyFiveDegre(GlcmMatrix oneHundredThirtyFiveDegre) {
        this.oneHundredThirtyFiveDegre = oneHundredThirtyFiveDegre;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public GlcmFeatures(int d, int length) {
        this.length = length;
        this.d = d;
        this.zeroDegree = new GlcmMatrix(d, 0, length);
        this.fortyFiveDegree = new GlcmMatrix(d, 45, length);
        this.ninetyDegree = new GlcmMatrix(d, 90, length);
        this.oneHundredThirtyFiveDegre = new GlcmMatrix(d, 135, length);

        this.zeroDegree.initializeElements();
        this.fortyFiveDegree.initializeElements();
        this.ninetyDegree.initializeElements();
        this.oneHundredThirtyFiveDegre.initializeElements();

    }
}
