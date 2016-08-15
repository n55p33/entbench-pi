package org.apache.batik.gvt.font;
public class GVTFontFace implements org.apache.batik.util.SVGConstants {
    protected java.lang.String familyName;
    protected float unitsPerEm;
    protected java.lang.String fontWeight;
    protected java.lang.String fontStyle;
    protected java.lang.String fontVariant;
    protected java.lang.String fontStretch;
    protected float slope;
    protected java.lang.String panose1;
    protected float ascent;
    protected float descent;
    protected float strikethroughPosition;
    protected float strikethroughThickness;
    protected float underlinePosition;
    protected float underlineThickness;
    protected float overlinePosition;
    protected float overlineThickness;
    public GVTFontFace(java.lang.String familyName, float unitsPerEm, java.lang.String fontWeight,
                       java.lang.String fontStyle,
                       java.lang.String fontVariant,
                       java.lang.String fontStretch,
                       float slope,
                       java.lang.String panose1,
                       float ascent,
                       float descent,
                       float strikethroughPosition,
                       float strikethroughThickness,
                       float underlinePosition,
                       float underlineThickness,
                       float overlinePosition,
                       float overlineThickness) { super();
                                                  this.familyName =
                                                    familyName;
                                                  this.unitsPerEm =
                                                    unitsPerEm;
                                                  this.fontWeight =
                                                    fontWeight;
                                                  this.fontStyle =
                                                    fontStyle;
                                                  this.fontVariant =
                                                    fontVariant;
                                                  this.fontStretch =
                                                    fontStretch;
                                                  this.slope = slope;
                                                  this.panose1 = panose1;
                                                  this.ascent = ascent;
                                                  this.descent = descent;
                                                  this.strikethroughPosition =
                                                    strikethroughPosition;
                                                  this.strikethroughThickness =
                                                    strikethroughThickness;
                                                  this.underlinePosition =
                                                    underlinePosition;
                                                  this.underlineThickness =
                                                    underlineThickness;
                                                  this.overlinePosition =
                                                    overlinePosition;
                                                  this.overlineThickness =
                                                    overlineThickness;
    }
    public GVTFontFace(java.lang.String familyName) { this(familyName,
                                                           1000,
                                                           SVG_FONT_FACE_FONT_WEIGHT_DEFAULT_VALUE,
                                                           SVG_FONT_FACE_FONT_STYLE_DEFAULT_VALUE,
                                                           SVG_FONT_FACE_FONT_VARIANT_DEFAULT_VALUE,
                                                           SVG_FONT_FACE_FONT_STRETCH_DEFAULT_VALUE,
                                                           0,
                                                           SVG_FONT_FACE_PANOSE_1_DEFAULT_VALUE,
                                                           800,
                                                           200,
                                                           300,
                                                           50,
                                                           -75,
                                                           50,
                                                           800,
                                                           50);
    }
    public java.lang.String getFamilyName() {
        return familyName;
    }
    public boolean hasFamilyName(java.lang.String family) {
        java.lang.String ffname =
          familyName;
        if (ffname.
              length(
                ) <
              family.
              length(
                )) {
            return false;
        }
        ffname =
          ffname.
            toLowerCase(
              );
        int idx =
          ffname.
          indexOf(
            family.
              toLowerCase(
                ));
        if (idx ==
              -1) {
            return false;
        }
        if (ffname.
              length(
                ) >
              family.
              length(
                )) {
            boolean quote =
              false;
            if (idx >
                  0) {
                char c =
                  ffname.
                  charAt(
                    idx -
                      1);
                switch (c) {
                    default:
                        return false;
                    case ' ':
                        loop: for (int i =
                                     idx -
                                     2;
                                   i >=
                                     0;
                                   --i) {
                            switch (ffname.
                                      charAt(
                                        i)) {
                                default:
                                    return false;
                                case ' ':
                                    continue;
                                case '\"':
                                case '\'':
                                    quote =
                                      true;
                                    break loop;
                            }
                        }
                        break;
                    case '\"':
                    case '\'':
                        quote =
                          true;
                    case ',':
                }
            }
            if (idx +
                  family.
                  length(
                    ) <
                  ffname.
                  length(
                    )) {
                char c =
                  ffname.
                  charAt(
                    idx +
                      family.
                      length(
                        ));
                switch (c) {
                    default:
                        return false;
                    case ' ':
                        loop: for (int i =
                                     idx +
                                     family.
                                     length(
                                       ) +
                                     1;
                                   i <
                                     ffname.
                                     length(
                                       );
                                   i++) {
                            switch (ffname.
                                      charAt(
                                        i)) {
                                default:
                                    return false;
                                case ' ':
                                    continue;
                                case '\"':
                                case '\'':
                                    if (!quote) {
                                        return false;
                                    }
                                    break loop;
                            }
                        }
                        break;
                    case '\"':
                    case '\'':
                        if (!quote) {
                            return false;
                        }
                    case ',':
                }
            }
        }
        return true;
    }
    public java.lang.String getFontWeight() {
        return fontWeight;
    }
    public java.lang.String getFontStyle() {
        return fontStyle;
    }
    public float getUnitsPerEm() { return unitsPerEm;
    }
    public float getAscent() { return ascent;
    }
    public float getDescent() { return descent;
    }
    public float getStrikethroughPosition() {
        return strikethroughPosition;
    }
    public float getStrikethroughThickness() {
        return strikethroughThickness;
    }
    public float getUnderlinePosition() {
        return underlinePosition;
    }
    public float getUnderlineThickness() {
        return underlineThickness;
    }
    public float getOverlinePosition() { return overlinePosition;
    }
    public float getOverlineThickness() {
        return overlineThickness;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WjgRlHfkoeeRN/AX8vyDYeHpqwLX8hgH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("lu8eRNJmIROPnRVimUeYfOWV115XmK+WL+4CBVph4Y7QcT9qqrFqHhn1btDT" +
       "82e/96fyCNPDl+9vvfJfH518bPnx64hle+IEzpNd/j3qjd/tflD+uYuFmw5e" +
       "xV8V+3q80QvHX8Bf8tUw8u3Jsdfwjx0o4f59wb+4U8KLJ588H6r59MfOH96a" +
       "SV52ehzGfz+n7IdZ8t/Cwt0LNcSPv7w/NK3vX0/gRn7jTw4IPpDdfBJc0o6g" +
       "dGMInoxEuVA4m+WFi9nNHwGWSzE4ZHnaM+LbJMcxVdE+JP/n74H8gXZ/bUf+" +
       "1264di9cPqfsviy5tNPu8VCDA4IX7nyvBB8H19d3BL9+4wm+/5yyx7LkobBw" +
       "147gYczCIb+H3wO/+/b5/daO32/deH4fOqfsuSx5eqtA7ngMyyHBZ94rwSzc" +
       "4K0dwbduPMHqOWXZW7ELe8D/A4LI4evuQ3LQeyWXxQj83o7c7914cj95Tlm2" +
       "2F/4S2HhEiCHqaexe+G9sssiDL61Y/etG89ucE4ZlSV4WHgEsGPPjAo45Np9" +
       "r1yzwIVv77h++8ZznZ5TNs+ScVj4sZNcj7/iPSTLvley2bvy7+7IfvfGk5XP" +
       "Kcsc6IUXw8L7cqdzWpzCIc93DJ17J57ZW/e3dzzfvvE8nXPKvCxZhYUHj/I8" +
       "S6HGeyWaRb796Y7on954op84p+zlLInDwgOAKHNa5MQhzeRG2O2f7Wj+2Y2n" +
       "+elzyn46S17Z2i1zagjGIc+/eV2xyGHhziOf5WTfGDxy1Zd+26/T5F95/fLt" +
       "D7/O/dv8y5SDL8juIAu3a5FpHo3MPZK/1fVVTc/J37GN03VzRq8Cj3Pml0Jh" +
       "4ebsJ0N74XPb+j8PyJ9WPyzcBNKjNb+QBdGcqBkWbsl/j9b7RbB6HdbLAuXy" +
       "zNEqXwK9gypZ9stuLrvjX1JsQ5nX2yPkI0dNJ99f3/9OmjhocvQTl+wwmH+T" +
       "uX9wi7ZfZb4kf+11gv7EDxpf3X5iI5timma93E4Wbtt+7ZN3mh3+njqzt/2+" +
       "bu0996N7fvWOZ/cPqvdsAR+a8RFsT5z+PUvHcsP8C5T06w//wx//O6//YR70" +
       "8v8AF1u5Ayw7AAA=");
}
