package org.apache.batik.svggen;
public class SVGLinearGradient extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGLinearGradient(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        java.awt.Paint paint =
          gc.
          getPaint(
            );
        return toSVG(
                 (java.awt.GradientPaint)
                   paint);
    }
    public org.apache.batik.svggen.SVGPaintDescriptor toSVG(java.awt.GradientPaint gradient) {
        org.apache.batik.svggen.SVGPaintDescriptor gradientDesc =
          (org.apache.batik.svggen.SVGPaintDescriptor)
            descMap.
            get(
              gradient);
        org.w3c.dom.Document domFactory =
          generatorContext.
            domFactory;
        if (gradientDesc ==
              null) {
            org.w3c.dom.Element gradientDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_LINEAR_GRADIENT_TAG);
            gradientDef.
              setAttributeNS(
                null,
                SVG_GRADIENT_UNITS_ATTRIBUTE,
                SVG_USER_SPACE_ON_USE_VALUE);
            java.awt.geom.Point2D p1 =
              gradient.
              getPoint1(
                );
            java.awt.geom.Point2D p2 =
              gradient.
              getPoint2(
                );
            gradientDef.
              setAttributeNS(
                null,
                SVG_X1_ATTRIBUTE,
                doubleString(
                  p1.
                    getX(
                      )));
            gradientDef.
              setAttributeNS(
                null,
                SVG_Y1_ATTRIBUTE,
                doubleString(
                  p1.
                    getY(
                      )));
            gradientDef.
              setAttributeNS(
                null,
                SVG_X2_ATTRIBUTE,
                doubleString(
                  p2.
                    getX(
                      )));
            gradientDef.
              setAttributeNS(
                null,
                SVG_Y2_ATTRIBUTE,
                doubleString(
                  p2.
                    getY(
                      )));
            java.lang.String spreadMethod =
              SVG_PAD_VALUE;
            if (gradient.
                  isCyclic(
                    ))
                spreadMethod =
                  SVG_REFLECT_VALUE;
            gradientDef.
              setAttributeNS(
                null,
                SVG_SPREAD_METHOD_ATTRIBUTE,
                spreadMethod);
            org.w3c.dom.Element gradientStop =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_STOP_TAG);
            gradientStop.
              setAttributeNS(
                null,
                SVG_OFFSET_ATTRIBUTE,
                SVG_ZERO_PERCENT_VALUE);
            org.apache.batik.svggen.SVGPaintDescriptor colorDesc =
              org.apache.batik.svggen.SVGColor.
              toSVG(
                gradient.
                  getColor1(
                    ),
                generatorContext);
            gradientStop.
              setAttributeNS(
                null,
                SVG_STOP_COLOR_ATTRIBUTE,
                colorDesc.
                  getPaintValue(
                    ));
            gradientStop.
              setAttributeNS(
                null,
                SVG_STOP_OPACITY_ATTRIBUTE,
                colorDesc.
                  getOpacityValue(
                    ));
            gradientDef.
              appendChild(
                gradientStop);
            gradientStop =
              domFactory.
                createElementNS(
                  SVG_NAMESPACE_URI,
                  SVG_STOP_TAG);
            gradientStop.
              setAttributeNS(
                null,
                SVG_OFFSET_ATTRIBUTE,
                SVG_HUNDRED_PERCENT_VALUE);
            colorDesc =
              org.apache.batik.svggen.SVGColor.
                toSVG(
                  gradient.
                    getColor2(
                      ),
                  generatorContext);
            gradientStop.
              setAttributeNS(
                null,
                SVG_STOP_COLOR_ATTRIBUTE,
                colorDesc.
                  getPaintValue(
                    ));
            gradientStop.
              setAttributeNS(
                null,
                SVG_STOP_OPACITY_ATTRIBUTE,
                colorDesc.
                  getOpacityValue(
                    ));
            gradientDef.
              appendChild(
                gradientStop);
            gradientDef.
              setAttributeNS(
                null,
                SVG_ID_ATTRIBUTE,
                generatorContext.
                  idGenerator.
                  generateID(
                    ID_PREFIX_LINEAR_GRADIENT));
            java.lang.StringBuffer paintAttrBuf =
              new java.lang.StringBuffer(
              URL_PREFIX);
            paintAttrBuf.
              append(
                SIGN_POUND);
            paintAttrBuf.
              append(
                gradientDef.
                  getAttributeNS(
                    null,
                    SVG_ID_ATTRIBUTE));
            paintAttrBuf.
              append(
                URL_SUFFIX);
            gradientDesc =
              new org.apache.batik.svggen.SVGPaintDescriptor(
                paintAttrBuf.
                  toString(
                    ),
                SVG_OPAQUE_VALUE,
                gradientDef);
            descMap.
              put(
                gradient,
                gradientDesc);
            defSet.
              add(
                gradientDef);
        }
        return gradientDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/QdyNNFOOhUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "N3N31rHdWe8m9rb3Rw72d99PToEMP1vare0WM34sl/Jo3l7Nmp/eLlP2+GYA" +
       "BWFenAIOzXRFO58Yj0CI2fLVfeljUKyCNblq2bX9vLmSh1Nm/e62wtuCYNai" +
       "uYhtSNRuGT5v3VLlu92dh8JoDxSLH/7Hj379Vx//NlhTCjq7yvwNlvLIjGyc" +
       "1c8fePG5B1/z7Hc+nCMbSOnxM0/8W16NsLezOGvaWdPZN/X+zFQhLw5oMYyY" +
       "HIxUJbf2tqHMB6YDMHu1VxzCT9/97cUnvvvZbeF3Mm5PEKsfevZXfrz7kWd3" +
       "jpTbj99Q8R7l2ZbcudKv3fNwAD16u1lyDvKfPv/0H/3O0x/canX38eKxBd6N" +
       "PvtX//P13ee/89Wb1C1nbO//sbDRHWc6aNjF9j/0eCaW1vI4mRTichXuFN2Q" +
       "xequPN9grtSU+jjjcwSCsK5khh2Rcce+WSzNU6UgxbVQSJkKU1MKG6RfqQvi" +
       "yhgawwGFIXRjg4zInlMilxhBjRfiWOyFxGgRtkhWwBIK3phtszXuVFtIzS67" +
       "VlyrbvTu2A86rruKOU2V1XqlnPqlqbTsVhfVLtgQWrNJKnTbg9W4hAsO5beG" +
       "PUtiF0WcFurwGKULCuxYmxk+HPsIXuv44bBlSZTTokal0cYIZr7DLBMqodaL" +
       "ATdLfVNPiHm5M2TbCMkudYdjyD4yWhijssfELSas6M5ooDgW4c3NCpkM1nhz" +
       "UuHWi8CYCdP1gm9u5EGvJEhmWq3hYbPWdTGCk8MC7TOGtRzO4VbdsiNmpLJU" +
       "Mhk2B7Og1KaXVYdkEdJkSdKKg5qryHJzU1nV1yQsNkpah67NgsowbmMKYgkK" +
       "ofGMOAFM1mawqFpNH60u/Tah9tGC4ZiDJTHEUpbCi7Y8x8XBZhRHUnVKN6vs" +
       "kpobs36cttux3/GbqB6ZYkv1Wxg7nHaarWF3gejooF2J9JjyOKSUIoEkrOgh" +
       "vdlQ5VolVjilXEXwjuCOvImeas2FQHd7+MLoozbe3xiUZ4WLdEFygTCjWZcg" +
       "J+ulua5wDSTqWQuWWcelcnlEU4jX9kY9t7ZZzQY1gp0Y9HA5UdSxLozq1Xq8" +
       "LHTlEhtYpZIvcYzkz9pEiumxNeknSaW48d0xU3REMkIHjmr1WQ3HxFnJxnS6" +
       "16gtHQ9pYsORNFO7ZjCWNWxODOshLlaKHDbS5yV7MO7xKqKLo4pLsMANLWNl" +
       "2jWCNkWD4FGyOysZLIgO1rSHIqkQccqnst1MK+nUcuwB2W0hm+JAKGi+NCMp" +
       "TWS7xc2A6nUxODRFpLkRY7QCj+jRTMDUEdctqVIFtpWYl8yyBI8jp6Sk+Bwd" +
       "OhLbmjm2Tyl8oexLLZRpiSsvafdTebxaLWzbC0OnTLUNL2x3WxueqrT4JEpx" +
       "RHU0jXcoqcLAA6STcr3lVGFHyz6eIMI0wEfkgLCSHjtiNl2+WxVNYuYmvI6K" +
       "XrPs97oDp+yZTjqi2kUVWZrNcbXQhWNCp7uBSTsxqRSlXrVQqui2oa0GfcZA" +
       "MGwqeuMAYxdwfTL00Kmh0hUMtQPCETt+3QRArFkMZ1IMXi5IVntmVWPJ9CfJ" +
       "gGB6teEUT5odTqC4lNA2SSviLbZmE/VxscqMNuugMxlU7GTVmGt+R4pKqNHS" +
       "O1NpvXBXuleRi8l0PqKHRWca1Dkzshv8qrTokK16J2m2uKbXpJwluqbsISnN" +
       "xYShZmAxexIypSeNtYytcXTBCWxY5Xi+Wx8y04IT6qG3IScrLJoXiqvlUKc6" +
       "a0QmWg06KAtlWi2hoQqzvZ7Peg4aMv04WHUJpogn2CIduvN2I8Cd5WCa9Ep4" +
       "0SOC0nhkozpjkkLENg2hvRpX+pajeNoIJyY1HF0u5gGCxr0lqgXjiqR26FJ9" +
       "Gls90hdxyepxOrbm3VJvVlM7xT5v1Hr1RVTgfSutVCrq0oq9epOaTMlgNreZ" +
       "2oKFVXJG0KFL95EoqRbsablR7NNmg5gS4kwxQp0hCmEXFRzcLnXnK6mo6+15" +
       "eSyuCU+T3bKc8tRoCmN+d2HWEj6qEt1w4rqKhPLL4gK1zM1IqTU7tVU048QE" +
       "cbuE3RJqfj1xVzCSwjDKqWQclf0izgSFZrvTxOShuQ48knWnldk0Flo6Ve8g" +
       "VUldSb1UVHhzrpOWXxqTWG2trnt9Ipj1y3w6juqNRp0OpV5DtTR/nfZYe4Jb" +
       "S81z5IVf5R12tm5J0qrR6DfN5Qzr8W2v3Ym6Ou9PQt1ilujMRSy0ohSQWm2T" +
       "copibLx+p9MUuYKCa1ZRXVctqoE2YE0udIWZWZ8FQQGYEZbIuis0KgbZq29Y" +
       "ZaDxdCNQGiiR1nm8T2IlUpiYTHNsUnygkS2prSxT3PdQptcY+o1Fv11DtJRO" +
       "pmUOtoYGvVngem3TLtTSdpOwufnCo6KekKgrrbEuFeCWFKEC6avIjGmiTtgk" +
       "Q2MjwDWhShRYdO3h5ebcqKE1O1Y02hhOpSLbshl91O+BVGv0MXZgCsN+pdwZ" +
       "sSvYTZwUccvLCC8OO6OA82edkDGZcWs4x/pJHW2SA5Whmw0PDxWsGxUrRs/0" +
       "0pWXYmxpLFXUokoPDEZim0KzvISVgkVWBqHJ6IiUxKK+bsFJKUFXg3Cy4u31" +
       "QE9Jseu1zUCZAJQl18EwQdTxolCXu4W4NvVop9gaLDs8LKMrGHaHJXqqrRDO" +
       "wK1RUtZMRohFqh1h84rg09VQbVU5pd7k4zWsdDXNMvtceV32Z/ywEFf6Hd6C" +
       "pUmzNeLHQous9SZFuAFCh8Jhyq0tuz0JiyvMJt1MEma1mrLFqNz3e74/jdfE" +
       "iJVK9gIVm5Y+se0WMQ3cVsqJY9bgEY5eN2N0sJLwhoxTa4wbtySTCDoWOo6R" +
       "pdgOVybbkzHNwgcSrY1Fri81jApdtMyx1arhnrdQe2U6JYFBfaw91sjAmmBV" +
       "TE8o0ZvVlp1FHV6XJFXrwlrD1lyKWBvNIiE36DKteBSytixfadeiGo6IYlxT" +
       "MVUfTGVvUktZfWqXtbkt6Yhm+kPK6BQrUXe2MpSk1/SnBXKNRkw0GCOesmHY" +
       "ZKaEG8QqScKmHiqWVKabMNKbdamy1l6SNaYiLg2/azmEieDxaI5PDX0s1ljD" +
       "MmcgTib1canHByUT0ashbBvxHDE0l3BUTKqkFj+q8Rze40N7w3dn/XSKre26" +
       "xjY2bImMom5xtiliMwLr9lbddhFLYqw4QTcje00kTLKKoyaDp2xjjnkds4X2" +
       "aQBvjVa/Wy1wU2tRUFadqYVL4WJBCvXIFJjAZZpRLSKaKxwZ+5KzqXp1tuxU" +
       "4GhiTxHM7dLuCtf8SthcDALMpFWUba97irByMFYtwTS+WbbKmisasFvyuKXS" +
       "x5tcsWYPdQzFGyVv4iQoJcqbwB9XVhi1SQcCVuQ1l090qTxfwZXJmFQWbqla" +
       "GnMKLzQUTeP6UzsV4z7DjxmvtvRahDDTPaRXEAeDSUkUeKZoKN5IrvW7wrrv" +
       "E7bUGYmc3VNlkHmoOxqG/JRZw0PdhDmuEtarZt2bqN6qsA4GXRBEnb5JoH0V" +
       "MRGWXIywjc/yPW1RQu0Zu0lxolXe9KLKNNiUEF4oqgVk1bbMRhGZVfA6pc5a" +
       "yVCdjUMxEJgOT02rVDUYGHUWXpv1JkKXa2BYbsGO4HEFss5FVqwNY8wOZRUg" +
       "uUut02ZlgvhMnBYLwyXMj1cLpWlRTcsdYR1ps0JUEjZB1aMUYrivbFiW5Dhj" +
       "BIr+t70tex24/ureyO7KXz4P7hrAi1g2QL2KN5Ht0KNZ88TBIVf+OXfyfPro" +
       "IdfhKQaUvV09eKsrhPzN6lPve/YFhfs0srN3+jOPoIuR5/+Mra5U+4ioHSDp" +
       "qVu/RTL5DcrhqcSX3/cv9w/fbrz7VZzPPnxCz5Mif5d58avtN8kf24FOH5xR" +
       "3HC3c5zp2vGTiUuBGsWBOzx2PvHggWffmHnsIfCt7nm2evMz0ptGwak8CrZr" +
       "f+Jw7RUP6zJviutoVy8pu+1A9I2Da7ZcXnybw7pN1oCX3LORJ4zb+1M8cZvz" +
       "wKYayoHp71+05UG4fKXX4aPT5h3Ogdcyh0GPgy+25zXsJ+K1e/KDk8xL+7cM" +
       "vGi6Wwe9/zYO+uWseeakg566jYNyuTfz0ntfjZcSAAA3XIxkp7z33XDvur0r" +
       "lD/3wuUL974w+uv8buDgPu8iDV3QYts+esB25PmcH6iamVt6cXvc5uc/H4ug" +
       "e29hY3Zalj/kOv/alv65CLpykh44Lf89Svd8BF06pAOitg9HSX4rgk4Dkuzx" +
       "E/6+w99yK4djUhgFohwBX4GYX6lBpAbJqeMYdrACd7/SChyBvcePgVV+J74P" +
       "LPH2Vvy6/PkXKPY9L1c/vb3WkG0xTTMpF2jo/PaG5QCcHr2ltH1Z5zpP/ujO" +
       "L1x8Yh9I79wqfBj8R3R7+OZ3CC3Hj/JT//QP7/39t/72C9/KDwX/D6KbZnas" +
       "IAAA");
}
