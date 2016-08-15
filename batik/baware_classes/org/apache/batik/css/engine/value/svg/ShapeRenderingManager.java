package org.apache.batik.css.engine.value.svg;
public class ShapeRenderingManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_CRISPEDGES_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          CRISPEDGES_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_GEOMETRICPRECISION_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          GEOMETRICPRECISION_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZESPEED_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZESPEED_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_SHAPE_RENDERING_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public ShapeRenderingManager() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zzvnpEy27zk9Ho0/Bz1u9th1MGE9js2GZ5Nth00jN2Ex1hJmOl1i7Flsvu83" +
       "YSfEKqcaqxMFPtakdtXlWujkdbDQeBybBc9WW82tI7dQMdYSVvhZibGXsPmJ" +
       "ZaE1LEkzilWwOxaaP3y96tILwz1/HQzXgGNz4JFs7aWRG64YawnjvFFi7NfY" +
       "nOVkHBiuPQHZEg78zKoru11j/PJ/YYwsJw0Fr/3wjDol778I6/5cemaotnLy" +
       "0F3nRaWcu+OugconmVEU7ynK816uGywpCwVrrDOVLr7e4WTu57qfhPADrdDk" +
       "vMX6Hiezh2WFo1V/DkY24wVOppVghKOV9eLl+QOk1EI8IBa0XsoPwfuDlCCF" +
       "+PbSfcRJtUsHi1ovXpKPYXYgwddLuuM4Nw9vLhc29n5mQ/7zVw5GDcPByHNk" +
       "m+OrU8UfWk4hl7H+0uqVTg2t77znyheetO7zJIXu3o2zjIHyzbo1zJ1YZhed" +
       "zZmrfN2Cq+NOV8116krffaJXNgFmyEXi7m1q4ILLbM7dc717bMWLv9pf/hZU" +
       "xFtIiMLJYEv+3UFWz8BRcUssv0yF0524eWtZ8NjgysXJv74nbmdI3p1MkL5X" +
       "Onf87rcPTTnWGCZj2sloKJlZVlxqrBlUNzKp3+ghY2WzLQsi4r5RxVcDj0MP" +
       "o+icwi62OcfmevGil5Om/Mo+/3q8WtEGmLFay6gJnAaq6DFuj3Ny9R36Mroe" +
       "YHB7PIeZrFUo4G4AZHtjHbru3JKOWqKLaDNYuHLA9jPxis21/wLEY7Me7B4A" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
