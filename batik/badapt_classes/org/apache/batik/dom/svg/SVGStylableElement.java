package org.apache.batik.dom.svg;
public abstract class SVGStylableElement extends org.apache.batik.dom.svg.SVGOMElement implements org.apache.batik.css.engine.CSSStylableElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_CLASS_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             xmlTraitInformation = t; }
    protected org.apache.batik.css.engine.StyleMap computedStyleMap;
    protected org.apache.batik.dom.svg.SVGStylableElement.OverrideStyleDeclaration
      overrideStyleDeclaration;
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      className;
    protected org.apache.batik.dom.svg.SVGStylableElement.StyleDeclaration
      style;
    protected SVGStylableElement() { super(); }
    protected SVGStylableElement(java.lang.String prefix,
                                 org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() { className =
                                                createLiveAnimatedString(
                                                  null,
                                                  SVG_CLASS_ATTRIBUTE);
    }
    public org.w3c.dom.css.CSSStyleDeclaration getOverrideStyle() {
        if (overrideStyleDeclaration ==
              null) {
            org.apache.batik.css.engine.CSSEngine eng =
              ((org.apache.batik.dom.svg.SVGOMDocument)
                 getOwnerDocument(
                   )).
              getCSSEngine(
                );
            overrideStyleDeclaration =
              new org.apache.batik.dom.svg.SVGStylableElement.OverrideStyleDeclaration(
                eng);
        }
        return overrideStyleDeclaration;
    }
    public org.apache.batik.css.engine.StyleMap getComputedStyleMap(java.lang.String pseudoElement) {
        return computedStyleMap;
    }
    public void setComputedStyleMap(java.lang.String pseudoElement,
                                    org.apache.batik.css.engine.StyleMap sm) {
        computedStyleMap =
          sm;
    }
    public java.lang.String getXMLId() { return getAttributeNS(
                                                  null,
                                                  "id");
    }
    public java.lang.String getCSSClass() {
        return getAttributeNS(
                 null,
                 "class");
    }
    public org.apache.batik.util.ParsedURL getCSSBase() {
        if (getXblBoundElement(
              ) !=
              null) {
            return null;
        }
        java.lang.String bu =
          getBaseURI(
            );
        return bu ==
          null
          ? null
          : new org.apache.batik.util.ParsedURL(
          bu);
    }
    public boolean isPseudoInstanceOf(java.lang.String pseudoClass) {
        if (pseudoClass.
              equals(
                "first-child")) {
            org.w3c.dom.Node n =
              getPreviousSibling(
                );
            while (n !=
                     null &&
                     n.
                     getNodeType(
                       ) !=
                     ELEMENT_NODE) {
                n =
                  n.
                    getPreviousSibling(
                      );
            }
            return n ==
              null;
        }
        return false;
    }
    public org.apache.batik.css.engine.StyleDeclarationProvider getOverrideStyleDeclarationProvider() {
        return (org.apache.batik.css.engine.StyleDeclarationProvider)
                 getOverrideStyle(
                   );
    }
    public void updatePropertyValue(java.lang.String pn,
                                    org.apache.batik.anim.values.AnimatableValue val) {
        org.w3c.dom.css.CSSStyleDeclaration over =
          getOverrideStyle(
            );
        if (val ==
              null) {
            over.
              removeProperty(
                pn);
        }
        else {
            over.
              setProperty(
                pn,
                val.
                  getCssText(
                    ),
                "");
        }
    }
    public boolean useLinearRGBColorInterpolation() {
        org.apache.batik.css.engine.CSSEngine eng =
          ((org.apache.batik.dom.svg.SVGOMDocument)
             getOwnerDocument(
               )).
          getCSSEngine(
            );
        org.apache.batik.css.engine.value.Value v =
          eng.
          getComputedStyle(
            this,
            null,
            org.apache.batik.css.engine.SVGCSSEngine.
              COLOR_INTERPOLATION_INDEX);
        return v.
          getStringValue(
            ).
          charAt(
            0) ==
          'l';
    }
    public void addTargetListener(java.lang.String ns,
                                  java.lang.String an,
                                  boolean isCSS,
                                  org.apache.batik.dom.anim.AnimationTargetListener l) {
        if (isCSS &&
              svgContext !=
              null) {
            ((org.apache.batik.dom.svg.SVGAnimationTargetContext)
               svgContext).
              addTargetListener(
                an,
                l);
        }
        else {
            super.
              addTargetListener(
                ns,
                an,
                isCSS,
                l);
        }
    }
    public void removeTargetListener(java.lang.String ns,
                                     java.lang.String an,
                                     boolean isCSS,
                                     org.apache.batik.dom.anim.AnimationTargetListener l) {
        if (isCSS) {
            ((org.apache.batik.dom.svg.SVGAnimationTargetContext)
               svgContext).
              removeTargetListener(
                an,
                l);
        }
        else {
            super.
              removeTargetListener(
                ns,
                an,
                isCSS,
                l);
        }
    }
    public org.w3c.dom.css.CSSStyleDeclaration getStyle() {
        if (style ==
              null) {
            org.apache.batik.css.engine.CSSEngine eng =
              ((org.apache.batik.dom.svg.SVGOMDocument)
                 getOwnerDocument(
                   )).
              getCSSEngine(
                );
            style =
              new org.apache.batik.dom.svg.SVGStylableElement.StyleDeclaration(
                eng);
            putLiveAttributeValue(
              null,
              SVG_STYLE_ATTRIBUTE,
              style);
        }
        return style;
    }
    public org.w3c.dom.css.CSSValue getPresentationAttribute(java.lang.String name) {
        org.w3c.dom.css.CSSValue result =
          (org.w3c.dom.css.CSSValue)
            getLiveAttributeValue(
              null,
              name);
        if (result !=
              null)
            return result;
        org.apache.batik.css.engine.CSSEngine eng =
          ((org.apache.batik.dom.svg.SVGOMDocument)
             getOwnerDocument(
               )).
          getCSSEngine(
            );
        int idx =
          eng.
          getPropertyIndex(
            name);
        if (idx ==
              -1)
            return null;
        if (idx >
              org.apache.batik.css.engine.SVGCSSEngine.
                FINAL_INDEX) {
            if (eng.
                  getValueManagers(
                    )[idx] instanceof org.apache.batik.css.engine.value.svg.SVGPaintManager) {
                result =
                  new org.apache.batik.dom.svg.SVGStylableElement.PresentationAttributePaintValue(
                    eng,
                    name);
            }
            if (eng.
                  getValueManagers(
                    )[idx] instanceof org.apache.batik.css.engine.value.svg.SVGColorManager) {
                result =
                  new org.apache.batik.dom.svg.SVGStylableElement.PresentationAttributeColorValue(
                    eng,
                    name);
            }
        }
        else {
            switch (idx) {
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FILL_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       STROKE_INDEX:
                    result =
                      new org.apache.batik.dom.svg.SVGStylableElement.PresentationAttributePaintValue(
                        eng,
                        name);
                    break;
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FLOOD_COLOR_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       LIGHTING_COLOR_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       STOP_COLOR_INDEX:
                    result =
                      new org.apache.batik.dom.svg.SVGStylableElement.PresentationAttributeColorValue(
                        eng,
                        name);
                    break;
                default:
                    result =
                      new org.apache.batik.dom.svg.SVGStylableElement.PresentationAttributeValue(
                        eng,
                        name);
            }
        }
        putLiveAttributeValue(
          null,
          name,
          (org.apache.batik.dom.svg.LiveAttributeValue)
            result);
        if (getAttributeNS(
              null,
              name).
              length(
                ) ==
              0) {
            return null;
        }
        return result;
    }
    public org.w3c.dom.svg.SVGAnimatedString getClassName() {
        return className;
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public class PresentationAttributeValue extends org.apache.batik.css.dom.CSSOMValue implements org.apache.batik.dom.svg.LiveAttributeValue, org.apache.batik.css.dom.CSSOMValue.ValueProvider {
        protected org.apache.batik.css.engine.CSSEngine
          cssEngine;
        protected java.lang.String property;
        protected org.apache.batik.css.engine.value.Value
          value;
        protected boolean mutate;
        public PresentationAttributeValue(org.apache.batik.css.engine.CSSEngine eng,
                                          java.lang.String prop) {
            super(
              null);
            valueProvider =
              this;
            setModificationHandler(
              new org.apache.batik.css.dom.CSSOMValue.AbstractModificationHandler(
                ) {
                  protected org.apache.batik.css.engine.value.Value getValue() {
                      return PresentationAttributeValue.this.
                        getValue(
                          );
                  }
                  public void textChanged(java.lang.String text)
                        throws org.w3c.dom.DOMException {
                      value =
                        cssEngine.
                          parsePropertyValue(
                            SVGStylableElement.this,
                            property,
                            text);
                      mutate =
                        true;
                      setAttributeNS(
                        null,
                        property,
                        text);
                      mutate =
                        false;
                  }
              });
            cssEngine =
              eng;
            property =
              prop;
            org.w3c.dom.Attr attr =
              getAttributeNodeNS(
                null,
                prop);
            if (attr !=
                  null) {
                value =
                  cssEngine.
                    parsePropertyValue(
                      SVGStylableElement.this,
                      prop,
                      attr.
                        getValue(
                          ));
            }
        }
        public org.apache.batik.css.engine.value.Value getValue() {
            if (value ==
                  null) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    INVALID_STATE_ERR,
                  "");
            }
            return value;
        }
        public void attrAdded(org.w3c.dom.Attr node,
                              java.lang.String newv) {
            if (!mutate) {
                value =
                  cssEngine.
                    parsePropertyValue(
                      SVGStylableElement.this,
                      property,
                      newv);
            }
        }
        public void attrModified(org.w3c.dom.Attr node,
                                 java.lang.String oldv,
                                 java.lang.String newv) {
            if (!mutate) {
                value =
                  cssEngine.
                    parsePropertyValue(
                      SVGStylableElement.this,
                      property,
                      newv);
            }
        }
        public void attrRemoved(org.w3c.dom.Attr node,
                                java.lang.String oldv) {
            if (!mutate) {
                value =
                  null;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "bq5jPt/BY3vGjiQ6jq8I262LiYll3b746/BcXx1u47cablF7f+rB37/S0L92" +
           "IucjnKu7xQkIf8+D0FqaO1GCqpzf8+GsjasHtk/gqDMv4KKgyG+2nbqwbrF4" +
           "MMyvcKxqm3X142dq9AdmmU6ZqSv+UFyYCaEajJi5EDq77RDaHQRLN0gD0Zdp" +
           "4nOx5ulTD+Z5N4bDU1Dg+inLlIK4myb7b1UK8veFONGs8fkn/KeulWDDk7Yt" +
           "T07cDblYA6YGTgSVmFrD94g8mzD7eDnny309j5O+gcOz0K/g/TK/reRkmg2h" +
           "+MUYKRxSpYTrua/dLs8B7oQO2eYfmrjncrEG7C/gihTgz6PcS66rvpXHVd/B" +
           "4RQj5eiqNn72owmcO+565vTt8sz9YNZR27yjE/dMLtbxY8r1DBd9No9TzuHw" +
           "CgOYAqd00RTAXtAnP/h/+CTNyKzcV2a3rknZN3BQEWqzbvmtm2nxxSMVpTOP" +
           "PHKZF4PM7XE5wHrSlGXvycPzXKzpNClxr5Rb5xCrMv+MkdpcejFSACNX/4JF" +
           "/RYj08ejBkoYvZS/sJPeSwldMv/20l1kpMylg+poPXhJ3gXpQIKPlzXHmQv/" +
           "h2KdDnmKrL17fNNrbrXpGRbvfRCWRv4PGqeMmda/aPrEM0c2tD96477j1n2U" +
           "KAujoyhlMnRM1tVYphQuyCnNkVW8fsnNqS9NWuR0DFWWwm4WzfYEOEKShpcA" +
           "swKXNUZD5s7mvWOrzr61r/gd6BE3k5DAyLTN2afctGZCD7I5lt0ZQtvAb5Ea" +
           "lzw7snp58i+/4fcIxOok5+Sm7xMvndh68WDtsbowmdxKiqAZoml+/H54ROmi" +
           "4pDeS6ZIRnMaVAQpkiD72s6pGNcCXgdxv9junJKZxdtMRuqzu+7sO+AyWR2m" +
           "+lrVVHjyQ+M62Z3x/efIzpUyU9MCDO6M52QyYtUh3A0I0b5Ym6Y5h5LS8xrH" +
           "htFg+80nOfeH/BGHa/8F84UrubwdAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public class PresentationAttributeColorValue extends org.apache.batik.css.dom.CSSOMSVGColor implements org.apache.batik.dom.svg.LiveAttributeValue, org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider {
        protected org.apache.batik.css.engine.CSSEngine
          cssEngine;
        protected java.lang.String property;
        protected org.apache.batik.css.engine.value.Value
          value;
        protected boolean mutate;
        public PresentationAttributeColorValue(org.apache.batik.css.engine.CSSEngine eng,
                                               java.lang.String prop) {
            super(
              null);
            valueProvider =
              this;
            setModificationHandler(
              new org.apache.batik.css.dom.CSSOMSVGColor.AbstractModificationHandler(
                ) {
                  protected org.apache.batik.css.engine.value.Value getValue() {
                      return PresentationAttributeColorValue.this.
                        getValue(
                          );
                  }
                  public void textChanged(java.lang.String text)
                        throws org.w3c.dom.DOMException {
                      value =
                        cssEngine.
                          parsePropertyValue(
                            SVGStylableElement.this,
                            property,
                            text);
                      mutate =
                        true;
                      setAttributeNS(
                        null,
                        property,
                        text);
                      mutate =
                        false;
                  }
              });
            cssEngine =
              eng;
            property =
              prop;
            org.w3c.dom.Attr attr =
              getAttributeNodeNS(
                null,
                prop);
            if (attr !=
                  null) {
                value =
                  cssEngine.
                    parsePropertyValue(
                      SVGStylableElement.this,
                      prop,
                      attr.
                        getValue(
                          ));
            }
        }
        public org.apache.batik.css.engine.value.Value getValue() {
            if (value ==
                  null) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    INVALID_STATE_ERR,
                  "");
            }
            return value;
        }
        public void attrAdded(org.w3c.dom.Attr node,
                              java.lang.String newv) {
            if (!mutate) {
                value =
                  cssEngine.
                    parsePropertyValue(
                      SVGStylableElement.this,
                      property,
                      newv);
            }
        }
        public void attrModified(org.w3c.dom.Attr node,
                                 java.lang.String oldv,
                                 java.lang.String newv) {
            if (!mutate) {
                value =
                  cssEngine.
                    parsePropertyValue(
                      SVGStylableElement.this,
                      property,
                      newv);
            }
        }
        public void attrRemoved(org.w3c.dom.Attr node,
                                java.lang.String oldv) {
            if (!mutate) {
                value =
                  null;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVZDWwU1xF+d/7BGIN/+A0/Bowh4qd3IYGkkSkJOAZMzmBh" +
           "4qqmYPb23tkLe7vL7lv77JQ2QaoglYIoJYSmCa1UECmCkNJGNC1BoKgkNEnV" +
           "BBqaViFV26g0FDWoalqVtunMe7u3P+c7aqlYund7b2fmzcyb+Wbe87HrpMwy" +
           "ST3VWIwNGNSKtWisXTItmmpWJctaD3Pd8tMl0l83XV1zf5SUd5ExvZLVJksW" +
           "XaFQNWV1kWmKZjFJk6m1htIUcrSb1KJmn8QUXesi4xWrNWOoiqywNj1FkaBT" +
           "MhOkVmLMVJI2o62OAEamJUCTONckviz8uilBqmTdGPDIJ/nIm31vkDLjrWUx" +
           "UpPYIvVJcZspajyhWKwpa5L5hq4O9Kg6i9Esi21RFzsuWJ1YnOeChherP7m5" +
           "p7eGu2CspGk64+ZZ66ilq300lSDV3myLSjPWNvJlUpIgo3zEjDQm3EXjsGgc" +
           "FnWt9ahA+9FUszPNOjeHuZLKDRkVYmRmUIghmVLGEdPOdQYJFcyxnTODtTNy" +
           "1gor80x8an5839Obak6WkOouUq1oHaiODEowWKQLHEozSWpay1IpmuoitRps" +
           "dgc1FUlVBp2drrOUHk1iNmy/6xactA1q8jU9X8E+gm2mLTPdzJmX5gHl/CpL" +
           "q1IP2DrBs1VYuALnwcBKBRQz0xLEncNSulXRUoxMD3PkbGx8GAiAdUSGsl49" +
           "t1SpJsEEqRMhokpaT7wDQk/rAdIyHQLQZGRyQaHoa0OSt0o9tBsjMkTXLl4B" +
           "1UjuCGRhZHyYjEuCXZoc2iXf/lxfs2T3o9oqLUoioHOKyirqPwqY6kNM62ia" +
           "mhTyQDBWzUvslya8sitKCBCPDxELmlNfuvHggvqzrwuaKUPQrE1uoTLrlg8l" +
           "x7w9tXnu/SWoRoWhWwpufsBynmXtzpumrAEIMyEnEV/G3Jdn153/wmNH6bUo" +
           "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" +
           "93xScd7gGDEY7sT5JOf+iD/icO2/hLEiIswdAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "WUwE3ZwJtksq6ymj2iCtOlgrqyh9wVzP/JG46TpjzsriqYLjYxG3OD4cNeaY" +
           "me7iKjqD6RnraA3L08IsklVG6i3YEWmNtPWka1GmgG8bk4HRlyayRIxHcnOb" +
           "GUKDaAr0LuwqS4ZqIEm90hdZqbbNm2JHplc55RJUD2saznjgd/gdJpiSvWmL" +
           "bHu92+XtBdIOo8pM2VqTAZKP4dhTxibaQMZwPuVRW2dsk8XGi94YrqPi2I8M" +
           "vbFuGFwu1Gc7rUJYYtVE2zWaRyqcEI1hgYwogyW1uulXTLPenYuV7jIVcgXh" +
           "wmpHWlvt+lJjFU2PLVSY5ezanxKOuJSniE1pwcYE2I+L6a4rzjocu61hIu5S" +
           "m8HSJup1vTlpVHaJZPM56i+JIR/MKEXAlW5ghM4sJAXMI11mgup9tKNs80kj" +
           "xqmcdqyZ62QEuxx3qBXYPk4aMt/vjX0GJ0y05dtzSx1wToQ1eBpeN5ORQEtE" +
           "TRqa3tJJOWnSGvT7cydfad1eNkziFs+w+pjLdlSHzXPbkTIWx/2GGlXJ7aCp" +
           "5stq7HbxlcJR3oihsEjdhpob6XQF4JpLLNNooFU8td+ttpc+7aLruYBlKJWu" +
           "YYYhnKVDznABaTQrgmR4qIk5szWCT4Gfa4iLSdNVlZ42K4mmhWMlwNgFTqDw" +
           "ZtBeOVupQcjBHGU3VTUbiZRlV4dDMlZJHDPbVVppVtqmt5mRjBaQBG2kZjsO" +
           "MLWObiVZYbdTtTIxqEUVaySb1Y7v4YNKze95WU9v7RqNRpBKiFepVFu2LCOb" +
           "tqA4dTVYojCK7gwHR2qNWZi5C9cY1sDCRot9ldQtpJmJRKXb501zxbXabKvl" +
           "2tNBF9VGXS8dp6lfFYYKmdiUEiyGqU/rSjsjBH6AIXaTZiTBoSfMDumBLIpx" +
           "M8YQcZs7qREBH+oo3J6rw2l1yqS5lHeHzQYpEjYSZ0GVrdQdRuWVioYHipFQ" +
           "ai5XCCp2xwIutHNvhiXAyk1otGHXp9PVFq3jK7Bk6000A03GFLLt1vgEH0rd" +
           "5tgRghbaMJRaG1sk8ALhlmOEsxGB3MRBCwRXF5OMqtNvNu0p78V8FIu7lram" +
           "wRKwotoBDZYZtc2kt/bbqc9P5aQ1bFfnTXnWCDPamw5Iyo98PJGj1aSuzZQl" +
           "r4Jhs7RlldwRGhcMcrMvWbtlNDSDcEDw7QXVU5isugoybi1k9KYpDBpIGOY1" +
           "hYhYPcrqbZmYrcCUsxzO1kSTbTB0jMnWZoPQnr0mjCpv16JuFE4EnFDUKbyr" +
           "5uPc5gc9dFiZcgsu67tohdsQ3CAxeZif59Wmb1JWn25sh26MGt2pZ5rNeYql" +
           "O04h6mN9gfmYhEy7tOJKVW/KkiNYcg3UmQLkxNaNVbho0F3eHUVVeZjAcEpO" +
           "djZSl2gJM4LAl9Llind640UH5viNrNqNRrTbCXqbdZ3x0uc2WMLPOis9CZt+" +
           "R5p3pXWwhTE+UPRurNRyA5mH9aYM0wPZn3n0wuNarag51EXZM3hJWjKq3Bjq" +
           "3oKVZ0SqyakMj/QBgojNmdGvbrzamNUby9Dl4CXbY+3F0Ik6QypeN3qDRVVh" +
           "KiIVWmqfkuqTNdLJkSrGImMObqeCofbHo7DBj/pDFGMBrhldAt9iGdXCNk24" +
           "th7uXBXbGiA652izUa/UKmNXgduTgecuK8Q2QwIhcKa7uYGFPrFq65iZSeam" +
           "wq5GnuZtJtSEt1Yai/Q4z8lYfpP29boixyCkdCznmLqJBhMxnQhLLnL8yoA0" +
           "Qn7dqcxoLkQSdbXrIYs1bYS56iNGpMCdCuLgdn9I4T7KLOCOvwNRSE7qrNSf" +
           "DylrUWHkUbW9DfBolo0k2BPgbd+aOb7uR3bFR5vViBJ6sCGK3mDBaoI2GrrV" +
           "4XjMjSuMRCjLeCVsAyOih06qjPChjDtOP7IGzSrBaHWbMAikWxHF6iJQ1z3H" +
           "bVIU3Jlh8G7VmKRTdDX39HQ3ETspQSzXrN9Zt8GWsO9VlxoPVtBIYwewkrFb" +
           "NpfgE2NlaATPt5HtSDdQiyLIGUjWJisuKg4BO7pYh22OdJhkY4Cd8dcXW+a3" +
           "v7it/P3lCcXJjfL/4mxi/+jRonj85DyrPFi+fHz7ePx79pLi9Mj55IC/csvb" +
           "Oc5ZmydXcPLZo7nGTY/mCr7uaCTyI5kqb+yulUxSHK6d4kA9iaGHb3UzXZ47" +
           "ffgdTz9jiB+pHRzdDVjFodr+hYFTxe8EYt506wM2vryVPz2w/uV3/N1D4zfb" +
           "b30Rt3mvOafkeZE/xn/sV6nX6997AN1xcnx9w/sC1zM9cf2h9eXYTLM4GF93" +
           "dP3wyTi+ohi2h8H4/dXROP7V+XPJ00i5+aHkG/aRdpt7lx+8zbMPFcX7U+ge" +
           "y0xPjlhnp4H5/S90jHRWYNnwfdffFjaBms8d2fbcV8a2c9dWV4sI3SB6GZRF" +
           "EJcJVnL+yG0s//Gi+KEUuqQBlvIllZsera1Dxzh1xw//X91BAsueP3LH818Z" +
           "d9xxij8/eoIte/s/cxv7f6YofiqF7i3sPz5hLNo+fmruT/9fzUXBOF3c8+5/" +
           "v2Kjf2puSfWLt7H0C0Xx8ymABGDp0PTD9Q2GPvtiDN0CDHiBdxdeGHFvfB8C" +
           "gN2DN7xztX9PSP+JZ67c86pnJr9f3vifvMtziYPuWWSed/aO7Ez9rig2F07p" +
           "gkv7G7Oo/PnNFHrwVnql0B2gLNX/jT31b6fQy29GDShBeZbyd49y8SxlCl0s" +
           "f8/S/UEKXT6lA8C/r5wl+WMgHZAU1T+Jjp35+i9vKtpeODOFHIVlOcgPvNAg" +
           "n7CcfZ2gmHbKN+aOp4hs/87ck/onnmGFb32u9ZH96wy6p+12hZR7OOju/ZsV" +
           "J9PMo7eUdizrLvqNz9/3k5ceP54P79srfJoiZ3R7zc3fHSD9KC1v+3efedVP" +
           "f92PPPNn5S3E/wDNKn9AyigAAA==");
    }
    public class PresentationAttributePaintValue extends org.apache.batik.css.dom.CSSOMSVGPaint implements org.apache.batik.dom.svg.LiveAttributeValue, org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider {
        protected org.apache.batik.css.engine.CSSEngine
          cssEngine;
        protected java.lang.String property;
        protected org.apache.batik.css.engine.value.Value
          value;
        protected boolean mutate;
        public PresentationAttributePaintValue(org.apache.batik.css.engine.CSSEngine eng,
                                               java.lang.String prop) {
            super(
              null);
            valueProvider =
              this;
            setModificationHandler(
              new org.apache.batik.css.dom.CSSOMSVGPaint.AbstractModificationHandler(
                ) {
                  protected org.apache.batik.css.engine.value.Value getValue() {
                      return PresentationAttributePaintValue.this.
                        getValue(
                          );
                  }
                  public void textChanged(java.lang.String text)
                        throws org.w3c.dom.DOMException {
                      value =
                        cssEngine.
                          parsePropertyValue(
                            SVGStylableElement.this,
                            property,
                            text);
                      mutate =
                        true;
                      setAttributeNS(
                        null,
                        property,
                        text);
                      mutate =
                        false;
                  }
              });
            cssEngine =
              eng;
            property =
              prop;
            org.w3c.dom.Attr attr =
              getAttributeNodeNS(
                null,
                prop);
            if (attr !=
                  null) {
                value =
                  cssEngine.
                    parsePropertyValue(
                      SVGStylableElement.this,
                      prop,
                      attr.
                        getValue(
                          ));
            }
        }
        public org.apache.batik.css.engine.value.Value getValue() {
            if (value ==
                  null) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    INVALID_STATE_ERR,
                  "");
            }
            return value;
        }
        public void attrAdded(org.w3c.dom.Attr node,
                              java.lang.String newv) {
            if (!mutate) {
                value =
                  cssEngine.
                    parsePropertyValue(
                      SVGStylableElement.this,
                      property,
                      newv);
            }
        }
        public void attrModified(org.w3c.dom.Attr node,
                                 java.lang.String oldv,
                                 java.lang.String newv) {
            if (!mutate) {
                value =
                  cssEngine.
                    parsePropertyValue(
                      SVGStylableElement.this,
                      property,
                      newv);
            }
        }
        public void attrRemoved(org.w3c.dom.Attr node,
                                java.lang.String oldv) {
            if (!mutate) {
                value =
                  null;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "ziclr2ocI8aCnTif5Nwf8kccrv8PYMQBDMwdAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "TT/w2u9WtxB/C0EJSyXKKAAA");
    }
    public class StyleDeclaration extends org.apache.batik.css.dom.CSSOMStoredStyleDeclaration implements org.apache.batik.dom.svg.LiveAttributeValue, org.apache.batik.css.engine.CSSEngine.MainPropertyReceiver {
        protected boolean mutate;
        public StyleDeclaration(org.apache.batik.css.engine.CSSEngine eng) {
            super(
              eng);
            declaration =
              cssEngine.
                parseStyleDeclaration(
                  SVGStylableElement.this,
                  getAttributeNS(
                    null,
                    SVG_STYLE_ATTRIBUTE));
        }
        public void attrAdded(org.w3c.dom.Attr node,
                              java.lang.String newv) {
            if (!mutate) {
                declaration =
                  cssEngine.
                    parseStyleDeclaration(
                      SVGStylableElement.this,
                      newv);
            }
        }
        public void attrModified(org.w3c.dom.Attr node,
                                 java.lang.String oldv,
                                 java.lang.String newv) {
            if (!mutate) {
                declaration =
                  cssEngine.
                    parseStyleDeclaration(
                      SVGStylableElement.this,
                      newv);
            }
        }
        public void attrRemoved(org.w3c.dom.Attr node,
                                java.lang.String oldv) {
            if (!mutate) {
                declaration =
                  new org.apache.batik.css.engine.StyleDeclaration(
                    );
            }
        }
        public void textChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            declaration =
              cssEngine.
                parseStyleDeclaration(
                  SVGStylableElement.this,
                  text);
            mutate =
              true;
            setAttributeNS(
              null,
              SVG_STYLE_ATTRIBUTE,
              text);
            mutate =
              false;
        }
        public void propertyRemoved(java.lang.String name)
              throws org.w3c.dom.DOMException {
            int idx =
              cssEngine.
              getPropertyIndex(
                name);
            for (int i =
                   0;
                 i <
                   declaration.
                   size(
                     );
                 i++) {
                if (idx ==
                      declaration.
                      getIndex(
                        i)) {
                    declaration.
                      remove(
                        i);
                    mutate =
                      true;
                    setAttributeNS(
                      null,
                      SVG_STYLE_ATTRIBUTE,
                      declaration.
                        toString(
                          cssEngine));
                    mutate =
                      false;
                    return;
                }
            }
        }
        public void propertyChanged(java.lang.String name,
                                    java.lang.String value,
                                    java.lang.String prio)
              throws org.w3c.dom.DOMException {
            boolean important =
              prio !=
              null &&
              prio.
              length(
                ) >
              0;
            cssEngine.
              setMainProperties(
                SVGStylableElement.this,
                this,
                name,
                value,
                important);
            mutate =
              true;
            setAttributeNS(
              null,
              SVG_STYLE_ATTRIBUTE,
              declaration.
                toString(
                  cssEngine));
            mutate =
              false;
        }
        public void setMainProperty(java.lang.String name,
                                    org.apache.batik.css.engine.value.Value v,
                                    boolean important) {
            int idx =
              cssEngine.
              getPropertyIndex(
                name);
            if (idx ==
                  -1)
                return;
            int i;
            for (i =
                   0;
                 i <
                   declaration.
                   size(
                     );
                 i++) {
                if (idx ==
                      declaration.
                      getIndex(
                        i))
                    break;
            }
            if (i <
                  declaration.
                  size(
                    ))
                declaration.
                  put(
                    i,
                    v,
                    idx,
                    important);
            else
                declaration.
                  append(
                    v,
                    idx,
                    important);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "XI1DhJAP763fVb7gjzjc+h/C60tJRB8AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "qQ5ZFP/4Hf/wg3//5d+rNvv+PyhFLTQyKgAA");
    }
    protected class OverrideStyleDeclaration extends org.apache.batik.css.dom.CSSOMStoredStyleDeclaration {
        protected OverrideStyleDeclaration(org.apache.batik.css.engine.CSSEngine eng) {
            super(
              eng);
            declaration =
              new org.apache.batik.css.engine.StyleDeclaration(
                );
        }
        public void textChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              overrideStyleTextChanged(
                SVGStylableElement.this,
                text);
        }
        public void propertyRemoved(java.lang.String name)
              throws org.w3c.dom.DOMException {
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              overrideStylePropertyRemoved(
                SVGStylableElement.this,
                name);
        }
        public void propertyChanged(java.lang.String name,
                                    java.lang.String value,
                                    java.lang.String prio)
              throws org.w3c.dom.DOMException {
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              overrideStylePropertyChanged(
                SVGStylableElement.this,
                name,
                value,
                prio);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "iBqvCHWXxSM2V/8LLChjvHUXAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
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
       "HtGQJvRsue00+4O1XTWghA06ENRPeDnt");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("jnsUgiD50dsnb+708zXFoe5xiNP/x3Hu9oI7qOfD0r3i/mry5L69+HuotI+V" +
       "Ofp/6nD91PXiwdGp+eFFtzTobHbu4Dw/HX3j9aKhipPRTz//4kvK+DPVS/sb" +
       "0Y+FpftCx/2bphqr5qkRPAJ6etv1T4GpIhjs5Jbxd57/8yfYd63edxNBJk+d" +
       "G+f5Ln+N+vxXBz8u/9Kl0h3Hd45XhamdbfTc2ZvG+301jHybPXPf+Maztx0V" +
       "kKy9QKzztx0n+nDhVccFF86/cUHdb+XZF8LSjxm2ERYhgSpimqQRq0gY+oYU" +
       "hcCm5TQfOaWMvxSW7owdQznR0i/ezB12UfC5YxY8kBeWQYr2LIhuhgVh6R7X" +
       "N2IxVG/Ih391Qd2/zrN/HpYeP+HDWSbk9f/4BPCXbwHwU3khBNL794Dff7My" +
       "f/6GWH//grp/n2dfDUsP62p45hryaMK/JZ/wSV0ubsfyub6f5Fddehas+He3" +
       "wIrX5oU/AdLP71nx87eHFQcnBO8uCP7TBfz4Rp79cVh6FPADPXdTnVddOcH6" +
       "J7eA9VV5YR+kj+6xfvT2YL10YvSLxeNKQfXtCwD/eZ79GQAcXBvwKT3/1i0A" +
       "fiQvfAKkT+wBf+L26/n/uKDuB3n2XbAOArkuKJJQChadYPverWJ7I0gv7bG9" +
       "dNuxHZQuqCvE/cOw9KpcZ2ezYn09B+8vbwFeEQaT26nP7uF99vbDe+CCujxO" +
       "7eCesHT/Dl5XDI6N01PXjn7ZRcXPGfKYAQf33gIDHs0L8yiE39wz4DdvDwPO" +
       "G6aDJy7gwhvyDEB+xAgmgRopzpGPMdautSbfIzmOqYonpvngdbfAgct54QCk" +
       "r+w58JXbrwLPXlBXzrPLYDE6v0qdWoQmvhODYv9IN+AbxhNdr3HBrmdu1bqj" +
       "IH1tz66v3R52nbbuRzCvjsQRbcM6LOI18gDRPBAnd8iLALqCma0LGP1cntXA" +
       "ahC5CnCjAFuKzz6Kxt6Z1eCgfqszqgrS1/cM+vrt16feBXWDPHtPWHoyCtT8" +
       "GwTRZwZd1DHzoPBQ9YFPfxTlc/DkCWLkVlUijyX81h7xn90exHcWBHcWKnGU" +
       "7ccMlKN6zRinQkF2mgFAsqIPZlUerZzHHBbsmV7AunmekWDHKirK2abn9IO6" +
       "VW69G6Tv7bn13b9ObuUZU4C7cgFwMc+EsPRaX7WcWL0Q+w3jEm+0I8jd4B/t" +
       "sf/o9s+NzQV1Vp5pO0+pMJM50R+eYNNv1cV/Oxjm/bu2u/+3ju2qlTS5AGCa" +
       "Zz7Y3gGAE18NVHt3NHB2f/dYHuR59dansIQnzAhugRm5x1h6Fgy7tWdG6/YL" +
       "+ucuqHshzz4Ylh7I/arzAZ5Pn8a+D4o8G9V5woQP3QIT8m+2Sh2A5117Jrzr" +
       "ZplwwzOPg49dUPfxPPvIThnOx1gfx01zJ1h/8aYC9IG7dnUwaf6xyONXfce5" +
       "+/ZQ/uJLD937+pfmf1x8ZXT8feB9ZOleLTLN01Hrp57vdn1VMwo+3LeLYXcL" +
       "cJ/a6/C1olzD0h0gz4d88A921P8Q2LZrUQNKkJ+m/Edh6eHzlGHpruL/abrP" +
       "AKf9hC4s3b17OE3yq6B3QJI//tpxKPi1P644ji4+OlvcHUo+flqxis3OIzeS" +
       "0XGT018w5UeKxUe4R8d/0e4z3Cvyl14a0j/9/eZndl9QAZ8xy/Je7iVL9+w+" +
       "5io6zY8Qn75ub0d93Y0/+8MHf/2+Z46OOx/cDfhEyU+N7alrf6vUs9yw+Loo" +
       "+6ev/613fPalbxSht/8PLWC/vx09AAA=");
}
