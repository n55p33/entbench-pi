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
      1471028785000L;
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
       "Bjg1royxl6dGSQHrBd2RFsNIXSSVvmpwF43lRhI+Gzfh3v8CDuVTqZUpAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "b7/x1RJVBjqd3Al++SP/7eHFO4333UQw");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("xWPn+Dw/5D+kXvpd/M3yz1+u3HJ8Q3hNCNbZTs+dvRe8O1KTNPIWZ24HHzl7" +
       "1/9ouUv7T3j+HfuJUFwjXvvVIy+41f7SBW2/WmT/KKk8EKnyVnZU9Pz7+fMv" +
       "iTPfVE6k86VXej98er6y4vNnwzggkN5/iPr9N4G6vFZ463WhXzoh+GBJ8C8u" +
       "wP9bRfbPksrdkqKcunr4tROIv/FaIXZB+rlDiD/3k4F4GDJRQiwypqT6ygU4" +
       "/3WR/fZFOL/8GnDeX1Q+DtLXD3F+/WZxqq+0lWlJ8IcXQPyjIvtaUrki+6mX" +
       "TDM1ikxFja8nxbeYhzGnJfJ/8xqQl9djDEh/coj8T34yyE/tcHoiyf/lAvjf" +
       "LrI/ToCNjkz38Npv6EfX3+xvvVbIxdXvjw8h/+gnDvmDwOY/c2ObX0YU7aMD" +
       "Xvz7T/3+z7741B+XETN3mjEvRb1Iv06Y6ak+33vpG9/52use+UIZuHbrWor3" +
       "Rvl8fO614bdnompLDPeeVXWgApdf3i/K/jupvPc1hkEW4c/SJoH1ugKfvdM9" +
       "CrT8C57h+OSvXxiYtYgkLy5C+dhEku1DqTuvyCdXhj88ujb+8fXlpBSD0mk6" +
       "9pdud1RP38e1/oci+0GQn5ed4xvlk8tV1PE9tQhkO2rbB3Ka/sFxaDdozK/L" +
       "6ef3nJaTnXK1rie8pzTx0l0XtN1TZLcnldvkgq89jAvIr+R75f5fF9CU4SDf" +
       "TYAsqsnxLpzT9//xGvT9kaISnNOX7tz33X/fjL6PX5WJKy38pYcvQPqmIgNb" +
       "eCUoolHjeKA6iYSjZedjrJcefA1YrxaVwBO79Nwh1ud+oljPxCGdNWuMtCn9" +
       "4+flfzr/5lc/u/viS/swo8I8JRXoRn+quPZ/HUX07gW281S4/Q/wn375T/8T" +
       "/54jD/ye42V4rED95EXLcKRNrzuJSqSkou3Ss0XTpbccj/XWI/G5aEkvPVtm" +
       "ZfHNF0hArcieSCpXT0sAmPjcnKUxvvLq5jwRnCdvRnBywMS5UPEi7vWN1/wH" +
       "Zf+/CfkLL16986EXuT/cHzpH/224i6zcqaWOczqG8FT59iBSNbPcnLv2EYVB" +
       "yflPJ5WHbvAcVsT1lYVySbp7+ncklfvO0wMbVH6fpns3cBBP6MBQ+8JpEhR4" +
       "T4CkKA6OI3hORcbsQynzS6ee4A61rDRE97/SGh93OR1MXUhx+R+goye0dHao" +
       "LF98cUy///vtX9oHc8uOtNsVo9wJDut9XPnxU94TNxztaKzbR2/70ZUv3fXM" +
       "kT5c2TN8ovGneHvs+pHTmBskZazz7p889Gs/8w9e/HoZkPn/AZgoYtOcNQAA");
}
