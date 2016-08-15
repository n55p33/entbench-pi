package org.apache.batik.css.engine.sac;
public class CSSBeginHyphenAttributeCondition extends org.apache.batik.css.engine.sac.CSSAttributeCondition {
    public CSSBeginHyphenAttributeCondition(java.lang.String localName, java.lang.String namespaceURI,
                                            boolean specified,
                                            java.lang.String value) {
        super(
          localName,
          namespaceURI,
          specified,
          value);
    }
    public short getConditionType() { return SAC_BEGIN_HYPHEN_ATTRIBUTE_CONDITION;
    }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        return e.
          getAttribute(
            getLocalName(
              )).
          startsWith(
            getValue(
              ));
    }
    public java.lang.String toString() { return '[' + getLocalName(
                                                        ) +
                                         "|=\"" +
                                         getValue(
                                           ) +
                                         "\"]"; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1z7pH7z29978W899Pc+Z/g9wal6Y8iIAAA==");
}
