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
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "cnbn+CMbvvY/amOj1jsVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "oWd/cP/vvfW3XvhmUcf7H0PLbNJIIAAA");
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
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "nN1Z/siGJ/4HzuyxejgVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Yw2W5Sw7d33gPya2/L6///cblJBHmZsc1afwReSljz2I/sR3cvydu2fYD6c3" +
           "Bm2Q3+1wS59y/nXv8fN/ugfdLkJXlIPkkZPsOHMiESRM4WFGCRLME/Mnk5/t" +
           "SX/tKJy9+XSoObbs6UCzOyxAP4PO+pd2G/5kegY44rnSfn2/kP1/Z474WN5e" +
           "zZof22o96/448NgwT0IBhm66kp3TeTICFmMrVw99lANJKVDx1YVdz8m8CaTh" +
           "uXVkwuxvM7ltrMra8paLvF+7pTVcO+QV7P5dO2KEB5LCD/7D81/9lSe+CbZo" +
           "AJ1LMvWBnTm24jjO8uRfeunDD73hhW99MA9AIPpwz77lO89mVIevJnHWdLKm" +
           "eyjqg5modH7yE1IYHR6fubSvaplkYDogtCYHSSDyzD3ftD727U9vE7zTZngK" +
           "WHv/Cx/44f6HXtg7llY/cUNmexxnm1rnTN95oOEAeuzVVskxsH/87DN/+NvP" +
           "PLfl6p6TSWIX3IE+/Zf/9dX9j37ryzfJRG6zvf/DxkZ39HqVsN86/BDFmc6v" +
           "FCrl9UkZ6arOWifTft0ncGbSrVgxjJdkY+xVuZY0KYvrir5u11l5HhHuqK7U" +
           "VVlel+Omo5JiQ+3gJXs4xw1rKMZ42ikKtcpwiReWVIvt84bNecsCSqMFisXa" +
           "zICszPXutDA1faSNGomYiHETkUNqYuluj9pom3FSDjZkuRxviGLa4WQJm3j2" +
           "xCszk0FPLNBDfVEihoPR0jBK1Roaz5gG0xLgah0PPETDWJ0tSGE61woMPjZs" +
           "Hhwxs0LN6BT50lAV3ZlXmXrySKtQfGpWmTbXEQqSzDERP5ZZDnPsfkVE8VGX" +
           "kkccNarJLOuPJgMGF1osqypiu1vxB324QhKIgLFEmjhuV4PXrALXsMiwMTch" +
           "BrHpJ/OBO5rQ0yI3Npdhqa405Vq3zhQmMu1Y+GLQhReDOt0M5tYkRTTekTpB" +
           "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");
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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
