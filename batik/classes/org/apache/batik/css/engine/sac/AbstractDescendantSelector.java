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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "WnvwIdNJRsvt9JYmWcpndeBGzc/tAh1JjfFNG//BzBfWnjp+lTusZs4xx9ox" +
       "SCMegObHAwcjTr/z6V+c+ubRUbPAWJYfGH18s/7ZK8f2/fYfWSbnkJij+PHx" +
       "D4TPPN3Y/sCHnN/BJuRuSWenPsB3h/fu08m/BZtLXw+SsgFSJ1rl+DZBTmHE" +
       "D0AJatg1OpTsnnFvOWnWTq0Z7J3rx0XXsn5UdFIuvCM1vlfnA8KlFkAs9QNh" +
       "gPCXbs6yFJsV2fCSjxvOT/yAB65mRxb232eiK7ZrsekxPeLBvA64wSvwSuux" +
       "33MJvKWgwPm4GakxPECAvZ/xibu1gLjm0FLeLsfmLtPNGZzCUjE4zDJSLljV" +
       "jYPT/FNr15D2txun3RFjQVizH8KyqyWbdNVkBVdHmgEnHsws/IOwnJfvSMGP" +
       "Qyf2HT4e7z252ozLBm+Z3gGn0LO//Pfl0LEP3sxR/1UwVbtLpiNUdulVjEt6" +
       "kKCbn7acsHq/5tDvftgyuO5OqjTsa5qkDsPf80GJ5fnBxS/KG/v+1LjlgaFd" +
       "d1BwzfeZ0z/l97rPvLlhiXgoyI+WZrxnHUm9TK3eKK/UKZyhlS2eWF+UcbKp" +
       "6FOz4Wm1nKw1d9GT04ED+LrDV1lUFpjMlzsDVjluOWQdTxiIcSET4/jarEDC" +
       "5Q0cF0vpHth2w1vXoxf0pyCs+nQpCSXXiHWCvbtvlzjR0vd700ln52Aw6aY/" +
       "G/76tnd3X+bbWY7+kzGiy3fAz1zVZJ1pi4/hE4DnP/igtNiB34Dk7dZxdEHm" +
       "PIrJr2AW8ykQ3ttwbfjp62dNBfwpy0dMJw5/7ePQgcNmxJmXGouy7hXcPObF" +
       "hqkONntRuoWFVuEcnX84v/elZ/fuD1p7k2CkLKaqMhWUrA2HEtprdlPW9V+t" +
       "fflgQ1EnxHIXKU8p0p4U7Yp7/bnMSMVc++DcgzjebUmNNmcksNyuLThMq5Nl" +
       "lcJlDXZ0aLx/d8btEaPJPHg6LbfvLBBD2OzJjph8rAWc/8kCY0ewOQCJa5Cy" +
       "fo2KUHKLEhvjtOPWpuLXo673JxgpkqwLQtdm4c8JlwW/8QlYkKc7rBN6LTP0" +
       "3rkF87EWsNLJAmOnsPkOI1PBgm25yhXHIt/9BCzSiGMr4HnYUuvhO7dIPtYC" +
       "Wj9fYOwFbM4yUo8+lV0POfY497+wR5qRxvw3Pni+mJV1B23em4rnjteWzzy+" +
       "9V1eEmTuNqsAxBMpWXZXwK73Uk2nCYkrWmXWwxr/ehkS7iSFEsQNtFyRl0ym" +
       "HzEypwATJiz+4ub5CSPTcvHA7NC6KV+HVOmnZKSEf7vpLjJS6dDBouaLm+QS" +
       "zA4k+HpZy5+HA66SjLiwYPpkO51hcd9hYH7jfzPYCSBl/tEQFc8f39TzyM37" +
       "Tpp3KKIsjHOwmgKwb17nZAqnhXlns+cq3bjsds1zFYvtfFRvCuyEzRyXb3cA" +
       "0GnoVI2+2wWjJXPJ8N6Jta/+bKL0bcik20lAAGjYnn0qS2spqFi3R7LTGxSZ" +
       "/Nqjddm3xx5YmfjLb/i5l5jpcG5++qh45dSOdw7NOtEUJFO6SAmkWprmx8X1" +
       "Y8pmKo7oA6RaMjrSICLMIgmyJ3fWoP8L+AcEt4tlzupML97AwbEhuyLIvres" +
       "lNVRqq9TU0rcyr5TnB7P/x9WTFWmNM3H4PS4qqb9ZhbC3QB/jEa6Nc0umEpv" +
       "aRwQJnKnJWyv8VdsPvgv74tPnIIcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/wXk2NmLBCcAAA==");
}
