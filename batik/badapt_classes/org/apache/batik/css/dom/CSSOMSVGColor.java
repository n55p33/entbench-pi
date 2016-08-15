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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/wLit8goehgAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "qrYYYiM6GtW0GWJ5ahOO0KIs6nq72hzgOm+NNFHtTO3JotehCGeoL2W/3xDm" +
           "FT6sCGGLayV4k9N13OQXmGxaGNqps9KgjJpq1xmva9ys63obby1ZvNNZrdB+" +
           "pzTvzdYRLzsELWuN8Xwg9yiipJc5mx96/SnXKsiMXawzNDZHAlgnKGUUtBkK" +
           "7dCLZoh056m9wPxVq9pqq92IqVDLZkNhO7VVu+Ui5KpdppSJx2N62nBgZsGb" +
           "+CJO2MYgNtbjqrWIW3Xd6uIENaUwXq0uegLnpR5dKvZHDL6qeeNEc8VN6FU1" +
           "b0GLMstXwYEuqcH2yDSmwWDsA0tWN3QNh4NwViuYgd0u6FZjxk/WoYKLyNSv" +
           "wbVUgAsFFK3IiICWKM1T08LSZ5HRIkg9ZpJyzKyLJBtgKKxaraiRTJYbCkAa" +
           "A9f1GZ4664RelNF2uCZ4o9atN9QoppahyMy1Yl2a1g2BW24Eu5gwmwmxmnZl" +
           "gVS6RXNRbay6o/4CZSgrbGH9gAVBOk7m7U4QqDUuKFMyW2kUOD3WR0SXF1t6" +
           "GE8CjK8gLTmeLCw4hitByrfa45ncKovMbNTeKFLVpiS+tawZkjVS1LKayCUY" +
           "4+uohaJ1sWEYy2LLcUwmCGzYCyPUrPUFtYWxg7LJ+apSROvdyG9q9SXaXrtB" +
           "pzcapEWhMFSxwlpUqqtGuKj5g5prK1y/3mgR3HrM6RENb8wGGmNNDA42DkKT" +
           "miqWxLlIznjPZ0RPQSVznsroSlnOiMlgDDPDtGgoSgeN6wLSpq3xRoGbM7ta" +
           "7k/WdncpmZFawqJq07FX47rfWnZqg6g83diNVlEubZoMzExA+A3anu3G3Vm9" +
           "R8VMrQkjTS42iuNyY+qhzGi0dGaIInWNNAZH46LBDfwk5T215zXiuoZN652x" +
           "aeqOGqyW9jooThgdnuh+LNXEcUel+2GvRw/Gix5XRaeFmO9S0rzJdGkWH82T" +
           "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" +
           "5pP+4d2///qPP/3NPE/5P+ltXa6tIgAA");
    }
    public static interface ValueProvider {
        org.apache.batik.css.engine.value.Value getValue();
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1471028785000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1471028785000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "cP/30tX2dytqZ+DXc7YPv5SqfuBOXWrv");
        java.lang.String jlc$ClassType$jl5$1 =
          ("oQw8koFHv4f6euK0vh7LwOtiH3rVqduPR8Hz+pd3dRJswx654T729g6x+Esv" +
           "XLn74Rdm/znvsxzf871EQXcrgWmevN534vmi48qKnuvi0ra1kitx7xkfeuRW" +
           "IoGNA4CZ5HvXtthv8KFX3wwbYAJ4ErMAfnCfxfShC/nnSbwDH7q8wwOVePtw" +
           "EqUEqAOU7LGc3Ta8xQ7wgZcy34k+39O3/NlDB9sb8tfFT7zQG/z4t+of3V5X" +
           "BNvQNM2ogN8Vd227VznRrBP05C2pHdG62H3jt+/75KVnjjqH920F3kXSCdle" +
           "d/O+ErZ2/LwTlP7qw7/8w//8hS/mV+b+P/wU6P24MAAA");
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
          1471028785000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1471028785000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "zztS8qYQej7QTzctlq0Kn6ylf3BWLb0C");
        java.lang.String jlc$ClassType$jl5$1 =
          ("QMntail3M93iPafB/qWUvDuE7p77iuJc2zF+/qyQXwWkL+xCLtx4x0hv35aS" +
           "JzOuXzkN96+m5H0gW2W4TzP4+8+K/uVAxNou+trNNPhHTwP+8ZT8eghdFAHa" +
           "a9v7Q2dFfBkIf3kX8eWbbu/fPg3276TkN0PoBSns08z9yRth7tYu+NbNNPfv" +
           "n4b7Myl5Bpjbn4vZxqGTEX/6RoR3dxdx9+aYu3AA+4unwf4PKfl8CN2/Bxtt" +
           "t68D/wtnhf/jUDqk3cDHbyD8cwdfGW87poM/P00HX03Jl8J0v+c1gX/5rMBB" +
           "77XN7gJnb6anf/00uN9MyV+E0L0ZXDCKT7cgnoz6L8+K+kUAwGQX9eQGot5r" +
           "M73/zmmAv5uSb4fpPjYAOGhbiuBfBfXZs0L9+0Dq1+xCfc3NMXCWwre2TsG7" +
           "lUXB34TpDtUUL+roYbYB+irMf3tWzCUgvrCLWbiBmA8lsydPGq+eAx/xGdTn" +
           "nqaLe1Jy256zgy9VxQ+VdObY9ZWj2ti6/azaeAKIrO5qQ71J2kgFvStD9qLT" +
           "oD+Ukvv33J5VvHRj7TEX2HrgrKAfBZKZu6DNm+L2u3hfdhreV6Tksb00ziq2" +
           "u7wK7qWzwn0ESO7twvVuZpRXToNbS0kefKlncFuepzjH0RZ+VLTZNtuT993e" +
           "d3zv70523sPzbgD67P7oTtZNGxng1rX7gK3ORvr08lXZA/hkQTL9PbGRIWV7" +
           "dUqQlHRD6BZlEQlWcFLCuVV0XdBtOAe6fdVpuj1ZUDolaEqwlBApoY4JfwM6" +
           "xa3Rdd5NfkBlHbS3c6CxYUrGKZmG0G1zJcwmSK8/48lFYhAeOiTyc/rTX/jD" +
           "71x8y2YT6dEtsdk5od2ix8t9+UvnSneGl96VzZSeF4UgS+G34dCFIOUMoYev" +
           "feYoq2uz3/XOU538BQdOnjW/7+N7HnrxwEMzhlQf4pENtCcr4YqE2le4T375" +
           "yVo2DXhxqQc66I+Gu8egjk4KHpxJuHzkaNSJaroi/dXHf+6zj3xjfG925mWj" +
           "kVTa8srLpK7teupW5qnbWbz50OPXEHhXomwO84r0hvf93Re+/savfO4cdAsO" +
           "3ZHOJ6cjKNQJoZ1rHRU7XMGlIbhCQKnLOHTXprTuzPcUlxrwnv2n+7PKIfRj" +
           "16o72yx9bPI5PWxlubHiw260SYQvPjajHYEUeeht5grP+dFd4U0+9MQPoLx9" +
           "7NDuzz2Z0x/ao57umj780gOjlTbe4rgrQ57uXBm3WLQF453MxTzwchOC8Oo6" +
           "1pvoltwWfHkTNh/8/u2Pvfr+z70yC5urlfQjKubaHYG3ke/wqZnd7uUsmfMN" +
           "KfmplFxJSTpNu/X6m5A533Kddz/zI3Yzb07JW1PyNpA0NSHQ2q6cOubWXWfW" +
           "Szofu7UZF6bk7Sn52R9QLwercizo/hwh3ep/qoJ+/jrvfvEHVNBBwzsp17sO" +
           "VPXulPxCSp5KRXJDXc1m5K0zK+qfpSSbxk3PJG69NyX/9IdX1CF5r9PYL1/n" +
           "3b84s5L+eUp+JSW/GkK3b5TUsqwbo6cPp+Rf7uvp11LyoZsQaB+/zrt/9SMG" +
           "2sdS8omU/AYItNA9OAhVOLNefjsln8zqSq/+dUp+62b5z+9ef4T80EH3gabr" +
           "2X7kgWHEkaW8rWfO7GafSsm/TcnvhdD5WNDDG+Nhf5iSP9j3sHTqdetzN8jD" +
           "Dn0nwVlj/+6aDFufzhi+eJbh8B+n5N+n5E8OQJ1ZQV86qqD/mJI/u5GudmhK" +
           "AU65Np/Y154p3VXVV8/sUv8lJV9JydduoL7++1F9/beU/OUKjKNOOPy7F0Iv" +
           "/cHOD4NR1gNX/VOCzUF66WNPX7zt/qdHf5Ztd9g/7H47Dt2mRpZ1+HTroetb" +
           "PF9RNxOTt2f0ruzTeeubu0vzJ4kUQucAzb4yvrHh/l8h9PyTuAEnoIc5nwXf" +
           "08c5Q+hC9vcw3/8JoTsO+EDfu7k4zPJdUDtgSS//Oj1se/IAD7rnNCMe2m7z" +
           "2DW/aoho828irkgffxojX/9s7YOb07pglJkkaS3gs+HWzSaSrNJ0Q8Yj16xt" +
           "r65b+i//3l2fuP3xvQ08d20EPoinQ7K95OTtHR3bC7MNGclv3f+br/q1p7+S" +
           "nRj9//yRyhG9QwAA");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "pRckKAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "xRH0+E3/X7A/E6/96itX7nvbK8J/Kg+8");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("Xj+3fv8Ium+5cd3Tp8tOXd8TRsbSLnV3//6sWViqgTt6MD9PJJAZAC0kvzTd" +
           "cwvgifM8bsAJ6GlOCTypneUEj7jl92m+H0+gB074Euie/cVplg+C2QFLcfl8" +
           "eKzHU6fJ9ofxsv1Gw+On/a68zT58kRWvDzl9brbYHSv/D+R4J2uz/0+Q57Uv" +
           "vTKc/OT3G7+8P7eruWqeF7PcN4Lu3R8hLictdsOeuuVsx3PdQz77gwe/fP97" +
           "jrftHtwLfBIDp2R79/kHY/temJRHWfN/+bZf+5F/8soflMfp/j+aX6tZoDMA" +
           "AA==");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ZCwAAA==");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVYfWwUxxUfnz+wje2zDRiHYAPmQDKht6EJLZFpGmNsbHrG" +
           "J45YwhSOub053+K93WV31j47dUtStdBKRYg6CU2C/wlR0ioJUdWordpEVJGa" +
           "REkrJUVN0yqkUiuVfqAGVUr/oG36Zmb39uPOkFSqpZtbz7553+/33tyz11Ct" +
           "ZaJuotE4nTWIFR/UaBKbFskOqNiyDsBeWn60Gv/jyNV990RQ3QRqyWNrVMYW" +
           "GVKImrUmUJeiWRRrMrH2EZJlJ5ImsYg5jamiaxNolWKNFAxVkRU6qmcJIxjH" +
           "ZgK1YUpNJWNTMuIwoKgrAZpIXBOpP/y6L4GaZN2Y9cg7feQDvjeMsuDJsihq" +
           "TRzD01iyqaJKCcWifUUT3WHo6uykqtM4KdL4MXW744K9ie1lLuh5IfrhjTP5" +
           "Vu6CFVjTdMrNs/YTS1enSTaBot7uoEoK1nH0ZVSdQMt9xBTFEq5QCYRKINS1" +
           "1qMC7ZuJZhcGdG4OdTnVGTJTiKINQSYGNnHBYZPkOgOHeurYzg+DtetL1gor" +
           "y0x8+A5p4dEjrd+vRtEJFFW0FFNHBiUoCJkAh5JChphWfzZLshOoTYNgp4ip" +
           "YFWZcyLdbimTGqY2hN91C9u0DWJymZ6vII5gm2nLVDdL5uV4Qjn/1eZUPAm2" +
           "dni2CguH2D4Y2KiAYmYOQ945R2qmFC1L0brwiZKNsS8AARxdViA0r5dE1WgY" +
           "NlC7SBEVa5NSClJPmwTSWh0S0KRozZJMma8NLE/hSZJmGRmiS4pXQNXAHcGO" +
           "ULQqTMY5QZTWhKLki8+1fTtPP6ANaxFUBTpniawy/ZfDoe7Qof0kR0wCdSAO" +
           "Nm1JPII7XjoVQQiIV4WIBc0Pv3T9vq3dl14TNLdXoBnLHCMyTcsXMi1vrR3o" +
           "vaeaqVFv6JbCgh+wnFdZ0nnTVzQAYTpKHNnLuPvy0v6fHzzxPfLXCGocQXWy" +
           "rtoFyKM2WS8YikrMPUQjJqYkO4IaiJYd4O9H0DJ4TigaEbtjuZxF6AiqUflW" +
           "nc7/BxflgAVzUSM8K1pOd58NTPP8uWgghFbDB61FqOY84n/im6KDUl4vEAnL" +
           "WFM0XUqaOrPfkgBxMuDbvJSBrJ+SLN02IQUl3ZyUMORBnjgvZMuSsnpBGkil" +
           "xkZT43tAed2MsxQz/p/Mi8yyFTNVVeD0teGSV6FahnU1S8y0vGDvGrz+fPoN" +
           "kU6sBByfULQd5MWFvDiXFwd5cZAXD8iLDak6pgMQK10DxVFVFZe6kqkhwgxB" +
           "moJyB7xt6k0d3nv0VE815JcxUwMeZqQ9gb4z4GGCC+Rp+WJ789yGK9teiaCa" +
           "BGrHMrWxytpIvzkJACVPOTXclIGO5DWG9b7GwDqaqcskC7i0VINwuNTr08Rk" +
           "+xSt9HFw2xYrUGnpplFRf3Tp3MyD41+5M4IiwV7ARNYCjLHjSYbgJaSOhTGg" +
           "Et/oyasfXnxkXvfQINBc3J5YdpLZ0BPOi7B70vKW9fjF9EvzMe72BkBriqG6" +
           "AAi7wzICYNPnAjezpR4MzulmAavslevjRpo39RlvhydsG1tWidxlKRRSkGP+" +
           "51LG+d/88s93cU+67SHq6+spQvt8kMSYtXPwafMy8oBJCNC9dy757YevnTzE" +
           "0xEoNlYSGGMrS2+IDnjwa68df/f9KxcuR7wUpqjBMHUKpUuyRW7Oyo/grwo+" +
           "/2EfhiRsQyBK+4ADa+tLuGYw4Zs99aCuVODG8iN2vwaZqOQUnFEJK6F/RTdt" +
           "e/Fvp1tFxFXYcRNm660ZePu37UIn3jjyz27OpkpmHdZzoUcmYHuFx7nfNPEs" +
           "06P44Ntd33kVn4cGAKBrKXOE4yjiLkE8htu5L+7k692hd59lyybLn+bBSvJN" +
           "Qmn5zOUPmsc/ePk61zY4SvlDP4qNPpFIIgogbAiJJYjr7G2HwdbVRdBhdRir" +
           "hrGVB2Z3X9r3xVb10g0QOwFiZQBha8wE3CwGssmhrl3225+90nH0rWoUGUKN" +
           "AIrZIcxrDjVAshMrD5BbND5/n1Bkph6WVu4PVOahsg0WhXWV4ztYMCiPyNyP" +
           "Vv9g59OLV3hmGoLH7X6Gm/nay5atfD/CHj9FUT3OAECAssWS3/ixjpv4Lcje" +
           "RF1LjSx83Lrw0MJiduypbWKwaA+OAYMw5T7363+/GT/3+9cr9KE6Z+T0BLKm" +
           "0RVoGqN8lPOA672Ws3/4cWxy1yfpF2yv+xYdgf2/DizYsjT+h1V59aG/rDlw" +
           "b/7oJ4D+dSFfhll+d/TZ1/dsls9G+NwqUL9s3g0e6vN7FYSaBAZ0jZnJdpp5" +
           "1WwsRT/KojoMUX/Sif6T4aoRGF0xqwAP6ww7A1c9L51YsqOWmzAMQUVE5Gdw" +
           "OGABTNmQqklTKQC4TzuT7aeTR+VTseQfRXLdVuGAoFv1jPSt8XeOvckjUc9C" +
           "X7LfF3ZIEV9LamVLnCV4703uiUF9pPn296eeuPqc0Cc8loeIyamFb34UP70g" +
           "El/cXTaWXR/8Z8T9JaTdhptJ4SeG/nRx/ifPzJ+MOAi8l8KlP6+btOT0qlJx" +
           "rQz6UGi6+xvRn55prx6CmhpB9bamHLfJSDaYV8ssO+NzqnfZ8bLM0Zk1RBgW" +
           "t7hI1Qm3cw5w7OYVFzcvTn8wlBquls6hTjalztwl88F099joYFEmBqsvfpgX" +
           "+n6KWuAuIHiOY9UWM8dhx3nsC1NUM60r4jK4gy0p8WLn/4jXbGOXUQTJwfHY" +
           "VXvzxxuuIRadZTd2ccuUn1+M1q9evP8djnGlm2ATpHbOVlVfUPwBqjNMklO4" +
           "b5pEqzT415zjyUoqUVQNK9d8VlDPw2RciRooYfVTnoCwhikh8fi3n+6rFDV6" +
           "dIAg4sFP8nXgDiTs8aTh+nHHx7yk9DsdrhSIYlV5g9wh5s9bBN7X9DYGMIH/" +
           "AuOWjS1+g4Gry+LefQ9c/8xTYmCVVTw3x2/sUCxiLC7B/oYlubm86oZ7b7S8" +
           "0LDJreHAwOzXjacfVAmfLNeExjcrVpri3r2w8+VfnKp7G9DnEKqCKlhxyPf7" +
           "h7jswwxoQ789lCgHBWiRfK7s631s9t6tub//js8eDoisXZo+LV9++vCvznZe" +
           "gPlz+QiqBXgixQnUqFi7Z7X9RJ42J1CzYg0WQUXgomA1gDgtLNkxq2buF8ed" +
           "zaVddpOhqKccRcvvfzCnzRBzl25rWQezlns7gZ+G3M5pG0bogLfjaxxEoIuY" +
           "+avTiVHDcO8AtbsNjg+5MKbxTX76Mf7Ilsf/CyHdHgedFQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "JxXdm/BKy4/RxO/4/YrXLcviRBsPYixr8WRnVR8TEtfvsZNKZTUgUDmhZUul" +
           "NAoZarwnUjzN2+DpeCJRrNdtSfJoOTSHXT0Jpa1Zaseg/K+YfrgpZ80SXg8Q" +
           "rbMItdKaizs0SU7LJMl2W7bgE/QSt+o0YQXW1NjKTGQNfV5izQCxA4mcyuqG" +
           "0ea2y1MrqWqxWIXAknJ7Sm9cubHu9eqmW/UYsa0x9URExgsPruiyMMLdqubZ" +
           "VcJMutU2IlX7Ni650nCMIXWuunJJosKU52Fqy302mjRxnMs00cbLYV3rVKam" +
           "xDoEOml1RKXOTgiHHrkpP5la5Um5z/lbmR64SpNlOrA1kWmX4lx7ggSzMTvD" +
           "uyo1FJjxih9I9bHMT60+s7SbpYrBx6NRA2eVjBRafODZSrqBZaPt6+jYN8pL" +
           "rpwS2gQfsm6FHvV66Gzhi+Ox3RORaa+llkfrGo+tVzXNqSA8y2gzv+UxXWKw" +
           "4dVoNrAr65Cr+WtFV1YiuW7Qc8K0SqlHanLZ83hxO8YlPuh3WY9JRutNed0w" +
           "utttNjKYGUH56ng23YSxT276g+p00pTsZTgYCeMFvZKWQ6Sn2LSkIUOsW27T" +
           "CG+bSmceLxI5Ixu4vRIMZ+qpKNzKDMfExa0wGTT7lWCo1ZssPxo1k6lpWuS8" +
           "3WpUyNVQaiIebLuNfltwkHUH95gpOSjPhJUyDEfG0mxlg6Q9X9OTVkiXJgxb" +
           "rvbGglOTN8JgyLW8hbmWB8kk8oIWtbSdbCnzSC3Gda06iLLxFg7ggd3cbEie" +
           "FUW9XY51aiI2SMXyhMqkCcSm2msq3JaMkc8uhUbUam0MYCutPpiS67Y9I1Ot" +
           "rsr4rN20mbaybATmYNyvlNuZSIqkrDeWq6WVmlnL9elNC83ixrKs1bx1Wew0" +
           "K3VazYR0oMurMWbOkS1CUQRR4oLSlEab2IbqY7FuK4TSosLuIJxmmzjorbdL" +
           "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" +
           "FRZLIAAA");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "m5U9poCG6dL4heNPxCMOL/4X0G+vEAYYAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "mZ9Q/y/otZn15CIAAA==");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "aDir+0wBDtPlEQzHn4lHHJ77L+vTFVYKGAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALU6e8zrVn2+X++9vb20vbctlK6j78ujBH1O4jx3GcOx4ziJ" +
           "49hx4sQe4+L4ETt+xo/ENiuDCkY1pIJGYUyD/rMiNlQem4Y2aWLqNG2AQJOY" +
           "0MYm8dA0NDaGRoXGprGNHTvf+363ULF9Uk5Ozvn9fuf3Pr9zzvfsd6FzgQ8V" +
           "PNdKFpYb7qpxuLu0qrth4qnBbo+qMpIfqApmSUEwBmPX5Ic/fekHP3yffnkH" +
           "Oi9Cd0mO44ZSaLhOMFID11qrCgVdOhxtW6odhNBlaimtJTgKDQumjCC8SkEv" +
           "OYIaQleofRZgwAIMWIBzFmD0EAog3aY6kY1lGJITBivobdAZCjrvyRl7IfTQ" +
           "cSKe5Ev2HhkmlwBQuJD95oFQOXLsQw8eyL6V+TqBP1CAn/qNN1/+/ZugSyJ0" +
           "yXC4jB0ZMBGCRUToVlu156ofoIqiKiJ0h6OqCqf6hmQZac63CN0ZGAtHCiNf" +
           "PVBSNhh5qp+veai5W+VMNj+SQ9c/EE8zVEvZ/3VOs6QFkPXuQ1m3EhLZOBDw" +
           "ogEY8zVJVvdRzpqGo4TQAycxDmS80gcAAPVmWw1192Cps44EBqA7t7azJGcB" +
           "c6FvOAsAes6NwCohdO8NiWa69iTZlBbqtRC65yQcs50CULfkishQQuhlJ8Fy" +
           "SsBK956w0hH7fJd+/ZNvdUhnJ+dZUWUr4/8CQLr/BNJI1VRfdWR1i3jra6kP" +
           "Snd/9okdCALALzsBvIX5w19+/o2vu/+5z29hfvYUmOF8qcrhNfmZ+e1ffgX2" +
           "aPOmjI0LnhsYmfGPSZ67P7M3czX2QOTdfUAxm9zdn3xu9BfC2z+ufmcHutiF" +
           "zsuuFdnAj+6QXdszLNXvqI7qS6GqdKFbVEfB8vkudDPoU4ajbkeHmhaoYRc6" +
           "a+VD5938N1CRBkhkKroZ9A1Hc/f7nhTqeT/2IAi6HXyguyDo7Feh/G/7HUIC" +
           "rLu2Ckuy5BiOCzO+m8kfwKoTzoFudXgOvN6EAzfygQvCrr+AJeAHuro3IQcB" +
           "rLg2jHHccMDxHcC86+9mLub9fxKPM8kub86cAUp/xcmQt0C0kK6lqP41+amo" +
           "1X7+k9e+uHMQAns6CaEqWG93u95uvt4uWG8XrLd7bL0rHV9VHQzYynUA49CZ" +
           "M/mqL83Y2JoZGMkE4Q4S4a2Pcr/Ue8sTD98E/MvbnAUazkDhG+dj7DBBdPM0" +
           "KAMvhZ770OYd/K8Ud6Cd44k1Yx0MXczQmSwdHqS9KycD6jS6l9797R986oOP" +
           "uYehdSxT70X89ZhZxD58Usm+K6sKyIGH5F/7oPSZa5997MoOdBakAZD6Qgm4" +
           "Ksgq959c41jkXt3Pgpks54DAmuvbkpVN7aeui6Huu5vDkdz6t+f9O4COfw7a" +
           "Nsd9O5u9y8val269JTPaCSnyLPvznPeRr/7lPyG5uvcT8qUjWxynhlePJIGM" +
           "2KU83O849IExcBIA97UPMe//wHff/Yu5AwCIR05b8ErWZg4FTAjU/K7Pr/72" +
           "G19/5is7h04Tgl0wmluGHG+F/BH4OwM+/5N9MuGygW0A34ntZZEHD9KIl638" +
           "qkPegBtbIO4yD7oycWxXMTRDmltq5rH/demVpc/8y5OXtz5hgZF9l3rdjydw" +
           "OP4zLejtX3zzv9+fkzkjZxvaof4OwbZZ8q5DyqjvS0nGR/yOv7rvNz8nfQTk" +
           "W5DjAiNV87QF5fqAcgMWc10U8hY+MVfOmgeCo4FwPNaOFB7X5Pd95Xu38d/7" +
           "k+dzbo9XLkftPpC8q1tXy5oHY0D+5SejnpQCHcBVnqPfdNl67oeAoggoyiCd" +
           "BUMfZKD4mJfsQZ+7+e/+9M/ufsuXb4J2COii5UoKIeUBB90CPF0NdJC8Yu8X" +
           "3rh1580F0FzORYWuE37rIPfkv24CDD5641xDZIXHYbje859Da/743//HdUrI" +
           "s8wp++0JfBF+9sP3Ym/4To5/GO4Z9v3x9VkZFGmHuOWP2/+28/D5P9+Bbhah" +
           "y/JeBchLVpQFkQiqnmC/LARV4rH54xXMdru+epDOXnEy1RxZ9mSiOdwNQD+D" +
           "zvoXDw3+aHwGBOK58m59t5j9fmOO+FDeXsmaV2+1nnVfAyI2yCtJgKEZjmTl" +
           "dB4NgcdY8pX9GOVBZQlUfGVp1XMyLwO1dO4dmTC723Jsm6uyFtlykfdrN/SG" +
           "q/u8AuvffkiMckFl955/eN+X3vvIN4CJetC5daY+YJkjK9JRVuz+6rMfuO8l" +
           "T33zPXkCAtmHf/sr/zUvHfovJHHW4FnT3hf13kxULt/MKSkIB3meUJVc2hf0" +
           "TMY3bJBa13uVHPzYnd8wP/ztT2yrtJNueAJYfeKpX/vR7pNP7RypjR+5rjw9" +
           "irOtj3Omb9vTsA899EKr5BjEP37qsT/+ncfeveXqzuOVXhscZD7x1//9pd0P" +
           "ffMLp5QaZy33pzBseBtOVoIuuv9H8YI23UzieKI5aWGznMOtSgvdzCrzvk7X" +
           "iJ4/oscKgwoC43XmkTDtlrzhcF6uRpVpvVCMIoQpl0WuM+p6m3480Tm9yxFS" +
           "yDlib8oJxmq0LnXbJYKQ9K7li+yEnpg+15+U++sSik96fbjWCgthfYBECOlM" +
           "ShzNaQpC1wc2rKnrLqzZdYWZGSQfmpOaLddxje6Ziq/PqkVmElhmsrLIObII" +
           "U1mdjjjHC+HCTFEqo27K6V5itepsv12ulYai5Y/IhPX4MHV4Yjpfi0bSG1aE" +
           "QFzSvkNSfLGt9KKyj4jFEs3zbEHAWLHtxmy/KEp9VZ3agR6Xosam0hkROM71" +
           "sHbRmFYYihmTnNta2l57rVa4DqNaEjuI1v1gaXnGqGxWUo6r1NypIZnlesOa" +
           "V1vzcRGbj+2AxKkBjLfqM3q5sMrxWJrZHZweNJD1LC2MpFHbnrZHJUTFDZUR" +
           "VFFfS8P2usNRg3q5FsU+We5q3dIkDnQMT9vObN7BiuiiuxRwdmNbSj/ECqZq" +
           "V+c0y8aFNjFeTu3FwotBOcbEfXaajj2wM4yHm35nOizLM7vQKa4qKweUu8FQ" +
           "7eFhcTRk5n24Kqi8R9oTur+uDfqr5aLVlfVugrG8Wd5wcV1KqZ65Gpo8qzh4" +
           "SlOe6NaqM6OW8vPxMJpUZRJuUbghDqqmJVKrMrqEsbKUyJtF2VepZIJhS2eG" +
           "8H0XqKoWU4jP9NvaeMG0avGMHbf9EUdGDlbihdpKrXZGltzW4iVR0looJUQG" +
           "TqkDwTVWmUslLK2bRiecjc1pu8uMi7RHTzqtPk4k827VlvrhWFoNimOOEops" +
           "p9adm20L57EJsyDMurQoc1gb0b2p3KLIdVMuzxGr0CGaXlwxCKmVmoYp1fwG" +
           "SzuTDh2V9P5UiBN0WA2mBF7vdGpVxvHaGIEircrCWrIwHPl8lIplx2mKxTCW" +
           "dVvYyCLqMf36oOd56iyuh+vVgCtJixLOh0QVDoeU3wsSwvESMUIH7ahPku14" +
           "Riwa64I6a8ZpE9XCuUGPETP2iSLZE40+PY1lQ1oFUkBOYoeIJkF5Aq/sXm1g" +
           "rPlCsMBUoeYPq8N40bcnKWIWVjRO8EJlCQv97iRoo+OSPExXK3Ww8emeOhEa" +
           "1WIJ41p0IwEuvgorRsWgwb5oOuayk1DtLr9aRbX2yE5wPIFJlmxzQiscVNvt" +
           "EVMSYlxMCHe0iCmca7NebHbI4cKm5qbEjZYTjtQ3MqmbSnnB9DuELLCDtDms" +
           "OmajLPV7xsLdFNa9RWJHLDUOaEq2g4jsrsIagtRCJubLk4rAuhU6IsxBY0Fx" +
           "iAUyTWPQCLoLqpCMS/UZLpgJs1g1BuSIdYgRj9Xs3oStu6KDA3uz1Uq5iTa1" +
           "YSFCm7TfNzqFtGuuAhzj/DXJO5JBYexksUzWTllfObwFS81Ov8sP+G6nxFdA" +
           "hAsjX5QkFnVFOe1VBKHNYxwy6KcJgUqB1JP0ABsvitaG2EQEJ1U2KVaQq1M1" +
           "1SeYPrf72CgSws5UQ3oFZTBuVmBZKUddnUlKaJufopVUbxpEu4H1OAWkY7eV" +
           "alV7OENSGGm0SHzE0prMOZO411fUrlDazBdd21CjOaETTqUIa7URZVPFYbHn" +
           "jROsgm6C2gJvwUKzxaGdRpPDNsqww0tTydcnAdlupqVlR8eDJeoLvI4IYhTr" +
           "GMpOiKrTLJTxNC2tYFj2oo3Ybzdocr0qLPElM6p2WVsMUSeWEGEpY0mbUloK" +
           "gyOI73Jrsulam1Z3Vaqyo3JFWOq4Umlhab3SWHUQpG4W1YQ09SXqKJII4lhX" +
           "rCChKklaQPEK32CKjKYTPbndNThrPVnMeX7Eb9KJptf4FOn2N4DkLC4iUgnv" +
           "9V3P4oSibjhFvyCW7Gq9WYDb09qsTYsLtxXAJMikadWuSyO3BkdwWXUEYqgL" +
           "Xb40Vg2OU3S1SlKqZFnF9nrWRWC4Y5iK5trqAkVxtxy5k3aq9/W23W0MCVsQ" +
           "wnk80+vCsJgO+0m6npJRmoyZMWdEDrXczCKmqyZNmVD8ml/qqaVNkw2Kcsdc" +
           "sxjGBLIpDLQSQpQMwVkWl6kb4FyXH0eewxJ2WIU1WJxM61pcauNBX9AnqDBb" +
           "s2iYDgo1qudKVbVBhdqaWpqbYcT36BFZW07x3jpyE9ziWg1yWEdjdB7WGxur" +
           "xJmCJXWIVZuZGD194tpFNPATOELocphUxI7nJGkTbGnpoKq0xd6KixslVY/W" +
           "RLmL4CPdrhaYZU+jCWHhizFpM1WQ/c0YGIAgSdJ2kEWpHScNhqAby/mouoKb" +
           "6xlW0tQVAiOVUGNcxq+yHrOcDRllwE+7TqL1eIOlU21GcbUyOU6WKRxyNlzv" +
           "tydYNfXWE3S+gYtuZSNIVXZccBMzYGByJiLLIG2lFQwB8VzGqW5jHeDjei0R" +
           "6qVkYLDRKqZWXFKrwmaxOVtF2KS7bvl8SgqF3sAtGnw4ma2VWmvGV8gZlfrq" +
           "OtYHBOsMut5oU8NKUcwvbF+jA4eVe6NIFEEyGM4KfZMOkApG80lg6UWZ6fcC" +
           "Rx57K1VnujPSHFNB0WlM9bSYpJTWWMI2iKRwAKKZZUgh9d2ZHg0btRipIqQL" +
           "bNVqtCPRoti2KjebUSyNah2UD/khKbtx4oao0dkorEOVzFl33CjAK5amh7PO" +
           "vGtXy2WQK9X1oD9IiWk8lUY0KldWggbibZR0kq7W8Ft1x6uLE59m1YGq+Aad" +
           "eMOyEkybmmZ6Bku1CGyEpTWe0QpYqwH3xm206ZA+V/K8eVwXsYZDd5BWVwCM" +
           "kG6hP+2RSBVmyJkTGRxDsmZNbs5ojp7WXG6syLWBzFMWuaktZ2TUVCIT7KzS" +
           "FB+E49miUm2xvSEHz7DBFI9kjl4UBJin8VZ17PmrNsyNYIXvSLjXCeHumqLN" +
           "scysDRH1R+IoRBcWuWCJkOHlGuupmxGMNzYJH8Xuyg14aqNTkTar0B6Dh7My" +
           "XCgIdjlZVtAmUuXsJsOzqTN1YBZH0G49uxyoUnOJCjfVQtQq4cSKx4VJTZ2x" +
           "Ks3TbGKuJzEFj1WZTNZrqqrPGiV2hmJ6Yg07RocseJi4wMDhmQY7O5zCGLVo" +
           "9IpIQVklbBUU/jN8QIIa0FUnAxMpu+640SiWkpoSaSE94WvUPK5I3daIG06Q" +
           "NBqQvqn7Y8GweLtPtGZBadDQhgKaphY/7JttU9IL0pArLOKiEE3dxajXoQo8" +
           "gqJT3Bq28IYaWYWkitom2NqxjbbGxhpaqKILt+mkQldhQMVIMbHcbPcL7pot" +
           "9/xU1YzhWk2qcwkpL/qlOkLMu2avBFdYsdEIymukIkWaZsXlUcXreDWJTYpU" +
           "F1dsnJAa81VBM/moxQd1pq6Gg1RRg3536Pipn9QMxcCNlhKCUg/1yy2E4KNO" +
           "WFaRNYP5NdFFULqOmKzfT6Re0/GUsBEUObq1qUZDLTSqvIESKT1qgYoMRoRq" +
           "rzifwHBlPV+6Q8+ItU69FpGUXqfK8FAxY6yBDDdOlcO1JdMAdeXMnyLjgle3" +
           "8V60FHudklqnFxUfHYGtDC9j0oDuerxF60RDlZcyL857QXXK05JnehpttsaD" +
           "QSeYT8ThOHXZUMGUxrxMKlTfYWxVWrBItEQVa1l0wL7WRIsDcYnWRFHCDb9Q" +
           "3LTwkLHabEo6FYske/U6VViPQfXU74BjU3acetOLO9HekR/eDx5WwEE2m+i8" +
           "iJNcfPqCZ0LoFs93Q1UOVSU+uMnM73Rue4GbzCO3PVB2bL3vRg8p+ZH1mcef" +
           "eloZfrS0s3dLNg2h83vvW8dvjV5747P5IH9EOry6+dzj/3zv+A36W17E5fQD" +
           "J5g8SfJ3B89+ofMq+dd3oJsOLnKue946jnT1+PXNRV8NI98ZH7vEue9Arfdk" +
           "6noQqPNre2r92ukXxKebKuuqW494gRvI8AXm1lnjhtCFhbq9xNq//Hn1qU8Q" +
           "qrMwHHU3v6/ZPYTPfc37cbcGR9fOB6wDNVzKBneB+N/aU8O3XqwaXnOqGs4c" +
           "AnRygMdPB9iX+p5M6g0i528t+HDQjmXVy3woR35n1jwWQhcDNcSAMwOPzBFH" +
           "R0KND6Gza9dQDvXytp9WLxjQx/f39PL9/xu97OQAO6dxfw6c5P1T5TqnWa4U" +
           "5vTef2M9vysH+K2seTKEbgOqIjK03FmywScONfPeF6OZOIRuP/7etW+0V/1k" +
           "r2Ugmdxz3RP89tlY/uTTly68/OnJ3+QPRAdPu7dQ0AUtsqyjt7FH+uc9H+yS" +
           "ubi3bO9mvfzrmT0/Oo2lELoJtDnnv72F/lgIvfQ0aAAJ2qOQHw+hyychgVXy" +
           "76NwnwAeeggHEuu2cxTk04A6AMm6v+ft6/EnfXXM7XlghfjM8cx/YN07f5x1" +
           "j2wWjxzL8vn/U+xn5Gj7HxXX5E893aPf+nzto9vHMNmS0jSjcoGCbt6+yx1k" +
           "9YduSG2f1nny0R/e/ulbXrm//dy+ZfgwmI7w9sDpr01t2wvz96H0j17+B6//" +
           "2NNfz++o/xdmza2M6CIAAA==");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "mhwbZisDGBt/wh/Z8Px/AYL5RKYIGAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "+snnvpFfT/8vEvVtTeIiAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hqugqOeikjzh8ypwdWYXXvfWlMH4Sm17dPJDS+/Z/wZXUcPuYzrnr8BNIscl" +
       "86De9Qr3v3zRz+/5+m3DdliwMNgV+vimfNyh9l3/23/kQc6dYIGQxcffEz90" +
       "17SWy97j/K43Qu6mTP7GBh7d5f30/am/Rhsrno6Syh5SL4sgmisY2HgPBI6W" +
       "E1lDoJ3TnhsE2hFPc9bbzvB7Qs+wfj/obqjwjtT4XutzfWNxCRfBc6HwChf6" +
       "XV+E8JcrOMtZvFyExbmOpxltmDqDWdKkz9nUhnTLSO2Q196w8kLby2J5CRYJ" +
       "u79LA9WyNV+MZjFec4AY620xsFibP9sgbkYqByUtCeGg41QuOUOn0s79nsw1" +
       "b7XdhU/KDUVKeTY8gtT+LCDl1aFSBnEzUmPCcQz2FV2j4swHop5/hqKu8/D6" +
       "ZNxUpIyL4WkVs2wNkLE/VMYgbkbGDsBOq+VJueQMpVyVw+2Tc+C/0Ng1YqZr" +
       "AuTUQ+UM4gb76gPzyhPzTDfD5V5mn5RGkVI2wtMh5tkRIGUmVMogbnA+iizz" +
       "GVuwj8x09xEMn7vSfRZbJw3zA2yvfNVZ9ZOaLv6o0d5IZhWg9Zx0dx/9QU/P" +
       "WfWyTdxYqOPcE+6991TJr6d+/I7NMLUAg0038d74Td2/3PwCDxar8ASx3nHN" +
       "nvMBnDQ8kWp9FhE0DLIEnvsEIvyTkav+x8McsKXiTEkpsOesV1I0iekjlEEc" +
       "FkvaPw9zckIAd9G+u0Vd9v5n7r7UhnVuwO7v0j/2ubde3LftyCE7NEV4GTkn" +
       "KOGVn2XDk8r8kNOWqyB/XXXJsXff7r46KuLBsVhcn3HsrFC4ik27suFTJHsi" +
       "nZCrLHb/K75S9/iehrKVcBhqI1VpTbk2TduSubt6pZXu82iPm91xd3qhOqfh" +
       "LwLPv/FBlcEKW3UaWkSmY0421QERGrYzElkErz7r3xpi/R4rPiers/yvgois" +
       "hvPpPXi40eAoB78p6KeGz5e5a7KGBmKOZypIgD5s3arlOQTTC/TQ1tKSQzOz" +
       "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" +
       "gxvy7sIhPSouv6u7G98u+g/lj4VtwTkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xBHkkUfKj+Y42wn98Svx75XHY9Ohbo9HpoP5Atxn3Nn97ceC0V2ZlF8PrtrO" +
       "T2vHg9FeIb9p5FUeyemljPzQvu9fcH0nBKNU5J37fx/87IHr77Iray57sJ2w" +
       "72ntsoaHr6QNLpjM7owPe0PWSGkbAzOKZKS5bRu9ptG86WpIj+8gPX4NSINr" +
       "QMpu8VxOnbBwfinYMhjwvn//8PP0byoPQVJucr1tE8cgkS8Q0mvBtWPd/j4B" +
       "Evd8IN3hgzUF0INjK7uFC8AFP09c40N1jwGavEBAbwAXvgOEXwPQ254PoLs0" +
       "MJ3ZV0GqPk9I3SO1j4F6+/+H4fV3oPrXAKU+H1B3isAlrsL0fKeX5uHKxyBp" +
       "LxDSq8E13EEaXgOS83wgXdAlKR9eACL5I9eI5GNhnS+onpB+ffS1L304ffbj" +
       "24lfFMCKoVC81tr86tcDWR742Cm57MGq7a+6P/zcn/7X6dvO7WbbFx3Ff99p" +
       "+PcVc1LGkBVtjgnfva7wc2EleyCy3lK5jF7OI+GTJ4v3puz2tSD9CvL3AKCG" +
       "qtuCuS/v+1amdGk/4k5BDAOx6NLKRPfHfHc+5myiubxdTB8ba+d5jxXo866D" +
       "xkgHrMt/8hvv/72fevSrQHn9wi15fAf6ONQjHWWvKv7xxz/w4Iue/tpP5tkk" +
       "sJfpU4/9eb7we89piDPyzoy8ax/qAxlUNl+KkUIQbqOvIudoT80aGF+3QJ4c" +
       "79bh0JP3fNX42W/+0naNfTxFOMasvOfp937/8vuePnfozcajV71cOFxn+3Yj" +
       "H/SdOwkf9oQTeslrdP77s09++heefPd2VPccXafjdmT90h/+7e9d/uDXPn/C" +
       "QvFm07kBxYb3FnpIQDT2f8ipqMCjSXlsQdEGZ0ZGv6WQ9WWzyeHw1O14Jdxf" +
       "NtrN9sToV5ubNq4rKV23Gyi1RqRU5oWuPe45xcnUG83mNXgEad2ibjVRbLDq" +
       "NFN4UgzalTIuqTXPFgSjmJieV/ZrdFhTVTkSqXSIBulCDqPUtVADjiAUQ1FI" +
       "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" +
       "2ExVFSNdFIvrEloe1eG0pndBoknEcHG1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "r933K2/6+Wf+JP8o5v8BiqziDxdFAAA=");
}
