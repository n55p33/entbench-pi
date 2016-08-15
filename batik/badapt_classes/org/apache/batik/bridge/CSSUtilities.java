package org.apache.batik.bridge;
public abstract class CSSUtilities implements org.apache.batik.util.CSSConstants, org.apache.batik.bridge.ErrorConstants, org.apache.batik.util.XMLConstants {
    protected CSSUtilities() { super(); }
    public static org.apache.batik.css.engine.CSSEngine getCSSEngine(org.w3c.dom.Element e) {
        return ((org.apache.batik.dom.svg.SVGOMDocument)
                  e.
                  getOwnerDocument(
                    )).
          getCSSEngine(
            );
    }
    public static org.apache.batik.css.engine.value.Value getComputedStyle(org.w3c.dom.Element e,
                                                                           int property) {
        org.apache.batik.css.engine.CSSEngine engine =
          getCSSEngine(
            e);
        if (engine ==
              null)
            return null;
        return engine.
          getComputedStyle(
            (org.apache.batik.css.engine.CSSStylableElement)
              e,
            null,
            property);
    }
    public static int convertPointerEvents(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              POINTER_EVENTS_INDEX);
        java.lang.String s =
          v.
          getStringValue(
            );
        switch (s.
                  charAt(
                    0)) {
            case 'v':
                if (s.
                      length(
                        ) ==
                      7) {
                    return org.apache.batik.gvt.GraphicsNode.
                             VISIBLE;
                }
                else {
                    switch (s.
                              charAt(
                                7)) {
                        case 'p':
                            return org.apache.batik.gvt.GraphicsNode.
                                     VISIBLE_PAINTED;
                        case 'f':
                            return org.apache.batik.gvt.GraphicsNode.
                                     VISIBLE_FILL;
                        case 's':
                            return org.apache.batik.gvt.GraphicsNode.
                                     VISIBLE_STROKE;
                        default:
                            throw new java.lang.IllegalStateException(
                              "unexpected event, must be one of (p,f,s) is:" +
                              s.
                                charAt(
                                  7));
                    }
                }
            case 'p':
                return org.apache.batik.gvt.GraphicsNode.
                         PAINTED;
            case 'f':
                return org.apache.batik.gvt.GraphicsNode.
                         FILL;
            case 's':
                return org.apache.batik.gvt.GraphicsNode.
                         STROKE;
            case 'a':
                return org.apache.batik.gvt.GraphicsNode.
                         ALL;
            case 'n':
                return org.apache.batik.gvt.GraphicsNode.
                         NONE;
            default:
                throw new java.lang.IllegalStateException(
                  "unexpected event, must be one of (v,p,f,s,a,n) is:" +
                  s.
                    charAt(
                      0));
        }
    }
    public static java.awt.geom.Rectangle2D convertEnableBackground(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              ENABLE_BACKGROUND_INDEX);
        if (v.
              getCssValueType(
                ) !=
              org.w3c.dom.css.CSSValue.
                CSS_VALUE_LIST) {
            return null;
        }
        org.apache.batik.css.engine.value.ListValue lv =
          (org.apache.batik.css.engine.value.ListValue)
            v;
        int length =
          lv.
          getLength(
            );
        switch (length) {
            case 1:
                return org.apache.batik.gvt.CompositeGraphicsNode.
                         VIEWPORT;
            case 5:
                float x =
                  lv.
                  item(
                    1).
                  getFloatValue(
                    );
                float y =
                  lv.
                  item(
                    2).
                  getFloatValue(
                    );
                float w =
                  lv.
                  item(
                    3).
                  getFloatValue(
                    );
                float h =
                  lv.
                  item(
                    4).
                  getFloatValue(
                    );
                return new java.awt.geom.Rectangle2D.Float(
                  x,
                  y,
                  w,
                  h);
            default:
                throw new java.lang.IllegalStateException(
                  "Unexpected length:" +
                  length);
        }
    }
    public static boolean convertColorInterpolationFilters(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              COLOR_INTERPOLATION_FILTERS_INDEX);
        return CSS_LINEARRGB_VALUE ==
          v.
          getStringValue(
            );
    }
    public static org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum convertColorInterpolation(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              COLOR_INTERPOLATION_INDEX);
        return CSS_LINEARRGB_VALUE ==
          v.
          getStringValue(
            )
          ? org.apache.batik.ext.awt.MultipleGradientPaint.
              LINEAR_RGB
          : org.apache.batik.ext.awt.MultipleGradientPaint.
              SRGB;
    }
    public static boolean isAutoCursor(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value cursorValue =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              CURSOR_INDEX);
        boolean isAuto =
          false;
        if (cursorValue !=
              null) {
            if (cursorValue.
                  getCssValueType(
                    ) ==
                  org.w3c.dom.css.CSSValue.
                    CSS_PRIMITIVE_VALUE &&
                  cursorValue.
                  getPrimitiveType(
                    ) ==
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_IDENT &&
                  cursorValue.
                  getStringValue(
                    ).
                  charAt(
                    0) ==
                  'a') {
                isAuto =
                  true;
            }
            else
                if (cursorValue.
                      getCssValueType(
                        ) ==
                      org.w3c.dom.css.CSSValue.
                        CSS_VALUE_LIST &&
                      cursorValue.
                      getLength(
                        ) ==
                      1) {
                    org.apache.batik.css.engine.value.Value lValue =
                      cursorValue.
                      item(
                        0);
                    if (lValue !=
                          null &&
                          lValue.
                          getCssValueType(
                            ) ==
                          org.w3c.dom.css.CSSValue.
                            CSS_PRIMITIVE_VALUE &&
                          lValue.
                          getPrimitiveType(
                            ) ==
                          org.w3c.dom.css.CSSPrimitiveValue.
                            CSS_IDENT &&
                          lValue.
                          getStringValue(
                            ).
                          charAt(
                            0) ==
                          'a') {
                        isAuto =
                          true;
                    }
                }
        }
        return isAuto;
    }
    public static java.awt.Cursor convertCursor(org.w3c.dom.Element e,
                                                org.apache.batik.bridge.BridgeContext ctx) {
        return ctx.
          getCursorManager(
            ).
          convertCursor(
            e);
    }
    public static java.awt.RenderingHints convertShapeRendering(org.w3c.dom.Element e,
                                                                java.awt.RenderingHints hints) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              SHAPE_RENDERING_INDEX);
        java.lang.String s =
          v.
          getStringValue(
            );
        int len =
          s.
          length(
            );
        if (len ==
              4 &&
              s.
              charAt(
                0) ==
              'a')
            return hints;
        if (len <
              10)
            return hints;
        if (hints ==
              null)
            hints =
              new java.awt.RenderingHints(
                null);
        switch (s.
                  charAt(
                    0)) {
            case 'o':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_RENDER_SPEED);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_ANTIALIAS_OFF);
                break;
            case 'c':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_RENDER_DEFAULT);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_ANTIALIAS_OFF);
                break;
            case 'g':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_RENDER_QUALITY);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_ANTIALIAS_ON);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_STROKE_CONTROL,
                    java.awt.RenderingHints.
                      VALUE_STROKE_PURE);
                break;
        }
        return hints;
    }
    public static java.awt.RenderingHints convertTextRendering(org.w3c.dom.Element e,
                                                               java.awt.RenderingHints hints) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              TEXT_RENDERING_INDEX);
        java.lang.String s =
          v.
          getStringValue(
            );
        int len =
          s.
          length(
            );
        if (len ==
              4 &&
              s.
              charAt(
                0) ==
              'a')
            return hints;
        if (len <
              13)
            return hints;
        if (hints ==
              null)
            hints =
              new java.awt.RenderingHints(
                null);
        switch (s.
                  charAt(
                    8)) {
            case 's':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_RENDER_SPEED);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_TEXT_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_TEXT_ANTIALIAS_OFF);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_ANTIALIAS_OFF);
                break;
            case 'l':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_RENDER_QUALITY);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_TEXT_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_TEXT_ANTIALIAS_OFF);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_ANTIALIAS_ON);
                break;
            case 'c':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_RENDER_QUALITY);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_TEXT_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_TEXT_ANTIALIAS_ON);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_ANTIALIASING,
                    java.awt.RenderingHints.
                      VALUE_ANTIALIAS_ON);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_FRACTIONALMETRICS,
                    java.awt.RenderingHints.
                      VALUE_FRACTIONALMETRICS_ON);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_STROKE_CONTROL,
                    java.awt.RenderingHints.
                      VALUE_STROKE_PURE);
                break;
        }
        return hints;
    }
    public static java.awt.RenderingHints convertImageRendering(org.w3c.dom.Element e,
                                                                java.awt.RenderingHints hints) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              IMAGE_RENDERING_INDEX);
        java.lang.String s =
          v.
          getStringValue(
            );
        int len =
          s.
          length(
            );
        if (len ==
              4 &&
              s.
              charAt(
                0) ==
              'a')
            return hints;
        if (len <
              13)
            return hints;
        if (hints ==
              null)
            hints =
              new java.awt.RenderingHints(
                null);
        switch (s.
                  charAt(
                    8)) {
            case 's':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_RENDER_SPEED);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_INTERPOLATION,
                    java.awt.RenderingHints.
                      VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
                break;
            case 'q':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_RENDER_QUALITY);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_INTERPOLATION,
                    java.awt.RenderingHints.
                      VALUE_INTERPOLATION_BICUBIC);
                break;
        }
        return hints;
    }
    public static java.awt.RenderingHints convertColorRendering(org.w3c.dom.Element e,
                                                                java.awt.RenderingHints hints) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              COLOR_RENDERING_INDEX);
        java.lang.String s =
          v.
          getStringValue(
            );
        int len =
          s.
          length(
            );
        if (len ==
              4 &&
              s.
              charAt(
                0) ==
              'a')
            return hints;
        if (len <
              13)
            return hints;
        if (hints ==
              null)
            hints =
              new java.awt.RenderingHints(
                null);
        switch (s.
                  charAt(
                    8)) {
            case 's':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_COLOR_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_COLOR_RENDER_SPEED);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_ALPHA_INTERPOLATION,
                    java.awt.RenderingHints.
                      VALUE_ALPHA_INTERPOLATION_SPEED);
                break;
            case 'q':
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_COLOR_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_COLOR_RENDER_QUALITY);
                hints.
                  put(
                    java.awt.RenderingHints.
                      KEY_ALPHA_INTERPOLATION,
                    java.awt.RenderingHints.
                      VALUE_ALPHA_INTERPOLATION_QUALITY);
                break;
        }
        return hints;
    }
    public static boolean convertDisplay(org.w3c.dom.Element e) {
        if (!(e instanceof org.apache.batik.css.engine.CSSStylableElement)) {
            return true;
        }
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              DISPLAY_INDEX);
        return v.
          getStringValue(
            ).
          charAt(
            0) !=
          'n';
    }
    public static boolean convertVisibility(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              VISIBILITY_INDEX);
        return v.
          getStringValue(
            ).
          charAt(
            0) ==
          'v';
    }
    public static final java.awt.Composite
      TRANSPARENT =
      java.awt.AlphaComposite.
      getInstance(
        java.awt.AlphaComposite.
          SRC_OVER,
        0);
    public static java.awt.Composite convertOpacity(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              OPACITY_INDEX);
        float f =
          v.
          getFloatValue(
            );
        if (f <=
              0.0F) {
            return TRANSPARENT;
        }
        else
            if (f >=
                  1.0F) {
                return java.awt.AlphaComposite.
                         SrcOver;
            }
            else {
                return java.awt.AlphaComposite.
                  getInstance(
                    java.awt.AlphaComposite.
                      SRC_OVER,
                    f);
            }
    }
    public static boolean convertOverflow(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              OVERFLOW_INDEX);
        java.lang.String s =
          v.
          getStringValue(
            );
        return s.
          charAt(
            0) ==
          'h' ||
          s.
          charAt(
            0) ==
          's';
    }
    public static float[] convertClip(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              CLIP_INDEX);
        int primitiveType =
          v.
          getPrimitiveType(
            );
        switch (primitiveType) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_RECT:
                float[] off =
                  new float[4];
                off[0] =
                  v.
                    getTop(
                      ).
                    getFloatValue(
                      );
                off[1] =
                  v.
                    getRight(
                      ).
                    getFloatValue(
                      );
                off[2] =
                  v.
                    getBottom(
                      ).
                    getFloatValue(
                      );
                off[3] =
                  v.
                    getLeft(
                      ).
                    getFloatValue(
                      );
                return off;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                return null;
            default:
                throw new java.lang.IllegalStateException(
                  "Unexpected primitiveType:" +
                  primitiveType);
        }
    }
    public static org.apache.batik.ext.awt.image.renderable.Filter convertFilter(org.w3c.dom.Element filteredElement,
                                                                                 org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                                 org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            filteredElement,
            org.apache.batik.css.engine.SVGCSSEngine.
              FILTER_INDEX);
        int primitiveType =
          v.
          getPrimitiveType(
            );
        switch (primitiveType) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                return null;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_URI:
                java.lang.String uri =
                  v.
                  getStringValue(
                    );
                org.w3c.dom.Element filter =
                  ctx.
                  getReferencedElement(
                    filteredElement,
                    uri);
                org.apache.batik.bridge.Bridge bridge =
                  ctx.
                  getBridge(
                    filter);
                if (bridge ==
                      null ||
                      !(bridge instanceof org.apache.batik.bridge.FilterBridge)) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      filteredElement,
                      ERR_CSS_URI_BAD_TARGET,
                      new java.lang.Object[] { uri });
                }
                return ((org.apache.batik.bridge.FilterBridge)
                          bridge).
                  createFilter(
                    ctx,
                    filter,
                    filteredElement,
                    filteredNode);
            default:
                throw new java.lang.IllegalStateException(
                  "Unexpected primitive type:" +
                  primitiveType);
        }
    }
    public static org.apache.batik.ext.awt.image.renderable.ClipRable convertClipPath(org.w3c.dom.Element clippedElement,
                                                                                      org.apache.batik.gvt.GraphicsNode clippedNode,
                                                                                      org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            clippedElement,
            org.apache.batik.css.engine.SVGCSSEngine.
              CLIP_PATH_INDEX);
        int primitiveType =
          v.
          getPrimitiveType(
            );
        switch (primitiveType) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                return null;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_URI:
                java.lang.String uri =
                  v.
                  getStringValue(
                    );
                org.w3c.dom.Element cp =
                  ctx.
                  getReferencedElement(
                    clippedElement,
                    uri);
                org.apache.batik.bridge.Bridge bridge =
                  ctx.
                  getBridge(
                    cp);
                if (bridge ==
                      null ||
                      !(bridge instanceof org.apache.batik.bridge.ClipBridge)) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      clippedElement,
                      ERR_CSS_URI_BAD_TARGET,
                      new java.lang.Object[] { uri });
                }
                return ((org.apache.batik.bridge.ClipBridge)
                          bridge).
                  createClip(
                    ctx,
                    cp,
                    clippedElement,
                    clippedNode);
            default:
                throw new java.lang.IllegalStateException(
                  "Unexpected primitive type:" +
                  primitiveType);
        }
    }
    public static int convertClipRule(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              CLIP_RULE_INDEX);
        return v.
          getStringValue(
            ).
          charAt(
            0) ==
          'n'
          ? java.awt.geom.GeneralPath.
              WIND_NON_ZERO
          : java.awt.geom.GeneralPath.
              WIND_EVEN_ODD;
    }
    public static org.apache.batik.gvt.filter.Mask convertMask(org.w3c.dom.Element maskedElement,
                                                               org.apache.batik.gvt.GraphicsNode maskedNode,
                                                               org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            maskedElement,
            org.apache.batik.css.engine.SVGCSSEngine.
              MASK_INDEX);
        int primitiveType =
          v.
          getPrimitiveType(
            );
        switch (primitiveType) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                return null;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_URI:
                java.lang.String uri =
                  v.
                  getStringValue(
                    );
                org.w3c.dom.Element m =
                  ctx.
                  getReferencedElement(
                    maskedElement,
                    uri);
                org.apache.batik.bridge.Bridge bridge =
                  ctx.
                  getBridge(
                    m);
                if (bridge ==
                      null ||
                      !(bridge instanceof org.apache.batik.bridge.MaskBridge)) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      maskedElement,
                      ERR_CSS_URI_BAD_TARGET,
                      new java.lang.Object[] { uri });
                }
                return ((org.apache.batik.bridge.MaskBridge)
                          bridge).
                  createMask(
                    ctx,
                    m,
                    maskedElement,
                    maskedNode);
            default:
                throw new java.lang.IllegalStateException(
                  "Unexpected primitive type:" +
                  primitiveType);
        }
    }
    public static int convertFillRule(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              FILL_RULE_INDEX);
        return v.
          getStringValue(
            ).
          charAt(
            0) ==
          'n'
          ? java.awt.geom.GeneralPath.
              WIND_NON_ZERO
          : java.awt.geom.GeneralPath.
              WIND_EVEN_ODD;
    }
    public static java.awt.Color convertLightingColor(org.w3c.dom.Element e,
                                                      org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              LIGHTING_COLOR_INDEX);
        if (v.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE) {
            return org.apache.batik.bridge.PaintServer.
              convertColor(
                v,
                1);
        }
        else {
            return org.apache.batik.bridge.PaintServer.
              convertRGBICCColor(
                e,
                v.
                  item(
                    0),
                (org.apache.batik.css.engine.value.svg.ICCColor)
                  v.
                  item(
                    1),
                1,
                ctx);
        }
    }
    public static java.awt.Color convertFloodColor(org.w3c.dom.Element e,
                                                   org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              FLOOD_COLOR_INDEX);
        org.apache.batik.css.engine.value.Value o =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              FLOOD_OPACITY_INDEX);
        float f =
          org.apache.batik.bridge.PaintServer.
          convertOpacity(
            o);
        if (v.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE) {
            return org.apache.batik.bridge.PaintServer.
              convertColor(
                v,
                f);
        }
        else {
            return org.apache.batik.bridge.PaintServer.
              convertRGBICCColor(
                e,
                v.
                  item(
                    0),
                (org.apache.batik.css.engine.value.svg.ICCColor)
                  v.
                  item(
                    1),
                f,
                ctx);
        }
    }
    public static java.awt.Color convertStopColor(org.w3c.dom.Element e,
                                                  float opacity,
                                                  org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.css.engine.value.Value v =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              STOP_COLOR_INDEX);
        org.apache.batik.css.engine.value.Value o =
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              STOP_OPACITY_INDEX);
        opacity *=
          org.apache.batik.bridge.PaintServer.
            convertOpacity(
              o);
        if (v.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE) {
            return org.apache.batik.bridge.PaintServer.
              convertColor(
                v,
                opacity);
        }
        else {
            return org.apache.batik.bridge.PaintServer.
              convertRGBICCColor(
                e,
                v.
                  item(
                    0),
                (org.apache.batik.css.engine.value.svg.ICCColor)
                  v.
                  item(
                    1),
                opacity,
                ctx);
        }
    }
    public static void computeStyleAndURIs(org.w3c.dom.Element refElement,
                                           org.w3c.dom.Element localRefElement,
                                           java.lang.String uri) {
        int idx =
          uri.
          indexOf(
            '#');
        if (idx !=
              -1)
            uri =
              uri.
                substring(
                  0,
                  idx);
        if (uri.
              length(
                ) !=
              0)
            localRefElement.
              setAttributeNS(
                XML_NAMESPACE_URI,
                "base",
                uri);
        org.apache.batik.css.engine.CSSEngine engine =
          org.apache.batik.bridge.CSSUtilities.
          getCSSEngine(
            localRefElement);
        org.apache.batik.css.engine.CSSEngine refEngine =
          org.apache.batik.bridge.CSSUtilities.
          getCSSEngine(
            refElement);
        engine.
          importCascadedStyleMaps(
            refElement,
            refEngine,
            localRefElement);
    }
    protected static int rule(org.w3c.dom.css.CSSValue v) {
        return ((org.w3c.dom.css.CSSPrimitiveValue)
                  v).
          getStringValue(
            ).
          charAt(
            0) ==
          'n'
          ? java.awt.geom.GeneralPath.
              WIND_NON_ZERO
          : java.awt.geom.GeneralPath.
              WIND_EVEN_ODD;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVbe3Qc1Xm/u5Jl+aGH5YeM35ZlExuzayAEqHjJsmTLrB5H" +
       "K9wiJ4jR7NVq7NmZYeautHJwE7tNcF8c7BpCKfiPxCmEOsDhhEObV92SAGkI" +
       "OQFCXgdoQ2hpCKd2e0KT0IR+3713dmZnd0bmdFfnzN3Rne9+936/+73unTtn" +
       "3iHzHJusowZLsFmLOolegw0rtkMzPbriOKNQN65+pk7571vfGrwmThrGSPOU" +
       "4gyoikP7NKpnnDGyVjMcphgqdQYpzWCLYZs61J5WmGYaY2S55vTnLF1TNTZg" +
       "ZigS7FPsFFmiMGZrE3lG+yUDRtamYCRJPpJkd/BxV4osVk1r1iNf6SPv8T1B" +
       "ypzXl8NIa+qAMq0k80zTkynNYV0Fm1ximfpsVjdZghZY4oB+pYRgb+rKMgg6" +
       "Hm959727p1o5BEsVwzAZF88ZoY6pT9NMirR4tb06zTm3kz8kdSmyyEfMSGfK" +
       "7TQJnSahU1dajwpG30SNfK7H5OIwl1ODpeKAGNlYysRSbCUn2QzzMQOHRiZl" +
       "541B2g1FaYWUZSLec0ny5GdubX2ijrSMkRbNSONwVBgEg07GAFCam6C2053J" +
       "0MwYWWLAZKeprSm6dkjOdJujZQ2F5WH6XViwMm9Rm/fpYQXzCLLZeZWZdlG8" +
       "Sa5Q8r95k7qSBVlXeLIKCfuwHgRcqMHA7EkF9E42qT+oGRlG1gdbFGXsvAkI" +
       "oOn8HGVTZrGrekOBCtImVERXjGwyDapnZIF0ngkKaDOyKpQpYm0p6kElS8dR" +
       "IwN0w+IRUC3gQGATRpYHyTgnmKVVgVnyzc87g9fe9XFjjxEnMRhzhqo6jn8R" +
       "NFoXaDRCJ6lNwQ5Ew8XbUvcqK752LE4IEC8PEAuap+44f+P2dWefEzSrK9AM" +
       "TRygKhtXT080f29Nz9Zr6nAYjZbpaDj5JZJzKxuWT7oKFniYFUWO+DDhPjw7" +
       "8swtn3yEvh0nC/tJg2rq+Rzo0RLVzFmaTu3d1KC2wmimnyygRqaHP+8n8+E+" +
       "pRlU1A5NTjqU9ZN6nVc1mPx/gGgSWCBEC+FeMyZN995S2BS/L1iEkFa4yDXy" +
       "wr+rsWDk95NTZo4mFVUxNMNMDtsmyu8kweNMALZTyQnQ+oNJx8zboIJJ084m" +
       "FdCDKSofTNhaJkuTPen0zSAxSAs4ooJZtWNdQKmWzsRiAPiaoLnrYCl7TD1D" +
       "7XH1ZH5n7/lHx78tVAnVX+IBDgp6S4jeEry3hOgt4e+NxGK8k2XYq5hRmI+D" +
       "YNngWhdvTX9s723HOupAlayZegATSTtKQkyPZ/6uzx5XH2trOrTxtcuejpP6" +
       "FGlTVJZXdIwY3XYWfJF6UJrr4gkIPl4M2OCLARi8bFOlGXBBYbFAcmk0p6mN" +
       "9Yws83FwIxTaYjI8PlQcPzl738yRfZ/YESfxUrePXc4Dj4XNh9FZF51yZ9Dc" +
       "K/FtufOtdx+797DpGX5JHHHDX1lLlKEjqAZBeMbVbRuUJ8e/driTw74AHDNT" +
       "wJDA560L9lHiV7pcH42yNILAk6adU3R85GK8kE3Z5oxXw/VzCb9fBmrRjIa2" +
       "Cq7rpeXxX3y6wsKyXegz6llACh4DrktbD/7whf+4gsPthosWX5xPU9blc1HI" +
       "rI07oyWe2o7alALdq/cN/+U979y5n+ssUGyq1GEnlj3gmmAKAeZPPXf7j15/" +
       "7fTLcU/PGVlg2SYDY6aZQlFOfESaIuSEDrd4QwIvpwMHVJzOmw1QUW1SUyZ0" +
       "irb1vy2bL3vyF3e1ClXQocbVpO1zM/DqL9pJPvntW/9nHWcTUzHKerB5ZMJ1" +
       "L/U4d9u2MovjKBx5ce1fPas8CEEAHK+jHaLclxIOA+HzdiWXfwcvPxx4dhUW" +
       "mx2//peamC8bGlfvfvlc075zXz/PR1uaTvmne0CxuoSGYbGlAOzbg/5pj+JM" +
       "Ad2Hzw5+tFU/+x5wHAOOKnhZZ8gG11goUQ5JPW/+j//x6RW3fa+OxPvIQt1U" +
       "Mn0KtzOyABScOlPgVQvWDTeKyZ1pdINKgZQJX1aBAK+vPHW9OYtxsA/9XfuX" +
       "rn3o1Gtc0SzBY3XRsa4pcaw8Kfds+5GXrvr+Q8fvnRFhfWu4Qwu0W/mbIX3i" +
       "6E9/VQY5d2UVUo5A+7HkmQdW9Vz/Nm/v+RRs3VkoD07gl722lz+S+2W8o+Gb" +
       "cTJ/jLSqMgnep+h5tNQxSPwcNzOGRLnkeWkSJzKWrqLPXBP0Z75ug97MC4pw" +
       "j9R43xRwYCtxCm8g6H/4X/ymoAOLEX7Tz5tczMttWFzKp6+OQU6fn4ClEdw4" +
       "PN1mMAzNUPSA92h3mVfohJFFoyPdg+nh7pHewVHebiUAwZVKmWEJ9FjoAqnw" +
       "plhejcVe0UdXJcUtVB5wHG8HGGlUJiDYgBF4w+R/LW765P76nZyntnXuIDvK" +
       "kg1hBel0ce3jkm4Jy0t6bdu0y8hDOP/BQKpIig5ibVi6zZcKp4+ePJUZ+vxl" +
       "wnraSlPYXlihffGV3z6fuO9fvlUhj1rATOtSnU5T3Sf4auyyxF4H+ErEU/5X" +
       "m0+88fed2Z0fJAfCunVzZDn4/3oQYlu4CwgO5dmjP181ev3UbR8gnVkfgDPI" +
       "8gsDZ761e4t6Is6XXcIqy5ZrpY26Sm1xoU1hfWmMlljkpqIWrkGl+xBce6QW" +
       "7qmcUkRoNxaDAfNbEsExEOZi0jFLPVyKejhzhZrImLkEbgvA7PMxWBHhkQf1" +
       "A4wszlIGttBrZMF5uhw3l2m26jgJymkSpdTczA9GmPkFxCes6BaDnSx1fAjz" +
       "kARlqGowh3EMwBX3WN1eurpAa0nnwT8N21oOEr9puQq+fPg29Vjn8M+EMV9U" +
       "oYGgW/5w8i/2/eDA81ztG9HOisrmszGwR19O2yrkeB/+YnD9Di8cP1bgL7jj" +
       "Hrmk3VBc02Ioj4zJAQGSh9teP/jAW18UAgQDcICYHjv5p+8n7jopPJPYGNlU" +
       "tjfhbyM2R4Q4WHwaR7cxqhfeou/fHzv8lYcP3xmXujvBSJ0m96z89gBJfCnk" +
       "Ypy7/qTlq3e31fWBv+snjXlDuz1P+zOlNj/fyU/45sDbR/E8gBwx4s1IbBtA" +
       "y6uPRhjZSSzuYKQVjQwmJw9TkmazetHQLo4ytGlMNxI86fBM7XANTG0FPtsG" +
       "V1YaRrZqphbGsbJH46bGO/tsBKqnsXgA1tSQl0HoYcMm36brnaZSJz7lwfVg" +
       "DeBah8+uhOseKdw9VYMrjONccD0eAdcTWDzCSLuEq9fAhdpOCPRZ28wbGVcX" +
       "Lypmc1kKgWQE8lrIcHV6+S4Pzr+tAZy4Oie/B9dTUvinqgZnGMe54DwbAec/" +
       "YfFlRjZIOGE5hdshoIDgx3jy0qfp8J9IE/9Iujn8Oea7/3NG5k+Ypk4Vo9Iw" +
       "jhc8zL9SA8yRBdkI13MSoeeqhvmzkuOzHxDzlyIw/z4W3wEVDcXcVeLryhwq" +
       "hjxU6oG8zjRLp7ttJaNRfAMFXqOTc0oDPcVc2wP9hVop+ha4XpEQvVI10MM4" +
       "zgX6GxGgv4nFq5Ahak53npk9edsx+er6Gx5Mr9VKN5fDMKVM4rcqML0vWb4f" +
       "DVNJ4icVqzwllmvDnfxHvsLiQzsfAeovsXib8T0FrskcVbeTFm9B7dVzoH9R" +
       "A6DR/slHAOBLJdCXVgvoUI4XAHR7EYMRamQoviPbg8keDiZWFw5tbD5W/paR" +
       "5RLa9JRi0SIPpKj38PxdrfCEvCB2REp/pGp4hnGMwJMLzIFZGgHaciyavFxq" +
       "FJQ4BLNYcy118LtSwu9WDbMwjheE2cYIzDZhsdpTtP6ckg1TtNiaGoIWXyB4" +
       "it9qgBbK8YJAS0aAdhkWWz3QeOANA21braLvh2DQO6SIO6oGWhjHOaJv7LoI" +
       "vG7A4ipGmiVeuzTH0pVZJPXib+zqWgF1CYizU4q1s2pAhXGcC6ibIoDCzmK9" +
       "DF/oc6D2aY42ge+Qg1j11QArvhcIK+f4qJRstGpYhXGcC6tbIrDaj0XaU6oh" +
       "yGckUCMeUKO1UqqtII4uxdKrBlQYx7mAykYApWGhQELmAgXFpG7OBFRqolZI" +
       "bQZ5ZqVcs1VDKozjXEjlI5BCSGImI4tcv65rVulpv+LeJ3+zK7bkPrromX9w" +
       "PvdvT4h9xko7q4HzRQ8/1Kj+JPfMz9wtwD8uxWs9XBcL6cTv//8ADDTLJXmU" +
       "6oY7vsis1tmaMNa4G7o5fK/Wh9+pv9n0widObfpX/nK5UXP2KXa3na1wtsvX" +
       "5tyZ199+sWnto/y1Tz1uOiOETcFDceVn3kqOsnH0W3DS7xAaFrHDMQ9MRinb" +
       "psV/jxeCtfz/HsFXvNGMHZtLx4f4YD7NSINOjaw4cPVn2PKI5fGXqYq7vBAn" +
       "DfDdbaJHNw2Ke2HuM3HUSDMTxTOH8LDySCfFSHlnlYfJ5RwQI4ywn3sjnt2H" +
       "xQnAUcWRCsEiyP86zMP4nFHlPaaYVQNHdhE+2wLQ3y/dzv1Vc2RhHAPg1Ik3" +
       "wdyRuXO8sWwdn51mid22Yk1pqjMoX2P+Fwf04Qiwz2DxWW8hLzf9ZC87Qreh" +
       "NFwsJGye+KJ6JXwN+VR8rlZpCqZ0T0vgnq7aVIRxjJgKlPILHspfjkD5q1h8" +
       "yYvDGF2GFTbl4nzFheOMTUeK1s6hfrJW71IwfL8pgXmzalCHcZwrfP9zBMDP" +
       "Y/GNUoBH8uJMq/caJfbNGiDVjs86QJ5fS7l+XTWkwjheuFL+MAKzH2Pxopfy" +
       "DCjOQVchN1R0L5PcxhNFQo7pSzXUvrpVgqf4rQamoRzn0r63IpD8ORY/9bQP" +
       "fKFeQfveqNXxgu0gz3Yp1/aqIRXGMQBEYA9FKt67EXD9Cotz3mZdSstOMc3I" +
       "8lTS1cBm36Es3beFHDtfKxRhWVfXLWXurhqKYRwvBMV4QziK8UYsiLdh0Keb" +
       "ZoZjhSj9pghYPFbDUy11t0jxbqkaYGEc53B6Rz3UlkWgtgKLZsYPS/LddWZa" +
       "lUBrqQFobfjsKhj0tBSRVQ00FsIxGjQvnWz1lhPiex4OVkcEkFuwWAMLEVUc" +
       "COHnQbqNzM0j/eKVcWARVT9tahkP37W1ytTXgnwnJBonPii+iUr4LovgWDlq" +
       "uKiu9J9owxMxPek0PwfDEYw49R2/BoskoGaXhZH4jmpAV2Bksf8zFdzsWFn2" +
       "2Zv4VEt99FRLY/upm38gltzu51SLU6RxMq/r/uO/vvsGy6aTGod8sTgMbHHR" +
       "uhlpD3kJCStgcYOjjt8o6HeBdgbpYS3Jf/10uxlZ6NEBK3HjJ9nLSB2Q4O1N" +
       "VgXVF6egC2L+VvsR5C/bls8FfLGJ/6sIzOT5Z4fu1lBefHg4rj52au/gx89/" +
       "5PPiqwxVVw4dQi6LUmS++ECEM8XDohtDubm8GvZsfa/58QWb3Y2lJWLAnsKv" +
       "9rSLQCyKWTjjqwLfKzidxc8WfnT62q9/51jDi3ES209wD3Hp/vLz4gUrb5O1" +
       "+1Plx9X2KTb/kKJr6/2z12+f/M+f8BP5pOwcfpB+XH35oY+9dGLl6XVxsqif" +
       "zNNg4VPgB9l3zRojVJ22x0iT5vQWYIjARVP0krNwzaicCjowjouEs6lYi9/0" +
       "MNJRfrqv/Euohbo5Q+2deLQI2TSlyCKvRsxM4Lxt3rICDbwaOZVY3i0cI84G" +
       "6ON4asCy3MOP9ecsbp/HK+Whx7kO38pv8W78/wBq6XVEkjwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "GZlVeuJwxWKz0exjAukZEbmaO1h7LYaa");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("BKHYaDqvzMp2d0oTbthb4wFHjxqb3nRsWcuY1nqpqSQyNtXccbW8BGXDFmlW" +
       "mly5hMdkhfKhNZ0i+iSYo0O4CDN2ggvl3ngOLXrdoAqVU7hc1KB+UcPqDOoP" +
       "Y1nz60WBqqDerIgrbdquCnwSLk0tHQx0hGf0Om5XUtaz+G65nJTMMboeTWcd" +
       "C3Q2U1oEgziVTLlhebHlrZph1Z6ZOFTqD7qsFizXUHPlGXMPHRXLikqPOuUx" +
       "Z28avTUbJn2ETqJK0GmQ81gaivysYpbkDoa0q8MBIoWNTaU/ZHBVDuc+BKau" +
       "UyOpLYYVzF9j0xoGxfUlaGdzYcUEQbz1rdmrYP3FvY1/Rb7wcLLJxbJr2QP2" +
       "RbyFTq5c4WFeYVS4RZqHUSDJ0X4ZNv9cPN4tcfx9ehl2vzZ34XgF5NHL9hZs" +
       "l1g57mSr03HS119tG0ITjJvBZcmvUrLQp0+SZu/+H7za7pr8vf9H3/3Mc8rw" +
       "Y/DhbmF1HhVujTz/Lba6Vu1TeF4NSnrT1dc4+vnmov2C32+9+5sPjN9mvPNF" +
       "7GR46Ew7zxb5z/uf+EL79fIHDwsXTpb/Ltv2dGmmJy5d9LstUKNV4I4vWfp7" +
       "8KR7X5P15g+Bi9p1L3Xl3QTniE0up1sRPbN4fbDbFLLru7uzvosr8pHiOUfZ" +
       "PjrVjfJ8P33OovffyYKno8LtuhoB+Wm6uumqxyU+fpk0yGF4pOZpji5NnavG" +
       "u37QAs3p2vOIpy5dJM2YGu6YGr6ETB3uU70nj/yxU5osRYUL5o6qZ8+h6iNZ" +
       "8IGocGdGlef4q0hVuGhjn9D1hvPoytcSj/Ll5z1hf/8aCLs3i3wTuPQdYfpL" +
       "L1o5YXmCXziHmF/Mgn8cFV4pe+5aDSLGy7cUNtfqbs/lh/aI/8k1IH5tFomC" +
       "69kd4mevJ+JfPgfxr2TBJ6PCfTvETTfbylKXwAwu8FauciwRrzpZUddVoJSs" +
       "KgMbottqmdwz8qlrYCTbp1T4YXB9ZsfIZ64nI8+fw8i/z4JfjwoP7xhpeHa2" +
       "5wuIAbCmuZlumTb4FV5J/W6ee56tSu6elH99DaRkSQuPgOvzO1I+fz1J+dI5" +
       "pHw5C/4jEIOrknIsKG+9zHRkw2EmOP2VHZm+rbYDSTGBQjESUK7H8pI4kF7N" +
       "1tH3vH3xWoXp9eD66o63r15P3v7gHN5eyILfB4OSGRKryGusgtDLNwX9xh7p" +
       "165VQu4BzdkB3X6/REgvG2uuOJDuvLB6/rXbG54X9yfn8PLtLPijKN/NlMtT" +
       "TsxxJRf323f28TlX37gGrjJFKlQBR2/ZcfWW68zVfScwWNVV1GyDD2Vmfmf2" +
       "/HvnsPMXWfC/o8I9O3Y4Q/LVkzKyh9/fU/Kn10oJGIcO3rWj5F3XiZK8zVmq" +
       "g5uvjvvg1iw43A+/YyBKV4F9cOGlkIQv7WB/6brDvvsc2PdkwR377u44kn61" +
       "7j64+BLgPrx1m3f7fV1xP3QO7key4IE97nwouBruV1/reAA88sPSDnfpJcR9" +
       "djw4KJ4D+S1Z8PqocMcOMmmGvi1tsqT7EeHgDdeKtQiaXd9hrV9PrLVzsOJZ" +
       "UI6ysxs5Vt4MzXl2XOAs3Mo1wM2npWDucDjewR1fT7iNc+A2s+Bt+64dgkFy" +
       "h7Wzx/r2a+3aN4Jm2zus9vXEOjwH6ygLumCgPsYKAs324jMd27tWsI+Ddm92" +
       "YDfXE+yPngM2c/EP+KjwsmMzZZvZvv3Hr/6+J9/Hv92i+twvvO53fuq51/3X" +
       "fCv8LWbISwER6Fc41nUqz3c+8cK3vvLyBz+Vnxi5YS6F2xcyZ8/DXX7c7ZJT" +
       "bDnw2y/l8yFwvWHL5/b72k8egWwOlFtuAtzlU4GX6lDT1YreisqZmdeNQP6k" +
       "6GwP57+zzbQH893W9APzB4nMyVvUm2zV1bcHwz6U5ZT85Oxod+zq3b3fV92w" +
       "PVfNJtHHz7ZHokzv6ORsJHiYXLGlT21bmld25WbmMtu4olCfltn4nGeZSToI" +
       "AWNy1tItsHOS/+ROV3ONnl6DRr8qiwSzssOP7DT6Iy+hRl/Yvw8/8b8fuWyu" +
       "oq+jIzD99A1TDgeekuvVN3OU57xZPMjeLB48vZ+s7Ob/u1pKV53wmpkfdxTk" +
       "Dk3W50enMuZsXstbxnzgy8b5z+3Y/Nx1YjNr6Hv2RJ3zXvHgZ7PgA/thIbOU" +
       "jBQZx1RV/vpUZVnZEy3K2brmV4zZaPKNHVvfuJ6jyT89h6OPZcFzl3LErrbH" +
       "UvdvFw/+0TWAvS+LfBS0+3s7sN/7mxGNT58D+19mwcf3g2hfChfHYvHwFfVU" +
       "y5Xl6CRhTsu/eAlk4MID27zb7+slA589h4x/mwW/tpcBYBfsK8jAv7rWRYg3" +
       "A5Bv3oF980sI9uxUb9v9XzgH8Rez4Df2M3va1I0ITPLy0f1YDu44dWrLPvXW" +
       "5+A3r5UI4DRfIHZEENediN87h4ivZcFX9pOilu15Sg43e/Cf9pj/80uwAnVh" +
       "tsM8u44G4NQg+t/PAf6NLPh6lJ9vzN9pRZ5/JdwvXAPuu7LIGmjceoc7un64" +
       "twGbY/tf5+D+bhZ8E3iI8nahLV9nI1xlwnauuIJww9ozlT0d37pWh+tB0OYP" +
       "7uj44Iul44d+oME71t37Ty/ZZouFDY7LlwhzEv7y6gQdZhUdfA8ADy63gN9/" +
       "MeiTqHD76b8kyCZp91/2Fyfbv+WQP/XcxVvue27ye9s51vFfZ9xKF27RVrZ9" +
       "+izsqfub/EDVzJyOW7cnY/0cwq1R4b6rvBcHs4jtTdbcw1u26W8HanA2PfDH" +
       "8+/T6S5Ghdv26UBR25vTSe6KChdAkuz2bv+4M06d8tweCU62/XT/aTnJXx7f" +
       "9YMIPsly+tB+5rXlfzFzvBlhtf2TmSflTz/XHfzEd6sf2/5pgGxLaZqVcguY" +
       "m27/vyAvNNvQ8MhVSzsu6ybqjX9+xy/d+vjx5os7tg3ey+yptj105eP5TceP" +
       "8gP16a/d9ys/8s+e+3p+zPX/A+QkNxv7RwAA");
}
