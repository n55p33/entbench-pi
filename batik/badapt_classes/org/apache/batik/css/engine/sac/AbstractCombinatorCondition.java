package org.apache.batik.css.engine.sac;
public abstract class AbstractCombinatorCondition implements org.w3c.css.sac.CombinatorCondition, org.apache.batik.css.engine.sac.ExtendedCondition {
    protected org.w3c.css.sac.Condition firstCondition;
    protected org.w3c.css.sac.Condition secondCondition;
    protected AbstractCombinatorCondition(org.w3c.css.sac.Condition c1, org.w3c.css.sac.Condition c2) {
        super(
          );
        firstCondition =
          c1;
        secondCondition =
          c2;
    }
    public boolean equals(java.lang.Object obj) { if (obj == null ||
                                                        obj.
                                                        getClass(
                                                          ) !=
                                                        getClass(
                                                          )) { return false;
                                                  }
                                                  org.apache.batik.css.engine.sac.AbstractCombinatorCondition c =
                                                    (org.apache.batik.css.engine.sac.AbstractCombinatorCondition)
                                                      obj;
                                                  return c.
                                                           firstCondition.
                                                    equals(
                                                      firstCondition) &&
                                                    c.
                                                      secondCondition.
                                                    equals(
                                                      secondCondition);
    }
    public int getSpecificity() { return ((org.apache.batik.css.engine.sac.ExtendedCondition)
                                            getFirstCondition(
                                              )).
                                    getSpecificity(
                                      ) +
                                    ((org.apache.batik.css.engine.sac.ExtendedCondition)
                                       getSecondCondition(
                                         )).
                                    getSpecificity(
                                      ); }
    public org.w3c.css.sac.Condition getFirstCondition() {
        return firstCondition;
    }
    public org.w3c.css.sac.Condition getSecondCondition() {
        return secondCondition;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "sbn2X32uyD9lHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Q9vF/9IB2L3qOBAd6fY4DB2uGLCeUqf1s9dCntfA57G9iHzsOPKcQLIKnrE8" +
       "nJUX0+I120BPq6/di/Afwc8J+PxP+qRy0hfbVf0OYm9r8dDB3sKH69i5iRWE" +
       "0ZXBsIW6tCylRWMrvHpdd3n9lca8Fj65PWNy1zGGu6ExaUnBUAkBnBnjhsq1" +
       "XlK5TFh8AgLiyeJudTcT0Lt29zdF8KixHNsWhKFTYXYKgFwTuHzb+zrdM7P1" +
       "i/tDOYSnAqjXxZld3ceZC1kspq6zu91KH9OX+j/rC2Pt3KEw3oO78vf+w/u+" +
       "+iuPfgsGBIecXKXOCuPgSI+dZXpQeefz77//Zc98+73ZYgDHdPi2V/9rtu17" +
       "03WsTqtSWgzTQt439b7UVDHbc/FaGLUz8AZGZu0NcaAbWA6csNXeLhx98o5v" +
       "zT/0nY9vd9jHg/4YMXj3M+/50e7Tz+wcOdc8etXR4ijP9myTKX3b3ggHyMM3" +
       "6iXjoP/xk0/+4W8/+a6tVndcuUun4CH043/531/dffbbX77G5u9m2/sJJjY6" +
       "9yxTCll8/8MX1Im8luJYnghYbTwpdTvRmp55uLpp5G22LxW8Nd8kN4atOLS1" +
       "0AaNBGBCLh4tq5tcRZ8oWoWUTC5qej1WGfRaLoO2WEuae4TVdzCNCmxiILUG" +
       "w7lPOBVl6De9wB6oNKkttOFiGOWiaogtMYB5gC50xblrLMdARp3VYLJCjcp4" +
       "OWpjImv786bm1Ex8UijP1QrdLzPJsE0v7d6i6S5NvjStgLmViwyjgK1Gubzr" +
       "sy2Hk8YdxrPGwdyfi+3ehOvZ84IwlGx1pWzoeVPoeoKaNCx71BlLPYP1nHoh" +
       "HqmU7UwMj1IUCq/32PkoaC3FJkOV40Ix7qzDGU7NTZHm2nQHWzJFquWIHQbT" +
       "WRWdscv6eiY2bIx2+XKrt4xYIOQdgtjkvTXHLWtd2ekNxwtnhteCpplbczga" +
       "SsZY5SJTk33DNn2Fj/qoIUwXAbXRFHE4HJbybF1PwqQjy1Jfas0LS7hQ0DMd" +
       "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");
}
