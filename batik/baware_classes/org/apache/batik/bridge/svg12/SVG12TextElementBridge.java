package org.apache.batik.bridge.svg12;
public class SVG12TextElementBridge extends org.apache.batik.bridge.SVGTextElementBridge implements org.apache.batik.bridge.svg12.SVG12BridgeUpdateHandler {
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.svg12.SVG12TextElementBridge(
                                                            ); }
    protected void addTextEventListeners(org.apache.batik.bridge.BridgeContext ctx,
                                         org.apache.batik.dom.events.NodeEventTarget e) {
        if (childNodeRemovedEventListener ==
              null) {
            childNodeRemovedEventListener =
              new org.apache.batik.bridge.svg12.SVG12TextElementBridge.DOMChildNodeRemovedEventListener(
                );
        }
        if (subtreeModifiedEventListener ==
              null) {
            subtreeModifiedEventListener =
              new org.apache.batik.bridge.svg12.SVG12TextElementBridge.DOMSubtreeModifiedEventListener(
                );
        }
        org.apache.batik.bridge.svg12.SVG12BridgeContext ctx12 =
          (org.apache.batik.bridge.svg12.SVG12BridgeContext)
            ctx;
        org.apache.batik.dom.AbstractNode n =
          (org.apache.batik.dom.AbstractNode)
            e;
        org.apache.batik.dom.svg12.XBLEventSupport evtSupport =
          (org.apache.batik.dom.svg12.XBLEventSupport)
            n.
            initializeEventSupport(
              );
        evtSupport.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true);
        ctx12.
          storeImplementationEventListenerNS(
            e,
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true);
        evtSupport.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false);
        ctx12.
          storeImplementationEventListenerNS(
            e,
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false);
    }
    protected void removeTextEventListeners(org.apache.batik.bridge.BridgeContext ctx,
                                            org.apache.batik.dom.events.NodeEventTarget e) {
        org.apache.batik.dom.AbstractNode n =
          (org.apache.batik.dom.AbstractNode)
            e;
        org.apache.batik.dom.svg12.XBLEventSupport evtSupport =
          (org.apache.batik.dom.svg12.XBLEventSupport)
            n.
            initializeEventSupport(
              );
        evtSupport.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true);
        evtSupport.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false);
    }
    protected class DOMChildNodeRemovedEventListener extends org.apache.batik.bridge.SVGTextElementBridge.DOMChildNodeRemovedEventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            super.
              handleEvent(
                org.apache.batik.dom.events.EventSupport.
                  getUltimateOriginalEvent(
                    evt));
        }
        public DOMChildNodeRemovedEventListener() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "c3bn+CMbvvE/m59a/DsVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected class DOMSubtreeModifiedEventListener extends org.apache.batik.bridge.SVGTextElementBridge.DOMSubtreeModifiedEventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            super.
              handleEvent(
                org.apache.batik.dom.events.EventSupport.
                  getUltimateOriginalEvent(
                    evt));
        }
        public DOMSubtreeModifiedEventListener() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Z3eOP7LhG/8DntYO5zgVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected org.w3c.dom.Node getFirstChild(org.w3c.dom.Node n) {
        return ((org.apache.batik.dom.xbl.NodeXBL)
                  n).
          getXblFirstChild(
            );
    }
    protected org.w3c.dom.Node getNextSibling(org.w3c.dom.Node n) {
        return ((org.apache.batik.dom.xbl.NodeXBL)
                  n).
          getXblNextSibling(
            );
    }
    protected org.w3c.dom.Node getParentNode(org.w3c.dom.Node n) {
        return ((org.apache.batik.dom.xbl.NodeXBL)
                  n).
          getXblParentNode(
            );
    }
    public void handleDOMCharacterDataModified(org.w3c.dom.events.MutationEvent evt) {
        org.w3c.dom.Node childNode =
          (org.w3c.dom.Node)
            evt.
            getTarget(
              );
        if (isParentDisplayed(
              childNode)) {
            if (getParentNode(
                  childNode) !=
                  childNode.
                  getParentNode(
                    )) {
                computeLaidoutText(
                  ctx,
                  e,
                  node);
            }
            else {
                laidoutText =
                  null;
            }
        }
    }
    public void handleBindingEvent(org.w3c.dom.Element bindableElement,
                                   org.w3c.dom.Element shadowTree) {
        
    }
    public void handleContentSelectionChangedEvent(org.apache.batik.bridge.svg12.ContentSelectionChangedEvent csce) {
        computeLaidoutText(
          ctx,
          e,
          node);
    }
    public SVG12TextElementBridge() { super(
                                        );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Vhfgy6kPHJLy489DyuvSxjp43rMj5Xueq5SXXyMOufFdB914J8j1w51bUelr" +
       "RuSzR2jiC2nxabBw6Fkm0Br0mzpYbkFw9lpiIO4eiRya4X/1fFWDgudPd1Tz" +
       "kRdGNYeWjZsOqmbnQkTa9dUM+StHqORrafHFADq3UUkDZD/pVmK0Q+CAGr70" +
       "fNWQ9n9iRw1//hPxkJ87OiHMVk87GCs7593A+LamyPu+880jFPWttHg6gO7Z" +
       "KOooWocU943norhVAN1y+ast6dn8rZdcrdtcB5M++MSZa1/8BPvV7HbH3pWt" +
       "kyR0rRqa5sGj1AP1E66nqEYm3cnNwaqb/f17AN1+pCYD6Hj2n3H/bxuk/wig" +
       "F18BKYBOzPYzsh347+2sSwfhAd3s/yDcDwLo1D4cILWpHAR5NoCuAiBp9Yfu" +
       "ri/cfyUJgHYv0e3q2IGsfsd7M9ud+3G220M5eJsk/RLI7kruZu3h5rbkBelD" +
       "T3Sp1z+Dvm9zm0UyxSRJqVxLQtdsLtbsZf53X5HaLq0TnfuePf3hk/fufqWc" +
       "3jC8P5MO8Hbn5a+LYJYbZBc8ko+/+M9e+YdPfD07ZP5fjuKxPMQqAAA=");
}
