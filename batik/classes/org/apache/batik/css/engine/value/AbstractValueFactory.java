package org.apache.batik.css.engine.value;
public abstract class AbstractValueFactory {
    public abstract java.lang.String getPropertyName();
    protected static java.lang.String resolveURI(org.apache.batik.util.ParsedURL base,
                                                 java.lang.String value) {
        return new org.apache.batik.util.ParsedURL(
          base,
          value).
          toString(
            );
    }
    protected org.w3c.dom.DOMException createInvalidIdentifierDOMException(java.lang.String ident) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        ident };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.identifier",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            SYNTAX_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createInvalidLexicalUnitDOMException(short type) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Integer(
          type) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.lexical.unit",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            NOT_SUPPORTED_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createInvalidFloatTypeDOMException(short t) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Integer(
          t) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.float.type",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            INVALID_ACCESS_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createInvalidFloatValueDOMException(float f) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Float(
          f) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.float.value",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            INVALID_ACCESS_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createInvalidStringTypeDOMException(short t) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Integer(
          t) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.string.type",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            INVALID_ACCESS_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createMalformedLexicalUnitDOMException() {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "malformed.lexical.unit",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            INVALID_ACCESS_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createDOMException() {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.access",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            NOT_SUPPORTED_ERR,
          s);
    }
    public AbstractValueFactory() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "601BB0eyZwhQFpSJV3yb8m8lEmqqJh8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JK1R9QmS2I4ZOuGQ4cJ5y7Mnil5ZT1NhsJLXlCAgGDuq6v0oqpAjurljVW6o" +
       "s5PmFg30QRcjeEdsxkhE8WFHJnZVRnC6vI0OlandJHVOaKdRRGhkjTNhXphv" +
       "Rs2l4KWzQeDohjsf9cXFKPH0QVvoz+mWoc42uJHNBdSbrCiXykY9PlmOLBrZ" +
       "zHhjAYfW1GGXTA/h54POaumEmGCRy5Am5frOb1QTpZm1wrZZiaT2vONvCHvo" +
       "jMY6PFI6ftXX/B3KrxcioTGd1tJG1JlFudsQ2c47G7IKGz1fTmduy2xgk1Cc" +
       "VNojR7LX67GEtGrkqFXlp22k3dKqrTzayCN5Edi+MwiTme4DEFCqiYPQ+GIi" +
       "UMZ6JNSFQS+tuYnbzECqWzFaLRHF2XjdYzKFMCYabjYFbzGp8jQvYKnLOWyE" +
       "bCRHzhFmTHvSbrpEiVrUtHJe8uyBJEsSQ/WcwPIm2CLaGB450kebSd1m26Kx" +
       "1JayN8xWW5wiF2xq0QE6smzMmFamXJ/YIOJEF3Vc4dj63K/xG02SSB6Xtahb" +
       "m9Dz2crE2MiroV0GFSbBrtvrsPBgsJhuaiOz1SEmo+ViEi83Y1oTiaw67UuY" +
       "ooWLhaLlDDl2tMosVcbelM0XG28k9IdOhQETsF1DEKVj5FOfIyJe4p1mpe7G" +
       "00SPk95czpdJc4gJ9A4edYRZaprdygqdL/uVCb1F/VG3Q/QTGmt0K51RhHaH" +
       "aUcHPfOaYjpwWBszaK+bL4aG06HY4SLjnW6gWJa505j2LnACLOz3uaqoEWvc" +
       "mIwc3FIpNs3NpdhBOpudTeSGqNU2mL5DERnPa4sOMlXXzCbqRAw3QkmUtwJa" +
       "4Nf6jNG44aZOJaTQmlLzVuAwyiy3c2W69FtcpUkhHbwp93B9lw7caJa4rJmN" +
       "mGDbbtA9GmCb2oSVqctZZmXILLgQYeYSbVINL62NYAE29SbH8+PmYtsOm22/" +
       "2urMdNdz+7Sg8cSI32KCCJDIGixq8YhlCRIVOS8LatSyl5DpjI9Ekt9NMMX0" +
       "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" +
       "7ZK8URVWkl8Zh8ttO1vJm8Eu1WvWZkjuBFRzzZ1Bcb0ZbvZjC/Ya6Toc1Vwu" +
       "NPCgrdcUZVhtVibwtl5H/WC4my6SldNqrJKVEaAAlxMiQltsdxLwdL83E3dd" +
       "su33dlUazYMVm65j1ycTPqhTAxzAIa7ztudMO/V6p8c7/dYGlSnRFbfDwWA8" +
       "WubTtIY1mu0lQQ8cmrOyGUsGXh+AgC+RVW2gIJMFjVS1bksbWO2OZhtWN9xI" +
       "qFCroPUls6w2q/0mUu12EXW3TvV532corr6TMAezQXYaUDoGXk7f8Y7itfUb" +
       "X9rOwb3lJsnJCZdpt4qGwUt4Y85u3uHB0ebMneLRVn52smtc/q5esmt8ZmcN" +
       "KrYI3vxCp1rl9sAn3/f0M8r0h6oHRzuSfAzdFXv+19rqVrXPiLoLSHr7C2+F" +
       "TMpDvdOdss++7+8eWL5Tf/IlnAU8dEHPiyJ/dPLs5wZvlb/3ALrlZN/shuPG" +
       "80yPn98tuztU4yR0l+f2zN584tk3Fh57O7gePfLsozffj79kxIpC3UfHJbu+" +
       "8SVt26LwYujqRo1noVee3tJHJgxOY8p/sV2Ys3LLB/aJnW8qHr4VXG87svNt" +
       "L8VOEB9+6MWqHKtKOSNuau7Bnvh4t/ChGw6t9ieR5TE4uxiX1pWC3nuJb76j" +
       "KN4dF+NYnmWzC/KCW77lZbilHP53ggs+cgv8Etxypah+201dceWUYG/id19i" +
       "4vcUxXfF0KNyqIqxSrpb0TbAa47qxsWmZEhMJ71MVv2TuQSce3/h3LQuHyqe" +
       "c3gDQemXD75cv3w9uLAjv2CvqF/K+8UZnORi6LZI98K45PrEJc76waL4WAxd" +
       "P+essZoZsmizrhGfdUZB+32nHvn4y/XIO8DVPfJI9xWPlGdKgmcvMf5TRfHD" +
       "MfTIOeP7tifGBcBdYvqPvBKTZHRk+uj/Phi0wqaS6+cu8cdniuKnLs6c0h/l" +
       "AcwlDvnpV8IhyyOHLP+PYuGzl9j+uaL4pYu2789lXiQYfvnl2t4B1/rI9vUr" +
       "Y/tZ0373krbfL4rfjKG37s2eiHZxBq/+LxHgt16u5V8LriePLH/ylbf885e0" +
       "/WVR/EkM3be3/BIr//SlWJnF0Gtv9vFIcfp9/w2fsO0/u5I/9czVO9/wDPuH" +
       "5fcTJ59G3TWG7tQS2z57WHmmfrsfqppR2nLX/ujSL/++EEMPv+gHLvHRoWCp" +
       "/9/sGb8YQ2+8hDGGbt9XzvL8AzD3ZjwxdAsoz1I+H0PXLlICLcr/s3T/BJKT" +
       "UzrQ6b5yluRfgXRAUlT/zT9ews+cbe6PhrMr59P4k/G878XG80zm/+i5fL38" +
       "UvE4t0723yo+IX/6GYp+9/PNH9p/RSLbYp4XUu4cQ3fsP2g5yc8ffkFpx7Ju" +
       "Hz725Xt+4q6vOn6XuGev8OlUOKPbQzf/TKPn+HH5YUX+c2/46a/74Wf+vDzc" +
       "/R8pNiIGQioAAA==");
}
