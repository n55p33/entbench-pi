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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVbe3Qc1Xm/u5Jl+aGH5YeM35ZlExuzayAEqHjJsmTLrB5H" +
       "K9wiJ4jR7NVq7NmZYeautHJwE7tNcJOWg11DKAX/kTiFUAc4nHBo86pbEiAN" +
       "ISdAII8DtCG0NIRT3J7QJDSh33fvnZ3Z2Z2ROd3VOXN3dOe7373f736ve+fO" +
       "mbfJPMcm66jBEmzWok6i12DDiu3QTI+uOM4o1I2rn6tT/vvmNwevipOGMdI8" +
       "pTgDquLQPo3qGWeMrNUMhymGSp1BSjPYYtimDrWnFaaZxhhZrjn9OUvXVI0N" +
       "mBmKBPsUO0WWKIzZ2kSe0X7JgJG1KRhJko8k2R183JUii1XTmvXIV/rIe3xP" +
       "kDLn9eUw0po6oEwryTzT9GRKc1hXwSYXWaY+m9VNlqAFljigXy4h2Ju6vAyC" +
       "jkdb3n3vzqlWDsFSxTBMxsVzRqhj6tM0kyItXm2vTnPOreSPSV2KLPIRM9KZ" +
       "cjtNQqdJ6NSV1qOC0TdRI5/rMbk4zOXUYKk4IEY2ljKxFFvJSTbDfMzAoZFJ" +
       "2XljkHZDUVohZZmId12UPPm5m1sfqyMtY6RFM9I4HBUGwaCTMQCU5iao7XRn" +
       "MjQzRpYYMNlpamuKrh2SM93maFlDYXmYfhcWrMxb1OZ9eljBPIJsdl5lpl0U" +
       "b5IrlPxv3qSuZEHWFZ6sQsI+rAcBF2owMHtSAb2TTeoPakaGkfXBFkUZO28A" +
       "Amg6P0fZlFnsqt5QoIK0CRXRFSObTIPqGVkgnWeCAtqMrAplilhbinpQydJx" +
       "1MgA3bB4BFQLOBDYhJHlQTLOCWZpVWCWfPPz9uDVd3zc2GPESQzGnKGqjuNf" +
       "BI3WBRqN0ElqU7AD0XDxttTdyopvHIsTAsTLA8SC5onbzl2/fd3ZZwTN6go0" +
       "QxMHqMrG1dMTzT9Y07P1qjocRqNlOhpOfonk3MqG5ZOuggUeZkWRIz5MuA/P" +
       "jjx10ycfom/FycJ+0qCaej4HerRENXOWplN7NzWorTCa6ScLqJHp4c/7yXy4" +
       "T2kGFbVDk5MOZf2kXudVDSb/HyCaBBYI0UK414xJ0723FDbF7wsWIaQVLnKV" +
       "vPDvSiwY+cPklJmjSUVVDM0wk8O2ifI7SfA4E4DtVHICtP5g0jHzNqhg0rSz" +
       "SQX0YIrKBxO2lsnSZE86fSNIDNICjqhgVu1YF1CqpTOxGAC+JmjuOljKHlPP" +
       "UHtcPZnf2Xvu4fHvClVC9Zd4gIOC3hKitwTvLSF6S/h7I7EY72QZ9ipmFObj" +
       "IFg2uNbFW9Mf23vLsY46UCVrph7ARNKOkhDT45m/67PH1Ufamg5tfPWSJ+Ok" +
       "PkXaFJXlFR0jRredBV+kHpTmungCgo8XAzb4YgAGL9tUaQZcUFgskFwazWlq" +
       "Yz0jy3wc3AiFtpgMjw8Vx0/O3jNzZN8ndsRJvNTtY5fzwGNh82F01kWn3Bk0" +
       "90p8W25/891H7j5seoZfEkfc8FfWEmXoCKpBEJ5xddsG5fHxbxzu5LAvAMfM" +
       "FDAk8Hnrgn2U+JUu10ejLI0g8KRp5xQdH7kYL2RTtjnj1XD9XMLvl4FaNKOh" +
       "rYLrWml5/BefrrCwbBf6jHoWkILHgGvS1v0/eu4/LuNwu+GixRfn05R1+VwU" +
       "MmvjzmiJp7ajNqVA98o9w39519u37+c6CxSbKnXYiWUPuCaYQoD5U8/c+uPX" +
       "Xj39YtzTc0YWWLbJwJhpplCUEx+Rpgg5ocMt3pDAy+nAARWn80YDVFSb1JQJ" +
       "naJt/W/L5kse/+UdrUIVdKhxNWn73Ay8+gt2kk9+9+b/WcfZxFSMsh5sHplw" +
       "3Us9zt22rcziOApHnl/7V08r90MQAMfraIco96WEw0D4vF3O5d/Byw8Hnl2B" +
       "xWbHr/+lJubLhsbVO198p2nfO988x0dbmk75p3tAsbqEhmGxpQDs24P+aY/i" +
       "TAHdh88OfrRVP/secBwDjip4WWfIBtdYKFEOST1v/k/+8ckVt/ygjsT7yELd" +
       "VDJ9CrczsgAUnDpT4FUL1nXXi8mdaXSDSoGUCV9WgQCvrzx1vTmLcbAP/V37" +
       "V65+4NSrXNEswWN10bGuKXGsPCn3bPuhF6744QPH754RYX1ruEMLtFv52yF9" +
       "4ujPfl0GOXdlFVKOQPux5Jn7VvVc+xZv7/kUbN1ZKA9O4Je9tpc+lPtVvKPh" +
       "23Eyf4y0qjIJ3qfoebTUMUj8HDczhkS55HlpEicylq6iz1wT9Ge+boPezAuK" +
       "cI/UeN8UcGArcQqvI+h/+F/8hqADixF+08+bXMjLbVhczKevjkFOn5+ApRHc" +
       "ODzdZjAMzVD0gPdod5lX6ISRRaMj3YPp4e6R3sFR3m4lAMGVSplhCfRY6AKp" +
       "8KZYXonFXtFHVyXFLVQecBxvBxhpVCYg2IAReMPkfy1u+uT++p2cp7Z17iA7" +
       "ypINYQXpdHHt45JuCctLem3btMvIQzj/0UCqSIoOYm1Yus2XCqePnjyVGfri" +
       "JcJ62kpT2F5YoX35pd89m7jnX75TIY9awEzrYp1OU90n+GrsssReB/hKxFP+" +
       "V5pPvP73ndmdHyQHwrp1c2Q5+P96EGJbuAsIDuXpo79YNXrt1C0fIJ1ZH4Az" +
       "yPJLA2e+s3uLeiLOl13CKsuWa6WNukptcaFNYX1pjJZY5KaiFq5BpfsQXHuk" +
       "Fu6pnFJEaDcWgwHzWxLBMRDmYtIxSz1cino4c5mayJi5BG4LwOzzMVgR4ZEH" +
       "9QOMLM5SBrbQa2TBebocN5dptuo4CcppEqXU3MwPRpj5ecQnrOgWg50sdXwI" +
       "85AEZahqMIdxDMAV91jdWrq6QGtJ58E/DdtaDhK/abkKvnT4FvVY5/DPhTFf" +
       "UKGBoFv+YPIv9r184Fmu9o1oZ0Vl89kY2KMvp20VcrwPfzG4fo8Xjh8r8Bfc" +
       "cY9c0m4ormkxlEfG5IAAycNtrx28780vCwGCAThATI+d/Mz7iTtOCs8kNkY2" +
       "le1N+NuIzREhDhafxtFtjOqFt+j790cOf+3Bw7fHpe5OMFKnyT0rvz1AEl8K" +
       "uRjnrj9r+fqdbXV94O/6SWPe0G7N0/5Mqc3Pd/ITvjnw9lE8DyBHjHgzEtsG" +
       "0PLqoxFGdhKL2xhpRSODycnDlKTZrF40tAujDG0a040ETzo8UztcA1Nbgc+2" +
       "wZWVhpGtmqmFcazs0bip8c4+H4HqaSzugzU15GUQetiwybfpeqep1IlPeXDd" +
       "XwO41uGzy+G6Swp3V9XgCuM4F1yPRsD1GBYPMdIu4eo1cKG2EwJ91jbzRsbV" +
       "xQuK2VyWQiAZgbwWMlydXrrLg/NvawAnrs7JH8D1hBT+iarBGcZxLjjPRsD5" +
       "T1h8lZENEk5YTuF2CCgg+DGevPRpOvwn0sQ/kW4Of4757v+ckfkTpqlTxag0" +
       "jOMFD/Ov1QBzZEE2wvWMROiZqmH+tOT49AfE/IUIzH+IxfdARUMxd5X4mjKH" +
       "iiEPlXogrzPN0uluW8loFN9Agdfo5JzSQE8x1/ZAf65Wir4FrpckRC9VDfQw" +
       "jnOB/noE6G9g8QpkiJrTnWdmT952TL66/pYH06u10s3lMEwpk/itCkzvS5bv" +
       "R8NUkvhJxSpPieXacCf/ka+w+NDORYD6KyzeYnxPgWsyR9XtpMVbUHv1HOhf" +
       "1gBotH/yEQD4Ygn0xdUCOpTjeQDdXsRghBoZiu/I9mCyh4OJ1YVDG5uPlb9j" +
       "ZLmENj2lWLTIAynqPTx/Xys8IS+IHZHSH6kanmEcI/DkAnNglkaAthyLJi+X" +
       "GgUlDsEs1lxLHfy+lPD7VcMsjON5YbYxArNNWKz2FK0/p2TDFC22poagxRcI" +
       "nuK3GqCFcjwv0JIRoF2CxVYPNB54w0DbVqvo+yEY9A4p4o6qgRbGcY7oG7sm" +
       "Aq/rsLiCkWaJ1y7NsXRlFkm9+Bu7slZAXQTi7JRi7awaUGEc5wLqhgigsLNY" +
       "L8MX+hyofZqjTeA75CBWfTXAiu8Fwso5PiolG60aVmEc58Lqpgis9mOR9pRq" +
       "CPIZCdSIB9RorZRqK4ijS7H0qgEVxnEuoLIRQGlYKJCQuUBBMambMwGVmqgV" +
       "UptBnlkp12zVkArjOBdS+QikEJKYycgi16/rmlV62q+498nf7IotuY8ueuof" +
       "nC/822Nin7HSzmrgfNGDDzSqP8099XN3C/BPS/FaD9eFQjrx+/8/AAPNckke" +
       "pbrhji8yq3W2Jow17oZuDt+r9eF36m82PfeJU5v+lb9cbtScfYrdbWcrnO3y" +
       "tXnnzGtvPd+09mH+2qceN50RwqbgobjyM28lR9k4+i046bcJDYvY4ZgHJqOU" +
       "bdPiv8cLwVr+f4/gK95oxo7NpeNDfDCfZqRBp0ZWHLj6LLY8Ynn8ZariLi/E" +
       "SQN8d5vo0U2D4l6Y+0wcNdLMRPHMITysPNJJMVLeWeVhcjkHxAgj7OfuiGf3" +
       "YHECcFRxpEKwCPK/DvMwPmdUeY8pZtXAkV2Az7YA9PdKt3Nv1RxZGMcAOHXi" +
       "TTB3ZO4cbyxbx2enWWK3rVhTmuoMyteY/8UBfTAC7DNYfN5byMtNP9nLjtBt" +
       "KA0XCwmbJ76oXglfQz4VX6hVmoIp3ZMSuCerNhVhHCOmAqX8kofyVyNQ/joW" +
       "X/HiMEaXYYVNuThfdv44Y9ORorVzqB+v1bsUDN9vSGDeqBrUYRznCt//HAHw" +
       "s1h8qxTgkbw40+q9Rol9uwZIteOzDpDnN1Ku31QNqTCO56+UP4rA7CdYPO+l" +
       "PAOKc9BVyA0V3cskt/FEkZBj+kINta9uleApfquBaSjHubTvzQgkf4HFzzzt" +
       "A1+oV9C+12t1vGA7yLNdyrW9akiFcQwAEdhDkYr3bgRcv8biHW+zLqVlp5hm" +
       "ZHkq6Wpgs+9Qlu7bQo6dqxWKsKyr65Yyd1cNxTCO54NivCEcxXgjFsTbMOjT" +
       "TTPDsUKUflsELB6r4amWupukeDdVDbAwjnM4vaMeassiUFuBRTPjhyX57joz" +
       "rUqgtdQAtDZ8dgUMelqKyKoGGgvhGA2al062essJ8T0PB6sjAsgtWKyBhYgq" +
       "DoTw8yDdRubGkX7xyjiwiKqfNrWMh+/aWmXqa0G+ExKNEx8U30QlfJdFcKwc" +
       "NVxUV/pPtOGJmJ50mp+D4QhGnPqOX4VFElCzy8JIfEc1oCswstj/mQpudqws" +
       "++xNfKqlPnyqpbH91I0viyW3+znV4hRpnMzruv/4r+++wbLppMYhXywOA1tc" +
       "tG5G2kNeQsIKWNzgqOPXC/pdoJ1BelhL8l8/3W5GFnp0wErc+En2MlIHJHh7" +
       "g1VB9cUp6IKYv9V+BPnLtuVzAV9s4v8qAjN5/tmhuzWUFx8ejquPnNo7+PFz" +
       "H/mi+CpD1ZVDh5DLohSZLz4Q4UzxsOjGUG4ur4Y9W99rfnTBZndjaYkYsKfw" +
       "qz3tIhCLYhbO+KrA9wpOZ/GzhR+fvvqb3zvW8HycxPYT3ENcur/8vHjByttk" +
       "7f5U+XG1fYrNP6To2nrv7LXbJ//zp/xEPik7hx+kH1dffOBjL5xYeXpdnCzq" +
       "J/M0WPgU+EH2XbPGCFWn7THSpDm9BRgicNEUveQsXDMqp4IOjOMi4Wwq1uI3" +
       "PYx0lJ/uK/8SaqFuzlB7Jx4tQjZNKbLIqxEzEzhvm7esQAOvRk4llncKx4iz" +
       "Afo4nhqwLPfwY/3LFrfP45Xy0ONch2/mt3g3/n+QeuzrkjwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1LDmwNUmy0GKjtBZmgS00Z610cgHGj6v");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Pv2N+37tR/7ps1/LX3P9f64J5JT7RwAA");
}
