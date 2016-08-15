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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jnz80j3vnJMi2b7h9EQ0/hzwhNljN8CENThWD0+7bYf24ZswH2sBM50pMPYs" +
       "Nt/3m3AD5CqnGqsWBT7WpHbV5Vro1A2w0Bgcmw5Pp61m5/AtlI+1gBV+VmDs" +
       "JWx+YlloNUvStGIV7I6Fbh66XnXpheGevwGGq8UxrFXjtvbx4RsuH2sB47xR" +
       "YOzX2JzjZDQYriUBuyUc+JlVV7a7xvjl/8IYGUiKuXd+eECdmPMXhHVtLj1z" +
       "rKpswrEtF0SZnL3aroSyJ5lWFO8RyvNeohssKQvtKq0DlS6+3uFk9ue7muSk" +
       "GL+EIhcs5vc4qR+SGU5WfVkU2YwXOZlcgBFOVtaLl+cPsKMOxgNJEVov5YcQ" +
       "/EFKkEJ8e+k+4qTCpYNFrRcvyccwO5Dg62XdiZvbhzaYixrbo5mQ//iVRVHt" +
       "UCjynNhm+spU8U+WU8elrf+yuqTTx9ZtuPfq4iet6zxJobt24SwjoXqzLg2z" +
       "B5b6vLM5c5WsnXNt9JnyWU5Z6btO9MomsAxbkbh6mxS43zIbstdc7x5f9uKv" +
       "9pe8BQVxJwlROBh05l4dZPQ0nBQ7Y7lVKhzuxMVb45zHBlbMT/71PXE5Q3Ku" +
       "ZIL0XdL5E/e8fWji8bowGdlCRkDFzDLiTmP1gLqJSX1GBxklm80ZEBH9RhVf" +
       "CTwaY4ziFiLsYptzVLYX73k5mZFb2OfejlcoWj8zVmlpNYHTQBE90u1xDq6+" +
       "M19a1wMMbo/nLJOx6gT0BkC2K9aq684lafESXSSbgcELB2w/E6/YXP8vh+I1" +
       "MeUeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
