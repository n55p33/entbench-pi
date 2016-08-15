package org.apache.batik.css.engine.value;
public abstract class AbstractValueFactory {
    public abstract java.lang.String getPropertyName();
    protected static java.lang.String resolveURI(org.apache.batik.util.ParsedURL base,
                                                 java.lang.String value) {
        return new org.apache.batik.util.ParsedURL(
          base,
          value).
          toString(
            );
    }
    protected org.w3c.dom.DOMException createInvalidIdentifierDOMException(java.lang.String ident) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        ident };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.identifier",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            SYNTAX_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createInvalidLexicalUnitDOMException(short type) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Integer(
          type) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.lexical.unit",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            NOT_SUPPORTED_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createInvalidFloatTypeDOMException(short t) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Integer(
          t) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.float.type",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            INVALID_ACCESS_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createInvalidFloatValueDOMException(float f) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Float(
          f) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.float.value",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            INVALID_ACCESS_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createInvalidStringTypeDOMException(short t) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Integer(
          t) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.string.type",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            INVALID_ACCESS_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createMalformedLexicalUnitDOMException() {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "malformed.lexical.unit",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            INVALID_ACCESS_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createDOMException() {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.access",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            NOT_SUPPORTED_ERR,
          s);
    }
    public AbstractValueFactory() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+IIp6OBw7gwBykC5eMW3in8DaqCxgSYfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2/nh7v8CLV3Rq0IqAAA=");
}
