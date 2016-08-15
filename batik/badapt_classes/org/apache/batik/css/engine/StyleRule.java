package org.apache.batik.css.engine;
public class StyleRule implements org.apache.batik.css.engine.Rule {
    public static final short TYPE = (short) 0;
    protected org.w3c.css.sac.SelectorList selectorList;
    protected org.apache.batik.css.engine.StyleDeclaration styleDeclaration;
    public short getType() { return TYPE; }
    public void setSelectorList(org.w3c.css.sac.SelectorList sl) { selectorList =
                                                                     sl;
    }
    public org.w3c.css.sac.SelectorList getSelectorList() { return selectorList;
    }
    public void setStyleDeclaration(org.apache.batik.css.engine.StyleDeclaration sd) {
        styleDeclaration =
          sd;
    }
    public org.apache.batik.css.engine.StyleDeclaration getStyleDeclaration() {
        return styleDeclaration;
    }
    public java.lang.String toString(org.apache.batik.css.engine.CSSEngine eng) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        if (selectorList !=
              null) {
            sb.
              append(
                selectorList.
                  item(
                    0));
            for (int i =
                   1;
                 i <
                   selectorList.
                   getLength(
                     );
                 i++) {
                sb.
                  append(
                    ", ");
                sb.
                  append(
                    selectorList.
                      item(
                        i));
            }
        }
        sb.
          append(
            " {\n");
        if (styleDeclaration !=
              null) {
            sb.
              append(
                styleDeclaration.
                  toString(
                    eng));
        }
        sb.
          append(
            "}\n");
        return sb.
          toString(
            );
    }
    public StyleRule() { super(); }
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
       "g6qRVikAAA==");
}
