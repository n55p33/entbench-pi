package org.apache.batik.svggen;
public class SVGTransformDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private java.lang.String transform;
    public SVGTransformDescriptor(java.lang.String transform) { super();
                                                                this.transform =
                                                                  transform;
    }
    public java.util.Map getAttributeMap(java.util.Map attrMap) { if (attrMap ==
                                                                        null)
                                                                      attrMap =
                                                                        new java.util.HashMap(
                                                                          );
                                                                  attrMap.
                                                                    put(
                                                                      SVG_TRANSFORM_ATTRIBUTE,
                                                                      transform);
                                                                  return attrMap;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        return defSet;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "f34yYe0z/JU1F/8F3qc03zAaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
