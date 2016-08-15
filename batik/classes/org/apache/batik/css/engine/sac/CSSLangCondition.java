package org.apache.batik.css.engine.sac;
public class CSSLangCondition implements org.w3c.css.sac.LangCondition, org.apache.batik.css.engine.sac.ExtendedCondition {
    protected java.lang.String lang;
    protected java.lang.String langHyphen;
    public CSSLangCondition(java.lang.String lang) { super();
                                                     this.lang = lang.toLowerCase(
                                                                        );
                                                     this.langHyphen =
                                                       lang +
                                                       '-'; }
    public boolean equals(java.lang.Object obj) { if (obj == null ||
                                                        obj.
                                                        getClass(
                                                          ) !=
                                                        getClass(
                                                          )) { return false;
                                                  }
                                                  org.apache.batik.css.engine.sac.CSSLangCondition c =
                                                    (org.apache.batik.css.engine.sac.CSSLangCondition)
                                                      obj;
                                                  return c.
                                                           lang.
                                                    equals(
                                                      lang);
    }
    public short getConditionType() { return SAC_LANG_CONDITION;
    }
    public java.lang.String getLang() { return lang;
    }
    public int getSpecificity() { return 1 << 8; }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        java.lang.String s =
          e.
          getAttribute(
            "lang").
          toLowerCase(
            );
        if (s.
              equals(
                lang) ||
              s.
              startsWith(
                langHyphen)) {
            return true;
        }
        s =
          e.
            getAttributeNS(
              org.apache.batik.util.XMLConstants.
                XML_NAMESPACE_URI,
              org.apache.batik.util.XMLConstants.
                XML_LANG_ATTRIBUTE).
            toLowerCase(
              );
        return s.
          equals(
            lang) ||
          s.
          startsWith(
            langHyphen);
    }
    public void fillAttributeSet(java.util.Set attrSet) {
        attrSet.
          add(
            "lang");
    }
    public java.lang.String toString() { return ":lang(" +
                                         lang +
                                         ')'; }
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
       "XN1tKf7hO37pQ3/vpd+pDn7/L2xkIoanKwAA");
}
