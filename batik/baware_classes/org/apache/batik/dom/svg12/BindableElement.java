package org.apache.batik.dom.svg12;
public class BindableElement extends org.apache.batik.dom.svg.SVGGraphicsElement {
    protected java.lang.String namespaceURI;
    protected java.lang.String localName;
    protected org.apache.batik.dom.svg12.XBLOMShadowTreeElement xblShadowTree;
    protected BindableElement() { super(); }
    public BindableElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner,
                           java.lang.String ns,
                           java.lang.String ln) { super(prefix, owner);
                                                  namespaceURI = ns;
                                                  localName = ln;
    }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public java.lang.String getLocalName() { return localName; }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return null;
    }
    protected org.w3c.dom.Node newNode() { return new org.apache.batik.dom.svg12.BindableElement(
                                             null,
                                             null,
                                             namespaceURI,
                                             localName);
    }
    public void setShadowTree(org.apache.batik.dom.svg12.XBLOMShadowTreeElement s) {
        xblShadowTree =
          s;
    }
    public org.apache.batik.dom.svg12.XBLOMShadowTreeElement getShadowTree() {
        return xblShadowTree;
    }
    public org.w3c.dom.Node getCSSFirstChild() {
        if (xblShadowTree !=
              null) {
            return xblShadowTree.
              getFirstChild(
                );
        }
        return null;
    }
    public org.w3c.dom.Node getCSSLastChild() {
        return getCSSFirstChild(
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
       "qXW2W4vB5Ngi3ITBtioxadeQSStRMyyDzc1wXZvQJmGKc3JAskNrW2WruKNI" +
       "g9bG7sUOtZt4zGph9qoNOza2E24iWhMlwMzF0J0tRkplGosNmt00MFRxYrI/" +
       "2A1DmFspYTtpRR2krtE4kVBh19vtsAGlhaked0J70EJ79V5bjkPgO1u6JgI3" +
       "5+W52h8yzrSXc+xgwG7ba5hr0oYfrzCzQzqdRMojRO2JAxGTMITq+rVKrKVT" +
       "2uO4mr9lhMVGxpnFvD4cTVri2EcsfrEDr3Jui58m9Uq/1pvqSJz0hKYUSCiV" +
       "oER1s5aiiT5eGH1OI2ZpoA0WOAe3Wiu4Y41XKurM+/5KsGCdoblFp4et59U2" +
       "iGfNkK3589SrtrK6BCeNvpU2R7KcgjlMt/GWsK2l4x7mrSfoOO/yaKJqMYzt" +
       "JBVbCik5GDq8Qq96mS9lM1bgSGyITNUdji3k5tAkZbOKY11f6dgpNbGmFN/a" +
       "ovISrnirDpl12LYq9TGdwrnxVuSRRaZtOgQ8m6mNlqCq8DKw1xtKbyDoQJrU" +
       "1oN2y+YaWEMhmsJk2847UmvSbvt0SrIUpg/ovu2v27HOxL2QWbV4IYbhZTtR" +
       "cFTZhLVhmqJwgEg5Mdem8qIvocg8hmvbxq6TS1KVsJy40Uv5qFqdrFkjzCmy" +
       "qY/zRoS7qVllkbqU9Lle4siE0K1jOk0YzHZgduu9UTzq6dWFskjAelKRV+h4" +
       "0cQmTg0EIoFQ6U436jhe1+3O3KqZseKoE62kXF4qAcXbGyEaym4+bs67JNO2" +
       "YYWpetsV4czgTlifd2IOXRndjSpm5rIqjHCk155X0xrLSmjLkQw6DCrjSLTz" +
       "ZW3djZAOlfms0BGH1ZiKMDTwF/LccOBkog+lWn1kWXM9bO52PUQyZ3xHGa11" +
       "sT6qthb9AWtPljQLc4NmB9F6+LRfI2e5y3f0am0sVscWzGymNWXg2OmAUZdr" +
       "hkZorlbBSMoQdg7ayi22qVYUdMYzQ3ZJzOurcdAg4KzJr+GkUhmYnEvaxo4Y" +
       "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" +
       "4Yd+7tWvlqeY/w/L1ZS4YiwAAA==");
}
