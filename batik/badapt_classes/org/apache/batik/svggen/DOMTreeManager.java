package org.apache.batik.svggen;
public class DOMTreeManager implements org.apache.batik.svggen.SVGSyntax, org.apache.batik.svggen.ErrorConstants {
    int maxGCOverrides;
    protected final java.util.List groupManagers = java.util.Collections.
      synchronizedList(
        new java.util.ArrayList(
          ));
    protected java.util.List genericDefSet = new java.util.LinkedList();
    org.apache.batik.svggen.SVGGraphicContext defaultGC;
    protected org.w3c.dom.Element topLevelGroup;
    org.apache.batik.svggen.SVGGraphicContextConverter gcConverter;
    protected org.apache.batik.svggen.SVGGeneratorContext generatorContext;
    protected org.apache.batik.svggen.SVGBufferedImageOp filterConverter;
    protected java.util.List otherDefs;
    public DOMTreeManager(org.apache.batik.ext.awt.g2d.GraphicContext gc,
                          org.apache.batik.svggen.SVGGeneratorContext generatorContext,
                          int maxGCOverrides) { super();
                                                if (gc == null) throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                                                                  ERR_GC_NULL);
                                                if (maxGCOverrides <=
                                                      0) throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                                                           ERR_MAXGCOVERRIDES_OUTOFRANGE);
                                                if (generatorContext ==
                                                      null)
                                                    throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                                                      ERR_CONTEXT_NULL);
                                                this.
                                                  generatorContext =
                                                  generatorContext;
                                                this.
                                                  maxGCOverrides =
                                                  maxGCOverrides;
                                                recycleTopLevelGroup(
                                                  );
                                                defaultGC =
                                                  gcConverter.
                                                    toSVG(
                                                      gc);
    }
    public void addGroupManager(org.apache.batik.svggen.DOMGroupManager groupManager) {
        if (groupManager !=
              null)
            groupManagers.
              add(
                groupManager);
    }
    public void removeGroupManager(org.apache.batik.svggen.DOMGroupManager groupManager) {
        if (groupManager !=
              null)
            groupManagers.
              remove(
                groupManager);
    }
    public void appendGroup(org.w3c.dom.Element group,
                            org.apache.batik.svggen.DOMGroupManager groupManager) {
        topLevelGroup.
          appendChild(
            group);
        synchronized (groupManagers)  {
            int nManagers =
              groupManagers.
              size(
                );
            for (int i =
                   0;
                 i <
                   nManagers;
                 i++) {
                org.apache.batik.svggen.DOMGroupManager gm =
                  (org.apache.batik.svggen.DOMGroupManager)
                    groupManagers.
                    get(
                      i);
                if (gm !=
                      groupManager)
                    gm.
                      recycleCurrentGroup(
                        );
            }
        }
    }
    protected void recycleTopLevelGroup() {
        recycleTopLevelGroup(
          true);
    }
    protected void recycleTopLevelGroup(boolean recycleConverters) {
        synchronized (groupManagers)  {
            int nManagers =
              groupManagers.
              size(
                );
            for (int i =
                   0;
                 i <
                   nManagers;
                 i++) {
                org.apache.batik.svggen.DOMGroupManager gm =
                  (org.apache.batik.svggen.DOMGroupManager)
                    groupManagers.
                    get(
                      i);
                gm.
                  recycleCurrentGroup(
                    );
            }
        }
        topLevelGroup =
          generatorContext.
            domFactory.
            createElementNS(
              SVG_NAMESPACE_URI,
              SVG_G_TAG);
        if (recycleConverters) {
            filterConverter =
              new org.apache.batik.svggen.SVGBufferedImageOp(
                generatorContext);
            gcConverter =
              new org.apache.batik.svggen.SVGGraphicContextConverter(
                generatorContext);
        }
    }
    public void setTopLevelGroup(org.w3c.dom.Element topLevelGroup) {
        if (topLevelGroup ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_TOP_LEVEL_GROUP_NULL);
        if (!SVG_G_TAG.
              equalsIgnoreCase(
                topLevelGroup.
                  getTagName(
                    )))
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_TOP_LEVEL_GROUP_NOT_G);
        recycleTopLevelGroup(
          false);
        this.
          topLevelGroup =
          topLevelGroup;
    }
    public org.w3c.dom.Element getRoot() {
        return getRoot(
                 null);
    }
    public org.w3c.dom.Element getRoot(org.w3c.dom.Element svgElement) {
        org.w3c.dom.Element svg =
          svgElement;
        if (svg ==
              null) {
            svg =
              generatorContext.
                domFactory.
                createElementNS(
                  SVG_NAMESPACE_URI,
                  SVG_SVG_TAG);
        }
        if (gcConverter.
              getCompositeConverter(
                ).
              getAlphaCompositeConverter(
                ).
              requiresBackgroundAccess(
                ))
            svg.
              setAttributeNS(
                null,
                SVG_ENABLE_BACKGROUND_ATTRIBUTE,
                SVG_NEW_VALUE);
        if (generatorContext.
              generatorComment !=
              null) {
            org.w3c.dom.Comment generatorComment =
              generatorContext.
                domFactory.
              createComment(
                generatorContext.
                  generatorComment);
            svg.
              appendChild(
                generatorComment);
        }
        applyDefaultRenderingStyle(
          svg);
        svg.
          appendChild(
            getGenericDefinitions(
              ));
        svg.
          appendChild(
            getTopLevelGroup(
              ));
        return svg;
    }
    public void applyDefaultRenderingStyle(org.w3c.dom.Element element) {
        java.util.Map groupDefaults =
          defaultGC.
          getGroupContext(
            );
        generatorContext.
          styleHandler.
          setStyle(
            element,
            groupDefaults,
            generatorContext);
    }
    public org.w3c.dom.Element getGenericDefinitions() {
        org.w3c.dom.Element genericDefs =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_DEFS_TAG);
        java.util.Iterator iter =
          genericDefSet.
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            genericDefs.
              appendChild(
                (org.w3c.dom.Element)
                  iter.
                  next(
                    ));
        }
        genericDefs.
          setAttributeNS(
            null,
            SVG_ID_ATTRIBUTE,
            ID_PREFIX_GENERIC_DEFS);
        return genericDefs;
    }
    public org.apache.batik.svggen.ExtensionHandler getExtensionHandler() {
        return generatorContext.
          getExtensionHandler(
            );
    }
    void setExtensionHandler(org.apache.batik.svggen.ExtensionHandler extensionHandler) {
        generatorContext.
          setExtensionHandler(
            extensionHandler);
    }
    public java.util.List getDefinitionSet() {
        java.util.List defSet =
          gcConverter.
          getDefinitionSet(
            );
        defSet.
          removeAll(
            genericDefSet);
        defSet.
          addAll(
            filterConverter.
              getDefinitionSet(
                ));
        if (otherDefs !=
              null) {
            defSet.
              addAll(
                otherDefs);
            otherDefs =
              null;
        }
        filterConverter =
          new org.apache.batik.svggen.SVGBufferedImageOp(
            generatorContext);
        gcConverter =
          new org.apache.batik.svggen.SVGGraphicContextConverter(
            generatorContext);
        return defSet;
    }
    public void addOtherDef(org.w3c.dom.Element definition) {
        if (otherDefs ==
              null) {
            otherDefs =
              new java.util.LinkedList(
                );
        }
        otherDefs.
          add(
            definition);
    }
    public org.w3c.dom.Element getTopLevelGroup() {
        boolean includeDefinitionSet =
          true;
        return getTopLevelGroup(
                 includeDefinitionSet);
    }
    public org.w3c.dom.Element getTopLevelGroup(boolean includeDefinitionSet) {
        org.w3c.dom.Element topLevelGroup =
          this.
            topLevelGroup;
        if (includeDefinitionSet) {
            java.util.List defSet =
              getDefinitionSet(
                );
            if (defSet.
                  size(
                    ) >
                  0) {
                org.w3c.dom.Element defElement =
                  null;
                org.w3c.dom.NodeList defsElements =
                  topLevelGroup.
                  getElementsByTagName(
                    SVG_DEFS_TAG);
                if (defsElements.
                      getLength(
                        ) >
                      0)
                    defElement =
                      (org.w3c.dom.Element)
                        defsElements.
                        item(
                          0);
                if (defElement ==
                      null) {
                    defElement =
                      generatorContext.
                        domFactory.
                        createElementNS(
                          SVG_NAMESPACE_URI,
                          SVG_DEFS_TAG);
                    defElement.
                      setAttributeNS(
                        null,
                        SVG_ID_ATTRIBUTE,
                        generatorContext.
                          idGenerator.
                          generateID(
                            ID_PREFIX_DEFS));
                    topLevelGroup.
                      insertBefore(
                        defElement,
                        topLevelGroup.
                          getFirstChild(
                            ));
                }
                java.util.Iterator iter =
                  defSet.
                  iterator(
                    );
                while (iter.
                         hasNext(
                           ))
                    defElement.
                      appendChild(
                        (org.w3c.dom.Element)
                          iter.
                          next(
                            ));
            }
        }
        recycleTopLevelGroup(
          false);
        return topLevelGroup;
    }
    public org.apache.batik.svggen.SVGBufferedImageOp getFilterConverter() {
        return filterConverter;
    }
    public org.apache.batik.svggen.SVGGraphicContextConverter getGraphicContextConverter() {
        return gcConverter;
    }
    org.apache.batik.svggen.SVGGeneratorContext getGeneratorContext() {
        return generatorContext;
    }
    org.w3c.dom.Document getDOMFactory() {
        return generatorContext.
                 domFactory;
    }
    org.apache.batik.svggen.StyleHandler getStyleHandler() {
        return generatorContext.
                 styleHandler;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "r9CuUnk/v/ISreGv+Db5v+KoxeOhNgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4+A+Mx1qmpvpC0maTeQEAk5O90l4PkUr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "RsZCAAA=");
}
