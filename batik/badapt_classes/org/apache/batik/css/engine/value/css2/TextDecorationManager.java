package org.apache.batik.css.engine.value.css2;
public class TextDecorationManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_BLINK_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BLINK_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LINE_THROUGH_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LINE_THROUGH_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OVERLINE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          OVERLINE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_UNDERLINE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          UNDERLINE_VALUE); }
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT_LIST; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_TEXT_DECORATION_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NONE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.ValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                if (lu.
                      getStringValue(
                        ).
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_NONE_VALUE)) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NONE_VALUE;
                }
                org.apache.batik.css.engine.value.ListValue lv =
                  new org.apache.batik.css.engine.value.ListValue(
                  ' ');
                do  {
                    if (lu.
                          getLexicalUnitType(
                            ) ==
                          org.w3c.css.sac.LexicalUnit.
                            SAC_IDENT) {
                        java.lang.String s =
                          lu.
                          getStringValue(
                            ).
                          toLowerCase(
                            ).
                          intern(
                            );
                        java.lang.Object obj =
                          values.
                          get(
                            s);
                        if (obj ==
                              null) {
                            throw createInvalidIdentifierDOMException(
                                    lu.
                                      getStringValue(
                                        ));
                        }
                        lv.
                          append(
                            (org.apache.batik.css.engine.value.Value)
                              obj);
                        lu =
                          lu.
                            getNextLexicalUnit(
                              );
                    }
                    else {
                        throw createInvalidLexicalUnitDOMException(
                                lu.
                                  getLexicalUnitType(
                                    ));
                    }
                }while(lu !=
                         null); 
                return lv;
        }
        throw createInvalidLexicalUnitDOMException(
                lu.
                  getLexicalUnitType(
                    ));
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (type !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            throw createInvalidStringTypeDOMException(
                    type);
        }
        if (!value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_NONE_VALUE)) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return org.apache.batik.css.engine.value.ValueConstants.
                 NONE_VALUE;
    }
    public TextDecorationManager() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "TM9PvlE9n4XP8FjP4Zuv58/doe7ni+SnY+QRu7iSUW5F3kbLn3kDWl4vCp+A" +
       "j3CspfDma/l371D3xSJ5OUaumyA+Ue/07PKSH99lH9+VKbX+O29A60eKwqfg" +
       "szjWevHma/2rd6j7tSL58kWtuWP8Ec5U/MobULFcAp6Ez81jFW+++Sr+5h3q" +
       "XimSf3RQkQKGmjiHI6mTY48PvPaxzRl9aY1//Eat8W74GMfWMN4ca1wtCa6e" +
       "KPWuQqmsppW6RKp2NAa5ranO3LPjE5pn76Q4OZ3SZa7s7RuXertyfEviuKXH" +
       "TnrTffeI4lk610BQLJ4l8+8Wyddi5C1aCNQYlMYsiv7ZmUW//kYt+jR8furY" +
       "oj/15lj0rkOsdKv5f09k+WF55F4GR/+65P/mrW1UvP6bkuA/FcnvwzDrYIfD" +
       "GdutrPEHr8caeYy8/ZZXXooz+8dedRXvcH1M+8rL1+9758vzf1fe+ji94nX/" +
       "GLnPSBzn/BHrufy1IASGXepy/+HANSj//iRG3v+Xu5wTI3cXf6USf3xg/naM" +
       "PPWazPHxmeF5xu8ce/ltGGPk2iFznue/w9X6VjwQ0mF6nvJ7MXLjMiWUovw/" +
       "T/e/Y+SBMzrY6SFznuTPYOuQpMj+eXAyZRqvbbDOKopDVTug1fGg5lcuBsun" +
       "PvPIa/nMufj6fRei4vJS50kEmxyudd7UvvrykPuR7za+eLheoznqfl+0ct8Y" +
       "ufdw0+c0Cn7qtq2dtHWt/9z3H/qV+589idgfOgh8Ni3PyfbeW99fod0gLm+c" +
       "7P/hO3/thb/38jfLE+L/B3vV+zhtKwAA");
}
