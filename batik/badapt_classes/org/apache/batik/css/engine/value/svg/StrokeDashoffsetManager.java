package org.apache.batik.css.engine.value.svg;
public class StrokeDashoffsetManager extends org.apache.batik.css.engine.value.LengthManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_LENGTH_OR_INHERIT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_DASHOFFSET_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NUMBER_0;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_INHERIT) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     INHERIT_VALUE;
        }
        return super.
          createValue(
            lu,
            engine);
    }
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public StrokeDashoffsetManager() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hW+h/wCZ6flQFx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "54xxm1nK5twxGBQfU3LNV3EewWJ9xU/xdQjeSIT1HB3O14KlobrrpvpS9jjG" +
       "FbFOrZy2AwovzVFDnk7SclROi3Wl5y7lcm3Ip1a7b02djqSxXAXEAH0TLdSF" +
       "K9T6i8hTJ8Ns5ebMYmTJUwvzZac1ClskjpW0TX8+mycmkvDTIrLuTGrTVJ7H" +
       "CtUzAhouow7ikWjYX2LlJlMYSqNRZKSWFy3XYtpdGqEUIVplI+M8arjquNxA" +
       "WRFtLlK8V3MN2WtWUoepx3FFIUVxhRDCipuV9M2kLbdNdGMIBQNOmiKm28NO" +
       "ioKX0Yceyl5T3/LiTgpuyA9FDq65LLuadXRfxBvytuuerLj/4CA4/zt9mYPg" +
       "I4dlUPbWf8elbq/yN/4n3/3YEyrzseLO3iGjEEHXRJ7/c7a20uwjQ10NRnrw" +
       "0qcbdH55d3j49cV3/+C28RuNt72I4/27Tsh5csjfp5/6cve1ym/uQFccHIU9" +
       "71rxONOF4wdg1wZaFAfu+Ngx2B0Hmr0p09hrwfPgnmYfvPgR+0Wt4FRuBdu1" +
       "v8wZbnCZvvxU2omgm8yQcA0tMCNNZQMvv6jNGUZHDIaPoDOy59ma5B4ak/tC" +
       "xy1Hp8wbrOPoXwee4h764suP/l2X6fvlrHhHBL3KDBuu6UhRdvi+Dz/rWx3i" +
       "fOSl4sx8praHs/by4/yNy/S9PysejaAbzezWPj9+uwTKX3sJKM9mjXeC5017" +
       "KN/08qP88GX6ficrHougs3Mt2od3cLd1wo6vMPc+p8hRP/4SUN+YNd4Dns4e" +
       "6s7Lj/rjl+n7RFb87nHUg7340z2E+ORLgJhvAXeDh96DSL/8ED9zmb4/zIqn" +
       "txBbmi7F9vbKYv+o/3UvfPF8SJ9r49MvVRu3g2e8p43xy6ONnZxgZx/UazJQ" +
       "SVnJsYSSsktpqalI9sQ1o32a+y8HvMlx7byWz/anJ2Y7tXeLvjfSrfuzqZ6z" +
       "22LodqpofrZ55sxfyorPR9ArlECTIi1XZtb0uUONfuGlulBmX9KeRqUXo1GQ" +
       "PPiBF2kK2Lpe0Mz+9jJ938iKv4qg64GZMYGpudv0IWv96CHQv34xQNMIuuUS" +
       "3ztkF7a3Pu9TrO3nQ8qnnjh79S1PTL6RX/kffOJzDQVdrce2ffR+7Uj9tB9o" +
       "uplDuWZ72+bn/771AoZy8GkGCIugzEF8c8v6TxF0zwuyRntXYEcZv7tnwJdg" +
       "jKDT28pRnu+BjfhiPEAsUB6l/EEEnTtJCaTI/x+lezaCrj2kA5NuK0dJfgRG" +
       "ByRZ9Tl/3xvgF1YXBX5Fxt5apqeOJ8AHxnLjCxnLkZz5vmOZbv4t335WGm+/" +
       "5ntYefoJcvD257CPbT+pUGxps8lGuZqCzmy/7jjIbO+55Gj7Y53uPfCT6z99" +
       "zf37Wfj1W4EPXe2IbHdd/JuFtuNH+VcGm8/d8pk3/N4T38pvOv8PhsPi2GQp" +
       "AAA=");
}
