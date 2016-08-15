package org.apache.batik.css.dom;
public class CSSOMSVGColor implements org.w3c.dom.svg.SVGColor, org.w3c.dom.css.RGBColor, org.w3c.dom.svg.SVGICCColor, org.w3c.dom.svg.SVGNumberList {
    protected org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider valueProvider;
    protected org.apache.batik.css.dom.CSSOMSVGColor.ModificationHandler handler;
    protected org.apache.batik.css.dom.CSSOMSVGColor.RedComponent redComponent;
    protected org.apache.batik.css.dom.CSSOMSVGColor.GreenComponent greenComponent;
    protected org.apache.batik.css.dom.CSSOMSVGColor.BlueComponent blueComponent;
    protected java.util.ArrayList iccColors;
    public CSSOMSVGColor(org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider vp) {
        super(
          );
        valueProvider =
          vp;
    }
    public void setModificationHandler(org.apache.batik.css.dom.CSSOMSVGColor.ModificationHandler h) {
        handler =
          h;
    }
    public java.lang.String getCssText() { return valueProvider.
                                             getValue(
                                               ).
                                             getCssText(
                                               ); }
    public void setCssText(java.lang.String cssText) throws org.w3c.dom.DOMException {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            iccColors =
              null;
            handler.
              textChanged(
                cssText);
        }
    }
    public short getCssValueType() { return CSS_CUSTOM;
    }
    public short getColorType() { org.apache.batik.css.engine.value.Value value =
                                    valueProvider.
                                    getValue(
                                      );
                                  int cssValueType =
                                    value.
                                    getCssValueType(
                                      );
                                  switch (cssValueType) {
                                      case org.w3c.dom.css.CSSValue.
                                             CSS_PRIMITIVE_VALUE:
                                          int primitiveType =
                                            value.
                                            getPrimitiveType(
                                              );
                                          switch (primitiveType) {
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_IDENT:
                                                  {
                                                      if (value.
                                                            getStringValue(
                                                              ).
                                                            equalsIgnoreCase(
                                                              org.apache.batik.util.CSSConstants.
                                                                CSS_CURRENTCOLOR_VALUE))
                                                          return SVG_COLORTYPE_CURRENTCOLOR;
                                                      return SVG_COLORTYPE_RGBCOLOR;
                                                  }
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_RGBCOLOR:
                                                  return SVG_COLORTYPE_RGBCOLOR;
                                          }
                                          throw new java.lang.IllegalStateException(
                                            "Found unexpected PrimitiveType:" +
                                            primitiveType);
                                      case org.w3c.dom.css.CSSValue.
                                             CSS_VALUE_LIST:
                                          return SVG_COLORTYPE_RGBCOLOR_ICCCOLOR;
                                  }
                                  throw new java.lang.IllegalStateException(
                                    "Found unexpected CssValueType:" +
                                    cssValueType);
    }
    public org.w3c.dom.css.RGBColor getRGBColor() {
        return this;
    }
    public org.w3c.dom.css.RGBColor getRgbColor() {
        return this;
    }
    public void setRGBColor(java.lang.String color) {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            handler.
              rgbColorChanged(
                color);
        }
    }
    public org.w3c.dom.svg.SVGICCColor getICCColor() {
        return this;
    }
    public org.w3c.dom.svg.SVGICCColor getIccColor() {
        return this;
    }
    public void setRGBColorICCColor(java.lang.String rgb,
                                    java.lang.String icc) {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            iccColors =
              null;
            handler.
              rgbColorICCColorChanged(
                rgb,
                icc);
        }
    }
    public void setColor(short type, java.lang.String rgb,
                         java.lang.String icc) {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            iccColors =
              null;
            handler.
              colorChanged(
                type,
                rgb,
                icc);
        }
    }
    public org.w3c.dom.css.CSSPrimitiveValue getRed() {
        valueProvider.
          getValue(
            ).
          getRed(
            );
        if (redComponent ==
              null) {
            redComponent =
              new org.apache.batik.css.dom.CSSOMSVGColor.RedComponent(
                );
        }
        return redComponent;
    }
    public org.w3c.dom.css.CSSPrimitiveValue getGreen() {
        valueProvider.
          getValue(
            ).
          getGreen(
            );
        if (greenComponent ==
              null) {
            greenComponent =
              new org.apache.batik.css.dom.CSSOMSVGColor.GreenComponent(
                );
        }
        return greenComponent;
    }
    public org.w3c.dom.css.CSSPrimitiveValue getBlue() {
        valueProvider.
          getValue(
            ).
          getBlue(
            );
        if (blueComponent ==
              null) {
            blueComponent =
              new org.apache.batik.css.dom.CSSOMSVGColor.BlueComponent(
                );
        }
        return blueComponent;
    }
    public java.lang.String getColorProfile() {
        if (getColorType(
              ) !=
              SVG_COLORTYPE_RGBCOLOR_ICCCOLOR) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                SYNTAX_ERR,
              "");
        }
        org.apache.batik.css.engine.value.Value value =
          valueProvider.
          getValue(
            );
        return ((org.apache.batik.css.engine.value.svg.ICCColor)
                  value.
                  item(
                    1)).
          getColorProfile(
            );
    }
    public void setColorProfile(java.lang.String colorProfile)
          throws org.w3c.dom.DOMException {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            handler.
              colorProfileChanged(
                colorProfile);
        }
    }
    public org.w3c.dom.svg.SVGNumberList getColors() {
        return this;
    }
    public int getNumberOfItems() { if (getColorType(
                                          ) !=
                                          SVG_COLORTYPE_RGBCOLOR_ICCCOLOR) {
                                        throw new org.w3c.dom.DOMException(
                                          org.w3c.dom.DOMException.
                                            SYNTAX_ERR,
                                          "");
                                    }
                                    org.apache.batik.css.engine.value.Value value =
                                      valueProvider.
                                      getValue(
                                        );
                                    return ((org.apache.batik.css.engine.value.svg.ICCColor)
                                              value.
                                              item(
                                                1)).
                                      getNumberOfColors(
                                        );
    }
    public void clear() throws org.w3c.dom.DOMException {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            iccColors =
              null;
            handler.
              colorsCleared(
                );
        }
    }
    public org.w3c.dom.svg.SVGNumber initialize(org.w3c.dom.svg.SVGNumber newItem)
          throws org.w3c.dom.DOMException {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            float f =
              newItem.
              getValue(
                );
            iccColors =
              new java.util.ArrayList(
                );
            org.w3c.dom.svg.SVGNumber result =
              new org.apache.batik.css.dom.CSSOMSVGColor.ColorNumber(
              f);
            iccColors.
              add(
                result);
            handler.
              colorsInitialized(
                f);
            return result;
        }
    }
    public org.w3c.dom.svg.SVGNumber getItem(int index)
          throws org.w3c.dom.DOMException {
        if (getColorType(
              ) !=
              SVG_COLORTYPE_RGBCOLOR_ICCCOLOR) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                INDEX_SIZE_ERR,
              "");
        }
        int n =
          getNumberOfItems(
            );
        if (index <
              0 ||
              index >=
              n) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                INDEX_SIZE_ERR,
              "");
        }
        if (iccColors ==
              null) {
            iccColors =
              new java.util.ArrayList(
                n);
            for (int i =
                   iccColors.
                   size(
                     );
                 i <
                   n;
                 i++) {
                iccColors.
                  add(
                    null);
            }
        }
        org.apache.batik.css.engine.value.Value value =
          valueProvider.
          getValue(
            ).
          item(
            1);
        float f =
          ((org.apache.batik.css.engine.value.svg.ICCColor)
             value).
          getColor(
            index);
        org.w3c.dom.svg.SVGNumber result =
          new org.apache.batik.css.dom.CSSOMSVGColor.ColorNumber(
          f);
        iccColors.
          set(
            index,
            result);
        return result;
    }
    public org.w3c.dom.svg.SVGNumber insertItemBefore(org.w3c.dom.svg.SVGNumber newItem,
                                                      int index)
          throws org.w3c.dom.DOMException {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            int n =
              getNumberOfItems(
                );
            if (index <
                  0 ||
                  index >
                  n) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    INDEX_SIZE_ERR,
                  "");
            }
            if (iccColors ==
                  null) {
                iccColors =
                  new java.util.ArrayList(
                    n);
                for (int i =
                       iccColors.
                       size(
                         );
                     i <
                       n;
                     i++) {
                    iccColors.
                      add(
                        null);
                }
            }
            float f =
              newItem.
              getValue(
                );
            org.w3c.dom.svg.SVGNumber result =
              new org.apache.batik.css.dom.CSSOMSVGColor.ColorNumber(
              f);
            iccColors.
              add(
                index,
                result);
            handler.
              colorInsertedBefore(
                f,
                index);
            return result;
        }
    }
    public org.w3c.dom.svg.SVGNumber replaceItem(org.w3c.dom.svg.SVGNumber newItem,
                                                 int index)
          throws org.w3c.dom.DOMException {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            int n =
              getNumberOfItems(
                );
            if (index <
                  0 ||
                  index >=
                  n) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    INDEX_SIZE_ERR,
                  "");
            }
            if (iccColors ==
                  null) {
                iccColors =
                  new java.util.ArrayList(
                    n);
                for (int i =
                       iccColors.
                       size(
                         );
                     i <
                       n;
                     i++) {
                    iccColors.
                      add(
                        null);
                }
            }
            float f =
              newItem.
              getValue(
                );
            org.w3c.dom.svg.SVGNumber result =
              new org.apache.batik.css.dom.CSSOMSVGColor.ColorNumber(
              f);
            iccColors.
              set(
                index,
                result);
            handler.
              colorReplaced(
                f,
                index);
            return result;
        }
    }
    public org.w3c.dom.svg.SVGNumber removeItem(int index)
          throws org.w3c.dom.DOMException {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            int n =
              getNumberOfItems(
                );
            if (index <
                  0 ||
                  index >=
                  n) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    INDEX_SIZE_ERR,
                  "");
            }
            org.w3c.dom.svg.SVGNumber result =
              null;
            if (iccColors !=
                  null) {
                result =
                  (org.apache.batik.css.dom.CSSOMSVGColor.ColorNumber)
                    iccColors.
                    get(
                      index);
            }
            if (result ==
                  null) {
                org.apache.batik.css.engine.value.Value value =
                  valueProvider.
                  getValue(
                    ).
                  item(
                    1);
                result =
                  new org.apache.batik.css.dom.CSSOMSVGColor.ColorNumber(
                    ((org.apache.batik.css.engine.value.svg.ICCColor)
                       value).
                      getColor(
                        index));
            }
            handler.
              colorRemoved(
                index);
            return result;
        }
    }
    public org.w3c.dom.svg.SVGNumber appendItem(org.w3c.dom.svg.SVGNumber newItem)
          throws org.w3c.dom.DOMException {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            if (iccColors ==
                  null) {
                int n =
                  getNumberOfItems(
                    );
                iccColors =
                  new java.util.ArrayList(
                    n);
                for (int i =
                       0;
                     i <
                       n;
                     i++) {
                    iccColors.
                      add(
                        null);
                }
            }
            float f =
              newItem.
              getValue(
                );
            org.w3c.dom.svg.SVGNumber result =
              new org.apache.batik.css.dom.CSSOMSVGColor.ColorNumber(
              f);
            iccColors.
              add(
                result);
            handler.
              colorAppend(
                f);
            return result;
        }
    }
    protected class ColorNumber implements org.w3c.dom.svg.SVGNumber {
        protected float value;
        public ColorNumber(float f) { super(
                                        );
                                      value =
                                        f;
        }
        public float getValue() { if (iccColors ==
                                        null) {
                                      return value;
                                  }
                                  int idx =
                                    iccColors.
                                    indexOf(
                                      this);
                                  if (idx ==
                                        -1) {
                                      return value;
                                  }
                                  org.apache.batik.css.engine.value.Value value =
                                    valueProvider.
                                    getValue(
                                      ).
                                    item(
                                      1);
                                  return ((org.apache.batik.css.engine.value.svg.ICCColor)
                                            value).
                                    getColor(
                                      idx);
        }
        public void setValue(float f) { value =
                                          f;
                                        if (iccColors ==
                                              null) {
                                            return;
                                        }
                                        int idx =
                                          iccColors.
                                          indexOf(
                                            this);
                                        if (idx ==
                                              -1) {
                                            return;
                                        }
                                        if (handler ==
                                              null) {
                                            throw new org.w3c.dom.DOMException(
                                              org.w3c.dom.DOMException.
                                                NO_MODIFICATION_ALLOWED_ERR,
                                              "");
                                        }
                                        else {
                                            handler.
                                              colorReplaced(
                                                f,
                                                idx);
                                        }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/gsKVPUfehgAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static interface ValueProvider {
        org.apache.batik.css.engine.value.Value getValue();
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1471109864000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1471109864000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "OjV4YqRFVsz1K1ZtZtc2cNSwG9Wosal4C3Pih5VZbJkkmc71ulkw04mtlCeb" +
           "Dm8NakixxljRugx7tjIcLSW3VjdrJScqF7p+1+rQM3LdxdB+ke2ujFocog1u" +
           "xpFoadh2CnAwLvXsSteaN9nVcNJsIZ3puqymHpkOTVXQy10Ht5otPhXGZsUa" +
           "iVUOuHNv0rabhDKJ12RH6DeLXZILTHy6YPBlR0Wo0khoVabRSE11uFuRGGIx" +
           "ilGEWVZimhinltgvLhdTX+7RouEQGB+Pek5YVFqCtdCMluhMsbqOoFVFQkK9" +
           "3Usluluc6512kUgSya7QiVowZ6GqtrtqbZ6wy8o8iXzbaukOvZJ7cqKXV2uh" +
           "sLQT07ODYtlWVBNG8RomzeNitzR1q4TRL4UJOeRJxK+3ln5DSvyRjZWaQkVL" +
           "2stCtWjE1MYdlqtkJ8DpSpGl1wImkBvTE3AyhNd0d5Awqg+vuTKSgFAViq15" +
           "R9RqymbeHTlSRRhObIEx5qhQVtcJ51GDVr/ElFd1bV5swDImDTEncXHeY6ar" +
           "5qA65dZJ0ZfC1UZtM3xN9pX1jIBJZdS1Zryw9k1mIGhzIOfpzBd8q9UNKZz0" +
           "u90Y11qSadHmqFSvYmWtVEf6qmIiuDBIpGBZgeuoapeXxVhj5YDgOgO5TsfJ" +
           "CO7PqhE+JYc1jKtGVF2MKZ4v1VW/YhmNRgErSZIcLekBUEatqsSUEJKNaGkM" +
           "8GZLNed1nqSaWJ1mzH5ESARH9D2X1JZTcmWEm+mSFxKnk3S7SzkoCOXeopD6" +
           "htyM68O1xC3m7fUQVQW5nEbjsL1qS2RzZIyRfldYyGJhWEw3VlAhkmVjXPAD" +
           "LVB9xWvoNaEBK72gh7hBY55SCTNq8pzidjCmKq4JB7HjeDgcMB68HvHkpqVN" +
           "/UqZHmq60+SXVX+0Hoj1RsXoF4oLaUNFLruSZHe6opGRRqjT2YRjpUK/J60w" +
           "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" +
           "pwV0JQP3fy9NbX+3omYGfj2f9uGXE9UP");
        java.lang.String jlc$ClassType$jl5$1 =
          ("3KlJ7T2UgUcy8Oj3UF5PnJbXYxl4QxxArzl1+/HIed74yq5Ogm3YIzfcx97e" +
           "IZZ+6YUrFx9+Yfqf8jrL8T3fSwx0UQ0t6+T1vhPPd7meohq5LC5tSyu5EPee" +
           "CaBHbsUS2DgAmHG+d22L/aYAeu3NsAEmgCcxYfDCfRYzgC7kvyfxDgLo8g4P" +
           "ZOLtw0mUIqAOULLHUnbb8BY7wAdeTn0n6nxP3/K1hw23N+SvS598odP78W+j" +
           "H9teVwTb0DTNqID3iru31aucaFYJevKW1I5o3dV+80v3ferSM0eVw/u2DO88" +
           "6QRvb7h5XYlYuUFeCUp/9eFf/uF/9sKX8itz/x+CQd8OuDAAAA==");
    }
    public static interface ModificationHandler {
        void textChanged(java.lang.String text)
              throws org.w3c.dom.DOMException;
        void redTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException;
        void redFloatValueChanged(short unit,
                                  float value)
              throws org.w3c.dom.DOMException;
        void greenTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException;
        void greenFloatValueChanged(short unit,
                                    float value)
              throws org.w3c.dom.DOMException;
        void blueTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException;
        void blueFloatValueChanged(short unit,
                                   float value)
              throws org.w3c.dom.DOMException;
        void rgbColorChanged(java.lang.String text)
              throws org.w3c.dom.DOMException;
        void rgbColorICCColorChanged(java.lang.String rgb,
                                     java.lang.String icc)
              throws org.w3c.dom.DOMException;
        void colorChanged(short type, java.lang.String rgb,
                          java.lang.String icc)
              throws org.w3c.dom.DOMException;
        void colorProfileChanged(java.lang.String cp)
              throws org.w3c.dom.DOMException;
        void colorsCleared() throws org.w3c.dom.DOMException;
        void colorsInitialized(float f) throws org.w3c.dom.DOMException;
        void colorInsertedBefore(float f,
                                 int idx)
              throws org.w3c.dom.DOMException;
        void colorReplaced(float f, int idx)
              throws org.w3c.dom.DOMException;
        void colorRemoved(int idx) throws org.w3c.dom.DOMException;
        void colorAppend(float f) throws org.w3c.dom.DOMException;
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1471109864000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1471109864000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "PeYOXw0j3+H3V2V86NGrJoddWVUiXz1o9xUPi5+88qk3XtqGzh9erkprePGx" +
           "xZ87Z65vi1bawN4S9x2h5rvxwZPDK0FAranNocchaPuFu2ug2d/07b1eSp+/" +
           "OvCaq9xhe9//2F27+9BLDxYh2q5lqXKm9UtDx87m7EXJUtMFwb+9+Hjxk//r" +
           "nXdvZrQt8GTPDE+cXsHB838AQ2/+49d+96Gsmi053TRwsKxywLZZib73oOaW" +
           "74vrVI7VW/70xf/0M+L7z0FbKHQ+0BM1WxreyvBtZWGTQZtl2MWMqgcMe8tE" +
           "D6TrpnFZzpZKEYrorGTVS1vOCmdrzj8dQnem+ynamujM1c0WhJ88FIftEDq/" +
           "dHXlIEBfe9o0vpo9PbSaKhy168uAiR7etevDZ7LrieAPtBNfm0HPGNYp8UPo" +
           "Ll9V+AMlpE+tA8DBWQG/Esj++C7gx28g4O0N10k2uxBorh+e+GZmuWKY1fez" +
           "p+nnHSl5Uwg9H+inmxbLVoVP1tLPnFVL");
        java.lang.String jlc$ClassType$jl5$1 =
          ("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" +
           "p7+SnRj9//5B+L69QwAA");
    }
    public abstract class AbstractModificationHandler implements org.apache.batik.css.dom.CSSOMSVGColor.ModificationHandler {
        protected abstract org.apache.batik.css.engine.value.Value getValue();
        public void redTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              40);
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        text);
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          getGreen(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          getBlue(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ')');
                    break;
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        text);
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getGreen(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getBlue(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ')');
                    sb.
                      append(
                        value.
                          item(
                            1).
                          getCssText(
                            ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              sb.
                toString(
                  ));
        }
        public void redFloatValueChanged(short unit,
                                         float fValue)
              throws org.w3c.dom.DOMException {
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              40);
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        org.apache.batik.css.engine.value.FloatValue.
                          getCssText(
                            unit,
                            fValue));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          getGreen(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          getBlue(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ')');
                    break;
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        org.apache.batik.css.engine.value.FloatValue.
                          getCssText(
                            unit,
                            fValue));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getGreen(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getBlue(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ')');
                    sb.
                      append(
                        value.
                          item(
                            1).
                          getCssText(
                            ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              sb.
                toString(
                  ));
        }
        public void greenTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              40);
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        value.
                          getRed(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        text);
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          getBlue(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ')');
                    break;
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getRed(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        text);
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getBlue(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ')');
                    sb.
                      append(
                        value.
                          item(
                            1).
                          getCssText(
                            ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              sb.
                toString(
                  ));
        }
        public void greenFloatValueChanged(short unit,
                                           float fValue)
              throws org.w3c.dom.DOMException {
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              40);
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        value.
                          getRed(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        org.apache.batik.css.engine.value.FloatValue.
                          getCssText(
                            unit,
                            fValue));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          getBlue(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ')');
                    break;
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getRed(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        org.apache.batik.css.engine.value.FloatValue.
                          getCssText(
                            unit,
                            fValue));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getBlue(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ')');
                    sb.
                      append(
                        value.
                          item(
                            1).
                          getCssText(
                            ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              sb.
                toString(
                  ));
        }
        public void blueTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              40);
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        value.
                          getRed(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          getGreen(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        text);
                    sb.
                      append(
                        ')');
                    break;
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getRed(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getGreen(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        text);
                    sb.
                      append(
                        ')');
                    sb.
                      append(
                        value.
                          item(
                            1).
                          getCssText(
                            ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              sb.
                toString(
                  ));
        }
        public void blueFloatValueChanged(short unit,
                                          float fValue)
              throws org.w3c.dom.DOMException {
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              40);
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        value.
                          getRed(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          getGreen(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        org.apache.batik.css.engine.value.FloatValue.
                          getCssText(
                            unit,
                            fValue));
                    sb.
                      append(
                        ')');
                    break;
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getRed(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getGreen(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        org.apache.batik.css.engine.value.FloatValue.
                          getCssText(
                            unit,
                            fValue));
                    sb.
                      append(
                        ')');
                    sb.
                      append(
                        value.
                          item(
                            1).
                          getCssText(
                            ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              sb.
                toString(
                  ));
        }
        public void rgbColorChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR:
                    break;
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    text +=
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              text);
        }
        public void rgbColorICCColorChanged(java.lang.String rgb,
                                            java.lang.String icc)
              throws org.w3c.dom.DOMException {
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      rgb +
                      ' ' +
                      icc);
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorChanged(short type,
                                 java.lang.String rgb,
                                 java.lang.String icc)
              throws org.w3c.dom.DOMException {
            switch (type) {
                case SVG_COLORTYPE_CURRENTCOLOR:
                    textChanged(
                      org.apache.batik.util.CSSConstants.
                        CSS_CURRENTCOLOR_VALUE);
                    break;
                case SVG_COLORTYPE_RGBCOLOR:
                    textChanged(
                      rgb);
                    break;
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      rgb +
                      ' ' +
                      icc);
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NOT_SUPPORTED_ERR,
                      "");
            }
        }
        public void colorProfileChanged(java.lang.String cp)
              throws org.w3c.dom.DOMException {
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      value.
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    sb.
                      append(
                        cp);
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        value.
                        item(
                          1);
                    for (int i =
                           0;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorsCleared() throws org.w3c.dom.DOMException {
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      value.
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        value.
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorsInitialized(float f)
              throws org.w3c.dom.DOMException {
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      value.
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        value.
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        f);
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorInsertedBefore(float f,
                                        int idx)
              throws org.w3c.dom.DOMException {
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      value.
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        value.
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    for (int i =
                           0;
                         i <
                           idx;
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        f);
                    for (int i =
                           idx;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorReplaced(float f,
                                  int idx)
              throws org.w3c.dom.DOMException {
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      value.
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        value.
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    for (int i =
                           0;
                         i <
                           idx;
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        f);
                    for (int i =
                           idx +
                           1;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorRemoved(int idx)
              throws org.w3c.dom.DOMException {
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      value.
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        value.
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    for (int i =
                           0;
                         i <
                           idx;
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    for (int i =
                           idx +
                           1;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorAppend(float f) throws org.w3c.dom.DOMException {
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      value.
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        value.
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    for (int i =
                           0;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        f);
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public AbstractModificationHandler() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "xbwkKAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "WkGUpBbVF52qwvkDr6NwWrQ1bZznWLQqGC1h1VTL20HWUOHydCL0hN6mnKr2" +
           "ehLKUlgJ1aVYt6aChQPDjhB1HXQ5WxdSZuCsN/3RpE9v1pks2oRfseJgvm0Z" +
           "mJ1yTcMhy2ySBlyXam/mLs7DMak0l0uuN0CMCUkFPfBsGW9wZ9jYykqCO1ln" +
           "sBGrjZLGUVmpNBekGm8RI7/ZGUhZ3apGVKxlnYRZ00bVX+BpgxxvKXZbHVsr" +
           "bdpDJ8vGdg68dNWHR+WqYKmKbBFLZLx2jb61IIXVbAiT2mw2aOiUPs5KihCN" +
           "2fKcb2FJD2iXN5pyc5EkuI56DWvGxfKsK5RMuhcLNQSbc+VWt1WpMdTAnZru" +
           "JJkR9RYe19wmghA1jfIIQ5OHnbEyGE/sKlrtDMmEUZhapCx0hvEHZYow0CXf" +
           "oOZaZeopSph0pqVO0oFrcErVhgPNNxGfE9Z9xRSqk41bV42AGpWXqcP2MH2p" +
           "UoLqDVigNnvjkHhrMUKqW6BOmBKXVb8Sk1QUKRWfF+sMt6jwlXgxbsiLppQN" +
           "J11WblRxtzxy+kmHWMXTUWwiQy9rgJWgFcGl5jS1KxPMxNtk1BsirCOoeNpz" +
           "QaameiGtUzGLtGtuiLuUykR1xTCRisWt6utqshh1UnhIraSmWY3n4brd3Naw" +
           "ynrW4GcOPUSXSDbYbkSpDnt2QlTdOR02OrgXt01xrcx7GzzsRWOFLq3FaTPr" +
           "TtJmJxwPrF5j1GHLGxlTKJvbrhsrBx7DbteLyolhmandntJrH/eI2apjTYNU" +
           "I9fDCUyP5L6mS6a3ESbRaNjScQQj+Uqd3IYDOoUZ2RoNJVcaS66ZwbI2LrGj" +
           "pq3Ia3kYtstYBcaqXSSqJHipt0Lahk/IqeVajplFrlhFZyyTTA0pohe9DkxX" +
           "KQtDShvN4Dxyuhxt4JrI1MCKl3DOsqxyHVgPRxXVpxU7MA1kPjTg5lYpLfCs" +
           "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" +
           "wVPwe/5uu0BhAD1xx/8X7M7Eq7/yytXL");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("b3uF/8/Fgddb59YfpKHLi9i2j58uO3Z9yQ/0hVno7sHdWTO/UAN78GB+mkgg" +
           "MwCaS35usuPmwRPnadyAE9DjnDPwpHaSEzziFt/H+X40gq4c8UXQpd3FcZYP" +
           "gNEBS3550z/U47HTZLvDeNluo+GJ435XLLOPnGXFW12On5vNd8eK/wM53MmK" +
           "d/8JclP94iv90Y9/r/GLu3O7qi1vt/kol2nogd0R4mLQfDfsmbuOdjjWJer5" +
           "7z/0pQfffbht99BO4KMYOCbbu04/GNt1/Kg4yrr9jbf92g/9y1f+qDhO9/8B" +
           "VoH+A6AzAAA=");
    }
    protected abstract class AbstractComponent implements org.w3c.dom.css.CSSPrimitiveValue {
        protected abstract org.apache.batik.css.engine.value.Value getValue();
        public java.lang.String getCssText() {
            return getValue(
                     ).
              getCssText(
                );
        }
        public short getCssValueType() { return getValue(
                                                  ).
                                           getCssValueType(
                                             );
        }
        public short getPrimitiveType() {
            return getValue(
                     ).
              getPrimitiveType(
                );
        }
        public float getFloatValue(short unitType)
              throws org.w3c.dom.DOMException {
            return org.apache.batik.css.dom.CSSOMValue.
              convertFloatValue(
                unitType,
                getValue(
                  ));
        }
        public java.lang.String getStringValue()
              throws org.w3c.dom.DOMException {
            return valueProvider.
              getValue(
                ).
              getStringValue(
                );
        }
        public org.w3c.dom.css.Counter getCounterValue()
              throws org.w3c.dom.DOMException {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                INVALID_ACCESS_ERR,
              "");
        }
        public org.w3c.dom.css.Rect getRectValue()
              throws org.w3c.dom.DOMException {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                INVALID_ACCESS_ERR,
              "");
        }
        public org.w3c.dom.css.RGBColor getRGBColorValue()
              throws org.w3c.dom.DOMException {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                INVALID_ACCESS_ERR,
              "");
        }
        public int getLength() { throw new org.w3c.dom.DOMException(
                                   org.w3c.dom.DOMException.
                                     INVALID_ACCESS_ERR,
                                   ""); }
        public org.w3c.dom.css.CSSValue item(int index) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                INVALID_ACCESS_ERR,
              "");
        }
        public AbstractComponent() { super(
                                       );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVZfWwUxxWfO39gG39hsDEEzJehNaF30IQ2kWkabGwwnLHF" +
           "AVJMglnvzdmL93aX3Tn7MCEliSIIEohSCLQq/FEZJa2SkEZNm6oNpUJtEuVD" +
           "CkVN0xbSKpVKm6BCW6V/0CR9b2bv9uM+XFf1STe3N/PmzXu/efM+Zp+9QUos" +
           "kzRRjYXYXoNaoQ6N9UqmRWPtqmRZW6GvXz5VJP1j5/XN9wZJaR+pHpKsblmy" +
           "aKdC1ZjVR+YrmsUkTabWZkpjOKPXpBY1RySm6FofqVesroShKrLCuvUYRYLt" +
           "khkhMyTGTGUgyWiXzYCR+RGQJMwlCa/1D7dGSKWsG3sd8kYXebtrBCkTzloW" +
           "I7WR3dKIFE4yRQ1HFIu1pkxyp6GrewdVnYVoioV2q6ttCDZGVmdBsPiFmo9v" +
           "Hxuq5RDMlDRNZ1w9awu1dHWExiKkxuntUGnC2kMeIUURMt1FzEhzJL1oGBYN" +
           "w6JpbR0qkL6KaslEu87VYWlOpYaMAjGyyMvEkEwpYbPp5TIDhzJm684ng7YL" +
           "M9oKLbNUPHln+MSpnbUvFpGaPlKjaFEURwYhGCzSB4DSxAA1rbWxGI31kRka" +
           "bHaUmoqkKmP2TtdZyqAmsSRsfxoW7Ewa1ORrOljBPoJuZlJmuplRL84Nyv5X" +
           "ElelQdC1wdFVaNiJ/aBghQKCmXEJ7M6eUjysaDFGFvhnZHRs3gQEMHVagrIh" +
           "PbNUsSZBB6kTJqJK2mA4CqanDQJpiQ4GaDIyNy9TxNqQ5GFpkPajRfroesUQ" +
           "UJVzIHAKI/V+Ms4Jdmmub5dc+3Nj85qj+7QNWpAEQOYYlVWUfzpMavJN2kLj" +
           "1KRwDsTEyuWRp6SGVw4FCQHieh+xoPnRw7fuX9F08TVBc0cOmp6B3VRm/fL4" +
           "QPU789pb7i1CMcoM3VJw8z2a81PWa4+0pgzwMA0ZjjgYSg9e3PLLBw58j34Y" +
           "JBVdpFTW1WQC7GiGrCcMRaXmeqpRU2I01kXKqRZr5+NdZBo8RxSNit6eeNyi" +
           "rIsUq7yrVOf/AaI4sECIKuBZ0eJ6+tmQ2BB/ThmEkNnwJZsIKb6f8I/4ZeSB" +
           "8JCeoGFJljRF08O9po76W2HwOAOA7VB4AKx+OGzpSRNMMKybg2EJ7GCI2gOy" +
           "ZYVjeiLcHo32dEe3rwfhdTOEJmZMJfMUajZzNBAA0Of5j7wKp2WDrsao2S+f" +
           "SLZ13Hq+/w1hTngEbEwYuQfWC4n1Qny9EKwXgvVCnvWa1w7AGZZk1g7bpWsg" +
           "OwkE+MKzUBKx07BPw3DiweVWtkQf2rjr0OIiMDFjtBhARtLFntDT7riFtC/v" +
           "l8/XVY0turbqUpAUR0gdrJeUVIwka81B8FHysH2MKwcgKDmxYaErNmBQM3WZ" +
           "xsA15YsRNpcyfYSa2M/ILBeHdOTCMxrOHzdyyk8unh59dPvXVgZJ0BsOcMkS" +
           "8GQ4vRedeMZZN/vdQC6+NQevf3z+qf264xA88SUdFrNmog6L/abhh6dfXr5Q" +
           "eqn/lf3NHPZycNhMggMGvrDJv4bH37SmfTfqUgYKx3UzIak4lMa4gg2Z+qjT" +
           "w212Bjb1wnzRhHwCcrf/lahx5jdv/+UujmQ6QtS4QnuUslaXV0Jmddz/zHAs" +
           "cqtJKdBdPd37jZM3Du7g5ggUS3It2IwtmjfsDiD4xGt73nv/2viVoGPCjJQb" +
           "ps7g9NJYiqsz6zP4BOD7KX7RmWCHcCp17bZnW5hxbQYuvswRD46WCtzQPpq3" +
           "aWCJSlyRBlSKR+jfNUtXvfTR0Vqx4yr0pA1mxcQMnP45beTAGzv/1cTZBGQM" +
           "sg6EDpnw3DMdzmtNU9qLcqQevTz/m69KZyAGgN+1lDHKXSnhkBC+h6s5Fit5" +
           "e7dv7MvYLLXcZu49Sa5kqF8+duVm1fabF25xab3ZlHvruyWjVRiS2AVYLEJE" +
           "43XtONpgYDs7BTLM9vuqDZI1BMzuvrj5wVr14m1Ytg+WlcEPWz0muM6Ux5ps" +
           "6pJpv/35pYZd7xSRYCepUHUp1inxM0fKwdipNQReN2V81RZktAyaWo4HyUIo" +
           "qwN3YUHu/e1IGIzvyNjLs3+w5umz17hlGoLHHW6Gy3jbgs0K3h/Exy8wUibZ" +
           "XjyVwY1PayiAm4t9gD83QlKKQWP0LpnHCYwXECt6TSUBB3EEHKyapIj2/Hz5" +
           "Dc/Nxh87cTbWc26VyELqvDlDB6TEz/36kzdDp//weo6gVWrnp45o03E9T3jp" +
           "5nmf4+KuVh//4MfNg22TiSzY1zRB7MD/C0CD5fkjhV+UVx/769yt9w3tmkSQ" +
           "WODD0s/yu93Pvr5+mXw8yJNcER+ykmPvpFY3qrCoSSGb11BN7Kni52tJxk4W" +
           "oVm0gH102HbS4T9fwpsXsD9sOh3Lw3NB5hbgWMCr9BUYexCbrWDsg5RxW0xb" +
           "7edypjpUG4RQFxpBypBDfw8224S0a/7Hs4wdbQbv782o3YBjC0HdTbbamyYB" +
           "JISgUiM5AAW2D8fqAgwLYDVcYCyBDdRYFYBjOxxcMOs0krXcQ2H1FBLVkwMZ" +
           "nQLI6nGsGTSL2hpGC0CGzWA2OPmmFgBgrMDYw9gkISoJcLjd8CTHk+Wif4km" +
           "wedmnKOowL7Yu0s+1Nz7J+H75uSYIOjqnwkf2f7u7je5oyhDz5Q5ni6vBB7M" +
           "lVvVYhNC/9tS4M7DK094f937w9++/pyQx19i+ojpoROHPwsdPSH8sqjDl2SV" +
           "wu45ohb3Sbeo0Cp8Ruefz+//yTP7DwZtzCOMlEBwNVlmRwKZ0mKWF0Mh6bon" +
           "a356rK6oE1x+FylLasqeJO2Ked3eNCs54ALVKdwdJ2jLjJkdVD3L0yGXm/vI" +
           "VJn7UrDVHbbN7pi8ueebWsCkTxYYO4XNMTj4YO6ejcL+Aw4cX58qOBaDLrKt" +
           "kzx5OPJN9als2xNXinP9Tm6CtB9sdOdB63q6O1IyNTCS88nj2JxhpApA64Q0" +
           "0RWNHrGPAf486np+gmGpA6S5RDrssruzUxWZ0M0O22gNTx7ofFML2NYP82/C" +
           "OU7wMjbfZ6QacBThhgOJvbqDyItTgAi/L1oG6li2WtbkEck3tQAilyZC5BfY" +
           "XLCjj57Ey1FPpjM7Kz8XRA5aP5sCtPDLM5t9tsr7Jo9WvqkF0Lo8EVpXsHmL" +
           "kUpAawtUUx6oZvmhQgoHp7enAKdGHPs8KPm4rezjk8cp39QCOP1xIpw+wOb3" +
           "wslvWd/G7/08WDVmYWVTOXhdnQK8ZuLYPFD2iK30kcnjlW9qAbxuFhj7OzYf" +
           "MlIOUEWggmBDE7n1IkWb0Kl/NFXGhuCdtBE4OXnw8k3Nb1D/RK6BYH4EA8XY" +
           "+QkjxQqz35/lMrD2aNRXkn36/8AoxciMrAvttBDL/rsbcUg6G7Nes4lXQ/Lz" +
           "Z2vKZp/d9i6/a8i8vqmEHD6eVFVX9unOREsNk8YVvh2V4nLL4EjV2rjkEgns" +
           "ClqUPFAjqGfaLs1PDZTQuikb4KT7KSH94L9uujlQAjp0UICKBzfJPOAOJPg4" +
           "30jj6CoSxfuklMibPFdVfE/rJ9rTzBT31S0WNfx1aDrvT4oXov3y+bMbN++7" +
           "9aVz4upYVqWxMeQyHbJ9cUFtl0vuIsTPLc2rdEPL7eoXypemixDP1bVbNm5Z" +
           "YP78jneu7yLVas7cp743vubCW4dKL0P5tIMEJEZm7nC9jBRItaaMpEnm74hk" +
           "VzXbJZPf8La2fGvvfSvif/sdvwUkogqal5++X77y9EO/Ot443hQk07tICdRX" +
           "NNVHKhRr3V4NYt6I2UeqFKsjBSICF0VSPSVTNRqxhLkXx8WGsyrTi+8UGFmc" +
           "XQZmv4mpUPVRarZBRhJDNlB0TXd6xM74bqaShuGb4PTYW4ntk8Lj4m6APfZH" +
           "ug0jfRtfssLgR/9wbheMhruSP+LTqv8Af6dyTSohAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "kWQsAAA=");
    }
    protected abstract class FloatComponent extends org.apache.batik.css.dom.CSSOMSVGColor.AbstractComponent {
        public void setStringValue(short stringType,
                                   java.lang.String stringValue)
              throws org.w3c.dom.DOMException {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                INVALID_ACCESS_ERR,
              "");
        }
        public FloatComponent() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "8LAB3BtOq5uVsYBBBSG3SlVlrYxYYYFvfIrlnAHa8rdOqVzG+uF8RgUlsp6u" +
           "KFLAed5AhbocjpftsuM6Hb1jxdXWso56XpDRlMZqKClx5sq3KdjEBi2i2u5b" +
           "7phdOn5r3avxy+kadoV14tUdF97YPNqQ3LZpo6yKU7XMwhGMV0YtqsKMOLdU" +
           "q1hWJmSxPF7G0XhueoaB0HWpQuqyMqvA9UU887IRag2MDdkmkQFsVBYl2kPK" +
           "gm03UgYJmdCES4OEKZExG5cHGw/LBoTBRLUSQnvzcoXsmYYmJCPB0+bDqdeq" +
           "Bx3NWPnNUifwEriSCoKKlsVmpSVw6KJbCXiBtbx+K2VX1lT0DLJRYRax7i4c" +
           "NKpL1LpEVTuoN10nVbWZbRq6OutspVTorYHZV4mrVs14Wel7jUBBJCaozRkb" +
           "7reG7cpYhbfNFKfIKau2VG5E6pnsJ/M6uliMRnKnL6/USkvMutq24wbjemTE" +
           "cNZNqpGq+mYimPpws0qN2aKtqZzdEF22Ns82CG941dJKnuNwvVUdqvJUkdpV" +
           "R4uQqSjiHNzsrlhnw08aVoo605AdLWaL4YgORN5eNelpmC7LPo12NiDhyCuC" +
           "rExwhIgoOfAFso7jpWSFc+LQGDelPtXawjSFNTWeXSxkdVSpo+hIn3iBJgRq" +
           "f9zu8L1lu0bMltsKqGJio8yC2DMNjKgjMsvM0LYppww8qrfblQaMd1hbokVx" +
           "1B61lVLGMV0qYqJeKVhOkUTZrFqNOGUZhEuwaVxX280Gq7NBhk+IOXhx1Gdd" +
           "dhNPlwmjz7QFjtnwUGQwFu0NyLHc7ItWLYONusWk0bqJh5xSx5yNQ7amNm/0" +
           "awnqIXZJqaVJowEvIkCcSpJZUIYZF8FKpVW6lTPNhN01kpctnmNlbXYSVGIk" +
           "aPDEmMbKWaXfkuCJyJGK6U+bZVMAiViLNqulkXbUqdaW54Y2JxarvmOMsTQy" +
           "tl1XyNjNoloJp2t5I9achhlsujUVX3VJITQbhim3sp5PLZWS7Y3tarutDstt" +
           "0eOUnlVZS2XYBK+bMmlUBSaGMUZZwh2GBv7abL4jP6a860c7Kd5VHIqPLizA" +
           "ATF/0P0RTkjZzTfci6Hbg9CPdTXWwUHwoqxEcSircXbULCzaJve8RrPwREMF" +
           "yk+GD77aXUVxKvz4+597QRt+orJ30IiaxtCtB1dIx3Tyo/lbX/34OyjuaY67" +
           "I194/7/cL7zTes+P0P99+AyTZ0n+7uDFL3Xfov76HnTLUa/khhuk00jXTndI" +
           "LoV6nISecKpP8uCRWi/n6uoBdX7sQK0fu3kP9qZWO1e4yc45zjT59nZmLf6P" +
           "TziFGEMXIssPi3Zlt0BNzqCeO9D9QaPlvrzdv66pRYe/PRyQmaoHuVoL5G0+" +
           "gJP6nZEe7/owRbfpZvueT31bO/bS1Q86x59q14EdTt8nHLL3lh/uNgJ40n03" +
           "XHHuruXUT79w+eK9L0z+umjAH12d3c5AF43EdU92u07Mbw1C3bALHdy+630F" +
           "xc8zBxq7GUsxdAsYC86f3kF/IIbeeDNoAAnGk5DPxtCVs5DAlsXvSbhfi6FL" +
           "x3AgqnaTkyDPAeoAJJ8+HxzqEfshb3WaB5nhyBDZudORf2Tgu3+QgU8ki8dP" +
           "RXlxZX0Ykcnu0vq6+pkXaPa9L6Of2N03qKCeK5zvIgPdtrv6OIrqR1+V2iGt" +
           "W3tPvHLnZ29/82H6uXPH8HGsneDt4Zs39MllEBct+O0f3vv7b//tF75etAH/" +
           "F47cxGJLIAAA");
    }
    protected class RedComponent extends org.apache.batik.css.dom.CSSOMSVGColor.FloatComponent {
        protected org.apache.batik.css.engine.value.Value getValue() {
            return valueProvider.
              getValue(
                ).
              getRed(
                );
        }
        public void setCssText(java.lang.String cssText)
              throws org.w3c.dom.DOMException {
            if (handler ==
                  null) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    NO_MODIFICATION_ALLOWED_ERR,
                  "");
            }
            else {
                getValue(
                  );
                handler.
                  redTextChanged(
                    cssText);
            }
        }
        public void setFloatValue(short unitType,
                                  float floatValue)
              throws org.w3c.dom.DOMException {
            if (handler ==
                  null) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    NO_MODIFICATION_ALLOWED_ERR,
                  "");
            }
            else {
                getValue(
                  );
                handler.
                  redFloatValueChanged(
                    unitType,
                    floatValue);
            }
        }
        public RedComponent() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "m5VhU0DDdGn8wvEn4hGHF/8LRosppwYYAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "7fyE+n8BgLzz4OQiAAA=");
    }
    protected class GreenComponent extends org.apache.batik.css.dom.CSSOMSVGColor.FloatComponent {
        protected org.apache.batik.css.engine.value.Value getValue() {
            return valueProvider.
              getValue(
                ).
              getGreen(
                );
        }
        public void setCssText(java.lang.String cssText)
              throws org.w3c.dom.DOMException {
            if (handler ==
                  null) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    NO_MODIFICATION_ALLOWED_ERR,
                  "");
            }
            else {
                getValue(
                  );
                handler.
                  greenTextChanged(
                    cssText);
            }
        }
        public void setFloatValue(short unitType,
                                  float floatValue)
              throws org.w3c.dom.DOMException {
            if (handler ==
                  null) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    NO_MODIFICATION_ALLOWED_ERR,
                  "");
            }
            else {
                getValue(
                  );
                handler.
                  greenFloatValueChanged(
                    unitType,
                    floatValue);
            }
        }
        public GreenComponent() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "DWe1YglwmCmPYDj+TDzi8Nx/AaRhzn0KGAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "+sev/MM3ffzpb+R31P8LYF+ryOgiAAA=");
    }
    protected class BlueComponent extends org.apache.batik.css.dom.CSSOMSVGColor.FloatComponent {
        protected org.apache.batik.css.engine.value.Value getValue() {
            return valueProvider.
              getValue(
                ).
              getBlue(
                );
        }
        public void setCssText(java.lang.String cssText)
              throws org.w3c.dom.DOMException {
            if (handler ==
                  null) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    NO_MODIFICATION_ALLOWED_ERR,
                  "");
            }
            else {
                getValue(
                  );
                handler.
                  blueTextChanged(
                    cssText);
            }
        }
        public void setFloatValue(short unitType,
                                  float floatValue)
              throws org.w3c.dom.DOMException {
            if (handler ==
                  null) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    NO_MODIFICATION_ALLOWED_ERR,
                  "");
            }
            else {
                getValue(
                  );
                handler.
                  blueFloatValueChanged(
                    unitType,
                    floatValue);
            }
        }
        public BlueComponent() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "TI4Ns5UBjI0/4Y9seO6/DkQj1wgYAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "+tlv5cfT/wtTpXQi4iIAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5B35Q3pUXH5Xdwe+nf0f3BOgmME5AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "YWUymTkI4o2qyDbo0vXpZFwv+y0PjtNh");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "vhnKfu2eX3njzz/xJ8UHMf8PEc4iKBNFAAA=");
}
