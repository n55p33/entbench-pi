package org.apache.batik.css.engine.value.svg;
public class BaselineShiftManager extends org.apache.batik.css.engine.value.LengthManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_BASELINE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          BASELINE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SUB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          SUB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SUPER_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          SUPER_VALUE); }
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_BASELINE_SHIFT_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_BASELINE_SHIFT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 BASELINE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                java.lang.Object v =
                  values.
                  get(
                    lu.
                      getStringValue(
                        ).
                      toLowerCase(
                        ).
                      intern(
                        ));
                if (v ==
                      null) {
                    throw createInvalidIdentifierDOMException(
                            lu.
                              getStringValue(
                                ));
                }
                return (org.apache.batik.css.engine.value.Value)
                         v;
        }
        return super.
          createValue(
            lu,
            engine);
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (type !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        java.lang.Object v =
          values.
          get(
            value.
              toLowerCase(
                ).
              intern(
                ));
        if (v ==
              null) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return (org.apache.batik.css.engine.value.Value)
                 v;
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_PERCENTAGE) {
            sm.
              putLineHeightRelative(
                idx,
                true);
            int fsi =
              engine.
              getLineHeightIndex(
                );
            org.apache.batik.css.engine.CSSStylableElement parent;
            parent =
              (org.apache.batik.css.engine.CSSStylableElement)
                elt.
                getParentNode(
                  );
            if (parent ==
                  null) {
                parent =
                  elt;
            }
            org.apache.batik.css.engine.value.Value fs =
              engine.
              getComputedStyle(
                parent,
                pseudo,
                fsi);
            float fsv =
              fs.
              getFloatValue(
                );
            float v =
              value.
              getFloatValue(
                );
            return new org.apache.batik.css.engine.value.FloatValue(
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER,
              fsv *
                v /
                100.0F);
        }
        return super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            value);
    }
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public BaselineShiftManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "aCbLZu/QWvGKb+f+BweqAnBRIwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nEOClPJM+9l0Z7+2v3gLzt55HmpOdXseaE6WBPBeUBfvV85hyzsKL38APMgR" +
       "tiDnseUCVL58sGR5tixvFMV7yzF5IIIu+4EXAS11kOJdCsvcNAKaWK5sl529" +
       "AKrLNScsmd8aQfC9l6d9ngdiaQ9tRVktivY+IPA7Bs+LZZfZBYAxFyuHjUO0" +
       "+E3fQfni9W8VRbcoqGN137621RvHuCOC1BqEzY213TjW/1oZ8cUAHel5TskX" +
       "/p+VBBH96Ikw2gOp7cf/0ye/9mPv/gYIuyF0sXQGiLZTPY7jItv/kS986qk3" +
       "vfwnHy9BFSCq+I++8+QHC6mz12fqk4WpfJm50HIYMSX26Vpp7V1n2ySwHLBc" +
       "JEepLPLS9W9sfuabX9ynqeen1jli/WMv/5PvHn7i5YNTHwfvfk1+fppn/4FQ" +
       "Kv3mIw8H0LN366XkoP7zl1/6N//8pY/utbp+NtXtgi+5L/67v/na4af/5Ldv" +
       "k0M9aHv3MbDRtX6/Fg7ax380JpHLVM24eeQYC7YfNZRFlNTm/WQh7xiFaY7t" +
       "9TZfL0fIQmeqoalpS6ldYeSqv9VAuoLPcVyuSq7ApexQpbrtRW85qxDUbmCu" +
       "CYvp7jZdk7OXJDEYdB2C5Nu0s2HJbpcmuN1mIDQXLbRlqLtszjuKrWwrPhwg" +
       "2wQxEGSBBHDQ6deJLbprawIrcpPtJmdaW7fpUFuHzMUt1hGq7XqL1J14lASZ" +
       "zas9OrWEHbnydzaRT0cDp7JL8+F8zm6s+U52R1s+TFWJ3FF9hukx9U0mBCCX" +
       "k9nNQlAaYcOz+HxgoNSAIRfSdIDW5ZGu91wmyzCnNUkZh2e7Jt+t092xyfd1" +
       "eLSZajTKS1rTXOpNLGdJm7KrtMQKdrKK2U19zfK1IFRWYdPHm9NZQxjPxZ0w" +
       "pmo2K9Y1Wt9hnmTK1SzqTjlNyDmkGW8ih1sSKbfbblfeAvddxRlt/NouFYdN" +
       "LFbqCBnGklhn4s1oU3f0mlnHl7WG1ZRMlDND3FkHM6+Prmf5WFqEmDetVyUv" +
       "8Lpm0OVlDen6qDzuRRNml21WK3sby5XGsi1FdjZHI2UazpIei1YG/Uaw3dXV" +
       "zRZdZyPHETGCmXPTtslatZT0yJ0iDeT6QBKtrdjnt94o4+rmaoYudBmL8VwS" +
       "+iLj58t+rU/FOYOr6VRu+EuTw4jxjnFVFfW2Q3XecRbIdlMLtHaGurqxlR2n" +
       "1jMiIl14EtGZ8NQkZyXfwThMElwyHasrDm3QtSU5ILFhGNU4KwzHs9hGu32Z" +
       "JjRu2/HmvbS/mDX1dkR5HRABtbm4qsxCTvZbA50Nlzw+7BKxQwXkaL0liM4g" +
       "3diNTTdnCEqSezTJZ3nN6IzwBjz3MSvznIHUrmf8lKpLzbFAoITvoGE+TXtw" +
       "k7AUytSS+oTVqxLiEG1TMZvTeS4YSEQPyZaG9vtVDmRgM9NZerEUDSdkV+PX" +
       "cisKVlVsKoqjrhwF/mbXi2A31lZ2ikgDAcP7ZIdNGJJhOb9KeK0IbjFi0K8s" +
       "khVqtyY1e+D4NG2uYIy3/bmdic6C4WaS3WFnSWWz3jr+Yt3XhUpgTng8yFlP" +
       "47faOEuSId0VUU4Qst6OGKXZdDATKs1dBax2rTq2W0+sidwUpk5gDqbVNCCV" +
       "uYusJ7wgz1FlEHLWfLvbAv/mSxQbw8xU5YbtQJbmxKhpbBAG6w96cY9gmKZk" +
       "UZPUTOGU2M0EmZHa/niDi/1BLNUqbLbm2tWZuuPWw9xpY1Mqz0kL7ys4Uk2I" +
       "CTlIpd1g1o6ZsOMte8RCEakNNmR4ZtVXV1Gjk9R1dmjvYCzdttZL1RjUNyS1" +
       "3XFtkdlwxGpr2lNMGHTbM8nbipvBqDed971459B1glqhnea0RzK18RaV4wrt" +
       "BwamiuyIAcYkjClzWmIJIp4up0PYc31yHK0XYaOaV/P5cM1YPlMZJV1VFDqu" +
       "0un0BkN/qMPpuFpvdy0tDcNwJ3BCp9WTgu5s1enunJmg1yVZkVKpwiDDBdNk" +
       "BK/RqXJp4Fao0W4Ds9U1llWX9SA3LSHstLLakBa7E3ZqcOuOwfdCLVU73Nau" +
       "O5Vmrak6HItovhKvU4kfuCYnZZ5Z16a6Okh9dipa8FrY6XpVU6PlCO6gTM13" +
       "iNiSNlraEVsb3O1ZE9bnyXTrjvkxTXHZjhk13N6MVdR+3MUakoVWanWG9qfT" +
       "LskNOjUErHhIiBmISkttNNzYuVSzlgMh62+QZhq6MjfitpqA7eJmd4nSWN5C" +
       "OpFWzdIUbazWGzJLxjxZ1daVaZSSeEqSi2o12waGoSPGtKl0gnSV8jpZG2oi" +
       "oeMdusogJp0a48TodJzlQBX1lo83pmQtINqEJmZ1nw+VrDugUpPBOUS3R4G1" +
       "coeSP3N6NQNpSAlLMz7SQtVaZCumiPd7LYlBZl0lafq9poPRGFLH0lomzNbk" +
       "gs2ten0otRc4yyJML8VJYdQ14DjSF9UJQyZciyeWnDtrNWiOmdpts2l16NV8" +
       "2e/1ZKY5XA8r/XwaCDg8gRWd9x2O5mlVReQoz9AF464UAfbA93wr7W1b2EqX" +
       "qA1BrWOjMkCTNtzxJkRVgRfOdLmopbNeZSWZS4eFDa/GzqJdRE2Wms3NKZlE" +
       "eynb49r1Zl5fhFsnkKsNGKGpeozhwSDuj32qwck9L6e4mMUGYKnKmc5U0BMD" +
       "pki+hg/nzkomCHxDjnpWJxBINKIrDTXZLqjVplE1nEljEXvLSUIGxiwQNnOK" +
       "p8OlDXcpY96KmxswWGxznMF4S60Nt+hwKQr4jjDMOdIbD3ixgTiNpliZLboR" +
       "QYt8jUDGfaWWePMW3moukF49neqN2Oj3Y9PsRE2/gcmTZVKTG4NOk91IPo/y" +
       "/WUrmTJ5F86DmWyuBNkYrPxAGcN4QuBVy8fV6YRQ++165FbmxFKtMk5CMliy" +
       "VntGv805brs16fQVojIm+mnKNZWhGI7SWYP3Q8xc5+KC4v0slIndRsKYNjfL" +
       "hKRP8hz4PNmQcDgQMXu55KomJbkKRaY027Ej3OISUU3Mqi0NskRqKiRewWxs" +
       "sfOR3Ddmg5qe+EGQWzQ2XClVX3XYNrwQR7FJKBSC94NOljEdAav58aKrGLgV" +
       "tRF2MUBaLQpOwCSGsVlob30UD2LHHVV26kiqYXiVGlYbS6nbU2ksNQxZCaKo" +
       "hUT9KKy5kgfcs3W2YMq0sOF06S7qLmfO6stFgDRWKYwETOA4MwoNO2pbdo2e" +
       "YDa74SKQuJisxR2bntUts24a26WO1GVvnFlqbwyyPK+SJWy7rbbIdARTkpQn" +
       "7Tju9NQhFg8FeQEvKq3EHAYrLV2LmSkMvfF4vFErcGvG9AfUaodS4rCL15G1" +
       "JzaEHc/X/ems6UvbzqTX4CbSXGUb/qSqpQ04r07IWddM5wsj6YRSVEnoRYMC" +
       "q/U84aftTao3UmLStLk+ra26Kh/NrHGX0Od0owLyUbUFD7NdVjfNbh2ESqWP" +
       "rHGp1VM62ErJOn5O75p4y/XrQX9cndIBy2/DwTqsIJMGnThLo1rlyIqqwOqm" +
       "vt34lsNszXlj1Q6GMl4zuFkyFwS1YiDwPNoG43Di4vwcY20ZGYUGPqumVJBT" +
       "Od/Go4bQNzRUWspkzrHTbazlpEP2R+G0PsFpf4BqveqCS5pJ0hoZJFooHiOo" +
       "q9RUOV30kc2WCuXWSk1RVZtzubnz3ZGqyahB4f3xWOVHuDaareYpPRExJwla" +
       "ZNfPMJ9oiGGwHlfYXNDN2bCTzTZ5TVnZbcX3iOnQz4I2q/OVXUT7G3jAisvR" +
       "btUKGXo5bvTqBBxEjLrUhm3fjfBdq4n0jIYL/ihh2LLmroQa6xx1J+MgqhIW" +
       "EaYNitVJPFdBvgqvyPkSR9toxoiZ3+jW7Qgm2+pKXLvifBB6TbrrRHIYA+07" +
       "TI2Yjmq1yNxpq23dWU42tD0nY7M5YEbLZmvdzFHam6GhsGBHotJukEMU15Tq" +
       "FjUT0/VBbksonU1DxgS0acTAoe1Fh5z6ZOohTQvrI5bSdTxFHPg9R6vPZXrk" +
       "ywHTlzzRFjrbPuf63UqLzCi1s803Q6xe901lLPNh1Bun6LjFzmzfGY9HkjVZ" +
       "Igw/bDC2ifVZgm0sNTWlkKaaE4vaYjJkKqY/EYhGE4wXyY7iBB2L8+62JguJ" +
       "2HUyp9+gOnJiaZphpyD1aNR8sls3m2jEzi0MrATElIz8qmQG8tDoqDI7zmsI" +
       "vwJrgjzrpBYx2NTclayljtaHRzw5ntqwXhvzaHcmOqmuzhUvyJdDgZmESx1N" +
       "vabbo6YTrqpMGkxTjOZiCIutuDaRdn5ALydul0v64BNhOaUFoomIZq2Dm6E6" +
       "3NSn3YEoqsttk2JHQ1kZdL1JTxgsV51gEbSbs1rb4ZAUZMj8asRXMSudxCkx" +
       "mxkTGZ1oGr0m6lFQz+Bmi8SykdVqCr24PcOWuL9b670smejotDqnvHmzIy1b" +
       "uY7PaKlueSsZBub7Uxzddi1vNx9GNZzLeVse9OExu3MHywqMDRY1mdvU1lgt" +
       "nhFIvaVYptE1I4mOp+Z2zbdtnuzDOrzB2ZFdxecEhzdFGjWdvJ06sBa77NjL" +
       "xh1RVY2kxyhq3LQX7bkOPk0UulPZCvlAzedota/qlI2M3el4nSd+DBI5tj9O" +
       "cX2yGKoZjCaraEBGlQZV0aWOqnVxOAbfpVzCrQM6jxWG0pwdHrHOEPbnLKuB" +
       "lEWlg0pOritUYq0TeLXs0RrNNtQhAre2FJYj2MaAOYztu8kQoMFO2mnZQp/p" +
       "AuZuyFmj1lz0a1x11u0YzYmcxK64Q4ZJdUU3pxFDOjicVvkhLqw7WDXLHJTu" +
       "uPPuTs/gGQhSFQC8jevKMBIjgfCq3MZZKxPFns74JSfLowaeays6ppf+gI/H" +
       "q3S8kvDmEsQ4VqXG6Zpy4f6WmlfIHhdj7jAgZZ1EJ1EShXwqxFQ+whfbdqpX" +
       "MmFpR9VNsJDbWIqhXHM61rUg7+W4O+VkUqGlGJnOk95IgQ2YSPVt2yW4Qdpu" +
       "F1sKxuvb1Xms3MC6dbq6thtFw/R17Gbsm54tiudvbRaWf5fuchBxarMWKnZo" +
       "nrrToWm5O/OZj7z8isZ+Fjs42uSWI+hy5Pl/29YT3T4l6gqQ9L4770Qx5Znx" +
       "yebrVz7yX54UPrD60Os4XnrXOT3Pi/w884Xf7r1H/fED6IFbW7GvOc0+y/Ti" +
       "2Q3YK4EexYErnNmGfeqWZx8vPPYe8Lz/yLPvv/0Rz22j4EIZBfuxv8sZwg/e" +
       "pe2HiiKNoMetcOCu9MCKdG0SeOX9gJLh+04FzIci6CHF82xddk+CKbvX1tjp" +
       "LsuK6Kz17wUPeWQ9+cZb//G7tP3ToviRCHqLFbZdy5Gj4vDn2Pyi7cMndn70" +
       "fu18HjzDIzuHb7ydP3WXtp8uih+PoOtWcVmk3Cq9g5U/cR9WXi0qnwbP9MjK" +
       "6Rtv5T+7S9tni+KVCLpq6tGxebfOVs/F8QPW0S2e0uqfuw+rrxeVz4JncWT1" +
       "4o23+hfv0vZLRfHFs1aPj/BnemLil+7DxHIJeAY8N49MvPnGm/ird2l7tSj+" +
       "1d7Ejm7Isb0/Mjs+lnnvvY+VTuhLb/zr+/XGO8FjHHnDeGO8cVASHBwb9Y7C" +
       "qLSqlraEsnpI6+C7UrZnrhUd0zx/N8NJnu+Wb2VvXzvX24WjWxxHkp447k3z" +
       "nMMOy3QzVfeLxbNk/v2i+EoEvUkNdDnSS2cWVb9+4tGv3q9HnwPP7sijuzfG" +
       "ow/sc6Xbzf+L4coLyisBZXL0uyX/12/vo+LnH5QEf1YUfwTSrL0f9meAt/PG" +
       "H9+vN54Cz48eeeNH3xhvXCoJLh2P+OE9YoePdnaxHBb3KHX3lKuK4nPHUm7c" +
       "TUohQj86yv31Uqdv3WWW/7ei+GZU3ER0/Pj2Ufbn9wvUBYp9/sivn3+9fu3c" +
       "E8X+5i5t3y2Kv46gRwGKsYEFfCof37r53ImF//P1WJiB1OV2d7mKyyhPvOZ2" +
       "6f5GpPqlV64+/PZXZv++vM5069biZRp62Iht+/TdgVPvl/xAN6zSjsv7mwR+" +
       "8e/CpXuA0K07Z2DJBWVhwYWLe9bLEfTsPVmjo6Pw04yPHIHjHRgj6NL+5TTP" +
       "VeCp2/EAtUB5mvJ6BF07Twm0KP+fpgPBf+WEDnS6fzlN8gSQDkiK1+/xj2cM" +
       "cm930eBXtDoay2yP0U+cDuoyUq7fK1JOfY+9+8xXVHk9+fiLJ95fUL6pfvmV" +
       "4fgHvo1/dn9dTLXlPC+kPExDD+1vrpVC");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("i6+mZ+8o7VjWpf4L33n0Fy4/f/yF9+he4ZMJdkq3d93+PlbX8aPyBlX+L9/+" +
       "S+//3CtfL288/F98lesSNy4AAA==");
}
