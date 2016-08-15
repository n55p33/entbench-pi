package org.apache.batik.bridge;
public abstract class AnimationSupport {
    public static void fireTimeEvent(org.w3c.dom.events.EventTarget target,
                                     java.lang.String eventType,
                                     java.util.Calendar time,
                                     int detail) { org.w3c.dom.events.DocumentEvent de =
                                                     (org.w3c.dom.events.DocumentEvent)
                                                       ((org.w3c.dom.Node)
                                                          target).
                                                       getOwnerDocument(
                                                         );
                                                   org.apache.batik.dom.events.DOMTimeEvent evt =
                                                     (org.apache.batik.dom.events.DOMTimeEvent)
                                                       de.
                                                       createEvent(
                                                         "TimeEvent");
                                                   evt.
                                                     initTimeEventNS(
                                                       org.apache.batik.util.XMLConstants.
                                                         XML_EVENTS_NAMESPACE_URI,
                                                       eventType,
                                                       null,
                                                       detail);
                                                   evt.
                                                     setTimestamp(
                                                       time.
                                                         getTime(
                                                           ).
                                                         getTime(
                                                           ));
                                                   target.
                                                     dispatchEvent(
                                                       evt);
    }
    public static org.apache.batik.anim.timing.TimedElement getTimedElementById(java.lang.String id,
                                                                                org.w3c.dom.Node n) {
        org.w3c.dom.Element e =
          getElementById(
            id,
            n);
        if (e instanceof org.apache.batik.dom.svg.SVGOMAnimationElement) {
            org.apache.batik.bridge.SVGAnimationElementBridge b =
              (org.apache.batik.bridge.SVGAnimationElementBridge)
                ((org.apache.batik.dom.svg.SVGOMAnimationElement)
                   e).
                getSVGContext(
                  );
            return b.
              getTimedElement(
                );
        }
        return null;
    }
    public static org.w3c.dom.events.EventTarget getEventTargetById(java.lang.String id,
                                                                    org.w3c.dom.Node n) {
        return (org.w3c.dom.events.EventTarget)
                 getElementById(
                   id,
                   n);
    }
    protected static org.w3c.dom.Element getElementById(java.lang.String id,
                                                        org.w3c.dom.Node n) {
        org.w3c.dom.Node p =
          n.
          getParentNode(
            );
        while (p !=
                 null) {
            n =
              p;
            if (n instanceof org.apache.batik.dom.svg.SVGOMUseShadowRoot) {
                p =
                  ((org.apache.batik.dom.svg.SVGOMUseShadowRoot)
                     n).
                    getCSSParentNode(
                      );
            }
            else {
                p =
                  n.
                    getParentNode(
                      );
            }
        }
        if (n instanceof org.apache.batik.dom.svg.IdContainer) {
            return ((org.apache.batik.dom.svg.IdContainer)
                      n).
              getElementById(
                id);
        }
        return null;
    }
    public AnimationSupport() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "9/OaJy0Ro3qwaRGTYvc58YjD+f8ClmSm1i0ZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALVaeczsVnX3+/Je8vJI8l5eyNKU7I8lMf084/FsepAyq8cz" +
       "9iy2x54xlId3e8bbeBuPadqAyiKQUtQmlFYQqRWIgsJSVFQkSpWqagGBKlGh" +
       "blIBVZVKS5HIH6VVaUuvPd/+FhRRRvKdO9fnnnvO755z7rn3zgvfh84EPgR7" +
       "rrXRLTfcVZNwd2GVd8ONpwa7fbI8Fv1AVVqWGAQsaLsiP/rZ8z/80QeMCzvQ" +
       "zQJ0l+g4biiGpusEtBq4VqwqJHT+sLVjqXYQQhfIhRiLSBSaFkKaQXiZhF5x" +
       "pGsIXSL3RUCACAgQAclFQBqHVKDT7aoT2a2sh+iEwQr6FegUCd3syZl4IfTI" +
       "cSae6Iv2HptxrgHgcDb7zQGl8s6JDz18oPtW56sUfg5Gnv2tt1743E3QeQE6" +
       "bzpMJo4MhAjBIAJ0m63akuoHDUVRFQG601FVhVF9U7TMNJdbgC4Gpu6IYeSr" +
       "ByBljZGn+vmYh8jdJme6+ZEcuv6BepqpWsr+rzOaJepA13sOdd1q2M3agYLn" +
       "TCCYr4myut/l9NJ0lBB66GSPAx0vDQAB6HqLrYaGezDUaUcEDdDF7dxZoqMj" +
       "TOibjg5Iz7gRGCWE7r8u0wxrT5SXoq5eCaH7TtKNt68A1a05EFmXELr7JFnO" +
       "CczS/Sdm6cj8fH/4hmfe7vScnVxmRZWtTP6zoNODJzrRqqb6qiOr2463PUF+" +
       "ULznS+/dgSBAfPcJ4i3NH/3yS296/YMvfmVL8/PXoBlJC1UOr8gfle74xqta" +
       "j9dvysQ467mBmU3+Mc1z8x/vvbmceMDz7jngmL3c3X/5Iv0X86c/qX5vBzpH" +
       "QDfLrhXZwI7ulF3bMy3Vx1VH9cVQVQjoVtVRWvl7AroF1EnTUbetI00L1JCA" +
       "Tlt5081u/htApAEWGUS3gLrpaO5+3RNDI68nHgRBF8AD3Q2eJ6DtJ/8OoTcj" +
       "hmuriCiLjum4yNh3M/0DRHVCCWBrIBKw+iUSuJEPTBBxfR0RgR0Y6t4LyTcV" +
       "XQV+bdq5ezCR57k+iDrAyLyfLfsk0+7C+tQpAPyrTrq9BTym51qK6l+Rn42a" +
       "nZc+feVrOwdusIdLCL0OjLi7HXE3H3F3O+LuyRGhU6fygV6ZjbydXTA3S+Dl" +
       "IP7d9jjzS/23vffRm4BZeevTANiMFLl+GG4dxgUij34yME7oxQ+t38H9amEH" +
       "2jkeTzNpQdO5rPs4i4IH0e7SST+6Ft/z7/nuDz/zwafcQ486FqD3HP3qnpmj" +
       "PnoSV9+VVQWEvkP2Tzwsfv7Kl566tAOdBt4PIl4oAgsFiD14coxjDnt5P/hl" +
       "upwBCmuub4tW9mo/Yp0LDd9dH7bkE35HXr8TYPxaaK84ZtLZ27u8rHzl1kCy" +
       "STuhRR5c38h4H/nbv/yXUg73fhw+f2RlY9Tw8hHfz5idz738zkMbYH1VBXT/" +
       "8KHxbz73/fe8OTcAQPHYtQa8lJUt4PNgCgHM7/rK6u++/a2PfnPn0GhCsPhF" +
       "kmXKyVbJH4PPKfD8b/ZkymUNW7+92NoLHg8fRA8vG/k1h7KBOGIBZ8ss6NLU" +
       "sV3F1ExRstTMYv/7/KuLn/+3Zy5sbcICLfsm9fqfzOCw/eea0NNfe+t/PJiz" +
       "OSVn69ghfodk2+B41yHnhu+Lm0yO5B1/9cBvf1n8CAizILQFZqrm0QrK8YDy" +
       "CSzkWMB5iZx4h2bFQ8FRRzjua0fyjSvyB775g9u5H/zJS7m0xxOWo/NOid7l" +
       "rallxcMJYH/vSa/viYEB6LAXh2+5YL34I8BRABxlEMOCkQ+CTnLMSvaoz9zy" +
       "93/6Z/e87Rs3QTtd6JzlikpXzB0OuhVYuhoYIF4l3i++aWvN67P7YTuBrlJ+" +
       "ayD35b9uAgI+fv1Y083yjUN3ve+/Rpb0zn/8z6tAyKPMNZbZE/0F5IUP3996" +
       "8nt5/0N3z3o/mFwdiEFudtgX/aT97zuP3vznO9AtAnRB3kv8ONGKMicSQLIT" +
       "7GeDIDk89v544rJdpS8fhLNXnQw1R4Y9GWgOFwBQz6iz+rnDCX88OQUc8Qy6" +
       "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" +
       "dWwvzC/S0i/c+4dv+Pjz38oP8/8PflTEUQgkAAA=");
}
