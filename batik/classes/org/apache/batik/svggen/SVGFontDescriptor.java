package org.apache.batik.svggen;
public class SVGFontDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private org.w3c.dom.Element def;
    private java.lang.String fontSize;
    private java.lang.String fontWeight;
    private java.lang.String fontStyle;
    private java.lang.String fontFamily;
    public SVGFontDescriptor(java.lang.String fontSize, java.lang.String fontWeight,
                             java.lang.String fontStyle,
                             java.lang.String fontFamily,
                             org.w3c.dom.Element def) { super();
                                                        if (fontSize ==
                                                              null ||
                                                              fontWeight ==
                                                              null ||
                                                              fontStyle ==
                                                              null ||
                                                              fontFamily ==
                                                              null)
                                                            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                                                              org.apache.batik.svggen.ErrorConstants.
                                                                ERR_FONT_NULL);
                                                        this.
                                                          fontSize =
                                                          fontSize;
                                                        this.
                                                          fontWeight =
                                                          fontWeight;
                                                        this.
                                                          fontStyle =
                                                          fontStyle;
                                                        this.
                                                          fontFamily =
                                                          fontFamily;
                                                        this.
                                                          def =
                                                          def;
    }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_FONT_SIZE_ATTRIBUTE,
            fontSize);
        attrMap.
          put(
            SVG_FONT_WEIGHT_ATTRIBUTE,
            fontWeight);
        attrMap.
          put(
            SVG_FONT_STYLE_ATTRIBUTE,
            fontStyle);
        attrMap.
          put(
            SVG_FONT_FAMILY_ATTRIBUTE,
            fontFamily);
        return attrMap;
    }
    public org.w3c.dom.Element getDef() { return def;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        if (def !=
              null &&
              !defSet.
              contains(
                def))
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
      ("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" +
       "GE42q/6zwTfpgfw4gu1Z/orNO/8FyTb1Ae8dAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
