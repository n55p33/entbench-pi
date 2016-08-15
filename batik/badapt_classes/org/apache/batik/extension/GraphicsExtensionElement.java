package org.apache.batik.extension;
public abstract class GraphicsExtensionElement extends org.apache.batik.extension.StylableExtensionElement implements org.w3c.dom.svg.SVGTransformable {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.extension.StylableExtensionElement.
                 xmlTraitInformation);
             t.put(null, SVG_TRANSFORM_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_TRANSFORM_LIST));
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             t.put(null, SVG_REQUIRED_EXTENSIONS_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     false,
                     org.apache.batik.util.SVGTypes.
                       TYPE_URI_LIST));
             t.put(null, SVG_REQUIRED_FEATURES_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     false,
                     org.apache.batik.util.SVGTypes.
                       TYPE_URI_LIST));
             t.put(null, SVG_SYSTEM_LANGUAGE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     false,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LANG_LIST));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedTransformList
      transform =
      createLiveAnimatedTransformList(
        null,
        SVG_TRANSFORM_ATTRIBUTE,
        "");
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired =
      createLiveAnimatedBoolean(
        null,
        SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
        false);
    protected GraphicsExtensionElement() { super(
                                             ); }
    protected GraphicsExtensionElement(java.lang.String name,
                                       org.apache.batik.dom.AbstractDocument owner) {
        super(
          name,
          owner);
    }
    public org.w3c.dom.svg.SVGElement getNearestViewportElement() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getNearestViewportElement(
            this);
    }
    public org.w3c.dom.svg.SVGElement getFarthestViewportElement() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getFarthestViewportElement(
            this);
    }
    public org.w3c.dom.svg.SVGRect getBBox() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getBBox(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getCTM() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getCTM(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getScreenCTM() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getScreenCTM(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getTransformToElement(org.w3c.dom.svg.SVGElement element)
          throws org.w3c.dom.svg.SVGException {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getTransformToElement(
            this,
            element);
    }
    public org.w3c.dom.svg.SVGAnimatedTransformList getTransform() {
        return transform;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    public java.lang.String getXMLlang() {
        return org.apache.batik.dom.util.XMLSupport.
          getXMLLang(
            this);
    }
    public void setXMLlang(java.lang.String lang) {
        setAttributeNS(
          XML_NAMESPACE_URI,
          XML_LANG_QNAME,
          lang);
    }
    public java.lang.String getXMLspace() {
        return org.apache.batik.dom.util.XMLSupport.
          getXMLSpace(
            this);
    }
    public void setXMLspace(java.lang.String space) {
        setAttributeNS(
          XML_NAMESPACE_URI,
          XML_SPACE_QNAME,
          space);
    }
    public org.w3c.dom.svg.SVGStringList getRequiredFeatures() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredFeatures(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getRequiredExtensions() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredExtensions(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getSystemLanguage() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getSystemLanguage(
            this);
    }
    public boolean hasExtension(java.lang.String extension) {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          hasExtension(
            this,
            extension);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ae3QU1Rm/u4G8eOQB4Z3wCigIuyK+g5QkJBDdQCQx1qCE" +
       "2dm7ycDszDBzN9lgUbT1kHqOFi0q9ij/iMdHRTytWtuKh1Zb9WAfKmptD9hT" +
       "66mtpZU+bE/V2u+7M7MzO7szdHtMc869O7n3fvfe73e/1308doqMN3TSQBUW" +
       "YSMaNSJtCusSdIMmWmXBMHqgrF+8p0T465b3N1wSJqV9ZPKgYHSKgkHbJSon" +
       "jD5SLykGExSRGhsoTSBFl04Nqg8JTFKVPlInGR0pTZZEiXWqCYoNegU9RmoE" +
       "xnQpnma0w+qAkfoYzCTKZxJt9lY3xchEUdVGnOYzXM1bXTXYMuWMZTBSHdsm" +
       "DAnRNJPkaEwyWFNGJ+doqjwyIKssQjMssk2+wILg8tgFeRAseKLqo4/3DlZz" +
       "CKYIiqIyzp6xiRqqPEQTMVLllLbJNGXsIDeQkhiZ4GrMSGPMHjQKg0ZhUJtb" +
       "pxXMfhJV0qlWlbPD7J5KNREnxMj83E40QRdSVjddfM7QQzmzeOfEwO28LLcm" +
       "l3ks3nVOdN89W6q/VUKq+kiVpHTjdESYBINB+gBQmopT3WhOJGiij9QosNjd" +
       "VJcEWdpprXStIQ0oAkvD8tuwYGFaozof08EK1hF409MiU/Use0kuUNZ/45Oy" +
       "MAC8TnN4NTlsx3JgsFKCielJAeTOIhm3XVISjMz1UmR5bLwCGgBpWYqyQTU7" +
       "1DhFgAJSa4qILCgD0W4QPWUAmo5XQQB1Rmb5dopYa4K4XRig/SiRnnZdZhW0" +
       "quBAIAkjdd5mvCdYpVmeVXKtz6kNq26/XlmvhEkI5pygoozznwBEDR6iTTRJ" +
       "dQp6YBJOXBq7W5h2ZDRMCDSu8zQ223znS6fXLGs4+pLZZnaBNhvj26jI+sWD" +
       "8cmvzmldckkJTqNcUw0JFz+Hc65lXVZNU0YDCzMt2yNWRuzKo5t+fM3uR+kH" +
       "YVLZQUpFVU6nQI5qRDWlSTLV11GF6gKjiQ5SQZVEK6/vIGXwHZMUapZuTCYN" +
       "yjrIOJkXlar8f4AoCV0gRJXwLSlJ1f7WBDbIvzMaIaQaElkI6WJi/l2IGSPJ" +
       "6KCaolFBFBRJUaNduor8G1GwOHHAdjAaB6nfHjXUtA4iGFX1gagAcjBIrQpQ" +
       "GqoYwGN0nS5og5JotNklaB7Q4qK8af+3kTLI85ThUAiWY47XGMigR+tVOUH1" +
       "fnFfuqXt9OP9x0xBQ+Ww0GJkJQweMQeP8MEj2cEjfoOTUIiPORUnYS4/LN52" +
       "MANghycu6b7u8q2jC0pA7rThcYB8GJouyPFHrY6tsA18v3i4dtLO+SdXPB8m" +
       "42KkVhBZWpDRvTTrA2C4xO2Wbk+Mg6dyHMY8l8NAT6erIk2AvfJzHFYv5eoQ" +
       "1bGckamuHmx3hoob9XcmBedPju4fvqn3xnPDJJzrI3DI8WDekLwLLXvWgjd6" +
       "bUOhfqv2vP/R4bt3qY6VyHE6tq/Mo0QeFnilwgtPv7h0nvBU/5FdjRz2CrDi" +
       "TACtAwPZ4B0jxwg12QYdeSkHhpOqnhJkrLIxrmSDujrslHBxreHfU0EsJqNW" +
       "Loa0xVJT/ou10zTMp5vijXLm4YI7jMu6tft/8dPfr+Rw276lyhUUdFPW5LJn" +
       "2Fktt1w1jtj26JRCuxP7u75+16k9m7nMQouFhQZsxLwV7BgsIcB8y0s73n7n" +
       "5MHj4aychxip0HSVgarTRCbLJ1aRSQF8woCLnSmBSZShBxScxqsUEFEpKQlx" +
       "maJufVK1aMVTf7y92hQFGUpsSVp25g6c8pktZPexLf9o4N2ERHTJDmxOM9PO" +
       "T3F6btZ1YQTnkbnptfp7XxTuB48BVtqQdlJueAmHgfB1u4Dzfy7Pz/fUXYTZ" +
       "IsMt/7kq5gqd+sW9xz+c1Pvhc6f5bHNjL/dydwpakylhmC3OQPfTvfZpvWAM" +
       "Qrvzj264tlo++jH02Ac9imCDjY06WMpMjnBYrceX/fIHz0/b+moJCbeTSlkV" +
       "Eu0C1zNSAQJOjUEwshntC2vMxR0utz1QhuQxn1eAAM8tvHRtKY1xsHc+M/3J" +
       "VQ8dOMkFTeNd1OcrUdISrmRhJcL8LMzOyZdLP1LPCoYtY47/z4D4m08bY6uI" +
       "GVvZFYvyPEpCTUWa42CfALe1qphGH8LntS5ASDoxa+FVF2PWaqLX9D8CjQXN" +
       "mlkxmxeWoNfMcUt8/+NYxkdfv+iNh+64e9iMoJb4uwMP3Yx/bZTjN//mn3kC" +
       "yx1BgejOQ98Xfey+Wa2rP+D0jkVG6sZMvqcHr+bQnvdo6u/hBaU/CpOyPlIt" +
       "WvuNXkFOo53rgxjbsDchsCfJqc+Nl83gsCnrceZ4vYFrWK8vcCIM+MbW+D3J" +
       "Y/7rcF1WQbrMEr/LvJIbIvzjGlN4eb4Us+WmIOJnhJFSg+9qPPZ2akDHjEzJ" +
       "pOQeXZBYh8LdVnZ1QHzPzhNfrppr1XRchu1ogmZgS4z21FEsLp99Z5LP7lyl" +
       "vQLSJmuGV/qwngjU2yt9qMENgaopBrJmc5Uf5qFSGkOgvL3rNnY2K1IKo/Ie" +
       "my5m+RYXg7RIBtsgXWNN8WofBlOBDF7tQ83ITAxSdUWQcQPKg+hNdEda0mnC" +
       "Znj5f8dwi6rKVFA8rCoBrGZ8xBEkUQMRkcCdlguWsXOEkv9VEWsvYv96ja1p" +
       "mEI2D/OQh+GVonvq2RVCEUQnV++3v+R744M37zuQ2PjgCtOG1ebu2dqUdOrQ" +
       "m5++Etn/65cLbA0qmKotl+kQlV2Tq8Yhc6xmJ996OyboxOQ73/1u40BLMXE8" +
       "ljWcIVLH/+cCE0v9DbF3Ki/e/IdZPasHtxYRks/1wOnt8pHOx15et1i8M8zP" +
       "GUzbmHc+kUvUlGsRK3XK0rrSk2MXF2YlZRoKRhSSZkmK5tUdl0f3SmEIPzMe" +
       "W1gZ0FmAA74toO5rmO0BPRygbAMVIApivRId1lSdWXtEW4ZnFZBhdxOub6Of" +
       "h2/n5V/OxfFc3oX5lwnAEbNb81HzIw1A5r6AugOY3QOYAGrtgs4G82HDFnc4" +
       "wOwfA2CmYN0sSLst7nYXD4wfaQDzjwTUfROzg4yUATAtLWrGFp7pBYRnE56k" +
       "ZAF6cAwA4pHJbEijFpejxQPkRxoAwjMBdd/D7NvgYgCg1p5OG5+ZBfDpFCAa" +
       "zzgIPTlWCM2HtNdic2/xCPmRBqDwYkDdy5j9kJGJgFC3CNt6BXDCsmcdKJ4f" +
       "KyiWQtpv8bO/eCj8SD3shhwTfwfv9XjhBrZ0zClkejMi1dAF8g7exOxnjNQB" +
       "aNnAokd12SIXej8fA/QasQ6N9AMWBA8Uj54faYCwvBtQ9x5mJ01B6vGG0WcX" +
       "gLRg7OzA9s4YwNaAdZdCOmTxfqh42PxIA6D5S0Dd3zA7BUIHsLWdKThfEACj" +
       "FZE7AP5pDACsxbo5kJ62UHi6eAD9SP1BCoUC6kqw8BNGKgHAL3bGcBOOJesd" +
       "ID4dAyAmYN1ZkI5Y3BwpHgg/Un/ztZ5zPDkAjWrMKgANI4uGEXgG06VLKYlJ" +
       "Q9YNWXRX7Tvb73v/kLnv8R64eBrT0X23fha5fZ+5BzLvHBfmXfu5acx7R45N" +
       "tQnIZ/AXgvRvTMgGFuAvI7Wt1uXXvOztl6bh1m1+0LT4EO2/O7zr+w/v2hO2" +
       "tOxGRsYNqVIiKxShyrHSjnpIL1gr+0LxQuFHGrDmjQF1izGby8gEUzsM2NjT" +
       "XPUIzRsr9VgC6ZjFzrHikfAjPZN6rAiAYyVmywAOIweOUJ0Dx/IxgGMm1i2D" +
       "9IbF0xvFw+FHGsDt6oC6NZhdwsgUEAzbzbRT88mC7W7qC7gb88w6x1WHLh0r" +
       "yCKQTlh8nygeMj/SAFg6A+o2YrbejPpsyLJXvEgRco7dQx1jhQnGzO9ZjL1X" +
       "PCZ+pAF89wXUXYvZVYzU4PZhxGA0FQOXkxYGqAeP3rHakc+FdMpi6lTxePiR" +
       "nsnKDASAImEWh1B4UHDeAORe5uPBXnc6bjCPSz2va6s42tj1W9P/zixAYLar" +
       "ezh6W+9b217hJ3TleCSYPRdzHQc26+Y0zStkHhtM4+CGal3foOllcVf06N4S" +
       "6WRq7hzM4dd+terZvbUl7WEyroOUpxVpR5p2JHLP68qMdNw1KefRDy9wzwhd" +
       "PiOhpZrm7L9D4udyb8XIDL/XGHiHOCPvKZj5fEl8/EBV+fQDV73FD2OzT4wm" +
       "AtbJtCy772lc36WaTpMS52yieWujcXm43jrOK/xchJEKmmNFdppUNzBS7aVi" +
       "ZDz/dbe7CaI9px0jpeaHu8lXGCmBJvh5i2Zb96AXLN1sRMaDci9mGTMSn+2G" +
       "ncfYdWdarSyJ+5UARqP8zZ4tYGnz1V6/ePjA5RuuP33hg+YrBVEWdu7EXiaA" +
       "WJkPJiy5dgeD3t7svkrXL/l48hMVi+xgsMacsGMbZju6S5pB6jUUjVme+3uj" +
       "MXuN//bBVc/9ZLT0NYh7N5OQAE50c/4NYEZL66R+cyxffXoFnT8saFryjZHV" +
       "y5J//hW/obbUbY5/+37x+EPXvX7njIMNYTKhg4yX8FKNX02uHVE2UXFI7yOT" +
       "JJBzmCL0Iglyjm5ORikW0HtzXCw4J2VL8Y0LbDHz4/f8l0GVsjpM9RY1rSQs" +
       "7Z7glJgr4zm7T2uah8ApcUxUSDcNAq4GiGx/rFPT7P1AZY2GSh0yCtjkkMGp" +
       "9/NPzO79DyA73Y3PKwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17Cazs1nne3KddlvWeJGuNdj3ZlsZ5nH04lm2F5KwcrkPO" +
       "DEm3ljncOdyGywyHjhrZQGOhAVyhlVMVdYSiUdDG8Iaidou2LlTEbZzaKOAg" +
       "SdMCtoMgQdM6Qu0CTdu4TXrIuft778rKe+kFzrmcs/F8//+f7/xn4RfeKt0U" +
       "haVy4Dtbw/HjS1oaX7Kd5qV4G2jRJZxoMnIYaSrmyFHEg7QXlCe/cv5PfvyK" +
       "eeFc6WapdI/seX4sx5bvRRMt8p21phKl80epPUdzo7h0gbDltQwlseVAhBXF" +
       "zxGldx2rGpcuEgddgEAXINAFqOgChByVApXerXmJi+U1ZC+OVqW/VtojSjcH" +
       "St69uPTEyUYCOZTd/WaYAgFo4db89wyAKiqnYenxQ+w7zJcB/mwZevXvfOzC" +
       "P76hdF4qnbc8Lu+OAjoRg5dIpTtczV1oYYSoqqZKpbs8TVM5LbRkx8qKfkul" +
       "uyPL8OQ4CbVDIeWJSaCFxTuPJHeHkmMLEyX2w0N4uqU56sGvm3RHNgDW+46w" +
       "7hD283QA8HYLdCzUZUU7qHLj0vLUuPTY6RqHGC+OQQFQ9RZXi03/8FU3ejJI" +
       "KN29050jewbExaHlGaDoTX4C3hKXHrpqo7msA1lZyob2Qlx64HQ5ZpcFSt1W" +
       "CCKvEpfuPV2saAlo6aFTWjqmn7eoD33mE97QO1f0WdUUJ+//raDSo6cqTTRd" +
       "CzVP0XYV73iW+EX5vq+/fK5UAoXvPVV4V+af/uyPfuYDj775zV2Zn7pCGXph" +
       "a0r8gvLG4s7vPIw907kh78atgR9ZufJPIC/Mn9nPeS4NwMi777DFPPPSQeab" +
       "k38rvvR57QfnSrePSjcrvpO4wI7uUnw3sBwtHGieFsqxpo5Kt2meihX5o9It" +
       "4JmwPG2XSut6pMWj0o1OkXSzX/wGItJBE7mIbgHPlqf7B8+BHJvFcxqUSqUL" +
       "IJSeAgEu7f5aeRSXdMj0XQ2SFdmzPB9iQj/HH0GaFy+AbE1oAax+CUV+EgIT" +
       "hPzQgGRgB6a2nwEGjeZFACM0COXAtJSod5CSkwVo5lJub8H/tzelOeYLm709" +
       "oI6HT5OBA8bR0HdULXxBeTVBez/60gvfOnc4OPalFZfq4OWXdi+/VLz80uHL" +
       "L13t5aW9veKd78k7sVM/UN4S0AAgyDue4f4q/vGXn7wB2F2wuRFI/hwoCl2d" +
       "p7Ej4hgV9KgA6y29+drmk7Ofq5wrnTtJuHnHQdLteXUmp8lDOrx4eqBdqd3z" +
       "n/6jP/nyL77oHw25Ewy+zwSX18xH8pOnRRz6iqYCbjxq/tnH5a++8PUXL54r" +
       "3QjoAVBiLAMTBmzz6Ol3nBjRzx2wY47lJgBY90NXdvKsA0q7PTZDf3OUUuj+" +
       "zuL5LiDjO3MTfy8IH9u3+eJ/nntPkMfv2dlKrrRTKAr2/TAX/NLv/vv/Ui/E" +
       "fUDU549NfZwWP3eMHPLGzhc0cNeRDfChpoFy332N+duffevTHy0MAJR46kov" +
       "vJjHGCAFoEIg5r/+zdV//P733vitc4dGsxeXbgtCPwbjRlPTQ5x5VundZ+AE" +
       "L3zvUZcAvzighdxwLk4911ct3ZIXjpYb6v85/3T1q3/8mQs7U3BAyoElfeDt" +
       "GzhKfxAtvfStj/3PR4tm9pR8fjsS21GxHWnec9QyEobyNu9H+snffOTv/rr8" +
       "S4B+AeVFVqYVLFYqxFAq9AYV+J8t4kun8qp59Fh03P5PDrFjfsgLyiu/9cN3" +
       "z374r35U9PakI3Nc3aQcPLezsDx6PAXN3396sA/lyATlGm9Sf+WC8+aPQYsS" +
       "aFEBhBbRIaCd9IRx7Je+6Zb/9K9/7b6Pf+eG0rl+6XbHl9W+XIyz0m3AwLXI" +
       "BIyVBs//zE65m1sP6DwtXQa+SHjo8hGg71uGfuURkMdP5NHTlxvV1aqeEv+5" +
       "fVrLf98LXMQCZe5lXNp5GQcZT1/GrarvXkIWgFwA6K6vJDmbFv36yBka7uZR" +
       "p8iq5dEHd9CbP5GUdmUfKH7dDNT4zNWJuJ97a0dc9sCf0s7iU7//vy4zlYKC" +
       "r+CknKovQV/43EPYR35Q1D/iwrz2o+nlExbwbI/q1j7v/o9zT978b86VbpFK" +
       "F5R9t3kmO0nOMBJwFaMDXxq41ifyT7p9Ox/nuUOuf/g0Dx977WkWPpoowXNe" +
       "On++/RTx3ptL+UMgfHjfdj582uz2SsUDtbO8Ir6YR+/bWVH++P4Y6KZwzveZ" +
       "7s/B3x4If5aHvME8YefF3I3tu1KPH/pSAZjH70ldhw9lKx55xeRxqClgh++/" +
       "zA6LIdn1k4WzHXmqlmoqn7Pa0QgpDI1+O0MbnRx9YxAm+2JgryIG6cpi2CvE" +
       "UMiWA8wPBogX5TgOIFzupuRDKVqDITcb0CTiWW4uCf6gHrFP58fQfPQdoumB" +
       "IO6jmV8FjfKToHkw96hCT3by1VLh8U20VWKFmnqA7qd/MnSo7zua7J3Cpb4t" +
       "rqIf6R6YUm+qXWpfquS/nSv3/AZgiQEwC0vJ0yaghm6Bnh9Aud92lIsHBjgD" +
       "a0dgZRdtp51nP3+qX9xP3C9AS3cecSjhg3XaL/zBK9/+m099H3AHXrppnY9r" +
       "QBnHiJZK8qXrz3/hs4+869Xf+4XCbQBin7309H8rFgLJVdDlj4XiJnm0OoD1" +
       "UA6LK3RDyFFMFtO8pubIzqZMJrRc4BCt99dl0It3f3/5uT/64m7NdZofTxXW" +
       "Xn71b/z5pc+8eu7YSvepyxabx+vsVrtFp9+9L+Gw9MRZbylq9P/zl1/8F//o" +
       "xU/venX3yXVbz0vcL/7O//32pdd+7zeusDy40QHa+AsrNr778WEjGiEHf0RV" +
       "1urstDpxoaQxgDWaRRtSfYNZxijZjstGk13iaFdlMTatrrBeTXXbW6UbZV00" +
       "ozqOMV3w1eVwRfetyqpj2ZBFqsMJv43ncTI2q9KiM0f0sRvE3Y7Jt1puHEjT" +
       "8qIHzWpJuU22yYxuR5k6jEkFbnXotlfX17rWrmtQtV6BVX9FUnWeY9HpXORI" +
       "meLwGEsiTh2R7twVUHK4MsJ+GQ4qfKPVXNSp6obDV7OOxIwNcciNjeVwgXO+" +
       "Z3ebHLFdDnopNxmYkc9zaN+pNKiVAeN8fzxjnJE3mFQCXpJ6ljBfYaJPaca0" +
       "M3H9XuqxgefKlU15hSx1X8wwfiyleNxxxHqqmL2pOht4tJgJZHUh8IJIJnNS" +
       "4lFuqEZuF/EmFM4s5d5mO+9TA7wMENmb7WgcRaxNRtGyVt6MCAOOjb42QSJt" +
       "TKz8BlTvOlKGjcWRtRpts6CVWpPViumxPDkjHIdY4NRAiEZdjV2altQYhCQ3" +
       "YMihzY6NimRO8XgRpAKpm/issnLmzoLptvHmmJr0vJS04XqvUWEnKjezVVUn" +
       "2yybuZlG670NXYMJQnGd+jKqezNapeDOvLWCZtPxqry0ZsGQt9UeJ6IjCi0b" +
       "KOv6AV+fmzQ+sCy7w/oRZaszXOnNwcwXClw8Yis+slx34TjZiIO+7Ge+XoF7" +
       "46rZb1Q6pDWFppFWWSZTSoIaTXpLIhjMe1SD4p0oreNG1B9jwHfBEY2nR6Zb" +
       "F2Yjziaz6tSdNBfEBhsYaDAXV1uWn7arXbNvIDgnN1YjAjO6lXmDZeZTxPWb" +
       "AsuiwLQXTdUPRLkxbggTy4A4a+J5kiqZ88oqQZERsgTSaLprTBWDmavNhHGc" +
       "tZbUqtaCBMddm73lqBlsDd/PMm+D9rqTlsXzE1xlg5aI4rSArtrzplmTuhMS" +
       "63IJnLG1Wj3zuJYuEIOoUQ4ISfJklDLXdq1lj8rRvAsr7jpzHVVZLnF+RSnT" +
       "TQXvZ+Wh0mo6wkyiphWxi2VkXNtS80mSjf1mXNbJejIpL4fijJDYadCfTVse" +
       "O2quJt25w/HErFod9FvG2LbYJsdKs964Ba1HA2EzlMipHEgJj4nU1g5HNL4U" +
       "HDmE9QbiY7OKMcGFDcE5eFVvz9HuYrTOSHkks3LPWY5ac9yCnNpowDF4a4zJ" +
       "vtNH++gEn8qUmvghPKgONvRwiKg2IqMtTx/awjRGGtagL1QN2UAUGx2FbMAO" +
       "Vr64GVAVj2v6RhP3Y2rpyGibbazGsKyX60ueGMFN3pwi1lxstIUBaRmTcjyj" +
       "p8Oq7vX1ZCXEHZrppJUUZcvzTWWAL3F2o5GsxsBkz64pPVv3aX46shh6MvVE" +
       "rgERVLNGIpRhbpWktWgn8KpmY5UAaYe8qYgoPMD9ZMv0h6HYiiOkCq/rVkON" +
       "CbrMqQKDwm6jNl7OTFSaB93JmudDpIY1Uro2XyzLpNFSt0NShB2YQviWFo6W" +
       "NWSt49mwL66bms9WFwNlKbvJ0E3rpu8vOoLioprK2ElDX6+8euoxXRzPwlG9" +
       "O4LnXW1JbAhCWM8NW20tprSpr9a1NQNNGou4vhJbs+2w14pXEOlXWK3vWc7G" +
       "iJl126x4a3QKNfuqPclqWNi1eASLkQ0jNdCKnW6Mao0VVY1bDs2AXnkmvgyJ" +
       "URq6XDexw8gZommoDfVppRfhK2pO+HIlneE85CfVSsaTQXNt2QLhNsRR2yaT" +
       "VqzHEKwyeliebGrtlrM1p1O1z8ybBO7V+ss4rm6qdgxMHJ9gScq0k3azXG0t" +
       "O27bI1k/6ZusFKXEZtZGjWikoPC2ErXrXttrAvZqyFvFTK2gMuRmhhzyE2xB" +
       "4FV5wrF9eONjhMe5KCdxJppySrqKpr1+LxizTurKeKLPxlWZnPF6e9upmWx/" +
       "MA0ibhbUmkZLgYNlLDFaSugdv0HVepMhj3fdlCY7DM3X+61FLFVFlveWCy+I" +
       "9aAtpHyCNmB0Fq9Y1cETDXGHho5Wk0Y307dtJoP0qSDy0igiY6i9XDWNlQrG" +
       "cyfNykqVWZtKS28uhpRNQOpW3QTycuuYLlanWUbn17oUrOcIyYbrDEipETt+" +
       "uWwPKzVE6Vgu1rXFSmtOBqTtoSJwewRIHw2zCrQouz6OLTSec5azXlLBqhnF" +
       "ISxO29PeJjK9GKutyXRSSeKsypoJm3pVDUFIOF4PJ/FYrKbRUCmTUB2fsbBK" +
       "k8s+r1FqlVbCqTriQndi4goBE2Aq3koqwVQJBvPFGIxBKGt0G24FXoitZDSY" +
       "rSVg2lumF2D8dC43apiOEFp1FZiDIUx4MddEuK6fyuX+rF9j5vKKEDpdGLNZ" +
       "gXKdZeqm2tyndFKZxjBUpsR0qerrskWZ5VZD61ikjy8ayYZk6mIKLSTepiDI" +
       "9epLbJtWUUOzabYDC7q2Lc/lWsiUuxV7ORu0Iolcr5RhWF6w3lr1WwlkovIU" +
       "wgJ6C+b0eL5OKGHZp/1mPTRSexF1FTPCdHyllCkHrhsR5gExS4212A/nY3it" +
       "YCOyTC7m5W4dF6F2qPSrc3YRkr0QItb4KCdGe+BQDW3RmEbluQuIFAypPmeU" +
       "OyuGkWrysju0exke0KwmSKhowoQ686QqO8yYzKT0EEyNVWGimEnVN1zJ4BpZ" +
       "rdrvRUTQ6UhNgmk7W2fNEhzuJoMZtNp4hj2tbePOiuxRhuwHaIi7SnOqN1d9" +
       "brCkjTVRDylPrI2ro7EPjTR323TLE1Ew2pMRGkeGMKcoeO7rqEOj3X47ZuH6" +
       "iEdSTp3OWYUFTlLZpNSeKldcD5M8u6nD6sZqheNZH4FDzEfDgQSnaG85ZcnJ" +
       "UsFUx0jmkUD3luvOrDeP1uK607LlauD2RrUuRLNmeTDzvfWqNplhvSnrzcrl" +
       "+ro8aTcaZL2dJWyNsQ0spgdVbZHU1NVUpUPWbZbLvdiDWk2FWCCVlTv2Y6e8" +
       "ZJ1ZjV/BIhhPqYt3Oi16u/BTmm3XITAUKyhBCj3YsefKaEYMobKC9SrrTnfR" +
       "r48tSINGqsTI0TBOxckygqob2ovhYEin1aYWVy2YhDNmMM0WLhgXy+l66gyi" +
       "ybgujCthyC1rpNCviY408ccTk+OkpTtuxlPVqeh1DgBlMlKbVw2p0ncRpN2I" +
       "fboZunQFZSZbY4GQsxESWOvJSK06nDoX4t68IXl9CTXVlE4WLVo3a5DXnEF0" +
       "qveVui80nY2H9BbUAq4Os9GmijTDFpIYtFhnaREZhLERAae8Nuz2PaWxoTc6" +
       "mINckapEHBHFbU8Uuo2NLrPdzN7wU31CZ0ZjO0V4JCbm4aAftANUnHi9Zmsp" +
       "If2WgmyQRjDEFz3L7geanbLMcpL6yMYmUVWFum1qbYgGZlSDJj1oliVU7wZ9" +
       "DJGzzBgxvDPHyNowplRLqUEpxrgTdNXdiMuuum3anSU+wI0+VseouIUKXSxy" +
       "FXWMN/Tx1pqzcbCGFzSkYTbMdeuRaW54faOvO4JtoqFUyTBnqdmkVVWRPmy0" +
       "tZROPZtiUZnyEH+pVmvcSNBsWEcgVo7YFtVByDmKwFO72dBlEdus0ZjtpE0X" +
       "r1TR1nowqMwVwSAmRpvOkE7UEDeUjKiSitEun+ors1Fj0hHSAouCSletZ0gb" +
       "nY6GETFXx7yp9xDM7ku9NsI0gy6CRenCby7xVm06tFoa0u1wTBXF/CnWWq42" +
       "MEoNxsYQIepgskdpGtciddRtqMgWATqqSsBrFOvoJhgaBjT1oCyWmhnTXSL2" +
       "PCTHBkKNGsmgJxiDSmtGjEUHZzsiNRcmQptfL9r1NbQkvDU8AfyIhnxFqNV1" +
       "U27qUrmJZsR6iOquoCdNWUnbk0aTillvJEGIYKyBq0Iag36CrEfteVxNBGFN" +
       "Z7HTWphVt1quEHyjR9cgup2F5Q20rpl0LabTwSQSqdVsZI1TztyGQ872ghFR" +
       "NUJQIWWT/nAQdl2b7VetbLDYwkZvmkVkjbJ5gZmOskkUdmYG1pLsfhYOraWO" +
       "2IxEtULEQsTtzN1uEHq00egpXumm0Cg1BqRbtWrdzmjRr6Tr/qYM2o+6ccvH" +
       "WpRkqpvImPaQbJEtJjwMu1h73l5hbWMBw5tWWp0PCbMSbrExyzsm7G0NjbQh" +
       "DukbLaTs18RwodlMEG0JXFj3jInit1WwcrVN1htkdEeyiarAYFI5AKbW2Qhg" +
       "Ll9LMzGbNhjJTAdIpc/SwjIVBytEY+rhUF4q5b5KBlbL4VONAeuGyBt3EQ4Z" +
       "ub25WUUb02FXQ+iJ1kwYVPCU1sLGGC6rreVW1KjFdnXeYaDMShGRkEMtM1vz" +
       "cmdRq7ZNvM47GsaJzETNhqxSa5XFSsbFwFGLyUYZG8hOHbizjqPM9EqLanCt" +
       "+WTVNjOyoarlWAul9WLqtOe9bejT0yCdBZNmUMOHBNOCV6RKbapjTZ90t51N" +
       "tjFVxqLNQArdNtHpNhJ1u4CFUZeAhMHQGtIYsx5LgPt7Dgz10FlZZ7uzdr3f" +
       "rdEZ39i4SLwAi+5tu11zlHprLvMByTVrW0ubJ7YiuI26HdJjCKyE8d7Ydak+" +
       "WP5NqQzl2vLMkroZpC60NiaPOkFasQNNHiawIwwwF8XXZtOqSYtOCxEIqhpN" +
       "SLmrWB13wJOcV64NPEUX1bkqh9wWLzenyGTFwJnUiMWBl1VnLUhjbKQ5SRKm" +
       "XjeNshiiYEZSk3ZPsGRkji8Z3No2VUPr1uN2tF6GAgE5DdgkZ1Y5NSJSVqIB" +
       "uZDspMU1A7RlT6c2WPeV64lNCglwPRboTIE6EsFXKNFsU02aRXrNigI1KLEn" +
       "Ea3WpKxsU10X/L7Hw5HcD7e2NJxtmzgEmXPIXyymC7EJlevttNxjhLXQ9uwR" +
       "SYn82AT8LMD9MSVUaslw1qtNhf6ovaV5HEczFyMqI8PZ2m6TnljLeWUYZwK2" +
       "aeC1GQGLFWLRHWYNSIedymAW2QHZmYjVkGOjttQ2HNwIG5nb5muJbMJIoEzT" +
       "KddVKGTVGFiDFAr7DN9mqogk1gacWdlisb1ckoOgA1FMRrc73S3Srot1ZrxB" +
       "kHyr6Off2W7dXcUm5OEVkL/A9mN6xl58EJdulfePaI7OHYu/86X9uwQH/08f" +
       "Ee2OWfYOtnUfz7d1N3Xl+G7u4Q51vt+e7989crX7IcXe3RufevV1lf6V6rn9" +
       "s6BP5pvjfvDTjrbWnGPvzE92n736PiVZXI85Ol/59U/914f4j5gffwfH64+d" +
       "6ufpJn+V/MJvDN6r/K1zpRsOT1suu7hzstJzJ89Ybg+1OAk9/sRJyyOHKrgv" +
       "lzgEQrCvguD0pvyRBVx5Rz7YWdAZR21//4y8f5BHfy8uPWhoMaUBho3imaVt" +
       "Aj+M9+9FHOj9oSvo/XiRwj4/905O8YqE106KolIU3f2l118UXzoj7yt59KsA" +
       "KBBFXw5j83JZ5CXeOEL7+WtAe0+e+BAIL+2jfen6o/3nZ+T9yzz6aly6BaBF" +
       "UT89UPP9V1DzJL/nc4j6a9eAujhY/CkQ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Xt5H/fL1R/3NM/L+XR79Wly6GaDGePIA9INXAE3KcWilR7C/ca2wnwDhlX3Y" +
       "r1x/2L9zRt7v5tF34tIdADanhJrmAfB52reP8P3mteJ7FoTX9vG9dn3w7R0V" +
       "eKMo8PtXLnCgx4evxFGpogX5NFA08Ad59N24dC+QxOGsxfvHxvcxkXzvGkRy" +
       "MU/M2eyX90Xyy9df5T88I++/59EPdirnTx88v/8KcrriafORLP74GmTxaJ74" +
       "QRC+uC+LL15/WfzZ1fP2ilf9b2AeQBa9tzu2fvIM2eyfVR9J5U+vQSp354kP" +
       "g/C1fal87bpLZe+OM/LyW1B7t8Sl24FUBJLIT6DzYs8fotu79RrQvStPfB8I" +
       "X99H9/XrTgnPFzAeOAPiQ3l0D4AYHUIsyv1s0fKuyy/FpRvXvqUewX7PtSr1" +
       "ERC+sQ/7G9dfqe87I++ZPHoyLr1rp9QokBXtlFafulatPgPCt/bhfesvSav1" +
       "MzA28+gSwBidwLj38BFG6BowPpgnfgCE397H+NvXX4XPn5GXrx73PhiX7gEq" +
       "PCCnvrb7XuGApB65AkntrumdYO29565VDnn+d/fl8N3rLwfyjDw6j4a7qfpA" +
       "DoeXtvMae9gR0NG1As29lz/cB/qH1x+oeEbeR/OIj0t35d7ZNoo1lwBElciG" +
       "dgrk9FrXG4+B8NY+yLf+kkaudgbSfILZ+zhwSkw5OqHK04x8y+LUTLsnv6P7" +
       "oXHpgavd889vLD9w2UdGuw9jlC+9fv7W+1+f/ofiqvvhxyu3EaVb9cRxjl+d" +
       "PPZ8cxBqulVI57bdRcpCVHur/UXzlT9EiEu3aSesOdjViuPShdO14tJNxf/j" +
       "5TZgWjsqB5Y0u4fjRbK4dAMokj9+IjigjrO+jeDirZNv4ZyWWbrzsB84blqF" +
       "/3P322nlsMrxK/P5Tk7xNdjBrkuy+x7sBeXLr+PUJ37U+pXdlX3FkbMsb+VW" +
       "onTL7uuBotF85+aJq7Z20NbNw2d+fOdXbnv6YJfpzl2Hj8z8WN8eu/Ll+J4b" +
       "xMV19uyf3f9PPvQPX/9ecSfv/wEDmyQ1pjcAAA==");
}
