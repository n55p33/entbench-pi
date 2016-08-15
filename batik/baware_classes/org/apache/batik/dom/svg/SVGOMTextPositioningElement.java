package org.apache.batik.dom.svg;
public abstract class SVGOMTextPositioningElement extends org.apache.batik.dom.svg.SVGOMTextContentElement implements org.w3c.dom.svg.SVGTextPositioningElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMTextContentElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH_LIST,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH_LIST,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_DX_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH_LIST,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_DY_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH_LIST,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_ROTATE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLengthList
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLengthList
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLengthList
      dx;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLengthList
      dy;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumberList
      rotate;
    protected SVGOMTextPositioningElement() {
        super(
          );
    }
    protected SVGOMTextPositioningElement(java.lang.String prefix,
                                          org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        x =
          createLiveAnimatedLengthList(
            null,
            SVG_X_ATTRIBUTE,
            getDefaultXValue(
              ),
            true,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH);
        y =
          createLiveAnimatedLengthList(
            null,
            SVG_Y_ATTRIBUTE,
            getDefaultYValue(
              ),
            true,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH);
        dx =
          createLiveAnimatedLengthList(
            null,
            SVG_DX_ATTRIBUTE,
            "",
            true,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH);
        dy =
          createLiveAnimatedLengthList(
            null,
            SVG_DY_ATTRIBUTE,
            "",
            true,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH);
        rotate =
          createLiveAnimatedNumberList(
            null,
            SVG_ROTATE_ATTRIBUTE,
            "",
            true);
    }
    public org.w3c.dom.svg.SVGAnimatedLengthList getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedLengthList getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedLengthList getDx() {
        return dx;
    }
    public org.w3c.dom.svg.SVGAnimatedLengthList getDy() {
        return dy;
    }
    public org.w3c.dom.svg.SVGAnimatedNumberList getRotate() {
        return rotate;
    }
    protected java.lang.String getDefaultXValue() {
        return "";
    }
    protected java.lang.String getDefaultYValue() {
        return "";
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Zvj/watwPQ8mAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "W6XJd5v1tEIzpCggypy0S0oitPsExUgBjvQGempi3mw0W5a9nkFhjFGpjXum" +
       "VBEDfC2m9QVjUp7aEMKSgoMMfszz2ybO2EK5TTlbVoi4Vl1t8sm2NGmxxKxc" +
       "48fLJdYJ1FEkKM0qGk4GBFmnPbrUoUVnRU7lkdGG6T4wwYaON6R6j5txlDER" +
       "3LYp2C2jaQPrg0m0tYzDlYzVWNWkt7LDAJnIdobGesB2KDZ0h5nGVi02q9oj" +
       "hE9LymaCdycYtjJS3KlwM6eSVse9ntHw4dgQ+i4vBAQthVqq92oEscLWzWZS" +
       "x5XezKFWK6e2TaZDrNYZy5NOdyJXstJCYvvDgKtiEjXmyky4aNESR1azAMfI" +
       "pYo2HcJO62yzGyWGQ1Ma6cwqg2k59tNRq+TbUqfLS5LRjfipJTlYsxYHtTGu" +
       "bEf4lCvH256AJzaXzMf4agrLPjqobpFm0th2pc42s5fkwsGSMRMk5S2FL1cs" +
       "i4+dJdlsL0TJ8ehu2teqdSGw4lE141oOm/SmNXwbYwnGbDh4k02YVljmpzGK" +
       "TUmaJ8xmxa8jEowGQaVegS2qVIOl6dR3y8vFIkUXpm/VJE4rabLeL6X4xFv2" +
       "eZ0emBqRoXZtpraXlkyzg5bHYZ0EWc01OJVsbIWipWW72+2FCjf3Git1GCGY" +
       "KWxSbLxE6Lij4zZl9+cy2kk3dIMby/ocq67cVF8G5srJtNIcdbRlqIqzljr0" +
       "2YY1kJXUbqvrYSmuJGJSUcqdJOgw4Rz4QGMUkaiowpmNfn0lLjEfWyFxlRNq" +
       "NqpJUlLDGKw1953KoscHA70J9xwYHk6MbtNWY9iYRXod2/gSTFCmQXW6bbq7" +
       "LVUzwpfS5Yifj5ZzpBb74tqpOT5stFnMbHpCZ95fNZnamCVn+Iicbdrd+RaN" +
       "pSTKBMwNvf7EsFihl02bKV2Pxxy7kiq+QY0ajfp6uw4MGO23t9iwXWLs/rTO" +
       "CjQaVucMg/bDcWkw9GMa4WiqvFJaMy7m8QayxSfGqCytjLmUVpeGSW5KsW3R" +
       "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" +
       "Brp/HVvWyWcwJ+KXvEBZ64VCLu8exXgF");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ShQAvNP1eQTdA8Jc9gvlXelKBL3ldqVBSRCeLFkHxnG2JKC84v/Jcs9H0JXj" +
       "chF0aRc5WeQF0Dookkff7x0yymvc+edqLV7PO9GhI3/hhC++N7aCax55rXE7" +
       "qnLydWTuvxdv/w997Xj3+v+m9NWX+8Of+m71V3avMyVL3G7zVu5noPt2D0WP" +
       "/PWn79jaYVuXes9+76GvXX7mcG/x0E7gY8M/IdtTt38H2ba9qHi5uP07b//b" +
       "7/viy39QXPX/PwPord6UMQAA");
}
