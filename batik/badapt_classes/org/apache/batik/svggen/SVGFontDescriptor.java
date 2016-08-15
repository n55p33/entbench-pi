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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "i93Npd2APD2kMq0pt6ZpT9y/+yqs9LAnbtwrNXcv2kHzH/iUwPNvfDBYsEME" +
       "TXOnfb00P3u/BGUwjjNSshReuZx7ipw3DmGzA44LScqy19S2vd9109Ld58ug" +
       "xUt57OgyeP8d2Z0wFccugmeDvRM2XDjAFGItYvGxImMPYXMYDrvgjTV2Jek6" +
       "4ciX4ATOPh+ePtuSvgt3QiHWAiiLv3f68agZnmO2lGOOlF1cyveEJbuxeSK7" +
       "Oeq9x0dxXH8qOBH+PCAi8GdFfP4MNj+BY7XwuaLxOw04z2D/4673H/0ivJ9h" +
       "pCnn0g9PmrNy/lMQ9+Dyw4caKmceuvFNXkVk76prAfkTaVX1noU87+WGCZZw" +
       "82rFycjgX88zMrNAMQVBJ1646s8J+pfALUF6Rsr4t5fuFagrXToQJV68JL+B" +
       "wxGQ4OtvjTxXGeJImCnxlFi2G7n3p5/P+1kW7x0Twi//T8eByHS/jfInD63f" +
       "eNu5q4+IOy5ZlSYnUUoNAKO4bssWQgsKSnNkla9b8nn9I1XtDpA3CYXdjXOx" +
       "J9y6IDINXPHZgQsgqy17D/TW4RXP/Gpn+WuQgraQEomRqVtyD88ZIw31ypZo" +
       "bgKAopHfTHUseWDi+ksTH73NryeISBhzCtMPyW8c3fr6fbMOt4RITQ8pg7KZ" +
       "Zvipfs2EtonKY2aM1ClWVwZUBCmKpPqySz0Gp4QXUtwvtjvrsr14Q8pIa87f" +
       "OnnulatVfZyaq/W0FrfzU43b4/uzyakl04YRYHB7PHXQfmweyOBqQDwORXsN" +
       "w8lmNRUG36QH8uMItmf5Kzbv/hcWLN5j7x0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bpCU7wTyf/vYL377T7/6x+W9yj8Cn6lKM94oAAA=");
}
