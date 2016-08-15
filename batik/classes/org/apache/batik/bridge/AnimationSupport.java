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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYe2wUxxkfnx/Yxs8DAyFgXobWQO4gCW0jUxLs2MH0bE7Y" +
       "QYpJOOZ25+4W7+0us3P22Sl5IFXQVEWIkoRUDVUloqRpAmkV1FZtIqpIDShp" +
       "paSoaVqFVGql0gdqUKX0D9qm38zs3j7ubEoVTrq5vZlvvvm+3/ecfekKqrUp" +
       "6iQGi7Epi9ixfoMlMbWJ2qdj2x6FuZTydDX+x57Lw3dFUN0Yaslhe0jBNhnQ" +
       "iK7aY2ipZtgMGwqxhwlR+Y4kJTahE5hppjGGOjR7MG/pmqKxIVMlnGAXpgnU" +
       "jhmjWrrAyKDDgKGlCZAkLiSJbw0v9yRQk2JaUx75Ih95n2+FU+a9s2yG2hL7" +
       "8ASOF5imxxOazXqKFK2zTH0qq5ssRoostk/f5ECwPbGpDIKVr7R+fO1ork1A" +
       "MA8bhsmEevZOYpv6BFETqNWb7ddJ3t6PHkHVCTTXR8xQV8I9NA6HxuFQV1uP" +
       "CqRvJkYh32cKdZjLqc5SuEAMrQgysTDFeYdNUsgMHOqZo7vYDNouL2krtSxT" +
       "8cl18eNP72n7QTVqHUOtmjHCxVFACAaHjAGgJJ8m1N6qqkQdQ+0GGHuEUA3r" +
       "2rRj6aitZQ3MCmB+FxY+WbAIFWd6WIEdQTdaUJhJS+plhEM5/2ozOs6Crgs8" +
       "XaWGA3weFGzUQDCaweB3zpaacc1QGVoW3lHSsetLQABb5+QJy5mlo2oMDBMo" +
       "Kl1Ex0Y2PgKuZ2SBtNYEB6QMLZ6RKcfawso4zpIU98gQXVIuAVWDAIJvYagj" +
       "TCY4gZUWh6zks8+V4c1HHja2GRFUBTKrRNG5/HNhU2do006SIZRAHMiNTWsT" +
       "T+EFrx2OIATEHSFiSfPDL1+9Z33nufOS5tYKNDvS+4jCUsqpdMs7S/q676rm" +
       "YtRbpq1x4wc0F1GWdFZ6ihZkmAUljnwx5i6e2/nzBx57kfw1ghoHUZ1i6oU8" +
       "+FG7YuYtTSf0PmIQihlRB1EDMdQ+sT6I5sBzQjOInN2RydiEDaIaXUzVmeI/" +
       "QJQBFhyiRnjWjIzpPluY5cRz0UIItcEXdcB3LZIf8cvQ7njOzJM4VrChGWY8" +
       "SU2uvx2HjJMGbHPxNHj9eNw2CxRcMG7SbByDH+SIs5CmmpolENdaXoTHSMGy" +
       "TAp5BpzMurnsi1y7eZNVVQD8knDY6xAx20xdJTSlHC/09l89nXpLuhQPAwcX" +
       "hj4LJ8bkiTFxYkyeGAufiKqqxEHz+cnSumCbcYhySLNN3SMPbd97eGU1uJU1" +
       "WQPActKVgXLT56UCN3+nlDPR5ukVlza+EUE1CRTFCitgnVePrTQLeUkZd0K3" +
       "KQ2FyKsHy331gBcyaipEhXQ0U11wuNSbE4TyeYbm+zi41YrHZXzmWlFRfnTu" +
       "xOTjux7dEEGRYAngR9ZC9uLbkzxxlxJ0Vzj0K/FtPXT54zNPHTC9JBCoKW4p" +
       "LNvJdVgZdoUwPCll7XJ8NvXagS4BewMkaYYhqMDIneEzAjmmx83XXJd6UDhj" +
       "0jzW+ZKLcSPLUXPSmxE+2s6HDumu3IVCAopU/8UR69nf/PLPdwgk3arQ6ivn" +
       "I4T1+DIRZxYVOafd88hRSgjQfXAi+Y0nrxzaLdwRKFZVOrCLj32QgcA6gOBX" +
       "zu9//8NLpy5GPBdmUIoLaehoikKX+Z/Apwq+/+Ffnj34hMwi0T4nlS0v5TKL" +
       "n7zGkw2ymg6hz52j634D3FDLaDitEx4//2pdvfHs3460SXPrMON6y/rrM/Dm" +
       "b+lFj72155+dgk2Vwquqh59HJlP1PI/zVkrxFJej+Pi7S595Ez8LSR8Sra1N" +
       "E5E7kcADCQNuElhsEOOdobXP82G17ffxYBj5up+UcvTiR827Pnr9qpA22D75" +
       "7T6ErR7pRdIKcNhnkDMEcjlfXWDxcWERZFgYTlTbsJ0DZneeG36wTT93DY4d" +
       "g2MVSLv2Dgp5shhwJYe6ds5vf/bGgr3vVKPIAGrUTawOYBFwqAE8ndg5SLFF" +
       "6+57pByT9W6lKaIyhMomuBWWVbZvf95iwiLTP1r46ubnT14SbmlJHrf6Ga4R" +
       "Yzcf1ov5CH+8jaF6nIbsAMIWS7iJT+ssuAXZU7R0pjZFtFinDh4/qe54bqNs" +
       "JqLB0t8Pne3Lv/7327ETv79Qoe40MNO6TScTRPedWcOPDBSNIdHBeYnrg5Zj" +
       "f/hxV7b3RuoFn+u8TkXg/5eBEmtnzv9hUd48+JfFo1tye28g9S8LwRlm+d2h" +
       "ly7ct0Y5FhHtqsz6ZW1ucFOPH1g4lBLoyw2uJp9pFoGzquQAUW7Yu+G7wXGA" +
       "eDhwZI6e1bHqbHFj8NxKuEu7y60C11DKqHGMzf8vgprDW5DJO5SYauZj4BFw" +
       "E4r1859RTLOEuWRtIlJ42x6Tbbu7EPWFENahUwT7BpoP7iAjBYiGJNXyUDwm" +
       "nIb59uRe5XBX8o/Sf2+psEHSdbwQ//qu9/a9LSxdz12rhK/PrcAFfSWvjQ8x" +
       "HkPds1w/g/LED0Q/HP/W5ZelPOFuP0RMDh9/4pPYkeMytuSVaFXZrcS/R16L" +
       "QtKtmO0UsWPgT2cO/OSFA4ciTpLfzlC15txWuTWrSv3e/CCCUs57v9r606PR" +
       "6gGI2EFUXzC0/QUyqAa9do5dSPsg9W5Qng87EvOKC63oWkiFYvqBWaqRuAjs" +
       "ZKg5o1EyquWJcCpBqjj6858sQzUTpiaviV/gw4hc2Px/ZnU+0WuJ+eFSjCzj" +
       "a7fDd4sTI1tuOPL4sKtC1M3EMQRNxGP1YCmm/KE3DDYTUjwyC6gH+VBkaB5E" +
       "JsdU5e9AANbeqUHV5dpddqeAy08+xsCzIHj9uzzMp24C5p3IyXQJB6HEp4b5" +
       "TBxnwZwPj4oTj86C7zE+PAFJDfD1JUEOL18Z8xD72k1AbClfWwffUUe/0RtB" +
       "DKq6RU0GPQxRKwE3fxbG/xNw354FuO/w4QRDLRy4cp+c5/f0Mu975tPAEqKi" +
       "LXxr5i3eorI3cvItknL6ZGv9wpP3vyeamdKbniaoMZmCrvvyoz9X1lmUZDSh" +
       "cpNsiy3x8z2GFs5wl4eSLR+E5C9K+tNO9PvpGaoVv3667zPU6NEBK/ngJ3kV" +
       "KgKQ8MezVoVyLV8pFavKm1cBfsf1wPc1pKsCxVS8EXUrTkG+E00pZ05uH374" +
       "6ueekzdJRcfT05zLXKgz8r5a6sdWzMjN5VW3rftayysNq93iF7jJ+mUTLgBl" +
       "UNz6FoeuVnZX6Yb1/qnNr//icN27ULZ3oyoMjrnb9z5SIgX3swI0wrsT5fUU" +
       "eldx5+vp/ubUlvWZv/9O3AuQrL9LZqZPKReff+hXxxadgrvh3EFUC3WdFMdQ" +
       "o2bfO2XsJMoEHUPNmt1fBBGBi4b1QLFu4c6JedMlcHHgbC7N8lcMDK0sbz/K" +
       "X8zAHWqS0F6zYIgcAeV+rjcTeFXrOHwjRFJogzfj67jGZU3n1gB/TCWGLMu9" +
       "n9dQS8SoHm5axKTYfV488uHCfwGmaaXRLRkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
