package org.apache.batik.css.dom;
public class CSSOMSVGPaint extends org.apache.batik.css.dom.CSSOMSVGColor implements org.w3c.dom.svg.SVGPaint {
    public CSSOMSVGPaint(org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider vp) {
        super(
          vp);
    }
    public void setModificationHandler(org.apache.batik.css.dom.CSSOMSVGColor.ModificationHandler h) {
        if (!(h instanceof org.apache.batik.css.dom.CSSOMSVGPaint.PaintModificationHandler)) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        super.
          setModificationHandler(
            h);
    }
    public short getColorType() { throw new org.w3c.dom.DOMException(
                                    org.w3c.dom.DOMException.
                                      INVALID_ACCESS_ERR,
                                    ""); }
    public short getPaintType() { org.apache.batik.css.engine.value.Value value =
                                    valueProvider.
                                    getValue(
                                      );
                                  switch (value.
                                            getCssValueType(
                                              )) {
                                      case org.w3c.dom.css.CSSValue.
                                             CSS_PRIMITIVE_VALUE:
                                          switch (value.
                                                    getPrimitiveType(
                                                      )) {
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_IDENT:
                                                  {
                                                      java.lang.String str =
                                                        value.
                                                        getStringValue(
                                                          );
                                                      if (str.
                                                            equalsIgnoreCase(
                                                              org.apache.batik.util.CSSConstants.
                                                                CSS_NONE_VALUE)) {
                                                          return SVG_PAINTTYPE_NONE;
                                                      }
                                                      else
                                                          if (str.
                                                                equalsIgnoreCase(
                                                                  org.apache.batik.util.CSSConstants.
                                                                    CSS_CURRENTCOLOR_VALUE)) {
                                                              return SVG_PAINTTYPE_CURRENTCOLOR;
                                                          }
                                                      return SVG_PAINTTYPE_RGBCOLOR;
                                                  }
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_RGBCOLOR:
                                                  return SVG_PAINTTYPE_RGBCOLOR;
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_URI:
                                                  return SVG_PAINTTYPE_URI;
                                          }
                                          break;
                                      case org.w3c.dom.css.CSSValue.
                                             CSS_VALUE_LIST:
                                          org.apache.batik.css.engine.value.Value v0 =
                                            value.
                                            item(
                                              0);
                                          org.apache.batik.css.engine.value.Value v1 =
                                            value.
                                            item(
                                              1);
                                          switch (v0.
                                                    getPrimitiveType(
                                                      )) {
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_IDENT:
                                                  return SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR;
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_URI:
                                                  if (v1.
                                                        getCssValueType(
                                                          ) ==
                                                        org.w3c.dom.css.CSSValue.
                                                          CSS_VALUE_LIST)
                                                      return SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR;
                                                  switch (v1.
                                                            getPrimitiveType(
                                                              )) {
                                                      case org.w3c.dom.css.CSSPrimitiveValue.
                                                             CSS_IDENT:
                                                          {
                                                              java.lang.String str =
                                                                v1.
                                                                getStringValue(
                                                                  );
                                                              if (str.
                                                                    equalsIgnoreCase(
                                                                      org.apache.batik.util.CSSConstants.
                                                                        CSS_NONE_VALUE)) {
                                                                  return SVG_PAINTTYPE_URI_NONE;
                                                              }
                                                              else
                                                                  if (str.
                                                                        equalsIgnoreCase(
                                                                          org.apache.batik.util.CSSConstants.
                                                                            CSS_CURRENTCOLOR_VALUE)) {
                                                                      return SVG_PAINTTYPE_URI_CURRENTCOLOR;
                                                                  }
                                                              return SVG_PAINTTYPE_URI_RGBCOLOR;
                                                          }
                                                      case org.w3c.dom.css.CSSPrimitiveValue.
                                                             CSS_RGBCOLOR:
                                                          return SVG_PAINTTYPE_URI_RGBCOLOR;
                                                  }
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_RGBCOLOR:
                                                  return SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR;
                                          }
                                  }
                                  return SVG_PAINTTYPE_UNKNOWN;
    }
    public java.lang.String getUri() { switch (getPaintType(
                                                 )) {
                                           case SVG_PAINTTYPE_URI:
                                               return valueProvider.
                                                 getValue(
                                                   ).
                                                 getStringValue(
                                                   );
                                           case SVG_PAINTTYPE_URI_NONE:
                                           case SVG_PAINTTYPE_URI_CURRENTCOLOR:
                                           case SVG_PAINTTYPE_URI_RGBCOLOR:
                                           case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                                               return valueProvider.
                                                 getValue(
                                                   ).
                                                 item(
                                                   0).
                                                 getStringValue(
                                                   );
                                       }
                                       throw new java.lang.InternalError(
                                         );
    }
    public void setUri(java.lang.String uri) {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            ((org.apache.batik.css.dom.CSSOMSVGPaint.PaintModificationHandler)
               handler).
              uriChanged(
                uri);
        }
    }
    public void setPaint(short paintType,
                         java.lang.String uri,
                         java.lang.String rgbColor,
                         java.lang.String iccColor) {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            ((org.apache.batik.css.dom.CSSOMSVGPaint.PaintModificationHandler)
               handler).
              paintChanged(
                paintType,
                uri,
                rgbColor,
                iccColor);
        }
    }
    public static interface PaintModificationHandler extends org.apache.batik.css.dom.CSSOMSVGColor.ModificationHandler {
        void uriChanged(java.lang.String uri);
        void paintChanged(short type, java.lang.String uri,
                          java.lang.String rgb,
                          java.lang.String icc);
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
           "HwAA");
    }
    public abstract class AbstractModificationHandler implements org.apache.batik.css.dom.CSSOMSVGPaint.PaintModificationHandler {
        protected abstract org.apache.batik.css.engine.value.Value getValue();
        public void redTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      text +
                      ", " +
                      getValue(
                        ).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
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
        public void redFloatValueChanged(short unit,
                                         float value)
              throws org.w3c.dom.DOMException {
            java.lang.String text;
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
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
        public void greenTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ", " +
                      getValue(
                        ).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        item(
                          0).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
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
        public void greenFloatValueChanged(short unit,
                                           float value)
              throws org.w3c.dom.DOMException {
            java.lang.String text;
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        item(
                          0).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
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
        public void blueTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        item(
                          0).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ")";
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
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
        public void blueFloatValueChanged(short unit,
                                          float value)
              throws org.w3c.dom.DOMException {
            java.lang.String text;
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        item(
                          0).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ')';
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
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
        public void rgbColorChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text +=
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ) +
                      ' ' +
                      text;
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ) +
                      ' ' +
                      text +
                      ' ' +
                      getValue(
                        ).
                        item(
                          2).
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
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      rgb +
                      ' ' +
                      icc);
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ) +
                      ' ' +
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
                case SVG_PAINTTYPE_CURRENTCOLOR:
                    textChanged(
                      "currentcolor");
                    break;
                case SVG_PAINTTYPE_RGBCOLOR:
                    textChanged(
                      rgb);
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
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
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
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
                        getValue(
                          ).
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
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    sb.
                      append(
                        cp);
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
        public void uriChanged(java.lang.String uri) {
            textChanged(
              "url(" +
              uri +
              ") none");
        }
        public void paintChanged(short type,
                                 java.lang.String uri,
                                 java.lang.String rgb,
                                 java.lang.String icc) {
            switch (type) {
                case SVG_PAINTTYPE_NONE:
                    textChanged(
                      "none");
                    break;
                case SVG_PAINTTYPE_CURRENTCOLOR:
                    textChanged(
                      "currentcolor");
                    break;
                case SVG_PAINTTYPE_RGBCOLOR:
                    textChanged(
                      rgb);
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      rgb +
                      ' ' +
                      icc);
                    break;
                case SVG_PAINTTYPE_URI:
                    textChanged(
                      "url(" +
                      uri +
                      ')');
                    break;
                case SVG_PAINTTYPE_URI_NONE:
                    textChanged(
                      "url(" +
                      uri +
                      ") none");
                    break;
                case SVG_PAINTTYPE_URI_CURRENTCOLOR:
                    textChanged(
                      "url(" +
                      uri +
                      ") currentcolor");
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    textChanged(
                      "url(" +
                      uri +
                      ") " +
                      rgb);
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      "url(" +
                      uri +
                      ") " +
                      rgb +
                      ' ' +
                      icc);
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
          ("H4sIAAAAAAAAALVaDWwcxRWeO//EduKfOHESQuz8mRSH9I4Q0oKcAvbFJqbn" +
           "2IoTSziAs7c3d954b3fZnbPPhvDXH9yWRgjMT2lJVSn8tAKCKlCL+FFSpACC" +
           "UgFpKaX8qK3U0DYioSqVCi19b3b3dm/v9o6reifdu73Z9968982b92Z29pFT" +
           "pMbQSQdVWIjNaNQI9SlsWNANGo/IgmHshrZx8Z4q4e/XnNx5cZDUjpGmCcEY" +
           "FAWD9ktUjhtjpF1SDCYoIjV2UhpHiWGdGlSfEpikKmOkTTIGUposiRIbVOMU" +
           "GUYFPUoWC4zpUizN6IClgJH2KFgS5paEe7y3u6NkkahqMw77Chd7xHUHOVNO" +
           "XwYjLdH9wpQQTjNJDkclg3VndHKepsozSVllIZphof3yVguCK6Jb8yBY93jz" +
           "x5/cPtHCIVgiKIrKuHvGLmqo8hSNR0mz09on05RxLbmBVEXJQhczI51Ru9Mw" +
           "dBqGTm1vHS6wvpEq6VRE5e4wW1OtJqJBjKzNVaIJupCy1Axzm0FDHbN858Lg" +
           "7Zqst6aXeS7edV54/p5rWn5aRZrHSLOkjKA5IhjBoJMxAJSmYlQ3euJxGh8j" +
           "ixUY7BGqS4IszVoj3WpISUVgaRh+GxZsTGtU5306WME4gm96WmSqnnUvwQPK" +
           "+leTkIUk+LrM8dX0sB/bwcEGCQzTEwLEnSVSPSkpcUZWeyWyPnZ+FRhAdEGK" +
           "sgk121W1IkADaTVDRBaUZHgEQk9JAmuNCgGoM7LSVylirQnipJCk4xiRHr5h" +
           "8xZw1XMgUISRNi8b1wSjtNIzSq7xObVz28HrlB1KkATA5jgVZbR/IQh1eIR2" +
           "0QTVKcwDU3DRxujdwrJn54KEAHObh9nk+dn1Zy7b1HH0RZPn7AI8Q7H9VGTj" +
           "4uFY02urIl0XV6EZdZpqSDj4OZ7zWTZs3enOaJBhlmU14s2QffPoruNX3vQT" +
           "+tcgaRggtaIqp1MQR4tFNaVJMtUvpwrVBUbjA6SeKvEIvz9AFsB1VFKo2TqU" +
           "SBiUDZBqmTfVqvw/QJQAFQhRA1xLSkK1rzWBTfDrjEYIWQpfch58nyHm52kk" +
           "jFwZnlBTNCyIgiIpanhYV9F/IwwZJwbYToRjEPWTYUNN6xCCYVVPhgWIgwlq" +
           "3RANIxxXU+HIyMjQ4Mjo5cMCBGwIQ0yrpPIMerZkOhAA0Fd5p7wMs2WHKsep" +
           "Pi7Op3v7zjw2/rIZTjgFLEwY6YX+QmZ/Id5fCPoLQX+hnP46e2IwhwUR07qU" +
           "kESeBXYIShxGjgQC3ISlaJM55jBikzD3Ifku6hq5+op9c+uqINi06WqAG1nX" +
           "5RShiJMg7Kw+Lh5pbZxd++7m54OkOkpaoee0IGNN6dGTkK3ESWtCL4pBeXKq" +
           "xBpXlcDypqsijUOS8qsWlpY6dYrq2M7IUpcGu4bhbA37V5CC9pOj907fPHrj" +
           "+UESzC0M2GUN5DQUH8Z0nk3bnd6EUEhv860nPz5y9wHVSQ05lcYukHmS6MM6" +
           "b5B44RkXN64Rnhx/9kAnh70eUjeD4ces2OHtIyfzdNtZHH2pA4cTqp4SZLxl" +
           "Y9zAJnR12mnh0bsYSZsZyBhCHgN5AfjKiHb/b1/9YAtH0q4Vza4iP0JZtys/" +
           "obJWnokWOxG5W6cU+N65d/jOu07dupeHI3CsL9RhJ9II5CUYHUDwGy9e+9Z7" +
           "7x4+EXRCmEGBTsdgnZPhviz9DD4B+P4Hv5hTsMHMLa0RK8GtyWY4DXve4NgG" +
           "uU6GlIDB0blHSfEZJsRkivPn0+ZzNj/5t4Mt5nDL0GJHy6bSCpz2s3rJTS9f" +
           "888OriYgYq118HPYzAS+xNHco+vCDNqRufn19u+9INwPpQDSryHNUp5RCceD" +
           "8AHcyrE4n9MLPfe+jOQcwx3judPItSYaF28/cbpx9PRzZ7i1uYsq97gPClq3" +
           "GUXmKEBnm4hF7AzPf/HuMg3p8gzYsNybqHYIxgQou/Dozqta5KOfQLdj0K0I" +
           "6dgY0iGDZnJCyeKuWfC7Y88v2/daFQn2kwZZFeL9Ap9wpB4inRoTkHwz2qWX" +
           "mXZM1wFp4XiQPITyGnAUVhce376UxviIzP58+RPbHjr0Lg9LzdRxtlvhBk67" +
           "kGzi7UG8/CIjdYKVzDNZ3LjYErsi2r8u3FzqA/x6BSOXfs7awWmBwoFj0e63" +
           "COILuMO3zB+KDz2w2VyqtOYuLPpg3fzob/79Suje918qUNlqrUWsYzhmmPac" +
           "yjPIF4dO9nun6Y4/PtWZ7C2n6GBbR4mygv9Xgwcb/YuI15QXbvnLyt2XTOwr" +
           "o36s9mDpVfnjwUdeunyDeEeQr4TN0pG3gs4V6najCp3qFJb8CrqJLY189q3P" +
           "RtFaDJou+B6zouiYd/aZib5wdDJSr+kqg0CncWzud8ITJw9ZWURxkdSzt8i9" +
           "q5HshhmRpGxUkNPUDu0vFAxtqiShGIamkDPk8F+EZI9p7bb/ccJjQ6/G24ez" +
           "bjfjvTB8j1tuHy8DzwCf7R4Mm4oo8+AUyJ3sLTwd4Y4pZO6YeN+TxYVWIIzT" +
           "W0SeFLYPDfZlRKphFHNhvkqHJVeTTuO7YUJEJkA7jcMs7SqyXdelFJT5KWvD" +
           "Ez7Q+t7kD04+amYI7+7Iw0zn5r/9WejgvJktzC3k+rxdnFvG3EZya1uQhDBn" +
           "rS3WC5fo//ORA08/fODWoBVnUUaqp1Qp7oRLolLh0gPfj6wR/qhIuCCZyA8O" +
           "P1HPOAfNKZu7lMdMOZKG2uKB/YLhfeJc5/CfzDE6q4CAydf2cPi7o2/uf4Wn" +
           "vDrMsdlE48qvkItdC0h7VPDHcF1PM1IDJVhneaEJq8xcC8zOt3+r+ZnbW6v6" +
           "IfUPkLq0Il2bpgPx3PS3wEjHXCY5u3wnGVr24PqPkcBGuzB/vYiZCVg75JmJ" +
           "f2/LcJVfKzzH8K/GGeaR3ABbF5hH/aiMpyZrNuG9KSfubqxU3G0Gk9aYOs3f" +
           "suLOV9Tfd5lr/WEpcH6E5D7IX0nYASiuNOMB5vuVAiZCMNuY3kXLB8ZPtPCE" +
           "xL/fRHKQq36kFDqPIXkItgMcnVLB83ClMDofjJq1HJ0tHyM/0VLB81QpeJ5G" +
           "8gTsOmKAiX/sPFkpXHrBmgct5x4sHxc/0c8VO8dLgfMikmOMtCE4pULnF5UM" +
           "nROWnyfKh8hPtFTovFEKnV8jeRVCR0/GYP+m6oVx+VUl085py7nT5ePiJ+of" +
           "OrIDzvulwPkDkrcZWW6DMxCJFAHp95UCaTvYXmPqNH/LAslX1ON+FTekKju/" +
           "XEidKoXUh0hOMjxF8YXng0rBcwH4tsrycVX58PiJlppb/yoFyqdI/sHIEg7K" +
           "sK7i4//C2HxcKWzWg2PbLQe3l4+Nn6jHdddmNbCgBCyBeiSwjW7ksBgRmQq6" +
           "F5BAVaUACYE3ccurePmA+In6O83LVGBpKVSWIWlmeNKEqAwosDPBg8w8ZFoq" +
           "hczF4Nac5d5c+cj4ifqn4oO8scieo0pSiuw4AmtLYXouklX2BBxQDKozGu+l" +
           "CVWnHlTbK4XqFnDWesobzHvKWxpVP9EiqKI767j/W0oBtBVJyJ6Ku6iGx3He" +
           "gAtXCpousNgq4MHya7+vqK/TFiqXlUKlF0m3Xcx20ZQ6lQfKtkqBci6U4DWm" +
           "TvO3LFB8RUvlp8FSoAwh2cHIQg5Kj6ZRxYvJQKUw2UjwUbDpWPl7U1/REgU+" +
           "MFakyl2FZA8jDWldKljSA6OVQuMicGW35dJI+WiM+Ih6nK3mhlTjX9dq0AEn" +
           "WQQcCUkMJpCGRyqF4RH/H/BkGDm7yJE/F1vByIbPdwJk6GRF3itJ5ms04mOH" +
           "muuWH9rzJj9yyb7qsihK6hJpWXY9fHM/iKvVdJqQ+JgsMk8AzblkWI+cC5kE" +
           "VQ8oWh7QTe4pRpYW4gZOoG7OGUZavJyM1PBfN9/1ELcOHyO15oWb5UbQDix4" +
           "eZNm4+h6uG6+e5MxH6HnnOfx9WxbqdHNirgPt/EpOn91zH7smTZfHhsXjxy6" +
           "Yud1Z770gHm4LsrC7CxqWRglC8wjfK4UT5fW+mqzddXu6Pqk6fH6c+yn3jmH" +
           "+27beIxBRuAH4Ss9p81GZ/bQ+a3D25775Vzt60ES2EsCAqw39rpe3DKR6s5o" +
           "aZ20743mP9QdFXR+DN7ddd/MJZsSH77Nj0qJ+RB4lT//uHjioavfuGPF4Y4g" +
           "WThAaiQlTjNjpEEyts8ou6g4pY+RRsnoy4CJoAVWkzlPjJswiAU8IuG4WHA2" +
           "ZlvxrQtG1uWfO+S/q9Igq9NU71XTZklojJKFTos5Mp4DujTUj1wBp8UaSqTf" +
           "QRLK4GhAPI5HBzXNfmWh9j2NJ4HbCi8QMXDv5Jd4Nf9fko+YMFYqAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "4cjPp4qfnzM9bfjS3eIFT637h4vV/j1a");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("rI6RHEK9fh7UfBtmr34UqKeK461vQYrdLdIfBsvIs7u2u9+3YEb3zkNK5aQV" +
           "Q28rkOK+r7ingRJ3C/QFKN/n2AG9R48Sp1ekPfYOEZzLySiGLiehceYatDe+" +
           "W4gNAG12CJG9NxAvFgwX89sTicYx4hfvgFjMiQD818+30s7G/BNvBnMaQ++6" +
           "wznwgv/xGPrA326HLwqhJ2/5n8ruvxXSb7x65YF3vsr9p+Lg9I3/Pzw4gB5Q" +
           "E9s+eUrxxPV9fqioRqHGB3dnFv1CD+bhfstZIoGAD2gu+Z6x4wZFj53FDTgB" +
           "Pcnpgwfw05wxdKn4PckHml4+5ouh+3YXJ1nWoHfAkl9u/CM9njiVuDvUme72" +
           "j5486YJF9vTIeVa80eTk+et807P4P9HRBmWy+0fRi9KXXqVHP/29+q/szn9L" +
           "tphleS8PDKD7d0fRi07zTc7nbtvbUV/3kc//4KEvP/j+o93Yh3YCH0+HE7K9" +
           "5+wD1h3Hj4sj0dm/eudv/sg/ffWPi2OZ/x+5zhTj6DUAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "tW75Wl2E99F8jHxUzP5QvGLz0X8Azz3dS/0aAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
