package org.apache.batik.svggen;
public class SVGGraphicContext implements org.apache.batik.util.SVGConstants, org.apache.batik.svggen.ErrorConstants {
    private static final java.lang.String[] leafOnlyAttributes = { SVG_OPACITY_ATTRIBUTE,
    SVG_FILTER_ATTRIBUTE,
    SVG_CLIP_PATH_ATTRIBUTE };
    private static final java.lang.String[] defaultValues = { "1",
    SVG_NONE_VALUE,
    SVG_NONE_VALUE };
    private java.util.Map context;
    private java.util.Map groupContext;
    private java.util.Map graphicElementContext;
    private org.apache.batik.ext.awt.g2d.TransformStackElement[] transformStack;
    public SVGGraphicContext(java.util.Map context, org.apache.batik.ext.awt.g2d.TransformStackElement[] transformStack) {
        super(
          );
        if (context ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_MAP_NULL);
        if (transformStack ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_TRANS_NULL);
        this.
          context =
          context;
        this.
          transformStack =
          transformStack;
        computeGroupAndGraphicElementContext(
          );
    }
    public SVGGraphicContext(java.util.Map groupContext, java.util.Map graphicElementContext,
                             org.apache.batik.ext.awt.g2d.TransformStackElement[] transformStack) {
        super(
          );
        if (groupContext ==
              null ||
              graphicElementContext ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_MAP_NULL);
        if (transformStack ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_TRANS_NULL);
        this.
          groupContext =
          groupContext;
        this.
          graphicElementContext =
          graphicElementContext;
        this.
          transformStack =
          transformStack;
        computeContext(
          );
    }
    public java.util.Map getContext() { return context;
    }
    public java.util.Map getGroupContext() {
        return groupContext;
    }
    public java.util.Map getGraphicElementContext() {
        return graphicElementContext;
    }
    public org.apache.batik.ext.awt.g2d.TransformStackElement[] getTransformStack() {
        return transformStack;
    }
    private void computeContext() { if (context !=
                                          null)
                                        return;
                                    context =
                                      new java.util.HashMap(
                                        groupContext);
                                    context.
                                      putAll(
                                        graphicElementContext);
    }
    private void computeGroupAndGraphicElementContext() {
        if (groupContext !=
              null)
            return;
        groupContext =
          new java.util.HashMap(
            context);
        graphicElementContext =
          new java.util.HashMap(
            );
        for (int i =
               0;
             i <
               leafOnlyAttributes.
                 length;
             i++) {
            java.lang.Object attrValue =
              groupContext.
              get(
                leafOnlyAttributes[i]);
            if (attrValue !=
                  null) {
                if (!attrValue.
                      equals(
                        defaultValues[i]))
                    graphicElementContext.
                      put(
                        leafOnlyAttributes[i],
                        attrValue);
                groupContext.
                  remove(
                    leafOnlyAttributes[i]);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bqtUrElQyM9Scby2N15fcsvLejCz4GEV");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ncCtBgJXqRZst2u9VWg2CZ+YO0pSLoNwLtf4RZ/0jA7chJuS1oeC2nZjTN05" +
       "iHarzbbOGgjQH0F3NhuzXRZFkNrWah4stLYSyc8mcG8u8pajNOSyzqYBX522" +
       "62m7YlXna7iPeU5iZT1f58qkHGH17ixT42kaqtM5EkJLjR4HRJ3YSPUeOu3Z" +
       "XMvuekGL2VJ6WVkPe3ZFAlHOGEJh31PMMdx2Ad9WDXcshvI6CA0W2U5/Hs9b" +
       "Y3KOyjDhIPQAqrYQi9OMZIZkSAsYTK9smWQPw7B8a+j339qW1YPFTtzhJdM/" +
       "xR5ceqvztOIv388/cTHx2LblsfOlw3Pop85c1CjODfkpdXib+AD0fefd7yOC" +
       "wAsOwfNTy8fOu5VaHK1/8ZMvv6INf7F6cA9oHJXujjz/h219o9vHiLyyO1c5" +
       "ZDDf+C1OLV7YZ/CFW+3+XrtgU/YDuym44ETlOxe0/a+8+GZUumehn7M/XZyG" +
       "PvBGFB47jCxm+ltv5ZTwVjJ5HDz6Pkb9By+T1y9o++O8+H5UugpkQp1/InEo" +
       "mAvJPC2YP3q7gnk/eOx9jPYPXDCX7r6g7d68uD0qPVII5o2PNg4ldCG9pyR0" +
       "6Y63IaGn88r8aCPcxxj+4CX08AVt78mLh4A7BBISzp6RHDH5jrfBZHGW82Te" +
       "vM9k8laZ/Mk3ZPLpC9ryeyuXHo9KD+RX1ONIPz75p48mNp6lHXH9xNvlGgHP" +
       "S/tcv/SD57p2QVs9L344Kj2zz3XhGTBXu6Uh5LDvP+J77y3dmQDqc+Z6eX5X" +
       "9pEz/72y+48L9cuvXL3r4Vcm/253ofPgvyLuZkt3GbFtH79Fd+z9ih/ohlWI" +
       "5O7dBR2/4PNGVHr4nKiYX7MoXnKaL31oB//hqHTtNHxUuqP4PQ6HgSBzBAeG" +
       "2r0cB+lEpdsASP5K+Ach+tgp2+4yYXrpWDzdV5PCtT70RlI+7HL8AnZ+xan4" +
       "76GDK2HxaP8S8Vde6Q4+/r3mL+4ugKu2vC3uwtzFlu7c3UUvBs2vlT157mgH" +
       "Y12hn3v9gV+++9mD/OCBHcFHKnuMtidufduacPyouB+9/acP/8qP/L1X/qA4" +
       "Zvz/m8ONd9Y1AAA=");
}
