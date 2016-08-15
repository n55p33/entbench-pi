package org.apache.batik.css.engine.value;
public abstract class AbstractValueManager extends org.apache.batik.css.engine.value.AbstractValueFactory implements org.apache.batik.css.engine.value.ValueManager {
    public org.apache.batik.css.engine.value.Value createFloatValue(short unitType,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException { throw createDOMException(
                                                    ); }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        throw createDOMException(
                );
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE &&
              value.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_URI) {
            return new org.apache.batik.css.engine.value.URIValue(
              value.
                getStringValue(
                  ),
              value.
                getStringValue(
                  ));
        }
        return value;
    }
    public AbstractValueManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "p1sZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
