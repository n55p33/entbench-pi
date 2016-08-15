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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7/vnr/1eedH2/wCx7DXipioAAA==");
}
