package org.apache.batik.css.engine.sac;
public abstract class AbstractDescendantSelector implements org.w3c.css.sac.DescendantSelector, org.apache.batik.css.engine.sac.ExtendedSelector {
    protected org.w3c.css.sac.Selector ancestorSelector;
    protected org.w3c.css.sac.SimpleSelector simpleSelector;
    protected AbstractDescendantSelector(org.w3c.css.sac.Selector ancestor,
                                         org.w3c.css.sac.SimpleSelector simple) {
        super(
          );
        ancestorSelector =
          ancestor;
        simpleSelector =
          simple;
    }
    public boolean equals(java.lang.Object obj) { if (obj == null ||
                                                        obj.
                                                        getClass(
                                                          ) !=
                                                        getClass(
                                                          )) { return false;
                                                  }
                                                  org.apache.batik.css.engine.sac.AbstractDescendantSelector s =
                                                    (org.apache.batik.css.engine.sac.AbstractDescendantSelector)
                                                      obj;
                                                  return s.
                                                           simpleSelector.
                                                    equals(
                                                      simpleSelector);
    }
    public int getSpecificity() { return ((org.apache.batik.css.engine.sac.ExtendedSelector)
                                            ancestorSelector).
                                    getSpecificity(
                                      ) +
                                    ((org.apache.batik.css.engine.sac.ExtendedSelector)
                                       simpleSelector).
                                    getSpecificity(
                                      ); }
    public org.w3c.css.sac.Selector getAncestorSelector() {
        return ancestorSelector;
    }
    public org.w3c.css.sac.SimpleSelector getSimpleSelector() {
        return simpleSelector;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ae2BB00nGS2301uaZCmf1YEbNT+3C3QkNcY3bfwHM59fe/rENe6wmjnHHGvH" +
       "II14AJofDxyMOPP2p39x+pvHRs0CY1l+YPTxzfpnrxzb/9t/ZJmcQ2KO4sfH" +
       "PxA++1Rj+7oPOL+DTcjdks5OfYDvDu/dZ5J/CzaXvhYkZQOkTrTK8e2CnMKI" +
       "H4AS1LBrdCjZPePectKsnVoz2DvXj4uuZf2o6KRceEdqfK/OB4RLLYBY6gfC" +
       "AOEv3ZxlKTYrsuElHzecn/gBD1zNjizsv89EV2zXYtNjesQDeR1wo1fgldZj" +
       "v+cSeGtBgfNxM1JjeIAAez/jE3dbAXHNoaW8XY7NXaabMziFpWJwmGWkXLCq" +
       "Gwen+afWriHtbzdOuyPGgrBmP4RlV0s26arJCq6ONANOPJhZ+AdhOS/fkYIf" +
       "h07uP3Ii3ntqtRmXDd4yvQNOoed++e8roePvv5Gj/qtgqnaXTEeo7NKrGJf0" +
       "IEE3P205YfVezeHf/bBlcP2dVGnY1zRJHYa/54MSy/ODi1+U1/f/qXHruqHd" +
       "d1BwzfeZ0z/l97rPvrFxiXg4yI+WZrxnHUm9TK3eKK/UKZyhla2eWF+UcbKp" +
       "6FOz4Wm1nKw1d9GT04ED+LrTV1lUFpjMlzsDVjluOWQdTxiIcSET4/jarEDC" +
       "5Q0cF0vpXth2w1vXoxf0pyCs+nQpCSXXiHWCvbtvtzjR0vd700ln52Aw6aY/" +
       "E/769nf2XOHbWY7+kzGiy3fAz1zVZJ1pi4/hE4DnP/igtNiB34Dk7dZxdEHm" +
       "PIrJr2AW8ykQ3tdwffipG+dMBfwpy0dMJ4587ePQwSNmxJmXGouy7hXcPObF" +
       "hqkONvtQuoWFVuEcnX+4sO/FZ/YdCFp7k2CkLKaqMhWUrA2HEtprdlPWDV+t" +
       "felQQ1EnxHIXKU8p0t4U7Yp7/bnMSMVc++DcgzjebUmNNmcksNyuLThMq5Nl" +
       "lcJlDXZ0aLx/T8btEaPJPHg6LbfvLBBD2OzNjph8rAWc/4kCY0exOQiJa5Cy" +
       "fo2KUHKLEhvjtOPWpuLXI673xxkpkqwLQtdm4c8JlwW/8QlYkKc7rBN6LTP0" +
       "3rkF87EWsNKpAmOnsfkOI1PBgm25yhXHIt/9BCzSiGMr4HnIUuuhO7dIPtYC" +
       "Wj9XYOx5bM4xUo8+lV0POfY4/7+wR5qRxvw3Pni+mJV1B23em4rnT9SWzzyx" +
       "7R1eEmTuNqsAxBMpWXZXwK73Uk2nCYkrWmXWwxr/egkS7iSFEsQNtFyRF02m" +
       "HzEypwATJiz+4ub5CSPTcvHA7NC6KV+DVOmnZKSEf7vpLjFS6dDBouaLm+Qy" +
       "zA4k+HpFy5+HA66SjLiwYPpkO51hcd9hYH7jfzPYCSBl/tEQFS+c2Nzz8K37" +
       "Tpl3KKIsjHOwmgKwb17nZAqnhXlns+cq3bTsds2zFYvtfFRvCuyEzRyXb3cA" +
       "0GnoVI2+2wWjJXPJ8O7Jta/8bKL0LcikO0hAAGjYkX0qS2spqFh3RLLTGxSZ" +
       "/Nqjddm3x9atTPzlN/zcS8x0ODc/fVS8enrn24dnnWwKkildpARSLU3z4+KG" +
       "MWULFUf0AVItGR1pEBFmkQTZkztr0P8F/AOC28UyZ3WmF2/g4NiQXRFk31tW" +
       "yuoo1derKSVuZd8pTo/n/w8rpipTmuZjcHpcVdMBMwvhboA/RiPdmmYXTGUz" +
       "NQ4IE7nTErbX+Ss27/8Xpe+vwYIcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ccnxv32kVBUEJwAA");
}
