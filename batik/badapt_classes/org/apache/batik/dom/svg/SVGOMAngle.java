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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "WF3el0vm1zbiAyOVpTNGNr9unkHaX8RMTpDSgYwsu9/duO5LNJ0OSBzgyeab" +
       "HH6GFFGsDUChrx8YKYISRxxJm9I7GZlWSBokoXRLMkjZfkmgGv91yw2D3Y4c" +
       "QGzeuEV2Q+sggrfWKZR3jWS+6sqaG5pZbpz5qrJ2tOnJqbhflONpIf/CzD7Z" +
       "y5jfmPWJp0bWd+w596V7zBf1oizs3o2tlCfIRPNzAN4ong7OC2zNbqtk3cLz" +
       "Ux6ctMA+X/B8KOAeGycJeDZ/qT7T9+baaMq9wH7j+IrHnz9Q8lKURLaQiMDI" +
       "1C35LwWzWkYn9VsS+W9negSdv1JvXvidXSuXDPzlLf7alZgHubOD5fvEV07c" +
       "+PLhuuMNUVLeRiZISpJm+dvKNbuULioO6b2kQjJaszBEaEUSZM+rnylIYgFX" +
       "dRwXC86K3FP8goORxvz3XvnfvZTJ6jDVV6sZJYnNVCRIufPEnBnfAWtG03wK" +
       "zhNrKrG8EYtYFmcD+NiXaNc0+/OH0hMa9+KthdYr/NArcpDf4t23/gchfGJj" +
       "fSoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LCmau6sKNFzNORWuTawt02xP9bI62cSVnF+3/ZhItj7t1ObGeOQPKLYjz1sj" +
       "YjtvV4QZttkgnQxJgl6YqLQ38EKnVltpy7QFpRU9nPPler1ZVStEwPQCN0OJ" +
       "SjwUFiam1kW2inQVW5yly2530FjOMEU0mMGi7oq1xSoZZ/XGYDFPzJnZ74QL" +
       "ZmxyfbEtUKRNVNJWC1ZHEwaCRbNPhJbggLDHrm5CpaYYttj1qx2r35DCWRgu" +
       "FwNa2JAcNx8Y5bHpjBRUgntsTXfiySyhs9YyGbSgWkX0J8NyezNzA7ffBMVL" +
       "vK/jZbw+jbO05a01yCWFCqSo3kScsDXK2LKLSQNK5unagZy4XK6VW5qGp6HS" +
       "xTYNXe9n7Xq1tZ05XHuj81rNH0gTZtkmxmIHVrFym4KqREwN7F4V30aSOrVU" +
       "iU9wbUyXl/P1otuiy1mV5rfzkT7XAmlbX7ge21EgCYq6biMW9WqQ2dhI8Ze6" +
       "IoyMOrvh3cgsR5ZVo+fliS0O9dQdCVrdJhQqEkyLq6uEu6pt+5jASN6IUVxp" +
       "anYnFN93+jZnjSKiNrVgN2LbzHrcXU0rJmqZjbRaI2cq3Bp3JxIMMbCzGY/x" +
       "3rTRhJG1gWjVpg6Zm9GGnIlKV5eCcM2TPOcKMLbeWGQfMSWMardrNS8Okbia" +
       "VtteM9MHtUQbTwJDY/URnME0vpRctCJAYdZKF4uFWc1irbVAFtvNPFz24bU6" +
       "as4RQFZIMxMGgsZocbhA4wQqV6FsM0/KbFva+JG3ldAe05GysLJMxvMxg0Fi" +
       "YDvhYlVp6WAtkDHERpZi2cmiLMaQQFKr+LA9Wo8Bt44zk46HWbdHc0OpM8A7" +
       "S7YthrZibSruShDxdCVW51ZzFKNsCAkJuoUqrtPs+VlDjewu8NnhWNsuZ0nM" +
       "iz09k+vNVXvZGPIre6gsoXAtLOoZCFfghTltUzUqpPtxk0dZdrrx67JJKWrU" +
       "ETdluiaaWzswkjSDJQfebKYNlJgzgxm8SMLqgFp6SK3tzeu0yNSnAPwIBDBp" +
       "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" +
       "tXT4uPpmZypOvHfeO3wr8Vh+fmaDKCeP");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("zRSHZvJXiU/c7GxX8Rrx8x975VWV/ZnqpYNn7WRcuiv2gz/naGvNOdHXvcX9" +
       "+kjPQtd3gqt1oGfr7GP145E4//3fu3cjecFz/y9dUPaP8uSX49LbDC2eHrzV" +
       "zbOGx2P/99/oqeDJNs+D933gOqi7+35r4X35grKv5Mk/jUtXALzi9Xv+e3qM" +
       "7VdvAdvb8sznwTU4wDZ4a7DtHQtMC4F/cb7AuV7bZWk8VbQgf/FVVP6dPPnn" +
       "YASigxE492Hw2rfU41H56q1a/AVwcQejwr31Fv/3F5R9PU/+AIzKocWHHh9o" +
       "SvEsPHfw6IwH/OGtekAdXC8eYH3xe+QB/+3mAr9bCPz3PPkmQB1dgPrfHKP+" +
       "L7eA+qE8M6dT9QC1+tZb+E9uXrZXdPW/49IDhxZGo9277zxfP8b4x7dq2fxN" +
       "pHOA0XnLLasXYO5+A8vu3ZMndwC00Tlojy26d/lW0f4wuJIDtMlbg/bS8Zvf" +
       "4ZEz7z1ygW0fy5MH49IjnrbZHae6wIv3HrpVzPl5lo8cYP7IW27hYQHpmQvg" +
       "5k3uPRGXHlV8b62F8cS/EO+Tt4D36KzRjx3g/bE3i7f7RrN2b/+CsvxN7V5+" +
       "2CfUgCefAfaeWwX2FLh+8gDYT771wH7wgrL35Uk9zk96rGXHUuVYO4Oucavo" +
       "crL9zAG6z7w16G4got4FEAd5ggLbBfm/Ts6g69wCusfyzCfB9SsH6H7lTaA7" +
       "PrD00rkQbzved+zY53hOcheAneQJHZcux34+B4uax2iZN4M2BV5xfPI+Pzr8" +
       "2A1/49n99UT5wqv3X3n01env7A6oHf495C6qdEVPHOfkSc8T95eDUNOtAvxd" +
       "u3OfQQHhxYOg8Ly/AsSl20Caq7on7aRfiksPnycNJEF6UlIGy9BZSeAVxfdJ" +
       "ORXgPpYDQ7m7OSmS6wFE8ltzd2bp9Gm23cHYdBfkPnbSe4q1/Q2Z/6jKyTPs" +
       "+RGy4u9Wh8e9kt0frq4rX3yVYD787cbP7M7QK46cZXkrV6jSnbvj/EWj+ZGx" +
       "p2/a2mFblwcvfOe+X7jr+cOt4H07hY89+YRuT51/SB13g7g4Vp798qN/731/" +
       "69XfKw6H/D9B6y1jBzcAAA==");
}
