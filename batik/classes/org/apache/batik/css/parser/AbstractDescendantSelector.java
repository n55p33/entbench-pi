package org.apache.batik.css.parser;
public abstract class AbstractDescendantSelector implements org.w3c.css.sac.DescendantSelector {
    protected org.w3c.css.sac.Selector ancestorSelector;
    protected org.w3c.css.sac.SimpleSelector simpleSelector;
    protected AbstractDescendantSelector(org.w3c.css.sac.Selector ancestor,
                                         org.w3c.css.sac.SimpleSelector simple) {
        super(
          );
        ancestorSelector =
          ancestor;
        simpleSelector =
          simple;
    }
    public org.w3c.css.sac.Selector getAncestorSelector() { return ancestorSelector;
    }
    public org.w3c.css.sac.SimpleSelector getSimpleSelector() {
        return simpleSelector;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fwEtQtzNMBgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3/e7b/7N576dnYn+N0g+EZQnIwAA");
}
