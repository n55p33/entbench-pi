package org.apache.batik.dom.events;
public class DOMTextEvent extends org.apache.batik.dom.events.DOMUIEvent implements org.w3c.dom.events.TextEvent {
    protected java.lang.String data;
    public java.lang.String getData() { return data; }
    public void initTextEvent(java.lang.String typeArg, boolean canBubbleArg,
                              boolean cancelableArg,
                              org.w3c.dom.views.AbstractView viewArg,
                              java.lang.String dataArg) { initUIEvent(typeArg,
                                                                      canBubbleArg,
                                                                      cancelableArg,
                                                                      viewArg,
                                                                      0);
                                                          data =
                                                            dataArg;
    }
    public void initTextEventNS(java.lang.String namespaceURIArg,
                                java.lang.String typeArg,
                                boolean canBubbleArg,
                                boolean cancelableArg,
                                org.w3c.dom.views.AbstractView viewArg,
                                java.lang.String dataArg) {
        initUIEventNS(
          namespaceURIArg,
          typeArg,
          canBubbleArg,
          cancelableArg,
          viewArg,
          0);
        data =
          dataArg;
    }
    public DOMTextEvent() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fvOZb+T74/8DOKufO/QjAAA=");
}
