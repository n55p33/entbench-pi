package org.apache.batik.dom.svg;
public class SVGOMFEConvolveMatrixElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFEConvolveMatrixElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_IN_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(null, SVG_ORDER_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_OPTIONAL_NUMBER));
             t.put(null, SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_OPTIONAL_NUMBER));
             t.put(null, SVG_KERNEL_MATRIX_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             t.put(null, SVG_DIVISOR_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_BIAS_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_TARGET_X_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_INTEGER));
             t.put(null, SVG_TARGET_Y_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_INTEGER));
             t.put(null, SVG_EDGE_MODE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_PRESERVE_ALPHA_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      EDGE_MODE_VALUES =
      { "",
    SVG_DUPLICATE_VALUE,
    SVG_WRAP_VALUE,
    SVG_NONE_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      edgeMode;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      bias;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      preserveAlpha;
    protected SVGOMFEConvolveMatrixElement() {
        super(
          );
    }
    public SVGOMFEConvolveMatrixElement(java.lang.String prefix,
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
        edgeMode =
          createLiveAnimatedEnumeration(
            null,
            SVG_EDGE_MODE_ATTRIBUTE,
            EDGE_MODE_VALUES,
            (short)
              1);
        bias =
          createLiveAnimatedNumber(
            null,
            SVG_BIAS_ATTRIBUTE,
            0.0F);
        preserveAlpha =
          createLiveAnimatedBoolean(
            null,
            SVG_PRESERVE_ALPHA_ATTRIBUTE,
            false);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_CONVOLVE_MATRIX_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn1() {
        return in;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getEdgeMode() {
        return edgeMode;
    }
    public org.w3c.dom.svg.SVGAnimatedNumberList getKernelMatrix() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGFEConvolveMatrixElement.getKernelMatrix is not implemente" +
           "d"));
    }
    public org.w3c.dom.svg.SVGAnimatedInteger getOrderX() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEConvolveMatrixElement.getOrderX is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedInteger getOrderY() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEConvolveMatrixElement.getOrderY is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedInteger getTargetX() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEConvolveMatrixElement.getTargetX is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedInteger getTargetY() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEConvolveMatrixElement.getTargetY is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getDivisor() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEConvolveMatrixElement.getDivisor is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getBias() {
        return bias;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getKernelUnitLengthX() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGFEConvolveMatrixElement.getKernelUnitLengthX is not imple" +
           "mented"));
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getKernelUnitLengthY() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGFEConvolveMatrixElement.getKernelUnitLengthY is not imple" +
           "mented"));
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getPreserveAlpha() {
        return preserveAlpha;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEConvolveMatrixElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aDXQU1RV+u4Ek5IeE8CsQfgPyuytVajmh1hASCG5+DoGo" +
       "AQ2T2bfJkNmZYeZtsiD4w9Ej1lOrFBGtUnqKBT0o1qO1rVXx2CrWn3Pwp9ZS" +
       "oS39sQVPoa3WVq29983szuzszsT1mOaceTt599333v3uffe+++Ydeo8MN3Qy" +
       "hSosxDZr1Ag1KKxN0A0arZcFw1gDdV3iXQXCP65+t2VJkBR2kpG9gtEsCgZt" +
       "lKgcNTpJtaQYTFBEarRQGkWONp0aVO8XmKQqnWSsZDTFNVkSJdasRik26BD0" +
       "CBklMKZL3QlGm6wOGKmOwEzCfCbhOje5NkLKRFXbbDef4Ghe76Bgy7g9lsFI" +
       "ZWSj0C+EE0ySwxHJYLVJnczXVHlzj6yyEE2y0EZ5sQXBqsjiLAhmPFLxwUe3" +
       "91ZyCEYLiqIyLp6xmhqq3E+jEVJh1zbING5sIteSgggpdTRmpCaSGjQMg4Zh" +
       "0JS0diuYfTlVEvF6lYvDUj0VaiJOiJHpmZ1ogi7ErW7a+Jyhh2Jmyc6ZQdpp" +
       "aWlNKbNEvHN+eNddV1c+WkAqOkmFpLTjdESYBINBOgFQGu+mulEXjdJoJxml" +
       "gLLbqS4JsrTF0nSVIfUoAkuA+lOwYGVCozof08YK9Aiy6QmRqXpavBg3KOu/" +
       "4TFZ6AFZx9mymhI2Yj0IWCLBxPSYAHZnsQzrk5QoI1PdHGkZay6DBsBaFKes" +
       "V00PNUwRoIJUmSYiC0pPuB1MT+mBpsNVMECdkYmenSLWmiD2CT20Cy3S1a7N" +
       "JEGrERwIZGFkrLsZ7wm0NNGlJYd+3mtZets1ykolSAIw5ygVZZx/KTBNcTGt" +
       "pjGqU1gHJmPZvMhuYdxTO4KEQOOxrsZmmye2nrt0wZQjR802k3K0ae3eSEXW" +
       "Je7vHnlscv3cJQU4jWJNNSRUfobkfJW1WZTapAYeZly6RySGUsQjq5+/8voH" +
       "6ekgKWkihaIqJ+JgR6NENa5JMtVXUIXqAqPRJjKCKtF6Tm8iRfAekRRq1rbG" +
       "YgZlTWSYzKsKVf4/QBSDLhCiEniXlJiaetcE1svfkxohpAgeMheeecT8m4MF" +
       "I73hXjVOw4IoKJKihtt0FeU3wuBxugHb3nA3WH1f2FATOphgWNV7wgLYQS+1" +
       "CFE1Hjb6wZQ6VrQ2NzbAOupH428WwLSS6CDQ56LFaf/HsZIo9+iBQABUMtnt" +
       "EGRYSytVOUr1LnFXYlnDuYe7XjKNDReIhRgji2H4kDl8iA8fguFDMHzIb3gS" +
       "CPBRx+A0TCMAFfaBMwBvXDa3/apVG3bMKADr0waGAf5BaDojIyrV2x4j5ea7" +
       "xMNV5Vumn1j0XJAMi5AqQWQJQcYgU6f3gPsS+6wVXtYN8coOG9McYQPjna6K" +
       "NApeyyt8WL0Uq/1Ux3pGxjh6SAU1XL5h75CSc/7kyJ6BGzquuyBIgpmRAocc" +
       "Dk4O2dvQv6f9eI3bQ+Tqt+Lmdz84vHubavuKjNCTiphZnCjDDLdduOHpEudN" +
       "Ex7vempbDYd9BPhyJsDaAzc5xT1GhiuqTbl1lKUYBI6pelyQkZTCuIT16uqA" +
       "XcMNdhR/HwNmMZJYC7XPWqz8F6njNCzHmwaOduaSgoeNr7Zr9/3q1b9cyOFO" +
       "RZgKx9agnbJah1fDzqq4/xplm+0anVJo986etm/d+d7N67jNQouZuQaswbIe" +
       "vBmoEGC+6eimt0+e2P9GMG3nAUZGaLrKYLnTaDItJ5JIuY+cMOBse0rgGGXo" +
       "AQ2nZq0CJirFJKFbpri2Pq6YtejxM7dVmqYgQ03KkhYM3oFdf94ycv1LV/9r" +
       "Cu8mIGJgtmGzm5nefrTdc52uC5txHskbXqu++wXhPogb4KsNaQvl7pdwGAjX" +
       "22Iu/wW8vMhFuxiLWYbT/jOXmGMD1SXe/sbZ8o6zT5/js83cgTnV3SxotaaF" +
       "YTE7Cd2Pd/unlYLRC+0uOtKyvlI+8hH02Ak9iuCHjVYdfGUywzis1sOLfv3s" +
       "c+M2HCsgwUZSIqtCtFHg64yMAAOnRi+42aT2tUtN5Q4UQ1HJRSVZwmdVIMBT" +
       "c6uuIa4xDvaWH41/bOmBvSe4oWm8i+q0cZViN+fDY1jGZeReRFiez8t5WCxM" +
       "GWyhluiG7bzLWkt8OnTpNWi5ePx/AuzNuTC47wqZ+64UYVbOSFPXDV4L0Fyu" +
       "igmMLHy2TT6m04rFMk76Chb15sxrPyf8WFGnmYRJvLIQo2lGsOK5ke0vH3z9" +
       "4jcP3LF7wNxdzfUOEi6+Cf9plbu3//7DLDPm4SHHzs/F3xk+dO/E+ktOc37b" +
       "TyN3TTJ7BwCxzub90oPx94MzCn8eJEWdpFK0cpEOQU6g9+uE/beRSlAgX8mg" +
       "Z+6lzY1jbToOTXbHCMew7ghh7zzgHVvje7krKIxFvSyFJ2yZX9htzwHCX9bl" +
       "NukgvobArg2e8bjseoxPx4yMTsblNbogsSaFB7O0dsB852SZL1+wy1VYPpCq" +
       "RmkS0mX0svZy4/a5fjD7XJue4SSsLYRntTXDZg/RY7lFL+CiYwG5y/CYpAiy" +
       "S/yJqU5zdA5Lt2H5ioau5tblDV0ddZG1De2Zhwm4NWpPwHrlUcDMNNaXPv+M" +
       "8b0/PWquhRk5GrvSl4MHisXj8ef/YDKcl4PBbDf2YPgbHW9tfJkH92Lc8a1J" +
       "GYxjPwc7Q8fOolJDnz/Le0E6Jr73+zNfvW7vzN/xCFAsGWC20FmOnM3Bc/bQ" +
       "ydOvlVc/zDdKw3BO1nwyk93sXDYjReVTrbBcjqfDRCcVMH20aSVaSvkDPnbf" +
       "iMVGS+mfwl8Anv/ig8rGCvyFFV1v5WTT0kmZBslAoUyVHtZr+Hq1Nl2Kw36q" +
       "31JoeFvVyb57333IVKjbhbka0x27vv5p6LZd5vbFzPBnZiXZTh4zyzfVi8UW" +
       "VPF0v1E4R+OfD2978uC2m81ZVWXmqw1KIv7QLz95ObTnty/mSIkKQH/4j6HZ" +
       "8cIV5EbbOquXVYXiuk/RzJxIUkPp8xQgJrOUqpPqjCDTzE3E9tjvjNx56sc1" +
       "PcvySYawbsog6Q7+PxUwmeetYfdUXtj+14lrLundkEdeM9WlIXeXDzQfenHF" +
       "bHFnkB/ZmKEk66gnk6k2M4CU6JQldGVNRhiZqfEfw1wiWDRwo/HZT+z0oe3C" +
       "4pvgS0VUsmkTPs3v8txekBzqH5Pp+8wFsvyWip/eXlXQCFpvIsUJRdqUoE3R" +
       "TMmLjES3wxnaJ1E2DtZSwQUPufo8TXNsAnlU6vnsUYlnabPgudwKHJd7RKXv" +
       "2KjPz859vLgZCUrpILvA/zSiTpHi6KtMP+kSaV+eIl0Az3prUus9RDroK5IX" +
       "NyPFNNpDUaspwRZ9NsHQM6E7trJVh3QP5CkdZgSCNT/BQ7of+Ernxc0g9EmC" +
       "kafKWhJ43uwS6tE8hVoET8yaVsxDqJ/4CuXFzUi5Zn7noHWy1iukpFv42aRb" +
       "pqoyFdw6e9JHvKTDRaWnyf9wAzjHep/jmqYjTQmkpjgPpzhwoeicmcexHcbO" +
       "aq8zaR4392/ftTfaev+ioOXStjPIcVVtoUz7qewY3dyv35q9orZaM9/qVo+N" +
       "jZduvFh9PO4xH9rrWLzMyCRJgb0BBmJQrRyBXUL6W5RpxNtMZ8nfbwDr7lel" +
       "qK3EV76I/NKFVhnS5sNzoyXyjT5o5cjZizRd6ge7c+3uS3169AHqlA/tj1j8" +
       "hpEJNoiZCCL9TRutd4YArSqkTYFnpyXbzkFsqyETlhIfVh/Rz/rQ/o7FaUbK" +
       "eiiLqKIgt1jheZUNxZkhgKIaaTPhuduS5+78ofBi9RH3Ex/ap1h8CLkDQNGk" +
       "LEp5pek5vFJm+LaR+vcQIDUDaQvh2WeJuy9/pLxYvdEIlPnQRmJRxEgpINXg" +
       "2h/M9oHLsSlIYxYoHgLMpiMNnfgBS/AD+WPmxeqDyyQfWjUW4xipAMwuo7pC" +
       "ZTOgpXCb5YObueXAA1QbtvFDABu6Jr7fOmzJfjh/2LxYfaCZ50NbgMUsiN0A" +
       "Gz/XviIF2AwfwJoURnuobqM1eyjResIS+Yn80fJi9UFkiQ+tFouLHGhdiRUh" +
       "G4fFQ4UD7u+esYR5Jn8cvFh9ZG30oa3Eoo6REsBhjaBDeYULiGVDCcRRS5qj" +
       "+QPhxeojbLsPbS0WLU4g3BbROlTBHVfGMUuaY/kD4cXqI+wGH1o3FutMIJZL" +
       "/ZJhXfAZJMCbntdGa9Az8M+LVg08xy2Rj+ePlherDyKqD20TFhthew5oLZN4" +
       "DhmwM4lA31ChgGnxKUuUU/mj4MXqI+lWH9q1WAwwMiYdstdC7hDhJ8tXuCBJ" +
       "DiUkZyy5zuQPiRerj9i3+NBuxeLG3JBc6YLkpqFysSF43rfkej9/SLxYfcTe" +
       "7UPbg8UdjFQCJG25Tl78NirWcYsN2s4hAG000vCD2ceW5B8PAlqOIw0vVh9g" +
       "7vehHcBiHzgYhQ60OLKHSidWaQJH5rtDlScsISRQYPZp/uaFjCerj/SP+dB+" +
       "iMVhRiZgxHZ9wU1/le22YXnkC7k1wMhkv1tyeLdjQtZFXfNyqfjw3ori8XvX" +
       "vmV+TExdAC2LkOJYQpadX8od74WaTmMSh7fM/G7OT/YDT4PkXieVjBRAyYPR" +
       "U2brZ8ET5WoNLaF0tvyZZVvOlowM57/Odi/AFsFux0ih+eJs8gvoHZrg60ta" +
       "ynC/NsjtQ0lmVE9/3WtnghIV9Kh9+pQ0T0EnORXFjxTGDqbfNIvzrhd+CeP3" +
       "r1PfZRLmDewu8fDeVS3XnPvy/eZdM1EWtmzBXkojpMi89sY7xS9f0z17S/VV" +
       "uHLuRyMfGTErdcY6ypywvWYm2YZN6mCNaGhIE123sIya9GWst/cvffqVHYWv" +
       "BUlgHQkIjIxel31jI6kldFK9LpL91alD0Pn1sNq592y+ZEHsb8f5PSNifqWa" +
       "7N2+S3zjwFWv75ywf0qQlDaR4RJeguBXSZZvVlZTsV/vJOWS0ZCEKUIvkiBn" +
       "fNIaiTYv4EkQx8WCszxdizcVIQxkfx3Ovt9ZIqsDVF+mJpQodlMeIaV2jakZ" +
       "18fDhKa5GOwaS5VY3oPFliRqA8y3K9KsaamP6EX/1Lgb+HbaO1if9nglN/kT" +
       "/BXfTv4PXg9u1psxAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xRO5jZUpc0yupp4gL5uu3KguBNYeMVpD");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
