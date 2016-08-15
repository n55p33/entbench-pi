package org.apache.batik.bridge;
public class GVTBuilder implements org.apache.batik.util.SVGConstants {
    public GVTBuilder() { super(); }
    public org.apache.batik.gvt.GraphicsNode build(org.apache.batik.bridge.BridgeContext ctx,
                                                   org.w3c.dom.Document document) {
        ctx.
          setDocument(
            document);
        ctx.
          initializeDocument(
            document);
        ctx.
          setGVTBuilder(
            this);
        org.apache.batik.bridge.DocumentBridge dBridge =
          ctx.
          getDocumentBridge(
            );
        org.apache.batik.gvt.RootGraphicsNode rootNode =
          null;
        try {
            rootNode =
              dBridge.
                createGraphicsNode(
                  ctx,
                  document);
            org.w3c.dom.Element svgElement =
              document.
              getDocumentElement(
                );
            org.apache.batik.gvt.GraphicsNode topNode =
              null;
            org.apache.batik.bridge.Bridge bridge =
              ctx.
              getBridge(
                svgElement);
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.GraphicsNodeBridge)) {
                return null;
            }
            org.apache.batik.bridge.GraphicsNodeBridge gnBridge =
              (org.apache.batik.bridge.GraphicsNodeBridge)
                bridge;
            topNode =
              gnBridge.
                createGraphicsNode(
                  ctx,
                  svgElement);
            if (topNode ==
                  null) {
                return null;
            }
            rootNode.
              getChildren(
                ).
              add(
                topNode);
            buildComposite(
              ctx,
              svgElement,
              (org.apache.batik.gvt.CompositeGraphicsNode)
                topNode);
            gnBridge.
              buildGraphicsNode(
                ctx,
                svgElement,
                topNode);
            dBridge.
              buildGraphicsNode(
                ctx,
                document,
                rootNode);
        }
        catch (org.apache.batik.bridge.BridgeException ex) {
            ex.
              setGraphicsNode(
                rootNode);
            throw ex;
        }
        if (ctx.
              isInteractive(
                )) {
            ctx.
              addUIEventListeners(
                document);
            ctx.
              addGVTListener(
                document);
        }
        if (ctx.
              isDynamic(
                )) {
            ctx.
              addDOMListeners(
                );
        }
        return rootNode;
    }
    public org.apache.batik.gvt.GraphicsNode build(org.apache.batik.bridge.BridgeContext ctx,
                                                   org.w3c.dom.Element e) {
        org.apache.batik.bridge.Bridge bridge =
          ctx.
          getBridge(
            e);
        if (bridge instanceof org.apache.batik.bridge.GenericBridge) {
            ((org.apache.batik.bridge.GenericBridge)
               bridge).
              handleElement(
                ctx,
                e);
            handleGenericBridges(
              ctx,
              e);
            return null;
        }
        else
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.GraphicsNodeBridge)) {
                handleGenericBridges(
                  ctx,
                  e);
                return null;
            }
        org.apache.batik.bridge.GraphicsNodeBridge gnBridge =
          (org.apache.batik.bridge.GraphicsNodeBridge)
            bridge;
        if (!gnBridge.
              getDisplay(
                e)) {
            handleGenericBridges(
              ctx,
              e);
            return null;
        }
        org.apache.batik.gvt.GraphicsNode gn =
          gnBridge.
          createGraphicsNode(
            ctx,
            e);
        if (gn !=
              null) {
            if (gnBridge.
                  isComposite(
                    )) {
                buildComposite(
                  ctx,
                  e,
                  (org.apache.batik.gvt.CompositeGraphicsNode)
                    gn);
            }
            else {
                handleGenericBridges(
                  ctx,
                  e);
            }
            gnBridge.
              buildGraphicsNode(
                ctx,
                e,
                gn);
        }
        if (ctx.
              isDynamic(
                )) {
            
        }
        return gn;
    }
    protected void buildComposite(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.CompositeGraphicsNode parentNode) {
        for (org.w3c.dom.Node n =
               e.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                buildGraphicsNode(
                  ctx,
                  (org.w3c.dom.Element)
                    n,
                  parentNode);
            }
        }
    }
    protected void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                     org.w3c.dom.Element e,
                                     org.apache.batik.gvt.CompositeGraphicsNode parentNode) {
        if (org.apache.batik.util.HaltingThread.
              hasBeenHalted(
                )) {
            throw new org.apache.batik.bridge.InterruptedBridgeException(
              );
        }
        org.apache.batik.bridge.Bridge bridge =
          ctx.
          getBridge(
            e);
        if (bridge instanceof org.apache.batik.bridge.GenericBridge) {
            ((org.apache.batik.bridge.GenericBridge)
               bridge).
              handleElement(
                ctx,
                e);
            handleGenericBridges(
              ctx,
              e);
            return;
        }
        else
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.GraphicsNodeBridge)) {
                handleGenericBridges(
                  ctx,
                  e);
                return;
            }
        if (!org.apache.batik.bridge.CSSUtilities.
              convertDisplay(
                e)) {
            handleGenericBridges(
              ctx,
              e);
            return;
        }
        org.apache.batik.bridge.GraphicsNodeBridge gnBridge =
          (org.apache.batik.bridge.GraphicsNodeBridge)
            bridge;
        try {
            org.apache.batik.gvt.GraphicsNode gn =
              gnBridge.
              createGraphicsNode(
                ctx,
                e);
            if (gn !=
                  null) {
                parentNode.
                  getChildren(
                    ).
                  add(
                    gn);
                if (gnBridge.
                      isComposite(
                        )) {
                    buildComposite(
                      ctx,
                      e,
                      (org.apache.batik.gvt.CompositeGraphicsNode)
                        gn);
                }
                else {
                    handleGenericBridges(
                      ctx,
                      e);
                }
                gnBridge.
                  buildGraphicsNode(
                    ctx,
                    e,
                    gn);
            }
            else {
                handleGenericBridges(
                  ctx,
                  e);
            }
        }
        catch (org.apache.batik.bridge.BridgeException ex) {
            org.apache.batik.gvt.GraphicsNode errNode =
              ex.
              getGraphicsNode(
                );
            if (errNode !=
                  null) {
                parentNode.
                  getChildren(
                    ).
                  add(
                    errNode);
                gnBridge.
                  buildGraphicsNode(
                    ctx,
                    e,
                    errNode);
                ex.
                  setGraphicsNode(
                    null);
            }
            throw ex;
        }
    }
    protected void handleGenericBridges(org.apache.batik.bridge.BridgeContext ctx,
                                        org.w3c.dom.Element e) {
        for (org.w3c.dom.Node n =
               e.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n instanceof org.w3c.dom.Element) {
                org.w3c.dom.Element e2 =
                  (org.w3c.dom.Element)
                    n;
                org.apache.batik.bridge.Bridge b =
                  ctx.
                  getBridge(
                    e2);
                if (b instanceof org.apache.batik.bridge.GenericBridge) {
                    ((org.apache.batik.bridge.GenericBridge)
                       b).
                      handleElement(
                        ctx,
                        e2);
                }
                handleGenericBridges(
                  ctx,
                  e2);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "EVUZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fPar2R3E/wJnz4410iQAAA==");
}
