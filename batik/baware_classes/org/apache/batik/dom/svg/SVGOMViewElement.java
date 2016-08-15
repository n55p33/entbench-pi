package org.apache.batik.dom.svg;
public class SVGOMViewElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGViewElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_PRESERVE_ASPECT_RATIO_VALUE));
             t.put(null, SVG_VIEW_BOX_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      2);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                                    "xMidYMid meet");
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_ZOOM_AND_PAN_ATTRIBUTE,
                                    SVG_MAGNIFY_VALUE);
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected SVGOMViewElement() { super(
                                     ); }
    public SVGOMViewElement(java.lang.String prefix,
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
        externalResourcesRequired =
          createLiveAnimatedBoolean(
            null,
            SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
            false);
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
    }
    public java.lang.String getLocalName() {
        return SVG_VIEW_TAG;
    }
    public org.w3c.dom.svg.SVGStringList getViewTarget() {
        throw new java.lang.UnsupportedOperationException(
          "SVGViewElement.getViewTarget is not implemented");
    }
    public short getZoomAndPan() { return org.apache.batik.dom.svg.SVGZoomAndPanSupport.
                                     getZoomAndPan(
                                       this);
    }
    public void setZoomAndPan(short val) {
        org.apache.batik.dom.svg.SVGZoomAndPanSupport.
          setZoomAndPan(
            this,
            val);
    }
    public org.w3c.dom.svg.SVGAnimatedRect getViewBox() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFitToViewBox.getViewBox is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return preserveAspectRatio;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMViewElement(
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
      ("H4sIAAAAAAAAALVaC2wcxRmeO79f8SPO07HzctI8yF3CozR1eJwdmzg9P4iN" +
       "q9qAs96bszfe293sztkXU7eAqAiVeKUhSRFYRQoKjYCgCkorHkqVtjxbiUdL" +
       "aQVUpFJ5lJaoKlRNKf3/2d3bvb27Na5qSztez8z/z/zffPP//8z64Y9IkaGT" +
       "JqqwEDugUSPUrrBeQTdorE0WDKMf6obFowXC369/r3t7kBQPkgVjgtElCgbt" +
       "kKgcMwZJo6QYTFBEanRTGkOJXp0aVJ8QmKQqg2SRZHQmNFkSJdalxih2GBD0" +
       "KKkVGNOlkSSjnZYCRhqjMJMwn0k44m1uiZJKUdUOON2Xurq3uVqwZ8IZy2Ck" +
       "JrpPmBDCSSbJ4ahksJaUTjZrqnxgVFZZiKZYaJ98iQXB7uglWRCseaz6k/N3" +
       "jdVwCBYKiqIybp6xhxqqPEFjUVLt1LbLNGHsJ98iBVFS4erMSHPUHjQMg4Zh" +
       "UNtapxfMvooqyUSbys1htqZiTcQJMbI6U4km6ELCUtPL5wwaSpllOxcGa1el" +
       "rTWtzDLxns3hw0evr/lRAakeJNWS0ofTEWESDAYZBEBpYoTqRiQWo7FBUqvA" +
       "YvdRXRJkacpa6TpDGlUEloTlt2HByqRGdT6mgxWsI9imJ0Wm6mnz4pxQ1l9F" +
       "cVkYBVsXO7aaFnZgPRhYLsHE9LgAvLNECsclJcbISq9E2sbmr0EHEC1JUDam" +
       "pocqVASoIHUmRWRBGQ33AfWUUehapAIBdUaW51WKWGuCOC6M0mFkpKdfr9kE" +
       "vco4ECjCyCJvN64JVmm5Z5Vc6/NR9447blB2KUESgDnHqCjj/CtAqMkjtIfG" +
       "qU5hH5iClZuiR4TFzxwMEgKdF3k6m32e/Oa5Ky9oOv282achR5+ekX1UZMPi" +
       "8ZEFr6xo27i9AKdRqqmGhIufYTnfZb1WS0tKAw+zOK0RG0N24+k9v/zGjSfp" +
       "h0FS3kmKRVVOJoBHtaKa0CSZ6ldRheoCo7FOUkaVWBtv7yQl8B6VFGrW9sTj" +
       "BmWdpFDmVcUq/xsgioMKhKgc3iUlrtrvmsDG+HtKI4SUwEMa4dlAzJ/1WDBy" +
       "bXhMTdCwIAqKpKjhXl1F+40weJwRwHYsPAKsHw8balIHCoZVfTQsAA/GqNUQ" +
       "UxNhYwKoNHBVT9eARCfRKaCfRZZp86w/hfYtnAwEAPoV3o0vw57Zpcoxqg+L" +
       "h5Ot7eceHX7JJBVuBAsZRjbCkCFzyBAfMgRDhmDIkHdIEgjwkepxaHOBYXnG" +
       "YaODp63c2Hfd7r0H1xQAs7TJQsA2CF3XZEScNscb2C58WDxVVzW1+u1tZ4Kk" +
       "MErqBJElBRkDSEQfBdckjlu7t3IEYpETEla5QgLGMl0VaQw8Ur7QYGkpVSeo" +
       "jvWM1Ls02AELt2Y4f7jIOX9y+tjkTQPf3hokwcwogEMWgQND8V703Wkf3ezd" +
       "/bn0Vt/63ienjkyrjh/ICCt2NMySRBvWeLnghWdY3LRKeGL4melmDnsZ+Gkm" +
       "wL4CF9jkHSPDzbTYLhttKQWD46qeEGRssjEuZ2O6OunUcJLW8vd6oMUC3HdN" +
       "8AxZG5H/xtbFGpZLTFIjzzxW8JBwWZ92/+9+/f5FHG47elS7wn4fZS0uj4XK" +
       "6rhvqnVo269TCv3eOtb7vXs+unWIcxZ6rM01YDOWbeCpYAkB5u88v//Nd94+" +
       "/nowzfMAI2WarjLY1jSWStuJTaTKx04YcL0zJXB6MmhA4jRfowBFpbgkjMgU" +
       "99a/q9dte+Ivd9SYVJChxmbSBbMrcOqXtZIbX7r+0yauJiBi0HVgc7qZnnyh" +
       "ozmi68IBnEfqplcbv/+ccD/EBPDDhjRFuWslHAbC1+0Sbv9WXl7sabsUi3WG" +
       "m/+ZW8yVHA2Ld73+cdXAx8+e47PNzK7cy90laC0mw7BYnwL1S7z+aZdgjEG/" +
       "i093X1sjnz4PGgdBowj+1ujRwT+mMshh9S4q+f3Pzize+0oBCXaQclkVYh0C" +
       "32ekDAhOjTFwrSntiivNxZ0shaKGm0qyjM+qQIBX5l669oTGONhTP1ny+I4T" +
       "M29zomlcRWOaXBWopgEe0SKXmHsTYfklXm7CYotN2GItOQKpuoet5T4KPesa" +
       "tFw8/r0U8m5uDOZUITOnshvW5YwukRHwWoDmTlVMYmThs+30oU4PFq286StY" +
       "tJkzb/kf4ceKiGY2NPDKQoygGcGKn3scf3nytUt/c+LuI5Nm5rQxf5DwyC39" +
       "V488cvO7/8yiMQ8PObI6j/xg+OH7lrdd/iGXd/w0SjensqM+xDpH9sKTiX8E" +
       "1xT/IkhKBkmNaJ0zBgQ5id5vEHJrwz58wFkkoz0zTzaTwpZ0HFrhjRGuYb0R" +
       "wsk24B1743uVJygswnXZAc8Wi35bvHwOEP4ylJvSQXwNAa8Nfprx8LreRzEj" +
       "C1MJuV8XJNap8GCWXh2g74Ys+vINu1OF7QPH0BhNwVEYvayz3Tg/r52Nn9ek" +
       "Z4i7mLTDE7FmGMljejy36QXcdCzgXFIUlxRB9pi/3Ec55EGu8zlETDznUd22" +
       "f0ve5DCSQ8oDwugXB4EnBZfBc7U1z6vzgLDfBAGLzdmhNp80I8tgn1IdsMHD" +
       "KU+199D9SUmnsdlN5XlwRJESeERpVVWZCorHVH2OprbBM2BNdiCPqVO+puaT" +
       "Bj5r5r0MjRga7No9SGjbyO1fzMjebA0eg2/wMTjlTLw9PXH+U0ysc5f92xtg" +
       "TGccsKfbhNOdvEh0z9J1IMFg35jvJM1vAY7ffHgm1vPgNtNr12WeTtuVZOKR" +
       "3372cujYH1/IcTAqY6q2RaYTVHZNrRKHzIgTXfySwXG6by04dPanzaOtcznP" +
       "YF3TLCcW/HslGLEpf+jxTuW5mz9Y3n/52N45HE1WeuD0qvxh18MvXLVePBTk" +
       "NypmNMi6ickUasmMAeU6ZUld6c+IBGszt8dWeMYtnox7t4crs8mzN/KJ+iQY" +
       "R3zajmFxNyMNUtrVRWQ5KsH+sJ2gYfjmBL26lADRCeumJjxd9874fe89YrLS" +
       "mwB4OtODh7/7eeiOwyZDzbuvtVnXT24Z8/6LT73GBOdz+AnA8x980C6swN8Q" +
       "5tusS5hV6VsYTcONtdpvWnyIjj+fmn7qoelbgxZOtzFSOKFKMcdLHPp/pGm8" +
       "/vb0Kldi22Z4DGuVDR+C5Eh9SzRdmgAzPUGywkejDzce9Wl7DIsTjCx1eJNJ" +
       "Gmy/30HroXlAqw7b8LQ9bdk2Pct2as+EpdxH1Mf0p3zansHix4xUjlIWVUVB" +
       "7racw24HiifnAYpl2IZR5xbLnlvmDkU+UR9zn/dpexGLM4xUARQY1/oFHd7s" +
       "6NeYI/qZpys8Hzpg/XwewKq1eXOnZfGdcwcrn6gPIG/4tL2JxasmWIOqmogo" +
       "sV5BybxkxEDbl4TTpceJXti7VzzY3Psn0+MuyyFg9lv0UPj2gTf2vcwjZimG" +
       "6HSccoVnCOWuq60aLGZMYO91vf8A0nFjTNVZ2pqAld3opD5zBubgO2+rfvqu" +
       "uoIOyBw6SWlSkfYnaWcsM3qWGMkR15Scjw1OLLXmgy6ekcAmzTrncqq8Ng9U" +
       "4XcReKt+1Frvo3OnSj5RDx0sAPHPt7jWv/rw5WMs3ge+GG6+eHzuB/MACD/R" +
       "rYPnAcuqB+YOSD5RH3vP+7R9hsUnjJRbjqZVTdleZmUOL2OfA/bgp4o0Vp/O" +
       "A1absA31nbQMPjl3rPKJ5scjUO7TVolFESOLAascByEbt5APbvnEEMZA8TzA" +
       "iJ6afBWexy0sHp87jPlEfaBa5tPWgEU9IysAxvbZDt9rfMC0TtwOgIvmAcC1" +
       "NoBPWyg8PQuAOY4d+UR9QNrg04Zpa2AtI0sAwHy3LQkHleZ5QGUhtuH10RnL" +
       "tDNzRyWfqI/lPh8RAvgRIbAV0niFTnZD6LQZVONmULqBI7NtHpBZjW3b4XnR" +
       "Mu/FuSOTT9TH+p0+bR1YXAHHDeCL9z4zfUc54sBy5f/lDh2Q934nxq8bS7P+" +
       "DcX81wnx0Znq0iUz17zBr0fS/95QCdlWPCnL7rti13uxptO4xCGtNG+ONW5y" +
       "N1ib70aLkQIocd6BLrP31YzU5+oNPaF09+y3+OTuCdkc/+3u93WIqE4/RorN" +
       "F3eXQdAOXfB1SLPJmvurSPoazr7eMu/BGtxLwAPxrA4wLeL+pom3Evx/iOzE" +
       "M2n+F9GweGpmd/cN5778oPlNVZSFqSnUUgHppvl518p23ZcCXm22ruJdG88v" +
       "eKxsnX0pUGtO2NkNDa60JALJnIZ0We752mg0pz86vnl8x7O/Olj8apAEhkhA" +
       "YGThUPaXiZSW1EnjUDQ7rR4QdP4ZtGXjvQcuvyD+tz/w72nETMNX5O8/LL5+" +
       "4rrXDi093hQkFZ2kSMLLfv7JZOcBBfKiCX2QVElGewqmCFrAJ2fk7AuQ2QKe" +
       "1TguFpxV6Vr8Ig9hL/seJ/v/GMpldZLqrWpSiaEayPornBpzZTw3bElN8wg4" +
       "Na6Dy7tYzKRwNYCkw9EuTbPvhUo3aHyDn82Vep/lxOaZ9Fl8U/8Lr0C9LF8o" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UOAbN0GB+444/Lk9BT73zlPgm+eUfbtI");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/uiQApLvu7hXbImup8e3RWs/PIX6j28CdRkEUQS2fXGP+ovvDOoLJxX+pKzw" +
       "3XOg/9ci+Q6AHp2GfkZ7//QmUJbXys+C5+f3KH/+neft/zyn7I0i+W8xdOde" +
       "ugk/OxLtJ64j2keXmFwR73dMgL+4CQI8X2QW7V7dE+DVd5wAFy6dU3ZHkRzE" +
       "0EOAANe5mj0ixpVziHGjZgVtLtxyE7QpdB76fvB8dU+br77ztHnwnLKHi+Ry" +
       "DL0P0IZ6swv9p86h0P4W/4Qq990EVZ4+ospv7KnyG2+XKm/q5Fx4+pyyZ4vk" +
       "8Rh6GFDlRjEYqxOoT9wE1AeKzEfB87U91K+981DPCci7UATkXXgeOEWeljK+" +
       "qh3x+vJpXh8XlHArNwH3ySITA8/v7eH+3jsP9yPnlP1gkbSB2wY4ezbU6Dh8" +
       "aHGCFXtbcWqAbGejj4s4ykeu+eeGw4B85Zdfuff2h18R/l0ZgHscNH8HDd2u" +
       "J45zOnTr1PvFINR0s6TCHYeBXEEJrQtQ3Sg+JYZuAWkx4QvUYe1BDL37erVB" +
       "TZCerknvheF0TeAHlN+n67FgiTmpF0MXD19OV+FA76BK8ToLjiTt+hGGx0E1" +
       "R5vEw93kI6fFqlyZ7n8zDh03OR3cW+wNy/9MOdrHJYf/m/Ki8pVXhsyPfq/5" +
       "C4fBxYoj53nRy+00dOkwzrnstNgLPnnD3o76uth/7o17fuWOZ4/2rfccTvhE" +
       "xE/N7Ynrh/FSbhCXgbf5rz/81Q//g1e+WYbP/D/a2UAWMjQAAA==");
}
