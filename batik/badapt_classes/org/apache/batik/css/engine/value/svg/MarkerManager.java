package org.apache.batik.css.engine.value.svg;
public class MarkerManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    protected java.lang.String property;
    public MarkerManager(java.lang.String prop) { super();
                                                  property = prop; }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_URI_OR_IDENT; }
    public java.lang.String getPropertyName() { return property; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() { return org.apache.batik.css.engine.value.ValueConstants.
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
                   SAC_URI:
                return new org.apache.batik.css.engine.value.URIValue(
                  lu.
                    getStringValue(
                      ),
                  resolveURI(
                    engine.
                      getCSSBaseURI(
                        ),
                    lu.
                      getStringValue(
                        )));
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
        switch (type) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                if (value.
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_NONE_VALUE)) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NONE_VALUE;
                }
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_URI:
                return new org.apache.batik.css.engine.value.URIValue(
                  value,
                  resolveURI(
                    engine.
                      getCSSBaseURI(
                        ),
                    value));
        }
        throw createInvalidStringTypeDOMException(
                type);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fWOkVXSxN+s/2wZYYHQgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "kLpHOLuvPs6P36HtE0X2EzH0kFU8qSiPHG+D8idfAcprRWVxAC8eoRRffZQ/" +
       "c4e2TxXZJ2Po2kqPj+GdXEtesOO7rKO3LiXq518B6oeKyidAGh+hHr/6qH/p" +
       "Dm2/UmQvnEctHvmf6inET78CiOUW8DhI7z2C+N5XH+Jn79D2O0X2G3uILd1Q" +
       "Ent/wXR8Cfn2l38pcEpfauM3X6k23gSSdqQN7dXRxkFJcHAM6rsLUCmqlVgi" +
       "RTvk9czSFHvsWvExzVN3Ak4Ph+2yVI72+QujXbjHfeR4tKXnHLb6QjvTdL/Y" +
       "PEvmLxTZH8TQa7RQV2K9VGZR9bunGv3cK9XokyA9c6TRZ14djd61j5Vutf7v" +
       "iUwvLG/Wy+DoT0r+v7y1joqff1oSfKXIvgTCrL0e9jfet9LGX3wn2shi6LXn" +
       "XrEUV/KPvOQJ3f7Zl/YLz1+78sbnx39ePuQ4eZp1Hw9dMRLbPntReqZ82Q91" +
       "wyox3Le/NvXLr6+9jA2dPLMBHhPkpehf3bN+I4aeeFnW+OhG8Czj3xzZ9m0Y" +
       "Y+jyvnCW5+/AHn0rHiAWyM9S/n0MXb9ICaQov8/S/VMMXT2lA4PuC2dJvg16" +
       "ByRF8V/844XSeHl1kWoUh4q291FHU5pdOh8in1jKQy9nKWei6reei4XLp5jH" +
       "cWuyf4x5U/vM85z4zLcaP7t/L6PZSp4XvVzhoXv3T3dOYt8nbtvbcV+XmXd8" +
       "+4FfvO+p4zj9gb3Ap4vxjGxvufXjlLbjx+Vzkvw33vir7/655/+qvP/9v9iN" +
       "DFwjKwAA");
}
