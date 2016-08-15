package org.apache.batik.dom.events;
public class DOMUIEvent extends org.apache.batik.dom.events.AbstractEvent implements org.w3c.dom.events.UIEvent {
    private org.w3c.dom.views.AbstractView view;
    private int detail;
    public org.w3c.dom.views.AbstractView getView() { return view; }
    public int getDetail() { return detail; }
    public void initUIEvent(java.lang.String typeArg, boolean canBubbleArg,
                            boolean cancelableArg,
                            org.w3c.dom.views.AbstractView viewArg,
                            int detailArg) { initEvent(typeArg, canBubbleArg,
                                                       cancelableArg);
                                             this.view = viewArg;
                                             this.detail = detailArg; }
    public void initUIEventNS(java.lang.String namespaceURIArg, java.lang.String typeArg,
                              boolean canBubbleArg,
                              boolean cancelableArg,
                              org.w3c.dom.views.AbstractView viewArg,
                              int detailArg) { initEventNS(namespaceURIArg,
                                                           typeArg,
                                                           canBubbleArg,
                                                           cancelableArg);
                                               this.view = viewArg;
                                               this.detail = detailArg;
    }
    protected java.lang.String[] split(java.lang.String s) { java.util.List a =
                                                               new java.util.ArrayList(
                                                               8);
                                                             java.lang.StringBuffer sb;
                                                             int i =
                                                               0;
                                                             int len =
                                                               s.
                                                               length(
                                                                 );
                                                             while (i <
                                                                      len) {
                                                                 char c =
                                                                   s.
                                                                   charAt(
                                                                     i++);
                                                                 if (org.apache.batik.xml.XMLUtilities.
                                                                       isXMLSpace(
                                                                         c)) {
                                                                     continue;
                                                                 }
                                                                 sb =
                                                                   new java.lang.StringBuffer(
                                                                     );
                                                                 sb.
                                                                   append(
                                                                     c);
                                                                 while (i <
                                                                          len) {
                                                                     c =
                                                                       s.
                                                                         charAt(
                                                                           i++);
                                                                     if (org.apache.batik.xml.XMLUtilities.
                                                                           isXMLSpace(
                                                                             c)) {
                                                                         a.
                                                                           add(
                                                                             sb.
                                                                               toString(
                                                                                 ));
                                                                         break;
                                                                     }
                                                                     sb.
                                                                       append(
                                                                         c);
                                                                 }
                                                                 if (i ==
                                                                       len) {
                                                                     a.
                                                                       add(
                                                                         sb.
                                                                           toString(
                                                                             ));
                                                                 }
                                                             }
                                                             return (java.lang.String[])
                                                                      a.
                                                                      toArray(
                                                                        new java.lang.String[a.
                                                                                               size(
                                                                                                 )]);
    }
    public DOMUIEvent() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "JWMGD/IcfBZAAm2ogr/iW+X/ADMJI8VXHwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6p+Up4H/FzbULp2OKgAA");
}
