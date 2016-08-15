package org.apache.batik.css.engine.value.svg12;
public class MarginShorthandManager extends org.apache.batik.css.engine.value.AbstractValueFactory implements org.apache.batik.css.engine.value.ShorthandManager {
    public MarginShorthandManager() { super(); }
    public java.lang.String getPropertyName() { return org.apache.batik.util.SVG12CSSConstants.
                                                         CSS_MARGIN_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public void setValues(org.apache.batik.css.engine.CSSEngine eng,
                          org.apache.batik.css.engine.value.ShorthandManager.PropertyHandler ph,
                          org.w3c.css.sac.LexicalUnit lu,
                          boolean imp) throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_INHERIT)
            return;
        org.w3c.css.sac.LexicalUnit[] lus =
          new org.w3c.css.sac.LexicalUnit[4];
        int cnt =
          0;
        while (lu !=
                 null) {
            if (cnt ==
                  4)
                throw createInvalidLexicalUnitDOMException(
                        lu.
                          getLexicalUnitType(
                            ));
            lus[cnt++] =
              lu;
            lu =
              lu.
                getNextLexicalUnit(
                  );
        }
        switch (cnt) {
            case 1:
                lus[3] =
                  (lus[2] =
                     (lus[1] =
                        lus[0]));
                break;
            case 2:
                lus[2] =
                  lus[0];
                lus[3] =
                  lus[1];
                break;
            case 3:
                lus[3] =
                  lus[1];
                break;
            default:
        }
        ph.
          property(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_MARGIN_TOP_PROPERTY,
            lus[0],
            imp);
        ph.
          property(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_MARGIN_RIGHT_PROPERTY,
            lus[1],
            imp);
        ph.
          property(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_MARGIN_BOTTOM_PROPERTY,
            lus[2],
            imp);
        ph.
          property(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_MARGIN_LEFT_PROPERTY,
            lus[3],
            imp);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XwzWy5FqsV65Z6K0oDHNZCPoo6Yoy11lkXhUp7/aDHDZWhP1uBcbFa9YrojV" +
       "gU2j4dQ0EaOnJNhk4kmsUpCGw446NWPY59dwUOsWMA5xJI6vsY6k6/a6z/AY" +
       "2Zz5sR7REiqipjxroHplo5Xq9UVnnsQYZceTXl8WyiiDJ824p3TxjlsYrtZd" +
       "p4JW1DVfwjyZLahDTOmPKDJNWa6dOBHf7+F8GIWo1Ywpu7EmWoE0N7VGUKZk" +
       "xepYwoyNZrAdiavForoma2HElppaYnbMzZzhZXaxRvDZYLqpFOsbsUkaTT12" +
       "xFLNJcXJBC9wqEMzrEZgXrteY4rjaWXVHmhOrdmhqpSApYQokcUGMdJRsZV2" +
       "C06HXqAlE6HiUsBL8KYGrwQvwGnOn6zX/RmC1eu9KJ6UCqI6qyNxx1dKga3L" +
       "LEKTzQXaqLMrxBabtBmN4xlcRhJ5NSwKo2rHaHa6YqUTNRJmY09ms/507NSR" +
       "pACvWTPuFCbLoAcL1Mjv18ddXaSGk4BcidzQKE8WRb5esrtsqdoaoszQGg17" +
       "0w3exK2aCLM6ImzcaeqhGLyi1yjwcDjwYyYqG6Gc0HKryNoVukw6tTFvkcWK" +
       "VUPldEkkA5njg3nf0VCMGjZKa4oUEG5ARSvLFDG0WzeRUonzhpP1gDbGiGsZ" +
       "cAHzCusmBtfrgWAUJHsiwe4EANGsancqjWDBcCnTcg2vOKwvUayIwqgmK4aK" +
       "1MQmLku10BoVWrDFtYgk6omxDFMUtihEXR5ey05LLmodqlLx6+QAK4X4JqiX" +
       "Yd70FHLpaVSMCRaD1jiypCYyZTfdvjQtCoksiSOVSSWHLRdZrV0zykV0UnW7" +
       "NZy0rTjaeOOmAyDCZJCk3nGVgSZhTocSy0VRZrQlztb4GV3HCLbX0UuNDq3P" +
       "NmYYwqmJoXCRFzduMZxiQwJlCnOj3PXQKPLMeQ1BdBA3baRetx+S80aVbwrM" +
       "nBY92fVSsyuxSEDR6GbYns15YcQUKUnWyPI8VOzBvNjpeiNmMUTT0mAtMT1N" +
       "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");
}
