package org.apache.batik.css.engine.value.css2;
public class UnicodeBidiManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_BIDI_OVERRIDE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BIDI_OVERRIDE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_EMBED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          EMBED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NORMAL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NORMAL_VALUE); }
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_UNICODE_BIDI_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public UnicodeBidiManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Ix+/dM8756RItm84PRGNPwc8YfbYdTBhDY7NgqfDtkPHyE2Yj7WAmU4XGHsW" +
       "m+/7TdgGucqpxqpFgY81qV11uRY6eR0sNA7HZsKzzVZz28gtlI+1gBV+VmDs" +
       "JWx+YlloNUvStGIV7I6Fbhy+XnXpheGevw6Gq8UxrFXjtvbxkRsuH2sB47xR" +
       "YOzX2JzlZCwYriUBuyUc+JlVV3a4xvjl/8IYGUiKuXd+eECdnPMXhHVtLj0z" +
       "WFU2aXDLeVEmZ6+2K6HsSaYVxXuE8ryX6AZLykK7SutApYuvdzhp+HxXk5wU" +
       "45dQ5LzF/B4ns4ZlhpNVXxZFNuMFTqYWYISTlfXi5fkD7KhD8UBShNZL+SEE" +
       "f5ASpBDfXrqPOKlw6WBR68VL8jHMDiT4ekl34ubW4Q3mosb2aCbkP35lUVQ7" +
       "HIo8J7Y5vjJV/JPl1HFp67+sLunU4Pq2e64sfdK6zpMUuns3zjIaqjfr0jB7" +
       "YJmVdzZnrpJ1866OPV0+1ykrfdeJXtkElmErEldvUwL3W2Z99prr3WPLX/zV" +
       "/pK3oCDeRkIUDgbbcq8OMnoaTorbYrlVKhzuxMVb47zHBlYuTP71PXE5Q3Ku" +
       "ZIL0XdK543e/fWjysbowGd1CRkHFzDLiTmP1gLqJSX1GJxkjm2syICL6jSq+" +
       "EngsxhjFLUTYxTbnmGwv3vNyMju3sM+9Ha9QtH5mNGlpNYHTQBE92u1xDq6+" +
       "M19a1wMMbo/nLJOx6gT0BkC2K9aq684laXG7LpLNwNCFA7afiVdsrv0XRfye" +
       "eeUeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+ws113f3Gv7Xts4vtd2XnUSx46vkzhL7+xzZheTNDP7" +
       "mtfOPuaxsxOKM+/3Y+exMztgCJFKIiJCBM4DCcwfJKJFeSAE6ksgV1WbICIk" +
       "qrSloCa0QiIFIsgf0KppS2dmf+/7MJYtVpqzs+ec7znfz/d8z+d895zzxe8A" +
       "98UR0AgDd2+4QXJTy5Obttu7mexDLb5JUL2FFMWaOnSlOGbLvOeVd/3atb/5" +
       "3qfM65eBKyLwmOT7QSIlVuDHKy0O3J2mUsC109yxq3lxAlynbGkngWliuSBl" +
       "xclzFPB9Z0QT4AZ1rAJYqgCWKoC1CiByWqsUeoPmp96wkpD8JN4CPwZcooAr" +
       "oVKplwBPnW8klCLJO2pmUSMoW7i/+s2XoGrhPAKePMF+wHwL4E83wBc/+8PX" +
       "f/0e4JoIXLN8plJHKZVIyk5E4CFP82QtihFV1VQReMTXNJXRIktyraLWWwQe" +
       "jS3Dl5I00k6MVGWmoRbVfZ5a7iGlwhalShJEJ/B0S3PV41/36a5klFjffIr1" +
       "gHBS5ZcAH7RKxSJdUrRjkXsdy1cT4J0XJU4w3iDLCqXoVU9LzOCkq3t9qcwA" +
       "Hj2MnSv5BsgkkeUbZdX7grTsJQEev2Ojla1DSXEkQ3s+Ad56sd7iUFTWeqA2" +
       "RCWSAG+6WK1uqRylxy+M0pnx+Q79g5/8ER/zL9c6q5riVvrfXwo9cUFopela" +
       "pPmKdhB86H3UZ6Q3/9bHLwNAWflNFyof6vzzH/3uB7//iZe/dqjzttvUmcu2" +
       "piTPK5+XH/79tw+fHdxTqXF/GMRWNfjnkNfuvzgqeS4Py5n35pMWq8Kbx4Uv" +
       "r/795iO/qv35ZeBBHLiiBG7qlX70iBJ4oeVq0VTztUhKNBUHHtB8dViX48DV" +
       "8p2yfO2QO9f1WEtw4F63zroS1L9LE+llE5WJrpbvlq8Hx++hlJj1ex4CAHC1" +
       "fICHyudp4PCpvxPABc3A00BJkXzLD8BFFFT4Y1DzE7m0rQnKpdc7YBykUemC" +
       "YBAZoFT6gakdFShxVdcodQJ3kptqVUYb5HxLCVQNtVRrJvmlY0Q3K68L/577" +
       "yyv817NLl8qheftFYnDLOYUFrqpFzysvpuj4u19+/ncvn0yUI8slwKBU4eZB" +
       "hZu1CjfLHm8eVLhZq1BltG/eqgJw6VLd8xsrVQ4OUQ6nUxJDSZkPPcv8Y+LD" +
       "H3/XPaUnhtm95VhUVcE7M/fwlErwmjCV0p+Blz+X/QT/483LwOXzFFypX2Y9" +
       "WIkvKuI8IcgbF6fe7dq99rFv/81XPvNCcDoJz3H6ETfcKlnN7XddNHQUKJpa" +
       "suVp8+97UvrN53/rhRuXgXtLwihJMpFKa5b888TFPs7N8eeO+bLCcl8JWA8i" +
       "T3KromOSezAxoyA7zak94OH6/ZHSxj8AHCXnZkFV+lhYpW88eEw1aBdQ1Hz8" +
       "fib8xT/4vf/Rqc19TN3XziyGjJY8d4Yuqsau1cTwyKkPsJGmlfX+6+cWP/fp" +
       "73zsQ7UDlDWevl2HN6p0WNJEOYSlmf/J17b/5Vvf/Pw3Lp86TVKul6nsWkp+" +
       "APm35edS+fy/6qnAVRmHqf7o8IhvnjwhnLDq+d2nupXU45bTsfKgG5zvBaql" +
       "W5LsapXH/p9rz7R+8y8+ef3gE26Zc+xS3//KDZzm/wMU+Mjv/vD/fKJu5pJS" +
       "LX2n9jutduDTx05bRqJI2ld65D/xH97x81+VfrFk5pINY6vQaoIDansA9QA2" +
       "a1s06hS8UNauknfGZyfC+bl2JkR5XvnUN/7qDfxf/fZ3a23Pxzhnx30mhc8d" +
       "XK1KnszL5t9ycdZjUmyW9bov0z903X35e2WLYtmiUrJcPI9KFsrPeclR7fuu" +
       "/uG/+bdv/vDv3wNcngAPuoGkTqR6wgEPlJ6uxWZJYHn4jz548Obs/jK5XkMF" +
       "bgF/cJC31r/uLRV89s5cM6lClNPp+tb/PXflj/73/3WLEWqWuc3KfEFeBL/4" +
       "C48PP/DntfzpdK+kn8hvZeYynDuVbf+q99eX33Xl310GrorAdeUoVuQr3i0n" +
       "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");
}
