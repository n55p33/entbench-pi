package org.apache.batik.extension;
public abstract class StylableExtensionElement extends org.apache.batik.extension.ExtensionElement implements org.apache.batik.css.engine.CSSStylableElement, org.w3c.dom.svg.SVGStylable {
    protected org.apache.batik.util.ParsedURL cssBase;
    protected org.apache.batik.css.engine.StyleMap computedStyleMap;
    protected StylableExtensionElement() { super(); }
    protected StylableExtensionElement(java.lang.String name, org.apache.batik.dom.AbstractDocument owner) {
        super(
          name,
          owner);
    }
    public org.apache.batik.css.engine.StyleMap getComputedStyleMap(java.lang.String pseudoElement) {
        return computedStyleMap;
    }
    public void setComputedStyleMap(java.lang.String pseudoElement,
                                    org.apache.batik.css.engine.StyleMap sm) {
        computedStyleMap =
          sm;
    }
    public java.lang.String getXMLId() { return getAttributeNS(
                                                  null,
                                                  "id"); }
    public java.lang.String getCSSClass() { return getAttributeNS(
                                                     null,
                                                     "class");
    }
    public org.apache.batik.util.ParsedURL getCSSBase() {
        if (cssBase ==
              null) {
            java.lang.String bu =
              getBaseURI(
                );
            if (bu ==
                  null) {
                return null;
            }
            cssBase =
              new org.apache.batik.util.ParsedURL(
                bu);
        }
        return cssBase;
    }
    public boolean isPseudoInstanceOf(java.lang.String pseudoClass) {
        if (pseudoClass.
              equals(
                "first-child")) {
            org.w3c.dom.Node n =
              getPreviousSibling(
                );
            while (n !=
                     null &&
                     n.
                     getNodeType(
                       ) !=
                     ELEMENT_NODE) {
                n =
                  n.
                    getPreviousSibling(
                      );
            }
            return n ==
              null;
        }
        return false;
    }
    public org.apache.batik.css.engine.StyleDeclarationProvider getOverrideStyleDeclarationProvider() {
        return null;
    }
    public org.w3c.dom.css.CSSStyleDeclaration getStyle() {
        throw new java.lang.UnsupportedOperationException(
          "Not implemented");
    }
    public org.w3c.dom.css.CSSValue getPresentationAttribute(java.lang.String name) {
        throw new java.lang.UnsupportedOperationException(
          "Not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedString getClassName() {
        throw new java.lang.UnsupportedOperationException(
          "Not implemented");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ML9WzIS/xtW7nVextuW/krT+bT8kAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+zr1n0f78++1/aN7Xtt5+HdxO/rtDbTHyVSFKU5TUJR" +
       "oiiJEiVSpESli8OnxDfFlyh1Xttga4wWyJLN6RK0NRogQR9Im2Bo1wJdB2/D" +
       "mhQNCnQNuq7AmqIb0HZdgPiPtsOyNTukfq/7uw83tTcB54g853sen+/5ns/5" +
       "nsPzxW9CF+MIgsPA3S7dIDk08uTQdvHDZBsa8WGfxcdKFBs65SpxPAVpL2pP" +
       "f/nKX337k6urB9ClBfSI4vtBoiRW4Me8EQduZugsdOU0teMaXpxAV1lbyRQk" +
       "TSwXYa04eYGF3namaAJdZ4+7gIAuIKALSNkFhDyVAoUeMPzUo4oSip/Ea+gf" +
       "QRdY6FKoFd1LoKdurCRUIsU7qmZcIgA13Fu8SwBUWTiPoCdPsO8x3wT40zDy" +
       "yr/4yNV/eRd0ZQFdsXyh6I4GOpGARhbQ/Z7hqUYUk7pu6AvoId8wdMGILMW1" +
       "dmW/F9DDsbX0lSSNjBMlFYlpaERlm6eau18rsEWplgTRCTzTMlz9+O2i6SpL" +
       "gPWdp1j3COkiHQC8bIGORaaiGcdF7nYsX0+gJ86XOMF4fQAEQNF7PCNZBSdN" +
       "3e0rIAF6eD92ruIvESGJLH8JRC8GKWglga7dttJC16GiOcrSeDGBHj0vN95n" +
       "Aan7SkUURRLoHefFyprAKF07N0pnxuebo/d/4gd9xj8o+6wbmlv0/15Q6PFz" +
       "hXjDNCLD14x9wfufZ39CeedvvHwAQUD4HeeE9zK/+g9f/9D7Hn/tq3uZd99C" +
       "hlNtQ0te1D6vPvi776Gea95VdOPeMIitYvBvQF6a//go54U8BDPvnSc1FpmH" +
       "x5mv8b8p//AvGH9xAF3uQZe0wE09YEcPaYEXWq4RdQ3fiJTE0HvQfYavU2V+" +
       "D7oHPLOWb+xTOdOMjaQH3e2WSZeC8h2oyARVFCq6BzxbvhkcP4dKsiqf8xCC" +
       "oKsgQNdA+D5o/3u+iBLIRFaBZyCKpviWHyDjKCjwx4jhJyrQ7QpRgdU7SByk" +
       "ETBBJIiWiALsYGUcZYBJY/gxwAiMaesqqmt0jlMKsgDVHBb2Fv5/aykvMF/d" +
       "XLgAhuM958nABfOICVzdiF7UXklbndd/6cXfPjiZHEfaSiAMNH64b/ywbPzw" +
       "pPHD2zUOXbhQtvn2ohP74QeD5wAaAAR5/3PCP+h/9OWn7wJ2F27uBpo/AKLI" +
       "7XmaOiWOXkmPGrBe6LXPbH5E+qHKAXRwI+EWHQdJl4vi44ImT+jw+vmJdqt6" +
       "r3z8z/7qSz/xUnA65W5g8CMmuLlkMZOfPq/iKNAMHXDjafXPP6n8you/8dL1" +
       "A+huQA+AEhMFmDBgm8fPt3HDjH7hmB0LLBcBYDOIPMUtso4p7XKyioLNaUo5" +
       "9g+Wzw8BHT9YmPh7QXj/kc2X/0XuI2ERv31vK8WgnUNRsu/3C+FP/8Hv/DlW" +
       "qvuYqK+cWfoEI3nhDDkUlV0paeChUxuYRoYB5P7LZ8b//NPf/PiHSwMAEs/c" +
       "qsHrRUwBUgBDCNT8T766/s/f+KPPf/3gxGguJNB9YRQkYN4Yen6Cs8iCHrgD" +
       "TtDge0+7BPjFBTUUhnNd9L1At0yrsOjCUP/3lWerv/I/PnF1bwouSDm2pPe9" +
       "cQWn6X+vBf3wb3/krx8vq7mgFevbqdpOxfak+chpzWQUKduiH/mP/MfHPvsV" +
       "5acB/QLKi62dUbIYVKoBKscNKfE/X8aH5/KqRfREfNb+b5xiZ/yQF7VPfv1b" +
       "D0jf+jevl7290ZE5O9xDJXxhb2FF9GQOqn/X+cnOKPEKyNVeG/3AVfe1b4Ma" +
       "F6BGDRBazEWAdvIbjONI+uI9f/hv//07P/q7d0EHNHTZDRSdVsp5Bt0HDNyI" +
       "V4Cx8vCDH9oP7ubeYzrPoZvAlwnXbp4B7SPLaN96BhTxU0X07M1Gdbui59R/" +
       "cERrxfs7gItYoiy8jMO9l3Gc8exN3KoH3iGpAnIBoNuBlhZsWvbrA3cY4XYR" +
       "NcsstIj+/h46/rfS0l720fKtcJifuz0R04W3dsplj/4vzlU/9if/8yZTKSn4" +
       "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" +
       "yr3velX8T+Wtt5N7rPex0L1m6rpnb1Gc");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("eb4URoZplWq6b3+nIiyxvyeBrt3+TiJwr0+eCwAX3r0v9UQCXT1fKoEulv9n" +
       "5Z4Ga86pXAJd2j+cFXk2ge4CIsXje0+uJcB3uCZ5Xlf5hTOO/5FtlSb58BuN" +
       "xkmRs7fmis1CeSH82LFP91fCX9S+9Gp/9IOv17+wv7UHCGG3K2q5l4Xu2V8g" +
       "LCstNgdP3ba247ouMc99+8Ev3/fs8UbmwX2HT+38TN+euPX9uI4XJuWNtt2v" +
       "veuX3/+zr/5ReSHh/wKDFHkxqS8AAA==");
}
