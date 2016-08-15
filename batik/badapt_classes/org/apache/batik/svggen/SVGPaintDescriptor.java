package org.apache.batik.svggen;
public class SVGPaintDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private org.w3c.dom.Element def;
    private java.lang.String paintValue;
    private java.lang.String opacityValue;
    public SVGPaintDescriptor(java.lang.String paintValue, java.lang.String opacityValue) {
        super(
          );
        this.
          paintValue =
          paintValue;
        this.
          opacityValue =
          opacityValue;
    }
    public SVGPaintDescriptor(java.lang.String paintValue, java.lang.String opacityValue,
                              org.w3c.dom.Element def) { this(
                                                           paintValue,
                                                           opacityValue);
                                                         this.
                                                           def =
                                                           def;
    }
    public java.lang.String getPaintValue() { return paintValue;
    }
    public java.lang.String getOpacityValue() { return opacityValue;
    }
    public org.w3c.dom.Element getDef() { return def; }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_FILL_ATTRIBUTE,
            paintValue);
        attrMap.
          put(
            SVG_STROKE_ATTRIBUTE,
            paintValue);
        attrMap.
          put(
            SVG_FILL_OPACITY_ATTRIBUTE,
            opacityValue);
        attrMap.
          put(
            SVG_STROKE_OPACITY_ATTRIBUTE,
            opacityValue);
        return attrMap;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        if (def !=
              null)
            defSet.
              add(
                def);
        return defSet;
    }
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
       "ff/4tT8oL9r+H+uR8ZymKgAA");
}
