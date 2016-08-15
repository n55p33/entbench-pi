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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "PPQ88gb+wib/YFx4+qrAtU2Mgwg2fvuR");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("tHnIxGNnhVhuIky+8sprr+vdr8IXd4ECjbhwR+wHH3WM1HCOjHo36On5s9/7" +
       "c5sI08OX72+98l8flT5mfeI6YtmeOIHzZJd/j3vjd8gPan/7YuGmg1fxV8W+" +
       "Hm/0wvEX8JdCI05CTzr2Gv6xAyXcvy/4F3dKePHkk+dDNZ/+2PnDWzPZlJ0e" +
       "h/Hfzyn7UZ78t7hw99SIieMv7w9N6wfXE7ixufHHBwQfyG8+Ca7JjuDkxhA8" +
       "GYlyoXA2ywsX85tvA5aWGh2yPO0Z8W0T33cM1Tsk/2fvgfyBdn91R/5Xb7h2" +
       "L1w+p+y+PLm00+7xUIMDghfufK8EHwfX13cEv37jCb7/nLLH8uShuHDXjuBh" +
       "zMIhv4ffA7/79vn95o7fb954fh86p+y5PHl6q8DB8RiWQ4LPvFeCebjBWzuC" +
       "b914gpVzyvK3Yhf2gP8HBJuHr7sPyUHvlVweI/C7O3K/e+PJ/eQ5Zflif+Ev" +
       "xIVLgFzbOI3dC++VXR5h8K0du2/deHadc8q4PCHiwiOAnXhmVMAhV/K9cs0D" +
       "F7694/rtG891eE7ZOE+EuPBjJ7kef8V7SFZ8r2Tzd+Xf3ZH97o0nq51TljvQ" +
       "Cy/GhfdtnM5pcQqHPN8xdO6deOZv3b+34/m9G8/TP6dskSezuPDgUZ5nKXT+" +
       "XonmkW9/siP6Jzee6CfPKXs5T9K48AAg2j0tcuKQ5vJG2O2f7mj+6Y2n+elz" +
       "yn4mT17Z2m331BCMQ55/7bpikePCnUc+y8m/MXjkqi/9tl+nab/8+uXbH359" +
       "8G83X6YcfEF2B1u43Uwc52hk7pH8rUFomPaG/B3bON1gw+hV4HHO/FIoLtyc" +
       "/+RoL3xuW//nAPnT6seFm0B6tOYX8iCaEzXjwi2b36P1fgGsXof18kC5TeZo" +
       "lS+B3kGVPPvlYCO7419SbEOZV9sj5CNHTWezv77/nTRx0OToJy75YXDzTeb+" +
       "wS3ZfpX5kva11xn+kz+sfXX7iY3mqFmW93I7W7ht+7XPptP88PfUmb3t93Ur" +
       "9dzb9/zKHc/uH1Tv2QI+NOMj2J44/XsW3A3izRco2dcf/oc//nde/4NN0Mv/" +
       "A5vaaZAsOwAA");
}
