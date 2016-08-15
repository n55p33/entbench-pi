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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3s8/Mbv3P0xori/PKwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "MlPZUvAVnJRT9WXoC5+7gH34B9v6R1xY1H40u3zCAp7tUd3a573/ce7Jm//t" +
       "udItcukudd9tnipuWjCMDFzF+MCXBq71ifyTbt/Ox3n2kOsfPs3Dx157moWP" +
       "JkrwXJQunm8/Rbz3FVL+IAgf2redD502u73S9oHeWd42vlhE791ZUfH4vgTo" +
       "Zuuc7zPdX4C/PRD+vAhFg0XCzou5B9t3pR4/9KVCMI/fm3muECl2gvvbyeNQ" +
       "U8AO33eZHW6HZDdI5+4G9zU90zWhYLWjEbI1NOatDA0/OfpGIIz3xcBdRQzy" +
       "lcWwtxXDVrY8YH4wQPy4wHEA4XI3pRhK8QoMuemAoRDf9gpJCAf1yH06P4bm" +
       "o28TTQ8EaR/N7Cpo1J8EzUOFRxX5iluslrYe31hfpnakawfofvonQ4cGgasr" +
       "/ilc2lvi2vYj2wNT6k21S+1LleK3e+We3wAsMQRmYatF2hjUMGzQ8wMoDziu" +
       "evHAAKdg7Qis7KLjtovs5071i/+J+wVo6c4jDiUDsE77+T98+dt/56nvA+4g" +
       "SjetinENKOMY0dJpsXT9uS989pF3vPL7P791G4DYp3/zxxc+UrSaXgVd8bhV" +
       "3LiIlgewLhSw+K1uSCVOqO00r2sFsrMpk41sDzhEq/11GfTCPd9ffO6Pv7hb" +
       "c53mx1OF9Zde+dt/cekzr5w7ttJ96rLF5vE6u9XuttPv3JdwVHrirLdsa/T/" +
       "y5df+Jf/+IVP73p1z8l1W89PvS/+7v/99qVXf/83r7A8uNEF2vhLKza55/Fh" +
       "I8aRgz+yquh1blIde1DaGMA6w6ENub7GbBNPN6Oy2eQWBNrVOIzLqkusV9O8" +
       "9kbtxnkXzemOa07mQnUxXDJ9u7Ls2A5kU9pwLGySWZKOrKo878wQY+SFSbdj" +
       "Ca2Wl4TypDzvQdNaWm5TbSpn2nGuDRNKhVsdpu3XjZWht+s6VK1XYC1YUnRd" +
       "4Dl0MpN4SqF5IsHSmNdwypt5IkoNl2bUL8NhRWi0mvM6XV3zxHLakdmRKQ35" +
       "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" +
       "mMOJtOcuMi/TZwFtUOokgaEyLWULzViVbdoqtxp6x6YCYt5I1xRblzJoLgsO" +
       "DUGeX19gm6yKmrrDcB1YNPRNeabUIrbcrTiL6aAVy9RqqQ6j8pzzV1rQSiEL" +
       "VSYQFjIbMKcns1VKi4s+EzTrkZk587irWjFmEEu1TLtw3YwxH4hZbqykfjQb" +
       "wSsVw6kyNZ+Vu3VCgtqR2q/OuHlE9SKIXBF4QYzOwKUb+rwxicszDxApGFJ9" +
       "3ix3liwr15RFd+j0ciJkOF2UUcmCSW3qy1VumLO5RRsRmBqr4li10mpgerLJ" +
       "N/Jatd+LybDTkZsk23Y37oojecJLB1NoufZNZ1LbJJ0l1aNNJQjRiPDU5sRo" +
       "Lvv8YMGYK7Ie0b5UG1XxUQDhurdpeuWxJJrtMY4msSnOaBqeBQbqMmi33044" +
       "uI4LSMZrkxmncsBJKlu01tOUiudjsu80DVhb261oNO0jcIQFaDSQ4QztLSYc" +
       "NV6omOaa6SwWmd5i1Zn2ZvFKWnVajlINvR5e60IMZ5UH08BfLWvjKdabcP60" +
       "XK6vyuN2o0HV23nK1VjHxBJmUNXnaU1bTjQm4rxmudxLfKjVVMk5Ull6oyBx" +
       "ywvOndaEJSyB8ZR5RKfTYjbzIGO4dh0CQ7GCkpTYg11npuJTcgiVVaxXWXW6" +
       "8359ZEM6hGsyq8TDJJPGixiqrhk/gcMhk1WbelK1YQrO2cEkn3tgXCwmq4k7" +
       "iMejujiqRBG/qFFivya58jgYjS2elxfeqJlMNLdi1HkAlM0pfVY15UrfQ5B2" +
       "IwmYZuQxFZQdb8w5Qk1xJLRXY1yrurw2E5PerCH7fRm1tIxJ5y3GsGqQ35xC" +
       "TGb01XogNt21j/Tm9ByuDnN8XUWaUQtJTUaqc4yEDKLEjIFTXht2+77aWDNr" +
       "A8xBnkRXYp6Mk7Yvid3G2lC4bu6shYkxZnKzsZkgApKQs2jQD9shKo39XrO1" +
       "kJF+S0XWSCMcEvOe7fRD3ck4djHOAmTtUKimQd02vTIlEzOrYZMZNMsyanTD" +
       "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" +
       "O1DzA1dQ87i453OI+mvXgHp7sPhTILy0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("j/ql64/6m2fk/fsi+vWkdDNAjQnUAeiHrgCaUpLIzo5gf+NaYT8Bwsv7sF++" +
       "/rB/94y83yui7ySlOwBsXo103Qfgi7RvH+H7rWvF9wwIr+7je/X64Ns7KvD6" +
       "tsAfXLnAgR4fvhJHZaoeFtPAtoE/LKLvJqX7gCQOZy0hODa+j4nke9cgkotF" +
       "YsFmv7Ivkl+5/ir/4Rl5/72IfrBTuXD64Pl9V5DTFU+bj2TxJ9cgi0eLxA+A" +
       "8MV9WXzx+sviz6+et7d91f8G5gFk0XurY+snz5DN/ln1kVT+7Bqkck+R+DAI" +
       "X9uXyteuu1T27jgjr7gFtXdLUrodSEWkyOIEuij23CG6vVuvAd07isT3gvD1" +
       "fXRfv+6U8NwWxoNnQLxQRPcCiPEhxG25n9m2vOvyi0npxlVga0ew33WtSn0E" +
       "hG/sw/7G9Vfqe8/Ie7qInkxK79gpNQ4VVT+l1aeuVatPg/CtfXjf+ivSav0M" +
       "jM0iugQwxicw7j18hBG6BowPFYnvB+F39jH+zvVX4XNn5BWrx70PJKV7gQoP" +
       "yKmv775XOCCpR65AUrtreidYe+/Za5VDkf/dfTl89/rLgTojjymi4W6qPpDD" +
       "4aXtosYedgQUv1aghffyR/tA/+j6A5XOyPtoEQlJ6e7CO9vEie6RgKhSxdRP" +
       "gZxc63rjMRDe3Af55l/RyNXPQFpMMHsfB06JpcQnVHmakW+Zn5pp95S3dT80" +
       "KT14tXv+xY3lBy/7yGj3YYz6pdfO3/rAa5P/uL3qfvjxym1k6VYjdd3jVyeP" +
       "Pd8cRrphb6Vz2+4i5VZUe8v9RfOVP0RISrfpJ6w53NVKktJdp2slpZu2/4+X" +
       "W4Np7agcWNLsHo4XyZPSDaBI8fiJ8IA6zvo2gk82brGFc1pm2c7DfvC4aW39" +
       "n3veSiuHVY5fmS92crZfgx3suqS778GeV7/8GkF/4ketX91d2VddJc+LVm4l" +
       "S7fsvh7YNlrs3Dxx1dYO2rp5+PSP7/zKbe8+2GW6c9fhIzM/1rfHrnw5vueF" +
       "yfY6e/7PH/inH/xHr31veyfv/wEpPyV5pjcAAA==");
}
