package org.apache.batik.bridge;
public class SVGFontElementBridge extends org.apache.batik.bridge.AbstractSVGBridge {
    public SVGFontElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FONT_TAG; }
    public org.apache.batik.bridge.SVGGVTFont createFont(org.apache.batik.bridge.BridgeContext ctx,
                                                         org.w3c.dom.Element fontElement,
                                                         org.w3c.dom.Element textElement,
                                                         float size,
                                                         org.apache.batik.gvt.font.GVTFontFace fontFace) {
        org.w3c.dom.NodeList glyphElements =
          fontElement.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_GLYPH_TAG);
        int numGlyphs =
          glyphElements.
          getLength(
            );
        java.lang.String[] glyphCodes =
          new java.lang.String[numGlyphs];
        java.lang.String[] glyphNames =
          new java.lang.String[numGlyphs];
        java.lang.String[] glyphLangs =
          new java.lang.String[numGlyphs];
        java.lang.String[] glyphOrientations =
          new java.lang.String[numGlyphs];
        java.lang.String[] glyphForms =
          new java.lang.String[numGlyphs];
        org.w3c.dom.Element[] glyphElementArray =
          new org.w3c.dom.Element[numGlyphs];
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            org.w3c.dom.Element glyphElement =
              (org.w3c.dom.Element)
                glyphElements.
                item(
                  i);
            glyphCodes[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_UNICODE_ATTRIBUTE);
            if (glyphCodes[i].
                  length(
                    ) >
                  1) {
                if (org.apache.batik.gvt.text.ArabicTextHandler.
                      arabicChar(
                        glyphCodes[i].
                          charAt(
                            0))) {
                    glyphCodes[i] =
                      new java.lang.StringBuffer(
                        glyphCodes[i]).
                        reverse(
                          ).
                        toString(
                          );
                }
            }
            glyphNames[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_GLYPH_NAME_ATTRIBUTE);
            glyphLangs[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_LANG_ATTRIBUTE);
            glyphOrientations[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_ORIENTATION_ATTRIBUTE);
            glyphForms[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_ARABIC_FORM_ATTRIBUTE);
            glyphElementArray[i] =
              glyphElement;
        }
        org.w3c.dom.NodeList missingGlyphElements =
          fontElement.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_MISSING_GLYPH_TAG);
        org.w3c.dom.Element missingGlyphElement =
          null;
        if (missingGlyphElements.
              getLength(
                ) >
              0) {
            missingGlyphElement =
              (org.w3c.dom.Element)
                missingGlyphElements.
                item(
                  0);
        }
        org.w3c.dom.NodeList hkernElements =
          fontElement.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_HKERN_TAG);
        org.w3c.dom.Element[] hkernElementArray =
          new org.w3c.dom.Element[hkernElements.
                                    getLength(
                                      )];
        for (int i =
               0;
             i <
               hkernElementArray.
                 length;
             i++) {
            org.w3c.dom.Element hkernElement =
              (org.w3c.dom.Element)
                hkernElements.
                item(
                  i);
            hkernElementArray[i] =
              hkernElement;
        }
        org.w3c.dom.NodeList vkernElements =
          fontElement.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_VKERN_TAG);
        org.w3c.dom.Element[] vkernElementArray =
          new org.w3c.dom.Element[vkernElements.
                                    getLength(
                                      )];
        for (int i =
               0;
             i <
               vkernElementArray.
                 length;
             i++) {
            org.w3c.dom.Element vkernElement =
              (org.w3c.dom.Element)
                vkernElements.
                item(
                  i);
            vkernElementArray[i] =
              vkernElement;
        }
        return new org.apache.batik.bridge.SVGGVTFont(
          size,
          fontFace,
          glyphCodes,
          glyphNames,
          glyphLangs,
          glyphOrientations,
          glyphForms,
          ctx,
          glyphElementArray,
          missingGlyphElement,
          hkernElementArray,
          vkernElementArray,
          textElement);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYfWwcRxWfO8eOP+OPJHaaDydxnCDH4bahDVBdKLVd23F6" +
       "tk+xawmH5jK3N3e38d7uZnfWPjsE2ooqLogQhbQNiPgPSNWC2qZCVICglVEl" +
       "2qoFqSWiFNQUCSTCR0QjpPJHgPJmZvd2b+/OURBYur31zJv35r35vd97c89c" +
       "Q9WWiTqJRiN03iBWZFCjcWxaJDWgYsuahLGE/EQV/vuRq2N3hVHNNFqTxdao" +
       "jC0ypBA1ZU2jLYpmUazJxBojJMVWxE1iEXMWU0XXptF6xRrJGaoiK3RUTxEm" +
       "MIXNGGrFlJpK0qZkxFFA0ZYY7ETiO5H6gtPRGGqUdWPeE9/gEx/wzTDJnGfL" +
       "oqgldgzPYsmmiirFFItG8ybqNXR1PqPqNELyNHJM3eeE4GBsX0kIup5v/uDG" +
       "mWwLD8FarGk65e5Zh4ilq7MkFUPN3uigSnLWcfR5VBVDDT5hirpjrlEJjEpg" +
       "1PXWk4LdNxHNzg3o3B3qaqoxZLYhirYXKzGwiXOOmjjfM2iopY7vfDF4u63g" +
       "rfCyxMXHeqVzTxxp+V4Vap5GzYo2wbYjwyYoGJmGgJJckphWXypFUtOoVYPD" +
       "niCmglVlwTnpNkvJaJjacPxuWNigbRCT2/RiBecIvpm2THWz4F6aA8r5rzqt" +
       "4gz42u75KjwcYuPgYL0CGzPTGHDnLFk1o2gpirYGVxR87L4PBGDp6hyhWb1g" +
       "apWGYQC1CYioWMtIEwA9LQOi1ToA0KRoY0WlLNYGlmdwhiQYIgNycTEFUnU8" +
       "EGwJReuDYlwTnNLGwCn5zufa2P7TJ7QDWhiFYM8pIqts/w2wqDOw6BBJE5NA" +
       "HoiFjbtjj+P2FxfDCIHw+oCwkPnB567fs6dz+VUhs6mMzHjyGJFpQr6YXPPm" +
       "5oGeu6rYNmoN3VLY4Rd5zrMs7sxE8wYwTHtBI5uMuJPLh372mQe/S/4SRvUj" +
       "qEbWVTsHOGqV9ZyhqMQcJhoxMSWpEVRHtNQAnx9Bq+E9pmhEjI6n0xahI2iV" +
       "yodqdP4/hCgNKliI6uFd0dK6+25gmuXveQMhtBo+qBE+25D4498UJaSsniMS" +
       "lrGmaLoUN3XmvyUB4yQhtlkpCaifkSzdNgGCkm5mJAw4yBJnImkqqQyRJqaG" +
       "hyA8jBFgZT8fjDCgGf9/E3nm5dq5UAgOYHMw/VXInAO6miJmQj5n9w9efy7x" +
       "uoAWSwcnPhTtAasRYTXCrUaE1Ug5qygU4sbWMevipOGcZiDjgXIbeyYeOHh0" +
       "sasKIGbMrYIgM9GuotIz4NGCy+UJ+VJb08L2K3tfDqNVMdSGZWpjlVWSPjMD" +
       "HCXPOGncmISi5NWGbb7awIqaqcskBdRUqUY4Wmr1WWKycYrW+TS4lYvlqFS5" +
       "bpTdP1o+P/fQ1BduD6NwcTlgJquBydjyOCPxAll3B2mgnN7mU1c/uPT4Sd0j" +
       "hKL64pbFkpXMh64gHILhSci7t+EXEi+e7OZhrwPCphgSDLiwM2ijiG+iLncz" +
       "X2rB4bRu5rDKptwY19Osqc95Ixynrfx9HcCigSXgVvjsdDKSf7PZdoM9OwSu" +
       "Gc4CXvDa8KkJ48Kvf/GnO3i43TLS7Kv/E4RGfdTFlLVxkmr1YDtpEgJy756P" +
       "f+2xa6cOc8yCxI5yBrvZcwAoC44QwvzIq8ffee/KxcthD+cUaredhBYoX3CS" +
       "jaP6FZwEa7u8/QD1qcANDDXd92uATyWt4KRKWGL9s3nn3hf+erpF4ECFERdG" +
       "e26uwBu/rR89+PqRf3RyNSGZlV4vZp6Y4PO1nuY+08TzbB/5h97a8vVX8AWo" +
       "DMDGlrJAOMEiHgPED20f9/92/rwzMPcJ9thp+cFfnF++Fikhn7n8ftPU+y9d" +
       "57st7rH8Zz2KjaiAF3vsyoP6jiA5HcBWFuTuXB77bIu6fAM0ToNGGSjXGjeB" +
       "H/NFyHCkq1f/5qcvtx99swqFh1C9quPUEOZJhuoA3cTKArXmjU/fIw53rhYe" +
       "LdxVVOJ8yQAL8NbyRzeYMygP9sIPO76//6mlKxxlhtCxya/wI+zRW8Ab/6sJ" +
       "ljk/3oo0mGhLpU6Ed1EXHz63lBp/cq/oF9qKq/sgNK/P/upfb0TO/+61MiWl" +
       "jurGR1UyS1SfzTAzWVQLRnmT5vHRu2vO/v5H3Zn+WykDbKzzJkTP/t8KTuyu" +
       "TOvBrbzy8J83Tt6dPXoLjL41EM6gyu+MPvPa8C75bJh3pILMSzrZ4kVRf2DB" +
       "qEmg9daYm2ykicN+RwEAbexgO+HT6wCgtzyrlsFOgasqLV0hqydXmJtij3GK" +
       "GjPQr+kyVsfAGy65AW5sPAFYNx4R3Tif+CR7xAXCo/9ldrGBPoOP31fwsd3N" +
       "iajjY/TWw1NpaSAE1Xwj1a6jOyt1WKKnci5grvRaJj13hxxJ6bmI03yxqXRx" +
       "L8USY8JOWtD3KDkoc7POXeBj8aPyYnf8DyJvbyuzQMitf1r6ytTbx97gCK9l" +
       "KVXAlS+dIPV8FbxFRORD+AvB59/swyLBBtg3XLEGnMZ+W6GzZ9xlop4VruLF" +
       "Dkgn296b+ebVZ4UDwZtPQJgsnvvSh5HT5wQJievhjpIbmn+NuCIKd9hjhu1u" +
       "+0pW+IqhP146+eOnT54KO8gepqzz0DEtHHqo0PGuKw662Om9jzb/5Exb1RCQ" +
       "2wiqtTXluE1GUsUJvtqyk75T8O6TXro7e2YRpyi02y0MZVGWmaWRNIArMjw1" +
       "yTp5qF+EK5FXSNkT7HGEonrZJHB8bJ1roWuFm4JjwkvhxP8ihfPQo5e7hrD6" +
       "uaHk5w5xRZefW2qu7Vi6/21eRgrX6EZAedpWVV+4/aGvMUySVngEGkU7YfCv" +
       "RyjqqOA29Hzihe/+i0J+EXgtKA9Q4d9+uS9DhD05UCVe/CKnKaoCEfb6VcM9" +
       "g55KZ9AHmW1CzYRwiRjlQ6UtAz+Z9Tc7GV+PsKMobfnvUC6ybfFLFNzelg6O" +
       "nbj+8SdFOy6reGGBaWkAPIubQaFEbq+ozdVVc6Dnxprn63a6adYqNuwx8yYf" +
       "VPsg3QwGhY2BXtXqLrSs71zc/9LPF2veAoI4jEIY6PWw71cg8ZMHNLw29CaH" +
       "Y6V5C+0Eb6KjPd+Yv3tP+m+/5d2Yk+ebK8sn5MtPPfDLsxsuQrPdMIKqgUFI" +
       "fhrVK9a989ohIs+a06hJsQbzsEXQomC1iBTWMNRiVhN5XJxwNhVG2WUO8rGU" +
       "6EqvwNC5zhGzX7e1lEMrDd5I0Q9kbpdhG0ZggTfiKwa2YCLB+1WJ2KhhuHWg" +
       "+oLBE3g2SI58kK/+Fn9lj2//B9TpgIujFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
