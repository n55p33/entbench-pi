package org.apache.batik.css.engine.sac;
public class CSSIdCondition extends org.apache.batik.css.engine.sac.AbstractAttributeCondition {
    protected java.lang.String namespaceURI;
    protected java.lang.String localName;
    public CSSIdCondition(java.lang.String ns, java.lang.String ln, java.lang.String value) {
        super(
          value);
        namespaceURI =
          ns;
        localName =
          ln;
    }
    public short getConditionType() { return SAC_ID_CONDITION; }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public java.lang.String getLocalName() { return localName; }
    public boolean getSpecified() { return true; }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        return e instanceof org.apache.batik.css.engine.CSSStylableElement
          ? ((org.apache.batik.css.engine.CSSStylableElement)
               e).
          getXMLId(
            ).
          equals(
            getValue(
              ))
          : false;
    }
    public void fillAttributeSet(java.util.Set attrSet) { attrSet.
                                                            add(
                                                              localName);
    }
    public int getSpecificity() { return 1 << 16; }
    public java.lang.String toString() { return '#' + getValue();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZfWwcxRWfO8ff384n+XASxyHKB3eErzYYKIlxiMnFcePE" +
                                                              "Ui+As96bszfe293sztln01CIigitGkEaQlpB+kdDQ2kgtCpqKYW6ouVD0Erh" +
                                                              "o5QiAipUhVIEEQKq0kLfm9nv+7CsNrW0c+uZ997Me/Pe772ZPfEeKbdM0ko1" +
                                                              "FmPjBrViXRrrlUyLpjpVybK2Q9+AfFeZ9OH1b/esi5KKJGkYlqwtsmTRjQpV" +
                                                              "U1aSLFI0i0maTK0eSlPI0WtSi5qjElN0LUlmK1Z3xlAVWWFb9BRFgn7JTJBm" +
                                                              "iTFTGcwy2m0LYGRRAlYS5yuJrw8PdyRInawb4x75PB95p28EKTPeXBYjTYnd" +
                                                              "0qgUzzJFjScUi3XkTLLa0NXxIVVnMZpjsd3qxbYJrklcnGeCtocaP/709uEm" +
                                                              "boKZkqbpjKtnbaOWro7SVII0er1dKs1Ye8iNpCxBan3EjLQnnEnjMGkcJnW0" +
                                                              "9ahg9fVUy2Y6da4OcyRVGDIuiJGlQSGGZEoZW0wvXzNIqGK27pwZtF3iaiu0" +
                                                              "zFPxztXxQ3dd3/STMtKYJI2K1ofLkWERDCZJgkFpZpCa1vpUiqaSpFmDze6j" +
                                                              "piKpyoS90y2WMqRJLAvb75gFO7MGNfmcnq1gH0E3Mysz3XTVS3OHsv8rT6vS" +
                                                              "EOg6x9NVaLgR+0HBGgUWZqYl8DubZcaIoqUYWRzmcHVs3wwEwFqZoWxYd6ea" +
                                                              "oUnQQVqEi6iSNhTvA9fThoC0XAcHNBmZX1Qo2tqQ5BFpiA6gR4boesUQUFVz" +
                                                              "QyALI7PDZFwS7NL80C759ue9nssO3KBt0qIkAmtOUVnF9dcCU2uIaRtNU5NC" +
                                                              "HAjGulWJw9Kcx/ZHCQHi2SFiQfOzr565ck3r5NOCZkEBmq2Du6nMBuRjgw2n" +
                                                              "FnauXFeGy6gydEvBzQ9ozqOs1x7pyBmAMHNciTgYcwYntz35lZvup+9GSU03" +
                                                              "qZB1NZsBP2qW9YyhqNS8mmrUlBhNdZNqqqU6+Xg3qYT3hKJR0bs1nbYo6yYz" +
                                                              "VN5VofP/wURpEIEmqoF3RUvrzrshsWH+njMIIZXwkDp42oj447+MSPFhPUPj" +
                                                              "kixpiqbHe00d9bfigDiDYNvh+CB4/Ujc0rMmuGBcN4fiEvjBMLUHZAtph2BN" +
                                                              "cUuS4519fd2ggJbiesfQ1Yz/xyQ51HTmWCQCm7AwDAEqRM8mXU1Rc0A+lN3Q" +
                                                              "debBgWeFe2FI2DZiJAbzxsS8MT5vDOaNiXljMG8sOC+JRPh0s3B+sd+wWyMQ" +
                                                              "9wC8dSv7rrtm1/62MnA0Y2wGmBpJ2wIJqNMDBwfRB+STLfUTS0+vfSJKZiRI" +
                                                              "iySzrKRiPllvDgFSySN2MNcNQmryMsQSX4bA1GbqMk0BQBXLFLaUKn2UmtjP" +
                                                              "yCyfBCd/YaTGi2ePgusnk0fGbu7/2vlREg0mBZyyHPAM2XsRyl3Ibg+DQSG5" +
                                                              "jbe+/fHJw3t1DxYCWcZJjnmcqENb2CHC5hmQVy2RHh54bG87N3s1wDaTYNcB" +
                                                              "EVvDcwRQp8NBcNSlChRO62ZGUnHIsXENGzb1Ma+He2ozf58FblGLYXgOPGvt" +
                                                              "uOS/ODrHwHau8Gz0s5AWPENc3mfc88ffv3MhN7eTTBp9VUAfZR0+AENhLRyq" +
                                                              "mj233W5SCnSvHen99p3v3bqT+yxQLCs0YTu2nQBcsIVg5lue3vPK66ePvRj1" +
                                                              "/JxBBs8OQiGUc5XEflJTQkmY7VxvPQCAKuADek37Dg38U0kr0qBKMbD+1bh8" +
                                                              "7cN/P9Ak/ECFHseN1kwtwOs/ZwO56dnrP2nlYiIyJmDPZh6ZQPWZnuT1pimN" +
                                                              "4zpyNz+/6DtPSfdAfgBMtpQJymG2jNugjGs+D+oxzom5NiZyLfZfwhu+rxdz" +
                                                              "wvN5exHahLMTPrYOm+WWPz6CIeirpQbk21/8oL7/g8fPcIWCxZjfHbZIRofw" +
                                                              "QGzOzYH4uWH82iRZw0B30WTPtU3q5KcgMQkSZUBma6sJIJoLOI9NXV75p18/" +
                                                              "MWfXqTIS3UhqVF1KbZR4HJJqCABqDQP+5owvXSn2f6wKmiauKslTPq8D92Bx" +
                                                              "4d3tyhiM78fEz+f+9LLjR09zRzSEjAWcP4opIQC8vKT3Yv/+F77w0vE7Do+J" +
                                                              "omBlccAL8c3751Z1cN+f/5Fncg51BQqWEH8yfuLu+Z1XvMv5PcxB7vZcfhoD" +
                                                              "3PZ4L7g/81G0reK3UVKZJE2yXUL3S2oWIzkJZaPl1NVQZgfGgyWgqHc6XExd" +
                                                              "GMY737RhtPPSJ7wjNb7XhwCuwSk2VtixvyIMcBHCXzZzlhW8XYXNeQ6eVBum" +
                                                              "zmCVNBWClPoSYhmpw+VZkM/pjm3dbuDN5CIuxSYhxF1e1Cu7gloshmeNPd2a" +
                                                              "IlpsF1pg05O/2GLcoKOqy5LaYxs0vNIdJVaa82Zc7c7I/yrC5Z4fcb0AIYgC" +
                                                              "i4pV5Pw0cWzfoaOprfeuFSHSEqxyu+AQ98Af/v1c7MgbzxQoq6qZbpyn0lGq" +
                                                              "+uaswikDQbmFH1Y8D3+t4eCbj7QPbZhOIYR9rVOUOvj/YlBiVfE4Dy/lqX1/" +
                                                              "m7/9iuFd06hpFofMGRb5wy0nnrn6XPlglJ/MROjlneiCTB3BgKsxKRxBte2B" +
                                                              "sFvmOkAzbuxSeDpsB+goXFcU8B03WxdjLZG01BJjvPgYgqQ4RJlbRfPCKFAZ" +
                                                              "4yb3ZQctqGKVDNCM2ue7C3p3yfvbe98SPnhOAQZBN/u++Lf6X979HN+tKnQP" +
                                                              "10Y+1wA38tVjTUL5z+EvAs9n+OC6sQN/ATM77cPaEve0hmmmZL4IKRDf2/L6" +
                                                              "yN1vPyAUCCeHEDHdf+gbn8cOHBIBJY78y/JO3X4ecewX6mBj4eqWlpqFc2z8" +
                                                              "68m9j96399aovUtwui+HbG0ydw8j7vllVtDoYqVX3db4y9tbyjZCoHaTqqym" +
                                                              "7MnS7lTQWSut7KBvF7w7As917TWjxRmJrHJyOIe/4amAunT5gB2dBu+XXS9v" +
                                                              "cQKk0/byzukHSDHWEkFwW4mxb2LzdSjYIEB6wrnLs8YtZ8sarfBstlXaPH1r" +
                                                              "FGMtofHhEmNHsLkD0jhYIxFIjp4pDp4FU8zEMUz1fbY+fdM3RTHWEup+v8TY" +
                                                              "vdgcFaboM6gMxxkq7vUMO9LxJ+t7H2ekclDXVSpp4TjGf2/0Bdf3zpYN58GT" +
                                                              "tA2RnL4Ni7GG7BS1i3z8H05cM/ESZ+xCOZbSMzG8oAbI4k7DZ3y4hJEfweYh" +
                                                              "QL+MxGR+c3bcM9KPz4KR+NH/PHhkW1N5+kYqxhrS04PwRQXy5jZpjJd7A/K1" +
                                                              "K5rmtK/7sM1OUQVofTe1Bx79RTK5okkWxIUyeOiG9r7jVfKrmSffclLNHlcf" +
                                                              "vJgkjbCNVKgjfhm59r+8OAS2TJxByoOTznYlQ1O2RzgXk2dVPj9cB2pcz9A/" +
                                                              "GlHXv//FH1wubLe0SA3h0T/y5TdO3TNx8oQoB7CoYWR1sY8s+V928BZseYmb" +
                                                              "PG9TP7r60sl33uy/ztmjBmyeyTnhVe8dw+GciZ2nCuMLZ/5NiXB7CZtfQTWY" +
                                                              "VlTV/QgGQgth2YxRXUl50Th5FqKxEccWwbPbDqnd04/GYqwlzPBmibG/YHOa" +
                                                              "kQYP9mWFjU8F/GWKlle8hUH/9bNVQ8znmou/PdO3YDHWElb6qMTYJ9h8wEgV" +
                                                              "0333b54ZzvwvzJCDHQp+GsALq3l5HyLFxzP5waONVXOP7niZH2zdD1x1cFZJ" +
                                                              "Z1XVf6Xie68wTJpWuE514oLF4D9QKy+e4rMFOAS0fPGfcaZIlJEFJZgYqRAv" +
                                                              "fp5yRmYV4gHp0PopqyCmw5SQVfmvn66WkRqPDiYVL36SBpAOJPjaaDgQdOlU" +
                                                              "n2nWQ+YxQW8XVNx9yUWC1x6uH8yeyg98NyXLAjjKv0o7eS/ba8P1yaPX9Nxw" +
                                                              "5pJ7xbW8rEoTEyilFk5C4guBe1GwtKg0R1bFppWfNjxUvdxB5GaxYC+WFvgc" +
                                                              "Hk4iEQPdb37oztpqd6+uXzl22eO/21/xPOSSnSQiQc20M/9CMGdkoVjYmcg/" +
                                                              "8fVLJr9M71j53fEr1qTff5VfuRJRXiwsTj8gv3j8uhcOzjvWGiW13aQczp40" +
                                                              "x28qrxrXtlF51EySesXqysESQYoiqYHjZANGioQxzO1im7Pe7cWPOoy05R+R" +
                                                              "8z+F1aj6GDU36FkthWLgQFrr9TgXRoG7lqxhhBi8Ht81wl4BxLgb4LkDiS2G" +
                                                              "4dwgVHxmcLi4sTAyo4u38Vd8W/Yf0e71ULEiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "P//2n/3AP3n5i+WJ9v8FKM++sYssAAA=");
}
