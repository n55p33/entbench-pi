package org.apache.batik.css.engine.value.css2;
public class SrcManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_NONE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NONE_VALUE); }
    public SrcManager() { super(); }
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_FONT_DESCRIPTOR_SRC_VALUE;
    }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_SRC_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NONE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.ValueConstants.
                                                             INHERIT_VALUE;
                                                default:
                                                    throw createInvalidLexicalUnitDOMException(
                                                            lu.
                                                              getLexicalUnitType(
                                                                ));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_STRING_VALUE:
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_URI:
                                            }
                                            org.apache.batik.css.engine.value.ListValue result =
                                              new org.apache.batik.css.engine.value.ListValue(
                                              );
                                            for (;
                                                 ;
                                                 ) {
                                                switch (lu.
                                                          getLexicalUnitType(
                                                            )) {
                                                    case org.w3c.css.sac.LexicalUnit.
                                                           SAC_STRING_VALUE:
                                                        result.
                                                          append(
                                                            new org.apache.batik.css.engine.value.StringValue(
                                                              org.w3c.dom.css.CSSPrimitiveValue.
                                                                CSS_STRING,
                                                              lu.
                                                                getStringValue(
                                                                  )));
                                                        lu =
                                                          lu.
                                                            getNextLexicalUnit(
                                                              );
                                                        break;
                                                    case org.w3c.css.sac.LexicalUnit.
                                                           SAC_URI:
                                                        java.lang.String uri =
                                                          resolveURI(
                                                            engine.
                                                              getCSSBaseURI(
                                                                ),
                                                            lu.
                                                              getStringValue(
                                                                ));
                                                        result.
                                                          append(
                                                            new org.apache.batik.css.engine.value.URIValue(
                                                              lu.
                                                                getStringValue(
                                                                  ),
                                                              uri));
                                                        lu =
                                                          lu.
                                                            getNextLexicalUnit(
                                                              );
                                                        if (lu !=
                                                              null &&
                                                              lu.
                                                              getLexicalUnitType(
                                                                ) ==
                                                              org.w3c.css.sac.LexicalUnit.
                                                                SAC_FUNCTION) {
                                                            if (!lu.
                                                                  getFunctionName(
                                                                    ).
                                                                  equalsIgnoreCase(
                                                                    "format")) {
                                                                break;
                                                            }
                                                            lu =
                                                              lu.
                                                                getNextLexicalUnit(
                                                                  );
                                                        }
                                                        break;
                                                    case org.w3c.css.sac.LexicalUnit.
                                                           SAC_IDENT:
                                                        java.lang.StringBuffer sb =
                                                          new java.lang.StringBuffer(
                                                          lu.
                                                            getStringValue(
                                                              ));
                                                        lu =
                                                          lu.
                                                            getNextLexicalUnit(
                                                              );
                                                        if (lu !=
                                                              null &&
                                                              lu.
                                                              getLexicalUnitType(
                                                                ) ==
                                                              org.w3c.css.sac.LexicalUnit.
                                                                SAC_IDENT) {
                                                            do  {
                                                                sb.
                                                                  append(
                                                                    ' ');
                                                                sb.
                                                                  append(
                                                                    lu.
                                                                      getStringValue(
                                                                        ));
                                                                lu =
                                                                  lu.
                                                                    getNextLexicalUnit(
                                                                      );
                                                            }while(lu !=
                                                                     null &&
                                                                     lu.
                                                                     getLexicalUnitType(
                                                                       ) ==
                                                                     org.w3c.css.sac.LexicalUnit.
                                                                       SAC_IDENT); 
                                                            result.
                                                              append(
                                                                new org.apache.batik.css.engine.value.StringValue(
                                                                  org.w3c.dom.css.CSSPrimitiveValue.
                                                                    CSS_STRING,
                                                                  sb.
                                                                    toString(
                                                                      )));
                                                        }
                                                        else {
                                                            java.lang.String id =
                                                              sb.
                                                              toString(
                                                                );
                                                            java.lang.String s =
                                                              id.
                                                              toLowerCase(
                                                                ).
                                                              intern(
                                                                );
                                                            org.apache.batik.css.engine.value.Value v =
                                                              (org.apache.batik.css.engine.value.Value)
                                                                values.
                                                                get(
                                                                  s);
                                                            result.
                                                              append(
                                                                v !=
                                                                  null
                                                                  ? v
                                                                  : new org.apache.batik.css.engine.value.StringValue(
                                                                  org.w3c.dom.css.CSSPrimitiveValue.
                                                                    CSS_STRING,
                                                                  id));
                                                        }
                                                        break;
                                                }
                                                if (lu ==
                                                      null) {
                                                    return result;
                                                }
                                                if (lu.
                                                      getLexicalUnitType(
                                                        ) !=
                                                      org.w3c.css.sac.LexicalUnit.
                                                        SAC_OPERATOR_COMMA) {
                                                    throw createInvalidLexicalUnitDOMException(
                                                            lu.
                                                              getLexicalUnitType(
                                                                ));
                                                }
                                                lu =
                                                  lu.
                                                    getNextLexicalUnit(
                                                      );
                                                if (lu ==
                                                      null) {
                                                    throw createMalformedLexicalUnitDOMException(
                                                            );
                                                }
                                            }
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze2wcxRmfOzt+x688cRLn5STK644YKCDTgOPYxOk5seIQ" +
       "qQ7Emdubszfe293sztnn0JSHSpNWJQohhIcg6h9B0DSQCBX1QaGJohYoFAlI" +
       "S2kLtKVSU1JaorZQkQL9vtnd28c9jKW6J+3c3sz3zcz3m+85d+J9MsU0SDNT" +
       "eYSP6cyMdKq8lxomS3Qo1DS3Qt+AdH8J/ceO85uuDZOyflI7RM0eiZqsS2ZK" +
       "wuwn82TV5FSVmLmJsQRy9BrMZMYI5bKm9pMZstmd0hVZknmPlmBIsI0aMdJA" +
       "OTfkeJqzbnsCTubFYCdRsZNoe3C4LUZqJE0fc8lne8g7PCNImXLXMjmpj+2i" +
       "IzSa5rISjckmb8sYZKWuKWODisYjLMMju5SrbAg2xq7KgWDRqboPLx0cqhcQ" +
       "TKOqqnEhnrmFmZoywhIxUuf2diosZe4mXyUlMVLtIeakJeYsGoVFo7CoI61L" +
       "BbufytR0qkMT4nBnpjJdwg1xstA/iU4NmrKn6RV7hhkquC27YAZpF2SltaTM" +
       "EfG+ldHD9++of6qE1PWTOlntw+1IsAkOi/QDoCwVZ4bZnkiwRD9pUOGw+5gh" +
       "U0XeY590oykPqpSn4fgdWLAzrTNDrOliBecIshlpiWtGVrykUCj715SkQgdB" +
       "1pmurJaEXdgPAlbJsDEjSUHvbJbSYVlNcDI/yJGVseVLQACs5SnGh7TsUqUq" +
       "hQ7SaKmIQtXBaB+onjoIpFM0UECDk6aCkyLWOpWG6SAbQI0M0PVaQ0BVKYBA" +
       "Fk5mBMnETHBKTYFT8pzP+5uuO3CrukENkxDsOcEkBfdfDUzNAaYtLMkMBnZg" +
       "MdasiB2hM5/dHyYEiGcEiC2a73/l4g2rmk+/YNHMyUOzOb6LSXxAOhavfXVu" +
       "x/JrS3AbFbpmynj4PsmFlfXaI20ZHTzMzOyMOBhxBk9v+dmXbz/OLoRJVTcp" +
       "kzQlnQI9apC0lC4rzLiRqcygnCW6SSVTEx1ivJuUw3tMVpnVuzmZNBnvJqWK" +
       "6CrTxG+AKAlTIERV8C6rSc151ykfEu8ZnRBSDg+pgWc1sT7im5NEdEhLsSiV" +
       "qCqrWrTX0FB+MwoeJw7YDkXjoPXDUVNLG6CCUc0YjFLQgyFmD0gm0g7CnqIj" +
       "VEkz7GiN9hlSD1VBIYwIapv+f1ong/JOGw2F4CjmBh2BAja0QVMSzBiQDqfX" +
       "dV58cuAlS8nQMGykOFkDS0espSNi6QisFLGWjoilsaM14i5NQiGx4nTcgnXw" +
       "cGzD4ADAA9cs77tl4879i0pA4/TRUsAcSRf5IlGH6yUc1z4gnWycumfh22vO" +
       "hklpjDRSiaepgoGl3RgElyUN21ZdE4cY5YaKBZ5QgTHO0CSWAE9VKGTYs1Ro" +
       "I8zAfk6me2ZwAhmabLRwGMm7f3L6gdE7tt12eZiE/dEBl5wCjg3Ze9GnZ313" +
       "S9Ar5Ju3bt/5D08e2au5/sEXbpwomcOJMiwK6kQQngFpxQL69MCze1sE7JXg" +
       "vzmFgwfX2Bxcw+d+2hxXjrJUgMBJzUhRBYccjKv4kKGNuj1CWRvE+3RQi2q0" +
       "xxnwXGMbqPjG0Zk6trMs5UY9C0ghQsUX+/RHfv3KX64QcDtRpc6TDvQx3ubx" +
       "ZDhZo/BZDa7abjUYA7q3Hui99773920XOgsUi/Mt2IJtB3gwOEKA+a4Xdr/5" +
       "ztvHzoVdPecQytNxyIgyWSGxn1QVERJWW+ruBzyhAl4CtablJhX0U07KNK4w" +
       "NKz/1C1Z8/RfD9RbeqBAj6NGq8afwO2/bB25/aUdHzWLaUISRmIXM5fMcu/T" +
       "3JnbDYOO4T4yd7w278Hn6SMQKMA5m/IeJvwtERgQcWhXCfkvF+2VgbGrsVli" +
       "epXfb1+ejGlAOnjug6nbPnjuotitP+XynnUP1dss9cJmaQamnxV0ThuoOQR0" +
       "V57edHO9cvoSzNgPM0rgfM3NBjjJjE8zbOop5b85c3bmzldLSLiLVCkaTXRR" +
       "YWSkErSbmUPgXzP69TdYhztaAU29EJXkCJ/TgQDPz390nSmdC7D3/GDW9657" +
       "7OjbQst0a445Wa861+dVReLuGvbx16/+5WP3HBm1Qv/ywt4swDf7481K/M4/" +
       "/jsHcuHH8qQlAf7+6ImHmzrWXhD8rkNB7pZMbpgCp+zyth5P/Su8qOynYVLe" +
       "T+olO1HehkEIzLQfkkPTyZ4hmfaN+xM9K6tpyzrMuUFn5lk26Mrc8AjvSI3v" +
       "UwPeaw4e4Vp4Wm3Dbg16rxARL92CZZloV2CzWhxfCSeVuqFx2CWD5LbMFFk5" +
       "h53IKlUCDqSpyDrAK4K0KVhmc7Jy/HhupcGg3paHxfYabDZa67bl02draBk2" +
       "K7O7E5+yYJLldW+uwhK0ynmF8mCRwx+78/DRxOZH11gq2+jPLTuhdHriV5+8" +
       "HHng9y/mSWMquaavVtgIUzxrVuCSPiPpESWCq3Fv1R5694ctg+smknVgX/M4" +
       "eQX+ng9CrChsd8GtPH/ne01b1w7tnEACMT8AZ3DK7/ScePHGpdKhsKiHLFPI" +
       "qaP8TG1+A6gyGBR+6lafGSzOKsA0PNil8FxvK8D1+YN4Ht3JhsZCrEWCyGCR" +
       "MRmbOCfTZLNbHYJKFgwM8h5RrPozUTznvnTchKxRTkGSMGIXVq29O6X9Lb1/" +
       "stTwsjwMFt2Mx6N3b3tj18viwCpQQ7IwebQDNMmT/9Rb8n8GnxA8n+KDW8cO" +
       "/AY31mFXSQuyZRJ6/qIuPCBAdG/jO8MPn3/CEiDorwPEbP/hb34WOXDYsimr" +
       "1l6cU+56eax62xIHGxV3t7DYKoKj688n9z7z+N59Yfug+jkpj2uawqiaPchQ" +
       "NrZN98Nu7XX9N+p+fLCxpAustZtUpFV5d5p1J/waW26m455zcMtzV3/tXSPm" +
       "nIRWOIFV+ECpiA/8HDEdO9p10b/DbyXL4OmyVb1r4lZSiLWIJXytyNjXsbkN" +
       "qh/ZbFflFOWYJTpmgmMpF5LbJwuSJfD02HL1TBySQqxFxL6nyNi92HwLDFDG" +
       "yzChuwUAuXsSAKnDsWZ4ttpSbZ04IIVYiwh9tMjYt7F5EDLtQcYdJLLl3LBt" +
       "+file945JyWyfbnpsWj8OeYxs4cmAcJGHFsIz802DjdPHMJCrEVgOlVk7Cls" +
       "vuuHcBP4KidZqxf5P6asdlLmInRiEhBqwLEF8CRsMRMTR6gQaxEUflJk7Aw2" +
       "P7IQWs+SNK1Y+byD0LLx01mXXgD3zGQBNxcexZZemThwhVgD4ITFRsKO/HNQ" +
       "/tErJCG2SaVIjGVkiSo3qTJ3aJYUw6ijr69TvIktvhJYzQm49kyzndUSWiqy" +
       "fnNPZ0ZiOiahgvkcNi9yUi0ZDPISgTt2nXXB//kkgI+XRGQxPGdsBM9MHPxC" +
       "rEU08w9Fxt7F5nec1ILWdicgVZGTMrOqgC0uGG/9L8DIcFLl3r3ipcHsnL98" +
       "rL8ppCeP1lXMOnrTG6KYyf6VUAPJaTKtKN6y1vNephssKQupaqwiVxdfFzhZ" +
       "+vmuhjkpxS8hwHsW8984WTguM1S7I1nTtRkv2hpfgBGqXevFy/NPSGPy8UAk" +
       "gtZL+RF43CAl7EJ8e+k+BsxdOljUevGSfAKzAwm+fqo75nPF+IC52mKfaCbk" +
       "L5Kz2jNjPO3x1NWLfbWB+OfQSZ7T1n+HA9LJoxs33XrxC49aN6aSQvfswVmq" +
       "IWW2Lm+zZeXCgrM5c5VtWH6p9lTlEieXb7A27NrhHI+xtIOD0VFxmwLXiWZL" +
       "9lbxzWPXPfeL/WWvQRWynYQolG/bc69zMnoa6vntsdzSAEpwcc/ZtvyhsbWr" +
       "kn//rbgwIznXZEH6AencY7e8fmj2seYwqe4mU6BMYRlxz7R+TN3CpBGjn0yV" +
       "zc4MbBHPjSq+uqMWbYxi3Ba42HBOzfbifTsni3Krqdx/KaoUbZQZ67S0msBp" +
       "oHKpdnuc6wVfZZ7W9QCD2+OpOEWjZvA0QGUHYj267hSbpat04WTG8mdr0IbE" +
       "wWL+G2r8L4jn24RVIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
