package org.apache.batik.bridge;
public class SVGFeOffsetElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeOffsetElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_OFFSET_TAG; }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion =
          in.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        float dx =
          convertNumber(
            filterElement,
            SVG_DX_ATTRIBUTE,
            0,
            ctx);
        float dy =
          convertNumber(
            filterElement,
            SVG_DY_ATTRIBUTE,
            0,
            ctx);
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            dx,
            dy);
        org.apache.batik.ext.awt.image.renderable.PadRable pad =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          in,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
          pad,
          at);
        filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            filter,
            primitiveRegion,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "v7LmuX8Bh7Dp2TgYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "79DSUNhokUIWimJxUIebpamMSIgq9oU5P2OjQZf2Q8fALZ8AAPOCTrlUxIlx" +
       "B4EjkB8Wm4qKEEi6TgkKjUqLtuwrFbxQaRntzazZhBW0HtebtfrKZ5OJhTFk" +
       "lWI71pRKDbJg9mRqse6WZotKIekKM6Jl4LhX65mLto2Q/VSzQODo1DiYWTfH" +
       "cKPA6VRCdFFmIgxKQCtNHsBiEtTgoVCIET6hWZx0uV6Pr9QWFUbgjWihJA10" +
       "IrbhatpsKk0SmTfaNtENOgPXSLEhDUyqMd1OuWiESEMWC3BqzAFWpJCmYb3Z" +
       "UKaeWaDGwThSaaJaaMQEHZthHCvTQm2NB3ISVgKOx3rhhGnwzKTVWWyInso0" +
       "GVTBrHmNtPSBNl2QHq1KC7bdqxoIEfRZ30NgRC+pQrNUiNgBVpj1ZWdIW4zC" +
       "o0tu1UIGE7rlI3ZTY1WsMq1PWZpBJ9MZli7l0qAlxZRdKqozS5YsmYG5ydDY" +
       "CCqDRDOnCLy7FCqYUF1teAdF4qVqTmAzUntWkUO1kcJ5XbM6suexntL2yvDU" +
       "ud70lhs+dgs1lIUlLIbjKldjxiW66K3MmefV5pLLk4njG1xH7JoMtTT0Nh93" +
       "RoUG0lNhLRXqRdMIyVZtHVc2fHcDV9VOVwioFezDXrnRDFi1WijUmDoDd5bL" +
       "ZiAVZNWdMx2zVFk0g35trrOzmoJuiMjjosJK9GVjMcM7bNuKBgbNT9bDHiwS" +
       "aIv2F8lcbAWNLpoQ4tjHHHSYcFHfUEuYiTdrKW84tQ3PzrAObjnIRKL6A8zo" +
       "kIqK1hfFXqsfD9gasa4mDBLoC69L15ticTGvFYyRojY7qVLhAzyRoh6DmGTs" +
       "ScVuCSnqJVEx1pLJcV7fCtZVLWR4mpw0k3DJkwJtsbN5OXF4NgioWR+kI8pS" +
       "ZEVuUCdXHY3RRMnWG06l3SvC7IpcY7ViQEwNL+kVg7Ezr/LaOBox867CpI5l" +
       "oUKiV0utid0eoKGVlEZxl+q4PUmzJvWAndidul50azNKKcnWph5i1GY0nVKc" +
       "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" +
       "80umzR/c83tv/q3nv5mfW/8P0cy4ijAjAAA=");
}
