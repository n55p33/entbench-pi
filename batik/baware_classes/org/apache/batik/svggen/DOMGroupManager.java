package org.apache.batik.svggen;
public class DOMGroupManager implements org.apache.batik.svggen.SVGSyntax, org.apache.batik.svggen.ErrorConstants {
    public static final short DRAW = 1;
    public static final short FILL = 16;
    protected org.apache.batik.ext.awt.g2d.GraphicContext gc;
    protected org.apache.batik.svggen.DOMTreeManager domTreeManager;
    protected org.apache.batik.svggen.SVGGraphicContext groupGC;
    protected org.w3c.dom.Element currentGroup;
    public DOMGroupManager(org.apache.batik.ext.awt.g2d.GraphicContext gc,
                           org.apache.batik.svggen.DOMTreeManager domTreeManager) {
        super(
          );
        if (gc ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_GC_NULL);
        if (domTreeManager ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_DOMTREEMANAGER_NULL);
        this.
          gc =
          gc;
        this.
          domTreeManager =
          domTreeManager;
        recycleCurrentGroup(
          );
        groupGC =
          domTreeManager.
            gcConverter.
            toSVG(
              gc);
    }
    void recycleCurrentGroup() { currentGroup = domTreeManager.getDOMFactory(
                                                                 ).
                                                  createElementNS(
                                                    SVG_NAMESPACE_URI,
                                                    SVG_G_TAG); }
    public void addElement(org.w3c.dom.Element element) { addElement(
                                                            element,
                                                            (short)
                                                              (DRAW |
                                                                 FILL));
    }
    public void addElement(org.w3c.dom.Element element, short method) {
        if (!currentGroup.
              hasChildNodes(
                )) {
            currentGroup.
              appendChild(
                element);
            groupGC =
              domTreeManager.
                gcConverter.
                toSVG(
                  gc);
            org.apache.batik.svggen.SVGGraphicContext deltaGC;
            deltaGC =
              processDeltaGC(
                groupGC,
                domTreeManager.
                  defaultGC);
            domTreeManager.
              getStyleHandler(
                ).
              setStyle(
                currentGroup,
                deltaGC.
                  getGroupContext(
                    ),
                domTreeManager.
                  getGeneratorContext(
                    ));
            if ((method &
                   DRAW) ==
                  0) {
                deltaGC.
                  getGraphicElementContext(
                    ).
                  put(
                    SVG_STROKE_ATTRIBUTE,
                    SVG_NONE_VALUE);
            }
            if ((method &
                   FILL) ==
                  0) {
                deltaGC.
                  getGraphicElementContext(
                    ).
                  put(
                    SVG_FILL_ATTRIBUTE,
                    SVG_NONE_VALUE);
            }
            domTreeManager.
              getStyleHandler(
                ).
              setStyle(
                element,
                deltaGC.
                  getGraphicElementContext(
                    ),
                domTreeManager.
                  getGeneratorContext(
                    ));
            setTransform(
              currentGroup,
              deltaGC.
                getTransformStack(
                  ));
            domTreeManager.
              appendGroup(
                currentGroup,
                this);
        }
        else {
            if (gc.
                  isTransformStackValid(
                    )) {
                org.apache.batik.svggen.SVGGraphicContext elementGC =
                  domTreeManager.
                    gcConverter.
                  toSVG(
                    gc);
                org.apache.batik.svggen.SVGGraphicContext deltaGC =
                  processDeltaGC(
                    elementGC,
                    groupGC);
                trimContextForElement(
                  deltaGC,
                  element);
                if (countOverrides(
                      deltaGC) <=
                      domTreeManager.
                        maxGCOverrides) {
                    currentGroup.
                      appendChild(
                        element);
                    if ((method &
                           DRAW) ==
                          0) {
                        deltaGC.
                          getContext(
                            ).
                          put(
                            SVG_STROKE_ATTRIBUTE,
                            SVG_NONE_VALUE);
                    }
                    if ((method &
                           FILL) ==
                          0) {
                        deltaGC.
                          getContext(
                            ).
                          put(
                            SVG_FILL_ATTRIBUTE,
                            SVG_NONE_VALUE);
                    }
                    domTreeManager.
                      getStyleHandler(
                        ).
                      setStyle(
                        element,
                        deltaGC.
                          getContext(
                            ),
                        domTreeManager.
                          getGeneratorContext(
                            ));
                    setTransform(
                      element,
                      deltaGC.
                        getTransformStack(
                          ));
                }
                else {
                    currentGroup =
                      domTreeManager.
                        getDOMFactory(
                          ).
                        createElementNS(
                          SVG_NAMESPACE_URI,
                          SVG_G_TAG);
                    addElement(
                      element,
                      method);
                }
            }
            else {
                currentGroup =
                  domTreeManager.
                    getDOMFactory(
                      ).
                    createElementNS(
                      SVG_NAMESPACE_URI,
                      SVG_G_TAG);
                gc.
                  validateTransformStack(
                    );
                addElement(
                  element,
                  method);
            }
        }
    }
    protected int countOverrides(org.apache.batik.svggen.SVGGraphicContext deltaGC) {
        return deltaGC.
          getGroupContext(
            ).
          size(
            );
    }
    protected void trimContextForElement(org.apache.batik.svggen.SVGGraphicContext svgGC,
                                         org.w3c.dom.Element element) {
        java.lang.String tag =
          element.
          getTagName(
            );
        java.util.Map groupAttrMap =
          svgGC.
          getGroupContext(
            );
        if (tag !=
              null) {
            java.util.Iterator iter =
              groupAttrMap.
              keySet(
                ).
              iterator(
                );
            while (iter.
                     hasNext(
                       )) {
                java.lang.String attrName =
                  (java.lang.String)
                    iter.
                    next(
                      );
                org.apache.batik.svggen.SVGAttribute attr =
                  org.apache.batik.svggen.SVGAttributeMap.
                  get(
                    attrName);
                if (attr !=
                      null &&
                      !attr.
                      appliesTo(
                        tag))
                    groupAttrMap.
                      remove(
                        attrName);
            }
        }
    }
    protected void setTransform(org.w3c.dom.Element element,
                                org.apache.batik.ext.awt.g2d.TransformStackElement[] transformStack) {
        java.lang.String transform =
          domTreeManager.
            gcConverter.
          toSVG(
            transformStack).
          trim(
            );
        if (transform.
              length(
                ) >
              0)
            element.
              setAttributeNS(
                null,
                SVG_TRANSFORM_ATTRIBUTE,
                transform);
    }
    static org.apache.batik.svggen.SVGGraphicContext processDeltaGC(org.apache.batik.svggen.SVGGraphicContext gc,
                                                                    org.apache.batik.svggen.SVGGraphicContext referenceGc) {
        java.util.Map groupDelta =
          processDeltaMap(
            gc.
              getGroupContext(
                ),
            referenceGc.
              getGroupContext(
                ));
        java.util.Map graphicElementDelta =
          gc.
          getGraphicElementContext(
            );
        org.apache.batik.ext.awt.g2d.TransformStackElement[] gcTransformStack =
          gc.
          getTransformStack(
            );
        org.apache.batik.ext.awt.g2d.TransformStackElement[] referenceStack =
          referenceGc.
          getTransformStack(
            );
        int deltaStackLength =
          gcTransformStack.
            length -
          referenceStack.
            length;
        org.apache.batik.ext.awt.g2d.TransformStackElement[] deltaTransformStack =
          new org.apache.batik.ext.awt.g2d.TransformStackElement[deltaStackLength];
        java.lang.System.
          arraycopy(
            gcTransformStack,
            referenceStack.
              length,
            deltaTransformStack,
            0,
            deltaStackLength);
        org.apache.batik.svggen.SVGGraphicContext deltaGC =
          new org.apache.batik.svggen.SVGGraphicContext(
          groupDelta,
          graphicElementDelta,
          deltaTransformStack);
        return deltaGC;
    }
    static java.util.Map processDeltaMap(java.util.Map map,
                                         java.util.Map referenceMap) {
        java.util.Map mapDelta =
          new java.util.HashMap(
          );
        java.util.Iterator iter =
          map.
          keySet(
            ).
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            java.lang.String key =
              (java.lang.String)
                iter.
                next(
                  );
            java.lang.String value =
              (java.lang.String)
                map.
                get(
                  key);
            java.lang.String refValue =
              (java.lang.String)
                referenceMap.
                get(
                  key);
            if (!value.
                  equals(
                    refValue)) {
                mapDelta.
                  put(
                    key,
                    value);
            }
        }
        return mapDelta;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xbvNcpBaGuT7NkD1eVUTa5d+NMs+v8vS13VHv+fhX3d1zauSU4j+iTdqjYXn" +
       "uGBPfDNy2VfEWxgWDzMlrmixcKcSp6lsL4XnI0qfX314NqmO3u7uV1d+eMEd" +
       "Fwq9zcyB+U7/hy45fvTW7YcPiQNHxG5GFub6t0zmX3TwjjNPYHGt0cdN3zjy" +
       "3psbNqXWqALt6Nw00pc7lyQtEkfpZdnRBpuW8PLsPL50ERYLGal0+5JNeInj" +
       "TIv+H86UhGl8F/R47TM5458/4t8q8r37K0sm7V//kgiXqX+UjImQkt6Eqrov" +
       "JlzvxYZJexWuuTHimoIfxQbWMDIpxyEJXhbwF2Q80CT6X8xIlb8/hAb+7e7X" +
       "CpsYpx+QEi/uLpdAqg5d8HVd+pDJdckh7meSIq5NdSuRI/6E0+k+PcR9H4wm" +
       "xv95lYKDRLttyYf3r23dcfL828V9tKxK27cjlTJIM8TVuJ1m+L3CTS1Fq3jN" +
       "/FMV942ekzLWsYJhBwWnulJzSIoDBq74FN9lrVWbvrN9+cCyR/+0u/g5cLON" +
       "JACbnHEbM2+ykkYCYHFjJPM8H7IwfotcN/8nQ8sX9X74avrKyHtD6O/fLb9w" +
       "cNPzeycfqAmSsmZSpGhRmuRXbKuHtHVUHjC7SLliNSSBRaACuYnnsqACjVPC" +
       "/2RxvdjqLE/X4r8ZGJmVeVOS+R+QUlUfpOYq2AhGt4nksMypSeWDnnOkhGH4" +
       "Bjg1royxl6dGSQHrBd2RFsNIXSSVPmRwF43lRhI+Gzfh3v8Cc3iloZUpAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "RnrHza+WqDLQ6eRO8Csf/e+PLN5tfuAW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ginefI7P80P+I+rF38Hfqvzty5Xbjm8IrwvBOtvp2bP3gvfEWprF/uLM7eCj" +
       "Z+/6Hyt3af+Jzr9jPxGK68Rrv3rkBbfaX76g7VeK7B+nlYdiTdkqroaefz9/" +
       "/iXxOrDUE+l88ZXeD5+er6z4wtkwDgikDx6i/uAtoC6vFd5+Q+iXTgg+XBL8" +
       "ywvw/2aR/fO0co+kqqeuHn71BOKvv1aIXZB+/hDiz/9kIB6GTJQQi4wpqb56" +
       "Ac5/U2S/dRHOr7wGnA8WlY+D9I1DnN+4VZzaK21lVhL8wQUQ/7DIvp5WripB" +
       "5qfTtRbHlqolN5Li26zDmNMS+b99DcjL6zEGpD8+RP7HPxnkp3Y4O5Hk/3oB" +
       "/O8U2R+lwEbHlnd47TcM4htv9rdfK+Ti6vfHh5Bf/olD/jCw+W+5uc0vI4r2" +
       "0QEv/IOnfu9nX3jqj8qImStWwktxLzZuEGZ6qs/3X/zmd7/+uke/WAau3S5L" +
       "yd4on4/PvT789kxUbYnhvrOqDlTg8kv7Rdl/p5X3v8YwyCL8WdqksFFX4bN3" +
       "ukeBln/OMxyf/PULA7MWseQnRSgfm0qKcyh15xX55MrwR0fXxj++sZyUYlA6" +
       "Tcf+0p2u5hv7uNb/WGQ/DPPzsnN8o3xyuYq6ga8VgWxHbftATis4OA7tBo35" +
       "DTn9wp7TcrJTrtaNhPeUJl66+4K2e4vszrRyh1LwtYdxAfnVfK/c/+sCmjIc" +
       "5HspkEUtPd6Fc/r+P1+Dvj9aVIJz+tKVfd/9963o+/hVmbjSwl965AKkbyoy" +
       "sIVXwyIaNUkGmptKOFp2PsZ66Q2vAeu1ohJ4YpeePcT67E8U65k4pLNmjZE2" +
       "pX/8nPLP5t/62ud2X3pxH2ZUmKe0At3sTxXX/6+jiN69wHaeCrf/If7TL/3J" +
       "f+bfd+SB33u8DG8uUD950TIcadPrTqISKalou/TOounS247HevuR+Fy0pJfe" +
       "WWZl8a0XSECtyJ5IK9dOSwCY+NycpTG++urmPBGcJ29FcHLAxLlQ8SLu9eHr" +
       "/oOy/9+E8sUXrl154wvcH+wPnaP/NtxNVq7omeuejiE8Vb4zjDXdKjfn7n1E" +
       "YVhy/tNp5Y03eQ4r4vrKQrkk3T39u9LK/efpgQ0qv0/TvRc4iCd0YKh94TQJ" +
       "CrwnQFIUB8cRPKciY/ahlPmlU09wh1pWGqIHX2mNj7ucDqYupLj8D9DRE1o2" +
       "O1SWL70wpj/4g/Yv7oO5FVfa7YpRroDDeh9XfvyU98RNRzsa687RMy9f/fLd" +
       "bznSh6t7hk80/hRvb75x5DTmhWkZ67z7p2/81Z/5hy98owzI/P+jWHKZnDUA" +
       "AA==");
}
