package org.apache.batik.css.dom;
public class CSSOMSVGViewCSS extends org.apache.batik.css.dom.CSSOMViewCSS {
    public CSSOMSVGViewCSS(org.apache.batik.css.engine.CSSEngine engine) {
        super(
          engine);
    }
    public org.w3c.dom.css.CSSStyleDeclaration getComputedStyle(org.w3c.dom.Element elt,
                                                                java.lang.String pseudoElt) {
        if (elt instanceof org.apache.batik.css.engine.CSSStylableElement) {
            return new org.apache.batik.css.dom.CSSOMSVGComputedStyle(
              cssEngine,
              (org.apache.batik.css.engine.CSSStylableElement)
                elt,
              pseudoElt);
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Qb8pw59fFfKfEK84fO2/jjzCvQkUAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6GoCVfAcqDSeMEiMtCy8y4EZMXPrDVyZ1R1n2cd7BsEpS1IflrphWPTxwGyH" +
       "w0KpbPJ1MU+pWrjusEvC1LFg0y3EUlHhq4yulkHLtkd4gV3UBwma2IOBMewO" +
       "g55kTFvNyLEnZdvuO5XCamRVRae0ApqYq64Hq3JnlbQlnESl0bQRzB2yT8x0" +
       "pcVjOYcIV3Vc6FWLgccVinguAE1tOBjIDa81FCoMmSvHCZD6m8l82LeFYrlL" +
       "+iUur+RJY1BZ+2apglaCYrFke47SW5nriWugPZidoNUOmAzKNYKqNFfmYFiv" +
       "9li+3kyYCmB6uQUPrS8PE5epEm2EEm2TnDeSuxa0AuBXaM4VDGWsNWKjKVKV" +
       "VQm3Ij/Bur1NYBIFRSxzVp9tThRSVEHf8Uq0SrBSTVQ9f+2A1kIe9Csj0t5Y" +
       "FdVgChXLxnNkX2MrvtDmVmSlGw87VT2X53FrY8yna7ZYyQ/WbonR0BLJkNDQ" +
       "S85gEEe+1YA3GtVC61jVFCTet5KmEdhxPhk5WLGkA9tIQL80oZYLlgLcGlSC" +
       "4bTqRjj041l31uhWSzMGQ5fLhFoPDQFm8u9IU/zrP90t667sQnnwbAAvV+lE" +
       "56e4XWynHk2bJw5KVtnn7MlS89GS1WFlAklvTA/e6jUguy19+rkXX9KYzxR2" +
       "9io6cohcCB33502wBuYRUumt9elb3wz72WPIYaXhy8/9y5XROxfv+SmqrQ+f" +
       "2OdJkr/Xf/mrrSfV39hBTh/UHW54pjmOdO14teGiD8KVb4+O1RwePJDsw6nE" +
       "UPjd3ZPs7s0rnje1glOZFWx1f6JgtpMB7OwXEu5JS29RUc3q4OmTH7CzUmEn" +
       "Q169QbVtkzbwlnp5DsK0UrEKgcaHGxPsk378KOm0oEfxfAZQh9JK66L7GshM" +
       "z/tJF9tjBa8QuXSiaJ9WIB+44UFw+4ilfv6lS+ff/JLwN1nd+uCh6UIPOT9b" +
       "mebREtCR/lnXBzM94/XCtiDkZj/PhcgDt3pKCJHTsM32+/4t9AdD5N6bQUNI" +
       "2B6FfB7K8iRkiJzJfo/CfThELh7ChcjZbecoyAuQOgRJux9x37jKevD+sSfH" +
       "+NRxlz1Q0N0/SUFHvPzxY76Zvebu+9Fq+557XX3lpc7gva+VP7OtyUOLSJKU" +
       "yvkecm77PHDgi4/ekto+rbPtp16/8wsXntiPG3duN3zoIUf29vDNC+ANyw2z" +
       "knXyR2/+g7f/zkvfzupa/wubVPeTZh8AAA==");
}
