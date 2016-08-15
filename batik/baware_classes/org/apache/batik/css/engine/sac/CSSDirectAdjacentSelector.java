package org.apache.batik.css.engine.sac;
public class CSSDirectAdjacentSelector extends org.apache.batik.css.engine.sac.AbstractSiblingSelector {
    public CSSDirectAdjacentSelector(short type, org.w3c.css.sac.Selector parent,
                                     org.w3c.css.sac.SimpleSelector simple) {
        super(
          type,
          parent,
          simple);
    }
    public short getSelectorType() { return SAC_DIRECT_ADJACENT_SELECTOR;
    }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        org.w3c.dom.Node n =
          e;
        if (!((org.apache.batik.css.engine.sac.ExtendedSelector)
                getSiblingSelector(
                  )).
              match(
                e,
                pseudoE))
            return false;
        while ((n =
                  n.
                    getPreviousSibling(
                      )) !=
                 null &&
                 n.
                 getNodeType(
                   ) !=
                 org.w3c.dom.Node.
                   ELEMENT_NODE)
            ;
        if (n ==
              null)
            return false;
        return ((org.apache.batik.css.engine.sac.ExtendedSelector)
                  getSelector(
                    )).
          match(
            (org.w3c.dom.Element)
              n,
            null);
    }
    public void fillAttributeSet(java.util.Set attrSet) { ((org.apache.batik.css.engine.sac.ExtendedSelector)
                                                             getSelector(
                                                               )).
                                                            fillAttributeSet(
                                                              attrSet);
                                                          ((org.apache.batik.css.engine.sac.ExtendedSelector)
                                                             getSiblingSelector(
                                                               )).
                                                            fillAttributeSet(
                                                              attrSet);
    }
    public java.lang.String toString() { return getSelector(
                                                  ) +
                                         " + " +
                                         getSiblingSelector(
                                           ); }
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
       "F/jtdylFJgAA");
}
