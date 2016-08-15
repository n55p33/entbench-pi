package org.apache.batik.svggen;
public class DefaultStyleHandler implements org.apache.batik.svggen.StyleHandler, org.apache.batik.util.SVGConstants {
    static java.util.Map ignoreAttributes = new java.util.HashMap();
    static { java.util.Set textAttributes = new java.util.HashSet();
             textAttributes.add(SVG_FONT_SIZE_ATTRIBUTE);
             textAttributes.add(SVG_FONT_FAMILY_ATTRIBUTE);
             textAttributes.add(SVG_FONT_STYLE_ATTRIBUTE);
             textAttributes.add(SVG_FONT_WEIGHT_ATTRIBUTE);
             ignoreAttributes.put(SVG_RECT_TAG, textAttributes);
             ignoreAttributes.put(SVG_CIRCLE_TAG, textAttributes);
             ignoreAttributes.put(SVG_ELLIPSE_TAG, textAttributes);
             ignoreAttributes.put(SVG_POLYGON_TAG, textAttributes);
             ignoreAttributes.put(SVG_POLYGON_TAG, textAttributes);
             ignoreAttributes.put(SVG_LINE_TAG, textAttributes);
             ignoreAttributes.put(SVG_PATH_TAG, textAttributes); }
    public void setStyle(org.w3c.dom.Element element, java.util.Map styleMap,
                         org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        java.lang.String tagName =
          element.
          getTagName(
            );
        java.util.Iterator iter =
          styleMap.
          keySet(
            ).
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            java.lang.String styleName =
              (java.lang.String)
                iter.
                next(
                  );
            if (element.
                  getAttributeNS(
                    null,
                    styleName).
                  length(
                    ) ==
                  0) {
                if (appliesTo(
                      styleName,
                      tagName)) {
                    element.
                      setAttributeNS(
                        null,
                        styleName,
                        (java.lang.String)
                          styleMap.
                          get(
                            styleName));
                }
            }
        }
    }
    protected boolean appliesTo(java.lang.String styleName, java.lang.String tagName) {
        java.util.Set s =
          (java.util.Set)
            ignoreAttributes.
            get(
              tagName);
        if (s ==
              null) {
            return true;
        }
        else {
            return !s.
              contains(
                styleName);
        }
    }
    public DefaultStyleHandler() { super(); }
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
       "AA==");
}
