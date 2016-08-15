package org.apache.batik.css.engine.value.svg;
public class FillRuleManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_EVENODD_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          EVENODD_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NONZERO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          NONZERO_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FILL_RULE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NONZERO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public FillRuleManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL0Za4xU1fnMLOyLhV0WFpDHAssC4eGMgJTqUuqysLI4CxsW" +
                                                              "CV2U4cydMzsX7tx7uffM7iyWqqQttKkEERGNkv7AYCkKMTV9WC3GtEq1piot" +
                                                              "WiP2YSKVkkqa2qa00u879965j9mZdZPSSe6ZO+d83/nej3Pm5GUy0jRII1N5" +
                                                              "hA/ozIysVnkXNUyWbFOoaW6Eubj0SBn929aL624Jk/IeMiZNzU6JmqxdZkrS" +
                                                              "7CHTZNXkVJWYuY6xJGJ0GcxkRh/lsqb2kAbZ7MjoiizJvFNLMgTYRI0YGUs5" +
                                                              "N+RElrMOewNOpsWAk6jgJNoaXG6JkRpJ0wdc8Eke8DbPCkJmXFomJ3Wx7bSP" +
                                                              "RrNcVqIx2eQtOYMs0DVloFfReITleGS7stRWwdrY0gIVNJ2u/fTqgXSdUME4" +
                                                              "qqoaF+KZG5ipKX0sGSO17uxqhWXMneRrpCxGRnmAOWmOOUSjQDQKRB1pXSjg" +
                                                              "fjRTs5k2TYjDnZ3KdQkZ4mSmfxOdGjRjb9MleIYdKrktu0AGaWfkpbWkLBDx" +
                                                              "4QXRQ49srXu2jNT2kFpZ7UZ2JGCCA5EeUCjLJJhhtiaTLNlDxqpg7G5myFSR" +
                                                              "d9mWrjflXpXyLJjfUQtOZnVmCJqursCOIJuRlbhm5MVLCYeyf41MKbQXZJ3g" +
                                                              "ympJ2I7zIGC1DIwZKQp+Z6OM2CGrSU6mBzHyMjbfAQCAWpFhPK3lSY1QKUyQ" +
                                                              "estFFKr2RrvB9dReAB2pgQManEwuuinqWqfSDtrL4uiRAbguawmgqoQiEIWT" +
                                                              "hiCY2AmsNDlgJY99Lq9bvv8edY0aJiHgOckkBfkfBUiNAaQNLMUMBnFgIdbM" +
                                                              "jx2mE17YFyYEgBsCwBbMD7965baFjWdetWCmDAKzPrGdSTwuHUuMeXNq27xb" +
                                                              "ypCNSl0zZTS+T3IRZV32SktOhwwzIb8jLkacxTMbfvGV+06wS2FS3UHKJU3J" +
                                                              "ZsCPxkpaRpcVZtzOVGZQzpIdpIqpyTax3kEq4D0mq8yaXZ9KmYx3kBGKmCrX" +
                                                              "xG9QUQq2QBVVw7uspjTnXac8Ld5zOiGkAh5SA08TsT7im5N0NK1lWJRKVJVV" +
                                                              "LdplaCi/GYWMkwDdpqMJ8PodUVPLGuCCUc3ojVLwgzSzFyQTYXuBp2gfVbIs" +
                                                              "avb1RttlRdmQVVgnVcEpjAh6nP5/pJVDucf1h0JgkqnBhKBALK3RlCQz4tKh" +
                                                              "7MrVV56Jv2Y5GwaIrTFOlgL5iEU+IshHgHzEIh8R5CNAPhIgT0IhQXU8smE5" +
                                                              "AZhwByQDyMY187rvXrttX1MZeJ/ePwL0j6BNvqrU5mYMJ83HpVP1o3fNvLDo" +
                                                              "5TAZESP1VOJZqmCRaTV6IX1JO+wIr0lAvXLLxgxP2cB6Z2gSS0LWKlY+7F0q" +
                                                              "tT5m4Dwn4z07OEUNwzdavKQMyj85c6T//k333hQmYX+lQJIjIckhehfm93we" +
                                                              "bw5miMH2rd178dNTh3drbq7wlR6nYhZgogxNQb8IqicuzZ9Bn4u/sLtZqL0K" +
                                                              "cjmnYHxIk41BGr5U1OKkdZSlEgROaUaGKrjk6Liapw2t350RDjsWhwbLd9GF" +
                                                              "AgyKivClbv2Jd9748xKhSad41HqqfjfjLZ6EhZvVi9Q01vXIjQZjAPf+ka6H" +
                                                              "Hr68d4twR4CYNRjBZhzbIFGBdUCD33h157sfXDh2Luy6MIeKnU1A45MTsoy/" +
                                                              "Bp8QPJ/hg0kGJ6xkU99mZ7wZ+ZSnI+U5Lm+Q/BRICugczXeq4IZySqYJhWH8" +
                                                              "/Lt29qLn/rK/zjK3AjOOtywcegN3/oaV5L7Xtv6jUWwTkrD4uvpzwayMPs7d" +
                                                              "udUw6ADykbv/rWmPvkKfgNoA+diUdzGRYonQBxEGXCp0cZMYbw6sLcNhtun1" +
                                                              "cX8YeZqkuHTg3CejN33y4hXBrb/L8tq9k+otlhdZVgBiy4g9+FI+rk7QcZyY" +
                                                              "Ax4mBhPVGmqmYbObz6y7q045cxXI9gBZCRKyud6ApJnzuZINPbLidy+9PGHb" +
                                                              "m2Uk3E6qFY0m26kIOFIFns7MNOTbnP7l2yw++ithqBP6IAUaKphAK0wf3L6r" +
                                                              "MzoXFtn1o4k/WH786AXhlrq1x5R8hp3qy7CioXeD/MTby35z/MHD/VZLMK94" +
                                                              "ZgvgTfrXeiWx54//LLCLyGmDtCsB/J7oyccnt624JPDd5ILYzbnCsgUJ2sVd" +
                                                              "fCLz93BT+c/DpKKH1El2A70JixLEdQ80jabTVUOT7Vv3N4BWt9OST55Tg4nN" +
                                                              "QzaY1txyCe8Ije+jAz44BU24Ap65tg/ODfpgiIiXtQJljhjn4bBQmK+Mkyrd" +
                                                              "0DhwyaDpLTdFt86BE1mlSi5PR7jK5BJ0AFcUbVOgTOJkwdD13WqPwb2tlIzj" +
                                                              "F3G4w6K7fDB/zg0uRwhfb3T5FZ/yErHpcWGCcTqtWMcsuv1jew4dTa5/cpHl" +
                                                              "xPX+LnQ1HLKe/u1/Xo8c+f3ZQRqdKq7pNyqsjykemhVI0hc2neIw4frg+2MO" +
                                                              "/unHzb0rh9OT4FzjEF0H/p4OQswvHolBVl7Z8/HkjSvS24bRXkwPqDO45fc6" +
                                                              "T569fY50MCxOTlZwFJy4/Egt/pCoNhgcEdWNvsCYlXeAcWjYOfAssR1gSTAw" +
                                                              "XKebg8Nmv69Xl0AtUXvkEmvCZBBk42SzQ03DmRdCDroicaz196lo5+5swoSe" +
                                                              "Us5An9FnH8EWd22T9jV3fWi54Q2DIFhwDU9FH9h0fvvrwmCV6CF5NXm8AzzJ" +
                                                              "0x3V4RDBUCiRowP8RHfXf7Dj8YtPW/wEE3IAmO079O1rkf2HrBCxDtmzCs65" +
                                                              "XhzroB3gbmYpKgKj/aNTu59/avfesK33uzipSGiawqiat0soX7zG+7Vo8brq" +
                                                              "W7U/PVBf1g7B10Eqs6q8M8s6kn4HrDCzCY9a3XO5644219igcRKa71ROkeRY" +
                                                              "iST3OYo2TqzUxfw2v9NjZr7V9txbh+/0xVBLOPbXS6x9E4d74agjm62qnKEc" +
                                                              "e0XH63FNc1Vy3/VSyWx4Wm25WoevkmKoJcR+sMTaQzh8BxoFGW/BhO8WUcgD" +
                                                              "10EhtbjWCM8aW6o1w1dIMdQSQh8tsfZdHB6FfruXcUcT+bNbxo58/NI975yT" +
                                                              "Mtm+1fRENP4c8ITZY9dBhfW4NhOeLlsPXcNXYTHUEmo6XWLtWRy+71fhOshV" +
                                                              "TjdWJxp87EntrsvV0MnroKGxuDYDns22mJuHr6FiqCW08LMSay/h8BNLQ6tY" +
                                                              "imYVq2F3NDR36H7VhReKe/46KK4B12bBE7eljw9fccVQSyjnjRJrv8bhLCdj" +
                                                              "QHEdSaiWcOBnVl/Z7Srjl/8LZeTAPIELPzydTir4z8G6J5eeOVpbOfHonedF" +
                                                              "j5y/y66BnieVVRTv+cnzXq4bLCUL0Wqs05Quvt7hZPbnupOExAOjkOG8hfoe" +
                                                              "JzOHRIVDVV/egWzEC5xMKYEIhyrrxYvzByimg+EAWzB6IT+EuA9CAhfi2wv3" +
                                                              "ESfVLhwQtV68IB/D7gCCr5d0J2SWDK0u12Fse+ZC/pNX3oEahnIgz2Ftlq9D" +
                                                              "FX9cOS1c1vrrKi6dOrp23T1XvvCkdZMnKXTXLtxlFDRu1n1h/qwys+huzl7l" +
                                                              "a+ZdHXO6arbTUfpuEr28CTeGKiRu3SYHrrbM5vwN17vHlr/4q33lb0EvvIWE" +
                                                              "KJwJthTeGuT0LBwSt8QKG1Q414k7t5Z5jw2sWJj663viXoYU3MYE4ePSueN3" +
                                                              "v31w0rHGMBnVQUZCs8xy4jpj1YC6gUl9Rg8ZLZurc8Ai2o0qvu53DEYYxeoh" +
                                                              "9GKrc3R+Fq94OWkq7OkLL8arFa2fGSu1rJrEbaB/HuXOOGdW33Evq+sBBHfG" +
                                                              "c4zJWS0CWgNcNh7r1HXnfnTEYl3kmYHBewYcPxOvOFz7L0aNsmTUHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
