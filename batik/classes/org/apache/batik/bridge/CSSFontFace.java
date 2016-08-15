package org.apache.batik.bridge;
public class CSSFontFace extends org.apache.batik.bridge.FontFace implements org.apache.batik.util.SVGConstants {
    org.apache.batik.gvt.font.GVTFontFamily fontFamily = null;
    public CSSFontFace(java.util.List srcs, java.lang.String familyName, float unitsPerEm,
                       java.lang.String fontWeight,
                       java.lang.String fontStyle,
                       java.lang.String fontVariant,
                       java.lang.String fontStretch,
                       float slope,
                       java.lang.String panose1,
                       float ascent,
                       float descent,
                       float strikethroughPosition,
                       float strikethroughThickness,
                       float underlinePosition,
                       float underlineThickness,
                       float overlinePosition,
                       float overlineThickness) { super(srcs, familyName,
                                                        unitsPerEm,
                                                        fontWeight,
                                                        fontStyle,
                                                        fontVariant,
                                                        fontStretch,
                                                        slope,
                                                        panose1,
                                                        ascent,
                                                        descent,
                                                        strikethroughPosition,
                                                        strikethroughThickness,
                                                        underlinePosition,
                                                        underlineThickness,
                                                        overlinePosition,
                                                        overlineThickness);
    }
    protected CSSFontFace(java.lang.String familyName) { super(familyName);
    }
    public static org.apache.batik.bridge.CSSFontFace createCSSFontFace(org.apache.batik.css.engine.CSSEngine eng,
                                                                        org.apache.batik.css.engine.FontFaceRule ffr) {
        org.apache.batik.css.engine.StyleMap sm =
          ffr.
          getStyleMap(
            );
        java.lang.String familyName =
          getStringProp(
            sm,
            eng,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_FAMILY_INDEX);
        org.apache.batik.bridge.CSSFontFace ret =
          new org.apache.batik.bridge.CSSFontFace(
          familyName);
        org.apache.batik.css.engine.value.Value v;
        v =
          sm.
            getValue(
              org.apache.batik.css.engine.SVGCSSEngine.
                FONT_WEIGHT_INDEX);
        if (v !=
              null)
            ret.
              fontWeight =
              v.
                getCssText(
                  );
        v =
          sm.
            getValue(
              org.apache.batik.css.engine.SVGCSSEngine.
                FONT_STYLE_INDEX);
        if (v !=
              null)
            ret.
              fontStyle =
              v.
                getCssText(
                  );
        v =
          sm.
            getValue(
              org.apache.batik.css.engine.SVGCSSEngine.
                FONT_VARIANT_INDEX);
        if (v !=
              null)
            ret.
              fontVariant =
              v.
                getCssText(
                  );
        v =
          sm.
            getValue(
              org.apache.batik.css.engine.SVGCSSEngine.
                FONT_STRETCH_INDEX);
        if (v !=
              null)
            ret.
              fontStretch =
              v.
                getCssText(
                  );
        v =
          sm.
            getValue(
              org.apache.batik.css.engine.SVGCSSEngine.
                SRC_INDEX);
        org.apache.batik.util.ParsedURL base =
          ffr.
          getURL(
            );
        if (v !=
              null &&
              v !=
              org.apache.batik.css.engine.value.ValueConstants.
                NONE_VALUE) {
            if (v.
                  getCssValueType(
                    ) ==
                  org.w3c.dom.css.CSSValue.
                    CSS_PRIMITIVE_VALUE) {
                ret.
                  srcs =
                  new java.util.LinkedList(
                    );
                ret.
                  srcs.
                  add(
                    getSrcValue(
                      v,
                      base));
            }
            else
                if (v.
                      getCssValueType(
                        ) ==
                      org.w3c.dom.css.CSSValue.
                        CSS_VALUE_LIST) {
                    ret.
                      srcs =
                      new java.util.LinkedList(
                        );
                    for (int i =
                           0;
                         i <
                           v.
                           getLength(
                             );
                         i++) {
                        ret.
                          srcs.
                          add(
                            getSrcValue(
                              v.
                                item(
                                  i),
                              base));
                    }
                }
        }
        return ret;
    }
    public static java.lang.Object getSrcValue(org.apache.batik.css.engine.value.Value v,
                                               org.apache.batik.util.ParsedURL base) {
        if (v.
              getCssValueType(
                ) !=
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE)
            return null;
        if (v.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_URI) {
            if (base !=
                  null)
                return new org.apache.batik.util.ParsedURL(
                  base,
                  v.
                    getStringValue(
                      ));
            return new org.apache.batik.util.ParsedURL(
              v.
                getStringValue(
                  ));
        }
        if (v.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_STRING)
            return v.
              getStringValue(
                );
        return null;
    }
    public static java.lang.String getStringProp(org.apache.batik.css.engine.StyleMap sm,
                                                 org.apache.batik.css.engine.CSSEngine eng,
                                                 int pidx) {
        org.apache.batik.css.engine.value.Value v =
          sm.
          getValue(
            pidx);
        org.apache.batik.css.engine.value.ValueManager[] vms =
          eng.
          getValueManagers(
            );
        if (v ==
              null) {
            org.apache.batik.css.engine.value.ValueManager vm =
              vms[pidx];
            v =
              vm.
                getDefaultValue(
                  );
        }
        while (v.
                 getCssValueType(
                   ) ==
                 org.w3c.dom.css.CSSValue.
                   CSS_VALUE_LIST) {
            v =
              v.
                item(
                  0);
        }
        return v.
          getStringValue(
            );
    }
    public static float getFloatProp(org.apache.batik.css.engine.StyleMap sm,
                                     org.apache.batik.css.engine.CSSEngine eng,
                                     int pidx) {
        org.apache.batik.css.engine.value.Value v =
          sm.
          getValue(
            pidx);
        org.apache.batik.css.engine.value.ValueManager[] vms =
          eng.
          getValueManagers(
            );
        if (v ==
              null) {
            org.apache.batik.css.engine.value.ValueManager vm =
              vms[pidx];
            v =
              vm.
                getDefaultValue(
                  );
        }
        while (v.
                 getCssValueType(
                   ) ==
                 org.w3c.dom.css.CSSValue.
                   CSS_VALUE_LIST) {
            v =
              v.
                item(
                  0);
        }
        return v.
          getFloatValue(
            );
    }
    public org.apache.batik.gvt.font.GVTFontFamily getFontFamily(org.apache.batik.bridge.BridgeContext ctx) {
        if (fontFamily !=
              null)
            return fontFamily;
        fontFamily =
          super.
            getFontFamily(
              ctx);
        return fontFamily;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "B/VkJNBAIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6adDs2FVYv29m3sx7s7w3Yzwzntiz+Y2xp51Pre6WupWx" +
       "wZJ61dJSS70qgWdtLalb+9otMgEMxK5QsZ1k7DgVeyqpsisJGTBFQkGSghoK" +
       "EkygEky52Kpiu0hS2ICr8A+WwknIlfrb32IGTFfp9tXVuefes9xzzj33vva1" +
       "yn1RWKn6nr0zbC8+1Lfx4dpGDuOdr0eHFIPwchjpGmnLUTQBbTfV53/82h9/" +
       "46Pm9YPKZanyJtl1vViOLc+NBD3y7FTXmMq109aurTtRXLnOrOVUhpLYsiHG" +
       "iuKXmMqDZ7rGlRvM8RQgMAUITAEqpwDhp1Cg08O6mzhk0UN24yio/L3KJaZy" +
       "2VeL6cWV584j8eVQdo7Q8CUFAMMDxfsMEFV23oaVZ09o39N8C8Efq0Kv/NPv" +
       "vv4T91SuSZVrlisW01HBJGIwiFR5yNEdRQ8jXNN0Tao86uq6JuqhJdtWXs5b" +
       "qjwWWYYrx0monzCpaEx8PSzHPOXcQ2pBW5iosReekLeydFs7frtvZcsGoPXx" +
       "U1r3FPaKdkDgVQtMLFzJqn7c5d6N5Wpx5ZmLPU5ovEEDAND1fkePTe9kqHtd" +
       "GTRUHtvLzpZdAxLj0HINAHqfl4BR4spTd0Ra8NqX1Y1s6DfjypMX4fj9JwB1" +
       "pWRE0SWuvPkiWIkJSOmpC1I6I5+vjd7z4e9xB+5BOWdNV+1i/g+ATk9f6CTo" +
       "Kz3UXVXfd3zoRebj8uM/86GDSgUAv/kC8B7mp/7u19/37qdf/9we5m/cBoZT" +
       "1roa31Q/rTzy+beS78LuKabxgO9FViH8c5SX6s8ffXlp64OV9/gJxuLj4fHH" +
       "14X/svy+H9F//6BydVi5rHp24gA9elT1HN+y9bCvu3oox7o2rFzRXY0svw8r" +
       "94M6Y7n6vpVbrSI9Hlbutcumy175Dli0AigKFt0P6pa78o7rvhybZX3rVyqV" +
       "+8FTwcHzYmX/K//jygwyPUeHZFV2LdeD+NAr6I8g3Y0VwFsTUoDWb6DIS0Kg" +
       "gpAXGpAM9MDUjz4ooaUZOkSKYg+wpwf09LDQL/+vDfO2oOl6dukSYPdbLy52" +
       "G0ANPFvTw5vqKwnR/fqP3fzlgxPlP+JGXHk7GOxwP9hhOdjhfrDDM4NVLl0q" +
       "x/i2YtC9OIEwNmBZA4P30LvE76Le/6Hn7wF65Gf3Ak4eAFDoznaXPDUEw9Lc" +
       "qUAbK69/Ivv+2ffWDioH5w1oMVHQdLXozhdm78S83bi4cG6H99oHv/LHn/34" +
       "y97pEjpnkY9W9q09i5X5/EWWhp6qa8DWnaJ/8Vn5J2/+zMs3Dir3guUOTFws" +
       "A5UE1uPpi2OcW6EvHVu7gpb7AMErL3Rku/h0bKKuxmboZactpawfKeuPAh4/" +
       "WKjs4+CBj3S4/C++vskvym/b60YhtAtUlNb0vaL/qd/8b19tlOw+NrzXzrgy" +
       "UY9fOrPYC2TXymX96KkOTEJdB3D/4xP8P/nY1z74t0sFABBvv92AN4qSBIsc" +
       "iBCw+Yc+F/zWl7746S8cnCjNpRh4u0SxLXV7QmTRXrl6FyLBaO84nQ8wFjZY" +
       "VoXW3Ji6jqdZK0tWbL3Q0v9z7QX4J//gw9f3emCDlmM1evc3R3Da/hai8n2/" +
       "/N1/8nSJ5pJaOKtTnp2C7S3gm04x42Eo74p5bL//1972z35R/hSwpcB+RVau" +
       "lybp0ZIHj4JOz91h4QhyVnqGm+p/GH/585/KP/vanhRFBqavUr1TkHFrnFNo" +
       "9gt3WZ2n7ueP+n/r9a/+z9l3FUIquPXgiWCuFHJ4GDz1I8HUL2pfCfrmuPLI" +
       "WZOxZzpy/O16+a3wvod77wvIf9dd4rXQcoAypkc+Dnr5sS9tPvmVH937r4sO" +
       "8QKw/qFX/sGfH374lYMzUcPbb3HcZ/vsI4eS7of3dP85+F0Cz/8rnoLeomHv" +
       "OR4jj9zXsyf+y/e356R5m2mVQ/R+97Mv/6d//fIH92Q8dt5pdkFM+KO//n9/" +
       "5fATX/6l29husHA9ueRp6zbFe87XvklRUgqVlL5YlocFaaVa7qXfKYpnorN2" +
       "97yIzsSzN9WPfuEPH5794c9+vZz1+YD4rJlhZX/P40eK4tmCZU9cdDIDOTIB" +
       "XPP10d+5br/+DYBRAhhV4CgjLgTubXvOKB1B33f/b//czz/+/s/fUznoVa4C" +
       "NmnAkRX2vXIFGFY9MoFn3Prf+b69+mYPgOJ6SWrlFuLLhqdOdP+RovEtRxHE" +
       "cSRxG8tblM+V5Y2i+PZjK3fFD70YmAldu2DoHr4LzgtyubRHVgq4HE68i+Cm" +
       "RcGUn7pFwe7HHfyFiN/DPlm+3Xv39dkrgvlT1/jkn3G28oHf+dNbNKD06LdZ" +
       "shf6S9Brn3yK/I7fL/ufutai99PbW+MdsPE57Vv/EeePDp6//J8PKvdLlevq" +
       "0a5qJttJ4bAksJOIjrdaYOd17vv5XcE+BH7pJHR460WbcWbYi079dK2CegFd" +
       "1K9e8OMll2+A591Hkn/3RW26VCkrN2+vUHsRvzeuXF2VwZpj2btj+/rtt4R2" +
       "RhofFnCH/dmkdwJ/qq+lfrz/m+mHVA65vQSU+b76YeuwVrybt5/fPUX1ncC3" +
       "R+XesrBZlivbx7N+Ym2rN46N5wzsNYGC3Fjbp0bszLze+xeeF9DTR059C+OB" +
       "fd0P/6+P/spH3v4loExU5b60EDTQoTMOaJQUW92//9rH3vbgK1/+4TIsAQts" +
       "9oPfeOp9BdbgbtQVRbkzc47JeqogSyyjeUaOYraMJHStoKxEgZ2h5ztjEI+A" +
       "Kf6lqY2vtwfNaIgf/5iZpDeIKSxsoPokG+qiNtRxgxh7nZ3a04EPngl0e7wh" +
       "OktzMsFzxqGbySKqJ/okSTWtle9kZc75IRdTnFU3BRlfNcn2dGAljamszYJa" +
       "HsLszGvRo5mMovxsEi5omuM8Vwvnq7iNYFUEaw15MYtaalRf8ZCKNPJUw9Iq" +
       "ts3NJjKeevEmF4T1ciGZ3X6sMmlftxYTL+3WZwod5RO8TnPt2F6jaNWv6yOx" +
       "J/YsFh4izIyZRvPWjPT6oWZJDGrNp7ko9UN4SoSDvlJzYtlAqHWvB9epje9Q" +
       "MDWGZxthMQ9V1e8a26HkT6ZicyftbJKuiaiCi3zutcgJOcIoqd/ItHkynbEO" +
       "yup9MYfkcdwA+8v+QlyAqM4nUXQhBJOh5TgB1feW4WAed+15P/RQVs4DpptP" +
       "GGarpao5z5aKJ8w2gTxAM8znec2DpqqwYDcdYSTBWTtoYnKy9vtNuCeiTbQe" +
       "5IK/mHJVcRms/RHVybsmA/c2NdyL+8tebzD3VVqzsVE8E3cTfWWxQ23iiIO1" +
       "aZoS0tcskZan8cittde1jtmgnF276RqtMcNiQ5pWRt10ANsSC+lBNa4uuttg" +
       "iQrz2srfcjkVGVHXYme4NxkjQg32lDU2aq5HQrjktlXZCsRgk8u2g2Z2vzda" +
       "WpssRdn5oJtJMCeESeiRXJOKJMDtxN8ITLtLSKt2MJHXIsuuZZT1AorLcVUg" +
       "s7HXHznjDaX2NZ4W7FncMdZkc5iza7qu4GPS6XixqDlD13YCgRoZRmc8tGhL" +
       "HJm5T1RNP6sRcmCw+GSqOIgzp5P1cqPPxrLvccMdTmhhw+jNRhwydHF6mHMd" +
       "icom876dZF1PryK5lyzWi1jzUWYq0ksW29JB0oRqwRImxCXcVScwPTGIOmXB" +
       "y9AbzJj1Mo87Jt7Z5ji59XjXH9UQPQ58H3VsQq03OWcDd+qoyxLJrDPOFwMk" +
       "nMYLmGPrO6OhdWOiCUUbBG7N5RbmT4RovBS8fMD37PoANK9WG1tbrUSszWyW" +
       "XjK1lFC2PIqjgwUmi2YwmkQ+4cHUVFkv5mMU1qkYGtQWzljBApoSWMXzNwru" +
       "obuhTZvtoAbZ6bTXJec0SdMBmcq4q6FCJParAyzudofOeMnPxylPWsMqRCWC" +
       "oVpDNxgLorSsCRq7TmWZa9uRYHXMjjdKhB1BGqu1YKHiZjIk1kKu94dEx1h6" +
       "K5kZzjiqg42G8wYGEajl4g1cFtxMkppw3nfmMjtDpgQX6L2GUO/J6znQbtXx" +
       "+J0biyjms3yn0wyN4cSIWwti16eWDJnNSYjvZQ69jfrqdmpPunBuDHrbhUP0" +
       "Odaw486ChuVGiMFZS9ZydY4P61yb6IwlPKacRQPx1UZjRWpWpx33+2hk90IU" +
       "qw43Au0FArGxbXq67mlhZz4YCh3Ka8npzIAJxO1Osi7F41GHlXRvt57y7Z2k" +
       "DhWyZVdNA1alnaDmmeryYndtril3u921fIxtCQm01Em0XWM3yBBCkv7YN8lE" +
       "bXiJwJmcMG/SVRDrpC21ka4GTG1t1lEUmlcpjtmkwU6iu6O8i88IbJzT9Fai" +
       "O1mtGgdcL2jUUKE/dQxBI7J+RIdJl6EDmDO6krTbDAyz33QoYbbiJkGyJDmH" +
       "T1BOHaznbaiJ4MOYxhiqr/cURYl0qD2vrw29FuHzVXc+xWnXwBN0onIQ30K0" +
       "FjSE9cbGsn1+k1TdcDSduAgh4U2si4lINEKSKR7DYbURQCsooZyWluU402va" +
       "GRM7HYVwu9QENwMoViYw8BbbJBmsPXXHkZi1oYnJGO64fmdENteWT5P4JmSU" +
       "aWMMdUfbqYXLtIOMvVGb3mx6fXvo6+YSQrdalAYm1ljNSGHnsRyDy6O531fW" +
       "axWTBRSpYtWYdfJAGm7TPECjzO7Wei0zipFwbtPdlsVjeC3NeYiYYkOC5Ntj" +
       "1YLtTTr05hEGT/HqBAmT6jptTd1tsJtT7Vpu8pI3yGdRGPbt9XQ1WkbtGiJ2" +
       "YJ/fausGKpK7ethtzrdsHenzUd7Q6oNddbbY1KpVRlTY3aRH1Nh6m4NozADe" +
       "lm+vhGmzaRKqJnjaXDfwvrnNeC3xtjMZI4edVUddwik88LvbMPWgZu6zRk5x" +
       "4pSxu5oTUf2NuqtZ00xtKhIyg/qbrLHb6s5C5rURGiSQjocaXLNgxvMmdQEo" +
       "ClSt+umgs8l0XqQzK/FtqT+vZmu9VY+UcSwLeHUwJdruwJ2hK301jw263mTD" +
       "GdeZyGmWYg4LD4zcHpDLUdpKxqmwaCrT5ZLPml05S6GGEucNtdEbaPiSyyxE" +
       "tEeJKPWSKqOvcBv2qancNjoDZtVpGoQKu23OJSkEajZHXjbuE463rCeYKTm0" +
       "Xe+Q3Ki13fhzo6cJiIcyRn3u13uCawcIMCcLgmBzSc3myJDRlRXD2THaGAj1" +
       "OJsvMceNEWPF8W5N2whtYPWgdJVoUL0e7GpNi3M4SGsjEJ+F6wZZDYbOAtnO" +
       "em7qWoyvomSSJ7V5b5Z0cy5FUI3V11q12pzruyCbYWYcsQSaogsonan6qKrk" +
       "1bGnkYSNEkPGMHqQllKYwuYCxpstv240nWbaJBPNha1eezDvD+lWT1q6bogz" +
       "bY3vrsjxwm20x9WQyJE2RIqL7aLqYLSMKdFmbAX5QLLcBuqQWmyjO8HrJFkA" +
       "dgfVcBqoVXyZZc2diedht+bMhqa/QOhaME1cSO8vJrmQcLDEjs36BvfHCxP2" +
       "xmhW2w2EIRZPZSPpZsqiFbMCO9mqzjpIaGMjQlaEqxlMNig3WsmbbLHWnVUu" +
       "hRSmrvi1gea52ffz3mqAdV2HX7SnTcxFuWU2WEoKrBkqgk4SWlX8CDFEweMR" +
       "rhXg66zjpzNcJkcrJRTxlsQvLXzkdYgogOMGylc9nqiPW1N/p1jzNF9xfXWB" +
       "6U1Tq2JMA9idppam85HKdavElAB6B0UrBxPNPgS1sV2mttdeQ2iMh/kQ662T" +
       "3areUHy9savOGx2rRUk1LOr2LFdqtIxFg1q3uZG0wriN6ACzoim9Kt/pmgEZ" +
       "Jc0+bY8ZbsVR3SBY6RC2bcRb22mMeqNJbiQDKqrvMpgHdpZgHBJS4FVK1jKG" +
       "p4kIaBBJMiSHsQi73JA6mfk4HgqWJ0J9az4bjSkK3kS7PBx2ltUtO6J7XKbW" +
       "tfrEWyiQwVFZZHT5rWxu6nTOtZpIe9ddGxjRanQzWcQSXY7yRR9qbSEv720R" +
       "4ENkt9pOzO4KGuerhBPWK43TAgrFYmKtOYnb18VI91DbgeFedWJYWq2NRase" +
       "LKewltfhiI2zaswhVYta1uou18utVjbHUWGBuGLStGUtgUapmks6p3SS0bQq" +
       "kgYlkwwH+XxKsQjMILFJQqhJNfOWZ7VrWICBMCALxpE0D6uZI20JgxrJfHfI" +
       "c7U6MfL5IWT1IyLpewjfU7ZRJ6LbadaZjhdTvi4t2VEkzqQuxcZ0bQcvx0Zd" +
       "p1whdyMOE1R6OkkbA7fm2wtKwMzlsIXrWV2Fh+l8K9LctA3vFG6eQqPeMg03" +
       "jK5b6gTftqrKVK+pVL7WJDqt+zFb73eklmoa4aC9IreRx83MFryuD5qdlDVa" +
       "MZ7uiBq07QwsK2x6DQjDCDmvDet5ItHCzmGo6hRabjFkIg039eY2XIcKYa/p" +
       "ya5Rp4MWssyAk4EGRh9sacB+VYDQ+ThSPGnLBubcG8ur1bavNZYhoYcKxNSq" +
       "wK7NwnG7N5EXqKD2Ovy4NjLa+dSr9ZueqnFcYzeb6CjirjcMZa7jhFWq9Ybd" +
       "mmBrJFoPWEVF2pw6neVsPa0yzMCqGpGkZ7qECnRMLAkEiQfDBZzgYaulud3W" +
       "tqekJNvrDZWRGGIObfhsPoNNJIO2mkVo2xYU8Wir2XbbgcdY0JIfDfDJDFos" +
       "RC1ouYt8Y2IdYzDoVidbuMO20FobaU91EWI7RD2lJALFmo6mbpwJ1goCEhVp" +
       "YQrPElJPfdvcbCakrweiKW6ItI1mqhXxbEDmZISuRnxKQh4/BEE+qg+GOVPF" +
       "NAIjUN0VcTEV2hLVxp0uLjKdFogMl4rTre5yJxAFDSHXpuJpGcfWMNtsZ9NW" +
       "Pk1su9EGAbkrdEO4vtZmQoYlKOPWEWqV9EarYWT5o4lFL3aWJVEOClzxYu6F" +
       "uTroITaKaNAs5Q2MnHHjmZeOkpyE4IxHnTEeeSAWJpLmsjWTWVuPw+0OrfKD" +
       "VYvctvAlQs9rlrBlLZbRbNdhRMFI/bqYT1odI6anbgupt8K2ueUW4cZvt0kP" +
       "4nwuiur98crGqyt3HVotwIl4PB36M80nhECRQsdEU4Zqjau0V5XYGR3POdiv" +
       "k1Q2FSczrdabG3VyxvYFsEVeByGLsk0fxC/4ZJiaHRpKEmccLwaBYnOTur2V" +
       "euyIUrqtpj9R0o0HS4JFkDo6VKZ+xNVEa+xEOG/o68ZSMResNRt0uGbSUJxU" +
       "iIIgIbRWb1EloNmGGhH4cIzjRQrh5TeW2ni0zNicnK//JXI1+0/PFcULJ3mw" +
       "8ne5cuFM9mIGdJ+HvHSc4Hr+lgRXmQIWZ/2TixRFRvltdzphLxPwn/7AK69q" +
       "3Gfg41OO98WVK7Hn/01bT3X7zKjFbZIX75z9ZMsLBqcpyF/8wO89NfkO8/1v" +
       "4EDzmQvzvIjy37Cv/VL/Heo/Pqjcc5KQvOXqw/lOL51PQ14N9TgJ3cm5ZOTb" +
       "ToTwdMFzCDzdIyF030Bq++BUYfa6ciElfXB0NnwkuxdukZ0aRYe6a1huefbc" +
       "LWvH0O+8G/TxMbWQ2Ho59Mfukg3/50XxUaDHaqjLsX7mlPuCCv+jN5ImLxv+" +
       "4Qkj33Kc1f2BI0b+wF8fI2/N8p5hTZnpPCwT28fwz9x+0exPCacCU475mbtw" +
       "8N8Wxb+IKw8aeiyG6jnkZzKq+9T5KT//5V+Vn+8Az0eO+PmRbyE/79nbu2MS" +
       "btyNn2K8s3VWLgf9+O1SufdYblyO8lN34eDPFsVPxJWHCw6WJ5986JU4W6f8" +
       "+nd/BX49eax/nzzi1ye/9fwqXn+65ENR/McS9HN3Ifq/FsXPx5WHANG94tzy" +
       "mOb3nNL8C98KHXntiObX3gDN5VHaO29L7qXzPudWu3V0X4Yo/44uz5WYvnAX" +
       "bvxmUfz3vQqcP4nRTtnxq2/opA6syDPWrLiA8OQtFwD3l9bUH3v12gNPvDr9" +
       "jfLaysnFsitM5YEViL3OnludqV/2Q31llbO/sj/F8su/L8WVJ+7AlLhyeV8p" +
       "Z/vFPfzvADNxET6u3Ff+n4X733Hl6ikcQLWvnAX5ClhwAKSoftU/ltCzd5LQ" +
       "MWu2l8649SM9Kvn92Dfj90mXs7dcilCgvJB57LYT/uimxmdfpUbf83X0M/tb" +
       "Nqot53mB5QGmcv/+ws+J63/ujtiOcV0evOsbj/z4lReOw5RH9hM+1ekzc3vm" +
       "9ldauo4fl5dQ8p9+4t+/51+9+sXymOv/A6PuCwQpKwAA");
}
