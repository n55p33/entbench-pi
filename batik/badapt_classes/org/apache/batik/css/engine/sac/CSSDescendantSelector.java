package org.apache.batik.css.engine.sac;
public class CSSDescendantSelector extends org.apache.batik.css.engine.sac.AbstractDescendantSelector {
    public CSSDescendantSelector(org.w3c.css.sac.Selector ancestor, org.w3c.css.sac.SimpleSelector simple) {
        super(
          ancestor,
          simple);
    }
    public short getSelectorType() { return SAC_DESCENDANT_SELECTOR;
    }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        org.apache.batik.css.engine.sac.ExtendedSelector p =
          (org.apache.batik.css.engine.sac.ExtendedSelector)
            getAncestorSelector(
              );
        if (!((org.apache.batik.css.engine.sac.ExtendedSelector)
                getSimpleSelector(
                  )).
              match(
                e,
                pseudoE))
            return false;
        for (org.w3c.dom.Node n =
               e.
               getParentNode(
                 );
             n !=
               null;
             n =
               n.
                 getParentNode(
                   )) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE &&
                  p.
                  match(
                    (org.w3c.dom.Element)
                      n,
                    null)) {
                return true;
            }
        }
        return false;
    }
    public void fillAttributeSet(java.util.Set attrSet) { ((org.apache.batik.css.engine.sac.ExtendedSelector)
                                                             getSimpleSelector(
                                                               )).
                                                            fillAttributeSet(
                                                              attrSet);
    }
    public java.lang.String toString() { return getAncestorSelector(
                                                  ) + " " +
                                         getSimpleSelector(
                                           ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "V3bqHDWGC2M+ay/yT9a8/W9+zuhIwBsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KyYAAA==");
}
