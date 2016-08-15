package org.apache.batik.dom.svg;
public class SVGOMAngle implements org.w3c.dom.svg.SVGAngle {
    protected short unitType;
    protected float value;
    protected static final java.lang.String[] UNITS = { "", "", "deg", "rad",
    "grad" };
    public short getUnitType() { revalidate();
                                 return unitType; }
    public float getValue() { revalidate();
                              return toUnit(unitType, value, SVG_ANGLETYPE_DEG);
    }
    public void setValue(float value) throws org.w3c.dom.DOMException { revalidate(
                                                                          );
                                                                        this.
                                                                          unitType =
                                                                          SVG_ANGLETYPE_DEG;
                                                                        this.
                                                                          value =
                                                                          value;
                                                                        reset(
                                                                          );
    }
    public float getValueInSpecifiedUnits() { revalidate(
                                                );
                                              return value;
    }
    public void setValueInSpecifiedUnits(float value)
          throws org.w3c.dom.DOMException { revalidate(
                                              );
                                            this.
                                              value =
                                              value;
                                            reset(
                                              ); }
    public java.lang.String getValueAsString() { revalidate(
                                                   );
                                                 return java.lang.Float.
                                                   toString(
                                                     value) +
                                                 UNITS[unitType];
    }
    public void setValueAsString(java.lang.String value)
          throws org.w3c.dom.DOMException { parse(
                                              value);
                                            reset(
                                              ); }
    public void newValueSpecifiedUnits(short unit,
                                       float value) {
        unitType =
          unit;
        this.
          value =
          value;
        reset(
          );
    }
    public void convertToSpecifiedUnits(short unit) {
        value =
          toUnit(
            unitType,
            value,
            unit);
        unitType =
          unit;
    }
    protected void reset() {  }
    protected void revalidate() {  }
    protected void parse(java.lang.String s) { try {
                                                   org.apache.batik.parser.AngleParser angleParser =
                                                     new org.apache.batik.parser.AngleParser(
                                                     );
                                                   angleParser.
                                                     setAngleHandler(
                                                       new org.apache.batik.parser.DefaultAngleHandler(
                                                         ) {
                                                           public void angleValue(float v)
                                                                 throws org.apache.batik.parser.ParseException {
                                                               value =
                                                                 v;
                                                           }
                                                           public void deg()
                                                                 throws org.apache.batik.parser.ParseException {
                                                               unitType =
                                                                 SVG_ANGLETYPE_DEG;
                                                           }
                                                           public void rad()
                                                                 throws org.apache.batik.parser.ParseException {
                                                               unitType =
                                                                 SVG_ANGLETYPE_RAD;
                                                           }
                                                           public void grad()
                                                                 throws org.apache.batik.parser.ParseException {
                                                               unitType =
                                                                 SVG_ANGLETYPE_GRAD;
                                                           }
                                                       });
                                                   unitType =
                                                     SVG_ANGLETYPE_UNSPECIFIED;
                                                   angleParser.
                                                     parse(
                                                       s);
                                               }
                                               catch (org.apache.batik.parser.ParseException e) {
                                                   unitType =
                                                     SVG_ANGLETYPE_UNKNOWN;
                                                   value =
                                                     0;
                                               }
    }
    protected static double[][] K = { { 1,
    java.lang.Math.
      PI /
      180,
    java.lang.Math.
      PI /
      200 },
    { 180 /
      java.lang.Math.
        PI,
    1,
    1800 /
      (9 *
         java.lang.Math.
           PI) },
    { 0.9,
    9 *
      java.lang.Math.
        PI /
      1800,
    1 } };
    public static float toUnit(short fromUnit,
                               float value,
                               short toUnit) {
        if (fromUnit ==
              1) {
            fromUnit =
              2;
        }
        if (toUnit ==
              1) {
            toUnit =
              2;
        }
        return (float)
                 (K[fromUnit -
                      2][toUnit -
                           2] *
                    value);
    }
    public SVGOMAngle() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fSoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "P8dzuG3T01nx/PHz1sLR4+qbnak48d75");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("4OitxGPZ+ZkEkU8em8kPzWSvEp+42dmu/DXi5z/2yqvK4GdLl3bP2qmocFfk" +
       "en/BUleqdWKue/P71TGfOa/vBFd9x2f97GP1vSTOf//37q0kL3ju/6UL2v5x" +
       "VvxKVHjbQo3Gu7e6WRW5l/0/eKOngifHPA/e94Fr13f7/dbC+/IFbV/Jin8W" +
       "Fa4AePnr9+z3eI/t124B29uyyufB1d1h67412A72BOOc4F+eT3Cu1bYGNJHK" +
       "qpe9+Mo7/25W/AsggXAngXMfBq9cQ9lL5au3qvEXwMXupMK+9Rr/Dxe0fT0r" +
       "/hBI5UjjpMN5qpw/C88MPDxjAX90qxaAguvFHdYXv0cW8N9uTvB7OcF/z4pv" +
       "AtThBaj/7R71f70F1A9llVk4VXaolbdew39687aDfKr/HRUeONIwFm7ffWf1" +
       "2h7jn9yqZrM3kdYOo/WWa1bLwdz9Bpo9uCcr7gBow3PQ7jV6cPlW0f4wuOId" +
       "2vitQXtp/+aXPDbmg0cu0O1jWfFgVHjEUZPtcaoLrPjgoVvFnJ1n+cgO80fe" +
       "cg2TOaRnLoCbDXnwRFR4VHadlRpEvHsh3idvAe/xWaMf2+H9sTeLt/VGXntw" +
       "eEFb9qb2IDvsE6jAks8Ae8+tAnsKXD+xA/YTbz2wH7yg7X1ZgUbZSY+VZBmK" +
       "FKln0FVvFV0WbD+zQ/eZtwbdDYGofQHEblZgQHde9q+TM+iat4DusazySXD9" +
       "6g7dr74JdPsDSy+dC/G2/b5jG332PsleAJbPCjoqXI7czAfznnu0zJtBmwKr" +
       "2J+8z44OP3bD33i2fz2Rv/Dq/VcefXX8u9sDakd/D7mrX7iixZZ18qTnifvL" +
       "XqBqRg7+ru25Ty+H8OIuKTzvrwBR4TZQZqweiFvql6LCw+dRA0pQnqSUwDJ0" +
       "lhJYRf59kk4BuPd0QJTbm5MkGR+AJLvVt2eWTp9m2x6MTbdJ7mMnrSdf298w" +
       "8h93OXmGPTtClv/d6ui4V7z9w9V1+Yuv9pgPf7v6s9sz9LIlbTbZKFf6hTu3" +
       "x/nzQbMjY0/fdLSjsS53X/jOfb941/NHW8H7tgzvLfkEb0+df0idsL0oP1a+" +
       "+ZVH//77/varv58fDvl/qPSi/gc3AAA=");
}
