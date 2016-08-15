package org.apache.batik.bridge;
public class SVGAltGlyphHandler implements org.apache.batik.gvt.font.AltGlyphHandler, org.apache.batik.util.SVGConstants {
    private org.apache.batik.bridge.BridgeContext ctx;
    private org.w3c.dom.Element textElement;
    public SVGAltGlyphHandler(org.apache.batik.bridge.BridgeContext ctx, org.w3c.dom.Element textElement) {
        super(
          );
        this.
          ctx =
          ctx;
        this.
          textElement =
          textElement;
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      float fontSize,
                                                                      java.text.AttributedCharacterIterator aci) {
        try {
            if (SVG_NAMESPACE_URI.
                  equals(
                    textElement.
                      getNamespaceURI(
                        )) &&
                  SVG_ALT_GLYPH_TAG.
                  equals(
                    textElement.
                      getLocalName(
                        ))) {
                org.apache.batik.bridge.SVGAltGlyphElementBridge altGlyphBridge =
                  (org.apache.batik.bridge.SVGAltGlyphElementBridge)
                    ctx.
                    getBridge(
                      textElement);
                org.apache.batik.gvt.font.Glyph[] glyphArray =
                  altGlyphBridge.
                  createAltGlyphArray(
                    ctx,
                    textElement,
                    fontSize,
                    aci);
                if (glyphArray !=
                      null) {
                    return new org.apache.batik.gvt.font.SVGGVTGlyphVector(
                      null,
                      glyphArray,
                      frc);
                }
            }
        }
        catch (java.lang.SecurityException e) {
            ctx.
              getUserAgent(
                ).
              displayError(
                e);
            throw e;
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "wiGf5NyX+SMbrvwP7w2TCsYYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jsNII+JYrYsrBKGMdGaQNbilzLrmtKSwtldmSl2ji7Q70rqfhctgYbXNxmLa" +
       "8eo6W2/bvsi1J3gyD2tA+as40cf+kqNDJ8lIdYKUlkMERpdwwqII2ooEcR2s" +
       "1uvYrlIVjqDwBgmyhlnNSEoTtSbHQm/bTFI+QVo43FpWluVRO5Td2ajMis0x" +
       "Sk0pasv0Fp0IoTcrHq02Ww1prGPZZr0SsPmwy87rTZShAn0W251KTyP6fko7" +
       "noFMMxWxiJgxzFIy8uP5xkrUYBM4vMtrgRGqGV+t+QOHDNUS4Qlc0Cc73VHH" +
       "7QYdlV9jiBvwSmhq3bmKxR2FGUV0jXPxqq+06/YkWIX1BtZwAkLKqiGPNzix" +
       "FU50c6irzCRue2RS4kdZ0K+guj6o6DwnbPFQsXorBfORzlQ3ykR5gQCd00EC" +
       "ZxYV9AeqoU+b8qKRisKIQg2uLKbioIFjzV6b12DGlbdpQGKWY6cY2BHdenkB" +
       "W1mpQaF4T++UF/NIZ7VeQjITadk2DVquSuu6ADhP5jCqj63eNkvhbrCgSNRI" +
       "V8SixA+qfLvtZrGKJyrd481mi0Ma4yUvkhoxDHFhYM/rU6Y+9NuVuCKRzrRV" +
       "58NeCxt1GutAcEW3S038coVUiDVIpOEt2bW2vlZTe8rMW8VWhluGOdDQed/I" +
       "2NK0ktYWiik2tX4PR3u43bPGYxXPREnIfAouiRU8W9WydVTdrNStXRJDb6Uk" +
       "Ri8UmCYVyrYvtSh7qDMN1l1G83nTXVUHjeqIXTTcCr5Otc5Wm84z0ZXHStOO" +
       "V/3tcCl0AjQAuf1G8WY2ZfU9KZ7w2zThUbPRabFlnFjhDcRUN4jaXazXc96b" +
       "DNgGOmBgQsDQVXPcDWW/1ca2rVSI8Q67IHmit+LMmdCTkzqpbikkhenIqRsu" +
       "OoWFyELcTFEpaTweN1mzUWfkFl+LYV6g01ab46fGUKNJv4+j9bktss5mEyTN" +
       "ptFCSoHQXcZpN5x15yKu1t3eqGcYqSuWa0qD8IdqrFZjSUXLkYYw9hAWQ4yY" +
       "RyzRYZZhoNVIYutpirXU4DG5mqz9ZVWVQRzWXWbd6OvjeRXBQb4fhHVp7rMN" +
       "ISARqQVyWl/TlpRkiJPuDOtSOia1tI6vsho78NLV2h8zrjEIOxLfn417eNrb" +
       "Ou7AbGUjthIqmVhHAfdma71yBh6F1GeYVx0M2t2KVF2V5Qk5WPLJEq6JaxHl" +
       "0MBQFlV8NUZwlK0Qo8l42Zd6QP1dxKVbsYFyJjpOra5eZzZzmBvKQZKOm2mF" +
       "J8LFApzwfiY/+vk/3un7zqLQcHQ/Bw7d+Yu3/Binzt2rR/LmsaPKTPG5AJ25" +
       "0zlZFT4u8B1VVJ+4rqJqJNG+7rnR/pnLjkOMR6/DKM7VnNA9urrNj+kP3OhO" +
       "rziif/Jdzz6njj5V3juouq4i6NbI83/a1hLNPsFnXip58sbliGFxpXlcDfzS" +
       "u/75fv5N5tt/jNuSh87weZbk7wyf/0r39cov70Hnj2qD1122nkZ66nRF8FKg" +
       "RXHg8qfqgg8cLdv9+SrB4DlY59339TcWN66mPb4zrDNF7fM7GzxctoeKWpKU" +
       "HiwuSHgjVnNVLThZNNdPGN4yr4/ZnnRUTn+soJDD7mNRFFhyHGkqYQJtKpEW" +
       "9COtuMEoeHn/yxTYP5w37wZeoASaFGmFiQna0Z04mOjxG9tkV+DPIhTO8p5X" +
       "KtGcqnRH0F3XX+blNxP3Xfd3gd0Vt/LZ5y7fcu9z078q7rOOrqFvpaFb9Ni2" +
       "T5Z/T/Qv+IGmW4XQt+6KwX7x9fEIuvcGFxkRdGHXKZj+tR38r0fQlbPwYHGK" +
       "75NwvxFBl47hAKld5yTIpyLoPADJu7/pv0Rhc1cFz86dcMGDYFOo+a5XUvMR" +
       "ysnrrtxiir9rHLpYvPvDxjXlc88NmHe82PjU7rpNsaXtNqdyCw1d3N38Hbnp" +
       "IzekdkjrQu+JH97x+VsfOwwpd+wYPnaeE7w99NJ3Wx3Hj4rbqO0f3Pt7b/yt" +
       "575Z1Fn/B5dh2+BHIwAA");
}
