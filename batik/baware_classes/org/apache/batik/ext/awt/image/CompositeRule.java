package org.apache.batik.ext.awt.image;
public final class CompositeRule implements java.io.Serializable {
    public static final int RULE_OVER = 1;
    public static final int RULE_IN = 2;
    public static final int RULE_OUT = 3;
    public static final int RULE_ATOP = 4;
    public static final int RULE_XOR = 5;
    public static final int RULE_ARITHMETIC = 6;
    public static final int RULE_MULTIPLY = 7;
    public static final int RULE_SCREEN = 8;
    public static final int RULE_DARKEN = 9;
    public static final int RULE_LIGHTEN = 10;
    public static final org.apache.batik.ext.awt.image.CompositeRule OVER =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_OVER);
    public static final org.apache.batik.ext.awt.image.CompositeRule IN =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_IN);
    public static final org.apache.batik.ext.awt.image.CompositeRule OUT =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_OUT);
    public static final org.apache.batik.ext.awt.image.CompositeRule ATOP =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_ATOP);
    public static final org.apache.batik.ext.awt.image.CompositeRule XOR =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_XOR);
    public static org.apache.batik.ext.awt.image.CompositeRule ARITHMETIC(float k1,
                                                                          float k2,
                                                                          float k3,
                                                                          float k4) {
        return new org.apache.batik.ext.awt.image.CompositeRule(
          k1,
          k2,
          k3,
          k4);
    }
    public static final org.apache.batik.ext.awt.image.CompositeRule
      MULTIPLY =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_MULTIPLY);
    public static final org.apache.batik.ext.awt.image.CompositeRule
      SCREEN =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_SCREEN);
    public static final org.apache.batik.ext.awt.image.CompositeRule
      DARKEN =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_DARKEN);
    public static final org.apache.batik.ext.awt.image.CompositeRule
      LIGHTEN =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_LIGHTEN);
    public int getRule() { return rule; }
    private int rule;
    private float k1;
    private float k2;
    private float k3;
    private float k4;
    private CompositeRule(int rule) { super(
                                        );
                                      this.
                                        rule =
                                        rule;
    }
    private CompositeRule(float k1, float k2,
                          float k3,
                          float k4) { super(
                                        );
                                      rule =
                                        RULE_ARITHMETIC;
                                      this.
                                        k1 =
                                        k1;
                                      this.
                                        k2 =
                                        k2;
                                      this.
                                        k3 =
                                        k3;
                                      this.
                                        k4 =
                                        k4;
    }
    public float[] getCoefficients() { if (rule !=
                                             RULE_ARITHMETIC)
                                           return null;
                                       return new float[] { k1,
                                       k2,
                                       k3,
                                       k4 };
    }
    private java.lang.Object readResolve()
          throws java.io.ObjectStreamException {
        switch (rule) {
            case RULE_OVER:
                return OVER;
            case RULE_IN:
                return IN;
            case RULE_OUT:
                return OUT;
            case RULE_ATOP:
                return ATOP;
            case RULE_XOR:
                return XOR;
            case RULE_ARITHMETIC:
                return this;
            case RULE_MULTIPLY:
                return MULTIPLY;
            case RULE_SCREEN:
                return SCREEN;
            case RULE_DARKEN:
                return DARKEN;
            case RULE_LIGHTEN:
                return LIGHTEN;
            default:
                throw new java.lang.Error(
                  "Unknown Composite Rule type");
        }
    }
    public java.lang.String toString() { switch (rule) {
                                             case RULE_OVER:
                                                 return "[CompositeRule: OVER]";
                                             case RULE_IN:
                                                 return "[CompositeRule: IN]";
                                             case RULE_OUT:
                                                 return "[CompositeRule: OUT]";
                                             case RULE_ATOP:
                                                 return "[CompositeRule: ATOP]";
                                             case RULE_XOR:
                                                 return "[CompositeRule: XOR]";
                                             case RULE_ARITHMETIC:
                                                 return "[CompositeRule: ARITHMATIC k1:" +
                                                 k1 +
                                                 " k2: " +
                                                 k2 +
                                                 " k3: " +
                                                 k3 +
                                                 " k4: " +
                                                 k4 +
                                                 ']';
                                             case RULE_MULTIPLY:
                                                 return "[CompositeRule: MULTIPLY]";
                                             case RULE_SCREEN:
                                                 return "[CompositeRule: SCREEN]";
                                             case RULE_DARKEN:
                                                 return "[CompositeRule: DARKEN]";
                                             case RULE_LIGHTEN:
                                                 return "[CompositeRule: LIGHTEN]";
                                             default:
                                                 throw new java.lang.Error(
                                                   "Unknown Composite Rule type");
                                         }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+C9MhjnCHzIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9pLFtAolVCaN/iw0x3RLbKqaa2JLpddr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
