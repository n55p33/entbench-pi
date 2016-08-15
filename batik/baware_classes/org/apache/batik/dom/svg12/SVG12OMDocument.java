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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6a8wkWVU13+zM7Ay7O7O7sKwj+x5Wdxu/enT1iwXd6uqu" +
       "flV39aOqursUhnp3dT273t2w8ggCkbgSWHBNYP0hRMWFJUQixmDWGAUCMcEQ" +
       "X4lAjIkokrA/RCMq3qr+3vPAjdhf6vbte88595xzzzl17rnf89+FzgQ+VPBc" +
       "a61bbrirpuHu0irthmtPDXa7dGko+oGqkJYYBCwYuyo//JmL3//BBxaXdqCz" +
       "AnS36DhuKIaG6wRjNXCtWFVo6OLhaNNS7SCELtFLMRbhKDQsmDaC8AkaesUR" +
       "1BC6Qu+zAAMWYMACnLMAE4dQAOl21YlsMsMQnTBYQb8InaKhs56csRdCDx0n" +
       "4om+aO+RGeYSAAq3Zr95IFSOnPrQgweyb2W+RuAPF+Bnfu3Nlz57GrooQBcN" +
       "Z5KxIwMmQrCIAN1mq7ak+gGhKKoiQHc6qqpMVN8QLWOT8y1AdwWG7ohh5KsH" +
       "SsoGI0/18zUPNXebnMnmR3Lo+gfiaYZqKfu/zmiWqANZ7zmUdSshlY0DAS8Y" +
       "gDFfE2V1H+UW03CUEHrgJMaBjFd6AACgnrPVcOEeLHWLI4IB6K7t3lmio8OT" +
       "0DccHYCecSOwSghdviHRTNeeKJuirl4NoXtPwg23UwDqfK6IDCWEXnUSLKcE" +
       "dunyiV06sj/fHbzh6bc6bWcn51lRZSvj/1aAdP8JpLGqqb7qyOoW8bbH6Y+I" +
       "93zhfTsQBIBfdQJ4C/P7b3vpydfd/+KXtjA/eR0YRlqqcnhV/rh0x9deQz5W" +
       "O52xcavnBka2+cckz81/uDfzROoBz7vngGI2ubs/+eL4z+bv+KT6nR3oQgc6" +
       "K7tWZAM7ulN2bc+wVL+lOqovhqrSgc6rjkLm8x3oHOjThqNuRxlNC9SwA91i" +
       "5UNn3fw3UJEGSGQqOgf6hqO5+31PDBd5P/UgCDoHHug28DwKbT/5dwi9CV64" +
       "tgqLsugYjgsPfTeTP4BVJ5SAbhewBKzehAM38oEJwq6vwyKwg4W6N6G4NhzE" +
       "OorBE76FYky/4cqRDbB3MzPz/r8XSDMJLyWnTgHlv+ak61vAa9qupaj+VfmZ" +
       "qN586dNXv7Jz4Ap7ugmhx8Gau9s1d/M1d8Gau/mauyfWhE6dypd6Zbb2do/B" +
       "DpnA10EUvO2xyZu6b3nfw6eBcXnJLUC9OwAUvnEwJg+jQyePgTIwUejFZ5N3" +
       "8m9HdqCd41E14xcMXcjQh1ksPIh5V0560/XoXnzvt7//wkeecg/96liY3nP3" +
       "azEzd334pGZ9V1YVEAAPyT/+oPi5q1946soOdAuIASDuhSKwUxBS7j+5xjG3" +
       "fWI/BGaynAECa65vi1Y2tR+3LoQL300OR/ItvyPv3wl0fEdmx/eBp7Bn2Pl3" +
       "Nnu3l7Wv3JpItmknpMhD7Bsn3sf++s//qZirez8aXzzyfpuo4RNHIkBG7GLu" +
       "63ce2gDrqyqA+7tnhx/68Hff+/O5AQCIR6634JWsJYHngy0Eav6lL63+5pvf" +
       "+PjXdw6M5lQInfd8NwReoirpgZzZFHT7TeQECz56yBIIIhagkBnOFc6xXcXQ" +
       "DFGy1MxQ//Pia9HP/cvTl7amYIGRfUt63Y8mcDj+E3XoHV9587/dn5M5JWcv" +
       "sUO1HYJtI+Pdh5QJ3xfXGR/pO//ivl//ovgxEGNBXAuMjZqHKihXA5TvG5zL" +
       "/3je7p6YQ7PmgeCo/R93sSPJxlX5A1//3u389/7opZzb49nK0e3ui94TWwvL" +
       "mgdTQP7VJ529LQYLAIe/OPiFS9aLPwAUBUBRBuErYHwQbdJjxrEHfebc3/7x" +
       "n9zzlq+dhnYo6ILligol5n4GnQcGrgYLEKhS7+ee3G5ucitoLuWiQtcInw9c" +
       "PrCMV2SDl8GD7lkGen0PyNqH8vZK1vzUvrWd9SLJMuQTpnbhJgRPbMrOXrDL" +
       "fr8KvCKzeJoU5TyM7kfOA/8FAPcdA2D6HdsDeSUAyjck5/bJm+w7lTW1fArL" +
       "mtdvOS/9r3S3hb03/3UabO5jNw7PVJaoHUa4e/+DsaR3/f2/X2NAeWC+Tn5y" +
       "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" +
       "AAA=");
}
