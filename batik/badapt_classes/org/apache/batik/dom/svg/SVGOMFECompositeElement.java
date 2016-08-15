package org.apache.batik.dom.svg;
public class SVGOMFECompositeElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFECompositeElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_IN_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(null, SVG_IN2_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(null, SVG_OPERATOR_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_K1_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_K2_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_K3_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_K4_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      OPERATOR_VALUES =
      { "",
    SVG_OVER_VALUE,
    SVG_IN_VALUE,
    SVG_OUT_VALUE,
    SVG_ATOP_VALUE,
    SVG_XOR_VALUE,
    SVG_ARITHMETIC_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in;
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in2;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      operator;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      k1;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      k2;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      k3;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      k4;
    protected SVGOMFECompositeElement() {
        super(
          );
    }
    public SVGOMFECompositeElement(java.lang.String prefix,
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
        in =
          createLiveAnimatedString(
            null,
            SVG_IN_ATTRIBUTE);
        in2 =
          createLiveAnimatedString(
            null,
            SVG_IN2_ATTRIBUTE);
        operator =
          createLiveAnimatedEnumeration(
            null,
            SVG_OPERATOR_ATTRIBUTE,
            OPERATOR_VALUES,
            (short)
              1);
        k1 =
          createLiveAnimatedNumber(
            null,
            SVG_K1_ATTRIBUTE,
            0.0F);
        k2 =
          createLiveAnimatedNumber(
            null,
            SVG_K2_ATTRIBUTE,
            0.0F);
        k3 =
          createLiveAnimatedNumber(
            null,
            SVG_K3_ATTRIBUTE,
            0.0F);
        k4 =
          createLiveAnimatedNumber(
            null,
            SVG_K4_ATTRIBUTE,
            0.0F);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_COMPOSITE_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn1() {
        return in;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn2() {
        return in2;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getOperator() {
        return operator;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getK1() {
        return k1;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getK2() {
        return k2;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getK3() {
        return k3;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getK4() {
        return k4;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFECompositeElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "d5hZLQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3M1Ct0OGe/h/923lI3/2P69woJyYrxKxHGs/hV795UdaP/LtvP0hQ2atH0uu" +
       "XMNAmHvYtvx553+cfvLMV08Xbp8W7lN3MbQo23HGO1MQN4b7gTWIsy8rvzwG" +
       "3AY8Fw9WgHcdZ+cjwx7n5sO1E9xntbP7s8fo+O2Zlt8Hrmd3vvPscWc8Vchv" +
       "uKv74+ns9j3AKcM8Ut855ffB3ylw/U12ZR1mGVsSfKC1i6vOHwRWPljaH0wc" +
       "WwhkIyLcfEk5sBTww/dc4Yf5RG17YB5sCFfTE10TMq47nDe5ow3eyNGoAzW8" +
       "M8s9Ay56p4b2NdTwY1dXwy25GrJEiIAVDFe2c0WPAFv1uc4QE/rDSyJGjzo8" +
       "cOKnr+3EOdluw+FXfu2pP/jwK0/9x5yv7jBCYGosmF8lPj/S5ruvfuvb37jn" +
       "0S/ky/qtihxujX58Y3PlvuWy7Ugu+t0HynlbpotHMvLZKefU1pSXrjTlD59f" +
       "xnJoLGOwHr5ny1Pnt55xPlfK+S3DPPf8eabf7lxiMabDn3//eVdf70o+KDvK" +
       "i8/t7e09f/EZ388FwQ5I4dSWAre2yxJ93yyLE7zz/Vnywr45zti6O48WJ1MJ" +
       "FxgOCB9Wu80L9OID37J++S9+fbsxOc4bxyrrH3v573x/7xMvnz6yHXzqih3Z" +
       "0TbbLWEu4D25lNkq9sRJo+Qtun/+xRf/xT9+8aNbqR64fHPTAXv3X/83//fr" +
       "e5/+09+7SiR9C3CA7IfmJ9daFh48XBZatufq2QTbL9vG04a3d7D5BoXJFXYK" +
       "Cu+9to6Z3OEOOfN3P/JfHhF+ZPHCDQTSjx/T0fEuP8e8+nu9d6s/f7pwywGD" +
       "XrEzv7zRxct582ygR3HgCpex56Nb18v1t/W7LHlfbroT1sGXTij7SJa8CKhD" +
       "zVS9tcwJ1X8qKRzjuuevn+sOIvDBbjoPrsF1H7tGCJJz3f58Om0c8PSzJ2/P" +
       "MNdwMo7YTvRj8v/MDcr/bnCJO/nFa8j/965HfjATcgF+7phAP3+DApXA9dxO" +
       "oOeuIdCnr0egOzxfz7ca+2qFr0+t2YzPGu42PUeg/OKb8I0XdlBeuAaUf3hd" +
       "vmHBN+gbbJw93zsm/2fehPz6Tn79GvJ//vrkz8f/tWPy/JM3IY+5k8e8hjz/" +
       "9PrkqVxNnt94E/J4O3m8a8jzW9cnT/Vq8vzzN5Qnb5+cApuZ28p7jb1S9vtf" +
       "nhBZ5Uu4kCUH6/hDpq1e2A9ARD0Igd9fMO1GVowdE2h03QKBJevew3WP9tz5" +
       "xZ/9z5/8+t996ltgESULt62yEB2sPEf2TFuX/elXP/XoXS//6c/mzwWAnsSX" +
       "nv5v+QO+37kxWI9ksPj8QRsthxGT7+N1LUOWd2EfwQPW8VvBcnGcSq8fbfTA" +
       "1/BqSGD7fzQstyqYCA+tIlqVkU5CtvTOgpg3mwM8qtJg0XSL2Hxh6ZhtDASe" +
       "kReLEJqp0x6+agRkQ3EpstTyzWFjuKR4coI3hmYobKi1uYDhnmNLzGzM90qi" +
       "VI/7E3uFl2wfdzr1aASvIqgGaXpltqoEMT0ZrdNwozXQWgq5HARBKwgxG2yj" +
       "3uvzStGwTMMLk/bUhzEDpqhEKGElWZlOumt4zqaVoFsZuy2uXEXgcW1qNYWS" +
       "RXfa86DLd7FUpuxOTV7xA8myEodqEXDPcFnCG7mCBy/bVY/p2KIezjsbyaDl" +
       "BmHxzsbuLUdVr7saEGVeXZPzGOVHE0VhnAk1KGP+ptPnZwvS1SqTKj8y5GV5" +
       "M6wWy0IPKWu9NlHkytJ8YtpTHF4vsYFgNsm2pVrzdORoAsmNiiILKTQ1MAVy" +
       "EK9sY1MiRGsQpx41hyyz69fQFV43rQ6xHnc7oj1uJ2ZXEEf6tNkj6kJrFnlG" +
       "qWEk1nhD1zoisZSYNbEuD2GKXEjtAWPUZSsaqU20KI54lVdEvtrnEXjkES7R" +
       "aTEpY8yGzW6ZkFC2pPq1xcIgnY1aJwda4MuSzVIK21nhmq73Z3FvE87SDSNy" +
       "8rA1CpYDfNibTOgm0V43qWoFHrG1pTEaBhGhM6MRPhnDvNi0vUkkiOp0FCBG" +
       "iPEetx7RnJV4Yl8LyrbRxK1OmeM7G3FUpLtFpjedVSgTsVscMq+Xpopo05jo" +
       "VvsYOSTWfqh2wnZMT5l1j59YGyaEWWsqJ9WhN8EovquqXg/mhvwkGTRxH1uW" +
       "SkNroFucVsV9alZas12ki6GDqaMTNUqiopZO9LwpVPYsqZ64kjwWWksH6zdJ" +
       "ImFUDDKZak/yA6NUY9tcUoTpRlAjJbna4QfNqmmTw+GqRs9lsz9UeCpZLvqT" +
       "YXGy6Ikp0Yg7hoqGrYRozTd6telHphslSG0Z1DRV05lwNqo1TaGk6LqxTMYV" +
       "NqyggeSnYybelJiyYQqi1W3XelM6HWtTHxUGDjvD1h2USSeO6sFjO4QHq3Fl" +
       "vBnMFgOLlMrWoCvYw2YayuTGS0yR9FeBKFK9+rpnlMzhUCC1gCmiEUFoCU4S" +
       "kiykkcFM+hvWJHs1D6FErqoQRNDsYothS0to3krYihS2esV2hZ+UBqP5fCxP" +
       "2sGsRxdTlep1hA7iMVNfamLdoUiPVEqPvVXS67WTPl7GGp1+tb1EkQEb8Z22" +
       "MZmIq3ExxJplptOKzOVcbidxe9IJNLGih0oP9pt+dyATyyKmlaKevypDsOUY" +
       "GtXH115n0OwKFamGLRbl0piUTLGPiNpGliI/qQWcKpaQ4VqC51VGITBxXp9S" +
       "1Vl1Y3Qn/cEgWKSJRHodbNzA5L7QgttmoGB0OKv0oKlLVRVxmSqij+C15YQ1" +
       "Bzg2T1slzmAYVgtjIh6PdWTcFvVxm0FrSrG7GZiEM6CsrtUa4b0lS1lotQ91" +
       "TG0iNZZhe02NcF53+kWi0zQXWleyRhVyOF7RTYcSCXw5aXA92S6nZIuaBIvZ" +
       "Gq0Chp1BNXaBDhpaaVaJmhY2SAdrJnYGqN5WrUZJ7rn4WG+XN2PLCWZGZPdn" +
       "eFSHh4qkDUpyyE/GBN1ZjjytFnWcWlUPpVqpOnJ1H5qWwuaCXituOhAmSh8b" +
       "19EkmHKGnviD2RB2qEG/NVmGarenRHyP1NeYWNJCH11LSQVv1FdNmpEdzeBT" +
       "sARBZqMksNLadRSZ1WKZn4c6uWnEpQXUWNdtZKwqC4GQxy1rEJVGmuKpPaYq" +
       "DcWK1GfDEC5Ho3VgVoLyCqnVGlyjFtGKNu21OylcJdhyn5Sw5qiVsmhN1lmF" +
       "RCGlWJqsFV1tDj3g7pK03khWyZlOhLhk1MzaZl3tbRRy1uow4QZbRP31cN4R" +
       "bIniSy1NqHRX0HJqwAjhQBUY9h2PYASYklgOCjuoyaVwRCluw05cSEQkq0VY" +
       "U6OXThtO39UTNEzZolMPMbfGs42NHpe48WKgzy2smUbOYGG4lagqtAe0qdOx" +
       "sqGL7Whiz2a+ZjKMn5bdhtvFm7YQNEzU1Di7IuucG+PqdDlVBVdadelhr4RQ" +
       "a2da7tR5Hax67GY9NDB1EnORiM6oIdTAe0o4H9pdhK71FutazPj2AmcVD2Ko" +
       "iluB42oQjBHLWNtTgVgumlF3Ni8SiDivsoMJhhUVmKojG1uIR81OyRaTkWWI" +
       "CDxnOnrXj2Fl3GFVpYm7tWUpLEoNdpXiployR+jQSeV45G8cfNlgbbcbpUGZ" +
       "DNvlWVTpJ7HQtENMlL05tNFqOmyvFkydJYMSTidFPNyQfVbtdTalgSNnbzwn" +
       "tsARLCc14TVRsuu2gRkMXWsobFIZ1MOuS8WNelNQOFLXmdraQzjH5FOvOoFo" +
       "Zoo5i16ot7tWEYnbwMnQitJYNRJvU6pbtYqFt4bCrFZJ4E0FnUCz6dROzDVS" +
       "65jwmBug1RHDCY5TrBpsX4Ei3+/ViOlcgwx8VG6AVakKIQy8UBF8w3fBOsZH" +
       "xJJTrG7f42bBfCIofHdkjaimhfZUJy3LTpk0+gOY0xiVSoJ21Cp3LLzSZ71V" +
       "C600JyNySaq2ypQraa9YLNeq7QVbDFOpwg+UNTsXS8qKGSblsQSnCM+YHahX" +
       "06Q6mLBl4FJphCvYrAURjF0sTqa6H+LlOetVeJIV8HpvHDVUJUKgZVrWdZkl" +
       "VLhID7DAM7tVgeBKUr82VCHTc5h2MvKLQpfolPlx0WZ5q89P8CkaDMsKtZTH" +
       "Y3wZNWI/NGR72WDWa44xaY8Pu3Ct08YCoxjRY8iwEZ3h8FSvDNxyfy3XNtNZ" +
       "sUiseloRC2cOJoDJgK2TUgXEdPWgiFTgpGKHNEJ1lMqYGi9SH2/xPTPkjZHV" +
       "H3NI1OBSb1KB+oIjo0UdgRgOIrBRazCd0KO1NKnK6aibFqM2acLVVVApM7WS" +
       "bVotnXaR1GCDqJzyC7Ivh6IdzhKUnHnemnKMVGaHnZU/C0280Y0TSYJ8qLOq" +
       "tpA23BTrnlzZYFC522ZhwDjcsNSRQZAkYvNRXZq1h0ZRWMKCXaQGwhzEuXN4" +
       "tRSWtaraFcyaR2njcA2XW3XAOdq4qsQVx3bo8rTLpf1giSu805XQpVgLFzbe" +
       "ZaBEqgLXmaUOUtNnjQhNHNWWRGlaLFOEW/UaENSA8MFML0IuxUw2cw6tDtB2" +
       "iPS7FCKzUWUs0VRIJVJ5VjdZmrAs1ldRzmv3p77Ia3BP6TjkWB32NjikNyb4" +
       "GC3Gyy5UHy2WxDiRtNp02aygHFZKHd1ZTVJ1SUsQUp7ORiJWjHojdsqoZZfg" +
       "dKlpTzR95S7LcYsjzLLJ8CQJRyRLwuR8ypX80mZB1UPTM40wHRXbULvSoicR" +
       "3jKRkeVqK7PUUAVHLzapochv5CFTXFe0xnShWgtoGTCV8iwe9aSK2EiMIizq" +
       "cnmOClPe7rYsc+DK3bA8WrFNAm2DoGVc2Uz77FwZjlWk21qm6Kg0XDeIOUxD" +
       "4hql6jwdSUYUj/vh0MZrnpdWVzEkJJ4zsShKNBt4CqnVuTOcLM0gpVG/E1t4" +
       "FR74rL3WxIjRxjERseiYbKHLhkXE6yhG6UWVM8k23hy3okicTusIbk5ERF/J" +
       "86mO8SxiEuXmrNEK1pOibiFWhPnLRWWIp2HPg20XCWb9QcOwZ3Vl463leZlu" +
       "bhYjZeQimKCSGi3UNhgfTQ0DNwi0von5bipRSa+y7A11epV6eDfSFKOeViZc" +
       "xx4nMrok8e5QsSczzlKlLh8NxQHXdSFzUyfGrEJV+03QDhIXjG4RZNGxi91i" +
       "M5E2VF1eL2NVHq6XIlWlul0vYlrhGh0zquSjY19cA6pbiVGl4dlljibWckfS" +
       "g8l6xMBSY0TJbRGfhGNGWa1qq0js1WGHboimXGWNRC+Nl4PifNZpu40qFwou" +
       "yRMglsSWeHFIRlY8Ikic88Xq0OmzxVaqtHwDDic9oe8BIyuzIgrhsorRgUCF" +
       "PUQf45pMRJAPplffqoktYar21opUlYMm7yY2OucCwFRIqrRriylNsBNDbpVx" +
       "iBrGqxJFNcXFGIbVNjzfzBRMkjYBOexLnQXKK2inrQs1tDgz162SQhUNh15S" +
       "xDyCoymMeYphoDg28eUGGZIw0pc4rMjhmLcaLdCEqlTqywDzF0OC83oLoRR0" +
       "k+G8jtukbfvTDmUTJWc0V0N1UGTwlgXaICV/5ZZStenwc89v005TXsQdx+5g" +
       "2ABdbSbiGlc6Vl8gNx06IWYDHmxU+/iiZDSRxPKbQ6w+xl1DaRYVledx1pmM" +
       "TVJZEHiTkzwC6o9pZgVAqT23VFdC1SnFc2kuMMHKpvpIwvSl8pxewKxH1OTS" +
       "oqr1xabut2vzgGv7RrktTOZ4l0UNkZ3LkVd1m0htMk+riIptUB5PHaiusRVc" +
       "kAMaW0ux0PZ6Vokx7biFg5pNu25xLtkD0YoB+FHutZLyRGnG3TY2MStwtYk3" +
       "Wp1Y6EhCm7Bmtbo1C4hY67ntBOlNmbnYFYJRYCmCXzVEIdCHjbhNJB2gqKE7" +
       "0RJbVeCVsRLgzTTTi8xDZVlbUemkMhhVaTjuFskaW0xR0l036JpcsbgNM7fM" +
       "EqojnXFUo1KuwSTcGhFw1B6MBG2Z1qxKCo/aS6Re3rRaDkVKwrSoBbQqFud1" +
       "sCdSJYFOSW0OketYxVSiMRad9WiuR2yyVEwNryAiocmNIdMk5RpiRrZt1YYI" +
       "HVeholYt1hY+M9CbNWcAYhA1nEfOYtOtxnBEl/WNOIUciieJKayxLirCzIii" +
       "Wngg0TY1nJKoWtXUYYpitjsql+WEcxdNvxYgdcQd1fWwNeMaG8CJCFkVG4Ku" +
       "xfpgiCDMcARUvqj0pNJ87rM0uqiCYLw/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("mzApavNqMgpdiKuVW1w3hCm72DaEyThuwOy8LEyXczoSBhYlV7mlte5F5EwM" +
       "NrCGuMNxGQn0NkxgTkQOek0LYoMQrqMkLfeEciANG23OUizcrVS8UhrYUCkZ" +
       "p5NaEVmniEz05SkCCytEqRg9KIr7dNdEonqdaNkRAVn8KsKtRlUaKyIpjcbd" +
       "QWOD21bU45vN6aJrzDfMuu4ldZptwfO12l2HfWYlCFAvJUrKMkQheIoXQ5Gn" +
       "ggE8nC0NeUR1agJu9Gx0wQpMvTbGBjarJvhE2CTixA0hNgTrEiZPlDJq+bJs" +
       "jz1LFKWViqWbgTZPpYEAQ5tOpUjQUDeuQcX2pgtpGZUMsPyJ3zdu7FHb/fkT" +
       "xINzmW/i2WFy5O3PwSPW/O/M7jHr/uPWK05jPHzkVeb+UYt1RT36VPzK42zZ" +
       "e8FHr3U4M38n+NmPvPyK1v9V+PTuRdEyKtwZef4P2fpKty87SpHdp1e+wvjJ" +
       "ndA/efy58KFaTnwofMJLqz8/oewvs+TPosI7DdeI8jeKOmbbtLHSsSgKDCWO" +
       "9PCqzz9XnqEdGus/3cjRkmMquDvLLILr4zsVfPxGVBAVbvcDYyVH+hvq4a9P" +
       "KPtfWfJ6VHj4UA+XKyEr//Yh4P/+FgA/kGU+Bq5f2gH+pRu1+fvfCOupW04o" +
       "uy3L/JuocDdgbNpTZZvdvXfFDvF9/y3gezTLfApcn9nh+8zNx3fuhLL7s+Rs" +
       "VDgD8BHuwZuwJ64y1S9/NXoA/9RdNwP+53bwP3fz4T96QtnjWfLwPvwczoOH" +
       "yH7gLSDLzs4VfghcX9oh+9LNR/bMCWXFLLkQFe4CyPrHXta++wTrHnlDe6iI" +
       "p9+qiTNtfHmniC/ffEU0TihDs6QcFW4DiqCuy8G3L8sO0VduBvqv7NB/5eaj" +
       "75xQ1suSD+zQ52guHgLDbgawr+6AffXmAxucUMZnCb0DVjkGjLkZwL6+A/b1" +
       "mw/s+RPKLmXJeAesegzY5C0AezDLzE7I/dEO2B/dKLA3DJ9OGSeUWVmigRjE" +
       "1despx2c07rv6FQ8KMjh6m8B7hNZJgqub+7gfvPmw12fULbJkgBEScCOxw+N" +
       "HhwEHR9iDW/oxHFUeOgan5NkB+MfvuITtu1nV+oXXjl3x0OvjP7t9ujl/qdR" +
       "d9KFO2axbR89i3vk/owf6DMjV8ad25O5+ZnHUy8BcNc6MRMVbgFpJvepD29r" +
       "/+2o8Lar1QY1QXq05k/vfOJoTTAf8v9H6/1MVDh7WA8s4tubo1U+DnoHVbLb" +
       "n/P3He5H3+ALHcOO9ODgKCMfya4mB9pheJtsd0QPH/W7PBB84I1MeNDk6Hcc" +
       "2aHD/MvE/QOC8fbbxEvqF18h2Q++Xv/V7Xckqi2nadbLHXTh9u0nLXmn2SHD" +
       "J67Z235fZ/Bnvnfvl+58en/Tde9W4MM5cES2x6/+xUbH8aP8G4v0tx76Z+/7" +
       "R6/8SX6O5P8ByMALujI6AAA=");
}
