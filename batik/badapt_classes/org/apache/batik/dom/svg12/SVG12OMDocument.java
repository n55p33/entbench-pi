package org.apache.batik.dom.svg12;
public class SVG12OMDocument extends org.apache.batik.dom.svg.SVGOMDocument {
    protected SVG12OMDocument() { super(); }
    public SVG12OMDocument(org.w3c.dom.DocumentType dt, org.w3c.dom.DOMImplementation impl) {
        super(
          dt,
          impl);
    }
    protected org.w3c.dom.Node newNode() { return new org.apache.batik.dom.svg12.SVG12OMDocument(
                                             ); }
    public void addCSSNavigableDocumentListener(org.apache.batik.css.engine.CSSNavigableDocumentListener l) {
        if (cssNavigableDocumentListeners.
              containsKey(
                l)) {
            return;
        }
        org.apache.batik.dom.svg.SVGOMDocument.DOMNodeInsertedListenerWrapper nodeInserted =
          new org.apache.batik.dom.svg.SVGOMDocument.DOMNodeInsertedListenerWrapper(
          l);
        org.apache.batik.dom.svg.SVGOMDocument.DOMNodeRemovedListenerWrapper nodeRemoved =
          new org.apache.batik.dom.svg.SVGOMDocument.DOMNodeRemovedListenerWrapper(
          l);
        org.apache.batik.dom.svg.SVGOMDocument.DOMSubtreeModifiedListenerWrapper subtreeModified =
          new org.apache.batik.dom.svg.SVGOMDocument.DOMSubtreeModifiedListenerWrapper(
          l);
        org.apache.batik.dom.svg.SVGOMDocument.DOMCharacterDataModifiedListenerWrapper cdataModified =
          new org.apache.batik.dom.svg.SVGOMDocument.DOMCharacterDataModifiedListenerWrapper(
          l);
        org.apache.batik.dom.svg.SVGOMDocument.DOMAttrModifiedListenerWrapper attrModified =
          new org.apache.batik.dom.svg.SVGOMDocument.DOMAttrModifiedListenerWrapper(
          l);
        cssNavigableDocumentListeners.
          put(
            l,
            new org.w3c.dom.events.EventListener[] { nodeInserted,
            nodeRemoved,
            subtreeModified,
            cdataModified,
            attrModified });
        org.apache.batik.dom.svg12.XBLEventSupport es =
          (org.apache.batik.dom.svg12.XBLEventSupport)
            initializeEventSupport(
              );
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeInserted",
            nodeInserted,
            false);
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            nodeRemoved,
            false);
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModified,
            false);
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMCharacterDataModified",
            cdataModified,
            false);
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMAttrModified",
            attrModified,
            false);
    }
    public void removeCSSNavigableDocumentListener(org.apache.batik.css.engine.CSSNavigableDocumentListener l) {
        org.w3c.dom.events.EventListener[] listeners =
          (org.w3c.dom.events.EventListener[])
            cssNavigableDocumentListeners.
            get(
              l);
        if (listeners ==
              null) {
            return;
        }
        org.apache.batik.dom.svg12.XBLEventSupport es =
          (org.apache.batik.dom.svg12.XBLEventSupport)
            initializeEventSupport(
              );
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeInserted",
            listeners[0],
            false);
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            listeners[1],
            false);
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            listeners[2],
            false);
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMCharacterDataModified",
            listeners[3],
            false);
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMAttrModified",
            listeners[4],
            false);
        cssNavigableDocumentListeners.
          remove(
            l);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "N6T2y9ux3plvzg9upsBGNRvgXsZObTv0UNa84eCEKv+chU7cZpw8obp3/7zM" +
       "h+670YVTvvP82LueeU4afRzZ2Tth0kLofOi4P2XKa9k8cWD0+I132WR+33Z4" +
       "avOFd/3TZfanV299GUf5D5zg8yTJ3yaf/xL+qPiBHej0wRnONTeBx5GeOH5y" +
       "c8GXw8i32WPnN/cdaPbu/cPE1+9p9vUv5zAxe/3Jre1vcoD3CzcZe3fWvCOE" +
       "ztlyTDnSwZnhpaNnhgcDufc89XLO//KOtx8/O30deLp74nZerrhvvK64p7YA" +
       "+9zXr7liEoNgV7ZVzZZ32wxDCWtNzU7X949Ls+Px7JwsJ/6Bm+jrw1nzy8AJ" +
       "BEm6GaEcWToSbKsQumXtaNKhHp/+Uehxs6fH5Eeqx+znB3OA37iJLj6eNc+F" +
       "0MO+bDlr+WbqyCCfPRT911/WEXIIXTxxL5jdcNx7zT8Ptrfl4qeeu3jrq5+b" +
       "/mV+NXZwo32egG5VItM8eqh65P2sCxZWLRfr/PaI1c2/ng+hyze+rwyhM/l3" +
       "zvPvbDFeCKFXXg8jhE6D9ijkZ/bC7CgkoJh/H4X7bAhdOIQLobPbl6MgnwPU" +
       "AUj2+vvufhQ8eiPGs2vWQ2Ump45n7wMr3fXDrHQk4T9yLE3n/x3ZT6nR9t8j" +
       "V8UXnhtQb3up+vHt3Z9oCmmaUbmVgM5tryEP0vJDN6S2T+ts77Hv3/Hp86/d" +
       "X0Lu2DJ86PVHeHvg+rdsXcsN83ux9HOv/t03/OZzX8+Pi/8HPf+YQdQjAAA=");
}
