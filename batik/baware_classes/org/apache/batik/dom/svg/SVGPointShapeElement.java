package org.apache.batik.dom.svg;
public abstract class SVGPointShapeElement extends org.apache.batik.dom.svg.SVGGraphicsElement implements org.w3c.dom.svg.SVGAnimatedPoints {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGGraphicsElement.
                 xmlTraitInformation);
             t.put(null, SVG_POINTS_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_POINTS_VALUE));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedPoints
      points;
    protected SVGPointShapeElement() { super(); }
    public SVGPointShapeElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner) {
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
    private void initializeLiveAttributes() { points =
                                                createLiveAnimatedPoints(
                                                  null,
                                                  SVG_POINTS_ATTRIBUTE,
                                                  "");
    }
    public org.apache.batik.dom.svg.SVGOMAnimatedPoints getSVGOMAnimatedPoints() {
        return points;
    }
    public org.w3c.dom.svg.SVGPointList getPoints() {
        return points.
          getPoints(
            );
    }
    public org.w3c.dom.svg.SVGPointList getAnimatedPoints() {
        return points.
          getAnimatedPoints(
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
      ("H4sIAAAAAAAAAL1Ze2wcxRmfO79f8SMvNw8ndpy0dsIdFAJFTimOYydOzrEV" +
       "h0i1IZe9vTnfxnu7y+6cfUmaEhAt6UMoTZOQVsF/OaJQIBSVlj5AQYgGREEC" +
       "0gelkIqqaihFJapKq6ZAv2929/ZxdxulIj1p5/Zmvvlmvm9+32vu4fdIhaGT" +
       "NqqwCNujUSPSr7ARQTdosk8WDGM79MXF+8qEv+88v/XGMKkcI3PSgjEkCgYd" +
       "kKicNMbIUkkxmKCI1NhKaRJnjOjUoPqUwCRVGSPzJWMwo8mSKLEhNUmRYIeg" +
       "x0izwJguJbKMDloMGFkag51E+U6ivf7hnhipF1Vtj0Pe6iLvc40gZcZZy2Ck" +
       "KbZbmBKiWSbJ0ZhksJ6cTlZrqrxnQlZZhOZYZLe81lLB5tjaAhV0PNb4wcVD" +
       "6SaugrmCoqiMi2dso4YqT9FkjDQ6vf0yzRi3ky+TshipcxEz0hmzF43ColFY" +
       "1JbWoYLdN1Alm+lTuTjM5lSpibghRtq9TDRBFzIWmxG+Z+BQzSzZ+WSQdnle" +
       "WlPKAhGPro4euW9n0+NlpHGMNErKKG5HhE0wWGQMFEozCaobvckkTY6RZgUO" +
       "e5TqkiBLe62TbjGkCUVgWTh+Wy3YmdWoztd0dAXnCLLpWZGpel68FAeU9asi" +
       "JQsTIOsCR1ZTwgHsBwFrJdiYnhIAd9aU8klJSTKyzD8jL2PnFiCAqVUZytJq" +
       "fqlyRYAO0mJCRBaUiegoQE+ZANIKFQCoM7KoJFPUtSaIk8IEjSMifXQj5hBQ" +
       "1XBF4BRG5vvJOCc4pUW+U3Kdz3tb1927T9mkhEkI9pykooz7r4NJbb5J22iK" +
       "6hTswJxY3x07Jix46mCYECCe7yM2aX78pQs3r2k7/bxJs7gIzXBiNxVZXJxN" +
       "zHllSV/XjWW4jWpNNSQ8fI/k3MpGrJGenAYeZkGeIw5G7MHT237xxQMP0XfD" +
       "pHaQVIqqnM0AjppFNaNJMtU3UoXqAqPJQVJDlWQfHx8kVfAekxRq9g6nUgZl" +
       "g6Rc5l2VKv8NKkoBC1RRLbxLSkq13zWBpfl7TiOENMFDlsOzkpifFdgwsiua" +
       "VjM0KoiCIilqdERXUX4jCh4nAbpNRxOA+smooWZ1gGBU1SeiAuAgTa2BpJqJ" +
       "GlMApR0bR1TA6mha0Cg6BvS1iDTt/7BGDuWcOx0KwREs8TsAGWxnkyonqR4X" +
       "j2TX9194NP6iCS40CEtDjFwFy0bMZSN82QgsG4FlI8WWJaEQX20eLm8eNhzV" +
       "JBg9eN36rtHbNu862FEGKNOmy0HPYSDt8ESfPscz2O48Lp5qadjb/tY1z4ZJ" +
       "eYy0CCLLCjIGk159AtyUOGlZcn0C4pITHpa7wgPGNV0VaRK8U6kwYXGpVqeo" +
       "jv2MzHNxsIMXmmm0dOgoun9y+vj0nTvuuDpMwt6IgEtWgDPD6SPox/P+utPv" +
       "CYrxbbzn/Aenju1XHZ/gCTF2ZCyYiTJ0+PHgV09c7F4uPBF/an8nV3sN+Gwm" +
       "gI2BO2zzr+FxOT22+0ZZqkHglKpnBBmHbB3XsrSuTjs9HKjN/H0ewGIO2mAH" +
       "PD2WUfJvHF2gYbvQBDbizCcFDw+fH9Xu/+3L71zL1W1HkkZXCjBKWY/LeyGz" +
       "Fu6nmh3YbtcpBbo3j498++h794xzzALFimILdmLbB14LjhDU/JXnb3/93Fuz" +
       "Z8N5nIcYqdF0lYF502QuLycOkYYAOWHBVc6WwAHKwAGB03mLAhCVUpKQkCna" +
       "1n8aV17zxF/vbTKhIEOPjaQ1l2bg9H9qPTnw4s5/tnE2IREDsKM2h8z06nMd" +
       "zr26LuzBfeTufHXpd84I90N8AJ9sSHspd7OEq4Hwc1vL5b+at9f5xm7AZqXh" +
       "xr/XxFyJUlw8dPb9hh3vP32B79ababmPe0jQekyEYbMqB+wX+v3TJsFIA911" +
       "p7fe2iSfvggcx4CjCH7XGNbBR+Y84LCoK6p+98yzC3a9UkbCA6RWVoXkgMDt" +
       "jNQAwKmRBvea075ws3m409V2vMmRAuELOlDBy4ofXX9GY1zZe59c+MN1D8y8" +
       "xYGmcRZL8+CqQzbL4OmzwNVX3Iiw/TRvu7G5ygZspZZNQNruQ2ttAEPfuYYt" +
       "F4+/WyEH58JgfhUx8yt7YGXRCNObAK8F2tygilmMLHy3gwHQGcZmPR/6HDZ9" +
       "5s57/kf1Y0evZg4szgerJZ5gxWsgx18+9NoNv3rgW8emzSyqq3SQ8M1r/few" +
       "nLjr7X8VwJiHhyIZnm/+WPThE4v6bnqXz3f8NM7uzBVGfoh1ztzPPpT5R7ij" +
       "8rkwqRojTaJVc+wQ5Cx6vzHIsw27EIG6xDPuzZnNBLEnH4eW+GOEa1l/hHAy" +
       "DnhHanxv8AWF+Xgu6+DptuDX7cdziPCX8eKQDuNrBHBt8MrGh+t5AYwZmZvL" +
       "yNt1QWKDCg9m+dMB+H6mAL7cYDeoYD5QkiZpDspi9LKOuXF83nopfN7ijYdd" +
       "8Fxv7fD6EqKnTNGxWV0YZUrNRlvHRM6wRVoTlPMND/UqUgbTcp79GT6xJgLE" +
       "ygWczAAj1YJl887Z8E8jsdJy+9vvc0z7DNnbb8ftT18runft3TOGgKWlai1e" +
       "J87edWQmOXzyGtOWW7z1Sz+U54/8+sNfRo7/4YUiKXMNU7WrZDpFZdfuKnFJ" +
       "j/cY4mWoY4pvzjn8x590Tqy/nCwX+9oukcfi72UgRHdph+Tfypm7/rJo+03p" +
       "XZeRsC7zqdPP8sGhh1/YuEo8HOY1t+kjCmp176Qer2eo1SnL6sp2j39Y4TWS" +
       "q+HZYkFlS0C8K2EhpaYGhJ27A8a+is0djCyWFEg08aqE9spyTJqi+dstwwiM" +
       "FCO6lIGpU1YtH93fcm7yxPlHTFT6w4KPmB488vWPI/ceMRFq3o6sKLigcM8x" +
       "b0j41ptM5XwMnxA8H+GDcmEHfoPz77PK9OX5Ol3T0LDag7bFlxj486n9P/ve" +
       "/nvClp6mGSmfUqWk40UOfBLBm/fvy59yPY6thmfUOuXRAIAUSYiqNF2aAjF9" +
       "kaMugGMANk4EjM1gc5SRVgc3XtDg+DccbR27AtrCzJGshWfckm38EubUX5go" +
       "lpoaIPqDAWPfx2YWapIJykoEoklHKSevgFJacawdHtGSTLx8pZSaGiD4jwLG" +
       "nsTmBxB0QCkjnii+pEgY5BRYOjh6evxK6QkTlklL2MnL11OpqQG6eC5g7Aw2" +
       "pxlpBj0V4uanjj6euQL6QMiQG+HRLaH0S+ijSGwqNTVA5lcDxs5i8xL4GNCH" +
       "P7XNp6sJRy0vfyLlFCPzil0bYrHbWvAPhXmrLj4601i9cOaW3/C8KH/zXQ8Z" +
       "Tiory+7SwfVeqek0JXFJ681CQuNfvweJS2W3jJRBy/f+hkl9DvZbjBoooXVT" +
       "vg0Frp+SkQr+7ab7EyO1Dh1k3uaLm+Q8cAcSfH1Hs415dVBKvlEXtLQkGpY2" +
       "cyFX3mkdBj/D+Zc6w/wU90UXJiX8TyY7s8uafzPFxVMzm7fuu3D9SfOiTZSF" +
       "vXuRS12MVJl3fvnssL0kN5tX5aaui3Meq1lp5wTN5oYdu1jsAm8vBGQNQbPI" +
       "dwVldOZvol6fXff0SwcrX4X0Z5yEBCjixgvL1ZyWhbR8POYk5q4/KfndWE/X" +
       "d/fctCb1tzf4JQvBMsNzDeCnj4tnH7jttcOts21hUjdIKiSsAHkdvWGPso2K" +
       "U/oYaZCM/hxsEbhAdB8k1VlFuj1LB5MxMgfxLeD1CNeLpc6GfC9e0zLSUZjG" +
       "FV5u18rqNNXXq1kliWwaIJN3euwqwZNgZzXNN8HpyR/lvELZ4+KGrzX+/FBL" +
       "2QDYqEccN/sqI5vIJ+/uP8R4h5l1YvPNHJ4zGEE8NqRpdsJZucq64bpo0mA/" +
       "I6FuqxedTcjM1PDnR5zdh/wVmhD5LzNGvarrHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "J//PxJU/+rv/+zYFqhzzHQKVS+NF5POfeYr81j+oxp95yHL00/ntGxiIbs/G" +
       "1j7n/fHR81f/1RH0oAjdUI5D56XkpqXfEUG4GJ/E0yC8vtB/MfQ7xDkvne4A" +
       "77rsnc8te9k3n22c4LmELp+vXXLH7yi5/AFQXjzWnRcvK+MVqHrg76yPR+Xj" +
       "+4BSxlWAfqyUfw5+V0D5s7KUE5YNh0jmcfI4nHr2NJ4Kwb7+ttxzhUiykqFf" +
       "bSmnkgJ6+L7b9LAy1F4A7GA/9FUt11Sh9HVndlMp2vSNFG10cVd6AZTWMRta" +
       "d2HDt93FLCs2VLxdlBZaBiLxCf7vv1fMMhkTvuWVbKiil/gSDd/+hjRUa+ZX" +
       "gGN4oHarfQst37U7Y3lf+fjBshIAtG75knuC8jttV7l5IpolOFkB/t+03XbZ" +
       "TVzCafEXxgkY7KNn3oUNwCnm+/7bJ3/177/ny8CqGOiBrNR4YEznXBCXlge7" +
       "v/v5T737La/+zvdV2yxg7/Jvf/2pD5Wzem9IWVlZJ2Q9VZI1ryJWVoqTcbUt" +
       "ampJ2b2dCR9ZHgggsuNTC/LK4192PvN7P3E4kVz2HJeAtY+/+vf+/NYnXj06" +
       "dw58z21HsfNjDmfBCum3HnM4gp671yrVCOp/fOGVn/mxVz52wOrxi6eaPji0" +
       "/8Rv/umv3vr073zpDoH0/S6Qxl9asMn19w0a8ZA4+bGYqNV2Sj7z9Em7o+Pz" +
       "ccbtcF8N96gaD1WKYCjB8iabvTopov7SRC1sKGqdTPD13E/be7il6AtP6ptE" +
       "0lqMA0GcTJcxhUwkZjrszpeu3SSmG4Oe9fskamiuM9xuJcukGCkcbVsikdU6" +
       "tQ4i5mqeukMbC5uI6GWZ62VeB67XsrShq0NTogVuu92RXGov5vw8ahOzqaAG" +
       "sYOvevS43RmvKRjf9jMYxzNkTY9HjjKs83PD7juksVGdkaVwY3m4cJzcG5FD" +
       "jDNH0ozx7Ym9CPjtYkfOlvScL5jVeBfg3nzE9k1u4c02Q83IUavYMUbKyKNx" +
       "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");
}
